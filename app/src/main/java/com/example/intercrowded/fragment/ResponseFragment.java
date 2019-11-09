package com.example.intercrowded.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.azoft.carousellayoutmanager.DefaultChildSelectionListener;
import com.example.intercrowded.R;
import com.example.intercrowded.api.model.InterPath;
import com.example.intercrowded.api.model.RouteData;
import com.example.intercrowded.route.adapter.ListViewElementAdapter;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResponseFragment extends Fragment {
    private static ArrayList<RouteData> responseDataFromQuery;
    private SearchFragment.OnFragmentInteractionListener mListener;
    private ListViewElementAdapter recyclerViewAdapter;
    private ArrayList<RouteData> feedData;
    private FragmentTransaction ft;
    private String dataSetType;


    @BindView(R.id.list_horizontal)
    RecyclerView listHorizontal;

    public ResponseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FeedFragment.
     * @param responseData
     */
    public static ResponseFragment newInstance(ArrayList<RouteData> responseData) {
        ResponseFragment fragment = new ResponseFragment();
        Bundle args = new Bundle();
        responseDataFromQuery = responseData;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_response, container, false);
        ButterKnife.bind(this, view);


        if (listHorizontal != null) {

        initRecyclerView(listHorizontal, new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true), new TestAdapter(responseDataFromQuery));
        }else {
            Toast.makeText(getContext(),"list null", Toast.LENGTH_SHORT).show();
        }

        return view;

    }




    private void initRecyclerView(final RecyclerView recyclerView, final CarouselLayoutManager layoutManager, final TestAdapter adapter) {
        // enable zoom effect. this line can be customized
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        layoutManager.setMaxVisibleItems(1);

        recyclerView.setLayoutManager(layoutManager);
        // we expect only fixed sized item for now
        recyclerView.setHasFixedSize(true);
        // sample adapter with random data
        recyclerView.setAdapter(adapter);
        // enable center post scrolling
        recyclerView.addOnScrollListener(new CenterScrollListener());
        // enable center post touching on item and item click listener
        DefaultChildSelectionListener.initCenterItemListener(new DefaultChildSelectionListener.OnCenterItemClickListener() {
            @Override
            public void onCenterItemClicked(@NonNull final RecyclerView recyclerView, @NonNull final CarouselLayoutManager carouselLayoutManager, @NonNull final View v) {
                final int position = recyclerView.getChildLayoutPosition(v);
                final String msg = String.format(Locale.US, "Item %1$d was clicked", position);
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
            }
        }, recyclerView, layoutManager);

        layoutManager.addOnItemSelectionListener(new CarouselLayoutManager.OnCenterItemSelectionListener() {

            @Override
            public void onCenterItemChanged(final int adapterPosition) {
                if (CarouselLayoutManager.INVALID_POSITION != adapterPosition) {
                    final int value = adapter.mPosition[adapterPosition];
/*
                    adapter.mPosition[adapterPosition] = (value % 10) + (value / 10 + 1) * 10;
                    adapter.notifyItemChanged(adapterPosition);
*/
                }
            }
        });
    }


    public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

        @SuppressWarnings("UnsecureRandomNumberGeneration")
        private final Random mRandom = new Random();
        private final int[] mColors;
        private final int[] mPosition;
        private  ArrayList<RouteData> items = new ArrayList<>();
        private int mItemsCount = 10;

        TestAdapter(ArrayList<RouteData> responseDataFromQuery) {
            mItemsCount = responseDataFromQuery.size();
            mColors = new int[mItemsCount];
            mPosition = new int[mItemsCount];
            for (int i = 0; mItemsCount > i; ++i) {
                //noinspection MagicNumber
                //TODO FILL ADAPTER
                items = responseDataFromQuery;
               // mColors[i] = Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
                mPosition[i] = i;
            }
        }

        @Override
        public TestAdapter.TestViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, null);
            return new TestAdapter.TestViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final TestViewHolder holder, final int position) {

        //    Toast.makeText(getContext(),items.get(position).getPaths().size(),Toast.LENGTH_SHORT).show();
            holder.optionLabel.setText(
                    String.valueOf(items.get(position).getPaths().get(1).getStartpoint().getName().concat(" - ").concat(items.get(position).getPaths().get(1).getEndpoint().getName())));
            initRegularRecyclerView(holder.optionListView, items.get(position).getPaths()); //option list element
            //holder.mItemViewBinding.cItem2.setText(String.valueOf(mPosition[position]));
           // holder.itemView.setBackgroundColor(mColors[position]);
        }

        @Override
        public int getItemCount() {
            return mItemsCount;
        }

        @Override
        public long getItemId(final int position) {
            return position;
        }


        public class TestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            @BindView(R.id.optionLabel)
            TextView optionLabel;
            @BindView(R.id.c_item_2)
            TextView c_item_2;
            @BindView(R.id.optionListView)
            RecyclerView optionListView;


            TestViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {

            }
        }
    }

    private void initRegularRecyclerView(RecyclerView optionListView, ArrayList<InterPath> paths) {

        optionListView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        optionListView.setHasFixedSize(true);

        optionListView.setAdapter(new ListViewElementAdapter(getContext(), paths));

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SearchFragment.OnFragmentInteractionListener) {
            mListener = (SearchFragment.OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
