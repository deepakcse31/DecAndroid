package com.example.decandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;


public class AirplaneModeChanger extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (isAirplaneModeOn(context.getApplicationContext())){
            Toast.makeText(context,"Airplane Mode is On",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context,"Airplane Mode is Off",Toast.LENGTH_LONG).show();
        }

    }
    private static boolean isAirplaneModeOn(Context context){
        return Settings.System.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0) !=0;
    }
}
