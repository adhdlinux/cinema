package com.startapp;

import android.app.Activity;
import android.content.Context;
import java.net.URLDecoder;
import java.util.Map;

public abstract class j9 implements k9 {
    private static final String LOG_TAG = "j9";
    public a openListener;

    public interface a {
        boolean onClickEvent(String str);
    }

    public j9(a aVar) {
        this.openListener = aVar;
    }

    public void applyOrientationProperties(Activity activity, n9 n9Var) {
        int i2;
        try {
            int i3 = 0;
            if (activity.getResources().getConfiguration().orientation == 1) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            int i4 = n9Var.f34965c;
            if (i4 == 0) {
                i3 = 1;
            } else if (i4 != 1) {
                if (n9Var.f34964b) {
                    i3 = -1;
                } else {
                    i3 = i2;
                }
            }
            int i5 = hc.f34643a;
            try {
                activity.setRequestedOrientation(i3);
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            y8.a((Context) activity, th);
        }
    }

    public abstract void close();

    public void createCalendarEvent(String str) {
        isFeatureSupported("calendar");
    }

    public void expand(String str) {
    }

    public abstract boolean isFeatureSupported(String str);

    public boolean open(String str) {
        try {
            String trim = URLDecoder.decode(str, "UTF-8").trim();
            if (trim.startsWith("sms")) {
                return openSMS(trim);
            }
            if (trim.startsWith("tel")) {
                return openTel(trim);
            }
            return this.openListener.onClickEvent(trim);
        } catch (Exception unused) {
            return this.openListener.onClickEvent(str);
        }
    }

    public boolean openSMS(String str) {
        isFeatureSupported("sms");
        return true;
    }

    public boolean openTel(String str) {
        isFeatureSupported("tel");
        return true;
    }

    public void playVideo(String str) {
        isFeatureSupported("inlineVideo");
    }

    public void resize() {
    }

    public void setExpandProperties(Map<String, String> map) {
    }

    public abstract void setOrientationProperties(Map<String, String> map);

    public void setResizeProperties(Map<String, String> map) {
    }

    public void storePicture(String str) {
        isFeatureSupported("storePicture");
    }

    public abstract void useCustomClose(String str);
}
