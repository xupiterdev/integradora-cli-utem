package com.integradora;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class Manager extends ReactContextBaseJavaModule{
    public Manager(ReactApplicationContext reactContext){
        super(reactContext);
    }

    @Override
    public String getName(){
        return  "Manager";
    }

    @ReactMethod
    public void greetUser(String name, Callback callback){
        System.out.println("usuario" + name);
        String greeting = "hola cara " + name;

        callback.invoke(greeting);
    }
}
