package com.example.android.notes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {
    static  ArrayList<String> notes=new ArrayList<>();

      ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView)findViewById(R.id.list);
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,notes);
        listView.setAdapter(arrayAdapter);


        //listView.setAdapter(arrayAdapter);
        /*SharedPreferences sharedPreferences=this.getSharedPreferences("package com.example.android.notes",MODE_PRIVATE);
        notes.clear();
        try {

            notes=(ArrayList<String>) objectSerializer.deserialize(sharedPreferences.getString("that",objectSerializer.serialize(new ArrayList<String>())));




        } catch (IOException e)
        {
            e.printStackTrace();
        }*/


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(MainActivity.this,notepad.class);
                intent.putExtra("place",position);
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus, menu);
        return true;

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.note)
        {

            Intent intent =new Intent(this,notepad.class);
            intent.putExtra("place",-1);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}
