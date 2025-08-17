package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;

public final class zzbwu implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zza;
    private final SharedPreferences zzb;
    private final zzg zzc;
    private final zzbxw zzd;
    private String zze = "-1";
    private int zzf = -1;

    zzbwu(Context context, zzg zzg, zzbxw zzbxw) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzc = zzg;
        this.zza = context;
        this.zzd = zzbxw;
    }

    private final void zzb(String str, int i2) {
        Context context;
        boolean z2 = false;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzaw)).booleanValue() ? str.isEmpty() || str.charAt(0) != '1' : i2 == 0 || str.isEmpty() || (str.charAt(0) != '1' && !str.equals("-1"))) {
            z2 = true;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzau)).booleanValue()) {
            this.zzc.zzH(z2);
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzfW)).booleanValue() && z2 && (context = this.zza) != null) {
                context.deleteDatabase("OfflineUpload.db");
            }
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzap)).booleanValue()) {
            this.zzd.zzt();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSharedPreferenceChanged(android.content.SharedPreferences r9, java.lang.String r10) {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzay
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            java.lang.String r1 = "-1"
            java.lang.String r2 = "IABTCF_PurposeConsents"
            r3 = 1
            r4 = -1
            java.lang.String r5 = "gad_has_consent_for_cookies"
            if (r0 == 0) goto L_0x007d
            boolean r0 = com.google.android.gms.internal.ads.zzbwt.zza(r10, r5)
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzbbe r10 = com.google.android.gms.internal.ads.zzbbm.zzaw
            com.google.android.gms.internal.ads.zzbbk r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r10 = r0.zzb(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x0033
            return
        L_0x0033:
            int r9 = r9.getInt(r5, r4)
            com.google.android.gms.ads.internal.util.zzg r10 = r8.zzc
            int r10 = r10.zzb()
            if (r9 == r10) goto L_0x0044
            com.google.android.gms.ads.internal.util.zzg r10 = r8.zzc
            r10.zzH(r3)
        L_0x0044:
            com.google.android.gms.ads.internal.util.zzg r10 = r8.zzc
            r10.zzE(r9)
            return
        L_0x004a:
            java.lang.String r0 = "IABTCF_gdprApplies"
            boolean r0 = com.google.android.gms.internal.ads.zzbwt.zza(r10, r0)
            if (r0 != 0) goto L_0x0060
            java.lang.String r0 = "IABTCF_TCString"
            boolean r0 = com.google.android.gms.internal.ads.zzbwt.zza(r10, r0)
            if (r0 != 0) goto L_0x0060
            boolean r0 = com.google.android.gms.internal.ads.zzbwt.zza(r10, r2)
            if (r0 == 0) goto L_0x00df
        L_0x0060:
            java.lang.String r9 = r9.getString(r10, r1)
            if (r9 == 0) goto L_0x0077
            com.google.android.gms.ads.internal.util.zzg r0 = r8.zzc
            java.lang.String r0 = r0.zzn(r10)
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0077
            com.google.android.gms.ads.internal.util.zzg r0 = r8.zzc
            r0.zzH(r3)
        L_0x0077:
            com.google.android.gms.ads.internal.util.zzg r0 = r8.zzc
            r0.zzF(r10, r9)
            return
        L_0x007d:
            java.lang.String r0 = r9.getString(r2, r1)
            int r9 = r9.getInt(r5, r4)
            java.lang.String r10 = java.lang.String.valueOf(r10)
            int r6 = r10.hashCode()
            r7 = -2004976699(0xffffffff887e7bc5, float:-7.6580835E-34)
            if (r6 == r7) goto L_0x00a0
            r2 = -527267622(0xffffffffe09288da, float:-8.447143E19)
            if (r6 == r2) goto L_0x0098
            goto L_0x00a8
        L_0x0098:
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto L_0x00a8
            r10 = 1
            goto L_0x00a9
        L_0x00a0:
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x00a8
            r10 = 0
            goto L_0x00a9
        L_0x00a8:
            r10 = -1
        L_0x00a9:
            if (r10 == 0) goto L_0x00cc
            if (r10 == r3) goto L_0x00ae
            return
        L_0x00ae:
            com.google.android.gms.internal.ads.zzbbe r10 = com.google.android.gms.internal.ads.zzbbm.zzaw
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r10 = r1.zzb(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00df
            if (r9 == r4) goto L_0x00df
            int r10 = r8.zzf
            if (r10 == r9) goto L_0x00df
            r8.zzf = r9
            r8.zzb(r0, r9)
            return
        L_0x00cc:
            boolean r10 = r0.equals(r1)
            if (r10 != 0) goto L_0x00df
            java.lang.String r10 = r8.zze
            boolean r10 = r10.equals(r0)
            if (r10 != 0) goto L_0x00df
            r8.zze = r0
            r8.zzb(r0, r9)
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbwu.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzb.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(this.zzb, "gad_has_consent_for_cookies");
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzay)).booleanValue()) {
            onSharedPreferenceChanged(this.zzb, "IABTCF_gdprApplies");
            onSharedPreferenceChanged(this.zzb, "IABTCF_TCString");
            return;
        }
        onSharedPreferenceChanged(this.zzb, "IABTCF_PurposeConsents");
    }
}
