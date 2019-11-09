package com.example.intercrowded.route.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.intercrowded.R;
import com.example.intercrowded.api.model.RouteData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ListViewElementAdapter extends RecyclerView.Adapter<ListViewElementAdapter.ListViewElementViewHolder> {


        private List<RouteData> mData;
        private Context context;
       // private StorageReference storageReference;


        public ListViewElementAdapter(Context context, List<RouteData> data) {
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
            final RouteData ad = mData.get(position);
            holder
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
