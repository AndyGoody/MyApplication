package com.startiasoft.googlemap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

/**
 * Created by PC_016 on 2015/9/16.
 */
public class SecondActivity extends Activity {

    private Spinner spinner;

    private ArrayAdapter<String> adapter;
    private ArrayList<String> list;

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);
        spinner = (Spinner) findViewById(R.id.spinner);
        list = new ArrayList<>();
        list.add("JAVA");
        list.add("Android");
        list.add("C++");
        list.add("iOS");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spinner.setAdapter(adapter);
        Log.i("lipan", "sd");

    }
//D4:FB:84:3B:9E:CF:19:BB:8A:27:A1:9A:48:C8:B3:1A:65:79:33:4E
//D4:FB:84:3B:9E:CF:19:BB:8A:27:A1:9A:48:C8:B3:1A:65:79:33:4E


    public void onClick(View v) {
        Log.i("lipan", "sd" + v.getId());
        switch (v.getId()) {
            case R.id.button:
                String s = spinner.getSelectedItem().toString();

                Log.i("lipan", s);
                break;

        }


    }
}
