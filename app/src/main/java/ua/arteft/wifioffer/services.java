package ua.arteft.wifioffer;

import android.content.Context;
import android.net.wifi.*;
import android.content.Intent;
import android.os.IBinder;
import android.app.Service;
import android.content.*;


public class services extends Service {

    private WifiManager manager;
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int state = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
          switch (state){
                case WifiManager.WIFI_STATE_ENABLING:
                    wifioff();
                    break;
                case WifiManager.WIFI_STATE_ENABLED:
                    wifioff();
                    break;
            }
        }
    };


    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
    public void onCreate() {
        super.onCreate();
        this.registerReceiver(this.receiver, new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION));
        wifioff();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.receiver);

    }

    void wifioff() {
        manager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        manager.setWifiEnabled(false);

    }
}
