package com.unity3d.services.core.request;

import android.os.Bundle;
import com.unity3d.services.core.log.DeviceLog;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebRequestRunnable implements Runnable {
    private final String _body;
    private boolean _canceled = false;
    private final int _connectTimeout;
    private WebRequest _currentRequest;
    private final Map<String, List<String>> _headers;
    private final IWebRequestListener _listener;
    private final int _readTimeout;
    private final String _type;
    private final String _url;

    public WebRequestRunnable(String str, String str2, String str3, int i2, int i3, Map<String, List<String>> map, IWebRequestListener iWebRequestListener) {
        this._url = str;
        this._type = str2;
        this._body = str3;
        this._connectTimeout = i2;
        this._readTimeout = i3;
        this._headers = map;
        this._listener = iWebRequestListener;
    }

    private Map<String, List<String>> getResponseHeaders(Bundle bundle) {
        if (bundle.size() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String next : bundle.keySet()) {
            String[] stringArray = bundle.getStringArray(next);
            if (stringArray != null) {
                hashMap.put(next, new ArrayList(Arrays.asList(stringArray)));
            }
        }
        return hashMap;
    }

    private void makeRequest(String str, String str2, Map<String, List<String>> map, String str3, int i2, int i3) throws MalformedURLException {
        if (!this._canceled) {
            WebRequest webRequest = new WebRequest(str, str2, map, i2, i3);
            this._currentRequest = webRequest;
            if (str3 != null) {
                webRequest.setBody(str3);
            }
            try {
                String makeRequest = this._currentRequest.makeRequest();
                if (!this._currentRequest.isCanceled()) {
                    Bundle bundle = new Bundle();
                    for (String next : this._currentRequest.getResponseHeaders().keySet()) {
                        if (next != null && !next.contentEquals("null")) {
                            String[] strArr = new String[this._currentRequest.getResponseHeaders().get(next).size()];
                            for (int i4 = 0; i4 < this._currentRequest.getResponseHeaders().get(next).size(); i4++) {
                                strArr[i4] = (String) this._currentRequest.getResponseHeaders().get(next).get(i4);
                            }
                            bundle.putStringArray(next, strArr);
                        }
                    }
                    if (!this._currentRequest.isCanceled()) {
                        onSucceed(makeRequest, this._currentRequest.getResponseCode(), getResponseHeaders(bundle));
                    }
                }
            } catch (Exception e2) {
                DeviceLog.exception("Error completing request", e2);
                onFailed(e2.getClass().getName() + ": " + e2.getMessage());
            }
        }
    }

    private void onFailed(String str) {
        this._listener.onFailed(this._url, str);
    }

    private void onSucceed(String str, int i2, Map<String, List<String>> map) {
        this._listener.onComplete(this._url, str, i2, map);
    }

    public void run() {
        DeviceLog.debug("Handling request message: " + this._url + " type=" + this._type);
        try {
            makeRequest(this._url, this._type, this._headers, this._body, this._connectTimeout, this._readTimeout);
        } catch (MalformedURLException e2) {
            DeviceLog.exception("Malformed URL", e2);
            onFailed("Malformed URL");
        }
    }

    public void setCancelStatus(boolean z2) {
        WebRequest webRequest;
        this._canceled = z2;
        if (z2 && (webRequest = this._currentRequest) != null) {
            webRequest.cancel();
        }
    }
}
