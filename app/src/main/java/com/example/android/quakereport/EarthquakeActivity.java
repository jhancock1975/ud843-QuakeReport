/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    private static DateFormat dateFormat = new SimpleDateFormat("YYYY-mm-dd");
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(LOG_TAG, "onCreate::starting up");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        try {
            List<QuakeListItem> earthquakes = new ArrayList<>();
            earthquakes.add(new QuakeListItem(6.7, "San Francisco", dateFormat.parse("2016-01-01")));
            earthquakes.add(new QuakeListItem(8.2, "London", dateFormat.parse("2016-08-01")));
            earthquakes.add(new QuakeListItem(9.9, "Tokyo", dateFormat.parse("2016-09-22")));
            earthquakes.add(new QuakeListItem(1.1, "Mexico City", dateFormat.parse("2017-01-31")));
            earthquakes.add(new QuakeListItem(2.8, "Moscow", dateFormat.parse("2017-03-17")));
            earthquakes.add(new QuakeListItem(7.1,"Rio de Janeiro", dateFormat.parse("2017-04-01")));
            earthquakes.add(new QuakeListItem(4.4, "Paris", dateFormat.parse("2018-10-01")));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        ArrayAdapter<QuakeListItem> adapter = new QuakeArrayAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
        } catch(ParseException e){
            Log.d(LOG_TAG, "onCreate:: unable to parse date format");
        }
    }
}
