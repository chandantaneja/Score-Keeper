package com.chandantanejadev.score_keeper;

import androidx.appcompat.app.AppCompatActivity;

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

    Spinner spinnerTarget = findViewById(R.id.spinner_target);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_and_name);
        EditText edNameOfTeam3 = findViewById(R.id.ed_nameOfTeam3);
        EditText edNameOfTeam4 = findViewById(R.id.ed_nameOfTeam4);
        TextView tvNameOfTeam3 = findViewById(R.id.txt_nameOfTeam3);
        TextView tvNameOfTeam4 = findViewById(R.id.txt_nameOfTeam4);

        if (MainActivity.PLAYER_COUNT == 2){
            edNameOfTeam3.setVisibility(View.GONE);
            edNameOfTeam4.setVisibility(View.GONE);
            tvNameOfTeam3.setVisibility(View.GONE);
            tvNameOfTeam4.setVisibility(View.GONE);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.target, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTarget.setAdapter(adapter);
        spinnerTarget.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected =  parent.getItemAtPosition(position).toString();
        Toast.makeText(this, selected, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "hello bro", Toast.LENGTH_SHORT).show();
    }
//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.radio_targetYes:
//                if (checked)
//                    spinnerTarget.setVisibility(View.VISIBLE);
//                    break;
//            case R.id.radio_targetNo:
//                if (checked)
//                    spinnerTarget.setVisibility(View.GONE);
//                    break;
//        }
//    }
}
