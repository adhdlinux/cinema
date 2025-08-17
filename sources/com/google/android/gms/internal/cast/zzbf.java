package com.google.android.gms.internal.cast;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;
import androidx.mediarouter.media.MediaTransferReceiver;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzn;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzbf extends zzak {
    private static final Logger zza = new Logger("MediaRouterProxy");
    private final MediaRouter zzb;
    private final CastOptions zzc;
    private final Map zzd = new HashMap();
    private zzbm zze;
    private boolean zzf;

    public zzbf(Context context, MediaRouter mediaRouter, CastOptions castOptions, zzn zzn) {
        this.zzb = mediaRouter;
        this.zzc = castOptions;
        if (Build.VERSION.SDK_INT <= 32) {
            zza.i("Don't need to set MediaRouterParams for Android S v2 or below", new Object[0]);
            return;
        }
        zza.d("Set up MediaRouterParams based on module flag and CastOptions for Android T or above", new Object[0]);
        this.zze = new zzbm(castOptions);
        Intent intent = new Intent(context, MediaTransferReceiver.class);
        intent.setPackage(context.getPackageName());
        boolean z2 = !context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty();
        this.zzf = z2;
        if (z2) {
            zzr.zzd(zzln.CAST_OUTPUT_SWITCHER_ENABLED);
        }
        zzn.zza(new String[]{"com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED"}).addOnCompleteListener(new zzbd(this, castOptions));
    }

    private final void zzt(MediaRouteSelector mediaRouteSelector, int i2) {
        Set<MediaRouter.Callback> set = (Set) this.zzd.get(mediaRouteSelector);
        if (set != null) {
            for (MediaRouter.Callback b2 : set) {
                this.zzb.b(mediaRouteSelector, b2, i2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzu */
    public final void zzq(MediaRouteSelector mediaRouteSelector) {
        Set<MediaRouter.Callback> set = (Set) this.zzd.get(mediaRouteSelector);
        if (set != null) {
            for (MediaRouter.Callback s2 : set) {
                this.zzb.s(s2);
            }
        }
    }

    public final Bundle zzb(String str) {
        for (MediaRouter.RouteInfo next : this.zzb.m()) {
            if (next.k().equals(str)) {
                return next.i();
            }
        }
        return null;
    }

    public final String zzc() {
        return this.zzb.n().k();
    }

    public final void zzd(Bundle bundle, int i2) {
        MediaRouteSelector d2 = MediaRouteSelector.d(bundle);
        if (d2 != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                zzt(d2, i2);
            } else {
                new zzdy(Looper.getMainLooper()).post(new zzbc(this, d2, i2));
            }
        }
    }

    public final void zze(Bundle bundle, zzan zzan) {
        MediaRouteSelector d2 = MediaRouteSelector.d(bundle);
        if (d2 != null) {
            if (!this.zzd.containsKey(d2)) {
                this.zzd.put(d2, new HashSet());
            }
            ((Set) this.zzd.get(d2)).add(new zzas(zzan));
        }
    }

    public final void zzf() {
        for (Set<MediaRouter.Callback> it2 : this.zzd.values()) {
            for (MediaRouter.Callback s2 : it2) {
                this.zzb.s(s2);
            }
        }
        this.zzd.clear();
    }

    public final void zzg(Bundle bundle) {
        MediaRouteSelector d2 = MediaRouteSelector.d(bundle);
        if (d2 != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                zzq(d2);
            } else {
                new zzdy(Looper.getMainLooper()).post(new zzbe(this, d2));
            }
        }
    }

    public final void zzh() {
        MediaRouter mediaRouter = this.zzb;
        mediaRouter.u(mediaRouter.g());
    }

    public final void zzi(String str) {
        zza.d("select route with routeId = %s", str);
        for (MediaRouter.RouteInfo next : this.zzb.m()) {
            if (next.k().equals(str)) {
                zza.d("media route is found and selected", new Object[0]);
                this.zzb.u(next);
                return;
            }
        }
    }

    public final void zzj(int i2) {
        this.zzb.z(i2);
    }

    public final boolean zzk() {
        MediaRouter.RouteInfo f2 = this.zzb.f();
        if (f2 == null || !this.zzb.n().k().equals(f2.k())) {
            return false;
        }
        return true;
    }

    public final boolean zzl() {
        MediaRouter.RouteInfo g2 = this.zzb.g();
        if (g2 == null || !this.zzb.n().k().equals(g2.k())) {
            return false;
        }
        return true;
    }

    public final boolean zzm(Bundle bundle, int i2) {
        MediaRouteSelector d2 = MediaRouteSelector.d(bundle);
        if (d2 == null) {
            return false;
        }
        return this.zzb.q(d2, i2);
    }

    public final zzbm zzn() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(MediaRouteSelector mediaRouteSelector, int i2) {
        synchronized (this.zzd) {
            zzt(mediaRouteSelector, i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzp(com.google.android.gms.cast.framework.CastOptions r8, com.google.android.gms.tasks.Task r9) {
        /*
            r7 = this;
            boolean r0 = r9.isSuccessful()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0034
            java.lang.Object r9 = r9.getResult()
            android.os.Bundle r9 = (android.os.Bundle) r9
            java.lang.String r0 = "com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED"
            if (r9 == 0) goto L_0x001a
            boolean r3 = r9.containsKey(r0)
            if (r3 == 0) goto L_0x001a
            r3 = 1
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            com.google.android.gms.cast.internal.Logger r4 = zza
            java.lang.Object[] r5 = new java.lang.Object[r2]
            if (r2 == r3) goto L_0x0024
            java.lang.String r6 = "not existed"
            goto L_0x0026
        L_0x0024:
            java.lang.String r6 = "existed"
        L_0x0026:
            r5[r1] = r6
            java.lang.String r6 = "The module-to-client output switcher flag %s"
            r4.d(r6, r5)
            if (r3 == 0) goto L_0x0034
            boolean r9 = r9.getBoolean(r0)
            goto L_0x0035
        L_0x0034:
            r9 = 1
        L_0x0035:
            com.google.android.gms.cast.internal.Logger r0 = zza
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r9)
            r4[r1] = r5
            boolean r5 = r8.zzh()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r4[r2] = r5
            java.lang.String r5 = "Set up output switcher flags: %b (from module), %b (from CastOptions)"
            r0.i(r5, r4)
            if (r9 == 0) goto L_0x0059
            boolean r8 = r8.zzh()
            if (r8 == 0) goto L_0x0059
            r8 = 1
            goto L_0x005a
        L_0x0059:
            r8 = 0
        L_0x005a:
            androidx.mediarouter.media.MediaRouter r9 = r7.zzb
            if (r9 == 0) goto L_0x00bf
            com.google.android.gms.cast.framework.CastOptions r4 = r7.zzc
            if (r4 != 0) goto L_0x0063
            goto L_0x00bf
        L_0x0063:
            boolean r5 = r4.zzf()
            boolean r4 = r4.zzd()
            androidx.mediarouter.media.MediaRouterParams$Builder r6 = new androidx.mediarouter.media.MediaRouterParams$Builder
            r6.<init>()
            androidx.mediarouter.media.MediaRouterParams$Builder r6 = r6.c(r8)
            androidx.mediarouter.media.MediaRouterParams$Builder r6 = r6.e(r5)
            androidx.mediarouter.media.MediaRouterParams$Builder r6 = r6.d(r4)
            androidx.mediarouter.media.MediaRouterParams r6 = r6.a()
            r9.x(r6)
            r9 = 4
            java.lang.Object[] r9 = new java.lang.Object[r9]
            boolean r6 = r7.zzf
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r9[r1] = r6
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r9[r2] = r8
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r5)
            r9[r3] = r8
            r8 = 3
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
            r9[r8] = r1
            java.lang.String r8 = "media transfer = %b, session transfer = %b, transfer to local = %b, in-app output switcher = %b"
            r0.i(r8, r9)
            if (r5 == 0) goto L_0x00bf
            androidx.mediarouter.media.MediaRouter r8 = r7.zzb
            com.google.android.gms.internal.cast.zzbb r9 = new com.google.android.gms.internal.cast.zzbb
            com.google.android.gms.internal.cast.zzbm r0 = r7.zze
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.internal.cast.zzbm r0 = (com.google.android.gms.internal.cast.zzbm) r0
            r9.<init>(r0)
            r8.w(r9)
            com.google.android.gms.internal.cast.zzln r8 = com.google.android.gms.internal.cast.zzln.CAST_TRANSFER_TO_LOCAL_ENABLED
            com.google.android.gms.internal.cast.zzr.zzd(r8)
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzbf.zzp(com.google.android.gms.cast.framework.CastOptions, com.google.android.gms.tasks.Task):void");
    }

    public final void zzr(MediaSessionCompat mediaSessionCompat) {
        this.zzb.v(mediaSessionCompat);
    }

    public final boolean zzs() {
        return this.zzf;
    }
}
