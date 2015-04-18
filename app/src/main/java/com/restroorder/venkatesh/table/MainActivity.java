package com.restroorder.venkatesh.table;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

    public void getTableID(View v)
    {
        EditText tID = (EditText)findViewById(R.id.editText);
        String tableID = tID.getText().toString();
        TextView vi = (TextView)findViewById(R.id.textView20);
        vi.setText(tableID);
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        i.putExtra("tableID2", tableID);
        startActivity(i);
    }

}

