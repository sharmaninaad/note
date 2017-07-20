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
import static com.example.android.notes.MainActivity.notes;
import static com.example.android.notes.R.id.editText;

public class notepad extends AppCompatActivity {
    ArrayList<String> note;
    EditText heading;
    EditText editText;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);
        heading=(EditText)findViewById(R.id.editText2);
        editText=(EditText)findViewById(R.id.editText);
        Intent my_intent = getIntent();
        i= my_intent.getIntExtra("place",0);
        if(i==-1)
        {
            heading.setText("");
            editText.setText("");

            heading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(i==-1) {
                        heading.setText("");
                    }

                }
            });

        }
        else
        {
            heading.setText(notes.get(i));
            editText.setText(note.get(i));
        }
    }
    public void save(View view)
    {

       // heading=(EditText)findViewById(R.id.editText2);
       // editText=(EditText)findViewById(R.id.editText);


        String head=heading.getText().toString();
        String text=editText.getText().toString();


        note.add(text);

        MainActivity.notes.add(head);
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
        /*Intent intente=new Intent(this,MainActivity.class);
        startActivity(intente);*/
    }
}
