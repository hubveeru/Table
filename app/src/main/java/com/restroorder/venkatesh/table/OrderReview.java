package com.restroorder.venkatesh.table;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;


public class OrderReview extends ActionBarActivity {

    String tableID;
    String[] order = new String[5];
    int index;
    String[] qty = {"0","0","0","0","0"};

    int amount = 0;

    int port = 6653;
    String destn = "192.168.179.102";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_review);
        Bundle b = getIntent().getExtras();
        tableID = b.getString("tableID2");
        order = b.getStringArray("order2");
        index = b.getInt("index2");
        qty = b.getStringArray("qty2");

        TextView vi1 = (TextView) findViewById(R.id.textView22);
        vi1.setText(order[0]);
        TextView vi2 = (TextView) findViewById(R.id.textView23);
        vi2.setText(order[1]);
        TextView vi3 = (TextView) findViewById(R.id.textView24);
        vi3.setText(order[2]);
        TextView vi4 = (TextView) findViewById(R.id.textView25);
        vi4.setText(order[3]);
        TextView vi5 = (TextView) findViewById(R.id.textView26);
        vi5.setText(order[4]);

        TextView qty1 = (TextView) findViewById(R.id.textView31);
        qty1.setText(qty[0]);
        TextView qty2 = (TextView) findViewById(R.id.textView30);
        qty2.setText(qty[1]);
        TextView qty3 = (TextView) findViewById(R.id.textView29);
        qty3.setText(qty[2]);
        TextView qty4 = (TextView) findViewById(R.id.textView28);
        qty4.setText(qty[3]);
        TextView qty5 = (TextView) findViewById(R.id.textView27);
        qty5.setText(qty[4]);

        amount = 160*Integer.parseInt(qty[0]) +
                  70*Integer.parseInt(qty[1]) +
                 100*Integer.parseInt(qty[2]) +
                  40*Integer.parseInt(qty[3]);
        TextView amt = (TextView) findViewById(R.id.textView44);
        amt.setText("Rs." + Integer.toString(amount));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order_review, menu);
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

    public void sendOrder(View v)
    {
        Toast.makeText(this.getApplicationContext(),"Working till stream",Toast.LENGTH_SHORT).show();

        try {
            Socket tab = new Socket(destn, port);
            //SocketAddress addr = tab.getRemoteSocketAddress();
            //tab.connect(addr);
            DataOutputStream out = new DataOutputStream(tab.getOutputStream());
            out.writeUTF(tableID);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*
        Intent i = new Intent(OrderReview.this, OrderPlaced.class);
        i.putExtra("order2", order);
        i.putExtra("tableID2", tableID);
        i.putExtra("index2", index);
        i.putExtra("qty2", qty);
        startActivity(i);
        */
    }
}
