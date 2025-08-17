package com.applovin.impl.adview.activity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.adview.activity.b.a;
import com.applovin.impl.adview.o;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.e.p;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements ServiceConnection {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m f13854a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final v f13855b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<AppLovinFullscreenActivity> f13856c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f13857d = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Messenger f13858e;

    /* renamed from: com.applovin.impl.adview.activity.a$a  reason: collision with other inner class name */
    private class C0007a implements AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdVideoPlaybackListener {
        private C0007a() {
        }

        private void a(Bundle bundle, FullscreenAdService.b bVar) {
            Message obtain = Message.obtain((Handler) null, bVar.a());
            if (bundle != null) {
                obtain.setData(bundle);
            }
            try {
                a.this.f13858e.send(obtain);
            } catch (RemoteException e2) {
                if (v.a()) {
                    v b2 = a.this.f13855b;
                    b2.b("AppLovinFullscreenActivity", "Failed to forward callback (" + bVar.a() + ")", e2);
                }
            }
        }

        private void a(FullscreenAdService.b bVar) {
            a((Bundle) null, bVar);
        }

        public void adClicked(AppLovinAd appLovinAd) {
            a(FullscreenAdService.b.AD_CLICKED);
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            a(FullscreenAdService.b.AD_DISPLAYED);
        }

        public void adHidden(AppLovinAd appLovinAd) {
            a(FullscreenAdService.b.AD_HIDDEN);
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            a(FullscreenAdService.b.AD_VIDEO_STARTED);
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d2, boolean z2) {
            Bundle bundle = new Bundle();
            bundle.putDouble("percent_viewed", d2);
            bundle.putBoolean("fully_watched", z2);
            a(bundle, FullscreenAdService.b.AD_VIDEO_ENDED);
        }
    }

    private static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<a> f13870a;

        private b(a aVar) {
            this.f13870a = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            a aVar;
            if (message.what != FullscreenAdService.b.AD.a() || (aVar = this.f13870a.get()) == null) {
                super.handleMessage(message);
                return;
            }
            aVar.a(com.applovin.impl.sdk.ad.b.a(message.getData().getInt(FullscreenAdService.DATA_KEY_AD_SOURCE)), message.getData().getString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE));
        }
    }

    public a(AppLovinFullscreenActivity appLovinFullscreenActivity, m mVar) {
        this.f13854a = mVar;
        this.f13855b = mVar.A();
        this.f13856c = new WeakReference<>(appLovinFullscreenActivity);
    }

    /* access modifiers changed from: private */
    public void a() {
        AppLovinFullscreenActivity appLovinFullscreenActivity = this.f13856c.get();
        if (appLovinFullscreenActivity != null) {
            if (v.a()) {
                this.f13855b.b("AppLovinFullscreenActivity", "Dismissing...");
            }
            appLovinFullscreenActivity.dismiss();
        } else if (v.a()) {
            this.f13855b.e("AppLovinFullscreenActivity", "Unable to dismiss parent Activity");
        }
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.b bVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.applovin.impl.sdk.ad.b bVar2 = bVar;
            this.f13854a.S().a((com.applovin.impl.sdk.e.a) new p(jSONObject, d.a(JsonUtils.getString(jSONObject, "zone_id", "")), bVar2, new AppLovinAdLoadListener() {
                public void adReceived(final AppLovinAd appLovinAd) {
                    final AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) a.this.f13856c.get();
                    boolean a2 = v.a();
                    if (appLovinFullscreenActivity != null) {
                        if (a2) {
                            a.this.f13855b.b("AppLovinFullscreenActivity", "Presenting ad...");
                        }
                        final C0007a aVar = new C0007a();
                        com.applovin.impl.adview.activity.b.a.a((e) appLovinAd, aVar, aVar, aVar, a.this.f13854a, appLovinFullscreenActivity, new a.C0008a() {
                            public void a(com.applovin.impl.adview.activity.b.a aVar) {
                                appLovinFullscreenActivity.setPresenter(aVar);
                                aVar.d();
                            }

                            public void a(String str, Throwable th) {
                                o.a((e) appLovinAd, aVar, str, th, appLovinFullscreenActivity);
                            }
                        });
                    } else if (a2) {
                        v b2 = a.this.f13855b;
                        b2.e("AppLovinFullscreenActivity", "Unable to present ad, parent activity has been GC'd - " + appLovinAd);
                    }
                }

                public void failedToReceiveAd(int i2) {
                    a.this.a();
                }
            }, this.f13854a));
        } catch (JSONException e2) {
            if (v.a()) {
                v vVar = this.f13855b;
                vVar.b("AppLovinFullscreenActivity", "Unable to process ad: " + str, e2);
            }
            a();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f13857d.compareAndSet(false, true)) {
            if (v.a()) {
                v vVar = this.f13855b;
                vVar.b("AppLovinFullscreenActivity", "Fullscreen ad service connected to " + componentName);
            }
            this.f13858e = new Messenger(iBinder);
            Message obtain = Message.obtain((Handler) null, FullscreenAdService.b.AD.a());
            obtain.replyTo = new Messenger(new b());
            try {
                if (v.a()) {
                    this.f13855b.b("AppLovinFullscreenActivity", "Requesting ad from FullscreenAdService...");
                }
                this.f13858e.send(obtain);
            } catch (RemoteException e2) {
                if (v.a()) {
                    this.f13855b.b("AppLovinFullscreenActivity", "Failed to send ad request message to FullscreenAdService", e2);
                }
                a();
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f13857d.compareAndSet(true, false) && v.a()) {
            v vVar = this.f13855b;
            vVar.b("AppLovinFullscreenActivity", "FullscreenAdService disconnected from " + componentName);
        }
    }
}
