package com.chandantanejadev.score_keeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TargetAndName extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private static boolean isTargetSetted = false;

    public boolean isIsTargetSetted() {
        return isTargetSetted;
    }

    /**
     * Tag for intent extra to send TargetScore to DisplayScore
     */
    public static final String TARGET_SCORE = "com.chandantanejadev.score_keeper.TARGET_SCORE";

    //declaring vars
    private Spinner spinnerTarget;
    private EditText edNameOfTeam1, edNameOfTeam2,edNameOfTeam3,edNameOfTeam4;


    /**
     * Getter for name of team 1 to be called in DisplayScore
     * @return mNameOfTeam1
     */
    public String getmNameOfTeam1() {
        return mNameOfTeam1;
    }

    /**
     * Getter for name of team 2 to be called in DisplayScore
     * @return mNameOfTeam2
     */

    public String getmNameOfTeam2() {
//        Log.d("TargetName", "getmNameOfTeam2: called");
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
    private static String mNameOfTeam1;
    private static String mNameOfTeam2;
    private static String mNameOfTeam3;
    private static String mNameOfTeam4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_and_name);

//        populating the variables with their respective Views

        spinnerTarget = findViewById(R.id.spinner_target);
        edNameOfTeam1 = findViewById(R.id.ed_nameOfTeam1);
        edNameOfTeam2 = findViewById(R.id.ed_nameOfTeam2);
        edNameOfTeam3 = findViewById(R.id.ed_nameOfTeam3);
        edNameOfTeam4 = findViewById(R.id.ed_nameOfTeam4);

//        TextView tvNameOfTeam1 = findViewById(R.id.txt_nameOfTeam1);
//        TextView tvNameOfTeam2 = findViewById(R.id.txt_nameOfTeam2);

        TextView tvNameOfTeam3 = findViewById(R.id.txt_nameOfTeam3);
        TextView tvNameOfTeam4 = findViewById(R.id.txt_nameOfTeam4);

//          Check if the user wants to use the app for 2 player or 4

        if (MainActivity.PLAYER_COUNT == 2){
            edNameOfTeam3.setVisibility(View.GONE);
            edNameOfTeam4.setVisibility(View.GONE);
            tvNameOfTeam3.setVisibility(View.GONE);
            tvNameOfTeam4.setVisibility(View.GONE);
        }


//         adapting the String Array to the Spinner to display the targets

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

//              As the user clicks on any target, the names of the teams are stored
//              in the String vars


            mNameOfTeam1 = edNameOfTeam1.getText().toString();
            mNameOfTeam2 = edNameOfTeam2.getText().toString();
            mNameOfTeam3 = edNameOfTeam3.getText().toString();
            mNameOfTeam4 = edNameOfTeam4.getText().toString();

            isTargetSetted = true;


//              Intent to start DisplayScore and to send selectedTarget Score as an extra

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
                if (checked){
                    spinnerTarget.setVisibility(View.GONE);


//                     as The user clicks NO
//                     Setting string vars with the data of their respective texts from ET's

                mNameOfTeam1 = edNameOfTeam1.getText().toString();
                mNameOfTeam2 = edNameOfTeam2.getText().toString();
                mNameOfTeam3 = edNameOfTeam3.getText().toString();
                mNameOfTeam4 = edNameOfTeam4.getText().toString();

                isTargetSetted = false;
//                      Intent to start DisplayScore activity
//                      The user do not want to set the target score

                Intent intent = new Intent(TargetAndName.this, DisplayScore.class);
                startActivity(intent);

                }
                    break;
        }
    }
}
