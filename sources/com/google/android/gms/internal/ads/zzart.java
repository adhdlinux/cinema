package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzart {
    private static final String zzd = "zzart";
    protected final Context zza;
    protected boolean zzb;
    protected boolean zzc;
    private ExecutorService zze;
    private DexClassLoader zzf;
    private zzaqy zzg;
    private byte[] zzh;
    private volatile AdvertisingIdClient zzi = null;
    private volatile boolean zzj;
    private Future zzk;
    private final boolean zzl;
    /* access modifiers changed from: private */
    public volatile zzaon zzm;
    private Future zzn;
    private zzaqn zzo;
    private final Map zzp;
    private boolean zzq;
    private zzarm zzr;

    private zzart(Context context) {
        boolean z2 = false;
        this.zzj = false;
        this.zzk = null;
        this.zzm = null;
        this.zzn = null;
        this.zzb = false;
        this.zzc = false;
        this.zzq = false;
        Context applicationContext = context.getApplicationContext();
        this.zzl = applicationContext != null ? true : z2;
        context = applicationContext != null ? applicationContext : context;
        this.zza = context;
        this.zzp = new HashMap();
        if (this.zzr == null) {
            this.zzr = new zzarm(context);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(17:1|2|(1:4)|5|6|7|8|(1:10)(1:11)|12|(1:14)(1:15)|16|17|18|(2:20|(1:22)(2:23|24))|25|26|(3:27|28|(17:30|(2:32|33)|34|35|36|37|(2:39|(1:41)(2:42|43))|44|(3:46|(1:48)|49)|50|51|52|53|54|55|56|85)(3:74|75|76))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[Catch:{ zzarj -> 0x016e }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0086 A[Catch:{ IllegalArgumentException -> 0x0160, zzaqx -> 0x0167 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015a A[SYNTHETIC, Splitter:B:74:0x015a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzart zzg(android.content.Context r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r11 = "1684864811298"
            com.google.android.gms.internal.ads.zzart r0 = new com.google.android.gms.internal.ads.zzart
            r0.<init>(r9)
            com.google.android.gms.internal.ads.zzarp r9 = new com.google.android.gms.internal.ads.zzarp     // Catch:{ zzarj -> 0x016e }
            r9.<init>()     // Catch:{ zzarj -> 0x016e }
            java.util.concurrent.ExecutorService r9 = java.util.concurrent.Executors.newCachedThreadPool(r9)     // Catch:{ zzarj -> 0x016e }
            r0.zze = r9     // Catch:{ zzarj -> 0x016e }
            r0.zzj = r12     // Catch:{ zzarj -> 0x016e }
            if (r12 == 0) goto L_0x0025
            java.util.concurrent.ExecutorService r9 = r0.zze     // Catch:{ zzarj -> 0x016e }
            com.google.android.gms.internal.ads.zzarq r12 = new com.google.android.gms.internal.ads.zzarq     // Catch:{ zzarj -> 0x016e }
            r12.<init>(r0)     // Catch:{ zzarj -> 0x016e }
            java.util.concurrent.Future r9 = r9.submit(r12)     // Catch:{ zzarj -> 0x016e }
            r0.zzk = r9     // Catch:{ zzarj -> 0x016e }
        L_0x0025:
            java.util.concurrent.ExecutorService r9 = r0.zze     // Catch:{ zzarj -> 0x016e }
            com.google.android.gms.internal.ads.zzars r12 = new com.google.android.gms.internal.ads.zzars     // Catch:{ zzarj -> 0x016e }
            r12.<init>(r0)     // Catch:{ zzarj -> 0x016e }
            r9.execute(r12)     // Catch:{ zzarj -> 0x016e }
            r9 = 1
            r12 = 0
            com.google.android.gms.common.GoogleApiAvailabilityLight r1 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()     // Catch:{ all -> 0x004f }
            android.content.Context r2 = r0.zza     // Catch:{ all -> 0x004f }
            int r2 = r1.getApkVersion(r2)     // Catch:{ all -> 0x004f }
            if (r2 <= 0) goto L_0x003f
            r2 = 1
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            r0.zzb = r2     // Catch:{ all -> 0x004f }
            android.content.Context r2 = r0.zza     // Catch:{ all -> 0x004f }
            int r1 = r1.isGooglePlayServicesAvailable(r2)     // Catch:{ all -> 0x004f }
            if (r1 != 0) goto L_0x004c
            r1 = 1
            goto L_0x004d
        L_0x004c:
            r1 = 0
        L_0x004d:
            r0.zzc = r1     // Catch:{ all -> 0x004f }
        L_0x004f:
            r0.zzo(r12, r9)     // Catch:{ zzarj -> 0x016e }
            boolean r1 = com.google.android.gms.internal.ads.zzarw.zzc()     // Catch:{ zzarj -> 0x016e }
            if (r1 == 0) goto L_0x0073
            com.google.android.gms.internal.ads.zzbbe r1 = com.google.android.gms.internal.ads.zzbbm.zzcV     // Catch:{ zzarj -> 0x016e }
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ zzarj -> 0x016e }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ zzarj -> 0x016e }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ zzarj -> 0x016e }
            boolean r1 = r1.booleanValue()     // Catch:{ zzarj -> 0x016e }
            if (r1 != 0) goto L_0x006b
            goto L_0x0073
        L_0x006b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ zzarj -> 0x016e }
            java.lang.String r10 = "Task Context initialization must not be called from the UI thread."
            r9.<init>(r10)     // Catch:{ zzarj -> 0x016e }
            throw r9     // Catch:{ zzarj -> 0x016e }
        L_0x0073:
            com.google.android.gms.internal.ads.zzaqy r1 = new com.google.android.gms.internal.ads.zzaqy     // Catch:{ zzarj -> 0x016e }
            r2 = 0
            r1.<init>(r2)     // Catch:{ zzarj -> 0x016e }
            r0.zzg = r1     // Catch:{ zzarj -> 0x016e }
            java.lang.String r3 = "THDWXzjjYOq9y9/d/gcKuzbUJu6FkzolekKt4SY4cbo="
            byte[] r3 = com.google.android.gms.internal.ads.zzapd.zzb(r3, r12)     // Catch:{ IllegalArgumentException -> 0x0160 }
            int r4 = r3.length     // Catch:{ IllegalArgumentException -> 0x0160 }
            r5 = 32
            if (r4 != r5) goto L_0x015a
            r4 = 4
            r5 = 16
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r3, r4, r5)     // Catch:{ IllegalArgumentException -> 0x0160 }
            byte[] r4 = new byte[r5]     // Catch:{ IllegalArgumentException -> 0x0160 }
            r3.get(r4)     // Catch:{ IllegalArgumentException -> 0x0160 }
            r3 = 0
        L_0x0093:
            if (r3 >= r5) goto L_0x009f
            byte r6 = r4[r3]     // Catch:{ IllegalArgumentException -> 0x0160 }
            r6 = r6 ^ 68
            byte r6 = (byte) r6     // Catch:{ IllegalArgumentException -> 0x0160 }
            r4[r3] = r6     // Catch:{ IllegalArgumentException -> 0x0160 }
            int r3 = r3 + 1
            goto L_0x0093
        L_0x009f:
            r0.zzh = r4     // Catch:{ zzaqx -> 0x0167 }
            android.content.Context r1 = r0.zza     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            java.io.File r1 = r1.getCacheDir()     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            if (r1 != 0) goto L_0x00ba
            android.content.Context r1 = r0.zza     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.String r3 = "dex"
            java.io.File r1 = r1.getDir(r3, r12)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            if (r1 == 0) goto L_0x00b4
            goto L_0x00ba
        L_0x00b4:
            com.google.android.gms.internal.ads.zzarj r9 = new com.google.android.gms.internal.ads.zzarj     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            throw r9     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
        L_0x00ba:
            java.lang.String r3 = "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"
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.String r5 = "%s/%s.jar"
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r7[r12] = r1     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r7[r9] = r11     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.String r5 = java.lang.String.format(r5, r7)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            boolean r5 = r4.exists()     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            if (r5 != 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzaqy r5 = r0.zzg     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            byte[] r7 = r0.zzh     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            byte[] r3 = r5.zzb(r7, r3)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r4.createNewFile()     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r8 = 33
            if (r7 < r8) goto L_0x00ed
            r4.setReadOnly()     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
        L_0x00ed:
            int r7 = r3.length     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r5.write(r3, r12, r7)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r5.close()     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
        L_0x00f4:
            r0.zzx(r1, r11)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            dalvik.system.DexClassLoader r3 = new dalvik.system.DexClassLoader     // Catch:{ all -> 0x0129 }
            java.lang.String r5 = r4.getAbsolutePath()     // Catch:{ all -> 0x0129 }
            java.lang.String r7 = r1.getAbsolutePath()     // Catch:{ all -> 0x0129 }
            android.content.Context r8 = r0.zza     // Catch:{ all -> 0x0129 }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ all -> 0x0129 }
            r3.<init>(r5, r7, r2, r8)     // Catch:{ all -> 0x0129 }
            r0.zzf = r3     // Catch:{ all -> 0x0129 }
            zzy(r4)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r0.zzw(r1, r11)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r2[r12] = r1     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r2[r9] = r11     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.String r10 = java.lang.String.format(r10, r2)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            zzz(r10)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            com.google.android.gms.internal.ads.zzaqn r10 = new com.google.android.gms.internal.ads.zzaqn     // Catch:{ zzarj -> 0x016e }
            r10.<init>(r0)     // Catch:{ zzarj -> 0x016e }
            r0.zzo = r10     // Catch:{ zzarj -> 0x016e }
            r0.zzq = r9     // Catch:{ zzarj -> 0x016e }
            goto L_0x016e
        L_0x0129:
            r2 = move-exception
            zzy(r4)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r0.zzw(r1, r11)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r3[r12] = r1     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            r3[r9] = r11     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.String r9 = java.lang.String.format(r10, r3)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            zzz(r9)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
            throw r2     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzaqx -> 0x0145, NullPointerException -> 0x013e }
        L_0x013e:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzarj r10 = new com.google.android.gms.internal.ads.zzarj     // Catch:{ zzarj -> 0x016e }
            r10.<init>(r9)     // Catch:{ zzarj -> 0x016e }
            throw r10     // Catch:{ zzarj -> 0x016e }
        L_0x0145:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzarj r10 = new com.google.android.gms.internal.ads.zzarj     // Catch:{ zzarj -> 0x016e }
            r10.<init>(r9)     // Catch:{ zzarj -> 0x016e }
            throw r10     // Catch:{ zzarj -> 0x016e }
        L_0x014c:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzarj r10 = new com.google.android.gms.internal.ads.zzarj     // Catch:{ zzarj -> 0x016e }
            r10.<init>(r9)     // Catch:{ zzarj -> 0x016e }
            throw r10     // Catch:{ zzarj -> 0x016e }
        L_0x0153:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzarj r10 = new com.google.android.gms.internal.ads.zzarj     // Catch:{ zzarj -> 0x016e }
            r10.<init>(r9)     // Catch:{ zzarj -> 0x016e }
            throw r10     // Catch:{ zzarj -> 0x016e }
        L_0x015a:
            com.google.android.gms.internal.ads.zzaqx r9 = new com.google.android.gms.internal.ads.zzaqx     // Catch:{ IllegalArgumentException -> 0x0160 }
            r9.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x0160 }
            throw r9     // Catch:{ IllegalArgumentException -> 0x0160 }
        L_0x0160:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzaqx r10 = new com.google.android.gms.internal.ads.zzaqx     // Catch:{ zzaqx -> 0x0167 }
            r10.<init>(r1, r9)     // Catch:{ zzaqx -> 0x0167 }
            throw r10     // Catch:{ zzaqx -> 0x0167 }
        L_0x0167:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzarj r10 = new com.google.android.gms.internal.ads.zzarj     // Catch:{ zzarj -> 0x016e }
            r10.<init>(r9)     // Catch:{ zzarj -> 0x016e }
            throw r10     // Catch:{ zzarj -> 0x016e }
        L_0x016e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzart.zzg(android.content.Context, java.lang.String, java.lang.String, boolean):com.google.android.gms.internal.ads.zzart");
    }

    /* access modifiers changed from: private */
    public final void zzv() {
        try {
            if (this.zzi == null && this.zzl) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zza);
                advertisingIdClient.start();
                this.zzi = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzi = null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:20|21|22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00c3 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dc A[SYNTHETIC, Splitter:B:42:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e3 A[SYNTHETIC, Splitter:B:46:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ee A[SYNTHETIC, Splitter:B:54:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f5 A[SYNTHETIC, Splitter:B:58:0x00f5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzw(java.io.File r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r12 = "test"
            java.io.File r0 = new java.io.File
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r11
            r4 = 1
            java.lang.String r5 = "1684864811298"
            r2[r4] = r5
            java.lang.String r6 = "%s/%s.tmp"
            java.lang.String r2 = java.lang.String.format(r6, r2)
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x001f
            return
        L_0x001f:
            java.io.File r2 = new java.io.File
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r11
            r1[r4] = r5
            java.lang.String r11 = "%s/%s.dex"
            java.lang.String r11 = java.lang.String.format(r11, r1)
            r2.<init>(r11)
            boolean r11 = r2.exists()
            if (r11 != 0) goto L_0x0037
            return
        L_0x0037:
            long r6 = r2.length()
            r8 = 0
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 > 0) goto L_0x0042
            return
        L_0x0042:
            int r11 = (int) r6
            byte[] r11 = new byte[r11]
            r1 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00ea, all -> 0x00d7 }
            r4.<init>(r2)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00ea, all -> 0x00d7 }
            int r6 = r4.read(r11)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            if (r6 > 0) goto L_0x0058
            r4.close()     // Catch:{ IOException -> 0x0054 }
        L_0x0054:
            zzy(r2)
            return
        L_0x0058:
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r6.print(r12)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r6.print(r12)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r6.print(r12)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzaoq r12 = com.google.android.gms.internal.ads.zzaor.zza()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            byte[] r6 = r6.getBytes()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzgoe r7 = com.google.android.gms.internal.ads.zzgoe.zzb     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            int r7 = r6.length     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzgoe r6 = com.google.android.gms.internal.ads.zzgoe.zzv(r6, r3, r7)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r12.zzc(r6)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            byte[] r5 = r5.getBytes()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            int r6 = r5.length     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzgoe r5 = com.google.android.gms.internal.ads.zzgoe.zzv(r5, r3, r6)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r12.zzd(r5)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzaqy r5 = r10.zzg     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            byte[] r6 = r10.zzh     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            java.lang.String r11 = r5.zza(r6, r11)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            byte[] r11 = r11.getBytes()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            int r5 = r11.length     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzgoe r5 = com.google.android.gms.internal.ads.zzgoe.zzv(r11, r3, r5)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r12.zza(r5)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            byte[] r11 = com.google.android.gms.internal.ads.zzaph.zze(r11)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            int r5 = r11.length     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzgoe r11 = com.google.android.gms.internal.ads.zzgoe.zzv(r11, r3, r5)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r12.zzb(r11)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r0.createNewFile()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r11.<init>(r0)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzgpm r12 = r12.zzal()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00ca }
            com.google.android.gms.internal.ads.zzaor r12 = (com.google.android.gms.internal.ads.zzaor) r12     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00ca }
            byte[] r12 = r12.zzax()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00ca }
            int r0 = r12.length     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00ca }
            r11.write(r12, r3, r0)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00ca }
            r11.close()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00ca }
            r4.close()     // Catch:{ IOException -> 0x00c3 }
        L_0x00c3:
            r11.close()     // Catch:{ IOException -> 0x00c6 }
        L_0x00c6:
            zzy(r2)
            return
        L_0x00ca:
            r12 = move-exception
            goto L_0x00d1
        L_0x00cc:
            goto L_0x00d5
        L_0x00ce:
            r11 = move-exception
            r12 = r11
            r11 = r1
        L_0x00d1:
            r1 = r4
            goto L_0x00da
        L_0x00d3:
            r11 = r1
        L_0x00d5:
            r1 = r4
            goto L_0x00ec
        L_0x00d7:
            r11 = move-exception
            r12 = r11
            r11 = r1
        L_0x00da:
            if (r1 == 0) goto L_0x00e1
            r1.close()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x00e1
        L_0x00e0:
        L_0x00e1:
            if (r11 == 0) goto L_0x00e6
            r11.close()     // Catch:{ IOException -> 0x00e6 }
        L_0x00e6:
            zzy(r2)
            throw r12
        L_0x00ea:
            r11 = r1
        L_0x00ec:
            if (r1 == 0) goto L_0x00f3
            r1.close()     // Catch:{ IOException -> 0x00f2 }
            goto L_0x00f3
        L_0x00f2:
        L_0x00f3:
            if (r11 == 0) goto L_0x00f8
            r11.close()     // Catch:{ IOException -> 0x00f8 }
        L_0x00f8:
            zzy(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzart.zzw(java.io.File, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:31|32|33|34|35|36|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e0, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e5, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00dd */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[ExcHandler: zzaqx | IOException | NoSuchAlgorithmException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:12:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ed A[SYNTHETIC, Splitter:B:61:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f4 A[SYNTHETIC, Splitter:B:65:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00fc A[SYNTHETIC, Splitter:B:72:0x00fc] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0103 A[SYNTHETIC, Splitter:B:76:0x0103] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzx(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.io.File r11 = new java.io.File
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r10
            r3 = 1
            java.lang.String r4 = "1684864811298"
            r1[r3] = r4
            java.lang.String r5 = "%s/%s.tmp"
            java.lang.String r1 = java.lang.String.format(r5, r1)
            r11.<init>(r1)
            boolean r1 = r11.exists()
            if (r1 != 0) goto L_0x001d
            return r2
        L_0x001d:
            java.io.File r1 = new java.io.File
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r10
            r0[r3] = r4
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r0)
            r1.<init>(r10)
            boolean r10 = r1.exists()
            if (r10 != 0) goto L_0x0106
            r10 = 0
            long r5 = r11.length()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00f8, all -> 0x00e9 }
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x0043
            zzy(r11)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00f8, all -> 0x00e9 }
            return r2
        L_0x0043:
            int r0 = (int) r5     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00f8, all -> 0x00e9 }
            byte[] r0 = new byte[r0]     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00f8, all -> 0x00e9 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00f8, all -> 0x00e9 }
            r5.<init>(r11)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00f8, all -> 0x00e9 }
            int r6 = r5.read(r0)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            if (r6 > 0) goto L_0x005f
            java.lang.String r0 = zzd     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r0, r1)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            zzy(r11)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            r5.close()     // Catch:{ IOException -> 0x005e }
        L_0x005e:
            return r2
        L_0x005f:
            com.google.android.gms.internal.ads.zzgoy r6 = com.google.android.gms.internal.ads.zzgoy.zza()     // Catch:{ NullPointerException -> 0x00dd, zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5 }
            com.google.android.gms.internal.ads.zzaor r0 = com.google.android.gms.internal.ads.zzaor.zzd(r0, r6)     // Catch:{ NullPointerException -> 0x00dd, zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            com.google.android.gms.internal.ads.zzgoe r7 = r0.zzh()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r7 = r7.zzA()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            r6.<init>(r7)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            boolean r4 = r4.equals(r6)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            if (r4 == 0) goto L_0x00d6
            com.google.android.gms.internal.ads.zzgoe r4 = r0.zzf()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r4 = r4.zzA()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            com.google.android.gms.internal.ads.zzgoe r6 = r0.zze()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r6 = r6.zzA()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r6 = com.google.android.gms.internal.ads.zzaph.zze(r6)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            boolean r4 = java.util.Arrays.equals(r4, r6)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            if (r4 == 0) goto L_0x00d6
            com.google.android.gms.internal.ads.zzgoe r4 = r0.zzg()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r4 = r4.zzA()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            boolean r4 = java.util.Arrays.equals(r4, r6)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            if (r4 != 0) goto L_0x00a9
            goto L_0x00d6
        L_0x00a9:
            com.google.android.gms.internal.ads.zzaqy r11 = r9.zzg     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r4 = r9.zzh     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            com.google.android.gms.internal.ads.zzgoe r0 = r0.zze()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r0 = r0.zzA()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            r6.<init>(r0)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r11 = r11.zzb(r4, r6)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            r1.createNewFile()     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            r0.<init>(r1)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            int r10 = r11.length     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d4, all -> 0x00d1 }
            r0.write(r11, r2, r10)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00d4, all -> 0x00d1 }
            r5.close()     // Catch:{ IOException -> 0x00cd }
        L_0x00cd:
            r0.close()     // Catch:{ IOException -> 0x00d0 }
        L_0x00d0:
            return r3
        L_0x00d1:
            r10 = move-exception
            r11 = r10
            goto L_0x00e3
        L_0x00d4:
            goto L_0x00e7
        L_0x00d6:
            zzy(r11)     // Catch:{ zzaqx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            r5.close()     // Catch:{ IOException -> 0x00dc }
        L_0x00dc:
            return r2
        L_0x00dd:
            r5.close()     // Catch:{ IOException -> 0x00e0 }
        L_0x00e0:
            return r2
        L_0x00e1:
            r11 = move-exception
            r0 = r10
        L_0x00e3:
            r10 = r5
            goto L_0x00eb
        L_0x00e5:
            r0 = r10
        L_0x00e7:
            r10 = r5
            goto L_0x00fa
        L_0x00e9:
            r11 = move-exception
            r0 = r10
        L_0x00eb:
            if (r10 == 0) goto L_0x00f2
            r10.close()     // Catch:{ IOException -> 0x00f1 }
            goto L_0x00f2
        L_0x00f1:
        L_0x00f2:
            if (r0 == 0) goto L_0x00f7
            r0.close()     // Catch:{ IOException -> 0x00f7 }
        L_0x00f7:
            throw r11
        L_0x00f8:
            r0 = r10
        L_0x00fa:
            if (r10 == 0) goto L_0x0101
            r10.close()     // Catch:{ IOException -> 0x0100 }
            goto L_0x0101
        L_0x0100:
        L_0x0101:
            if (r0 == 0) goto L_0x0106
            r0.close()     // Catch:{ IOException -> 0x0106 }
        L_0x0106:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzart.zzx(java.io.File, java.lang.String):boolean");
    }

    private static final void zzy(File file) {
        if (!file.exists()) {
            Log.d(zzd, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
            return;
        }
        file.delete();
    }

    private static final void zzz(String str) {
        zzy(new File(str));
    }

    public final int zza() {
        if (this.zzo != null) {
            return zzaqn.zzd();
        }
        return Integer.MIN_VALUE;
    }

    public final Context zzb() {
        return this.zza;
    }

    public final zzaon zzc() {
        return this.zzm;
    }

    public final zzaqn zzd() {
        return this.zzo;
    }

    public final zzaqy zze() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final zzarm zzf() {
        return this.zzr;
    }

    public final AdvertisingIdClient zzh() {
        if (!this.zzj) {
            return null;
        }
        if (this.zzi != null) {
            return this.zzi;
        }
        Future future = this.zzk;
        if (future != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.zzk = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzk.cancel(true);
            }
        }
        return this.zzi;
    }

    public final DexClassLoader zzi() {
        return this.zzf;
    }

    public final Method zzj(String str, String str2) {
        zzatg zzatg = (zzatg) this.zzp.get(new Pair(str, str2));
        if (zzatg == null) {
            return null;
        }
        return zzatg.zza();
    }

    public final ExecutorService zzk() {
        return this.zze;
    }

    public final Future zzl() {
        return this.zzn;
    }

    /* access modifiers changed from: package-private */
    public final void zzo(int i2, boolean z2) {
        if (this.zzc) {
            Future<?> submit = this.zze.submit(new zzarr(this, i2, true));
            if (i2 == 0) {
                this.zzn = submit;
            }
        }
    }

    public final boolean zzp() {
        return this.zzc;
    }

    public final boolean zzq() {
        return this.zzb;
    }

    public final boolean zzr() {
        return this.zzq;
    }

    public final boolean zzs() {
        return this.zzr.zza();
    }

    public final boolean zzt(String str, String str2, Class... clsArr) {
        Pair pair = new Pair(str, str2);
        if (this.zzp.containsKey(pair)) {
            return false;
        }
        this.zzp.put(pair, new zzatg(this, str, str2, clsArr));
        return true;
    }

    public final byte[] zzu() {
        return this.zzh;
    }
}
