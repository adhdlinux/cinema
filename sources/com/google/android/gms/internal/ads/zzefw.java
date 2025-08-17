package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzefw implements zzfvj {
    private final zzfel zza;
    private final zzcvi zzb;
    private final zzfgn zzc;
    private final zzfgr zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzcrg zzg;
    private final zzefr zzh;
    private final zzech zzi;
    private final Context zzj;
    private final zzffy zzk;

    zzefw(Context context, zzfel zzfel, zzefr zzefr, zzcvi zzcvi, zzfgn zzfgn, zzfgr zzfgr, zzcrg zzcrg, Executor executor, ScheduledExecutorService scheduledExecutorService, zzech zzech, zzffy zzffy) {
        this.zzj = context;
        this.zza = zzfel;
        this.zzh = zzefr;
        this.zzb = zzcvi;
        this.zzc = zzfgn;
        this.zzd = zzfgr;
        this.zzg = zzcrg;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzech;
        this.zzk = zzffy;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzfj)).booleanValue() == false) goto L_0x005a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzfwm zza(java.lang.Object r9) throws java.lang.Exception {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzezz r9 = (com.google.android.gms.internal.ads.zzezz) r9
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzfk
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            java.lang.String r1 = "No fill."
            r2 = 1
            if (r2 == r0) goto L_0x001a
            java.lang.String r0 = "No ad config."
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            com.google.android.gms.internal.ads.zzezy r3 = r9.zzb
            com.google.android.gms.internal.ads.zzezq r3 = r3.zzb
            int r3 = r3.zze
            r4 = 200(0xc8, float:2.8E-43)
            r5 = 300(0x12c, float:4.2E-43)
            if (r3 == 0) goto L_0x0059
            if (r3 < r4) goto L_0x003e
            if (r3 >= r5) goto L_0x003e
            com.google.android.gms.internal.ads.zzbbe r3 = com.google.android.gms.internal.ads.zzbbm.zzfj
            com.google.android.gms.internal.ads.zzbbk r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r6.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L_0x0059
            goto L_0x005a
        L_0x003e:
            if (r3 < r5) goto L_0x0047
            r0 = 400(0x190, float:5.6E-43)
            if (r3 >= r0) goto L_0x0047
            java.lang.String r1 = "No location header to follow redirect or too many redirects."
            goto L_0x005a
        L_0x0047:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Received error HTTP response code: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = r0.toString()
            goto L_0x005a
        L_0x0059:
            r1 = r0
        L_0x005a:
            com.google.android.gms.internal.ads.zzezy r0 = r9.zzb
            com.google.android.gms.internal.ads.zzezq r0 = r0.zzb
            com.google.android.gms.internal.ads.zzezp r3 = r0.zzi
            if (r3 == 0) goto L_0x0066
            java.lang.String r1 = r3.zza()
        L_0x0066:
            com.google.android.gms.internal.ads.zzech r3 = r8.zzi
            r3.zzh(r0)
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzhR
            com.google.android.gms.internal.ads.zzbbk r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r3.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r3 = 3
            if (r0 == 0) goto L_0x0095
            com.google.android.gms.internal.ads.zzezy r0 = r9.zzb
            com.google.android.gms.internal.ads.zzezq r0 = r0.zzb
            int r0 = r0.zze
            if (r0 == 0) goto L_0x0095
            if (r0 < r4) goto L_0x008a
            if (r0 < r5) goto L_0x0095
        L_0x008a:
            com.google.android.gms.internal.ads.zzefu r9 = new com.google.android.gms.internal.ads.zzefu
            r9.<init>(r3, r1)
            com.google.android.gms.internal.ads.zzfwm r9 = com.google.android.gms.internal.ads.zzfwc.zzg(r9)
            goto L_0x019a
        L_0x0095:
            com.google.android.gms.internal.ads.zzfel r0 = r8.zza
            com.google.android.gms.internal.ads.zzfef r4 = com.google.android.gms.internal.ads.zzfef.RENDER_CONFIG_INIT
            com.google.android.gms.internal.ads.zzefu r5 = new com.google.android.gms.internal.ads.zzefu
            r5.<init>(r3, r1)
            com.google.android.gms.internal.ads.zzfwm r1 = com.google.android.gms.internal.ads.zzfwc.zzg(r5)
            com.google.android.gms.internal.ads.zzfec r0 = com.google.android.gms.internal.ads.zzfdv.zzc(r1, r4, r0)
            com.google.android.gms.internal.ads.zzfdq r0 = r0.zza()
            com.google.android.gms.internal.ads.zzezy r1 = r9.zzb
            com.google.android.gms.internal.ads.zzezq r1 = r1.zzb
            java.lang.String r1 = r1.zzm
            com.google.android.gms.internal.ads.zzbbe r3 = com.google.android.gms.internal.ads.zzbbm.zzdj
            com.google.android.gms.internal.ads.zzbbk r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x00d2
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzech r2 = r8.zzi
            com.google.android.gms.internal.ads.zzezy r3 = r9.zzb
            java.util.List r3 = r3.zza
            r2.zzg(r1, r3)
            goto L_0x011b
        L_0x00d2:
            com.google.android.gms.internal.ads.zzezy r1 = r9.zzb
            java.util.List r1 = r1.zza
            java.util.Iterator r1 = r1.iterator()
        L_0x00da:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x011b
            java.lang.Object r3 = r1.next()
            com.google.android.gms.internal.ads.zzezn r3 = (com.google.android.gms.internal.ads.zzezn) r3
            com.google.android.gms.internal.ads.zzech r4 = r8.zzi
            r4.zzd(r3)
            java.util.List r4 = r3.zza
            java.util.Iterator r4 = r4.iterator()
        L_0x00f1:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x010e
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzcrg r6 = r8.zzg
            int r7 = r3.zzb
            com.google.android.gms.internal.ads.zzecc r5 = r6.zza(r7, r5)
            if (r5 == 0) goto L_0x00f1
            boolean r5 = r5.zzb(r9, r3)
            if (r5 == 0) goto L_0x00f1
            goto L_0x00da
        L_0x010e:
            com.google.android.gms.internal.ads.zzech r4 = r8.zzi
            r5 = 0
            r7 = 0
            com.google.android.gms.ads.internal.client.zze r7 = com.google.android.gms.internal.ads.zzfbi.zzd(r2, r7, r7)
            r4.zze(r3, r5, r7)
            goto L_0x00da
        L_0x011b:
            com.google.android.gms.internal.ads.zzcvi r1 = r8.zzb
            com.google.android.gms.internal.ads.zzcne r2 = new com.google.android.gms.internal.ads.zzcne
            com.google.android.gms.internal.ads.zzfgr r3 = r8.zzd
            com.google.android.gms.internal.ads.zzfgn r4 = r8.zzc
            r2.<init>(r9, r3, r4)
            java.util.concurrent.Executor r3 = r8.zze
            r1.zzm(r2, r3)
            com.google.android.gms.internal.ads.zzezy r1 = r9.zzb
            java.util.List r1 = r1.zza
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        L_0x0134:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0199
            java.lang.Object r3 = r1.next()
            com.google.android.gms.internal.ads.zzezn r3 = (com.google.android.gms.internal.ads.zzezn) r3
            java.util.List r4 = r3.zza
            java.util.Iterator r4 = r4.iterator()
        L_0x0146:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0196
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzcrg r6 = r8.zzg
            int r7 = r3.zzb
            com.google.android.gms.internal.ads.zzecc r6 = r6.zza(r7, r5)
            if (r6 == 0) goto L_0x0146
            boolean r7 = r6.zzb(r9, r3)
            if (r7 == 0) goto L_0x0146
            com.google.android.gms.internal.ads.zzfel r4 = r8.zza
            com.google.android.gms.internal.ads.zzfef r7 = com.google.android.gms.internal.ads.zzfef.RENDER_CONFIG_WATERFALL
            com.google.android.gms.internal.ads.zzfec r0 = r4.zzb(r7, r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = "render-config-"
            r4.append(r7)
            r4.append(r2)
            java.lang.String r7 = "-"
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.google.android.gms.internal.ads.zzfec r0 = r0.zzh(r4)
            com.google.android.gms.internal.ads.zzefv r4 = new com.google.android.gms.internal.ads.zzefv
            r4.<init>(r8, r3, r9, r6)
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            com.google.android.gms.internal.ads.zzfec r0 = r0.zzc(r3, r4)
            com.google.android.gms.internal.ads.zzfdq r0 = r0.zza()
        L_0x0196:
            int r2 = r2 + 1
            goto L_0x0134
        L_0x0199:
            r9 = r0
        L_0x019a:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefw.zza(java.lang.Object):com.google.android.gms.internal.ads.zzfwm");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzb(zzezn zzezn, zzezz zzezz, zzecc zzecc, Throwable th) throws Exception {
        zzffn zza2 = zzffm.zza(this.zzj, 12);
        zza2.zzd(zzezn.zzF);
        zza2.zzh();
        zzefr zzefr = this.zzh;
        zzfwm zzn = zzfwc.zzn(zzecc.zza(zzezz, zzezn), (long) zzezn.zzS, TimeUnit.MILLISECONDS, this.zzf);
        zzefr.zze(zzezz, zzezn, zzn, this.zzc);
        zzffx.zza(zzn, this.zzk, zza2);
        return zzn;
    }
}
