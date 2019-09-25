package com.chandantanejadev.score_keeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;



public class DisplayScore extends AppCompatActivity {

    TargetAndName targetAndName = new TargetAndName();
    private String SelectedTarget;
//    private static final String TAG = "com.chandantanejadev";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (MainActivity.PLAYER_COUNT == 2) {
            setContentView(R.layout.activity_display_score_2player);
        }
        else if (MainActivity.PLAYER_COUNT == 4){
            setContentView(R.layout.activity_display_score_4player);
        }
        TextView txtNameTeam1_2Player = findViewById(R.id.txt_nameTeam1);
        TextView txtNameTeam2_2Player = findViewById(R.id.txt_nameTeam2);
        Intent intent = getIntent();
        if (intent.hasExtra(TargetAndName.TARGET_SCORE)){
            SelectedTarget = intent.getStringExtra(TargetAndName.TARGET_SCORE);
        }

        txtNameTeam1_2Player.setText(targetAndName.getmNameOfTeam1());
        txtNameTeam2_2Player.setText(targetAndName.getmNameOfTeam2());
    }
}


