package it.balduzzi.appedicola.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.balduzzi.BusinessLogic.DividerItemDecoration;
import it.balduzzi.BusinessLogic.RecyclerTouchListener;
import it.balduzzi.BusinessLogic.SportAdapter;
import it.balduzzi.Model.Item;
import it.balduzzi.Model.OutputPublications;
import it.balduzzi.ServiceAccess.ListenerResponse;
import it.balduzzi.ServiceAccess.NetworkManager;
import it.balduzzi.appedicola.R;
import it.balduzzi.appedicola.dummy.DummyContent;
import it.balduzzi.appedicola.fragment.ItemDetailFragment;


/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity implements SportAdapter.Callback {

    @BindView(R.id.item_list)
    RecyclerView mRecyclerView;
    SportAdapter mSportAdapter;
    LinearLayoutManager mLayoutManager;
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
        
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
        mSportAdapter = new SportAdapter(new ArrayList<>(), this,mTwoPane);



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
                    mSportAdapter.addItems(publication[0].getData().getItems());
                    mRecyclerView.setAdapter(mSportAdapter);
                    mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
                        @Override
                        public void onClick(View view, int position) {
                            Item it = publication[0].getData().getItems().get(position);


                            Context context = view.getContext();
                            Intent intent = new Intent(context, ItemDetailActivity.class);
                            intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, it.getPublicationId());
                            intent.putExtra(ItemDetailFragment.LIST_ITEM, (Serializable) publication[0].getData().getItems());
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

    private void setupRecyclerView(@NonNull RecyclerView recyclerView, OutputPublications pub) {


       // recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, ITEMS, mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final ItemListActivity mParentActivity;
        private final List<DummyContent.DummyItem> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DummyContent.DummyItem item = (DummyContent.DummyItem) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, item.id);
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id);

                    context.startActivity(intent);
                }
            }
        };

        SimpleItemRecyclerViewAdapter(ItemListActivity parent,
                                      List<DummyContent.DummyItem> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).id);
            holder.mContentView.setText(mValues.get(position).content);

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }
}
