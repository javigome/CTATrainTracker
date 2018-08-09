package com.example.fatty.ctatraintracker;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                //get the current item from ListView
                View view = super.getView(position, convertView, parent);
                // 0 = red = #f70000
                if (position == 0) {
                    //Set background color for ListView regular row/item
                    view.setBackgroundColor(Color.parseColor("#f70000"));
                }
                // 1 = blue - #0834e0
                else if (position == 1){
                    //Set Color
                    view.setBackgroundColor(Color.parseColor("#0734e0"));
                }
                //2 = brown - #a6692b
                else if (position == 2){
                    //Set Color
                    view.setBackgroundColor(Color.parseColor("#a6692b"));
                }
                //3 = green - #009900
                else if (position == 3){
                    //Set Color
                    view.setBackgroundColor(Color.parseColor("#009900"));
                }
                //4 = orange - #ffa500
                else if (position == 4){
                    //Set Color
                    view.setBackgroundColor(Color.parseColor("#ffa500"));
                }
                //5 = pink - #ffc0cb
                else if (position == 5){
                    //Set Color
                    view.setBackgroundColor(Color.parseColor("#ffc0cb"));
                }
                //6 = purple - #800080
                else if (position == 6){
                    //Set Color
                    view.setBackgroundColor(Color.parseColor("#800080"));
                }
                //7 = yellow - #ffff00
                else if (position == 7){
                    //Set Color
                    view.setBackgroundColor(Color.parseColor("#ffff00"));
                }

                return view;
            }
        };

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
