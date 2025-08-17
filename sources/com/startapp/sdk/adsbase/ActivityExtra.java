package com.startapp.sdk.adsbase;

import android.app.Activity;
import com.startapp.o6;
import java.io.Serializable;

public class ActivityExtra implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean isActivityFullScreen;

    public ActivityExtra(Activity activity) {
        a(o6.a(activity));
    }

    public boolean a() {
        return this.isActivityFullScreen;
    }

    public final void a(boolean z2) {
        this.isActivityFullScreen = z2;
    }
}
