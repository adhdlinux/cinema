package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.imageutils.JfifUtil;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class zzamg implements zzaku {
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final zzamf zzc;
    private final int zzd;

    public zzamg(zzamf zzamf, int i2) {
        this.zzc = zzamf;
        this.zzd = 5242880;
    }

    static int zze(InputStream inputStream) throws IOException {
        return (zzn(inputStream) << 24) | zzn(inputStream) | (zzn(inputStream) << 8) | (zzn(inputStream) << 16);
    }

    static long zzf(InputStream inputStream) throws IOException {
        return (((long) zzn(inputStream)) & 255) | ((((long) zzn(inputStream)) & 255) << 8) | ((((long) zzn(inputStream)) & 255) << 16) | ((((long) zzn(inputStream)) & 255) << 24) | ((((long) zzn(inputStream)) & 255) << 32) | ((((long) zzn(inputStream)) & 255) << 40) | ((((long) zzn(inputStream)) & 255) << 48) | ((((long) zzn(inputStream)) & 255) << 56);
    }

    static String zzh(zzame zzame) throws IOException {
        return new String(zzm(zzame, zzf(zzame)), "UTF-8");
    }

    static void zzj(OutputStream outputStream, int i2) throws IOException {
        outputStream.write(i2 & JfifUtil.MARKER_FIRST_BYTE);
        outputStream.write((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE);
        outputStream.write((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE);
        outputStream.write((i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE);
    }

    static void zzk(OutputStream outputStream, long j2) throws IOException {
        outputStream.write((byte) ((int) j2));
        outputStream.write((byte) ((int) (j2 >>> 8)));
        outputStream.write((byte) ((int) (j2 >>> 16)));
        outputStream.write((byte) ((int) (j2 >>> 24)));
        outputStream.write((byte) ((int) (j2 >>> 32)));
        outputStream.write((byte) ((int) (j2 >>> 40)));
        outputStream.write((byte) ((int) (j2 >>> 48)));
        outputStream.write((byte) ((int) (j2 >>> 56)));
    }

    static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzk(outputStream, (long) length);
        outputStream.write(bytes, 0, length);
    }

    static byte[] zzm(zzame zzame, long j2) throws IOException {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        long zza2 = zzame.zza();
        if (i2 >= 0 && j2 <= zza2) {
            int i3 = (int) j2;
            if (((long) i3) == j2) {
                byte[] bArr = new byte[i3];
                new DataInputStream(zzame).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j2 + ", maxLength=" + zza2);
    }

    private static int zzn(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private final void zzo(String str, zzamd zzamd) {
        if (!this.zza.containsKey(str)) {
            this.zzb += zzamd.zza;
        } else {
            this.zzb += zzamd.zza - ((zzamd) this.zza.get(str)).zza;
        }
        this.zza.put(str, zzamd);
    }

    private final void zzp(String str) {
        zzamd zzamd = (zzamd) this.zza.remove(str);
        if (zzamd != null) {
            this.zzb -= zzamd.zza;
        }
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    public final synchronized zzakt zza(String str) {
        zzame zzame;
        zzamd zzamd = (zzamd) this.zza.get(str);
        if (zzamd == null) {
            return null;
        }
        File zzg = zzg(str);
        try {
            zzame = new zzame(new BufferedInputStream(new FileInputStream(zzg)), zzg.length());
            zzamd zza2 = zzamd.zza(zzame);
            if (!TextUtils.equals(str, zza2.zzb)) {
                zzalw.zza("%s: key=%s, found=%s", zzg.getAbsolutePath(), str, zza2.zzb);
                zzp(str);
                zzame.close();
                return null;
            }
            byte[] zzm = zzm(zzame, zzame.zza());
            zzakt zzakt = new zzakt();
            zzakt.zza = zzm;
            zzakt.zzb = zzamd.zzc;
            zzakt.zzc = zzamd.zzd;
            zzakt.zzd = zzamd.zze;
            zzakt.zze = zzamd.zzf;
            zzakt.zzf = zzamd.zzg;
            List<zzalc> list = zzamd.zzh;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzalc zzalc : list) {
                treeMap.put(zzalc.zza(), zzalc.zzb());
            }
            zzakt.zzg = treeMap;
            zzakt.zzh = Collections.unmodifiableList(zzamd.zzh);
            zzame.close();
            return zzakt;
        } catch (IOException e2) {
            zzalw.zza("%s: %s", zzg.getAbsolutePath(), e2.toString());
            zzi(str);
            return null;
        } catch (Throwable th) {
            zzame.close();
            throw th;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.google.android.gms.internal.ads.zzamf r0 = r8.zzc     // Catch:{ all -> 0x0062 }
            java.io.File r0 = r0.zza()     // Catch:{ all -> 0x0062 }
            boolean r1 = r0.exists()     // Catch:{ all -> 0x0062 }
            r2 = 0
            if (r1 != 0) goto L_0x0026
            boolean r1 = r0.mkdirs()     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0024
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0062 }
            r1[r2] = r0     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = "Unable to create cache dir %s"
            com.google.android.gms.internal.ads.zzalw.zzb(r0, r1)     // Catch:{ all -> 0x0062 }
            monitor-exit(r8)
            return
        L_0x0024:
            monitor-exit(r8)
            return
        L_0x0026:
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0060
        L_0x002c:
            int r1 = r0.length     // Catch:{ all -> 0x0062 }
            if (r2 >= r1) goto L_0x005e
            r1 = r0[r2]     // Catch:{ all -> 0x0062 }
            long r3 = r1.length()     // Catch:{ IOException -> 0x0058 }
            com.google.android.gms.internal.ads.zzame r5 = new com.google.android.gms.internal.ads.zzame     // Catch:{ IOException -> 0x0058 }
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0058 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0058 }
            r7.<init>(r1)     // Catch:{ IOException -> 0x0058 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0058 }
            r5.<init>(r6, r3)     // Catch:{ IOException -> 0x0058 }
            com.google.android.gms.internal.ads.zzamd r6 = com.google.android.gms.internal.ads.zzamd.zza(r5)     // Catch:{ all -> 0x0053 }
            r6.zza = r3     // Catch:{ all -> 0x0053 }
            java.lang.String r3 = r6.zzb     // Catch:{ all -> 0x0053 }
            r8.zzo(r3, r6)     // Catch:{ all -> 0x0053 }
            r5.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005b
        L_0x0053:
            r3 = move-exception
            r5.close()     // Catch:{ IOException -> 0x0058 }
            throw r3     // Catch:{ IOException -> 0x0058 }
        L_0x0058:
            r1.delete()     // Catch:{ all -> 0x0062 }
        L_0x005b:
            int r2 = r2 + 1
            goto L_0x002c
        L_0x005e:
            monitor-exit(r8)
            return
        L_0x0060:
            monitor-exit(r8)
            return
        L_0x0062:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamg.zzb():void");
    }

    public final synchronized void zzc(String str, boolean z2) {
        zzakt zza2 = zza(str);
        if (zza2 != null) {
            zza2.zzf = 0;
            zza2.zze = 0;
            zzd(str, zza2);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x016e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd(java.lang.String r16, com.google.android.gms.internal.ads.zzakt r17) {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r2 = r17
            monitor-enter(r15)
            long r3 = r1.zzb     // Catch:{ all -> 0x01a4 }
            byte[] r5 = r2.zza     // Catch:{ all -> 0x01a4 }
            int r5 = r5.length     // Catch:{ all -> 0x01a4 }
            long r6 = (long) r5     // Catch:{ all -> 0x01a4 }
            long r3 = r3 + r6
            int r6 = r1.zzd     // Catch:{ all -> 0x01a4 }
            long r7 = (long) r6
            r9 = 1063675494(0x3f666666, float:0.9)
            int r10 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x0022
            float r3 = (float) r5
            float r4 = (float) r6
            float r4 = r4 * r9
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            monitor-exit(r15)
            return
        L_0x0022:
            java.io.File r3 = r15.zzg(r16)     // Catch:{ all -> 0x01a4 }
            r4 = 1
            r5 = 0
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x016e }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x016e }
            r7.<init>(r3)     // Catch:{ IOException -> 0x016e }
            r6.<init>(r7)     // Catch:{ IOException -> 0x016e }
            com.google.android.gms.internal.ads.zzamd r7 = new com.google.android.gms.internal.ads.zzamd     // Catch:{ IOException -> 0x016e }
            r7.<init>(r0, r2)     // Catch:{ IOException -> 0x016e }
            r8 = 538247942(0x20150306, float:1.2621791E-19)
            zzj(r6, r8)     // Catch:{ IOException -> 0x014a }
            java.lang.String r8 = r7.zzb     // Catch:{ IOException -> 0x014a }
            zzl(r6, r8)     // Catch:{ IOException -> 0x014a }
            java.lang.String r8 = r7.zzc     // Catch:{ IOException -> 0x014a }
            if (r8 != 0) goto L_0x0048
            java.lang.String r8 = ""
        L_0x0048:
            zzl(r6, r8)     // Catch:{ IOException -> 0x014a }
            long r10 = r7.zzd     // Catch:{ IOException -> 0x014a }
            zzk(r6, r10)     // Catch:{ IOException -> 0x014a }
            long r10 = r7.zze     // Catch:{ IOException -> 0x014a }
            zzk(r6, r10)     // Catch:{ IOException -> 0x014a }
            long r10 = r7.zzf     // Catch:{ IOException -> 0x014a }
            zzk(r6, r10)     // Catch:{ IOException -> 0x014a }
            long r10 = r7.zzg     // Catch:{ IOException -> 0x014a }
            zzk(r6, r10)     // Catch:{ IOException -> 0x014a }
            java.util.List r8 = r7.zzh     // Catch:{ IOException -> 0x014a }
            if (r8 == 0) goto L_0x0089
            int r10 = r8.size()     // Catch:{ IOException -> 0x014a }
            zzj(r6, r10)     // Catch:{ IOException -> 0x014a }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ IOException -> 0x014a }
        L_0x006e:
            boolean r10 = r8.hasNext()     // Catch:{ IOException -> 0x014a }
            if (r10 == 0) goto L_0x008c
            java.lang.Object r10 = r8.next()     // Catch:{ IOException -> 0x014a }
            com.google.android.gms.internal.ads.zzalc r10 = (com.google.android.gms.internal.ads.zzalc) r10     // Catch:{ IOException -> 0x014a }
            java.lang.String r11 = r10.zza()     // Catch:{ IOException -> 0x014a }
            zzl(r6, r11)     // Catch:{ IOException -> 0x014a }
            java.lang.String r10 = r10.zzb()     // Catch:{ IOException -> 0x014a }
            zzl(r6, r10)     // Catch:{ IOException -> 0x014a }
            goto L_0x006e
        L_0x0089:
            zzj(r6, r5)     // Catch:{ IOException -> 0x014a }
        L_0x008c:
            r6.flush()     // Catch:{ IOException -> 0x014a }
            byte[] r2 = r2.zza     // Catch:{ IOException -> 0x016e }
            r6.write(r2)     // Catch:{ IOException -> 0x016e }
            r6.close()     // Catch:{ IOException -> 0x016e }
            long r10 = r3.length()     // Catch:{ IOException -> 0x016e }
            r7.zza = r10     // Catch:{ IOException -> 0x016e }
            r15.zzo(r0, r7)     // Catch:{ IOException -> 0x016e }
            long r6 = r1.zzb     // Catch:{ IOException -> 0x016e }
            int r0 = r1.zzd     // Catch:{ IOException -> 0x016e }
            long r10 = (long) r0     // Catch:{ IOException -> 0x016e }
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ab
            goto L_0x01a2
        L_0x00ab:
            boolean r0 = com.google.android.gms.internal.ads.zzalw.zzb     // Catch:{ IOException -> 0x016e }
            if (r0 == 0) goto L_0x00b6
            java.lang.String r0 = "Pruning old cache entries."
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x016e }
            com.google.android.gms.internal.ads.zzalw.zzd(r0, r2)     // Catch:{ IOException -> 0x016e }
        L_0x00b6:
            long r6 = r1.zzb     // Catch:{ IOException -> 0x016e }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x016e }
            java.util.Map r0 = r1.zza     // Catch:{ IOException -> 0x016e }
            java.util.Set r0 = r0.entrySet()     // Catch:{ IOException -> 0x016e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x016e }
            r2 = 0
        L_0x00c7:
            boolean r8 = r0.hasNext()     // Catch:{ IOException -> 0x016e }
            r12 = 2
            if (r8 == 0) goto L_0x011e
            java.lang.Object r8 = r0.next()     // Catch:{ IOException -> 0x016e }
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ IOException -> 0x016e }
            java.lang.Object r8 = r8.getValue()     // Catch:{ IOException -> 0x016e }
            com.google.android.gms.internal.ads.zzamd r8 = (com.google.android.gms.internal.ads.zzamd) r8     // Catch:{ IOException -> 0x016e }
            java.lang.String r13 = r8.zzb     // Catch:{ IOException -> 0x016e }
            java.io.File r13 = r15.zzg(r13)     // Catch:{ IOException -> 0x016e }
            boolean r13 = r13.delete()     // Catch:{ IOException -> 0x016e }
            if (r13 == 0) goto L_0x00f0
            long r13 = r1.zzb     // Catch:{ IOException -> 0x016e }
            r16 = r10
            long r9 = r8.zza     // Catch:{ IOException -> 0x016e }
            long r13 = r13 - r9
            r1.zzb = r13     // Catch:{ IOException -> 0x016e }
            goto L_0x0103
        L_0x00f0:
            r16 = r10
            java.lang.String r9 = "Could not delete cache entry for key=%s, filename=%s"
            java.lang.Object[] r10 = new java.lang.Object[r12]     // Catch:{ IOException -> 0x016e }
            java.lang.String r8 = r8.zzb     // Catch:{ IOException -> 0x016e }
            r10[r5] = r8     // Catch:{ IOException -> 0x016e }
            java.lang.String r8 = zzq(r8)     // Catch:{ IOException -> 0x016e }
            r10[r4] = r8     // Catch:{ IOException -> 0x016e }
            com.google.android.gms.internal.ads.zzalw.zza(r9, r10)     // Catch:{ IOException -> 0x016e }
        L_0x0103:
            r0.remove()     // Catch:{ IOException -> 0x016e }
            int r2 = r2 + 1
            long r8 = r1.zzb     // Catch:{ IOException -> 0x016e }
            float r8 = (float) r8     // Catch:{ IOException -> 0x016e }
            int r9 = r1.zzd     // Catch:{ IOException -> 0x016e }
            float r9 = (float) r9     // Catch:{ IOException -> 0x016e }
            r10 = 1063675494(0x3f666666, float:0.9)
            float r9 = r9 * r10
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 >= 0) goto L_0x0118
            goto L_0x0120
        L_0x0118:
            r10 = r16
            r9 = 1063675494(0x3f666666, float:0.9)
            goto L_0x00c7
        L_0x011e:
            r16 = r10
        L_0x0120:
            boolean r0 = com.google.android.gms.internal.ads.zzalw.zzb     // Catch:{ IOException -> 0x016e }
            if (r0 == 0) goto L_0x01a2
            java.lang.String r0 = "pruned %d files, %d bytes, %d ms"
            r8 = 3
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x016e }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x016e }
            r8[r5] = r2     // Catch:{ IOException -> 0x016e }
            long r9 = r1.zzb     // Catch:{ IOException -> 0x016e }
            long r9 = r9 - r6
            java.lang.Long r2 = java.lang.Long.valueOf(r9)     // Catch:{ IOException -> 0x016e }
            r8[r4] = r2     // Catch:{ IOException -> 0x016e }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x016e }
            r9 = r16
            long r6 = r6 - r9
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ IOException -> 0x016e }
            r8[r12] = r2     // Catch:{ IOException -> 0x016e }
            com.google.android.gms.internal.ads.zzalw.zzd(r0, r8)     // Catch:{ IOException -> 0x016e }
            monitor-exit(r15)
            return
        L_0x014a:
            r0 = move-exception
            java.lang.String r2 = "%s"
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x016e }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x016e }
            r7[r5] = r0     // Catch:{ IOException -> 0x016e }
            com.google.android.gms.internal.ads.zzalw.zza(r2, r7)     // Catch:{ IOException -> 0x016e }
            r6.close()     // Catch:{ IOException -> 0x016e }
            java.lang.String r0 = "Failed to write header for %s"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x016e }
            java.lang.String r6 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x016e }
            r2[r5] = r6     // Catch:{ IOException -> 0x016e }
            com.google.android.gms.internal.ads.zzalw.zza(r0, r2)     // Catch:{ IOException -> 0x016e }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x016e }
            r0.<init>()     // Catch:{ IOException -> 0x016e }
            throw r0     // Catch:{ IOException -> 0x016e }
        L_0x016e:
            boolean r0 = r3.delete()     // Catch:{ all -> 0x01a4 }
            if (r0 != 0) goto L_0x0181
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ all -> 0x01a4 }
            java.lang.String r2 = r3.getAbsolutePath()     // Catch:{ all -> 0x01a4 }
            r0[r5] = r2     // Catch:{ all -> 0x01a4 }
            java.lang.String r2 = "Could not clean up file %s"
            com.google.android.gms.internal.ads.zzalw.zza(r2, r0)     // Catch:{ all -> 0x01a4 }
        L_0x0181:
            com.google.android.gms.internal.ads.zzamf r0 = r1.zzc     // Catch:{ all -> 0x01a4 }
            java.io.File r0 = r0.zza()     // Catch:{ all -> 0x01a4 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x01a4 }
            if (r0 != 0) goto L_0x01a2
            java.lang.String r0 = "Re-initializing cache after external clearing."
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x01a4 }
            com.google.android.gms.internal.ads.zzalw.zza(r0, r2)     // Catch:{ all -> 0x01a4 }
            java.util.Map r0 = r1.zza     // Catch:{ all -> 0x01a4 }
            r0.clear()     // Catch:{ all -> 0x01a4 }
            r2 = 0
            r1.zzb = r2     // Catch:{ all -> 0x01a4 }
            r15.zzb()     // Catch:{ all -> 0x01a4 }
            monitor-exit(r15)
            return
        L_0x01a2:
            monitor-exit(r15)
            return
        L_0x01a4:
            r0 = move-exception
            monitor-exit(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamg.zzd(java.lang.String, com.google.android.gms.internal.ads.zzakt):void");
    }

    public final File zzg(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public final synchronized void zzi(String str) {
        boolean delete = zzg(str).delete();
        zzp(str);
        if (!delete) {
            zzalw.zza("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
        }
    }

    public zzamg(File file, int i2) {
        this.zzc = new zzamc(this, file);
        this.zzd = 20971520;
    }
}
