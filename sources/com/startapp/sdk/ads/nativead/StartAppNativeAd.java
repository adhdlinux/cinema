package com.startapp.sdk.ads.nativead;

import android.content.Context;
import com.startapp.o6;
import com.startapp.p;
import com.startapp.q7;
import com.startapp.r7;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adinformation.AdInformationMetaData;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.adrules.AdaptMetaData;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StartAppNativeAd extends Ad {
    private static final long serialVersionUID = 1;
    private b adEventDelegate;
    public boolean isLoading = false;
    private List<NativeAdDetails> listNativeAds = new ArrayList();
    private NativeAd nativeAd;
    private NativeAdPreferences preferences;

    public enum CampaignAction {
        LAUNCH_APP,
        OPEN_MARKET
    }

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public int f36015a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f36016b;

        public a(int i2) {
            this.f36016b = i2;
        }

        public void run() {
            int i2 = this.f36015a + 1;
            this.f36015a = i2;
            if (i2 == this.f36016b) {
                StartAppNativeAd.this.i();
            }
        }
    }

    public class b implements AdEventListener {

        /* renamed from: a  reason: collision with root package name */
        public AdEventListener f36018a;

        public b(AdEventListener adEventListener) {
            this.f36018a = adEventListener;
        }

        public void onFailedToReceiveAd(Ad ad) {
            if (ad != null) {
                StartAppNativeAd.this.setErrorMessage(ad.getErrorMessage());
            }
            AdEventListener adEventListener = this.f36018a;
            if (adEventListener != null) {
                StartAppNativeAd startAppNativeAd = StartAppNativeAd.this;
                p.a(startAppNativeAd.f36173b, adEventListener, (Ad) startAppNativeAd);
                this.f36018a = null;
            }
            StartAppNativeAd.this.isLoading = false;
        }

        public void onReceiveAd(Ad ad) {
            StartAppNativeAd.this.h();
        }
    }

    public StartAppNativeAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_NATIVE);
    }

    public static String getPrivacyImageUrl() {
        return AdInformationMetaData.f36260a.c();
    }

    public static String getPrivacyURL() {
        if (AdInformationMetaData.f36260a.b() == null) {
            return "";
        }
        String b2 = AdInformationMetaData.f36260a.b();
        if (b2.contains("http://") || b2.contains("https://")) {
            return AdInformationMetaData.f36260a.b();
        }
        return "https://" + AdInformationMetaData.f36260a.b();
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
    }

    public final AdDetails g() {
        NativeAdDetails nativeAdDetails;
        if (this.listNativeAds.size() <= 0 || (nativeAdDetails = this.listNativeAds.get(0)) == null) {
            return null;
        }
        return nativeAdDetails.f35996a;
    }

    public String getAdId() {
        AdDetails g2 = g();
        if (g2 != null) {
            return g2.a();
        }
        return null;
    }

    public String getBidToken() {
        AdDetails g2 = g();
        if (g2 != null) {
            return g2.d();
        }
        return null;
    }

    public ArrayList<NativeAdDetails> getNativeAds() {
        return getNativeAds((String) null);
    }

    public int getNumberOfAds() {
        return this.listNativeAds.size();
    }

    public void h() {
        List<AdDetails> g2;
        int size;
        NativeAd nativeAd2 = this.nativeAd;
        if (nativeAd2 == null || (g2 = nativeAd2.g()) == null || (size = g2.size()) <= 0) {
            i();
            return;
        }
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new NativeAdDetails(g2.get(i2)));
        }
        this.listNativeAds = arrayList;
        NativeAdPreferences nativeAdPreferences = this.preferences;
        if (nativeAdPreferences == null || !nativeAdPreferences.isAutoBitmapDownload()) {
            i();
            return;
        }
        a aVar = new a(size);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((NativeAdDetails) it2.next()).loadImages(this.f36173b, aVar);
        }
    }

    public final void i() {
        this.isLoading = false;
        setErrorMessage((String) null);
        b bVar = this.adEventDelegate;
        if (bVar != null) {
            p.b(this.f36173b, bVar.f36018a, (Ad) this);
        }
    }

    public boolean isBelowMinCPM() {
        return this.nativeAd.isBelowMinCPM();
    }

    public boolean loadAd() {
        return loadAd(new NativeAdPreferences(), (AdEventListener) null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n===== StartAppNativeAd =====\n");
        for (int i2 = 0; i2 < getNumberOfAds(); i2++) {
            sb.append(this.listNativeAds.get(i2));
        }
        sb.append("===== End StartAppNativeAd =====");
        return sb.toString();
    }

    public ArrayList<NativeAdDetails> getNativeAds(String str) {
        ArrayList<NativeAdDetails> arrayList = new ArrayList<>();
        AdRulesResult a2 = AdaptMetaData.f36307a.a().a(AdPreferences.Placement.INAPP_NATIVE, str);
        if (a2.b()) {
            for (NativeAdDetails next : this.listNativeAds) {
                next.f36001f = str;
                arrayList.add(next);
            }
            r7.f35760a.a(new q7(AdPreferences.Placement.INAPP_NATIVE, str));
        } else {
            Context context = this.f36173b;
            ArrayList arrayList2 = new ArrayList();
            for (NativeAdDetails nativeAdDetails : this.listNativeAds) {
                arrayList2.add(nativeAdDetails.f35996a);
            }
            o6.a(context, o6.a((List<AdDetails>) arrayList2), str, 0, a2.a());
        }
        return arrayList;
    }

    public boolean loadAd(AdEventListener adEventListener) {
        return loadAd(new NativeAdPreferences(), adEventListener);
    }

    public boolean loadAd(NativeAdPreferences nativeAdPreferences) {
        return loadAd(nativeAdPreferences, (AdEventListener) null);
    }

    public boolean loadAd(NativeAdPreferences nativeAdPreferences, AdEventListener adEventListener) {
        this.adEventDelegate = new b(adEventListener);
        this.preferences = nativeAdPreferences;
        if (this.isLoading) {
            setErrorMessage("Ad is currently being loaded");
            return false;
        }
        this.isLoading = true;
        NativeAd nativeAd2 = new NativeAd(this.f36173b, nativeAdPreferences);
        this.nativeAd = nativeAd2;
        return nativeAd2.load(nativeAdPreferences, this.adEventDelegate, true);
    }
}
