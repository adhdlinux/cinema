package com.facebook.ads.internal.view;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.adapters.ae;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.settings.a;
import com.facebook.ads.internal.view.f.a;
import com.facebook.ads.internal.view.f.b.b;
import com.facebook.ads.internal.view.f.b.c;
import com.facebook.ads.internal.view.f.b.h;
import com.facebook.ads.internal.view.f.b.i;
import com.facebook.ads.internal.view.f.b.k;
import java.util.UUID;

public class j extends a {

    /* renamed from: b  reason: collision with root package name */
    private final String f21623b = UUID.randomUUID().toString();

    /* renamed from: c  reason: collision with root package name */
    private final k f21624c = new k() {
        public void a(com.facebook.ads.internal.view.f.b.j jVar) {
            if (j.this.f21635n != null) {
                j.this.f21635n.c();
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final i f21625d = new i() {
        public void a(h hVar) {
            if (j.this.f21635n != null) {
                j.this.f21635n.b();
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final c f21626e = new c() {
        public void a(b bVar) {
            if (j.this.f21635n != null) {
                j.this.f21635n.h();
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final ae f21627f;

    /* renamed from: g  reason: collision with root package name */
    private com.facebook.ads.internal.m.c f21628g;

    /* renamed from: h  reason: collision with root package name */
    private com.facebook.ads.internal.view.f.b f21629h;

    /* renamed from: i  reason: collision with root package name */
    private String f21630i;

    /* renamed from: j  reason: collision with root package name */
    private Uri f21631j;

    /* renamed from: k  reason: collision with root package name */
    private String f21632k;

    /* renamed from: l  reason: collision with root package name */
    private String f21633l;

    /* renamed from: m  reason: collision with root package name */
    private String f21634m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public k f21635n;

    /* renamed from: o  reason: collision with root package name */
    private NativeAd f21636o;

    public j(Context context) {
        super(context);
        this.f21627f = new ae(this, context);
        t();
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21627f = new ae(this, context);
        t();
    }

    public j(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21627f = new ae(this, context);
        t();
    }

    @TargetApi(21)
    public j(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f21627f = new ae(this, context);
        t();
    }

    private void a(Intent intent) {
        if (this.f21630i == null || this.f21629h == null) {
            throw new IllegalStateException("Must setVideoReportUri first.");
        } else if (this.f21631j == null && this.f21633l == null) {
            throw new IllegalStateException("Must setVideoURI or setVideoMPD first.");
        } else {
            intent.putExtra("useNativeCtaButton", this.f21634m);
            intent.putExtra(AudienceNetworkActivity.VIEW_TYPE, a.C0036a.FULL_SCREEN_VIDEO);
            intent.putExtra(AudienceNetworkActivity.VIDEO_URL, this.f21631j.toString());
            String str = this.f21632k;
            if (str == null) {
                str = "";
            }
            intent.putExtra(AudienceNetworkActivity.CLIENT_TOKEN, str);
            intent.putExtra(AudienceNetworkActivity.VIDEO_MPD, this.f21633l);
            intent.putExtra(AudienceNetworkActivity.PREDEFINED_ORIENTATION_KEY, 13);
            intent.putExtra(AudienceNetworkActivity.VIDEO_SEEK_TIME, getCurrentPositionInMillis());
            intent.putExtra(AudienceNetworkActivity.AUDIENCE_NETWORK_UNIQUE_ID_EXTRA, this.f21623b);
            intent.putExtra(AudienceNetworkActivity.VIDEO_LOGGER, this.f21629h.g());
            intent.putExtra("video_time_polling_interval", getVideoProgressReportIntervalMs());
            intent.addFlags(268435456);
        }
    }

    private void t() {
        getEventBus().a((T[]) new f[]{this.f21624c, this.f21625d, this.f21626e});
    }

    public void a() {
        Context context = getContext();
        Intent intent = new Intent(context, AudienceNetworkActivity.class);
        a(intent);
        try {
            a(false);
            setVisibility(8);
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            try {
                intent.setClass(context, InterstitialAdActivity.class);
                context.startActivity(intent);
            } catch (Exception e2) {
                com.facebook.ads.internal.j.b.a(com.facebook.ads.internal.j.a.a(e2, "Error occurred while loading fullscreen video activity."));
            }
        }
    }

    public void a(String str, String str2) {
        com.facebook.ads.internal.view.f.b bVar = this.f21629h;
        if (bVar != null) {
            bVar.a();
        }
        this.f21632k = str2;
        this.f21630i = str;
        this.f21629h = (str == null || str2 == null) ? null : new com.facebook.ads.internal.view.f.b(getContext(), this.f21628g, this, str2);
    }

    public void b() {
        NativeAd nativeAd = this.f21636o;
        if (nativeAd != null) {
            nativeAd.onCtaBroadcast();
        }
    }

    public k getListener() {
        return this.f21635n;
    }

    public String getUniqueId() {
        return this.f21623b;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f21627f.a();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f21627f.b();
        super.onDetachedFromWindow();
    }

    public void setAdEventManager(com.facebook.ads.internal.m.c cVar) {
        this.f21628g = cVar;
    }

    public void setEnableBackgroundVideo(boolean z2) {
        this.f21236a.setBackgroundPlaybackEnabled(z2);
    }

    public void setListener(k kVar) {
        this.f21635n = kVar;
    }

    public void setNativeAd(NativeAd nativeAd) {
        this.f21636o = nativeAd;
    }

    public void setVideoCTA(String str) {
        this.f21634m = str;
    }

    public void setVideoMPD(String str) {
        if (str == null || this.f21629h != null) {
            this.f21633l = str;
            super.setVideoMPD(str);
            return;
        }
        throw new IllegalStateException("Must setVideoReportUri first.");
    }

    public void setVideoURI(Uri uri) {
        if (uri == null || this.f21629h != null) {
            this.f21631j = uri;
            super.setVideoURI(uri);
            return;
        }
        throw new IllegalStateException("Must setVideoReportUri first.");
    }
}
