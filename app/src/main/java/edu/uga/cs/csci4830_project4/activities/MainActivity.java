package edu.uga.cs.csci4830_project4.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.List;

import edu.uga.cs.csci4830_project4.R;
import edu.uga.cs.csci4830_project4.database.states.StateModel;
import edu.uga.cs.csci4830_project4.database.states.StatesAccess;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private static final boolean DEBUG = true;

    // TODO: example usage of StatesAccess, not actually needed to main activity
    private StatesAccess statesAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statesAccess = new StatesAccess(this);
        if (DEBUG) {
            statesAccess.open();
            List<StateModel> states = statesAccess.retrieveAllStates();
            for (StateModel state : states) {
                Log.d(TAG, "State in db: " + state);
            }
            statesAccess.close();
        }

        Button buttonPlay = findViewById(R.id.buttonPlay);

        // TODO: replace this with a call to the GameActivity
        buttonPlay.setOnClickListener(view -> startActivity(new Intent(this,
                old_GameActivity.class)));
        // buttonPlay.setOnClickListener(view -> startActivity(new Intent(this, GameActivity
        // .class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        statesAccess.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        statesAccess.close();
    }
}
