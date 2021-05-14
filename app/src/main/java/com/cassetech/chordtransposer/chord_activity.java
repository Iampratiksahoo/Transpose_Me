 package com.cassetech.chordtransposer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class chord_activity extends AppCompatActivity
{
    String[] chords = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    EditText chord1;
    EditText chord2;
    EditText chord3;
    EditText chord4;
    EditText chord5;
    EditText chord6;
    EditText chord7;
    EditText chord8;
    EditText chord9;
    EditText chord10;
    EditText chord11;
    EditText chord12;

    TextView resultChord1;
    TextView resultChord2;
    TextView resultChord3;
    TextView resultChord4;
    TextView resultChord5;
    TextView resultChord6;
    TextView resultChord7;
    TextView resultChord8;
    TextView resultChord9;
    TextView resultChord10;
    TextView resultChord11;
    TextView resultChord12;

    TextView tranposeValue1;
    TextView tranposeValue2;
    TextView tranposeValue3;
    TextView tranposeValue4;
    TextView tranposeValue5;
    TextView tranposeValue6;
    TextView tranposeValue7;
    TextView tranposeValue8;
    TextView tranposeValue9;
    TextView tranposeValue10;
    TextView tranposeValue11;
    TextView tranposeValue12;

    Button Button1;
    Button Button2;
    Button Button3;
    Button Button4;
    Button Button5;
    Button Button6;
    Button Button7;
    Button Button8;
    Button Button9;
    Button Button10;
    Button Button11;
    Button Button12;
    Button Button13;
    Button Button14;
    Button Button15;
    Button Button16;
    Button Button17;
    Button Button18;
    Button Button19;
    Button Button20;
    Button Button21;
    Button Button22;
    Button Button23;
    Button Button24;

    TextView textViewChords;
    TextView textViewTranspose;

    EditText[] chordArray;
    TextView[] resultChordArray;
    TextView[] tranposeValueArray;
    Button[] negativeButton;
    Button[] positiveButton;
    String[] positiveButtonArray;
    String[] negativeButtonArray;
    String[] checkForChange;

    String lastChord[];
    int counter[];
    boolean isChanged = false;
    int chordValue;

    public void onClickPositiveButton(View view)
    {
        int tag = Integer.valueOf(view.getTag().toString());
        String tempChord = chordArray[tag - 1].getText().toString();
        tempChord = tempChord.toUpperCase();
        boolean isPresent = false;
        if(checkForChange[tag -1].equals(""))  // Check if the Last Chord is Changed.
        {
            checkForChange[tag-1] = tempChord;
        }
        else
        {
            if(!checkForChange[tag-1].equals(tempChord))
            {
                lastChord[tag-1] = "";
                counter[tag - 1] = 0;
                checkForChange[tag-1] = tempChord;
            }
        }
        for(int k = 0; k < 12; k++) // Check if the user has entered an invalid chord
        {
            if(tempChord.equals(chords[k]))
            {
                isPresent = true;
                break;
            }
        }
        if(!isPresent) // exit the function if user has entered invalid chord
        {
            if(tag == 1)
            {
                Toast.makeText(this,"Invalid Chord entered at 1st Position",Toast.LENGTH_SHORT).show();
                return;
            }
            else if(tag == 2)
            {
                Toast.makeText(this,"Invalid Chord entered at 2nd Position",Toast.LENGTH_SHORT).show();
                return;
            }
            else if(tag == 3)
            {
                Toast.makeText(this,"Invalid Chord entered at 3rd Position",Toast.LENGTH_SHORT).show();
                return;
            }
            else
            {
                Toast.makeText(this,"Invalid Chord entered at "+tag+"th Position",Toast.LENGTH_SHORT).show();
                return;
            }
        }
        else
        {
            String tempResultChord = null;
            try // Continue to the main problem Solving
            {
                if (lastChord[tag - 1].equals("")) {
                    lastChord[tag - 1] = tempChord;
                    resultChordArray[tag - 1].setText("");
                } else {
                    tempChord = lastChord[tag - 1];
                }
                if (tempChord.equals(lastChord[tag - 1])) {
                    if (!resultChordArray[tag - 1].getText().toString().equals("")) {
                        resultChordArray[tag - 1].setText(tempChord);
                    }
                    int i = 0;
                    while (i < 12)  // For Positive
                    {
                        if (tempChord.equals(chords[i])) {
                            if (i + 1 == 12)
                                i = -1;

                            tempResultChord = chords[i + 1];
                            counter[tag - 1]++;
                            if (counter[tag - 1] == 12)
                                counter[tag - 1] = 0;
                            break;
                        }
                        i++;
                    }
                    resultChordArray[tag - 1].setText(tempResultChord);
                    if (counter[tag - 1] >= 0) {
                        tranposeValueArray[tag - 1].setText("+" + counter[tag - 1]);
                    } else {
                        tranposeValueArray[tag - 1].setText("-" + counter[tag - 1]);
                    }
                    lastChord[tag - 1] = tempResultChord;
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Some error Occurred, please check the entered chord and try again", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onClickNegativeButton(View view)
    {
        int tag = Integer.valueOf(view.getTag().toString());
        String tempChord = chordArray[tag - 1].getText().toString();
        boolean isPresent = false;
        tempChord = tempChord.toUpperCase();
            if (checkForChange[tag - 1].equals("")) {
                checkForChange[tag - 1] = tempChord;
            } else {
                if (!checkForChange[tag - 1].equals(tempChord)) {
                    lastChord[tag - 1] = "";
                    counter[tag - 1] = 0;
                    checkForChange[tag - 1] = tempChord;
                }
            }
            for (int k = 0; k < 12; k++) // Check if the user has entered an invalid chord
            {
                if (tempChord.equals(chords[k])) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) {
                if (tag == 1) {
                    Toast.makeText(this, "Invalid Chord entered at 1st Position", Toast.LENGTH_SHORT).show();
                    return;
                } else if (tag == 2) {
                    Toast.makeText(this, "Invalid Chord entered at 2nd Position", Toast.LENGTH_SHORT).show();
                    return;
                } else if (tag == 3) {
                    Toast.makeText(this, "Invalid Chord entered at 3rd Position", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(this, "Invalid Chord entered at " + tag + "th Position", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            else
            {
                String tempResultChord = null;
                try
                {
                if (lastChord[tag - 1].equals(""))
                {
                    lastChord[tag - 1] = tempChord;
                    resultChordArray[tag - 1].setText("");
                }
                else
                {
                    tempChord = lastChord[tag - 1];
                }
                if (tempChord.equals(lastChord[tag - 1]))
                {
                    if (!resultChordArray[tag - 1].getText().toString().equals(""))
                    {
                        resultChordArray[tag - 1].setText(tempChord);
                    }
                    int i = 11;
                    while (i >= 0)  // For Positive
                    {
                        if (tempChord.equals(chords[i]))
                        {
                            if (i - 1 == -1)
                                i = 12;

                            tempResultChord = chords[i - 1];
                            counter[tag - 1]--;
                            if (counter[tag - 1] == -12)
                                counter[tag - 1] = 0;
                            break;
                        }
                        i--;
                    }
                    resultChordArray[tag - 1].setText(tempResultChord);
                    if (counter[tag - 1] >= 0)
                    {
                        tranposeValueArray[tag - 1].setText("+" + counter[tag - 1]);
                    } else
                    {
                        tranposeValueArray[tag - 1].setText("-" + counter[tag - 1]);
                    }
                    lastChord[tag - 1] = tempResultChord;
                }
            }
        catch(Exception e)
            {
                e.printStackTrace();
                Toast.makeText(this, "Some error occurred, please check the entered chord and try again", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onClickMasterPlusButton(View view)
    {
        String tempResultChord = "";
        String faulty;
        boolean isPresent;
            for (int i = 0; i < chordValue; i++)
            {
                faulty = "";
                String tempChord = chordArray[i].getText().toString();
                tempChord = tempChord.toUpperCase();
                isPresent = false;
                if (checkForChange[i].equals("")) {
                    checkForChange[i] = tempChord;
                } else {
                    if (!checkForChange[i].equals(tempChord) && !tempChord.equals("a") && !tempChord.equals("A")) {
                        lastChord[i] = "";
                        counter[i] = 0;
                        checkForChange[i] = tempChord;
                    }
                }
                for (int k = 0; k < 12; k++) // Check if the user has entered an invalid chord
                {
                    if (tempChord.equals(chords[k])) {
                        isPresent = true;
                        break;
                    }
                }
                if (!isPresent) {
                    if (i == 0) {
                        faulty = "1st";
                    } else if (i == 1) {
                        faulty = "2nd";
                    } else if (i == 2) {
                        faulty = "3rd";
                    } else {
                        faulty = i + 1 + "th";
                    }
                }
                if (!faulty.equals("")) {
                    Toast.makeText(this, "Invalid Chords at " + faulty + " Position", Toast.LENGTH_SHORT).show();
                    continue;
                }
                    try {

                        if (!chordArray[i].getText().toString().equals("")) {
                            if (lastChord[i].equals("")) {
                                lastChord[i] = tempChord;
                                resultChordArray[i].setText("");
                            } else {
                                tempChord = lastChord[i];
                            }
                            if (tempChord.equals(lastChord[i])) {
                                if (!resultChordArray[i].getText().toString().equals("")) {
                                    resultChordArray[i].setText(tempChord);
                                }
                                int j = 0;
                                while (j < 12)  // For Positive
                                {
                                    if (tempChord.equals(chords[j])) {
                                        if (j + 1 == 12)
                                            j = -1;

                                        tempResultChord = chords[j + 1];
                                        counter[i]++;
                                        if (counter[i] == 12)
                                            counter[i] = 0;
                                        break;
                                    }
                                    j++;
                                }
                                resultChordArray[i].setText(tempResultChord);
                                if (counter[i] >= 0) {
                                    tranposeValueArray[i].setText("+" + counter[i]);
                                } else {
                                    tranposeValueArray[i].setText("-" + counter[i]);
                                }
                                lastChord[i] = tempResultChord;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Some error Occurred, please check the entered chord and try again", Toast.LENGTH_SHORT).show();

                    }
                }
    }
    public void onClickMasterMinusButton(View view)
    {

        String tempResultChord = "";
        String faulty;
        boolean isPresent;
            for (int i = 0; i < chordValue; i++)
            {
                faulty = "";
                isPresent = false;
                String tempChord = chordArray[i].getText().toString();
                tempChord = tempChord.toUpperCase();
                if (checkForChange[i].equals("")) {
                    checkForChange[i] = tempChord;
                } else {
                    if (!checkForChange[i].equals(tempChord) && !tempChord.equals("a") && !tempChord.equals("A")) {
                        lastChord[i] = "";
                        counter[i] = 0;
                        checkForChange[i] = tempChord;
                    }
                }
                for (int k = 0; k < 12; k++) // Check if the user has entered an invalid chord
                {
                    if (tempChord.equals(chords[k])) {
                        isPresent = true;
                        break;
                    }
                }
                if (!isPresent) {
                    if (i == 0) {
                        faulty = "1st";
                    } else if (i == 1) {
                        faulty = "2nd";
                    } else if (i == 2) {
                        faulty = "3rd";
                    } else {
                        faulty = i + 1 + "th";
                    }
                }
                if (!faulty.equals("")) {
                    Toast.makeText(this, "Invalid Chords at " + faulty + " Position", Toast.LENGTH_SHORT).show();
                    continue;
                }
                    try {

                        if (!chordArray[i].getText().toString().equals("")) {
                            if (lastChord[i].equals("")) {
                                lastChord[i] = tempChord;
                                resultChordArray[i].setText("");
                            } else {
                                tempChord = lastChord[i];
                            }
                            if (tempChord.equals(lastChord[i])) {
                                if (!resultChordArray[i].getText().toString().equals("")) {
                                    resultChordArray[i].setText(tempChord);
                                }
                                int j = 11;
                                while (j >= 0)  // For Positive
                                {
                                    if (tempChord.equals(chords[j])) {
                                        if (j - 1 == -1)
                                            j = 12;

                                        tempResultChord = chords[j - 1];
                                        counter[i]--;
                                        if (counter[i] == -12)
                                            counter[i] = 0;
                                        break;
                                    }
                                    j--;
                                }
                                resultChordArray[i].setText(tempResultChord);
                                if (counter[i] >= 0) {
                                    tranposeValueArray[i].setText("+" + counter[i]);
                                } else {
                                    tranposeValueArray[i].setText("-" + counter[i]);
                                }
                                lastChord[i] = tempResultChord;
                            }
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                        Toast.makeText(this, "Some error Occurred, please check the entered chord and try again", Toast.LENGTH_SHORT).show();
                    }
                }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord);

        chordValue = getIntent().getExtras().getInt("noofchords");

        chord1 = (EditText)findViewById(R.id.chord1);
        chord2 = (EditText)findViewById(R.id.chord2);
        chord3 = (EditText)findViewById(R.id.chord3);
        chord4 = (EditText)findViewById(R.id.chord4);
        chord5 = (EditText)findViewById(R.id.chord5);
        chord6 = (EditText)findViewById(R.id.chord6);
        chord7 = (EditText)findViewById(R.id.chord7);
        chord8 = (EditText)findViewById(R.id.chord8);
        chord9 = (EditText)findViewById(R.id.chord9);
        chord10 = (EditText)findViewById(R.id.chord10);
        chord11 = (EditText)findViewById(R.id.chord11);
        chord12 = (EditText)findViewById(R.id.chord12);

        resultChord1 = (TextView)findViewById(R.id.resultChord1);
        resultChord2 = (TextView)findViewById(R.id.resultChord2);
        resultChord3 = (TextView)findViewById(R.id.resultChord3);
        resultChord4 = (TextView)findViewById(R.id.resultChord4);
        resultChord5 = (TextView)findViewById(R.id.resultChord5);
        resultChord6 = (TextView)findViewById(R.id.resultChord6);
        resultChord7 = (TextView)findViewById(R.id.resultChord7);
        resultChord8 = (TextView)findViewById(R.id.resultChord8);
        resultChord9 = (TextView)findViewById(R.id.resultChord9);
        resultChord10 = (TextView)findViewById(R.id.resultChord10);
        resultChord11 = (TextView)findViewById(R.id.resultChord11);
        resultChord12 = (TextView)findViewById(R.id.resultChord12);

        tranposeValue1 = (TextView)findViewById(R.id.tranposeValue1);
        tranposeValue2 = (TextView)findViewById(R.id.tranposeValue2);
        tranposeValue3 = (TextView)findViewById(R.id.tranposeValue3);
        tranposeValue4 = (TextView)findViewById(R.id.tranposeValue4);
        tranposeValue5 = (TextView)findViewById(R.id.tranposeValue5);
        tranposeValue6 = (TextView)findViewById(R.id.tranposeValue6);
        tranposeValue7 = (TextView)findViewById(R.id.tranposeValue7);
        tranposeValue8 = (TextView)findViewById(R.id.tranposeValue8);
        tranposeValue9 = (TextView)findViewById(R.id.tranposeValue9);
        tranposeValue10 = (TextView)findViewById(R.id.tranposeValue10);
        tranposeValue11 = (TextView)findViewById(R.id.tranposeValue11);
        tranposeValue12 = (TextView)findViewById(R.id.tranposeValue12);

        Button1 = (Button)findViewById(R.id.Button1);
        Button2 = (Button)findViewById(R.id.Button2);
        Button3 = (Button)findViewById(R.id.Button3);
        Button4 = (Button)findViewById(R.id.Button4);
        Button5 = (Button)findViewById(R.id.Button5);
        Button6 = (Button)findViewById(R.id.Button6);
        Button7 = (Button)findViewById(R.id.Button7);
        Button8 = (Button)findViewById(R.id.Button8);
        Button9 = (Button)findViewById(R.id.Button9);
        Button10 = (Button)findViewById(R.id.Button10);
        Button11 = (Button)findViewById(R.id.Button11);
        Button12 = (Button)findViewById(R.id.Button12);
        Button13 = (Button)findViewById(R.id.Button13);
        Button14 = (Button)findViewById(R.id.Button14);
        Button15 = (Button)findViewById(R.id.Button15);
        Button16 = (Button)findViewById(R.id.Button16);
        Button17 = (Button)findViewById(R.id.Button17);
        Button18 = (Button)findViewById(R.id.Button18);
        Button19 = (Button)findViewById(R.id.Button19);
        Button20 = (Button)findViewById(R.id.Button20);
        Button21 = (Button)findViewById(R.id.Button21);
        Button22 = (Button)findViewById(R.id.Button22);
        Button23 = (Button)findViewById(R.id.Button23);
        Button24 = (Button)findViewById(R.id.Button24);

        textViewChords = (TextView)findViewById(R.id.textViewChords);
        textViewTranspose = (TextView)findViewById(R.id.textViewTranspose);
        textViewTranspose.setText("Chords");
        textViewTranspose.setText("Transpose");

        textViewChords.setPaintFlags(textViewChords.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textViewTranspose.setPaintFlags(textViewTranspose.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        positiveButton = new Button[]{Button1, Button3, Button5, Button7, Button9, Button11, Button13, Button15, Button17, Button19, Button21, Button23};
        negativeButton = new Button[]{Button2, Button4, Button6, Button8, Button10, Button12, Button14, Button16, Button18, Button20, Button22, Button24};
        positiveButtonArray = new String[]{String.valueOf(R.id.Button1), String.valueOf(R.id.Button3), String.valueOf(R.id.Button5), String.valueOf(R.id.Button7), String.valueOf(R.id.Button9), String.valueOf(R.id.Button11), String.valueOf(R.id.Button13), String.valueOf(R.id.Button15), String.valueOf(R.id.Button17), String.valueOf(R.id.Button19), String.valueOf(R.id.Button21), String.valueOf(R.id.Button23)};
        negativeButtonArray = new String[]{String.valueOf(R.id.Button2), String.valueOf(R.id.Button4), String.valueOf(R.id.Button6), String.valueOf(R.id.Button8), String.valueOf(R.id.Button10), String.valueOf(R.id.Button12), String.valueOf(R.id.Button14), String.valueOf(R.id.Button16), String.valueOf(R.id.Button18), String.valueOf(R.id.Button20), String.valueOf(R.id.Button22), String.valueOf(R.id.Button24)};
        lastChord = new String[]{"","","","","","","","","","","",""};
        checkForChange = new String[]{"","","","","","","","","","","",""};
        counter = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        chordArray = new EditText[]{chord1, chord2, chord3, chord4, chord5, chord6, chord7, chord8, chord9, chord10, chord11, chord12};
        tranposeValueArray = new TextView[]{tranposeValue1, tranposeValue2, tranposeValue3, tranposeValue4, tranposeValue5, tranposeValue6, tranposeValue7, tranposeValue8, tranposeValue9, tranposeValue10, tranposeValue11, tranposeValue12};
        resultChordArray = new TextView[]{resultChord1, resultChord2, resultChord3, resultChord4, resultChord5, resultChord6, resultChord7, resultChord8, resultChord9, resultChord10, resultChord11, resultChord12};


        for(int i = 0 ;  i < chordValue ; i++ )
        {
            chordArray[i].setVisibility(View.VISIBLE);
            resultChordArray[i].setVisibility(View.VISIBLE);
            tranposeValueArray[i].setVisibility(View.VISIBLE);
            positiveButton[i].setVisibility(View.VISIBLE);
            negativeButton[i].setVisibility(View.VISIBLE);
        }
    }
}