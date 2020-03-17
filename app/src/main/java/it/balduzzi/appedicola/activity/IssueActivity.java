package it.balduzzi.appedicola.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.balduzzi.appedicola.R;
import it.balduzzi.businesslogic.adapter.IssueAdapter;
import it.balduzzi.model.issue.Issue;
import it.balduzzi.model.publication.Item;
import it.balduzzi.serviceaccess.ListenerResponse;
import it.balduzzi.serviceaccess.NetworkManager;


public class IssueActivity extends AppCompatActivity {

    private Item mItem;
    private Issue mIssue;
    @BindView(R.id.item_list)
    RecyclerView mRecyclerView;
    private IssueAdapter mIssueAdapter;
    private static final String TAG = "IssueActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        List<Item> itemList = (List<Item>) getIntent().getSerializableExtra(getResources().getString(R.string.extraListElements));
        String result = getIntent().getStringExtra(getResources().getString(R.string.extraItemId));
        for(Item i : itemList)
        {
            if(i.getPublicationId().equals(result))
            {
                mItem = i;
            }
        }

        ButterKnife.bind(this);
        setUp();
        setIssue();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        RequestQueue requestQueue = NetworkManager.getInstance(this).getRequestQueue();
        if( requestQueue != null)
        {
            requestQueue.cancelAll(TAG);
        }

        Log.d(TAG + ": ", "OnStop ");
    }


    private void setUp() {

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mIssueAdapter = new IssueAdapter(new ArrayList<>());
    }

    private void setIssue() {

        Log.d(TAG + ": ", "Get issue ");

        NetworkManager.getInstance(this).requestGet(getResources().getString(R.string.apiIssue), mItem.getPublicationId(),new ListenerResponse()
        {
            @Override
            public void getResult(String result)
            {
                if (!result.isEmpty())
                {
                    Gson gson = new Gson();
                    mIssue = gson.fromJson(result, Issue.class);
                    mIssueAdapter.addItems(mIssue.getData().getItems());
                    mRecyclerView.setAdapter(mIssueAdapter);
                }
            }

            @Override
            public void getResult(Boolean result)
            {
                Log.d(TAG + ": ", "Error Response: " + result);
            }
        });
    }
}
