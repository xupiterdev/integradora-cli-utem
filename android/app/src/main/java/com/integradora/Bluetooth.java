package com.integradora;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Set;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;

import com.facebook.react.bridge.WritableArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Bluetooth extends ReactContextBaseJavaModule {

    private final static int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;

    private BluetoothAdapter BA;

    public  Bluetooth (ReactApplicationContext reactContext){
        super(reactContext);
        BA = BluetoothAdapter.getDefaultAdapter();
    }

    @Override
    public String getName(){ return "Bluetooth"; }


    @ReactMethod
    public void isEneable(Promise promise){
        promise.resolve(BA.isEnabled() ? true : false);
    }

    @ReactMethod
    public void on(Promise promise){
        if (!BA.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            getCurrentActivity().startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }

    @ReactMethod
    public void getDevices(Promise promise){
        Set<BluetoothDevice> pairedDevices = BA.getBondedDevices();

        if(pairedDevices.size() > 0){
            JSONArray devicesList = new JSONArray();

            for (BluetoothDevice device : pairedDevices){

                String name = device.getName();
                String address = device.getAddress();

                try {
                    JSONObject json = new JSONObject();
                    json.put("name", name);
                    json.put("address", address);

                    devicesList.put(json);
                }catch (JSONException e){}
            }

            WritableArray devicesPromise = Arguments.createArray();
            devicesPromise.pushString(devicesList.toString());

            promise.resolve(devicesList.toString());
        }
    }
}
