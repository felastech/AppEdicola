package it.balduzzi.appedicola.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.balduzzi.appedicola.R;
import it.balduzzi.businesslogic.adapter.DividerItemDecoration;
import it.balduzzi.businesslogic.adapter.PublicationAdapter;
import it.balduzzi.businesslogic.adapter.RecyclerTouchListener;
import it.balduzzi.model.publication.Item;
import it.balduzzi.model.publication.OutputPublications;
import it.balduzzi.serviceaccess.ListenerResponse;
import it.balduzzi.serviceaccess.NetworkManager;


public class PublicationActivity extends AppCompatActivity implements PublicationAdapter.Callback {

    @BindView(R.id.item_list)
    RecyclerView mRecyclerView;
    PublicationAdapter mPublicationAdapter;
    LinearLayoutManager mLayoutManager;
    private  String ARG_ITEM_ID = "ARG_ITEM_ID";
    private String LIST_ITEM = "LIST_ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        ButterKnife.bind(this);
        setUp();
    }

    private void setUp() {

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_drawable);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        mPublicationAdapter = new PublicationAdapter(new ArrayList<>(), this);

        prepareDemoContent();
    }

    private void prepareDemoContent() {

         getPublications();
    }

    @Override
    public void onEmptyViewRetryClick() {
        prepareDemoContent();
    }

    private OutputPublications getPublications() {

        final OutputPublications[] publication = new OutputPublications[1];

        NetworkManager.getInstance(this).requestGet("publications", new ListenerResponse()
        {
            @Override
            public void getResult(String result)
            {
                if (!result.isEmpty())
                {
                    Gson gson = new Gson();
                    publication[0] = gson.fromJson(result, OutputPublications.class);
                    mPublicationAdapter.addItems(publication[0].getData().getItems());
                    mRecyclerView.setAdapter(mPublicationAdapter);
                    mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
                        @Override
                        public void onClick(View view, int position) {
                            Item it = publication[0].getData().getItems().get(position);


                            Context context = view.getContext();
                            Intent intent = new Intent(context, IssueActivity.class);
                            intent.putExtra(ARG_ITEM_ID, it.getPublicationId());
                            intent.putExtra(LIST_ITEM, (Serializable) publication[0].getData().getItems());
                            context.startActivity(intent);
                        }

                        @Override
                        public void onLongClick(View view, int position) {

                        }
                    }));

                }
            }

            @Override
            public void getResult(Boolean result)
            {
              //Errore
            }
        });

        return publication[0];
    }
}
