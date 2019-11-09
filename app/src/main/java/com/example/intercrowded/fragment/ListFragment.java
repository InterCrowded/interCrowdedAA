package com.example.intercrowded.fragment;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intercrowded.DataRepository;
import com.example.intercrowded.JsonTemplate;
import com.example.intercrowded.R;
import com.example.intercrowded.api.model.RouteData;
import com.example.intercrowded.route.OpenDetailListener;
import com.example.intercrowded.route.adapter.RouteAdapter;

import java.util.ArrayList;

import com.example.intercrowded.api.IDataProvider;
import com.example.intercrowded.api.RemoteDataProvider;
import com.example.intercrowded.api.response.RouteResponse;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;


public class ListFragment extends Fragment {

    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private OnFragmentInteractionListener mListener;
    private RouteAdapter recyclerViewAdapter;
    private ArrayList<RouteData> feedData;
    private FragmentTransaction ft;
    private String dataSetType;


    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FeedFragment.
     */
    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        //args.putString(OWN, own);
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
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        ButterKnife.bind(this, view);

        userName.setText("John Doe");

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        feedData = new ArrayList<>();

        RemoteDataProvider.instance().getRoutes("100", new IDataProvider.DataListener<RouteResponse>() {
            @Override
            public void onSuccess(RouteResponse routeResponse) {

                feedData.addAll(routeResponse.getData().getResults());
                DataRepository.getInstance().setFeedData(feedData);
                setupAdapter();
            }

            @Override
            public void onError(String errorMessage) {
                Log.d(TAG, "onError() called with: errorMessage = [" + errorMessage + "]");
            }
        });

//        progressBar.setVisibility(View.VISIBLE);


        return view;
    }



    private void setupAdapter() {

        recyclerViewAdapter = new RouteAdapter(getContext(), DataRepository.getInstance().getDataSet());
        recyclerViewAdapter.setOpenDetailedPageListener(new OpenDetailListener() {
            @Override
            public void onOpen(JsonTemplate comicData) {
                if (getFragmentManager() != null ) {
                    ft = getFragmentManager().beginTransaction();
                   // ft.replace(R.id.container, DetailedRouteFragment.newInstance(comicData.getId(), comicData.getComicImage().getImagPathFul(), comicData));
                    ft.addToBackStack("a");
                    ft.commit();
                }
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);

      //  progressBar.setVisibility(View.INVISIBLE);
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}