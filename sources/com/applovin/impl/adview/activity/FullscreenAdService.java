package com.applovin.impl.adview.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.o;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAd;

public class FullscreenAdService extends Service {
    public static final String DATA_KEY_AD_SOURCE = "ad_source";
    public static final String DATA_KEY_RAW_FULL_AD_RESPONSE = "raw_full_ad_response";
    private static final String TAG = "FullscreenAdService";

    private static class a extends Handler {
        private a() {
        }

        public void handleMessage(Message message) {
            try {
                o oVar = AppLovinFullscreenActivity.parentInterstitialWrapper;
                if (oVar != null) {
                    e a2 = oVar.a();
                    int i2 = message.what;
                    b bVar = b.AD;
                    if (i2 == bVar.a()) {
                        Bundle bundle = new Bundle();
                        bundle.putString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE, a2.getRawFullResponse());
                        bundle.putInt(FullscreenAdService.DATA_KEY_AD_SOURCE, a2.getSource().a());
                        Message obtain = Message.obtain((Handler) null, bVar.a());
                        obtain.setData(bundle);
                        message.replyTo.send(obtain);
                    } else if (message.what == b.AD_DISPLAYED.a()) {
                        j.a(oVar.c(), (AppLovinAd) a2);
                    } else if (message.what == b.AD_CLICKED.a()) {
                        j.a(oVar.d(), (AppLovinAd) a2);
                    } else if (message.what == b.AD_VIDEO_STARTED.a()) {
                        j.a(oVar.b(), (AppLovinAd) a2);
                    } else if (message.what == b.AD_VIDEO_ENDED.a()) {
                        Bundle data = message.getData();
                        j.a(oVar.b(), (AppLovinAd) a2, data.getDouble("percent_viewed"), data.getBoolean("fully_watched"));
                    } else if (message.what == b.AD_HIDDEN.a()) {
                        j.b(oVar.c(), (AppLovinAd) a2);
                    } else {
                        super.handleMessage(message);
                    }
                } else if (!Utils.getBooleanForProbability(1)) {
                    super.handleMessage(message);
                } else {
                    throw new RuntimeException("parentWrapper is null for " + message.what);
                }
            } catch (RemoteException e2) {
                if (v.a()) {
                    v.c(FullscreenAdService.TAG, "Failed to respond to Fullscreen Activity in another process with ad", e2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public enum b {
        AD(0),
        AD_DISPLAYED(1),
        AD_CLICKED(2),
        AD_VIDEO_STARTED(3),
        AD_VIDEO_ENDED(4),
        AD_HIDDEN(5);
        

        /* renamed from: g  reason: collision with root package name */
        private final int f13853g;

        private b(int i2) {
            this.f13853g = i2;
        }

        public int a() {
            return this.f13853g;
        }
    }

    public IBinder onBind(Intent intent) {
        return new Messenger(new a()).getBinder();
    }
}
