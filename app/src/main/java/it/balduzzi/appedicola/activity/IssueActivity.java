package it.balduzzi.appedicola.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.balduzzi.appedicola.R;
import it.balduzzi.businesslogic.adapter.DividerItemDecoration;
import it.balduzzi.businesslogic.adapter.IssueAdapter;
import it.balduzzi.model.issue.Issue;
import it.balduzzi.model.publication.Item;
import it.balduzzi.serviceaccess.ListenerResponse;
import it.balduzzi.serviceaccess.NetworkManager;


public class IssueActivity extends AppCompatActivity {

    private List<Item> itemList;
    private Item mItem;
    private Issue test;
    @BindView(R.id.item_list)
    RecyclerView mRecyclerView;
    IssueAdapter mSportAdapter;
    LinearLayoutManager mLayoutManager;
    private  String ARG_ITEM_ID = "ARG_ITEM_ID";
    private String LIST_ITEM = "LIST_ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        itemList = (List<Item>)  getIntent().getSerializableExtra(LIST_ITEM);
        String result = getIntent().getStringExtra(ARG_ITEM_ID);
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

        NetworkManager.getInstance(this).requestGet("issues", mItem.getPublicationId(),new ListenerResponse()
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
            NavUtils.navigateUpTo(this, new Intent(this, PublicationActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
