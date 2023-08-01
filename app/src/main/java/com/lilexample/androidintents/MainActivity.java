package com.lilexample.androidintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the UI controls
        findViewById(R.id.create_explicit).setOnClickListener(this);
        findViewById(R.id.create_implicit).setOnClickListener(this);
        findViewById(R.id.btnMediaIntents).setOnClickListener(this);
        findViewById(R.id.btnAppIntents).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Figure out which button was clicked
        int viewClicked = v.getId();

        if (viewClicked == R.id.create_explicit) {
            // TODO: Build an explicit Intent to launch our Activity
            Intent intent = new Intent(this, DestinationActivity.class);

            // TODO: send data along with the Intent to the destination using putExtra()
            intent.putExtra("StringData", "This is a String");
            intent.putExtra("IntData", 1234);

            // TODO: Start the activity with our explicit intent
            startActivity(intent);
        }
        else if (viewClicked == R.id.create_implicit) {
            // TODO: Build an implicit intent to handle a type of action
            String textMessage = "This is a sample message";

            // first created Intent
            Intent i = new Intent();
            // set the intent action along with MIME type of data that i am sending using Intent.action send class
            i.setAction(Intent.ACTION_SEND);
            // set the type as plain text which means that asking system which app you have can handle text data
            i.setType("text/plain");
            // we use putExtra() to store the payload data in the intent
            i.putExtra(Intent.EXTRA_TEXT, textMessage);
            // TODO: use an intent chooser to force a choose dialog


            // TODO: Verify that the intent will resolve to an activity
            startActivity(i);
            // Typically you would handle the null case here by informing the user
            // that there is no installed app to handle this intent or
            // by taking some other action
        }

        // Handle button clicks to start the other intent examples
        if (viewClicked == R.id.btnAppIntents) {
            Intent i = new Intent(this, AppsActivity.class);
            startActivity(i);
        }
        else if (viewClicked == R.id.btnMediaIntents) {
            Intent i = new Intent(this, MediaActivity.class);
            startActivity(i);
        }
    }
}
