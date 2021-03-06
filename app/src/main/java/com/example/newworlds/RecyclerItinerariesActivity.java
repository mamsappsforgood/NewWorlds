package com.example.newworlds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class creates a RecyclerView for displaying possible itineraries from places the user selected
 */
public class RecyclerItinerariesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_itineraries);

        /**
         * Sets up a RecyclerView for the possible itineraries
         */
        recyclerView = (RecyclerView) findViewById(R.id.recyclerFinal);

        /**
         * Improves the performance since changes in content do not change the layout size of the RecyclerView
         */
        recyclerView.setHasFixedSize(true);

        /**
         * Sets up the linear layout manager
         */
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        final Controller aController = (Controller) getApplicationContext();

        /**
         * Gets the places the user selected passed in by intents
         */
        Bundle bundle = getIntent().getExtras();
        ArrayList<Education> educations2 = (ArrayList<Education>) bundle.get("Arjun Education");
        ArrayList<Entertainment> entertainments2 = (ArrayList<Entertainment>) bundle.get("Arjun Entertainment");
        ArrayList<Restaurant> restaurants2 = (ArrayList<Restaurant>) bundle.get("Arjun Restaurant");

        /**
         * Creates new array lists of places and sets them to the places the user selected if they
         * are not null
         */
        ArrayList<Education> education3 = new ArrayList<Education>();
        ArrayList<Entertainment> entertainment3 = new ArrayList<Entertainment>();
        ArrayList<Restaurant> restaurant3 = new ArrayList<Restaurant>();

        if (educations2 != null) {
            Log.d("does this work?", Arrays.toString(educations2.toArray()));
            education3 = educations2;
        }

        if (entertainments2 != null) {
            Log.d("does this work?2", Arrays.toString(entertainments2.toArray()));
            entertainment3 = entertainments2;
        }

        if (restaurants2 != null) {
            Log.d("does this work?3", Arrays.toString(restaurants2.toArray()));
            restaurant3 = restaurants2;
        }

        /**
         * Creates an array list of schedules from the places selected and acts accordingly if user
         * selects multiple places from same type
         */
        ArrayList<ArrayList<Itenerary>> itineraries = new ArrayList<ArrayList<Itenerary>>();
        ArrayList<ArrayList<Itenerary>> dummy = new ArrayList<ArrayList<Itenerary>>();
        ArrayList<ArrayList<Itenerary>> edenDummy = new ArrayList<ArrayList<Itenerary>>();

        if (restaurant3.size() == 0 && education3.size() == 0 && entertainment3.size() == 0) {
            Log.d("AlexTestItenerary", "It doesn't work");
        } else {
            itineraries = aController.permutate(restaurant3, education3, entertainment3);

            /**
             * Attempts to go through different permutations of itineraries with the same places in them
             * (different orders)
             * (These methods don't work correctly)
             */
/*
            for (int i = 0; i < itineraries.size(); i++) {
                ArrayList<ArrayList<Itenerary>> dummy2 = new ArrayList<>();
                dummy2 = aController.permutate2(itineraries.get(i));
                for (int k = 0; k < dummy2.size(); k++) {
                    dummy.add(dummy2.get(k));
                }

            }

/*
             for (int i=0;i<itineraries.size();i++){
                 edenDummy = aController.edenPermutate(itineraries.get(i));
             }


        }
*/

            Log.d("itineraries", itineraries.toString());
            //Log.d("dummy", dummy.toString());

            /**
             * Creates and sets an adapter for displaying the itineraries
             */
            adapter = new RecycleViewAdapterItineraries(itineraries, this);
            recyclerView.setAdapter(adapter);

            /**
             * Directs to the Recycler Final Activity Class and passes in the itinerary selected when
             * "Final Itinerary" Button is clicked
             */
            final Button buttonOp2 = (Button) findViewById(R.id.final_itinerary);
            buttonOp2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(RecyclerItinerariesActivity.this, RecyclerFinalActivity.class);
                    intent.putExtra("yolo", aController.getAlexsItenerary());
                    Log.d("yay", aController.getAlexsItenerary().toString());
                    startActivity(intent);
                }
            });
        }
    }
}
