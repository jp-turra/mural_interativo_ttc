package com.novacasa.tictactoe_controller;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Set;

public class BluetoothService {

    private final static String TAG = "BluetoothService";

    private BluetoothAdapter bluetoothAdapter;
    private Context context;

    public BluetoothService (Context context) {
        this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.context = context;
    }
    // TODO: Fazer verificação de mudança de estado do BT, utilizar broadcast.

    public boolean isBluetoothSupported () {
        boolean hold = false;

        if(bluetoothAdapter != null){
            hold = true;
        }else {
            Log.w(TAG, "Device doesn't have support for bluetooth.\nbltAdapter="+bluetoothAdapter);
        }

        return hold;
    }

    public void isBluetoothEnable (Activity activity, int REQUEST_ENABLE_BT){
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            activity.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }

    public void getPairedDevices () {
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        List<String> deviceList = new ArrayList<>();
        List<String> deviceMacList = new ArrayList<>();
        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                deviceList.add(device.getName());
                deviceMacList.add(device.getAddress()); // MAC address
            }

        }

    }
    public void searchDevice () {
        bluetoothAdapter.startDiscovery();

    }


}
