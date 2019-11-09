package com.example.intercrowded.fragment;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intercrowded.DataRepository;
import com.example.intercrowded.JsonTemplate;
import com.example.intercrowded.R;
import com.example.intercrowded.api.model.RouteData;
import com.example.intercrowded.base.BaseApplication;
import com.example.intercrowded.route.OpenDetailListener;
import com.example.intercrowded.route.adapter.RouteAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.intercrowded.api.IDataProvider;
import com.example.intercrowded.api.RemoteDataProvider;
import com.example.intercrowded.api.response.RouteResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;


public class SearchFragment extends Fragment {

    @BindView(R.id.searchButton)
    Button searchButton;

    private OnFragmentInteractionListener mListener;
    private RouteAdapter recyclerViewAdapter;
    private ArrayList<RouteData> feedData;
    private FragmentTransaction ft;
    private String dataSetType;


    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FeedFragment.
     */
    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
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
        View view = inflater.inflate(R.layout.main_background_2, container, false);
        ButterKnife.bind(this, view);

        initPlaces();



        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Search",Toast.LENGTH_SHORT).show();
               //TODO pass arguments of search
                runSearchQuery();
            }
        });


        return view;
    }

    private void initPlaces() {
        Places.initialize(getContext(), "AIzaSyCK6YgyICsqDw1TNzMaV9scJNoUqghDbx4");

        // Create a new Places client instance
        PlacesClient placesClient = Places.createClient(getActivity().getBaseContext());

        // Initialize the AutocompleteSupportFragment.
        if (getFragmentManager() != null) {

            AutocompleteSupportFragment autocompleteFragmentFROM = (AutocompleteSupportFragment)
                    getChildFragmentManager().findFragmentById(R.id.autocomplete_fragmentFROM);

            AutocompleteSupportFragment autocompleteFragmentTO = (AutocompleteSupportFragment)
                    getChildFragmentManager().findFragmentById(R.id.autocomplete_fragmentTO);


            autocompleteFragmentFROM.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));
            autocompleteFragmentTO.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));


        autocompleteFragmentFROM.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });

        autocompleteFragmentTO.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Toast.makeText(getActivity().getBaseContext(),place.getName(),Toast.LENGTH_SHORT).show();
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });

        }
    }

    private void runSearchQuery() {
        if (getFragmentManager() != null) {

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.container, ResponseFragment.newInstance());
            ft.addToBackStack("list");
            ft.commit();
        }
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


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}