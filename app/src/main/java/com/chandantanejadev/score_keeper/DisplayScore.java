package com.chandantanejadev.score_keeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class DisplayScore extends AppCompatActivity implements AlterScore2Player {

    TargetAndName targetAndName = new TargetAndName();
    private static int scoreTeam1 = 0;
    private static int scoreTeam2 = 0;
    private Button scoreAdd1Team1, scoreAdd2Team1, scoreAdd5Team1, scoreAdd1Team2, scoreAdd2Team2, scoreAdd5Team2;
    private TextView txtNameTeam1_2Player, txtNameTeam2_2Player, displayScoreTeam1, displayScoreTeam2;
    private String selectedTarget;
//    private static final String TAG = "com.chandantanejadev";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (MainActivity.PLAYER_COUNT == 2) {
            setContentView(R.layout.activity_display_score_2player);
            txtNameTeam1_2Player = findViewById(R.id.txt_nameTeam1);
            txtNameTeam2_2Player = findViewById(R.id.txt_nameTeam2);
            scoreAdd1Team1 = findViewById(R.id.add1Score);
            scoreAdd2Team1 = findViewById(R.id.add2Score);
            scoreAdd5Team1 = findViewById(R.id.add5Score);
            scoreAdd1Team2 = findViewById(R.id.add1ScoreTeam2);
            scoreAdd2Team2 = findViewById(R.id.add2ScoreTeam2);
            scoreAdd5Team2 = findViewById(R.id.add5ScoreTeam2);
            displayScoreTeam1 = findViewById(R.id.txt_ScoreDisplay_Team1_2Player);
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

        scoreAdd1Team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add1ToTheScoreTeam1();
            }
        });

        scoreAdd2Team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add2ToTheScoreTeam1();
            }
        });

        scoreAdd5Team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add5ToTheScoreTeam1();
            }
        });

        scoreAdd1Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add1ToTheScoreTeam2();
            }
        });

        scoreAdd2Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add2ToTheScoreTeam2();
            }
        });
        scoreAdd5Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add5ToTheScoreTeam2();
            }
        });
    }

    @Override
    public void add1ToTheScoreTeam1() {
        scoreTeam1 ++;
        displayCurrentScoreTeam1();
    }

    @Override
    public void add2ToTheScoreTeam1() {
        scoreTeam1 += 2;
        displayCurrentScoreTeam1();
    }

    @Override
    public void add5ToTheScoreTeam1() {
        scoreTeam1 += 5;
        displayCurrentScoreTeam1();
    }

    @Override
    public void sub1ToTheScoreTeam1() {
        scoreTeam1 --;
        displayCurrentScoreTeam1();
    }

    @Override
    public void sub2ToTheScoreTeam1() {
        scoreTeam1 -= 2;
        displayCurrentScoreTeam1();
    }

    @Override
    public void sub5ToTheScoreTeam1() {
        scoreTeam1 -= 5;
        displayCurrentScoreTeam1();
    }

    @Override
    public void displayCurrentScoreTeam1() {
        displayScoreTeam1.setText(scoreTeam1);
    }

    @Override
    public void add1ToTheScoreTeam2() {
        scoreTeam2 ++;
    }

    @Override
    public void add2ToTheScoreTeam2() {
        scoreTeam2 += 2;
    }

    @Override
    public void add5ToTheScoreTeam2() {
        scoreTeam2 += 5;
    }

    @Override
    public void sub1ToTheScoreTeam2() {
        scoreTeam2--;
    }

    @Override
    public void sub2ToTheScoreTeam2() {
        scoreTeam2 -= 2;
    }

    @Override
    public void sub5ToTheScoreTeam2() {
        scoreTeam2 -= 5;
    }

    @Override
    public void displayCurrentScoreTeam2() {
        displayScoreTeam2.setText(scoreTeam2);
    }
}
