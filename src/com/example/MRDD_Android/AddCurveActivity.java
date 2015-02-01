package com.example.MRDD_Android;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kevin on 1/31/2015.
 */
public class AddCurveActivity extends Activity {
    private ArrayAdapter<String> listAdapter;

    // Logcat tag
    private static final String TAG = "AddCurveView";
    private ListView curveListView;

    String[] curves = new String[] {"Curve 1", "Curve 2", "Curve 3", "Curve 4",
            "Curve 5", "Curve 6", "Curve 7", "Curve 8", "Curve 9", "Curve 10",
            "Curve 11", "Curve 12", "Curve 13", "Curve 14", "Curve 15", "Curve 16"};
    ArrayList<String> curveList = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_curve);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        curveListView = (ListView) findViewById(R.id.add_curve_view);
        curveList.addAll(Arrays.asList(curves));

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, curveList);
        curveListView.setAdapter(listAdapter);
        curveListView.setTextFilterEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_well_actions, menu);


        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.add_well_search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true); // Collapseable widget

        SearchView.OnQueryTextListener textChangeListener = new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextChange(String newText)
            {
                // this is your adapter that will be filtered
                listAdapter.getFilter().filter(newText);
                System.out.println("on text chnge text: "+newText);
                return true;
            }
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                // this is your adapter that will be filtered
                listAdapter.getFilter().filter(query);
                System.out.println("on query submit: "+query);
                return true;
            }
        };
        searchView.setOnQueryTextListener(textChangeListener);

        return super.onCreateOptionsMenu(menu);
    }
}
