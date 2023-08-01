package com.lilexample.androidintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        TextView values = (TextView)findViewById(R.id.txtValues);

        // TODO: extract those 2 pieces of data passed by the caller and display them in textview
        // TODO: First i need to getIntent function to get the callingIntent that the Activity was invoked with
        Intent callingIntent = getIntent();
        if(callingIntent != null){
            // TODO: we've created str and intValue to get the Values from the callingIntent in the get_Extra
            String str = callingIntent.getStringExtra("StringData");
            // in integer you have to specify default value in case the integer value is not there
            Integer intValue = callingIntent.getIntExtra("IntData", -1);
            String data = str + "\n" + Integer.toString(intValue);

            values.setText(data);
        }
    }
}
