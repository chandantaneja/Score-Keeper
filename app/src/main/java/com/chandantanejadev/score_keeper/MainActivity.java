package com.chandantanejadev.score_keeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //a global int that will decide the layout of the Target and Name adder
    public static int PLAYER_COUNT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * creating and instantiating buttons
         */
        Button btn2Player = findViewById(R.id.btn_2Player);
        Button btn4Player = findViewById(R.id.btn_4Player);


        /**
         * Setting OnClickListeners for buttons
         */
        btn2Player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PLAYER_COUNT = 2;
                TargetAndNameSetterActivity();
            }
        });
        btn4Player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PLAYER_COUNT = 4;
                TargetAndNameSetterActivity();
            }
        });
    }


    /**
     * Method to start another activity
     */
    private void TargetAndNameSetterActivity(){
        Intent intent = new Intent(MainActivity.this, TargetAndName.class);
        startActivity(intent);
    }
}
