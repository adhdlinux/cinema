package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class zzccu implements zzge {
    private final Context zza;
    private final zzge zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze = ((Boolean) zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue();
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzawl zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private final AtomicLong zzl = new AtomicLong(-1);
    private zzgj zzm;

    public zzccu(Context context, zzge zzge, String str, int i2, zzhg zzhg, zzcct zzcct) {
        this.zza = context;
        this.zzb = zzge;
        this.zzc = str;
        this.zzd = i2;
    }

    private final boolean zzg() {
        if (!this.zze) {
            return false;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzeb)).booleanValue() && !this.zzj) {
            return true;
        }
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzec)).booleanValue() || this.zzk) {
            return false;
        }
        return true;
    }

    public final int zza(byte[] bArr, int i2, int i3) throws IOException {
        if (this.zzg) {
            InputStream inputStream = this.zzf;
            if (inputStream != null) {
                return inputStream.read(bArr, i2, i3);
            }
            return this.zzb.zza(bArr, i2, i3);
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r13.cancel(false);
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00bd, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r13.cancel(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c1, code lost:
        com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c8, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c9, code lost:
        com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d0, code lost:
        throw null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:19:0x00ac, B:23:0x00be] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x00ac */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00be */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzgj r13) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.zzg
            if (r0 != 0) goto L_0x013f
            r0 = 1
            r12.zzg = r0
            android.net.Uri r0 = r13.zza
            r12.zzh = r0
            r12.zzm = r13
            com.google.android.gms.internal.ads.zzawl r0 = com.google.android.gms.internal.ads.zzawl.zza(r0)
            r12.zzi = r0
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzdY
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x00d1
            com.google.android.gms.internal.ads.zzawl r0 = r12.zzi
            if (r0 == 0) goto L_0x0118
            com.google.android.gms.internal.ads.zzawl r0 = r12.zzi
            long r2 = r13.zzf
            r0.zzh = r2
            com.google.android.gms.internal.ads.zzawl r13 = r12.zzi
            java.lang.String r0 = r12.zzc
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfpw.zzc(r0)
            r13.zzi = r0
            com.google.android.gms.internal.ads.zzawl r13 = r12.zzi
            int r0 = r12.zzd
            r13.zzj = r0
            com.google.android.gms.internal.ads.zzawl r13 = r12.zzi
            boolean r13 = r13.zzg
            if (r13 == 0) goto L_0x0053
            com.google.android.gms.internal.ads.zzbbe r13 = com.google.android.gms.internal.ads.zzbbm.zzea
            com.google.android.gms.internal.ads.zzbbk r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r13 = r0.zzb(r13)
            java.lang.Long r13 = (java.lang.Long) r13
            goto L_0x005f
        L_0x0053:
            com.google.android.gms.internal.ads.zzbbe r13 = com.google.android.gms.internal.ads.zzbbm.zzdZ
            com.google.android.gms.internal.ads.zzbbk r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r13 = r0.zzb(r13)
            java.lang.Long r13 = (java.lang.Long) r13
        L_0x005f:
            long r2 = r13.longValue()
            com.google.android.gms.common.util.Clock r13 = com.google.android.gms.ads.internal.zzt.zzB()
            r13.elapsedRealtime()
            com.google.android.gms.ads.internal.zzt.zzd()
            android.content.Context r13 = r12.zza
            com.google.android.gms.internal.ads.zzawl r0 = r12.zzi
            java.util.concurrent.Future r13 = com.google.android.gms.internal.ads.zzaww.zza(r13, r0)
            r0 = 0
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException | TimeoutException -> 0x00be, InterruptedException -> 0x00ac }
            java.lang.Object r2 = r13.get(r2, r4)     // Catch:{ ExecutionException | TimeoutException -> 0x00be, InterruptedException -> 0x00ac }
            com.google.android.gms.internal.ads.zzawx r2 = (com.google.android.gms.internal.ads.zzawx) r2     // Catch:{ ExecutionException | TimeoutException -> 0x00be, InterruptedException -> 0x00ac }
            r2.zzd()     // Catch:{ ExecutionException | TimeoutException -> 0x00be, InterruptedException -> 0x00ac }
            boolean r3 = r2.zzf()     // Catch:{ ExecutionException | TimeoutException -> 0x00be, InterruptedException -> 0x00ac }
            r12.zzj = r3     // Catch:{ ExecutionException | TimeoutException -> 0x00be, InterruptedException -> 0x00ac }
            boolean r3 = r2.zze()     // Catch:{ ExecutionException | TimeoutException -> 0x00be, InterruptedException -> 0x00ac }
            r12.zzk = r3     // Catch:{ ExecutionException | TimeoutException -> 0x00be, InterruptedException -> 0x00ac }
            r2.zza()     // Catch:{ ExecutionException | TimeoutException -> 0x00be, InterruptedException -> 0x00ac }
            boolean r3 = r12.zzg()     // Catch:{ ExecutionException | TimeoutException -> 0x00be, InterruptedException -> 0x00ac }
            if (r3 != 0) goto L_0x00a4
            java.io.InputStream r2 = r2.zzc()     // Catch:{ ExecutionException | TimeoutException -> 0x00be, InterruptedException -> 0x00ac }
            r12.zzf = r2     // Catch:{ ExecutionException | TimeoutException -> 0x00be, InterruptedException -> 0x00ac }
            com.google.android.gms.common.util.Clock r13 = com.google.android.gms.ads.internal.zzt.zzB()
            r13.elapsedRealtime()
            throw r1
        L_0x00a4:
            com.google.android.gms.common.util.Clock r13 = com.google.android.gms.ads.internal.zzt.zzB()
            r13.elapsedRealtime()
            throw r1
        L_0x00ac:
            r13.cancel(r0)     // Catch:{ all -> 0x00c9 }
            java.lang.Thread r13 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00c9 }
            r13.interrupt()     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.common.util.Clock r13 = com.google.android.gms.ads.internal.zzt.zzB()
            r13.elapsedRealtime()
            throw r1
        L_0x00be:
            r13.cancel(r0)     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.common.util.Clock r13 = com.google.android.gms.ads.internal.zzt.zzB()
            r13.elapsedRealtime()
            throw r1
        L_0x00c9:
            com.google.android.gms.common.util.Clock r13 = com.google.android.gms.ads.internal.zzt.zzB()
            r13.elapsedRealtime()
            throw r1
        L_0x00d1:
            com.google.android.gms.internal.ads.zzawl r0 = r12.zzi
            if (r0 == 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzawl r0 = r12.zzi
            long r1 = r13.zzf
            r0.zzh = r1
            com.google.android.gms.internal.ads.zzawl r0 = r12.zzi
            java.lang.String r1 = r12.zzc
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfpw.zzc(r1)
            r0.zzi = r1
            com.google.android.gms.internal.ads.zzawl r0 = r12.zzi
            int r1 = r12.zzd
            r0.zzj = r1
            com.google.android.gms.internal.ads.zzawh r0 = com.google.android.gms.ads.internal.zzt.zzc()
            com.google.android.gms.internal.ads.zzawl r1 = r12.zzi
            com.google.android.gms.internal.ads.zzawi r1 = r0.zzb(r1)
        L_0x00f5:
            if (r1 == 0) goto L_0x0118
            boolean r0 = r1.zze()
            if (r0 == 0) goto L_0x0118
            boolean r0 = r1.zzg()
            r12.zzj = r0
            boolean r0 = r1.zzf()
            r12.zzk = r0
            boolean r0 = r12.zzg()
            if (r0 != 0) goto L_0x0118
            java.io.InputStream r13 = r1.zzc()
            r12.zzf = r13
            r0 = -1
            return r0
        L_0x0118:
            com.google.android.gms.internal.ads.zzawl r0 = r12.zzi
            if (r0 == 0) goto L_0x0136
            com.google.android.gms.internal.ads.zzgj r0 = new com.google.android.gms.internal.ads.zzgj
            com.google.android.gms.internal.ads.zzawl r1 = r12.zzi
            java.lang.String r1 = r1.zza
            android.net.Uri r2 = android.net.Uri.parse(r1)
            r3 = 0
            long r4 = r13.zze
            long r6 = r13.zzf
            long r8 = r13.zzg
            r10 = 0
            int r11 = r13.zzi
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r8, r10, r11)
            r12.zzm = r0
        L_0x0136:
            com.google.android.gms.internal.ads.zzge r13 = r12.zzb
            com.google.android.gms.internal.ads.zzgj r0 = r12.zzm
            long r0 = r13.zzb(r0)
            return r0
        L_0x013f:
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r0 = "Attempt to open an already open CacheDataSource."
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccu.zzb(com.google.android.gms.internal.ads.zzgj):long");
    }

    public final Uri zzc() {
        return this.zzh;
    }

    public final void zzd() throws IOException {
        if (this.zzg) {
            this.zzg = false;
            this.zzh = null;
            InputStream inputStream = this.zzf;
            if (inputStream != null) {
                IOUtils.closeQuietly((Closeable) inputStream);
                this.zzf = null;
                return;
            }
            this.zzb.zzd();
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    public final /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    public final void zzf(zzhg zzhg) {
    }
}
