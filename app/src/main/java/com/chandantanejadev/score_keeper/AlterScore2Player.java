package com.chandantanejadev.score_keeper;

import android.view.View;

public interface AlterScore2Player {
     void add1ToTheScoreTeam1(View v);
     void add2ToTheScoreTeam1(View v);
     void add5ToTheScoreTeam1(View v);
     void sub1ToTheScoreTeam1(View v);
     void sub2ToTheScoreTeam1(View v);
     void sub5ToTheScoreTeam1(View v);
     void displayCurrentScoreTeam1();

     void add1ToTheScoreTeam2(View v);
     void add2ToTheScoreTeam2(View v);
     void add5ToTheScoreTeam2(View v);
     void sub1ToTheScoreTeam2(View v);
     void sub2ToTheScoreTeam2(View v);
     void sub5ToTheScoreTeam2(View v);
     void displayCurrentScoreTeam2();

     void resetScore(View v);
}
