package com.novacasa.tictactoe_controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";

    private ImageView buttonUp, buttonDown, buttonRight, buttonLeft, buttonAction;

    private BluetoothService bluetoothService;

    // Create a BroadcastReceiver for ACTION_FOUND.
    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Discovery has found a device. Get the BluetoothDevice
                // object and its info from the Intent.
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_inicial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuItemBluetoothConnect){
            if (bluetoothService.isBluetoothSupported()){
                Log.i(TAG,"O dispositivo suporta BT");
                bluetoothService.isBluetoothEnable(this, 1);
            }else{
                Log.i(TAG,"O dispositivo não suporta BT");

            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothService = new BluetoothService(this);

        buttonAction  = findViewById(R.id.buttonAction);
        buttonDown  = findViewById(R.id.buttonDown);
        buttonLeft  = findViewById(R.id.buttonLeft);
        buttonRight  = findViewById(R.id.buttonRight);
        buttonUp  = findViewById(R.id.buttonUp);

        // Register for broadcasts when a device is discovered.
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(receiver, filter);

        // TODO: Realizar conexão com outros dispositivos
        // https://developer.android.com/guide/topics/connectivity/bluetooth#EnableDiscoverability

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == -1) {
                Toast.makeText(this, "Bluetooth Ligado", Toast.LENGTH_SHORT).show();
            } else {
                Log.i(TAG, "Ação de ativar BT cancelada");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Don't forget to unregister the ACTION_FOUND receiver.
        unregisterReceiver(receiver);
    }
}