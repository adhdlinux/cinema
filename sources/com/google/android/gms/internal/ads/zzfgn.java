package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzfgn {
    private final zzefr zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzfaa zzf;
    private final zzfab zzg;
    private final Clock zzh;
    private final zzaqs zzi;

    public zzfgn(zzefr zzefr, zzbzx zzbzx, String str, String str2, Context context, zzfaa zzfaa, zzfab zzfab, Clock clock, zzaqs zzaqs) {
        this.zza = zzefr;
        this.zzb = zzbzx.zza;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzfaa;
        this.zzg = zzfab;
        this.zzh = clock;
        this.zzi = zzaqs;
    }

    public static final List zzf(int i2, int i3, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(zzi((String) it2.next(), "@gw_mpe@", "2." + i3));
        }
        return arrayList;
    }

    public static final List zzg(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(zzi((String) it2.next(), "@gw_adnetstatus@", str));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static String zzh(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (zzbzq.zzk()) {
            return "fakeForAdDebugLog";
        }
        return str;
    }

    private static String zzi(String str, String str2, String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public final List zzc(zzezz zzezz, zzezn zzezn, List list) {
        return zzd(zzezz, zzezn, false, "", "", list);
    }

    public final List zzd(zzezz zzezz, zzezn zzezn, boolean z2, String str, String str2, List list) {
        String str3;
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            boolean z3 = true;
            if (true != z2) {
                str3 = "0";
            } else {
                str3 = "1";
            }
            String zzi2 = zzi(zzi(zzi((String) it2.next(), "@gw_adlocid@", zzezz.zza.zza.zzf), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.zzb);
            if (zzezn != null) {
                zzi2 = zzbxy.zzc(zzi(zzi(zzi(zzi2, "@gw_qdata@", zzezn.zzz), "@gw_adnetid@", zzezn.zzy), "@gw_allocid@", zzezn.zzx), this.zze, zzezn.zzX);
            }
            String zzi3 = zzi(zzi(zzi(zzi2, "@gw_adnetstatus@", this.zza.zzf()), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            boolean z4 = false;
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzdg)).booleanValue() && !TextUtils.isEmpty(str)) {
                z4 = true;
            }
            boolean z5 = !TextUtils.isEmpty(str2);
            if (z4) {
                z3 = z5;
            } else if (!z5) {
                arrayList.add(zzi3);
            }
            if (this.zzi.zzf(Uri.parse(zzi3))) {
                Uri.Builder buildUpon = Uri.parse(zzi3).buildUpon();
                if (z4) {
                    buildUpon = buildUpon.appendQueryParameter("ms", str);
                }
                if (z3) {
                    buildUpon = buildUpon.appendQueryParameter("attok", str2);
                }
                zzi3 = buildUpon.build().toString();
            }
            arrayList.add(zzi3);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f A[LOOP:0: B:12:0x0059->B:14:0x005f, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zze(com.google.android.gms.internal.ads.zzezn r10, java.util.List r11, com.google.android.gms.internal.ads.zzbuu r12) {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.common.util.Clock r1 = r9.zzh
            long r1 = r1.currentTimeMillis()
            java.lang.String r3 = r12.zzc()     // Catch:{ RemoteException -> 0x00a8 }
            int r12 = r12.zzb()     // Catch:{ RemoteException -> 0x00a8 }
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch:{ RemoteException -> 0x00a8 }
            com.google.android.gms.internal.ads.zzbbe r4 = com.google.android.gms.internal.ads.zzbbm.zzdh
            com.google.android.gms.internal.ads.zzbbk r5 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r5.zzb(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0035
            com.google.android.gms.internal.ads.zzfab r4 = r9.zzg
            if (r4 != 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzfpd r4 = com.google.android.gms.internal.ads.zzfpd.zzc()
            goto L_0x003b
        L_0x0032:
            com.google.android.gms.internal.ads.zzfaa r4 = r4.zza
            goto L_0x0037
        L_0x0035:
            com.google.android.gms.internal.ads.zzfaa r4 = r9.zzf
        L_0x0037:
            com.google.android.gms.internal.ads.zzfpd r4 = com.google.android.gms.internal.ads.zzfpd.zzd(r4)
        L_0x003b:
            com.google.android.gms.internal.ads.zzfgl r5 = com.google.android.gms.internal.ads.zzfgl.zza
            com.google.android.gms.internal.ads.zzfpd r5 = r4.zza(r5)
            java.lang.String r6 = ""
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzfgm r7 = com.google.android.gms.internal.ads.zzfgm.zza
            com.google.android.gms.internal.ads.zzfpd r4 = r4.zza(r7)
            java.lang.Object r4 = r4.zzb(r6)
            java.lang.String r4 = (java.lang.String) r4
            java.util.Iterator r11 = r11.iterator()
        L_0x0059:
            boolean r6 = r11.hasNext()
            if (r6 == 0) goto L_0x00a7
            java.lang.Object r6 = r11.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = android.net.Uri.encode(r5)
            java.lang.String r8 = "@gw_rwd_userid@"
            java.lang.String r6 = zzi(r6, r8, r7)
            java.lang.String r7 = android.net.Uri.encode(r4)
            java.lang.String r8 = "@gw_rwd_custom_data@"
            java.lang.String r6 = zzi(r6, r8, r7)
            java.lang.String r7 = java.lang.Long.toString(r1)
            java.lang.String r8 = "@gw_tmstmp@"
            java.lang.String r6 = zzi(r6, r8, r7)
            java.lang.String r7 = android.net.Uri.encode(r3)
            java.lang.String r8 = "@gw_rwd_itm@"
            java.lang.String r6 = zzi(r6, r8, r7)
            java.lang.String r7 = "@gw_rwd_amt@"
            java.lang.String r6 = zzi(r6, r7, r12)
            java.lang.String r7 = r9.zzb
            java.lang.String r8 = "@gw_sdkver@"
            java.lang.String r6 = zzi(r6, r8, r7)
            android.content.Context r7 = r9.zze
            boolean r8 = r10.zzX
            java.lang.String r6 = com.google.android.gms.internal.ads.zzbxy.zzc(r6, r7, r8)
            r0.add(r6)
            goto L_0x0059
        L_0x00a7:
            return r0
        L_0x00a8:
            r10 = move-exception
            java.lang.String r11 = "Unable to determine award type and amount."
            com.google.android.gms.internal.ads.zzbzr.zzh(r11, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgn.zze(com.google.android.gms.internal.ads.zzezn, java.util.List, com.google.android.gms.internal.ads.zzbuu):java.util.List");
    }
}
