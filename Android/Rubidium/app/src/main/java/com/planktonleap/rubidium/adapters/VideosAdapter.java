package com.planktonleap.rubidium.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.planktonleap.rubidium.R;
import com.planktonleap.rubidium.models.VideoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pongtep Pakakat on 2/9/2017.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.ViewHolder> implements Filterable {

    private List<VideoModel> original_items = new ArrayList<>();
    private List<VideoModel> filtered_items = new ArrayList<>();
    private ItemFilter mFilter = new ItemFilter();

    private final Context ctx;

    private OnItemClickListener mOnItemClickListener;
    public interface OnItemClickListener {
        void onItemClick(View view, VideoModel obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public VideosAdapter(Context context, List<VideoModel> items) {
        original_items = items;
        filtered_items = items;
        ctx = context;
    }

    public void swapItems(List<VideoModel> items) {
        original_items = items;
        filtered_items = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvVideoTitle;
        public ImageView imvPlaceHolder;
        public LinearLayout lyt_parent;

        public ViewHolder(View v) {
            super(v);


            tvVideoTitle = (TextView) v.findViewById(R.id.tvVideoTitle);
            tvVideoTitle = (TextView) v.findViewById(R.id.tvVideoTitle);
            lyt_parent = (LinearLayout) v.findViewById(R.id.lyt_parent);
        }
    }

    public Filter getFilter() {
        return mFilter;
    }

    @Override
    public VideosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_video, parent, false);

        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final VideoModel video = filtered_items.get(position);

                holder.tvVideoTitle.setText(video.getVideoTitle());
                //holder.imvPlaceHolder.setImageBitmap();



		/*
		* Make click listener.
		*/
        holder.lyt_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, video, position);
                }
            }
        });
    }


    public VideoModel getItem(int position) {
        return filtered_items.get(position);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return filtered_items.size();
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String query = constraint.toString().toLowerCase();

            List<VideoModel> filteredResults = new ArrayList<>();


            FilterResults results = new FilterResults();
            results.values = filteredResults;

            return results;

        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filtered_items = (List<VideoModel>) results.values;
            notifyDataSetChanged();
        }
    }
}
