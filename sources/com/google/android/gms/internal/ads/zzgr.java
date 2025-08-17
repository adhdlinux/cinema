package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public final class zzgr extends zzfy implements zzhb {
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzha zzf;
    private final zzha zzg;
    private zzgj zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;

    @Deprecated
    public zzgr() {
        this((String) null, 8000, 8000, false, (zzha) null, (zzfpi) null, false);
    }

    /* synthetic */ zzgr(String str, int i2, int i3, boolean z2, zzha zzha, zzfpi zzfpi, boolean z3, zzgq zzgq) {
        this(str, i2, i3, z2, zzha, (zzfpi) null, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.net.HttpURLConnection zzk(java.net.URL r3, int r4, byte[] r5, long r6, long r8, boolean r10, boolean r11, java.util.Map r12) throws java.io.IOException {
        /*
            r2 = this;
            java.net.URLConnection r3 = r3.openConnection()
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3
            int r4 = r2.zzc
            r3.setConnectTimeout(r4)
            int r4 = r2.zzd
            r3.setReadTimeout(r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.google.android.gms.internal.ads.zzha r5 = r2.zzf
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
            com.google.android.gms.internal.ads.zzha r5 = r2.zzg
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
            r4.putAll(r12)
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0032:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x004e
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r12 = r5.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            r3.setRequestProperty(r12, r5)
            goto L_0x0032
        L_0x004e:
            r4 = 0
            r0 = -1
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 != 0) goto L_0x005d
            int r6 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r6 != 0) goto L_0x005c
            r4 = 0
            goto L_0x007c
        L_0x005c:
            r6 = r4
        L_0x005d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "bytes="
            r4.append(r5)
            r4.append(r6)
            java.lang.String r5 = "-"
            r4.append(r5)
            int r5 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r5 == 0) goto L_0x0078
            long r6 = r6 + r8
            long r6 = r6 + r0
            r4.append(r6)
        L_0x0078:
            java.lang.String r4 = r4.toString()
        L_0x007c:
            if (r4 == 0) goto L_0x0083
            java.lang.String r5 = "Range"
            r3.setRequestProperty(r5, r4)
        L_0x0083:
            java.lang.String r4 = r2.zze
            if (r4 == 0) goto L_0x008c
            java.lang.String r5 = "User-Agent"
            r3.setRequestProperty(r5, r4)
        L_0x008c:
            r4 = 1
            if (r4 == r10) goto L_0x0092
            java.lang.String r4 = "identity"
            goto L_0x0094
        L_0x0092:
            java.lang.String r4 = "gzip"
        L_0x0094:
            java.lang.String r5 = "Accept-Encoding"
            r3.setRequestProperty(r5, r4)
            r3.setInstanceFollowRedirects(r11)
            r4 = 0
            r3.setDoOutput(r4)
            int r4 = com.google.android.gms.internal.ads.zzgj.zzj
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)
            r3.connect()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgr.zzk(java.net.URL, int, byte[], long, long, boolean, boolean, java.util.Map):java.net.HttpURLConnection");
    }

    private final URL zzl(URL url, String str, zzgj zzgj) throws zzgx {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!UriUtil.HTTPS_SCHEME.equals(protocol) && !UriUtil.HTTP_SCHEME.equals(protocol)) {
                    throw new zzgx("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), zzgj, 2001, 1);
                } else if (this.zzb || protocol.equals(url.getProtocol())) {
                    return url2;
                } else {
                    String protocol2 = url.getProtocol();
                    throw new zzgx("Disallowed cross-protocol redirect (" + protocol2 + " to " + protocol + ")", zzgj, 2001, 1);
                }
            } catch (MalformedURLException e2) {
                throw new zzgx((IOException) e2, zzgj, 2001, 1);
            }
        } else {
            throw new zzgx("Null location redirect", zzgj, 2001, 1);
        }
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                zzer.zzd("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.zzi = null;
        }
    }

    public final int zza(byte[] bArr, int i2, int i3) throws zzgx {
        if (i3 == 0) {
            return 0;
        }
        try {
            long j2 = this.zzm;
            if (j2 != -1) {
                long j3 = j2 - this.zzn;
                if (j3 != 0) {
                    i3 = (int) Math.min((long) i3, j3);
                }
                return -1;
            }
            InputStream inputStream = this.zzj;
            int i4 = zzfj.zza;
            int read = inputStream.read(bArr, i2, i3);
            if (read == -1) {
                return -1;
            }
            this.zzn += (long) read;
            zzg(read);
            return read;
        } catch (IOException e2) {
            zzgj zzgj = this.zzh;
            int i5 = zzfj.zza;
            throw zzgx.zza(e2, zzgj, 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b2, code lost:
        if (r10 == 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzgj r27) throws com.google.android.gms.internal.ads.zzgx {
        /*
            r26 = this;
            r12 = r26
            r13 = r27
            r12.zzh = r13
            r14 = 0
            r12.zzn = r14
            r12.zzm = r14
            r26.zzi(r27)
            r11 = 1
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x0201 }
            android.net.Uri r0 = r13.zza     // Catch:{ IOException -> 0x0201 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0201 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0201 }
            long r9 = r13.zzf     // Catch:{ IOException -> 0x0201 }
            long r7 = r13.zzg     // Catch:{ IOException -> 0x0201 }
            boolean r0 = r13.zza(r11)     // Catch:{ IOException -> 0x0201 }
            boolean r1 = r12.zzb     // Catch:{ IOException -> 0x0201 }
            r5 = 0
            if (r1 != 0) goto L_0x003d
            r3 = 1
            r4 = 0
            r16 = 1
            java.util.Map r6 = r13.zzd     // Catch:{ IOException -> 0x0201 }
            r1 = r26
            r18 = r6
            r5 = r9
            r9 = r0
            r10 = r16
            r11 = r18
            java.net.HttpURLConnection r0 = r1.zzk(r2, r3, r4, r5, r7, r9, r10, r11)     // Catch:{ IOException -> 0x0201 }
            goto L_0x0087
        L_0x003d:
            r11 = r2
            r5 = 0
        L_0x003f:
            int r6 = r5 + 1
            r1 = 20
            if (r5 > r1) goto L_0x01dc
            r3 = 1
            r4 = 0
            r16 = 0
            java.util.Map r5 = r13.zzd     // Catch:{ IOException -> 0x0201 }
            r1 = r26
            r2 = r11
            r18 = r5
            r20 = r6
            r5 = r9
            r21 = r7
            r23 = r9
            r9 = r0
            r10 = r16
            r25 = r11
            r11 = r18
            java.net.HttpURLConnection r1 = r1.zzk(r2, r3, r4, r5, r7, r9, r10, r11)     // Catch:{ IOException -> 0x0201 }
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x0201 }
            java.lang.String r3 = "Location"
            java.lang.String r3 = r1.getHeaderField(r3)     // Catch:{ IOException -> 0x0201 }
            r4 = 300(0x12c, float:4.2E-43)
            if (r2 == r4) goto L_0x01c9
            r4 = 301(0x12d, float:4.22E-43)
            if (r2 == r4) goto L_0x01c9
            r4 = 302(0x12e, float:4.23E-43)
            if (r2 == r4) goto L_0x01c9
            r4 = 303(0x12f, float:4.25E-43)
            if (r2 == r4) goto L_0x01c9
            r4 = 307(0x133, float:4.3E-43)
            if (r2 == r4) goto L_0x01c9
            r4 = 308(0x134, float:4.32E-43)
            if (r2 != r4) goto L_0x0086
            goto L_0x01c9
        L_0x0086:
            r0 = r1
        L_0x0087:
            r12.zzi = r0     // Catch:{ IOException -> 0x0201 }
            int r1 = r0.getResponseCode()     // Catch:{ IOException -> 0x0201 }
            r12.zzl = r1     // Catch:{ IOException -> 0x0201 }
            java.lang.String r3 = r0.getResponseMessage()     // Catch:{ IOException -> 0x0201 }
            int r1 = r12.zzl
            r4 = 2008(0x7d8, float:2.814E-42)
            r5 = 4096(0x1000, float:5.74E-42)
            java.lang.String r6 = "Content-Range"
            r7 = 200(0xc8, float:2.8E-43)
            r8 = -1
            if (r1 < r7) goto L_0x015e
            r10 = 299(0x12b, float:4.19E-43)
            if (r1 <= r10) goto L_0x00a7
            goto L_0x015e
        L_0x00a7:
            r0.getContentType()
            int r1 = r12.zzl
            if (r1 != r7) goto L_0x00b4
            long r10 = r13.zzf
            int r1 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r1 != 0) goto L_0x00b5
        L_0x00b4:
            r10 = r14
        L_0x00b5:
            java.lang.String r1 = "Content-Encoding"
            java.lang.String r1 = r0.getHeaderField(r1)
            java.lang.String r3 = "gzip"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x00e3
            long r2 = r13.zzg
            int r16 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r16 == 0) goto L_0x00cc
            r12.zzm = r2
            goto L_0x00e7
        L_0x00cc:
            java.lang.String r2 = "Content-Length"
            java.lang.String r2 = r0.getHeaderField(r2)
            java.lang.String r3 = r0.getHeaderField(r6)
            long r2 = com.google.android.gms.internal.ads.zzhc.zza(r2, r3)
            int r6 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x00e0
            long r8 = r2 - r10
        L_0x00e0:
            r12.zzm = r8
            goto L_0x00e7
        L_0x00e3:
            long r2 = r13.zzg
            r12.zzm = r2
        L_0x00e7:
            r2 = 2000(0x7d0, float:2.803E-42)
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0153 }
            r12.zzj = r0     // Catch:{ IOException -> 0x0153 }
            if (r1 == 0) goto L_0x00fa
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0153 }
            java.io.InputStream r1 = r12.zzj     // Catch:{ IOException -> 0x0153 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0153 }
            r12.zzj = r0     // Catch:{ IOException -> 0x0153 }
        L_0x00fa:
            r1 = 1
            r12.zzk = r1
            r26.zzj(r27)
            int r0 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x0105
            goto L_0x013f
        L_0x0105:
            byte[] r0 = new byte[r5]     // Catch:{ IOException -> 0x0142 }
        L_0x0107:
            int r3 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r3 <= 0) goto L_0x013f
            r5 = 4096(0x1000, double:2.0237E-320)
            long r5 = java.lang.Math.min(r10, r5)     // Catch:{ IOException -> 0x0142 }
            int r3 = (int) r5     // Catch:{ IOException -> 0x0142 }
            java.io.InputStream r5 = r12.zzj     // Catch:{ IOException -> 0x0142 }
            int r6 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ IOException -> 0x0142 }
            r6 = 0
            int r3 = r5.read(r0, r6, r3)     // Catch:{ IOException -> 0x0142 }
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ IOException -> 0x0142 }
            boolean r5 = r5.isInterrupted()     // Catch:{ IOException -> 0x0142 }
            if (r5 != 0) goto L_0x0134
            r5 = -1
            if (r3 == r5) goto L_0x012e
            long r8 = (long) r3     // Catch:{ IOException -> 0x0142 }
            long r10 = r10 - r8
            r12.zzg(r3)     // Catch:{ IOException -> 0x0142 }
            goto L_0x0107
        L_0x012e:
            com.google.android.gms.internal.ads.zzgx r0 = new com.google.android.gms.internal.ads.zzgx     // Catch:{ IOException -> 0x0142 }
            r0.<init>(r13, r4, r1)     // Catch:{ IOException -> 0x0142 }
            throw r0     // Catch:{ IOException -> 0x0142 }
        L_0x0134:
            com.google.android.gms.internal.ads.zzgx r0 = new com.google.android.gms.internal.ads.zzgx     // Catch:{ IOException -> 0x0142 }
            java.io.InterruptedIOException r3 = new java.io.InterruptedIOException     // Catch:{ IOException -> 0x0142 }
            r3.<init>()     // Catch:{ IOException -> 0x0142 }
            r0.<init>((java.io.IOException) r3, (com.google.android.gms.internal.ads.zzgj) r13, (int) r2, (int) r1)     // Catch:{ IOException -> 0x0142 }
            throw r0     // Catch:{ IOException -> 0x0142 }
        L_0x013f:
            long r0 = r12.zzm
            return r0
        L_0x0142:
            r0 = move-exception
            r26.zzm()
            boolean r3 = r0 instanceof com.google.android.gms.internal.ads.zzgx
            if (r3 == 0) goto L_0x014d
            com.google.android.gms.internal.ads.zzgx r0 = (com.google.android.gms.internal.ads.zzgx) r0
            throw r0
        L_0x014d:
            com.google.android.gms.internal.ads.zzgx r3 = new com.google.android.gms.internal.ads.zzgx
            r3.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzgj) r13, (int) r2, (int) r1)
            throw r3
        L_0x0153:
            r0 = move-exception
            r1 = 1
            r26.zzm()
            com.google.android.gms.internal.ads.zzgx r3 = new com.google.android.gms.internal.ads.zzgx
            r3.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzgj) r13, (int) r2, (int) r1)
            throw r3
        L_0x015e:
            r1 = 1
            r2 = 0
            java.util.Map r10 = r0.getHeaderFields()
            int r11 = r12.zzl
            r7 = 416(0x1a0, float:5.83E-43)
            if (r11 != r7) goto L_0x0186
            java.lang.String r6 = r0.getHeaderField(r6)
            long r17 = com.google.android.gms.internal.ads.zzhc.zzb(r6)
            r6 = r3
            long r2 = r13.zzf
            int r19 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r19 != 0) goto L_0x0187
            r12.zzk = r1
            r26.zzj(r27)
            long r0 = r13.zzg
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x0185
            return r0
        L_0x0185:
            return r14
        L_0x0186:
            r6 = r3
        L_0x0187:
            java.io.InputStream r0 = r0.getErrorStream()
            if (r0 == 0) goto L_0x01a7
            int r1 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ IOException -> 0x01aa }
            byte[] r1 = new byte[r5]     // Catch:{ IOException -> 0x01aa }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01aa }
            r2.<init>()     // Catch:{ IOException -> 0x01aa }
        L_0x0196:
            int r3 = r0.read(r1)     // Catch:{ IOException -> 0x01aa }
            r5 = -1
            if (r3 == r5) goto L_0x01a2
            r8 = 0
            r2.write(r1, r8, r3)     // Catch:{ IOException -> 0x01aa }
            goto L_0x0196
        L_0x01a2:
            byte[] r0 = r2.toByteArray()     // Catch:{ IOException -> 0x01aa }
            goto L_0x01ac
        L_0x01a7:
            byte[] r0 = com.google.android.gms.internal.ads.zzfj.zzf     // Catch:{ IOException -> 0x01aa }
            goto L_0x01ac
        L_0x01aa:
            byte[] r0 = com.google.android.gms.internal.ads.zzfj.zzf
        L_0x01ac:
            r26.zzm()
            int r1 = r12.zzl
            if (r1 != r7) goto L_0x01b9
            com.google.android.gms.internal.ads.zzgf r1 = new com.google.android.gms.internal.ads.zzgf
            r1.<init>(r4)
            goto L_0x01ba
        L_0x01b9:
            r1 = 0
        L_0x01ba:
            r4 = r1
            com.google.android.gms.internal.ads.zzgz r8 = new com.google.android.gms.internal.ads.zzgz
            int r2 = r12.zzl
            r1 = r8
            r3 = r6
            r5 = r10
            r6 = r27
            r7 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            throw r8
        L_0x01c9:
            r2 = 1
            r8 = 0
            r1.disconnect()     // Catch:{ IOException -> 0x01ff }
            r1 = r25
            java.net.URL r11 = r12.zzl(r1, r3, r13)     // Catch:{ IOException -> 0x01ff }
            r5 = r20
            r7 = r21
            r9 = r23
            goto L_0x003f
        L_0x01dc:
            r20 = r6
            r2 = 1
            com.google.android.gms.internal.ads.zzgx r0 = new com.google.android.gms.internal.ads.zzgx     // Catch:{ IOException -> 0x01ff }
            java.net.NoRouteToHostException r1 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x01ff }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01ff }
            r3.<init>()     // Catch:{ IOException -> 0x01ff }
            java.lang.String r4 = "Too many redirects: "
            r3.append(r4)     // Catch:{ IOException -> 0x01ff }
            r5 = r20
            r3.append(r5)     // Catch:{ IOException -> 0x01ff }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x01ff }
            r1.<init>(r3)     // Catch:{ IOException -> 0x01ff }
            r3 = 2001(0x7d1, float:2.804E-42)
            r0.<init>((java.io.IOException) r1, (com.google.android.gms.internal.ads.zzgj) r13, (int) r3, (int) r2)     // Catch:{ IOException -> 0x01ff }
            throw r0     // Catch:{ IOException -> 0x01ff }
        L_0x01ff:
            r0 = move-exception
            goto L_0x0203
        L_0x0201:
            r0 = move-exception
            r2 = 1
        L_0x0203:
            r26.zzm()
            com.google.android.gms.internal.ads.zzgx r0 = com.google.android.gms.internal.ads.zzgx.zza(r0, r13, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgr.zzb(com.google.android.gms.internal.ads.zzgj):long");
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|(1:6)(1:7)|8|(5:13|14|(2:16|(1:18))(2:19|(1:21))|22|(4:26|27|28|29))|30|31) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0069 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() throws com.google.android.gms.internal.ads.zzgx {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r10.zzj     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x007b
            long r3 = r10.zzm     // Catch:{ all -> 0x008a }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0010
            r3 = r5
            goto L_0x0013
        L_0x0010:
            long r7 = r10.zzn     // Catch:{ all -> 0x008a }
            long r3 = r3 - r7
        L_0x0013:
            java.net.HttpURLConnection r7 = r10.zzi     // Catch:{ all -> 0x008a }
            if (r7 == 0) goto L_0x0069
            int r8 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ all -> 0x008a }
            r9 = 20
            if (r8 <= r9) goto L_0x001e
            goto L_0x0069
        L_0x001e:
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ Exception -> 0x0069 }
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x002e
            int r3 = r7.read()     // Catch:{ Exception -> 0x0069 }
            r4 = -1
            if (r3 == r4) goto L_0x0069
            goto L_0x0035
        L_0x002e:
            r5 = 2048(0x800, double:1.0118E-320)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x0035
            goto L_0x0069
        L_0x0035:
            java.lang.Class r3 = r7.getClass()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x0069 }
            if (r4 != 0) goto L_0x004d
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r4.equals(r3)     // Catch:{ Exception -> 0x0069 }
            if (r3 == 0) goto L_0x0069
        L_0x004d:
            java.lang.Class r3 = r7.getClass()     // Catch:{ Exception -> 0x0069 }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x0069 }
            r3.getClass()
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0069 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0069 }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x0069 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0069 }
            r3.invoke(r7, r4)     // Catch:{ Exception -> 0x0069 }
        L_0x0069:
            r2.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x007b
        L_0x006d:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzgx r3 = new com.google.android.gms.internal.ads.zzgx     // Catch:{ all -> 0x008a }
            com.google.android.gms.internal.ads.zzgj r4 = r10.zzh     // Catch:{ all -> 0x008a }
            int r5 = com.google.android.gms.internal.ads.zzfj.zza     // Catch:{ all -> 0x008a }
            r5 = 2000(0x7d0, float:2.803E-42)
            r6 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzgj) r4, (int) r5, (int) r6)     // Catch:{ all -> 0x008a }
            throw r3     // Catch:{ all -> 0x008a }
        L_0x007b:
            r10.zzj = r0
            r10.zzm()
            boolean r0 = r10.zzk
            if (r0 == 0) goto L_0x0089
            r10.zzk = r1
            r10.zzh()
        L_0x0089:
            return
        L_0x008a:
            r2 = move-exception
            r10.zzj = r0
            r10.zzm()
            boolean r0 = r10.zzk
            if (r0 == 0) goto L_0x0099
            r10.zzk = r1
            r10.zzh()
        L_0x0099:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgr.zzd():void");
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        return httpURLConnection == null ? zzfsf.zzd() : new zzgp(httpURLConnection.getHeaderFields());
    }

    private zzgr(String str, int i2, int i3, boolean z2, zzha zzha, zzfpi zzfpi, boolean z3) {
        super(true);
        this.zze = str;
        this.zzc = i2;
        this.zzd = i3;
        this.zzb = z2;
        this.zzf = zzha;
        this.zzg = new zzha();
    }
}
