package com.example.intercrowded.route.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.intercrowded.R;
import com.example.intercrowded.api.model.InterPath;
import com.example.intercrowded.api.model.RouteData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ListViewElementAdapter extends RecyclerView.Adapter<ListViewElementAdapter.ListViewElementViewHolder> {


        private ArrayList<InterPath> mData;
        private Context context;


        public ListViewElementAdapter(Context context, ArrayList<InterPath> data) {
            this.mData = data;
            this.context = context;
        }

        @Override
        public ListViewElementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_element, parent,false);
            return new ListViewElementViewHolder(view);
        }


        @Override
        public void onBindViewHolder(final ListViewElementViewHolder holder, int position) {
            final InterPath ad = mData.get(position);
            holder.transportationMeanTitlePreview.setText(ad.getVehicle_type());
        }


        @Override
        public int getItemCount() {
            return mData.size();
        }



        public class ListViewElementViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            @BindView(R.id.transportationMeanTitlePreview)
            TextView transportationMeanTitlePreview;


            ListViewElementViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

            @Override
            public void onClick(View view) {
              //  if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
