package qureshi.aaq.com.crackit;

/**
 * Created by asheer.qureshi on 3/17/2018.
 */

import android.content.Context;
import android.net.ConnectivityManager;


public class DetectConnection {
    public static boolean checkInternetConnection(Context context) {

        ConnectivityManager con_manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return (con_manager.getActiveNetworkInfo() != null
                && con_manager.getActiveNetworkInfo().isAvailable()
                && con_manager.getActiveNetworkInfo().isConnected());
    }
}