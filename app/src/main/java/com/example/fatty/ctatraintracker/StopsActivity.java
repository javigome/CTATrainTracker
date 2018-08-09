package com.example.fatty.ctatraintracker;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class StopsActivity extends ListActivity implements AdapterView.OnItemClickListener {

    ArrayList<String> list;
    ArrayList<Integer> list2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stops);
        setTitle("Pick your Stop:");
        Intent intent = getIntent();
        int index = intent.getIntExtra("index", 0);

        //populate list depending on the line chosen

        //redline
        if (index == 0) {
            list = new ArrayList<>();
            list2 = new ArrayList<>();

            list.add(0, "47th-Dan Ryan");
            list.add(1, "63rd-Dan Ryan");
            list.add(2, "69th");
            list.add(3, "79th");
            list.add(4, "87th");
            list.add(5, "95th/Dan Ryan");
            list.add(6, "Addison");
            list.add(7, "Argyle");
            list.add(8, "Belmont");
            list.add(9, "Berwyn");
            list.add(10, "Bryn Mawr");
            list.add(11, "Cermak-Chinatown");
            list.add(12, "Chicago/State");
            list.add(13, "Clark/Division");
            list.add(14, "Fullerton");
            list.add(15, "Garfield-Dan Ryan");
            list.add(16, "Grand/State");
            list.add(17, "Granville");
            list.add(18, "Harrison");
            list.add(19, "Howard");
            list.add(20, "Jackson/State");
            list.add(21, "Jarvis");
            list.add(22, "Lake/State");
            list.add(23, "Lawrence");
            list.add(24, "Loyola");
            list.add(25, "Monroe/State");
            list.add(26, "Morse");
            list.add(27, "North/Clybourn");
            list.add(28, "Roosevelt/State");
            list.add(29, "Sheridan");
            list.add(30, "Sox-35th");
            list.add(31, "Thorndale");
            list.add(32, "Wilson");


            list2.add(0, 41230);
            list2.add(1, 40910);
            list2.add(2, 40990);
            list2.add(3, 40240);
            list2.add(4, 41430);
            list2.add(5, 40450);
            list2.add(6, 41420);
            list2.add(7, 41200);
            list2.add(8, 41320);
            list2.add(9, 40340);
            list2.add(10, 41380);
            list2.add(11, 41000);
            list2.add(12, 41450);
            list2.add(13, 40630);
            list2.add(14, 41220);
            list2.add(15, 41170);
            list2.add(16, 40330);
            list2.add(17, 40760);
            list2.add(18, 41490);
            list2.add(19, 40900);
            list2.add(20, 40560);
            list2.add(21, 41190);
            list2.add(22, 41660);
            list2.add(23, 40770);
            list2.add(24, 41300);
            list2.add(25, 41090);
            list2.add(26, 40100);
            list2.add(27, 40650);
            list2.add(28, 41400);
            list2.add(29, 40080);
            list2.add(30, 40190);
            list2.add(31, 40880);
            list2.add(32, 40540);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);

        }
        // blue line
        else if (index == 1) {

            list = new ArrayList<>();
            list2 = new ArrayList<>();

            list.add(0, "Addison");
            list.add(1, "Austin");
            list.add(2, "Belmont");
            list.add(3, "California/Milwaukee");
            list.add(4, "Chicago/Milwaukee");
            list.add(5, "Cicero");
            list.add(6, "Clark/Lake");
            list.add(7, "Clinton");
            list.add(8, "Cumberland");
            list.add(9, "Damen/Milwaukee");
            list.add(10, "Division/Milwaukee");
            list.add(11, "Forest Park");
            list.add(12, "Grand/Milwaukee");
            list.add(13, "Harlem (Forest Pk-bound)");
            list.add(14, "Harlem (O'Hare-bound)");
            list.add(15, "Illinois Medical District");
            list.add(16, "Irving Park");
            list.add(17, "Jackson/Dearborn");
            list.add(18, "Jefferson Park");
            list.add(19, "Kedzie-Homan");
            list.add(20, "LaSalle");
            list.add(21, "Logan Square");
            list.add(22, "Monroe/Dearborn");
            list.add(23, "Montrose");
            list.add(24, "Oak Park");
            list.add(25, "O'Hare Airport");
            list.add(26, "Pulaski");
            list.add(27, "Racine");
            list.add(28, "Rosemont");
            list.add(29, "UIC-Halsted");
            list.add(30, "Washington/Dearborn");
            list.add(31, "Western");
            list.add(32, "Western/Milwaukee");


            list2.add(0, 41240);
            list2.add(1, 40010);
            list2.add(2, 40060);
            list2.add(3, 40570);
            list2.add(4, 41410);
            list2.add(5, 40970);
            list2.add(6, 40380);
            list2.add(7, 40430);
            list2.add(8, 40230);
            list2.add(9, 40590);
            list2.add(10, 40320);
            list2.add(11, 40390);
            list2.add(12, 40490);
            list2.add(13, 40980);
            list2.add(14, 40750);
            list2.add(15, 40810);
            list2.add(16, 40550);
            list2.add(17, 40070);
            list2.add(18, 41280);
            list2.add(19, 40250);
            list2.add(20, 41340);
            list2.add(21, 41020);
            list2.add(22, 40790);
            list2.add(23, 41330);
            list2.add(24, 40180);
            list2.add(25, 40890);
            list2.add(26, 40920);
            list2.add(27, 40470);
            list2.add(28, 40820);
            list2.add(29, 40350);
            list2.add(30, 40370);
            list2.add(31, 40220);
            list2.add(32, 40670);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);

        }
        //brown line
        else if (index == 2) {
            list = new ArrayList<>();
            list2 = new ArrayList<>();


            list.add(0, "Adams/Wabash");
            list.add(1, "Addison");
            list.add(2, "Armitage");
            list.add(3, "Belmont");
            list.add(4, "Chicago");
            list.add(5, "Clark/Lake");
            list.add(6, "Damen");
            list.add(7, "Diversey");
            list.add(8, "Francisco");
            list.add(9, "Fullerton");
            list.add(10, "Harold Washington Library");
            list.add(11, "Irving Park");
            list.add(12, "Kedzie");
            list.add(13, "Kimball");
            list.add(14, "LaSalle/Van Buren");
            list.add(15, "Madison/Wabash");
            list.add(16, "Merchandise Mart");
            list.add(17, "Montrose");
            list.add(18, "Paulina");
            list.add(19, "Quincy/Wells");
            list.add(20, "Randolph/Wabash");
            list.add(21, "Rockwell");
            list.add(22, "Sedgwick");
            list.add(23, "Southport");
            list.add(24, "State/Lake");
            list.add(25, "Washington/Wells");
            list.add(26, "Wellington");
            list.add(27, "Western");


            list2.add(0, 40680);
            list2.add(1, 41440);
            list2.add(2, 40660);
            list2.add(3, 41320);
            list2.add(4, 40710);
            list2.add(5, 40380);
            list2.add(6, 40090);
            list2.add(7, 40530);
            list2.add(8, 40870);
            list2.add(9, 41220);
            list2.add(10, 40850);
            list2.add(11, 41460);
            list2.add(12, 41180);
            list2.add(13, 41290);
            list2.add(14, 40160);
            list2.add(15, 40640);
            list2.add(16, 40460);
            list2.add(17, 41500);
            list2.add(18, 41310);
            list2.add(19, 40040);
            list2.add(20, 40200);
            list2.add(21, 41010);
            list2.add(22, 40800);
            list2.add(23, 40360);
            list2.add(24, 40260);
            list2.add(25, 40730);
            list2.add(26, 41210);
            list2.add(27, 41480);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);

        }
        //green line
        else if (index == 3) {
            list = new ArrayList<>();
            list2 = new ArrayList<>();


            list.add(0, "35th-Bronzeville-IIT");
            list.add(1, "43rd");
            list.add(2, "47th");
            list.add(3, "51st");
            list.add(4, "Adams/Wabash");
            list.add(5, "Ashland");
            list.add(6, "Ashland/63rd");
            list.add(7, "Austin");
            list.add(8, "California");
            list.add(9, "Central");
            list.add(10, "Cicero");
            list.add(11, "Clark/Lake");
            list.add(12, "Clinton");
            list.add(13, "Conservatory");
            list.add(14, "Cottage Grove");
            list.add(15, "Garfield");
            list.add(16, "Halsted");
            list.add(17, "Harlem/Lake");
            list.add(18, "Indiana");
            list.add(19, "Kedzie");
            list.add(20, "King Drive");
            list.add(21, "Laramie");
            list.add(22, "Madison/Wabash");
            list.add(23, "Morgan");
            list.add(24, "Oak Park");
            list.add(25, "Pulaski");
            list.add(26, "Randolph/Wabash");
            list.add(27, "Ridgeland");
            list.add(28, "Roosevelt");
            list.add(29, "State/Lake");


            list2.add(0, 41120);
            list2.add(1, 41270);
            list2.add(2, 41080);
            list2.add(3, 40130);
            list2.add(4, 40680);
            list2.add(5, 40170);
            list2.add(6, 40290);
            list2.add(7, 41260);
            list2.add(8, 41360);
            list2.add(9, 40280);
            list2.add(10, 40480);
            list2.add(11, 40380);
            list2.add(12, 41160);
            list2.add(13, 41670);
            list2.add(14, 40720);
            list2.add(15, 40510);
            list2.add(16, 40940);
            list2.add(17, 40020);
            list2.add(18, 40300);
            list2.add(19, 41070);
            list2.add(20, 41140);
            list2.add(21, 40700);
            list2.add(22, 40640);
            list2.add(23, 41510);
            list2.add(24, 41350);
            list2.add(25, 40030);
            list2.add(26, 40200);
            list2.add(27, 40610);
            list2.add(28, 41400);
            list2.add(29, 40260);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);

        }
        //orange line
        else if (index == 4) {
            list = new ArrayList<>();
            list2 = new ArrayList<>();


            list.add(0, "35th/Archer");
            list.add(1, "Adams/Wabash");
            list.add(2, "Ashland");
            list.add(3, "Clark/Lake");
            list.add(4, "Halsted");
            list.add(5, "Harold Washington Library");
            list.add(6, "Kedzie");
            list.add(7, "LaSalle/Van Buren");
            list.add(8, "Madison/Wabash");
            list.add(9, "Midway");
            list.add(10, "Pulaski");
            list.add(11, "Quincy/Wells");
            list.add(12, "Randolph/Wabash");
            list.add(13, "Roosevelt");
            list.add(14, "State/Lake");
            list.add(15, "Washington/Wells");
            list.add(16, "Western");


            list2.add(0, 40120);
            list2.add(1, 40680);
            list2.add(2, 41060);
            list2.add(3, 40380);
            list2.add(4, 41130);
            list2.add(5, 40850);
            list2.add(6, 41150);
            list2.add(7, 40160);
            list2.add(8, 40640);
            list2.add(9, 40930);
            list2.add(10, 40960);
            list2.add(11, 40040);
            list2.add(12, 40200);
            list2.add(13, 41400);
            list2.add(14, 40260);
            list2.add(15, 40730);
            list2.add(16, 40310);


            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);

        }
        //pink line
        else if (index == 5) {
            list = new ArrayList<>();
            list2 = new ArrayList<>();


            list.add(0, "18th");
            list.add(1, "54th/Cermak");
            list.add(2, "Adams/Wabash");
            list.add(3, "Ashland");
            list.add(4, "California");
            list.add(5, "Central Park");
            list.add(6, "Cicero");
            list.add(7, "Clark/Lake");
            list.add(8, "Clinton");
            list.add(9, "Damen");
            list.add(10, "Harold Washington Library");
            list.add(11, "Kedzie");
            list.add(12, "Kostner");
            list.add(13, "LaSalle/Van Buren");
            list.add(14, "Madison/Wabash");
            list.add(15, "Morgan");
            list.add(16, "Polk");
            list.add(17, "Pulaski");
            list.add(18, "Quincy/Wells");
            list.add(19, "Randolph/Wabash");
            list.add(20, "State/Lake");
            list.add(21, "Washington/Wells");
            list.add(22, "Western");


            list2.add(0, 40830);
            list2.add(1, 40580);
            list2.add(2, 40680);
            list2.add(3, 40170);
            list2.add(4, 40440);
            list2.add(5, 40780);
            list2.add(6, 40420);
            list2.add(7, 40380);
            list2.add(8, 41160);
            list2.add(9, 40210);
            list2.add(10, 40850);
            list2.add(11, 41040);
            list2.add(12, 40600);
            list2.add(13, 40160);
            list2.add(14, 40640);
            list2.add(15, 41510);
            list2.add(16, 41030);
            list2.add(17, 40150);
            list2.add(18, 40040);
            list2.add(19, 40200);
            list2.add(20, 40260);
            list2.add(21, 40730);
            list2.add(22, 40740);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);


        }
        //purple line
        else if (index == 6) {
            list = new ArrayList<>();
            list2 = new ArrayList<>();


            list.add(0, "Central");
            list.add(1, "Davis");
            list.add(2, "Dempster");
            list.add(3, "Foster");
            list.add(4, "Howard");
            list.add(5, "Linden");
            list.add(6, "Main");
            list.add(7, "Noyes");
            list.add(8, "South Boulevard");


            list2.add(0, 41250);
            list2.add(1, 40050);
            list2.add(2, 40690);
            list2.add(3, 40520);
            list2.add(4, 40900);
            list2.add(5, 41050);
            list2.add(6, 40270);
            list2.add(7, 40400);
            list2.add(8, 40840);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);


        }
        //yellow line
        else if (index == 7) {
            list = new ArrayList<>();
            list2 = new ArrayList<>();

            list.add(0, "Howard");
            list.add(1, "Oakton-Skokie");
            list.add(2, "Dempster-Skokie");

            list2.add(0, 40900);
            list2.add(1, 41680);
            list2.add(2, 40140);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.stops, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent=new Intent(this, ArrivalsActivity.class);

        //get mapid from hashmap by getting item(train stop) and its value; key=stop and value=mapid
        //int index=map.get(adapterView.getItemAtPosition(i));
        int index=list2.get(i);
        //pass the mapid from hashmap to next intent
        intent.putExtra("index", index);
        startActivity(intent);
    }

}
