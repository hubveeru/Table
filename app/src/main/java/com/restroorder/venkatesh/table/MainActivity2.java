package com.restroorder.venkatesh.table;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity2 extends ActionBarActivity {

    String tableID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        Bundle b = getIntent().getExtras();
        tableID = b.getString("tableID2");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showMenu(View v)
    {
        Intent i = new Intent(MainActivity2.this, MainActivity3.class);
        i.putExtra("tableID2", tableID);
        startActivity(i);

    }
    public void showAboutRestaurant(View v)
    {
        Intent i = new Intent(this, AboutRestaurant.class);
        startActivity(i);
    }
}
