package com.restroorder.venkatesh.table;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;


public class MainActivity3 extends ActionBarActivity {

    String tableID;
    String[] order = {" "," "," "," "," "};
    int index = 0;
    String[] qty = {"0","0","0","0","0"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);
        Bundle b = getIntent().getExtras();
        tableID = b.getString("tableID2");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity3, menu);
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

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox:
                if (checked) {
                    order[0] = "Pizza";
                    EditText qty1 = (EditText)findViewById(R.id.editText5);
                    qty[0] = qty1.getText().toString();
                    if(qty[0].matches("")){
                        qty[0] ="1";
                    }

                }
                else {
                    order[0] = " ";
                    qty[0] = "0";
                }
                break;
            case R.id.checkBox2:
                if (checked) {
                    order[1] = "Burger";
                    EditText qty2 = (EditText)findViewById(R.id.editText6);
                    qty[1] = qty2.getText().toString();
                    if(qty[1].matches("")){
                        qty[1] ="1";
                    }
                }
                else {
                    order[1] = " ";
                    qty[1] = "0";
                }
                break;
            case R.id.checkBox3:
                if (checked) {
                    order[2] = "Hot Dog";
                    EditText qty3 = (EditText)findViewById(R.id.editText7);
                    qty[2] = qty3.getText().toString();
                    if(qty[2].matches("")){
                        qty[2] ="1";
                    }
                }
                else {
                    order[2] = " ";
                    qty[2] = "0";
                }
                break;
            case R.id.checkBox4:
                if (checked) {
                    order[3] = "Samosa";
                    qty[3] = "1";
                    EditText qty4 = (EditText)findViewById(R.id.editText8);
                    qty[3] = qty4.getText().toString();
                    if(qty[3].matches("")){
                        qty[3] ="1";
                    }
                }
                else {
                    order[3] = " ";
                    qty[3] = "0";
                }
                break;
        }
    }

    public void orderReview(View v)
    {
        Intent i = new Intent(MainActivity3.this, OrderReview.class);
        i.putExtra("order2", order);
        i.putExtra("tableID2", tableID);
        i.putExtra("index2", index);
        i.putExtra("qty2", qty);
        startActivity(i);
    }
}
