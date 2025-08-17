package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbqf extends zzbps {
    private final RtbAdapter zza;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzb;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzc;
    /* access modifiers changed from: private */
    public MediationAppOpenAd zzd;
    private String zze = "";

    public zzbqf(RtbAdapter rtbAdapter) {
        this.zza = rtbAdapter;
    }

    private final Bundle zzv(zzl zzl) {
        Bundle bundle;
        Bundle bundle2 = zzl.zzm;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    private static final Bundle zzw(String str) throws RemoteException {
        zzbzr.zzj("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e2) {
            zzbzr.zzh("", e2);
            throw new RemoteException();
        }
    }

    private static final boolean zzx(zzl zzl) {
        if (zzl.zzf) {
            return true;
        }
        zzay.zzb();
        return zzbzk.zzr();
    }

    private static final String zzy(String str, zzl zzl) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzl.zzu;
        }
    }

    public final zzdq zze() {
        RtbAdapter rtbAdapter = this.zza;
        if (rtbAdapter instanceof zza) {
            try {
                return ((zza) rtbAdapter).getVideoController();
            } catch (Throwable th) {
                zzbzr.zzh("", th);
            }
        }
        return null;
    }

    public final zzbqh zzf() throws RemoteException {
        return zzbqh.zza(this.zza.getVersionInfo());
    }

    public final zzbqh zzg() throws RemoteException {
        return zzbqh.zza(this.zza.getSDKVersionInfo());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(com.google.android.gms.dynamic.IObjectWrapper r9, java.lang.String r10, android.os.Bundle r11, android.os.Bundle r12, com.google.android.gms.ads.internal.client.zzq r13, com.google.android.gms.internal.ads.zzbpw r14) throws android.os.RemoteException {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzbqd r0 = new com.google.android.gms.internal.ads.zzbqd     // Catch:{ all -> 0x009c }
            r0.<init>(r8, r14)     // Catch:{ all -> 0x009c }
            com.google.android.gms.ads.mediation.rtb.RtbAdapter r14 = r8.zza     // Catch:{ all -> 0x009c }
            com.google.android.gms.ads.mediation.MediationConfiguration r1 = new com.google.android.gms.ads.mediation.MediationConfiguration     // Catch:{ all -> 0x009c }
            int r2 = r10.hashCode()     // Catch:{ all -> 0x009c }
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r2) {
                case -1396342996: goto L_0x0048;
                case -1052618729: goto L_0x003e;
                case -239580146: goto L_0x0034;
                case 604727084: goto L_0x002a;
                case 1167692200: goto L_0x0020;
                case 1911491517: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0052
        L_0x0016:
            java.lang.String r2 = "rewarded_interstitial"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x0052
            r10 = 3
            goto L_0x0053
        L_0x0020:
            java.lang.String r2 = "app_open"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x0052
            r10 = 5
            goto L_0x0053
        L_0x002a:
            java.lang.String r2 = "interstitial"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x0052
            r10 = 1
            goto L_0x0053
        L_0x0034:
            java.lang.String r2 = "rewarded"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x0052
            r10 = 2
            goto L_0x0053
        L_0x003e:
            java.lang.String r2 = "native"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x0052
            r10 = 4
            goto L_0x0053
        L_0x0048:
            java.lang.String r2 = "banner"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x0052
            r10 = 0
            goto L_0x0053
        L_0x0052:
            r10 = -1
        L_0x0053:
            if (r10 == 0) goto L_0x0076
            if (r10 == r7) goto L_0x0073
            if (r10 == r6) goto L_0x0070
            if (r10 == r5) goto L_0x006d
            if (r10 == r4) goto L_0x006a
            if (r10 != r3) goto L_0x0062
            com.google.android.gms.ads.AdFormat r10 = com.google.android.gms.ads.AdFormat.APP_OPEN_AD     // Catch:{ all -> 0x009c }
            goto L_0x0078
        L_0x0062:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x009c }
            java.lang.String r10 = "Internal Error"
            r9.<init>(r10)     // Catch:{ all -> 0x009c }
            throw r9     // Catch:{ all -> 0x009c }
        L_0x006a:
            com.google.android.gms.ads.AdFormat r10 = com.google.android.gms.ads.AdFormat.NATIVE     // Catch:{ all -> 0x009c }
            goto L_0x0078
        L_0x006d:
            com.google.android.gms.ads.AdFormat r10 = com.google.android.gms.ads.AdFormat.REWARDED_INTERSTITIAL     // Catch:{ all -> 0x009c }
            goto L_0x0078
        L_0x0070:
            com.google.android.gms.ads.AdFormat r10 = com.google.android.gms.ads.AdFormat.REWARDED     // Catch:{ all -> 0x009c }
            goto L_0x0078
        L_0x0073:
            com.google.android.gms.ads.AdFormat r10 = com.google.android.gms.ads.AdFormat.INTERSTITIAL     // Catch:{ all -> 0x009c }
            goto L_0x0078
        L_0x0076:
            com.google.android.gms.ads.AdFormat r10 = com.google.android.gms.ads.AdFormat.BANNER     // Catch:{ all -> 0x009c }
        L_0x0078:
            r1.<init>(r10, r12)     // Catch:{ all -> 0x009c }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x009c }
            r10.<init>()     // Catch:{ all -> 0x009c }
            r10.add(r1)     // Catch:{ all -> 0x009c }
            com.google.android.gms.ads.mediation.rtb.RtbSignalData r12 = new com.google.android.gms.ads.mediation.rtb.RtbSignalData     // Catch:{ all -> 0x009c }
            java.lang.Object r9 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r9)     // Catch:{ all -> 0x009c }
            android.content.Context r9 = (android.content.Context) r9     // Catch:{ all -> 0x009c }
            int r1 = r13.zze     // Catch:{ all -> 0x009c }
            int r2 = r13.zzb     // Catch:{ all -> 0x009c }
            java.lang.String r13 = r13.zza     // Catch:{ all -> 0x009c }
            com.google.android.gms.ads.AdSize r13 = com.google.android.gms.ads.zzb.zzc(r1, r2, r13)     // Catch:{ all -> 0x009c }
            r12.<init>(r9, r10, r11, r13)     // Catch:{ all -> 0x009c }
            r14.collectSignals(r12, r0)     // Catch:{ all -> 0x009c }
            return
        L_0x009c:
            r9 = move-exception
            java.lang.String r10 = "Error generating signals for RTB"
            com.google.android.gms.internal.ads.zzbzr.zzh(r10, r9)
            android.os.RemoteException r9 = new android.os.RemoteException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqf.zzh(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, android.os.Bundle, android.os.Bundle, com.google.android.gms.ads.internal.client.zzq, com.google.android.gms.internal.ads.zzbpw):void");
    }

    public final void zzi(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpe zzbpe, zzboc zzboc) throws RemoteException {
        zzl zzl2 = zzl;
        try {
            this.zza.loadRtbAppOpenAd(new MediationAppOpenAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzl2), zzx(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzy(str2, zzl), this.zze), new zzbqc(this, zzbpe, zzboc));
        } catch (Throwable th) {
            zzbzr.zzh("Adapter failed to render app open ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzj(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbph zzbph, zzboc zzboc, zzq zzq) throws RemoteException {
        zzl zzl2 = zzl;
        zzq zzq2 = zzq;
        try {
            zzbpy zzbpy = new zzbpy(this, zzbph, zzboc);
            RtbAdapter rtbAdapter = this.zza;
            Bundle zzw = zzw(str2);
            Bundle zzv = zzv(zzl2);
            boolean zzx = zzx(zzl);
            Location location = zzl2.zzk;
            int i2 = zzl2.zzg;
            int i3 = zzl2.zzt;
            String zzy = zzy(str2, zzl);
            AdSize zzc2 = zzb.zzc(zzq2.zze, zzq2.zzb, zzq2.zza);
            String str3 = this.zze;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw, zzv, zzx, location, i2, i3, zzy, zzc2, str3);
            rtbAdapter.loadRtbBannerAd(mediationBannerAdConfiguration, zzbpy);
        } catch (Throwable th) {
            zzbzr.zzh("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzk(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbph zzbph, zzboc zzboc, zzq zzq) throws RemoteException {
        zzl zzl2 = zzl;
        zzq zzq2 = zzq;
        try {
            zzbpz zzbpz = new zzbpz(this, zzbph, zzboc);
            RtbAdapter rtbAdapter = this.zza;
            Bundle zzw = zzw(str2);
            Bundle zzv = zzv(zzl2);
            boolean zzx = zzx(zzl);
            Location location = zzl2.zzk;
            int i2 = zzl2.zzg;
            int i3 = zzl2.zzt;
            String zzy = zzy(str2, zzl);
            AdSize zzc2 = zzb.zzc(zzq2.zze, zzq2.zzb, zzq2.zza);
            String str3 = this.zze;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw, zzv, zzx, location, i2, i3, zzy, zzc2, str3);
            rtbAdapter.loadRtbInterscrollerAd(mediationBannerAdConfiguration, zzbpz);
        } catch (Throwable th) {
            zzbzr.zzh("Adapter failed to render interscroller ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzl(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpk zzbpk, zzboc zzboc) throws RemoteException {
        zzl zzl2 = zzl;
        try {
            this.zza.loadRtbInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzl2), zzx(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzy(str2, zzl), this.zze), new zzbqa(this, zzbpk, zzboc));
        } catch (Throwable th) {
            zzbzr.zzh("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzm(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpn zzbpn, zzboc zzboc) throws RemoteException {
        zzn(str, str2, zzl, iObjectWrapper, zzbpn, zzboc, (zzbef) null);
    }

    public final void zzn(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpn zzbpn, zzboc zzboc, zzbef zzbef) throws RemoteException {
        zzl zzl2 = zzl;
        try {
            zzbqb zzbqb = new zzbqb(this, zzbpn, zzboc);
            RtbAdapter rtbAdapter = this.zza;
            MediationNativeAdConfiguration mediationNativeAdConfiguration = r4;
            MediationNativeAdConfiguration mediationNativeAdConfiguration2 = new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzl2), zzx(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzy(str2, zzl), this.zze, zzbef);
            rtbAdapter.loadRtbNativeAd(mediationNativeAdConfiguration, zzbqb);
        } catch (Throwable th) {
            zzbzr.zzh("Adapter failed to render native ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzo(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpq zzbpq, zzboc zzboc) throws RemoteException {
        zzl zzl2 = zzl;
        try {
            this.zza.loadRtbRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzl2), zzx(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzy(str2, zzl), this.zze), new zzbqe(this, zzbpq, zzboc));
        } catch (Throwable th) {
            zzbzr.zzh("Adapter failed to render rewarded interstitial ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzp(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpq zzbpq, zzboc zzboc) throws RemoteException {
        zzl zzl2 = zzl;
        try {
            this.zza.loadRtbRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzl2), zzx(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzy(str2, zzl), this.zze), new zzbqe(this, zzbpq, zzboc));
        } catch (Throwable th) {
            zzbzr.zzh("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzq(String str) {
        this.zze = str;
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationAppOpenAd mediationAppOpenAd = this.zzd;
        if (mediationAppOpenAd == null) {
            return false;
        }
        try {
            mediationAppOpenAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbzr.zzh("", th);
            return true;
        }
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzb;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbzr.zzh("", th);
            return true;
        }
    }

    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzc;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbzr.zzh("", th);
            return true;
        }
    }
}
