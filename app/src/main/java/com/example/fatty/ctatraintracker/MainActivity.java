package com.example.fatty.ctatraintracker;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {

    ArrayList<String> myList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pick a line: ");
        myList = new ArrayList<>();
        myList.add("Red Line");//0
        myList.add("Blue Line");//1
        myList.add("Brown Line");//2
        myList.add("Green Line");//3
        myList.add("Orange Line");//4
        myList.add("Pink Line");//5
        myList.add("Purple Line");//6
        myList.add("Yellow Line");//8

        //returns a view for each object in a collection of data objects you provide,
        // and can be used with a list-based user interface widgets such as ListView or Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);

        //Bind to new Adapter
        setListAdapter(adapter);

        getListView().setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu, this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle action bar item clicks here
        //The action bar will automatically handle clicks on the Home/Up button,
        //so long as you specify a parent activity in AndroidManifest.xml
        int id = item.getItemId();
        if(id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //send to - to launch an activity in the code below it is sending the onClickItem to the StopsActivity.class
        Intent intent = new Intent(this, StopsActivity.class);

        //pass the index to intent
        intent.putExtra("index", i);
        startActivity(intent);
    }
}
