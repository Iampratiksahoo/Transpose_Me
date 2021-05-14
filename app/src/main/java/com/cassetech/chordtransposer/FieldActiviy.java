package com.cassetech.chordtransposer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FieldActiviy extends AppCompatActivity
{
    EditText editNoofChords;

    public void onSubmit(View view)
    {

        try
        {
            int chordValue = Integer.valueOf(editNoofChords.getText().toString());
            if (chordValue > 12) {
                Toast.makeText(this, "No of Chord Cannot be more than 12", Toast.LENGTH_SHORT).show();
            } else if (chordValue < 0) {
                Toast.makeText(this, "No of Chord Cannot be less than 0", Toast.LENGTH_SHORT).show();
            } else if (chordValue == 0) {
                Toast.makeText(this, "Atleast one chord is required to transpose", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(FieldActiviy.this, chord_activity.class);
                intent.putExtra("noofchords", chordValue);
                startActivity(intent);
            }
        }
        catch(Exception e)
        {
                Toast.makeText(this, "Atleast one chord is required to transpose", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_activiy);

        //Declaration//
        editNoofChords = (EditText)findViewById(R.id.editNoOfChords);

    }
}