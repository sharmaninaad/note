package com.example.android.notes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;

import static android.R.id.edit;
import static android.os.Build.VERSION_CODES.M;
import static com.example.android.notes.MainActivity.notes;
import static com.example.android.notes.R.id.editText;
import static com.example.android.notes.R.id.note;

public class notepad extends AppCompatActivity {

    EditText heading;
    EditText editText;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);

        //getting the variables

        heading=(EditText)findViewById(R.id.editText2);
        editText=(EditText)findViewById(R.id.editText);

        //getting the values passed by intent

        Intent my_intent = getIntent();
        i= my_intent.getIntExtra("place",0);

        //checking if the list is empty

        if(i==-1)
        {
            heading.setText("");
            editText.setText("");


        }
        else
        {
            heading.setText(notes.get(i));
            editText.setText(MainActivity.note.get(i));
        }
    }
    public void save(View view)
    {

       // heading=(EditText)findViewById(R.id.editText2);
       // editText=(EditText)findViewById(R.id.editText);


        String head=heading.getText().toString();
        String text=editText.getText().toString();

        Intent my_intent = getIntent();
        i= my_intent.getIntExtra("place",0);

        if(i==-1)
        {
            MainActivity.note.add(text);

            MainActivity.notes.add(head);
        }
        else
        {

            MainActivity.note.remove(i);
            MainActivity.note.add(text);
            MainActivity.notes.remove(i);
            MainActivity.notes.add(head);
        }
      //  MainActivity.
        heading.setText("");
        editText.setText("");

       // MainActivity.arrayAdapter=new ArrayAdapter(this,R.layout.activity_main,notes);
        /*SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.android.notes",MODE_PRIVATE);
        try
        {
            sharedPreferences.edit().putString("that",objectSerializer.serialize(notes)).apply();
        } catch (IOException e)
        {
            e.printStackTrace();
        }*/
        Intent intente=new Intent(this,MainActivity.class);
        startActivity(intente);
    }
}
