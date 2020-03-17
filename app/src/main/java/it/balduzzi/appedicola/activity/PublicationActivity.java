package it.balduzzi.appedicola.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.balduzzi.appedicola.R;
import it.balduzzi.businesslogic.adapter.PublicationAdapter;
import it.balduzzi.businesslogic.adapter.RecyclerTouchListener;
import it.balduzzi.model.publication.Item;
import it.balduzzi.model.publication.OutputPublications;
import it.balduzzi.serviceaccess.ListenerResponse;
import it.balduzzi.serviceaccess.NetworkManager;


public class PublicationActivity extends AppCompatActivity {

    @BindView(R.id.item_list)
    RecyclerView mRecyclerView;
    private PublicationAdapter mPublicationAdapter;
    private OutputPublications[] publication = null;
    private static final String TAG = "PublicationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        ButterKnife.bind(this);
        setUp();
        getPublications();
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
        mPublicationAdapter = new PublicationAdapter(new ArrayList<>());

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Log.d(TAG + ": ", "Click item ");

                Item it = publication[0].getData().getItems().get(position);
                Context context = view.getContext();
                Intent intent = new Intent(context, IssueActivity.class);
                intent.putExtra(getResources().getString(R.string.extraItemId), it.getPublicationId());
                intent.putExtra(getResources().getString(R.string.extraListElements), (Serializable) publication[0].getData().getItems());
                context.startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void getPublications() {

        Log.d(TAG + ": ", "Get publications ");

        NetworkManager.getInstance(this).requestGet(getResources().getString(R.string.apiPublication),null, new ListenerResponse()
        {
            @Override
            public void getResult(String result)
            {
                if (!result.isEmpty())
                {
                    publication = new OutputPublications[1];
                    Gson gson = new Gson();
                    publication[0] = gson.fromJson(result, OutputPublications.class);
                    mPublicationAdapter.addItems(publication[0].getData().getItems());
                    mRecyclerView.setAdapter(mPublicationAdapter);
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
