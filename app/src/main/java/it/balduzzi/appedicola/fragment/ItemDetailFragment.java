package it.balduzzi.appedicola.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.gson.Gson;

import java.util.List;

import it.balduzzi.Model.Item;
import it.balduzzi.ServiceAccess.ListenerResponse;
import it.balduzzi.ServiceAccess.NetworkManager;
import it.balduzzi.appedicola.R;
import it.balduzzi.appedicola.activity.ItemDetailActivity;
import it.balduzzi.appedicola.activity.ItemListActivity;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    public static final String LIST_ITEM = "list";

    /**
     * The dummy content this fragment is presenting.
     */
    private Item mItem;
    private List<Item> itemList;
    private Issue test;



    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            itemList = (List<Item>) getArguments().getSerializable(LIST_ITEM);
            String result = getArguments().getString(ARG_ITEM_ID);
            for(Item i : itemList)
            {
                if(i.getPublicationId().equals(result))
                {
                   mItem = i;
                }
            }

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getPublicationName());
            }

            setIssue();
        }
    }

    private void setIssue() {

        NetworkManager.getInstance(this.getContext()).requestGet("issues", "pub_5df8a84cdeb4d",new ListenerResponse()
        {
            @Override
            public void getResult(String result)
            {
                if (!result.isEmpty())
                {
                    Gson gson = new Gson();
                    test = gson.fromJson(result, Issue.class);

          


                }
            }

            @Override
            public void getResult(Boolean result)
            {
                //Errore
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.getPublicationName());
        }

        return rootView;
    }
}
