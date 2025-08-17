package com.google.android.gms.internal.ads;

import android.os.IBinder;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzay;

public final class zzfbi {
    public static zze zza(Throwable th) {
        if (th instanceof zzecg) {
            zzecg zzecg = (zzecg) th;
            return zzc(zzecg.zza(), zzecg.zzb());
        } else if (th instanceof zzdtx) {
            if (th.getMessage() == null) {
                return zzd(((zzdtx) th).zza(), (String) null, (zze) null);
            }
            return zzd(((zzdtx) th).zza(), th.getMessage(), (zze) null);
        } else if (!(th instanceof zzay)) {
            return zzd(1, (String) null, (zze) null);
        } else {
            zzay zzay = (zzay) th;
            return new zze(zzay.zza(), zzfpw.zzc(zzay.getMessage()), MobileAds.ERROR_DOMAIN, (zze) null, (IBinder) null);
        }
    }

    public static zze zzb(Throwable th, zzech zzech) {
        zze zze;
        zze zza = zza(th);
        int i2 = zza.zza;
        if ((i2 == 3 || i2 == 0) && (zze = zza.zzd) != null && !zze.zzc.equals(MobileAds.ERROR_DOMAIN)) {
            zza.zzd = null;
        }
        if (zzech != null) {
            zza.zze = zzech.zzb();
        }
        return zza;
    }

    public static zze zzc(int i2, zze zze) {
        if (i2 != 0) {
            if (i2 == 8) {
                if (((Integer) zzba.zzc().zzb(zzbbm.zzhP)).intValue() > 0) {
                    return zze;
                }
                i2 = 8;
            }
            return zzd(i2, (String) null, zze);
        }
        throw null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        r3 = "No fill.";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.client.zze zzd(int r8, java.lang.String r9, com.google.android.gms.ads.internal.client.zze r10) {
        /*
            r0 = 0
            if (r9 != 0) goto L_0x0054
            int r9 = r8 + -1
            if (r8 == 0) goto L_0x0053
            java.lang.String r1 = "No fill."
            switch(r9) {
                case 1: goto L_0x0050;
                case 2: goto L_0x004e;
                case 3: goto L_0x004b;
                case 4: goto L_0x0048;
                case 5: goto L_0x0045;
                case 6: goto L_0x0042;
                case 7: goto L_0x003f;
                case 8: goto L_0x003c;
                case 9: goto L_0x0039;
                case 10: goto L_0x0036;
                case 11: goto L_0x000c;
                case 12: goto L_0x0021;
                case 13: goto L_0x001e;
                case 14: goto L_0x001b;
                case 15: goto L_0x0018;
                case 16: goto L_0x0015;
                case 17: goto L_0x0012;
                case 18: goto L_0x000f;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.String r9 = "Internal error."
            goto L_0x0054
        L_0x000f:
            java.lang.String r9 = "Ad inspector cannot be opened because it is already open."
            goto L_0x0054
        L_0x0012:
            java.lang.String r9 = "Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information."
            goto L_0x0054
        L_0x0015:
            java.lang.String r9 = "Ad inspector failed to load."
            goto L_0x0054
        L_0x0018:
            java.lang.String r9 = "Ad inspector had an internal error."
            goto L_0x0054
        L_0x001b:
            java.lang.String r9 = "Invalid ad string."
            goto L_0x0054
        L_0x001e:
            java.lang.String r9 = "Mismatch request IDs."
            goto L_0x0054
        L_0x0021:
            com.google.android.gms.internal.ads.zzbbe r9 = com.google.android.gms.internal.ads.zzbbm.zzhS
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r9 = r2.zzb(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r9 > 0) goto L_0x004e
            java.lang.String r9 = "The mediation adapter did not return an ad."
            goto L_0x0054
        L_0x0036:
            java.lang.String r9 = "The ad can not be shown when app is not in foreground."
            goto L_0x0054
        L_0x0039:
            java.lang.String r9 = "The ad has already been shown."
            goto L_0x0054
        L_0x003c:
            java.lang.String r9 = "The ad is not ready."
            goto L_0x0054
        L_0x003f:
            java.lang.String r9 = "A mediation adapter failed to show the ad."
            goto L_0x0054
        L_0x0042:
            java.lang.String r9 = "Invalid request: Invalid ad size."
            goto L_0x0054
        L_0x0045:
            java.lang.String r9 = "Invalid request: Invalid ad unit ID."
            goto L_0x0054
        L_0x0048:
            java.lang.String r9 = "Network error."
            goto L_0x0054
        L_0x004b:
            java.lang.String r9 = "App ID missing."
            goto L_0x0054
        L_0x004e:
            r3 = r1
            goto L_0x0055
        L_0x0050:
            java.lang.String r9 = "Invalid request."
            goto L_0x0054
        L_0x0053:
            throw r0
        L_0x0054:
            r3 = r9
        L_0x0055:
            int r9 = r8 + -1
            com.google.android.gms.ads.internal.client.zze r7 = new com.google.android.gms.ads.internal.client.zze
            if (r8 == 0) goto L_0x00e1
            r0 = 2
            r1 = 1
            r2 = 0
            r4 = 3
            switch(r9) {
                case 0: goto L_0x0099;
                case 1: goto L_0x0098;
                case 2: goto L_0x0096;
                case 3: goto L_0x0091;
                case 4: goto L_0x008f;
                case 5: goto L_0x0098;
                case 6: goto L_0x0098;
                case 7: goto L_0x008c;
                case 8: goto L_0x008f;
                case 9: goto L_0x0098;
                case 10: goto L_0x0096;
                case 11: goto L_0x0099;
                case 12: goto L_0x0075;
                case 13: goto L_0x0070;
                case 14: goto L_0x006b;
                case 15: goto L_0x0099;
                case 16: goto L_0x0098;
                case 17: goto L_0x008f;
                case 18: goto L_0x0096;
                default: goto L_0x0062;
            }
        L_0x0062:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            switch(r8) {
                case 1: goto L_0x00d5;
                case 2: goto L_0x00d2;
                case 3: goto L_0x00cf;
                case 4: goto L_0x00cc;
                case 5: goto L_0x00c9;
                case 6: goto L_0x00c6;
                case 7: goto L_0x00c3;
                case 8: goto L_0x00c0;
                case 9: goto L_0x00bd;
                case 10: goto L_0x00ba;
                case 11: goto L_0x00b7;
                case 12: goto L_0x00b4;
                case 13: goto L_0x00b1;
                case 14: goto L_0x00ae;
                case 15: goto L_0x00ab;
                case 16: goto L_0x00a8;
                case 17: goto L_0x00a5;
                case 18: goto L_0x00a2;
                default: goto L_0x0067;
            }
        L_0x0067:
            java.lang.String r8 = "AD_INSPECTOR_ALREADY_OPEN"
            goto L_0x00d7
        L_0x006b:
            r8 = 11
            r2 = 11
            goto L_0x0099
        L_0x0070:
            r8 = 10
            r2 = 10
            goto L_0x0099
        L_0x0075:
            com.google.android.gms.internal.ads.zzbbe r8 = com.google.android.gms.internal.ads.zzbbm.zzhS
            com.google.android.gms.internal.ads.zzbbk r9 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r8 = r9.zzb(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r8 > 0) goto L_0x0096
            r8 = 9
            r2 = 9
            goto L_0x0099
        L_0x008c:
            r8 = 4
            r2 = 4
            goto L_0x0099
        L_0x008f:
            r2 = 2
            goto L_0x0099
        L_0x0091:
            r8 = 8
            r2 = 8
            goto L_0x0099
        L_0x0096:
            r2 = 3
            goto L_0x0099
        L_0x0098:
            r2 = 1
        L_0x0099:
            java.lang.String r4 = "com.google.android.gms.ads"
            r6 = 0
            r1 = r7
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return r7
        L_0x00a2:
            java.lang.String r8 = "AD_INSPECTOR_NOT_IN_TEST_MODE"
            goto L_0x00d7
        L_0x00a5:
            java.lang.String r8 = "AD_INSPECTOR_FAILED_TO_LOAD"
            goto L_0x00d7
        L_0x00a8:
            java.lang.String r8 = "AD_INSPECTOR_INTERNAL_ERROR"
            goto L_0x00d7
        L_0x00ab:
            java.lang.String r8 = "INVALID_AD_STRING"
            goto L_0x00d7
        L_0x00ae:
            java.lang.String r8 = "REQUEST_ID_MISMATCH"
            goto L_0x00d7
        L_0x00b1:
            java.lang.String r8 = "MEDIATION_NO_FILL"
            goto L_0x00d7
        L_0x00b4:
            java.lang.String r8 = "INTERNAL_SHOW_ERROR"
            goto L_0x00d7
        L_0x00b7:
            java.lang.String r8 = "APP_NOT_FOREGROUND"
            goto L_0x00d7
        L_0x00ba:
            java.lang.String r8 = "AD_REUSED"
            goto L_0x00d7
        L_0x00bd:
            java.lang.String r8 = "NOT_READY"
            goto L_0x00d7
        L_0x00c0:
            java.lang.String r8 = "MEDIATION_SHOW_ERROR"
            goto L_0x00d7
        L_0x00c3:
            java.lang.String r8 = "INVALID_AD_SIZE"
            goto L_0x00d7
        L_0x00c6:
            java.lang.String r8 = "INVALID_AD_UNIT_ID"
            goto L_0x00d7
        L_0x00c9:
            java.lang.String r8 = "NETWORK_ERROR"
            goto L_0x00d7
        L_0x00cc:
            java.lang.String r8 = "APP_ID_MISSING"
            goto L_0x00d7
        L_0x00cf:
            java.lang.String r8 = "NO_FILL"
            goto L_0x00d7
        L_0x00d2:
            java.lang.String r8 = "INVALID_REQUEST"
            goto L_0x00d7
        L_0x00d5:
            java.lang.String r8 = "INTERNAL_ERROR"
        L_0x00d7:
            java.lang.String r10 = "Unknown SdkError: "
            java.lang.String r8 = r10.concat(r8)
            r9.<init>(r8)
            throw r9
        L_0x00e1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfbi.zzd(int, java.lang.String, com.google.android.gms.ads.internal.client.zze):com.google.android.gms.ads.internal.client.zze");
    }
}
