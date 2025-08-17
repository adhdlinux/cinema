package com.google.android.gms.cast;

import com.google.android.gms.tasks.OnCompleteListener;

final class zzam implements OnCompleteListener {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    zzam(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        com.google.android.gms.cast.CastRemoteDisplayLocalService.zzl(r4.zza, (android.view.Display) r5.getResult());
        com.google.android.gms.cast.CastRemoteDisplayLocalService.zzd.set(false);
        r5 = r4.zza;
        r0 = r5.zzo;
        r5 = r5.zzp;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
        if (r0 == null) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
        if (r5 == null) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.google.android.gms.common.stats.ConnectionTracker.getInstance().unbindService(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        com.google.android.gms.cast.CastRemoteDisplayLocalService.zza.d("No need to unbind service, already unbound", new java.lang.Object[0]);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onComplete(com.google.android.gms.tasks.Task r5) {
        /*
            r4 = this;
            boolean r0 = r5.isSuccessful()
            r1 = 0
            if (r0 != 0) goto L_0x0018
            com.google.android.gms.cast.internal.Logger r5 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zza
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "Connection was not successful"
            r5.e(r1, r0)
            com.google.android.gms.cast.CastRemoteDisplayLocalService r5 = r4.zza
            com.google.android.gms.cast.CastRemoteDisplayLocalService.zzo(r5)
            return
        L_0x0018:
            com.google.android.gms.cast.internal.Logger r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zza
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "startRemoteDisplay successful"
            r0.d(r3, r2)
            java.lang.Object r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzc
            monitor-enter(r0)
            com.google.android.gms.cast.CastRemoteDisplayLocalService r2 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zze     // Catch:{ all -> 0x0080 }
            if (r2 != 0) goto L_0x0040
            com.google.android.gms.cast.internal.Logger r5 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zza     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = "Remote Display started but session already cancelled"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0080 }
            r5.d(r2, r1)     // Catch:{ all -> 0x0080 }
            com.google.android.gms.cast.CastRemoteDisplayLocalService r5 = r4.zza     // Catch:{ all -> 0x0080 }
            com.google.android.gms.cast.CastRemoteDisplayLocalService.zzo(r5)     // Catch:{ all -> 0x0080 }
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            return
        L_0x0040:
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            java.lang.Object r5 = r5.getResult()
            android.view.Display r5 = (android.view.Display) r5
            com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = r4.zza
            com.google.android.gms.cast.CastRemoteDisplayLocalService.zzl(r0, r5)
            java.util.concurrent.atomic.AtomicBoolean r5 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzd
            r5.set(r1)
            com.google.android.gms.cast.CastRemoteDisplayLocalService r5 = r4.zza
            android.content.Context r0 = r5.zzo
            android.content.ServiceConnection r5 = r5.zzp
            if (r0 == 0) goto L_0x0074
            if (r5 == 0) goto L_0x0074
            com.google.android.gms.common.stats.ConnectionTracker r2 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x0069 }
            r2.unbindService(r0, r5)     // Catch:{ IllegalArgumentException -> 0x0069 }
            goto L_0x0074
        L_0x0069:
            com.google.android.gms.cast.internal.Logger r5 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zza
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "No need to unbind service, already unbound"
            r5.d(r1, r0)
        L_0x0074:
            com.google.android.gms.cast.CastRemoteDisplayLocalService r5 = r4.zza
            r0 = 0
            r5.zzp = null
            com.google.android.gms.cast.CastRemoteDisplayLocalService r5 = r4.zza
            r5.zzo = null
            return
        L_0x0080:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.zzam.onComplete(com.google.android.gms.tasks.Task):void");
    }
}
