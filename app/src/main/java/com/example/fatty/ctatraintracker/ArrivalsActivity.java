package com.example.fatty.ctatraintracker;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import android.os.Handler;

public class ArrivalsActivity extends ListActivity implements SwipeRefreshLayout.OnRefreshListener {

    SimpleAdapter adapter;
    SwipeRefreshLayout mSwipeRefreshLayout;
    String text;

    private Route route;
    List<Route> routes;
    Handler handler;
    int mapid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrivals);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.container);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        setTitle("Arrivals");
        Intent intent = getIntent();
        mapid = intent.getIntExtra("index", 0);
        //apikey= is a temporary experimental key for public use
        new RequestTask().execute("http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx?key=d37555ccc09141848543ab21e287b560&mapid=" + mapid);//+mapid
        System.out.println("mapID" + mapid);
        routes = new ArrayList<>();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.arrivals, menu);
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
    public void onRefresh() {
        //when pull down happens

        mSwipeRefreshLayout.setRefreshing(true);

        // Simulate a long running activity

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
                //clear list
                routes.clear();
                //apikey= is a temporary experimental key for public use
                new RequestTask().execute("http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx?key=d37555ccc09141848543ab21e287b560&mapid=" + mapid);//+mapid
                Toast.makeText(getApplicationContext(), "Refreshed",
                        Toast.LENGTH_LONG).show();
            }
        }, 1000);

    }

    class RequestTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... uri) {

            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response;
            String responseString = null;
            try {
                response = httpclient.execute(new HttpGet(uri[0]));
                StatusLine statusLine = response.getStatusLine();
                if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    response.getEntity().writeTo(out);
                    out.close();
                    responseString = out.toString();
                } else {
                    //close connection
                    response.getEntity().getContent().close();
                    throw new IOException(statusLine.getReasonPhrase());
                }
            } catch (ClientProtocolException e) {
                //todo handle problems..
            } catch (IOException e) {
                //todo handle problems
            }
            return responseString;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            //parse information
            System.out.println(result);

            //instantiates parser

            XmlPullParserFactory factory = null;
            XmlPullParser parser = null;

            try {
                factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                parser = factory.newPullParser();

                parser.setInput(new StringReader(result));

                int eventType = parser.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String tagname = parser.getName();
                    switch (eventType) {
                        case XmlPullParser.START_TAG:
                            if (tagname.equalsIgnoreCase("eta")) {
                                //create new obj
                                route = new Route();
                            }
                            break;

                        case XmlPullParser.TEXT:
                            text = parser.getText();
                            break;
                        case XmlPullParser.END_TAG:
                            if (tagname.equalsIgnoreCase("eta")) {
                                routes.add(route);
                                System.out.println(tagname);
                            } else if (tagname.equalsIgnoreCase("prdt")) {
                                //cast to int
                                route.setPrdt(text);
                            } else if (tagname.equalsIgnoreCase("arrt")) {
                                route.setArrt(text);
                            } else if (tagname.equalsIgnoreCase("destnm")) {
                                //cast to int
                                //int text2 = Integer.parseInt(text);
                                route.setDestNm(text);


                            } else if (tagname.equalsIgnoreCase("stpde")) {
                                //cast to int
                                //int text2 = Integer.parseInt(text);
                                route.setStpde(text);


                            }
                            break;

                        default:
                            break;
                    }
                    eventType = parser.next();

                }

            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Routes size is: " + routes.size());

            //set to listView
            List<HashMap<String, Object>> data = new ArrayList<>();

            HashMap<String, Object> map;
            Collections.sort(routes, new CustomComparator());

            for (int i = 0; i < routes.size(); i++) {

                map = new HashMap<>();

                map.put("destination", routes.get(i).getDestNm());
                if (routes.get(i).getArrivals() == 1)
                    map.put("arrival", "Due");
                else
                    map.put("arrival", routes.get(i).getArrivals() + " MIN");
                data.add(map);


            }

            adapter = new SimpleAdapter(getApplication(), data, R.layout.item, new String[]{"destination", "arrival"}, new int[]{R.id.destination, R.id.arrival});
            //set adapter to list
            setListAdapter(adapter);
            //show arrivals

        }//end of request


        public class CustomComparator implements Comparator<Route> {
            @Override
            public int compare(Route o1, Route o2) {
                return o1.getDestNm().compareTo(o2.getDestNm());
            }
        }
    }
}

