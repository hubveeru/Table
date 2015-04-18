package com.restroorder.venkatesh.table;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class OrderPlaced extends ActionBarActivity {

    String tableID;
    String[] order = new String[5];
    int index;
    String[] qty = {"0","0","0","0","0"};

    int amount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placed);
        Bundle b = getIntent().getExtras();
        tableID = b.getString("tableID2");
        order = b.getStringArray("order2");
        index = b.getInt("index2");
        qty = b.getStringArray("qty2");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order_placed, menu);
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
    public void getBill(View v)
    {
        Intent i = new Intent(this, BillDisplay.class);
        startActivity(i);

    }
    public void showMenu(View v)
    {
        Intent i = new Intent(this, MainActivity3.class);
        startActivity(i);
    }
}
