package com.startapp;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.ads.splash.SplashScreen;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.io.Serializable;

public class y4 extends v3 {

    /* renamed from: v  reason: collision with root package name */
    public SplashConfig f36943v = null;

    /* renamed from: w  reason: collision with root package name */
    public SplashScreen f36944w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f36945x = false;

    /* renamed from: y  reason: collision with root package name */
    public boolean f36946y = false;

    public boolean a(int i2, KeyEvent keyEvent) {
        if (this.f36945x) {
            if (i2 == 25) {
                if (!this.f36946y) {
                    this.f36946y = true;
                    SplashScreen splashScreen = this.f36944w;
                    splashScreen.f36056g = true;
                    splashScreen.f36051b.f36034g = true;
                    Toast.makeText(this.f36704b, "Test Mode", 0).show();
                    return true;
                }
            } else if (i2 == 24 && this.f36946y) {
                this.f36704b.finish();
                return true;
            }
        }
        return i2 == 4;
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
        AdPreferences adPreferences;
        if (this.f36943v != null) {
            Serializable serializableExtra = this.f36703a.getSerializableExtra("AdPreference");
            if (serializableExtra != null) {
                adPreferences = (AdPreferences) serializableExtra;
            } else {
                adPreferences = new AdPreferences();
            }
            this.f36945x = this.f36703a.getBooleanExtra("testMode", false);
            SplashScreen splashScreen = new SplashScreen(this.f36704b, this.f36943v, adPreferences);
            this.f36944w = splashScreen;
            SplashEventHandler splashEventHandler = splashScreen.f36051b;
            wb.a(splashEventHandler.f36028a).a(splashEventHandler.f36038k, new IntentFilter("com.startapp.android.adInfoWasClickedBroadcastListener"));
            if (!splashScreen.c()) {
                splashScreen.f36055f.post(splashScreen.f36059j);
            } else {
                splashScreen.f36055f.postDelayed(splashScreen.f36059j, 100);
            }
        }
    }

    public void g() {
        SplashEventHandler.SplashState splashState;
        SplashScreen splashScreen = this.f36944w;
        if (splashScreen != null) {
            splashScreen.f36055f.removeCallbacks(splashScreen.f36059j);
            SplashEventHandler splashEventHandler = splashScreen.f36051b;
            SplashEventHandler.SplashState splashState2 = splashEventHandler.f36036i;
            if (splashState2 != SplashEventHandler.SplashState.DISPLAYED && splashState2 != (splashState = SplashEventHandler.SplashState.DO_NOT_DISPLAY)) {
                splashEventHandler.f36036i = splashState;
                if (splashEventHandler.f36031d) {
                    splashEventHandler.b();
                }
            }
        }
    }

    public void h() {
    }

    public void a(Bundle bundle) {
        this.f36943v = (SplashConfig) this.f36703a.getSerializableExtra("SplashConfig");
    }
}
