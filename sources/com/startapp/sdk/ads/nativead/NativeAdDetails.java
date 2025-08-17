package com.startapp.sdk.ads.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.startapp.la;
import com.startapp.me;
import com.startapp.o6;
import com.startapp.ob;
import com.startapp.q4;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.nativead.StartAppNativeAd;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.z6;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NativeAdDetails implements NativeAdInterface {

    /* renamed from: a  reason: collision with root package name */
    public final AdDetails f35996a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f35997b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f35998c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35999d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36000e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f36001f;

    /* renamed from: g  reason: collision with root package name */
    public ob f36002g;

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<View> f36003h = new WeakReference<>((Object) null);

    /* renamed from: i  reason: collision with root package name */
    public View.OnAttachStateChangeListener f36004i;

    /* renamed from: j  reason: collision with root package name */
    public NativeAdDisplayListener f36005j;

    /* renamed from: k  reason: collision with root package name */
    public me f36006k;

    /* renamed from: l  reason: collision with root package name */
    public final z6.a f36007l = new a();

    public class a implements z6.a {
        public a() {
        }

        public void onSent() {
            NativeAdDetails nativeAdDetails = NativeAdDetails.this;
            nativeAdDetails.f35999d = true;
            NativeAdDisplayListener nativeAdDisplayListener = nativeAdDetails.f36005j;
            if (nativeAdDisplayListener != null) {
                nativeAdDisplayListener.adDisplayed(nativeAdDetails);
            }
        }
    }

    public class b implements la.b {

        /* renamed from: a  reason: collision with root package name */
        public int f36009a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f36010b;

        public b(Runnable runnable) {
            this.f36010b = runnable;
        }

        public void a(Bitmap bitmap, int i2) {
            if (i2 == 0) {
                NativeAdDetails.this.f35997b = bitmap;
            } else {
                NativeAdDetails.this.f35998c = bitmap;
            }
            int i3 = this.f36009a + 1;
            this.f36009a = i3;
            if (i3 == 2) {
                this.f36010b.run();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            NativeAdDetails.a(NativeAdDetails.this, view);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            NativeAdDetails.a(NativeAdDetails.this, view);
        }
    }

    public class e implements ob.a {
        public e() {
        }
    }

    public NativeAdDetails(AdDetails adDetails) {
        this.f35996a = adDetails;
    }

    public static void a(NativeAdDetails nativeAdDetails, View view) {
        nativeAdDetails.getClass();
        Context context = view.getContext();
        int ordinal = nativeAdDetails.getCampaignAction().ordinal();
        if (ordinal == 0) {
            o6.a(nativeAdDetails.getPackageName(), nativeAdDetails.f35996a.l(), nativeAdDetails.f35996a.g(), context, new TrackingParams(nativeAdDetails.f36001f));
        } else if (ordinal == 1) {
            boolean a2 = o6.a(context, AdPreferences.Placement.INAPP_NATIVE);
            if (!nativeAdDetails.f35996a.A() || a2) {
                o6.a(context, nativeAdDetails.f35996a.g(), nativeAdDetails.f35996a.u(), new TrackingParams(nativeAdDetails.f36001f), nativeAdDetails.f35996a.B() && !a2, false);
            } else {
                o6.a(context, nativeAdDetails.f35996a.g(), nativeAdDetails.f35996a.u(), nativeAdDetails.f35996a.p(), new TrackingParams(nativeAdDetails.f36001f), AdsCommonMetaData.f36186h.z(), AdsCommonMetaData.f36186h.y(), nativeAdDetails.f35996a.B(), nativeAdDetails.f35996a.C(), false, (Runnable) null);
            }
        }
        NativeAdDisplayListener nativeAdDisplayListener = nativeAdDetails.f36005j;
        if (nativeAdDisplayListener != null) {
            nativeAdDisplayListener.adClicked(nativeAdDetails);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        unregisterView();
    }

    public String getCallToAction() {
        String e2;
        AdDetails adDetails = this.f35996a;
        if (adDetails == null || (e2 = adDetails.e()) == null) {
            return "";
        }
        return e2;
    }

    public StartAppNativeAd.CampaignAction getCampaignAction() {
        StartAppNativeAd.CampaignAction campaignAction = StartAppNativeAd.CampaignAction.OPEN_MARKET;
        AdDetails adDetails = this.f35996a;
        if (adDetails == null || !adDetails.z()) {
            return campaignAction;
        }
        return StartAppNativeAd.CampaignAction.LAUNCH_APP;
    }

    public String getCategory() {
        String f2;
        AdDetails adDetails = this.f35996a;
        if (adDetails == null || (f2 = adDetails.f()) == null) {
            return "";
        }
        return f2;
    }

    public String getDescription() {
        String i2;
        AdDetails adDetails = this.f35996a;
        if (adDetails == null || (i2 = adDetails.i()) == null) {
            return "";
        }
        return i2;
    }

    public Bitmap getImageBitmap() {
        return this.f35997b;
    }

    public String getImageUrl() {
        AdDetails adDetails = this.f35996a;
        if (adDetails != null) {
            return adDetails.j();
        }
        return null;
    }

    public String getInstalls() {
        String k2;
        AdDetails adDetails = this.f35996a;
        if (adDetails == null || (k2 = adDetails.k()) == null) {
            return "";
        }
        return k2;
    }

    public String getPackageName() {
        String p2;
        AdDetails adDetails = this.f35996a;
        if (adDetails == null || (p2 = adDetails.p()) == null) {
            return "";
        }
        return p2;
    }

    public float getRating() {
        AdDetails adDetails = this.f35996a;
        if (adDetails != null) {
            return adDetails.q();
        }
        return 5.0f;
    }

    public Bitmap getSecondaryImageBitmap() {
        return this.f35998c;
    }

    public String getSecondaryImageUrl() {
        AdDetails adDetails = this.f35996a;
        if (adDetails != null) {
            return adDetails.r();
        }
        return null;
    }

    public String getTitle() {
        String t2;
        AdDetails adDetails = this.f35996a;
        if (adDetails == null || (t2 = adDetails.t()) == null) {
            return "";
        }
        return t2;
    }

    public boolean isApp() {
        AdDetails adDetails = this.f35996a;
        if (adDetails != null) {
            return adDetails.y();
        }
        return true;
    }

    public boolean isBelowMinCPM() {
        AdDetails adDetails = this.f35996a;
        return adDetails != null && adDetails.n();
    }

    public void loadImages(Context context, Runnable runnable) {
        b bVar = new b(runnable);
        new la(context, getImageUrl(), bVar, 0).a();
        new la(context, getSecondaryImageUrl(), bVar, 1).a();
    }

    public void registerViewForInteraction(View view) {
        a(view);
        this.f36003h.get().setOnClickListener(new c());
    }

    public String toString() {
        String description = getDescription();
        if (description != null) {
            description = description.substring(0, Math.min(30, description.length()));
        }
        return "         Title: [" + getTitle() + "]\n         Description: [" + description + "]...\n         Rating: [" + getRating() + "]\n         Installs: [" + getInstalls() + "]\n         Category: [" + getCategory() + "]\n         PackageName: [" + getPackageName() + "]\n         CampaginAction: [" + getCampaignAction() + "]\n";
    }

    public void unregisterView() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        ob obVar = this.f36002g;
        if (obVar != null) {
            obVar.a();
            this.f36002g = null;
        }
        View view = this.f36003h.get();
        this.f36003h.clear();
        if (!(view == null || (onAttachStateChangeListener = this.f36004i) == null)) {
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        Bitmap bitmap = this.f35997b;
        if (bitmap != null) {
            bitmap.recycle();
            this.f35997b = null;
        }
        Bitmap bitmap2 = this.f35998c;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f35998c = null;
        }
    }

    public void registerViewForInteraction(View view, List<View> list) {
        registerViewForInteraction(view, list, (NativeAdDisplayListener) null);
    }

    public void registerViewForInteraction(View view, List<View> list, NativeAdDisplayListener nativeAdDisplayListener) {
        if (list == null || list.isEmpty() || this.f36003h.get() != null) {
            registerViewForInteraction(view);
        } else {
            d dVar = new d();
            for (View onClickListener : list) {
                onClickListener.setOnClickListener(dVar);
            }
            a(view);
        }
        this.f36005j = nativeAdDisplayListener;
    }

    public final void a(View view) {
        this.f36003h = new WeakReference<>(view);
        if (!view.hasWindowFocus()) {
            if (this.f36004i == null) {
                this.f36004i = new q4(this);
            }
            view.addOnAttachStateChangeListener(this.f36004i);
            return;
        }
        a();
    }

    public final void a() {
        long j2;
        if (this.f36002g == null && !this.f35999d) {
            View view = this.f36003h.get();
            if (view == null) {
                NativeAdDisplayListener nativeAdDisplayListener = this.f36005j;
                if (nativeAdDisplayListener != null) {
                    nativeAdDisplayListener.adNotDisplayed(this);
                    return;
                }
                return;
            }
            Context context = view.getContext();
            String[] w2 = this.f35996a.w();
            TrackingParams trackingParams = new TrackingParams(this.f36001f);
            if (this.f35996a.h() != null) {
                j2 = TimeUnit.SECONDS.toMillis(this.f35996a.h().longValue());
            } else {
                j2 = TimeUnit.SECONDS.toMillis(MetaData.f36379h.n());
            }
            z6 z6Var = new z6(context, w2, trackingParams, j2);
            z6Var.f36992l = new WeakReference<>(this.f36007l);
            ob obVar = new ob(this.f36003h, z6Var, BannerMetaData.f35889b.a());
            this.f36002g = obVar;
            obVar.f35565c = new e();
            if (obVar.b()) {
                obVar.run();
            }
        }
    }
}
