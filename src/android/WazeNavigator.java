package com.adaltojunior.cordova.plugin;


import org.apache.cordova.CordovaPlugin;

import org.apache.cordova.CallbackContext;

import android.content.Intent;

import org.apache.cordova.LOG;
import org.json.JSONException;
import org.json.JSONArray;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.lang.String;


public class WazeNavigator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("navigateByWaze")) {
            String toLat = data.getString(2);
            String toLng = data.getString(3);

            openUrlIntentByApplication(toLat, toLng);

            return true;

        } else {

            return false;

        }
    }

    private void openUrlIntentByApplication(String toLat, String toLng) {

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("geo:"+toLat+","+toLng));
        this.cordova.getActivity().startActivity(intent);

    }
}