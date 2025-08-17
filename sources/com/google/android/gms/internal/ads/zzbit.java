package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.facebook.ads.internal.c.a;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzbit implements zzbij {
    private final zzb zza;
    private final zzdqa zzb;
    private final zzfev zzc;
    private final zzbzw zzd;
    private final zzbqq zze;
    private final zzeba zzf;
    private zzx zzg = null;

    public zzbit(zzb zzb2, zzbqq zzbqq, zzeba zzeba, zzdqa zzdqa, zzfev zzfev) {
        this.zza = zzb2;
        this.zze = zzbqq;
        this.zzf = zzeba;
        this.zzb = zzdqa;
        this.zzc = zzfev;
        this.zzd = new zzbzw((String) null);
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if (ContextChain.TAG_PRODUCT.equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("c".equalsIgnoreCase(str)) {
            return 14;
        }
        return -1;
    }

    static Uri zzc(Context context, zzaqs zzaqs, Uri uri, View view, Activity activity) {
        if (zzaqs == null) {
            return uri;
        }
        try {
            if (zzaqs.zze(uri)) {
                return zzaqs.zza(uri, context, view, activity);
            }
            return uri;
        } catch (zzaqt unused) {
            return uri;
        } catch (Exception e2) {
            zzt.zzo().zzu(e2, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e2) {
            zzbzr.zzh("Error adding click uptime parameter to url: ".concat(String.valueOf(uri.toString())), e2);
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    private final void zzh(Context context, String str, String str2) {
        this.zzf.zzc(str);
        zzdqa zzdqa = this.zzb;
        if (zzdqa != null) {
            zzebl.zzc(context, zzdqa, this.zzc, this.zzf, str, "dialog_not_shown", zzfsf.zze("dialog_not_shown_reason", str2));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: android.net.Uri} */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v1, types: [android.content.Intent] */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r11v14 */
    /* JADX WARNING: type inference failed for: r11v15 */
    /* JADX WARNING: type inference failed for: r11v16 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* JADX WARNING: type inference failed for: r11v18 */
    /* JADX WARNING: type inference failed for: r11v19 */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00df, code lost:
        if (r3 == null) goto L_0x00e1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzi(com.google.android.gms.ads.internal.client.zza r18, java.util.Map r19, boolean r20, java.lang.String r21, boolean r22) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = 1
            r1.zzj(r3)
            r4 = r0
            com.google.android.gms.internal.ads.zzcez r4 = (com.google.android.gms.internal.ads.zzcez) r4
            android.content.Context r5 = r4.getContext()
            com.google.android.gms.internal.ads.zzaqs r6 = r4.zzI()
            android.view.View r7 = r4.zzF()
            java.lang.String r8 = "activity"
            java.lang.Object r8 = r5.getSystemService(r8)
            android.app.ActivityManager r8 = (android.app.ActivityManager) r8
            java.lang.String r9 = "u"
            java.lang.Object r9 = r2.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            r11 = 0
            if (r10 == 0) goto L_0x0032
            goto L_0x0134
        L_0x0032:
            android.net.Uri r9 = android.net.Uri.parse(r9)
            android.net.Uri r9 = zzc(r5, r6, r9, r7, r11)
            android.net.Uri r9 = zzd(r9)
            java.lang.String r10 = "use_first_package"
            java.lang.Object r10 = r2.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            boolean r10 = java.lang.Boolean.parseBoolean(r10)
            java.lang.String r12 = "use_running_process"
            java.lang.Object r12 = r2.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            boolean r12 = java.lang.Boolean.parseBoolean(r12)
            java.lang.String r13 = "use_custom_tabs"
            java.lang.Object r2 = r2.get(r13)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            if (r2 != 0) goto L_0x0078
            com.google.android.gms.internal.ads.zzbbe r2 = com.google.android.gms.internal.ads.zzbbm.zzek
            com.google.android.gms.internal.ads.zzbbk r14 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r14.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r3 = 0
        L_0x0078:
            java.lang.String r2 = r9.getScheme()
            java.lang.String r14 = "http"
            boolean r2 = r14.equalsIgnoreCase(r2)
            java.lang.String r15 = "https"
            if (r2 == 0) goto L_0x0093
            android.net.Uri$Builder r2 = r9.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r15)
            android.net.Uri r11 = r2.build()
            goto L_0x00a9
        L_0x0093:
            java.lang.String r2 = r9.getScheme()
            boolean r2 = r15.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00a9
            android.net.Uri$Builder r2 = r9.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r14)
            android.net.Uri r11 = r2.build()
        L_0x00a9:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.content.Intent r9 = com.google.android.gms.internal.ads.zzbis.zza(r9, r5, r6, r7)
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbis.zza(r11, r5, r6, r7)
            if (r3 == 0) goto L_0x00c4
            com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.ads.internal.util.zzs.zzm(r5, r9)
            com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.ads.internal.util.zzs.zzm(r5, r11)
        L_0x00c4:
            android.content.pm.ResolveInfo r3 = com.google.android.gms.internal.ads.zzbis.zzd(r9, r2, r5, r6, r7)
            if (r3 == 0) goto L_0x00cf
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbis.zzb(r9, r3, r5, r6, r7)
            goto L_0x0134
        L_0x00cf:
            if (r11 == 0) goto L_0x00e1
            android.content.pm.ResolveInfo r3 = com.google.android.gms.internal.ads.zzbis.zzc(r11, r5, r6, r7)
            if (r3 == 0) goto L_0x00e1
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbis.zzb(r9, r3, r5, r6, r7)
            android.content.pm.ResolveInfo r3 = com.google.android.gms.internal.ads.zzbis.zzc(r11, r5, r6, r7)
            if (r3 != 0) goto L_0x0134
        L_0x00e1:
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x00e8
            goto L_0x0133
        L_0x00e8:
            if (r12 == 0) goto L_0x0125
            if (r8 == 0) goto L_0x0125
            java.util.List r3 = r8.getRunningAppProcesses()
            if (r3 == 0) goto L_0x0125
            int r8 = r2.size()
            r11 = 0
        L_0x00f7:
            if (r11 >= r8) goto L_0x0125
            java.lang.Object r12 = r2.get(r11)
            android.content.pm.ResolveInfo r12 = (android.content.pm.ResolveInfo) r12
            java.util.Iterator r14 = r3.iterator()
        L_0x0103:
            boolean r15 = r14.hasNext()
            int r16 = r11 + 1
            if (r15 == 0) goto L_0x0122
            java.lang.Object r15 = r14.next()
            android.app.ActivityManager$RunningAppProcessInfo r15 = (android.app.ActivityManager.RunningAppProcessInfo) r15
            java.lang.String r15 = r15.processName
            android.content.pm.ActivityInfo r13 = r12.activityInfo
            java.lang.String r13 = r13.packageName
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x0103
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbis.zzb(r9, r12, r5, r6, r7)
            goto L_0x0134
        L_0x0122:
            r11 = r16
            goto L_0x00f7
        L_0x0125:
            if (r10 == 0) goto L_0x0133
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            android.content.pm.ResolveInfo r2 = (android.content.pm.ResolveInfo) r2
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzbis.zzb(r9, r2, r5, r6, r7)
            goto L_0x0134
        L_0x0133:
            r11 = r9
        L_0x0134:
            if (r20 == 0) goto L_0x0152
            com.google.android.gms.internal.ads.zzeba r2 = r1.zzf
            if (r2 == 0) goto L_0x0152
            if (r11 == 0) goto L_0x0152
            android.content.Context r2 = r4.getContext()
            android.net.Uri r3 = r11.getData()
            java.lang.String r3 = r3.toString()
            r4 = r21
            boolean r2 = r1.zzk(r0, r2, r3, r4)
            if (r2 != 0) goto L_0x0151
            goto L_0x0152
        L_0x0151:
            return
        L_0x0152:
            com.google.android.gms.internal.ads.zzcge r0 = (com.google.android.gms.internal.ads.zzcge) r0     // Catch:{ ActivityNotFoundException -> 0x0161 }
            com.google.android.gms.ads.internal.overlay.zzc r2 = new com.google.android.gms.ads.internal.overlay.zzc     // Catch:{ ActivityNotFoundException -> 0x0161 }
            com.google.android.gms.ads.internal.overlay.zzx r3 = r1.zzg     // Catch:{ ActivityNotFoundException -> 0x0161 }
            r2.<init>(r11, r3)     // Catch:{ ActivityNotFoundException -> 0x0161 }
            r3 = r22
            r0.zzaD(r2, r3)     // Catch:{ ActivityNotFoundException -> 0x0161 }
            return
        L_0x0161:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.google.android.gms.internal.ads.zzbzr.zzj(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbit.zzi(com.google.android.gms.ads.internal.client.zza, java.util.Map, boolean, java.lang.String, boolean):void");
    }

    private final void zzj(boolean z2) {
        zzbqq zzbqq = this.zze;
        if (zzbqq != null) {
            zzbqq.zza(z2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008d, code lost:
        if (r2 != false) goto L_0x0096;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzk(com.google.android.gms.ads.internal.client.zza r9, android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzdqa r1 = r8.zzb
            if (r1 == 0) goto L_0x0014
            com.google.android.gms.internal.ads.zzfev r2 = r8.zzc
            com.google.android.gms.internal.ads.zzeba r3 = r8.zzf
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r5 = "offline_open"
            r0 = r10
            r4 = r12
            com.google.android.gms.internal.ads.zzebl.zzc(r0, r1, r2, r3, r4, r5, r6)
        L_0x0014:
            com.google.android.gms.internal.ads.zzbza r0 = com.google.android.gms.ads.internal.zzt.zzo()
            boolean r0 = r0.zzx(r10)
            r1 = 0
            if (r0 == 0) goto L_0x0027
            com.google.android.gms.internal.ads.zzeba r9 = r8.zzf
            com.google.android.gms.internal.ads.zzbzw r10 = r8.zzd
            r9.zzh(r10, r12)
            return r1
        L_0x0027:
            com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.ads.internal.util.zzbr r0 = com.google.android.gms.ads.internal.util.zzs.zzv(r10)
            com.google.android.gms.ads.internal.zzt.zzp()
            androidx.core.app.NotificationManagerCompat r2 = androidx.core.app.NotificationManagerCompat.d(r10)
            boolean r2 = r2.a()
            java.lang.String r3 = "offline_notification_channel"
            com.google.android.gms.ads.internal.util.zzaa r4 = com.google.android.gms.ads.internal.zzt.zzq()
            boolean r3 = r4.zzi(r10, r3)
            r4 = r9
            com.google.android.gms.internal.ads.zzcez r4 = (com.google.android.gms.internal.ads.zzcez) r4
            com.google.android.gms.ads.internal.overlay.zzl r5 = r4.zzL()
            r6 = 1
            if (r5 == 0) goto L_0x0055
            android.app.Activity r5 = r4.zzi()
            if (r5 != 0) goto L_0x0055
            r5 = 1
            goto L_0x0056
        L_0x0055:
            r5 = 0
        L_0x0056:
            if (r2 != 0) goto L_0x0096
            com.google.android.gms.ads.internal.zzt.zzp()
            androidx.core.app.NotificationManagerCompat r2 = androidx.core.app.NotificationManagerCompat.d(r10)
            boolean r2 = r2.a()
            if (r2 == 0) goto L_0x0066
            goto L_0x0090
        L_0x0066:
            int r2 = android.os.Build.VERSION.SDK_INT
            r7 = 33
            if (r2 >= r7) goto L_0x007d
            com.google.android.gms.internal.ads.zzbbe r2 = com.google.android.gms.internal.ads.zzbbm.zzhY
            com.google.android.gms.internal.ads.zzbbk r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r7.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            goto L_0x008d
        L_0x007d:
            com.google.android.gms.internal.ads.zzbbe r2 = com.google.android.gms.internal.ads.zzbbm.zzhX
            com.google.android.gms.internal.ads.zzbbk r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r7.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
        L_0x008d:
            if (r2 == 0) goto L_0x0090
            goto L_0x0096
        L_0x0090:
            java.lang.String r9 = "notifications_disabled"
            r8.zzh(r10, r12, r9)
            return r1
        L_0x0096:
            if (r3 == 0) goto L_0x009e
            java.lang.String r9 = "notification_channel_disabled"
            r8.zzh(r10, r12, r9)
            return r1
        L_0x009e:
            if (r0 != 0) goto L_0x00a6
            java.lang.String r9 = "work_manager_unavailable"
            r8.zzh(r10, r12, r9)
            return r1
        L_0x00a6:
            if (r5 == 0) goto L_0x00ae
            java.lang.String r9 = "ad_no_activity"
            r8.zzh(r10, r12, r9)
            return r1
        L_0x00ae:
            com.google.android.gms.internal.ads.zzbbe r2 = com.google.android.gms.internal.ads.zzbbm.zzhV
            com.google.android.gms.internal.ads.zzbbk r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x00c6
            java.lang.String r9 = "notification_flow_disabled"
            r8.zzh(r10, r12, r9)
            return r1
        L_0x00c6:
            com.google.android.gms.ads.internal.overlay.zzl r2 = r4.zzL()
            if (r2 == 0) goto L_0x00f9
            com.google.android.gms.internal.ads.zzebm r2 = com.google.android.gms.internal.ads.zzebn.zzf()
            android.app.Activity r3 = r4.zzi()
            r2.zza(r3)
            r3 = 0
            r2.zzb(r3)
            r2.zze(r0)
            r2.zzc(r12)
            r2.zzd(r11)
            com.google.android.gms.internal.ads.zzebn r11 = r2.zzf()
            com.google.android.gms.ads.internal.overlay.zzl r0 = r4.zzL()     // Catch:{ Exception -> 0x00f0 }
            r0.zzf(r11)     // Catch:{ Exception -> 0x00f0 }
            goto L_0x0101
        L_0x00f0:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            r8.zzh(r10, r12, r9)
            return r1
        L_0x00f9:
            r10 = r9
            com.google.android.gms.internal.ads.zzcge r10 = (com.google.android.gms.internal.ads.zzcge) r10
            r1 = 14
            r10.zzaE(r0, r12, r11, r1)
        L_0x0101:
            r9.onAdClicked()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbit.zzk(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public final void zzl(int i2) {
        if (this.zzb != null) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzig)).booleanValue()) {
                zzfev zzfev = this.zzc;
                String zza2 = zzbcm.zza(i2);
                zzfeu zzb2 = zzfeu.zzb("cct_action");
                zzb2.zza("cct_open_status", zza2);
                zzfev.zzb(zzb2);
                return;
            }
            zzdpz zza3 = this.zzb.zza();
            zza3.zzb("action", "cct_action");
            zza3.zzb("cct_open_status", zzbcm.zza(i2));
            zza3.zzg();
        }
    }

    /* renamed from: zze */
    public final void zza(zza zza2, Map map) {
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        Object obj;
        HashMap hashMap;
        zza zza3 = zza2;
        Map map2 = map;
        zzcez zzcez = (zzcez) zza3;
        String zzc2 = zzbxy.zzc((String) map2.get("u"), zzcez.getContext(), true);
        String str2 = (String) map2.get(a.f20042a);
        if (str2 == null) {
            zzbzr.zzj("Action missing from an open GMSG.");
            return;
        }
        zzb zzb2 = this.zza;
        if (zzb2 == null || zzb2.zzc()) {
            zzezn zzD = zzcez.zzD();
            zzezq zzP = zzcez.zzP();
            boolean z5 = false;
            if (zzD == null || zzP == null) {
                str = "";
                z2 = false;
            } else {
                z2 = zzD.zzaj;
                str = zzP.zzb;
            }
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjq)).booleanValue() || !map2.containsKey("sc") || !((String) map2.get("sc")).equals("0")) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ("expand".equalsIgnoreCase(str2)) {
                if (zzcez.zzaA()) {
                    zzbzr.zzj("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzj(false);
                ((zzcge) zza3).zzaF(zzf(map), zzb(map), z3);
            } else if ("webapp".equalsIgnoreCase(str2)) {
                zzj(false);
                if (zzc2 != null) {
                    ((zzcge) zza3).zzaG(zzf(map), zzb(map), zzc2, z3);
                } else {
                    ((zzcge) zza3).zzaH(zzf(map), zzb(map), (String) map2.get("html"), (String) map2.get("baseurl"), z3);
                }
            } else if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
                Context context = zzcez.getContext();
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzem)).booleanValue()) {
                    if (((Boolean) zzba.zzc().zzb(zzbbm.zzes)).booleanValue()) {
                        zze.zza("User opt out chrome custom tab.");
                    } else {
                        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzeq)).booleanValue()) {
                            z5 = true;
                        } else {
                            String str3 = (String) zzba.zzc().zzb(zzbbm.zzer);
                            if (!str3.isEmpty() && context != null) {
                                String packageName = context.getPackageName();
                                Iterator it2 = zzfpu.zzc(zzfos.zzc(';')).zzd(str3).iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        if (((String) it2.next()).equals(packageName)) {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                z5 = true;
                            }
                        }
                    }
                }
                boolean zzg2 = zzbcn.zzg(zzcez.getContext());
                if (z5) {
                    if (!zzg2) {
                        zzl(4);
                    } else {
                        zzj(true);
                        if (TextUtils.isEmpty(zzc2)) {
                            zzbzr.zzj("Cannot open browser with null or empty url");
                            zzl(7);
                            return;
                        }
                        Uri zzd2 = zzd(zzc(zzcez.getContext(), zzcez.zzI(), Uri.parse(zzc2), zzcez.zzF(), zzcez.zzi()));
                        if (!z2 || this.zzf == null || !zzk(zza3, zzcez.getContext(), zzd2.toString(), str)) {
                            this.zzg = new zzbiq(this);
                            ((zzcge) zza3).zzaD(new zzc((String) null, zzd2.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (Intent) null, ObjectWrapper.wrap(this.zzg).asBinder(), true), z3);
                            return;
                        }
                        return;
                    }
                }
                map2.put("use_first_package", "true");
                map2.put("use_running_process", "true");
                zzi(zza2, map, z2, str, z3);
            } else if ("app".equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map2.get("system_browser"))) {
                zzi(zza2, map, z2, str, z3);
            } else if ("open_app".equalsIgnoreCase(str2)) {
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzhN)).booleanValue()) {
                    zzj(true);
                    String str4 = (String) map2.get(ContextChain.TAG_PRODUCT);
                    if (str4 == null) {
                        zzbzr.zzj("Package name missing from open app action.");
                    } else if (!z2 || this.zzf == null || !zzk(zza3, zzcez.getContext(), str4, str)) {
                        PackageManager packageManager = zzcez.getContext().getPackageManager();
                        if (packageManager == null) {
                            zzbzr.zzj("Cannot get package manager from open app action.");
                            return;
                        }
                        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str4);
                        if (launchIntentForPackage != null) {
                            ((zzcge) zza3).zzaD(new zzc(launchIntentForPackage, this.zzg), z3);
                        }
                    }
                }
            } else {
                zzj(true);
                String str5 = (String) map2.get("intent_url");
                Intent intent = null;
                if (!TextUtils.isEmpty(str5)) {
                    try {
                        intent = Intent.parseUri(str5, 0);
                    } catch (URISyntaxException e2) {
                        zzbzr.zzh("Error parsing the url: ".concat(String.valueOf(str5)), e2);
                    }
                }
                Intent intent2 = intent;
                if (!(intent2 == null || intent2.getData() == null)) {
                    Uri data = intent2.getData();
                    if (!Uri.EMPTY.equals(data)) {
                        Uri zzd3 = zzd(zzc(zzcez.getContext(), zzcez.zzI(), data, zzcez.zzF(), zzcez.zzi()));
                        if (!TextUtils.isEmpty(intent2.getType())) {
                            if (((Boolean) zzba.zzc().zzb(zzbbm.zzhO)).booleanValue()) {
                                intent2.setDataAndType(zzd3, intent2.getType());
                            }
                        }
                        intent2.setData(zzd3);
                    }
                }
                if (!((Boolean) zzba.zzc().zzb(zzbbm.zzic)).booleanValue() || !"intent_async".equalsIgnoreCase(str2) || !map2.containsKey("event_id")) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                HashMap hashMap2 = new HashMap();
                if (z4) {
                    hashMap = hashMap2;
                    obj = ContextChain.TAG_PRODUCT;
                    zzbir zzbir = r1;
                    zzbir zzbir2 = new zzbir(this, z3, zza2, hashMap2, map);
                    this.zzg = zzbir;
                    z3 = false;
                } else {
                    hashMap = hashMap2;
                    obj = ContextChain.TAG_PRODUCT;
                }
                if (intent2 == null) {
                    HashMap hashMap3 = hashMap;
                    if (!TextUtils.isEmpty(zzc2)) {
                        zzc2 = zzd(zzc(zzcez.getContext(), zzcez.zzI(), Uri.parse(zzc2), zzcez.zzF(), zzcez.zzi())).toString();
                    }
                    if (!z2 || this.zzf == null || !zzk(zza3, zzcez.getContext(), zzc2, str)) {
                        ((zzcge) zza3).zzaD(new zzc((String) map2.get(ContextChain.TAG_INFRA), zzc2, (String) map2.get("m"), (String) map2.get(obj), (String) map2.get("c"), (String) map2.get("f"), (String) map2.get("e"), this.zzg), z3);
                    } else if (z4) {
                        hashMap3.put((String) map2.get("event_id"), Boolean.TRUE);
                        ((zzblc) zza3).zzd("openIntentAsync", hashMap3);
                    }
                } else if (!z2 || this.zzf == null || !zzk(zza3, zzcez.getContext(), intent2.getData().toString(), str)) {
                    ((zzcge) zza3).zzaD(new zzc(intent2, this.zzg), z3);
                } else if (z4) {
                    HashMap hashMap4 = hashMap;
                    hashMap4.put((String) map2.get("event_id"), Boolean.TRUE);
                    ((zzblc) zza3).zzd("openIntentAsync", hashMap4);
                }
            }
        } else {
            this.zza.zzb(zzc2);
        }
    }
}
