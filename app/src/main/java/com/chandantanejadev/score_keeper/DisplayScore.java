package com.chandantanejadev.score_keeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class DisplayScore extends AppCompatActivity implements AlterScore2Player, AlterScore4Player {

    TargetAndName targetAndName = new TargetAndName();
    private static int currentScoreTeam1 = 0;
    private static int currentScoreTeam2 = 0;

    private TextView displayScoreTeam1;
    private TextView displayScoreTeam2;
    private String selectedTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (MainActivity.PLAYER_COUNT == 2) {
            setContentView(R.layout.activity_display_score_2player);
            TextView txtNameTeam1_2Player = findViewById(R.id.txt_nameTeam1);
            TextView txtNameTeam2_2Player = findViewById(R.id.txt_nameTeam2);

            displayScoreTeam1 = findViewById(R.id.txt_DisplayScore_Team1_2Player);
            displayScoreTeam2 = findViewById(R.id.txt_ScoreDisplay_Team2_2Player);
            txtNameTeam1_2Player.setText(targetAndName.getmNameOfTeam1());
            txtNameTeam2_2Player.setText(targetAndName.getmNameOfTeam2());
        }
        else if (MainActivity.PLAYER_COUNT == 4){
            setContentView(R.layout.activity_display_score_4player);
        }



        Intent intent = getIntent();
        if (intent.hasExtra(TargetAndName.TARGET_SCORE)){
            selectedTarget = intent.getStringExtra(TargetAndName.TARGET_SCORE);
        }

    }

    @Override
    public void add1ToTheScoreTeam1(View v) {
        currentScoreTeam1 ++;
        displayCurrentScoreTeam1();
    }

    @Override
    public void add2ToTheScoreTeam1(View v) {
        currentScoreTeam1 += 2;
        displayCurrentScoreTeam1();
    }

    @Override
    public void add5ToTheScoreTeam1(View v) {
        currentScoreTeam1 += 5;
        displayCurrentScoreTeam1();
    }

    @Override
    public void sub1ToTheScoreTeam1(View v) {
        currentScoreTeam1 --;
        displayCurrentScoreTeam1();
    }

    @Override
    public void sub2ToTheScoreTeam1(View v) {
        currentScoreTeam1 -= 2;
        displayCurrentScoreTeam1();
    }

    @Override
    public void sub5ToTheScoreTeam1(View v) {
        currentScoreTeam1 -= 5;
        displayCurrentScoreTeam1();
    }

    @Override
    public void displayCurrentScoreTeam1() {
        displayScoreTeam1.setText(String.valueOf(currentScoreTeam1));
        if (targetAndName.isIsTargetSetted()){
            if (currentScoreTeam1 >= Integer.valueOf(selectedTarget)) {
                winnerIsTeamA();
            }
        }

    }


    @Override
    public void add1ToTheScoreTeam2(View v) {
        currentScoreTeam2 ++;
        displayCurrentScoreTeam2();
    }

    @Override
    public void add2ToTheScoreTeam2(View v) {
        currentScoreTeam2 += 2;
        displayCurrentScoreTeam2();
    }

    @Override
    public void add5ToTheScoreTeam2(View v) {
        currentScoreTeam2 += 5;
        displayCurrentScoreTeam2();
    }

    @Override
    public void sub1ToTheScoreTeam2(View v) {
        currentScoreTeam2--;
        displayCurrentScoreTeam2();
    }

    @Override
    public void sub2ToTheScoreTeam2(View v) {
        currentScoreTeam2 -= 2;
        displayCurrentScoreTeam2();
    }

    @Override
    public void sub5ToTheScoreTeam2(View v) {
        currentScoreTeam2 -= 5;
        displayCurrentScoreTeam2();
    }

    @Override
    public void displayCurrentScoreTeam2() {
        displayScoreTeam2.setText(String.valueOf(currentScoreTeam2));
        if (targetAndName.isIsTargetSetted()) {
            if (currentScoreTeam2 >= Integer.valueOf(selectedTarget)) {
                winnerIsTeamB();
            }
        }
    }

    @Override
    public void resetScore(View v){
        currentScoreTeam1 = 0;
        currentScoreTeam2 = 0;
        displayCurrentScoreTeam1();
        displayCurrentScoreTeam2();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    private void winnerIsTeamA(){
        currentScoreTeam1 = 0;
        currentScoreTeam2 = 0;
        Toast.makeText(this, "Winner is " + targetAndName.getmNameOfTeam1(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "New Game Started", Toast.LENGTH_SHORT).show();
        displayCurrentScoreTeam1();
        displayCurrentScoreTeam2();
    }

    private void winnerIsTeamB(){
        currentScoreTeam1 = 0;
        currentScoreTeam2 = 0;
        Toast.makeText(this, "Winner is " + targetAndName.getmNameOfTeam2(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "New Game Started", Toast.LENGTH_SHORT).show();
        displayCurrentScoreTeam1();
        displayCurrentScoreTeam2();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        currentScoreTeam1 = 0;
        currentScoreTeam2 = 0;
    }

}
