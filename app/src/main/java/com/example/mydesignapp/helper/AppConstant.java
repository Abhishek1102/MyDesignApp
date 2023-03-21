package com.example.mydesignapp.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.widget.Toast;

import com.example.mydesignapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppConstant {

    public static final String IS_LOGIN ="is_login" ;
    public static String user_name = "name";
    public static String user_number = "number";
    public static String user_email = "email";

    public static String LANGUAGE = "user_language";

    public static boolean isOnline(final Context ctx) {
        if (ctx != null) {
            final ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    final NetworkInfo ni = cm.getActiveNetworkInfo();
                    Network activeNetwork = cm.getActiveNetwork();
                    NetworkCapabilities caps = cm.getNetworkCapabilities(activeNetwork);
                    if (caps != null) {
                        boolean vpnInUse = caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN);
                        if (vpnInUse) {
                            Toast.makeText(ctx, ctx.getString(R.string.vpn), Toast.LENGTH_SHORT).show();
                            return false;
                        } else {
                            if (ni != null) {
                                if (ni.isConnectedOrConnecting()) {
                                    return true;
                                } else {
                                    Toast.makeText(ctx, ctx.getString(R.string.nointernet), Toast.LENGTH_SHORT).show();
                                    return false;
                                }
                            } else {
                                Toast.makeText(ctx, ctx.getString(R.string.nointernet), Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        }
                    } else {
                        Toast.makeText(ctx, ctx.getString(R.string.nointernet), Toast.LENGTH_SHORT).show();
                        return false;
                    }

                } else {
                    NetworkInfo networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_VPN);
                    if (networkInfo != null) {
                        if (networkInfo.isConnectedOrConnecting()) {
                            Toast.makeText(ctx, "Please disconnect VPN and try again.", Toast.LENGTH_SHORT).show();
                            return false;
                        } else {
                            final NetworkInfo ni = cm.getActiveNetworkInfo();
                            if (ni != null) {
                                if (ni.isConnectedOrConnecting()) {
                                    return true;
                                } else {
                                    Toast.makeText(ctx, ctx.getString(R.string.nointernet), Toast.LENGTH_SHORT).show();
                                    return false;
                                }
                            } else {
                                Toast.makeText(ctx, ctx.getString(R.string.nointernet), Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        }
                    } else {
                        Toast.makeText(ctx, ctx.getString(R.string.nointernet), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(new Date());
        return time;
    }


    public static void setLanguage(Context activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("LANGUAGE_SETTING", Context.MODE_PRIVATE);
        String languageToLoad;
        if (sharedPreferences.getString(AppConstant.LANGUAGE, "en").equalsIgnoreCase("en")) {
            languageToLoad = "en"; // your language
        } else {
            languageToLoad = "gu";
        }
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        activity.getResources().updateConfiguration(config,
                activity.getResources().getDisplayMetrics());
    }
}
