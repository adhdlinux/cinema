package com.unity3d.services.core.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import org.json.JSONException;
import org.json.JSONObject;

public class BroadcastEventReceiver extends BroadcastReceiver {
    private String _name;

    public BroadcastEventReceiver(String str) {
        this._name = str;
    }

    public void onReceive(Context context, Intent intent) {
        String str;
        String action = intent.getAction();
        if (action != null) {
            if (intent.getDataString() != null) {
                str = intent.getDataString();
            } else {
                str = "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (intent.getExtras() != null) {
                    Bundle extras = intent.getExtras();
                    for (String next : extras.keySet()) {
                        jSONObject.put(next, extras.get(next));
                    }
                }
            } catch (JSONException e2) {
                DeviceLog.debug("JSONException when composing extras for broadcast action " + action + ": " + e2.getMessage());
            }
            WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null && currentApp.isWebAppLoaded()) {
                currentApp.sendEvent(WebViewEventCategory.BROADCAST, BroadcastEvent.ACTION, this._name, action, str, jSONObject);
            }
        }
    }
}
