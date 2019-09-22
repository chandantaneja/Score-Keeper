package com.chandantanejadev.score_keeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TargetAndName extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /**
     * Tag for intent extra to send TargetScore to DisplayScore
     */
    public static final String TARGET_SCORE = "com.chandantanejadev.score_keeper.TARGET_SCORE";

    //declaring vars
    private Spinner spinnerTarget;
    private EditText edNameOfTeam1, edNameOfTeam2,edNameOfTeam3,edNameOfTeam4;

    /**
     * setter for name of team 1 for later reference
     * @param mNameOfTeam1
     */
    public void setmNameOfTeam1(String mNameOfTeam1) {
        this.mNameOfTeam1 = mNameOfTeam1;
        Log.d("Setter Team Name ", "setmNameOfTeam1: Team name one is set as " + mNameOfTeam1 + this.mNameOfTeam1);
    }

    /**
     * setter for name of team 2 for later reference
     * @param mNameOfTeam2
     */
    public void setmNameOfTeam2(String mNameOfTeam2) {
        this.mNameOfTeam2 = mNameOfTeam2;
        Log.d("Setter Team Name ", "setmNameOfTeam2: Team name one is set as " + mNameOfTeam2 + this.mNameOfTeam2);
    }

    /**
     * setter for name of team 3 for later reference
     * @param mNameOfTeam3
     */

    public void setmNameOfTeam3(String mNameOfTeam3) {
        this.mNameOfTeam3 = mNameOfTeam3;
        Log.d("Setter Team Name ", "setmNameOfTeam3: Team name one is set as " + mNameOfTeam3 + this.mNameOfTeam3);
    }

    /**
     * setter for name of team 4 for later reference
     * @param mNameOfTeam4
     */

    public void setmNameOfTeam4(String mNameOfTeam4) {
        this.mNameOfTeam4 = mNameOfTeam4;
        Log.d("Setter Team Name ", "setmNameOfTeam4: Team name one is set as " + mNameOfTeam4 + this.mNameOfTeam4);
    }

    /**
     * Getter for name of team 1 to be called in DisplayScore
     * @return mNameOfTeam1
     */


    public String test(){
        return "fuckOff";
    }

    /**
     * Getter for name of team 2 to be called in DisplayScore
     * @return mNameOfTeam2
     */

    public String getmNameOfTeam2() {
        Log.d("TargetName", "getmNameOfTeam2: called");
        return mNameOfTeam2;
    }

    /**
     * Getter for name of team 3 to be called in DisplayScore
     * @return mNameOfTeam3
     */
    public String getmNameOfTeam3() {
        return mNameOfTeam3;
    }

    /**
     * Getter for name of team 4 to be called in DisplayScore
     * @return mNameOfTeam4
     */
    public String getmNameOfTeam4() {
        return mNameOfTeam4;
    }

    /**
     * Strings to store names of the teams for further calling them from other activities using getters
     */
    public String mNameOfTeam1;
    private String mNameOfTeam2;
    private String mNameOfTeam3;
    private String mNameOfTeam4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_and_name);

        //populating the variables with their respective Views
        spinnerTarget = findViewById(R.id.spinner_target);
        edNameOfTeam1 = findViewById(R.id.ed_nameOfTeam1);
        edNameOfTeam2 = findViewById(R.id.ed_nameOfTeam2);
        edNameOfTeam3 = findViewById(R.id.ed_nameOfTeam3);
        edNameOfTeam4 = findViewById(R.id.ed_nameOfTeam4);
        TextView tvNameOfTeam1 = findViewById(R.id.txt_nameOfTeam1);
        TextView tvNameOfTeam2 = findViewById(R.id.txt_nameOfTeam2);
        TextView tvNameOfTeam3 = findViewById(R.id.txt_nameOfTeam3);
        TextView tvNameOfTeam4 = findViewById(R.id.txt_nameOfTeam4);

        /**
         * Check if the user wants to use the app for 2 player or 4
         */
        if (MainActivity.PLAYER_COUNT == 2){
            edNameOfTeam3.setVisibility(View.GONE);
            edNameOfTeam4.setVisibility(View.GONE);
            tvNameOfTeam3.setVisibility(View.GONE);
            tvNameOfTeam4.setVisibility(View.GONE);
        }

        /**
         * adapting the String Array to the Spinner to display the targets
         */
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.target, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTarget.setAdapter(adapter);
        //setting on click listener to the Spinner
        spinnerTarget.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //getting the item clicked in the Spinner
        String selectedTarget = parent.getItemAtPosition(position).toString();
        //make Target default and do nothing when kept like this
        if (selectedTarget.equals("Target")){
            //do nothing here
        }else{
            Toast.makeText(this, selectedTarget, Toast.LENGTH_SHORT).show();
            /**
             * As the user clicks on any target, the names of the teams are stored
             * in the String vars
             */


            mNameOfTeam1 = edNameOfTeam1.getText().toString();
            setmNameOfTeam1(mNameOfTeam1);
//            Log.d("TargetAndJava", "onValueClicked: value of team 1" + mNameOfTeam1 + "working fine till here");
            mNameOfTeam2 = edNameOfTeam2.getText().toString();
            setmNameOfTeam2(mNameOfTeam2);
//            Log.d("TargetAndJava", "onValueClicked: value of team 2" + mNameOfTeam2 + "working fine till here");
            mNameOfTeam3 = edNameOfTeam3.getText().toString();
            setmNameOfTeam1(mNameOfTeam3);
            mNameOfTeam4 = edNameOfTeam4.getText().toString();
            setmNameOfTeam4(mNameOfTeam4);


            Toast.makeText(this, " Team 1: " + mNameOfTeam1 + "Team 2: " + mNameOfTeam2 + " Team 3: " + mNameOfTeam3 + " Team 4: " + mNameOfTeam4,
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TargetAndName.this, DisplayScore.class);
            intent.putExtra(TARGET_SCORE, selectedTarget);
            startActivity(intent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    /**
     * If Yes is clicked then only display the Spinner
     * If No is clicked then set the visibility of the Spinner to Gone/Invisible
     * @param view is the view of the radio group
     */
    public void onRadioButtonClicked(View view) {
//         Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_targetYes:
                if (checked)
                    spinnerTarget.setVisibility(View.VISIBLE);
                    break;
            case R.id.radio_targetNo:
                if (checked){ //added {} now
                    spinnerTarget.setVisibility(View.GONE);
                mNameOfTeam1 = edNameOfTeam1.getText().toString();
                setmNameOfTeam1(mNameOfTeam1);
//                Log.d("TargetAndJava", "onRadioButtonClicked: value of team 1" + mNameOfTeam1 + "working fine till here");
                mNameOfTeam2 = edNameOfTeam2.getText().toString();
                setmNameOfTeam2(mNameOfTeam2);
//                Log.d("TargetAndJava", "onRadioButtonClicked: value of team 2" + mNameOfTeam2 + "working fine till here");
                mNameOfTeam3 = edNameOfTeam3.getText().toString();
                setmNameOfTeam3(mNameOfTeam3);
//                Log.d("TargetAndJava", "onRadioButtonClicked: value of team 3" + mNameOfTeam3 + "working fine till here");
                mNameOfTeam4 = edNameOfTeam4.getText().toString();
                setmNameOfTeam4(mNameOfTeam4);
//                Log.d("TargetAndJava", "onRadioButtonClicked: value of team 4" + mNameOfTeam4 + "working fine till here");
                    Toast.makeText(this, " Team 1: " + mNameOfTeam1 + "Team 2: " + mNameOfTeam2 + " Team 3: " + mNameOfTeam3 + " Team 4: " + mNameOfTeam4,
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TargetAndName.this, DisplayScore.class);
                startActivity(intent);
                }
                    break;
        }
    }

    public String getmNameOfTeam1() {
        Log.d("Important!!", "getmNameOfTeam1: Okay Your close" + " the val is " + mNameOfTeam1);
        return mNameOfTeam1;
    }



}
