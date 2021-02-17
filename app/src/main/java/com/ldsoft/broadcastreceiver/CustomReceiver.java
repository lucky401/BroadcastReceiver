package com.ldsoft.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID+"ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if(intentAction!=null){
            String toasMessage = "";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toasMessage=context.getString(R.string.power_connected);
                    break; 
                case Intent.ACTION_POWER_DISCONNECTED:
                    toasMessage=context.getString(R.string.power_disconnected);
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toasMessage=intent.getStringExtra("DATA");
                    break;
            }
            Toast.makeText(context, toasMessage, Toast.LENGTH_SHORT).show();
        }
    }
}