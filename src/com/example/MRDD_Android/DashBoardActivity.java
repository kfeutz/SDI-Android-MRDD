package com.example.MRDD_Android;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Allen on 2/1/2015.
 */
public class DashBoardActivity extends Activity{

    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        String[] details = new String[] {"Temp: 25 C", "Time : 0:25", "Depth: 500 ft"};
        ArrayList<String> detailList = new ArrayList<String>();
        detailList.addAll(Arrays.asList(details));

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, detailList);


        setListAdapter(listAdapter);

    }
}
