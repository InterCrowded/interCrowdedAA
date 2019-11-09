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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.option_list_element, null);
            return new ListViewElementViewHolder(view);
        }


        @Override
        public void onBindViewHolder(final ListViewElementViewHolder holder, int position) {
            final InterPath ad = mData.get(position);
            holder.transportationmeanTitle.setText(ad.getVehicle_type());
            holder.ElementTimeLabel.setText(ad.getTimespan().toString());
        }


        @Override
        public int getItemCount() {
            return mData.size();
        }



        public class ListViewElementViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            @BindView(R.id.transportationmeanTitle)
            TextView transportationmeanTitle;
            @BindView(R.id.ElementTimeLabel)
            TextView ElementTimeLabel;


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
