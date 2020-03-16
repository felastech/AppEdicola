package it.balduzzi.businesslogic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import it.balduzzi.appedicola.activity.IssueActivity;
import it.balduzzi.model.issue.ItemIssue;
import it.balduzzi.appedicola.R;

public class IssueAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = "IssueAdapter";
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    private Callback mCallback;
    private final IssueActivity mParentActivity;
    private List<ItemIssue> mIssueList;


    public IssueAdapter(List<ItemIssue> issueList, IssueActivity parent) {
        mIssueList = issueList;
        mParentActivity = parent;
    }
    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_issue, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.item_empty_view, parent, false));
        }
    }
    @Override
    public int getItemViewType(int position) {
        if (mIssueList != null && mIssueList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }
    @Override
    public int getItemCount() {
        if (mIssueList != null && mIssueList.size() > 0) {
            return mIssueList.size();
        } else {
            return 1;
        }
    }
    public void addItems(List<ItemIssue> sportList) {
        mIssueList.addAll(sportList);
        notifyDataSetChanged();
    }
    public interface Callback {
        void onEmptyViewRetryClick();
    }
    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.thumbnail)
        ImageView coverImageView;
        @BindView(R.id.title)
        TextView titleTextView;
        @BindView(R.id.btnAction)
        Button btnAction;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        protected void clear() {
            coverImageView.setImageDrawable(null);
            titleTextView.setText("");

        }
        public void onBind(int position) {
            super.onBind(position);
            final ItemIssue mIssue = mIssueList.get(position);
           if (mIssue.getVariants() != null) {

               String url = mIssue.getVariants().get(0).getMediumImagesUrl();
               url = url.replace("{0:000}","001");
               Glide.with(itemView.getContext())
                       .load(url)
                       .into(coverImageView);
            }
            if (mIssue.getIssueName() != null) {
                titleTextView.setText(mIssue.getIssueName());
            }
            if(mIssue.isForSale()){
                btnAction.setText("Acquista");
            }
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