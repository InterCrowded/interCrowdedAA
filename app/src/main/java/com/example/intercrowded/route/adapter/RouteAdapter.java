package com.example.intercrowded.route.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intercrowded.JsonTemplate;
import com.example.intercrowded.R;
import com.example.intercrowded.api.model.RouteData;
import com.example.intercrowded.route.OpenDetailListener;

import java.util.List;

import butterknife.ButterKnife;


public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.ComicViewHolder> {


        private List<RouteData> mData;
        private ItemClickListener mClickListener;
        private Context context;
       // private StorageReference storageReference;
        private OpenDetailListener openDetailedPageListener;


        public RouteAdapter(Context context, List<RouteData> data) {
            this.mData = data;
            this.context = context;
        }

        @Override
        public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, null);
            return new ComicViewHolder(view);
        }


        @Override
        public void onBindViewHolder(final ComicViewHolder holder, int position) {
            final RouteData ad = mData.get(position);
            //TODO item template holders to be bindid here
//            holder.adName.setText(ad.getTitle());
//            holder.adShortDesc.setText(ad.getDescription());
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    openDetailedPage(ad);
//                }
//            });
//            holder.adShortDesc.setText(ad.getDescription());
//            holder.adName.setText(ad.getTitle());
//            holder.like.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    likeAd(holder.like, ad);
//                }
//            });


           /* GlideApp.with(holder.itemView.getContext())
                    .load(ad.getComicImage().getImagPathFul())
                    .into(holder.adPhoto);*/
        }

//        private void likeAd(ImageView like, ComicData ad) {
//
//            if (ad.isLiked()) {
//                GlideApp.with(like.getContext())
//                        .load(R.drawable.like)
//                        .into(like);
//            } else {
//                GlideApp.with(like.getContext())
//                        .load(R.drawable.liked)
//                        .into(like);
//            }
//            ad.setLiked(!ad.isLiked());
//        }

        private void openDetailedPage(JsonTemplate ad) {

            openDetailedPageListener.onOpen(ad);

        }

        public void setOpenDetailedPageListener(OpenDetailListener openDetailedPageListener) {
            this.openDetailedPageListener = openDetailedPageListener;
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        String getItem(int id) {
            return String.valueOf(mData.get(id));
        }

        // allows clicks events to be caught
        void setClickListener(ItemClickListener itemClickListener) {
            this.mClickListener = itemClickListener;
        }

        // parent activity will implement this method to respond to click events
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }

        public class ComicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            /*@BindView(R.id.seen_number)
            TextView seenNumber;
            @BindView(R.id.ad_photo)
            ImageView adPhoto;
            @BindView(R.id.ad_name)
            TextView adName;
            @BindView(R.id.ad_short_desc)
            TextView adShortDesc;
            @BindView(R.id.seen)
            ImageView seen;
            @BindView(R.id.like)
            ImageView like;
            @BindView(R.id.report)
            ImageView report;
            @BindView(R.id.card_view)
            CardView cardView;*/

            ComicViewHolder(View itemView) {
                super(itemView);
               // ButterKnife.bind(this, itemView);
                //itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
              //  if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
