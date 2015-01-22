package com.example.MRDD_Android;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kevin on 1/21/2015.
 */
public class WellListActivity extends ListActivity {
    private ArrayAdapter<String> listAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] wells = new String[] {"Well 1", "Well 2", "Well 3", "Well 4",
                "Well 5", "Well 6", "Well 7", "Well 8", "Well 9", "Well 10",
                "Well 11", "Well 12", "Well 13", "Well 14", "Well 15", "Well 16"};
        ArrayList<String> wellList = new ArrayList<String>();
        wellList.addAll(Arrays.asList(wells));

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, wellList);


        setListAdapter(listAdapter);
    }
}
