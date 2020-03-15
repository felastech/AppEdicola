package it.balduzzi.appedicola.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.balduzzi.BusinessLogic.DividerItemDecoration;
import it.balduzzi.BusinessLogic.IssueAdapter;
import it.balduzzi.Model.Item;
import it.balduzzi.ServiceAccess.ListenerResponse;
import it.balduzzi.ServiceAccess.NetworkManager;
import it.balduzzi.appedicola.R;
import it.balduzzi.appedicola.fragment.Issue;
import it.balduzzi.appedicola.fragment.ItemDetailFragment;


/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ItemListActivity}.
 */
public class ItemDetailActivity extends AppCompatActivity {

    private List<Item> itemList;
    private Item mItem;
    private Issue test;
    @BindView(R.id.item_list)
    RecyclerView mRecyclerView;
    IssueAdapter mSportAdapter;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        itemList = (List<Item>)  getIntent().getSerializableExtra(ItemDetailFragment.LIST_ITEM);
        String result = getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID);
        for(Item i : itemList)
        {
            if(i.getPublicationId().equals(result))
            {
                mItem = i;
            }
        }

        ButterKnife.bind(this);

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_drawable);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        mSportAdapter = new IssueAdapter(new ArrayList<>(), this);

        setIssue();
    }

    private void setIssue() {

        NetworkManager.getInstance(this).requestGet("issues", "pub_5df8a84cdeb4d",new ListenerResponse()
        {
            @Override
            public void getResult(String result)
            {
                if (!result.isEmpty())
                {
                    Gson gson = new Gson();
                    test = gson.fromJson(result, Issue.class);
                    mSportAdapter.addItems(test.getData().getItems());
                    mRecyclerView.setAdapter(mSportAdapter);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, ItemListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
