package us.shandian.giga.get;

public class DownloadRunnableFallback implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final DownloadMission f42220b;

    public DownloadRunnableFallback(DownloadMission downloadMission) {
        if (downloadMission != null) {
            this.f42220b = downloadMission;
            return;
        }
        throw new NullPointerException("mission is null");
    }

    private void a(int i2) {
        synchronized (this.f42220b) {
            this.f42220b.l(i2);
            this.f42220b.p();
        }
    }

    private void b() {
        synchronized (this.f42220b) {
            this.f42220b.m();
        }
    }

    private void c(long j2) {
        synchronized (this.f42220b) {
            this.f42220b.n(j2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            r0 = -1
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00a8 }
            us.shandian.giga.get.DownloadMission r2 = r8.f42220b     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r2 = r2.f42191c     // Catch:{ Exception -> 0x00a8 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00a8 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x00a8 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x00a8 }
            us.shandian.giga.get.DownloadMission r2 = r8.f42220b     // Catch:{ Exception -> 0x00a8 }
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r2.f42195g     // Catch:{ Exception -> 0x00a8 }
            if (r2 == 0) goto L_0x003e
            java.util.Set r2 = r2.entrySet()     // Catch:{ Exception -> 0x00a8 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x00a8 }
        L_0x001e:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x00a8 }
            if (r3 == 0) goto L_0x003e
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x00a8 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x00a8 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00a8 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00a8 }
            r1.setRequestProperty(r4, r3)     // Catch:{ Exception -> 0x00a8 }
            goto L_0x001e
        L_0x003e:
            int r2 = r1.getResponseCode()     // Catch:{ Exception -> 0x00a8 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 == r3) goto L_0x0052
            int r2 = r1.getResponseCode()     // Catch:{ Exception -> 0x00a8 }
            r3 = 206(0xce, float:2.89E-43)
            if (r2 == r3) goto L_0x0052
            r8.a(r3)     // Catch:{ Exception -> 0x00a8 }
            goto L_0x00ad
        L_0x0052:
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00a8 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a8 }
            r3.<init>()     // Catch:{ Exception -> 0x00a8 }
            us.shandian.giga.get.DownloadMission r4 = r8.f42220b     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r4 = r4.f42192d     // Catch:{ Exception -> 0x00a8 }
            r3.append(r4)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ Exception -> 0x00a8 }
            us.shandian.giga.get.DownloadMission r4 = r8.f42220b     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r4 = r4.f42190b     // Catch:{ Exception -> 0x00a8 }
            r3.append(r4)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r4 = "rw"
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x00a8 }
            r3 = 0
            r2.seek(r3)     // Catch:{ Exception -> 0x00a8 }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00a8 }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ Exception -> 0x00a8 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00a8 }
            r1 = 512(0x200, float:7.175E-43)
            byte[] r4 = new byte[r1]     // Catch:{ Exception -> 0x00a8 }
        L_0x0087:
            r5 = 0
            int r6 = r3.read(r4, r5, r1)     // Catch:{ Exception -> 0x00a8 }
            if (r6 == r0) goto L_0x00a1
            us.shandian.giga.get.DownloadMission r7 = r8.f42220b     // Catch:{ Exception -> 0x00a8 }
            boolean r7 = r7.f42202n     // Catch:{ Exception -> 0x00a8 }
            if (r7 == 0) goto L_0x00a1
            r2.write(r4, r5, r6)     // Catch:{ Exception -> 0x00a8 }
            long r5 = (long) r6     // Catch:{ Exception -> 0x00a8 }
            r8.c(r5)     // Catch:{ Exception -> 0x00a8 }
            boolean r5 = java.lang.Thread.interrupted()     // Catch:{ Exception -> 0x00a8 }
            if (r5 == 0) goto L_0x0087
        L_0x00a1:
            r2.close()     // Catch:{ Exception -> 0x00a8 }
            r3.close()     // Catch:{ Exception -> 0x00a8 }
            goto L_0x00ad
        L_0x00a8:
            r1 = 233(0xe9, float:3.27E-43)
            r8.a(r1)
        L_0x00ad:
            us.shandian.giga.get.DownloadMission r1 = r8.f42220b
            int r2 = r1.f42205q
            if (r2 != r0) goto L_0x00ba
            boolean r0 = r1.f42202n
            if (r0 == 0) goto L_0x00ba
            r8.b()
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.shandian.giga.get.DownloadRunnableFallback.run():void");
    }
}
