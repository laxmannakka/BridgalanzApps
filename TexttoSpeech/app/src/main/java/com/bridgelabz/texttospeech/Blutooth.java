package com.bridgelabz.texttospeech;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class Blutooth extends AppCompatActivity {
    int REQUEST_ENABLE_BT = 1;
    Button on, off, showdevices, search;
    BluetoothAdapter mBluetoothAdapter;
    Set<BluetoothDevice> pairedDevices;
    ListView lv;
    ArrayList list;
     BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blutooth);
        on = (Button) findViewById(R.id.on);
        off = (Button) findViewById(R.id.off);
        showdevices = (Button) findViewById(R.id.list);
        search = (Button) findViewById(R.id.serach);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        lv = (ListView) findViewById(R.id.listview);
        lv.setVisibility(View.INVISIBLE);
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mBluetoothAdapter == null) {
                    Toast.makeText(getApplicationContext(), "Message Blootoothnot supported", Toast.LENGTH_LONG).show();
                }
                if (mBluetoothAdapter.isEnabled()) {
                    Toast.makeText(getApplicationContext(), "Turned on", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Blutooth is starting ... on", Toast.LENGTH_LONG).show();
                    mBluetoothAdapter.disable();
                    Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(turnOn, 0);
                }

            }
        });


        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBluetoothAdapter.disable();
                Toast.makeText(getApplicationContext(), "Turned off", Toast.LENGTH_LONG).show();

            }
        });
        showdevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv.setVisibility(View.VISIBLE);
                pairedDevices = mBluetoothAdapter.getBondedDevices();
                list = new ArrayList();
                for (BluetoothDevice bt : pairedDevices)
                    list.add(bt.getName());
                Toast.makeText(getApplicationContext(), "Showing Paired Devices", Toast.LENGTH_SHORT).show();

                final ArrayAdapter adapter = new ArrayAdapter(Blutooth.this, android.R.layout.simple_list_item_1, list);
                lv.setAdapter(adapter);


            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv.setVisibility(View.VISIBLE);

                if (mBluetoothAdapter.isDiscovering()) {
                    mBluetoothAdapter.cancelDiscovery();
                }
                IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                registerReceiver(mReceiver, filter);
                mBluetoothAdapter.startDiscovery();
            }

            final BroadcastReceiver mReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    // When discovery finds a device
                    if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                        // Get the BluetoothDevice object from the Intent
                        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                        // Add the name and address to an array adapter to show in a ListView
                        list.add(device.getName() + "\t" + device.getAddress());
                        Toast.makeText(getApplicationContext(), "Scanned name is " + device.getName(), Toast.LENGTH_LONG).show();
                    }
                    final ArrayAdapter adapter = new ArrayAdapter(Blutooth.this, android.R.layout.simple_list_item_1, list);
                    lv.setAdapter(adapter);
                }

            };
        });


    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }



    public void discover() {
        Intent discoverableIntent = new
                Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivity(discoverableIntent);
    }


}
