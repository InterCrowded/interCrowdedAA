package com.example.intercrowded;

import com.example.intercrowded.api.model.RouteData;
import com.example.intercrowded.route.adapter.RouteAdapter;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {
        private static final DataRepository ourInstance = new DataRepository();
        private ArrayList<RouteData> dataSet = new ArrayList<>();
        private Object image;

        public static DataRepository getInstance() {
            return ourInstance;
        }

        private DataRepository() {}

        public void setFeedData(List<RouteData> results) {
            this.dataSet.addAll(results);
        }

        public ArrayList<RouteData> getDataSet() {
            dataSet.add(new RouteData("a"));
            dataSet.add(new RouteData("b"));
            dataSet.add(new RouteData("c"));
            dataSet.add(new RouteData("d"));
            return dataSet;
        }

}
