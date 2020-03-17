package it.balduzzi.businesslogic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import it.balduzzi.appedicola.R;
import it.balduzzi.model.publication.Item;

public class PublicationAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    private List<Item> mPublicationList;


    public PublicationAdapter(List<Item> publicationList) {
        mPublicationList = publicationList;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
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
    public void addItems(List<Item> publicationList) {
        mPublicationList.addAll(publicationList);
        notifyDataSetChanged();
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
        }
    }
}