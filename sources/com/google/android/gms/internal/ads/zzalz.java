package com.google.android.gms.internal.ads;

import com.google.protobuf.CodedOutputStream;

public class zzalz implements zzald {
    protected final zzamb zza;
    @Deprecated
    protected final zzaly zzb;
    private final zzaly zzc;

    public zzalz(zzaly zzaly) {
        zzamb zzamb = new zzamb(CodedOutputStream.DEFAULT_BUFFER_SIZE);
        this.zzc = zzaly;
        this.zzb = zzaly;
        this.zza = zzamb;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:78|79|80|81|82|83|84|(3:85|86|(1:88)(1:197))|91|92|93|94|95|96) */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0297, code lost:
        r0 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x0219 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:94:0x0207 */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0277 A[Catch:{ IOException -> 0x0293 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x028d A[Catch:{ IOException -> 0x0293 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02af A[SYNTHETIC, Splitter:B:139:0x02af] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x02b2 A[EDGE_INSN: B:184:0x02b2->B:141:0x02b2 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzalg zza(com.google.android.gms.internal.ads.zzalk r24) throws com.google.android.gms.internal.ads.zzalt {
        /*
            r23 = this;
            r1 = r24
            java.lang.String r2 = "Error occurred when closing InputStream"
            java.lang.String r3 = "Content-Type"
            long r4 = android.os.SystemClock.elapsedRealtime()
        L_0x000a:
            java.util.Collections.emptyList()
            r7 = 1
            r8 = 0
            r9 = 0
            com.google.android.gms.internal.ads.zzakt r0 = r24.zzd()     // Catch:{ IOException -> 0x02b5 }
            if (r0 != 0) goto L_0x001b
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ IOException -> 0x02b5 }
            goto L_0x003b
        L_0x001b:
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ IOException -> 0x02b5 }
            r10.<init>()     // Catch:{ IOException -> 0x02b5 }
            java.lang.String r11 = r0.zzb     // Catch:{ IOException -> 0x02b5 }
            if (r11 == 0) goto L_0x0029
            java.lang.String r12 = "If-None-Match"
            r10.put(r12, r11)     // Catch:{ IOException -> 0x02b5 }
        L_0x0029:
            long r11 = r0.zzd     // Catch:{ IOException -> 0x02b5 }
            r13 = 0
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x003a
            java.lang.String r0 = "If-Modified-Since"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzamh.zzc(r11)     // Catch:{ IOException -> 0x02b5 }
            r10.put(r0, r11)     // Catch:{ IOException -> 0x02b5 }
        L_0x003a:
            r0 = r10
        L_0x003b:
            java.lang.String r10 = "application/x-www-form-urlencoded; charset=UTF-8"
            java.lang.String r11 = r24.zzk()     // Catch:{ IOException -> 0x02b5 }
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ IOException -> 0x02b5 }
            r12.<init>()     // Catch:{ IOException -> 0x02b5 }
            r12.putAll(r0)     // Catch:{ IOException -> 0x02b5 }
            java.util.Map r0 = r24.zzl()     // Catch:{ IOException -> 0x02b5 }
            r12.putAll(r0)     // Catch:{ IOException -> 0x02b5 }
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x02b5 }
            r0.<init>(r11)     // Catch:{ IOException -> 0x02b5 }
            java.net.URLConnection r11 = r0.openConnection()     // Catch:{ IOException -> 0x02b5 }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ IOException -> 0x02b5 }
            boolean r13 = java.net.HttpURLConnection.getFollowRedirects()     // Catch:{ IOException -> 0x02b5 }
            r11.setInstanceFollowRedirects(r13)     // Catch:{ IOException -> 0x02b5 }
            int r13 = r24.zzb()     // Catch:{ IOException -> 0x02b5 }
            r11.setConnectTimeout(r13)     // Catch:{ IOException -> 0x02b5 }
            r11.setReadTimeout(r13)     // Catch:{ IOException -> 0x02b5 }
            r11.setUseCaches(r9)     // Catch:{ IOException -> 0x02b5 }
            r11.setDoInput(r7)     // Catch:{ IOException -> 0x02b5 }
            r0.getProtocol()     // Catch:{ IOException -> 0x02b5 }
            java.util.Set r0 = r12.keySet()     // Catch:{ all -> 0x02a9 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x02a9 }
        L_0x007d:
            boolean r13 = r0.hasNext()     // Catch:{ all -> 0x02a9 }
            if (r13 == 0) goto L_0x0093
            java.lang.Object r13 = r0.next()     // Catch:{ all -> 0x02a9 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x02a9 }
            java.lang.Object r14 = r12.get(r13)     // Catch:{ all -> 0x02a9 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x02a9 }
            r11.setRequestProperty(r13, r14)     // Catch:{ all -> 0x02a9 }
            goto L_0x007d
        L_0x0093:
            int r0 = r24.zza()     // Catch:{ all -> 0x02a9 }
            if (r0 == 0) goto L_0x00c4
            java.lang.String r0 = "POST"
            r11.setRequestMethod(r0)     // Catch:{ all -> 0x02a9 }
            byte[] r0 = r24.zzx()     // Catch:{ all -> 0x02a9 }
            if (r0 == 0) goto L_0x00c9
            r11.setDoOutput(r7)     // Catch:{ all -> 0x02a9 }
            java.util.Map r12 = r11.getRequestProperties()     // Catch:{ all -> 0x02a9 }
            boolean r12 = r12.containsKey(r3)     // Catch:{ all -> 0x02a9 }
            if (r12 != 0) goto L_0x00b4
            r11.setRequestProperty(r3, r10)     // Catch:{ all -> 0x02a9 }
        L_0x00b4:
            java.io.DataOutputStream r10 = new java.io.DataOutputStream     // Catch:{ all -> 0x02a9 }
            java.io.OutputStream r12 = r11.getOutputStream()     // Catch:{ all -> 0x02a9 }
            r10.<init>(r12)     // Catch:{ all -> 0x02a9 }
            r10.write(r0)     // Catch:{ all -> 0x02a9 }
            r10.close()     // Catch:{ all -> 0x02a9 }
            goto L_0x00c9
        L_0x00c4:
            java.lang.String r0 = "GET"
            r11.setRequestMethod(r0)     // Catch:{ all -> 0x02a9 }
        L_0x00c9:
            int r0 = r11.getResponseCode()     // Catch:{ all -> 0x02a9 }
            r10 = -1
            if (r0 == r10) goto L_0x029d
            r24.zza()     // Catch:{ all -> 0x02a9 }
            r12 = 100
            r13 = 304(0x130, float:4.26E-43)
            r14 = 200(0xc8, float:2.8E-43)
            if (r0 < r12) goto L_0x00dd
            if (r0 < r14) goto L_0x00ff
        L_0x00dd:
            r12 = 204(0xcc, float:2.86E-43)
            if (r0 == r12) goto L_0x00ff
            if (r0 == r13) goto L_0x00ff
            com.google.android.gms.internal.ads.zzami r12 = new com.google.android.gms.internal.ads.zzami     // Catch:{ all -> 0x00fa }
            java.util.Map r15 = r11.getHeaderFields()     // Catch:{ all -> 0x00fa }
            java.util.List r15 = com.google.android.gms.internal.ads.zzamk.zza(r15)     // Catch:{ all -> 0x00fa }
            int r14 = r11.getContentLength()     // Catch:{ all -> 0x00fa }
            com.google.android.gms.internal.ads.zzamj r6 = new com.google.android.gms.internal.ads.zzamj     // Catch:{ all -> 0x00fa }
            r6.<init>(r11)     // Catch:{ all -> 0x00fa }
            r12.<init>(r0, r15, r14, r6)     // Catch:{ all -> 0x00fa }
            goto L_0x010f
        L_0x00fa:
            r0 = move-exception
            r14 = r23
            goto L_0x02ad
        L_0x00ff:
            com.google.android.gms.internal.ads.zzami r12 = new com.google.android.gms.internal.ads.zzami     // Catch:{ all -> 0x02a9 }
            java.util.Map r6 = r11.getHeaderFields()     // Catch:{ all -> 0x02a9 }
            java.util.List r6 = com.google.android.gms.internal.ads.zzamk.zza(r6)     // Catch:{ all -> 0x02a9 }
            r12.<init>(r0, r6, r10, r8)     // Catch:{ all -> 0x02a9 }
            r11.disconnect()     // Catch:{ IOException -> 0x02b5 }
        L_0x010f:
            int r0 = r12.zzb()     // Catch:{ IOException -> 0x0299 }
            java.util.List r6 = r12.zzd()     // Catch:{ IOException -> 0x0299 }
            if (r0 != r13) goto L_0x01da
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0299 }
            long r20 = r10 - r4
            com.google.android.gms.internal.ads.zzakt r0 = r24.zzd()     // Catch:{ IOException -> 0x0299 }
            if (r0 != 0) goto L_0x0136
            com.google.android.gms.internal.ads.zzalg r0 = new com.google.android.gms.internal.ads.zzalg     // Catch:{ IOException -> 0x0299 }
            r17 = 304(0x130, float:4.26E-43)
            r18 = 0
            r19 = 1
            r16 = r0
            r22 = r6
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List) r22)     // Catch:{ IOException -> 0x0299 }
            goto L_0x01d9
        L_0x0136:
            java.util.TreeSet r10 = new java.util.TreeSet     // Catch:{ IOException -> 0x0299 }
            java.util.Comparator r11 = java.lang.String.CASE_INSENSITIVE_ORDER     // Catch:{ IOException -> 0x0299 }
            r10.<init>(r11)     // Catch:{ IOException -> 0x0299 }
            boolean r11 = r6.isEmpty()     // Catch:{ IOException -> 0x0299 }
            if (r11 != 0) goto L_0x015b
            java.util.Iterator r11 = r6.iterator()     // Catch:{ IOException -> 0x0299 }
        L_0x0147:
            boolean r13 = r11.hasNext()     // Catch:{ IOException -> 0x0299 }
            if (r13 == 0) goto L_0x015b
            java.lang.Object r13 = r11.next()     // Catch:{ IOException -> 0x0299 }
            com.google.android.gms.internal.ads.zzalc r13 = (com.google.android.gms.internal.ads.zzalc) r13     // Catch:{ IOException -> 0x0299 }
            java.lang.String r13 = r13.zza()     // Catch:{ IOException -> 0x0299 }
            r10.add(r13)     // Catch:{ IOException -> 0x0299 }
            goto L_0x0147
        L_0x015b:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ IOException -> 0x0299 }
            r11.<init>(r6)     // Catch:{ IOException -> 0x0299 }
            java.util.List r6 = r0.zzh     // Catch:{ IOException -> 0x0299 }
            if (r6 == 0) goto L_0x018a
            boolean r6 = r6.isEmpty()     // Catch:{ IOException -> 0x0299 }
            if (r6 != 0) goto L_0x01c7
            java.util.List r6 = r0.zzh     // Catch:{ IOException -> 0x0299 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x0299 }
        L_0x0170:
            boolean r13 = r6.hasNext()     // Catch:{ IOException -> 0x0299 }
            if (r13 == 0) goto L_0x01c7
            java.lang.Object r13 = r6.next()     // Catch:{ IOException -> 0x0299 }
            com.google.android.gms.internal.ads.zzalc r13 = (com.google.android.gms.internal.ads.zzalc) r13     // Catch:{ IOException -> 0x0299 }
            java.lang.String r14 = r13.zza()     // Catch:{ IOException -> 0x0299 }
            boolean r14 = r10.contains(r14)     // Catch:{ IOException -> 0x0299 }
            if (r14 != 0) goto L_0x0170
            r11.add(r13)     // Catch:{ IOException -> 0x0299 }
            goto L_0x0170
        L_0x018a:
            java.util.Map r6 = r0.zzg     // Catch:{ IOException -> 0x0299 }
            boolean r6 = r6.isEmpty()     // Catch:{ IOException -> 0x0299 }
            if (r6 != 0) goto L_0x01c7
            java.util.Map r6 = r0.zzg     // Catch:{ IOException -> 0x0299 }
            java.util.Set r6 = r6.entrySet()     // Catch:{ IOException -> 0x0299 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x0299 }
        L_0x019c:
            boolean r13 = r6.hasNext()     // Catch:{ IOException -> 0x0299 }
            if (r13 == 0) goto L_0x01c7
            java.lang.Object r13 = r6.next()     // Catch:{ IOException -> 0x0299 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ IOException -> 0x0299 }
            java.lang.Object r14 = r13.getKey()     // Catch:{ IOException -> 0x0299 }
            boolean r14 = r10.contains(r14)     // Catch:{ IOException -> 0x0299 }
            if (r14 != 0) goto L_0x019c
            com.google.android.gms.internal.ads.zzalc r14 = new com.google.android.gms.internal.ads.zzalc     // Catch:{ IOException -> 0x0299 }
            java.lang.Object r15 = r13.getKey()     // Catch:{ IOException -> 0x0299 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x0299 }
            java.lang.Object r13 = r13.getValue()     // Catch:{ IOException -> 0x0299 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ IOException -> 0x0299 }
            r14.<init>(r15, r13)     // Catch:{ IOException -> 0x0299 }
            r11.add(r14)     // Catch:{ IOException -> 0x0299 }
            goto L_0x019c
        L_0x01c7:
            com.google.android.gms.internal.ads.zzalg r6 = new com.google.android.gms.internal.ads.zzalg     // Catch:{ IOException -> 0x0299 }
            r17 = 304(0x130, float:4.26E-43)
            byte[] r0 = r0.zza     // Catch:{ IOException -> 0x0299 }
            r19 = 1
            r16 = r6
            r18 = r0
            r22 = r11
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List) r22)     // Catch:{ IOException -> 0x0299 }
            r0 = r6
        L_0x01d9:
            return r0
        L_0x01da:
            java.io.InputStream r11 = r12.zzc()     // Catch:{ IOException -> 0x0299 }
            if (r11 == 0) goto L_0x0225
            int r13 = r12.zza()     // Catch:{ IOException -> 0x0299 }
            r14 = r23
            com.google.android.gms.internal.ads.zzamb r15 = r14.zza     // Catch:{ IOException -> 0x0297 }
            com.google.android.gms.internal.ads.zzamn r8 = new com.google.android.gms.internal.ads.zzamn     // Catch:{ IOException -> 0x0297 }
            r8.<init>(r15, r13)     // Catch:{ IOException -> 0x0297 }
            r13 = 1024(0x400, float:1.435E-42)
            byte[] r13 = r15.zzb(r13)     // Catch:{ all -> 0x0213 }
        L_0x01f3:
            int r7 = r11.read(r13)     // Catch:{ all -> 0x01fd }
            if (r7 == r10) goto L_0x01ff
            r8.write(r13, r9, r7)     // Catch:{ all -> 0x01fd }
            goto L_0x01f3
        L_0x01fd:
            r0 = move-exception
            goto L_0x0215
        L_0x01ff:
            byte[] r7 = r8.toByteArray()     // Catch:{ all -> 0x01fd }
            r11.close()     // Catch:{ IOException -> 0x0207 }
            goto L_0x020c
        L_0x0207:
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x0297 }
            com.google.android.gms.internal.ads.zzalw.zzd(r2, r10)     // Catch:{ IOException -> 0x0297 }
        L_0x020c:
            r15.zza(r13)     // Catch:{ IOException -> 0x0297 }
            r8.close()     // Catch:{ IOException -> 0x0297 }
            goto L_0x0229
        L_0x0213:
            r0 = move-exception
            r13 = 0
        L_0x0215:
            r11.close()     // Catch:{ IOException -> 0x0219 }
            goto L_0x021e
        L_0x0219:
            java.lang.Object[] r6 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x0297 }
            com.google.android.gms.internal.ads.zzalw.zzd(r2, r6)     // Catch:{ IOException -> 0x0297 }
        L_0x021e:
            r15.zza(r13)     // Catch:{ IOException -> 0x0297 }
            r8.close()     // Catch:{ IOException -> 0x0297 }
            throw r0     // Catch:{ IOException -> 0x0297 }
        L_0x0225:
            r14 = r23
            byte[] r7 = new byte[r9]     // Catch:{ IOException -> 0x0297 }
        L_0x0229:
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0293 }
            long r10 = r10 - r4
            boolean r8 = com.google.android.gms.internal.ads.zzalw.zzb     // Catch:{ IOException -> 0x0293 }
            if (r8 != 0) goto L_0x023c
            r16 = 3000(0xbb8, double:1.482E-320)
            int r8 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x0239
            goto L_0x023c
        L_0x0239:
            r8 = 200(0xc8, float:2.8E-43)
            goto L_0x0271
        L_0x023c:
            java.lang.String r8 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            r13 = 5
            java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ IOException -> 0x0293 }
            r13[r9] = r1     // Catch:{ IOException -> 0x0293 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x0293 }
            r11 = 1
            r13[r11] = r10     // Catch:{ IOException -> 0x0293 }
            if (r7 == 0) goto L_0x0252
            int r10 = r7.length     // Catch:{ IOException -> 0x0293 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x0293 }
            goto L_0x0254
        L_0x0252:
            java.lang.String r10 = "null"
        L_0x0254:
            r11 = 2
            r13[r11] = r10     // Catch:{ IOException -> 0x0293 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x0293 }
            r11 = 3
            r13[r11] = r10     // Catch:{ IOException -> 0x0293 }
            com.google.android.gms.internal.ads.zzaky r10 = r24.zzy()     // Catch:{ IOException -> 0x0293 }
            int r10 = r10.zza()     // Catch:{ IOException -> 0x0293 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x0293 }
            r11 = 4
            r13[r11] = r10     // Catch:{ IOException -> 0x0293 }
            com.google.android.gms.internal.ads.zzalw.zza(r8, r13)     // Catch:{ IOException -> 0x0293 }
            goto L_0x0239
        L_0x0271:
            if (r0 < r8) goto L_0x028d
            r8 = 299(0x12b, float:4.19E-43)
            if (r0 > r8) goto L_0x028d
            com.google.android.gms.internal.ads.zzalg r8 = new com.google.android.gms.internal.ads.zzalg     // Catch:{ IOException -> 0x0293 }
            r19 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0293 }
            long r20 = r10 - r4
            r16 = r8
            r17 = r0
            r18 = r7
            r22 = r6
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List) r22)     // Catch:{ IOException -> 0x0293 }
            return r8
        L_0x028d:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0293 }
            r0.<init>()     // Catch:{ IOException -> 0x0293 }
            throw r0     // Catch:{ IOException -> 0x0293 }
        L_0x0293:
            r0 = move-exception
            r18 = r7
            goto L_0x02bb
        L_0x0297:
            r0 = move-exception
            goto L_0x02b9
        L_0x0299:
            r0 = move-exception
            r14 = r23
            goto L_0x02b9
        L_0x029d:
            r14 = r23
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x02a7 }
            java.lang.String r6 = "Could not retrieve response code from HttpUrlConnection."
            r0.<init>(r6)     // Catch:{ all -> 0x02a7 }
            throw r0     // Catch:{ all -> 0x02a7 }
        L_0x02a7:
            r0 = move-exception
            goto L_0x02ac
        L_0x02a9:
            r0 = move-exception
            r14 = r23
        L_0x02ac:
            r7 = 0
        L_0x02ad:
            if (r7 != 0) goto L_0x02b2
            r11.disconnect()     // Catch:{ IOException -> 0x02b3 }
        L_0x02b2:
            throw r0     // Catch:{ IOException -> 0x02b3 }
        L_0x02b3:
            r0 = move-exception
            goto L_0x02b8
        L_0x02b5:
            r0 = move-exception
            r14 = r23
        L_0x02b8:
            r12 = 0
        L_0x02b9:
            r18 = 0
        L_0x02bb:
            boolean r6 = r0 instanceof java.net.SocketTimeoutException
            if (r6 == 0) goto L_0x02cf
            com.google.android.gms.internal.ads.zzamm r0 = new com.google.android.gms.internal.ads.zzamm
            com.google.android.gms.internal.ads.zzals r6 = new com.google.android.gms.internal.ads.zzals
            r6.<init>()
            java.lang.String r7 = "socket"
            r8 = 0
            r0.<init>(r7, r6, r8)
        L_0x02cc:
            r6 = r0
            goto L_0x033e
        L_0x02cf:
            boolean r6 = r0 instanceof java.net.MalformedURLException
            if (r6 != 0) goto L_0x0389
            if (r12 == 0) goto L_0x0383
            int r0 = r12.zzb()
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            r7[r9] = r6
            java.lang.String r6 = r24.zzk()
            r8 = 1
            r7[r8] = r6
            java.lang.String r6 = "Unexpected response code %d for %s"
            com.google.android.gms.internal.ads.zzalw.zzb(r6, r7)
            if (r18 == 0) goto L_0x0330
            java.util.List r22 = r12.zzd()
            com.google.android.gms.internal.ads.zzalg r6 = new com.google.android.gms.internal.ads.zzalg
            r19 = 0
            long r7 = android.os.SystemClock.elapsedRealtime()
            long r20 = r7 - r4
            r16 = r6
            r17 = r0
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List) r22)
            r7 = 401(0x191, float:5.62E-43)
            if (r0 == r7) goto L_0x0322
            r7 = 403(0x193, float:5.65E-43)
            if (r0 != r7) goto L_0x030e
            goto L_0x0322
        L_0x030e:
            r1 = 400(0x190, float:5.6E-43)
            if (r0 < r1) goto L_0x031c
            r1 = 499(0x1f3, float:6.99E-43)
            if (r0 > r1) goto L_0x031c
            com.google.android.gms.internal.ads.zzakx r0 = new com.google.android.gms.internal.ads.zzakx
            r0.<init>(r6)
            throw r0
        L_0x031c:
            com.google.android.gms.internal.ads.zzalr r0 = new com.google.android.gms.internal.ads.zzalr
            r0.<init>(r6)
            throw r0
        L_0x0322:
            com.google.android.gms.internal.ads.zzamm r0 = new com.google.android.gms.internal.ads.zzamm
            com.google.android.gms.internal.ads.zzaks r7 = new com.google.android.gms.internal.ads.zzaks
            r7.<init>(r6)
            java.lang.String r6 = "auth"
            r8 = 0
            r0.<init>(r6, r7, r8)
            goto L_0x02cc
        L_0x0330:
            r8 = 0
            com.google.android.gms.internal.ads.zzamm r0 = new com.google.android.gms.internal.ads.zzamm
            com.google.android.gms.internal.ads.zzalf r6 = new com.google.android.gms.internal.ads.zzalf
            r6.<init>()
            java.lang.String r7 = "network"
            r0.<init>(r7, r6, r8)
            goto L_0x02cc
        L_0x033e:
            com.google.android.gms.internal.ads.zzaky r0 = r24.zzy()
            int r7 = r24.zzb()
            com.google.android.gms.internal.ads.zzalt r8 = r6.zzb     // Catch:{ zzalt -> 0x0368 }
            r0.zzc(r8)     // Catch:{ zzalt -> 0x0368 }
            r8 = 2
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r6 = r6.zza
            r0[r9] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r7 = 1
            r0[r7] = r6
            java.lang.String r6 = "%s-retry [timeout=%s]"
            java.lang.String r0 = java.lang.String.format(r6, r0)
            r1.zzm(r0)
            goto L_0x000a
        L_0x0368:
            r0 = move-exception
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = r6.zza
            r2[r9] = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            r4 = 1
            r2[r4] = r3
            java.lang.String r3 = "%s-timeout-giveup [timeout=%s]"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r1.zzm(r2)
            throw r0
        L_0x0383:
            com.google.android.gms.internal.ads.zzalh r1 = new com.google.android.gms.internal.ads.zzalh
            r1.<init>(r0)
            throw r1
        L_0x0389:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r1 = r24.zzk()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "Bad URL "
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalz.zza(com.google.android.gms.internal.ads.zzalk):com.google.android.gms.internal.ads.zzalg");
    }
}
