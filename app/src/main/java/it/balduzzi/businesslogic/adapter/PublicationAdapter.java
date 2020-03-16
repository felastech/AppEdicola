package it.balduzzi.businesslogic.adapter;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.balduzzi.appedicola.R;
import it.balduzzi.appedicola.activity.PublicationActivity;
import it.balduzzi.model.publication.Item;

public class PublicationAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = "PublicationAdapter";
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    private Callback mCallback;
    private final PublicationActivity mParentActivity;
    private List<Item> mPublicationList;


    public PublicationAdapter(List<Item> publicationList, PublicationActivity parent) {
        mPublicationList = publicationList;
        mParentActivity = parent;
    }
    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
        //  holder.itemView.setOnClickListener(mOnClickListener);
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.item_empty_view, parent, false));
        }
    }
    @Override
    public int getItemViewType(int position) {
        if (mPublicationList != null && mPublicationList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }
    @Override
    public int getItemCount() {
        if (mPublicationList != null && mPublicationList.size() > 0) {
            return mPublicationList.size();
        } else {
            return 1;
        }
    }
    public void addItems(List<Item> sportList) {
        mPublicationList.addAll(sportList);
        notifyDataSetChanged();
    }
    public interface Callback {
        void onEmptyViewRetryClick();
    }
    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.title)
        TextView titleTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        protected void clear() {
            titleTextView.setText("");
        }
        public void onBind(int position) {
            super.onBind(position);
            final Item mPublication = mPublicationList.get(position);

            if (mPublication.getPublicationName() != null) {
                titleTextView.setText(mPublication.getPublicationName());
            }

            itemView.setOnClickListener(v -> {
                if (mPublication.getProjectId() != null) {
                    try {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse(mPublication.getProjectId()));
                        itemView.getContext().startActivity(intent);
                    } catch (Exception e) {
                        Log.e(TAG, "onClick: Image url is not correct");
                    }
                }
            });
        }
    }
    public class EmptyViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_message)
        TextView messageTextView;
        @BindView(R.id.buttonRetry)
        TextView buttonRetry;
        EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            buttonRetry.setOnClickListener(v -> mCallback.onEmptyViewRetryClick());
        }
        @Override
        protected void clear() {
        }
    }
}