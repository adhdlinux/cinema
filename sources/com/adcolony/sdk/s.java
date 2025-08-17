package com.adcolony.sdk;

import android.content.Context;
import com.adcolony.sdk.e0;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.protobuf.CodedOutputStream;
import com.uwetrottmann.trakt5.TraktV2;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.ui.AdActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;
import org.joda.time.DateTimeConstants;

class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private HttpURLConnection f13357b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f13358c;

    /* renamed from: d  reason: collision with root package name */
    private h0 f13359d;

    /* renamed from: e  reason: collision with root package name */
    private a f13360e;

    /* renamed from: f  reason: collision with root package name */
    private g f13361f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f13362g;

    /* renamed from: h  reason: collision with root package name */
    private int f13363h = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13364i = false;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, List<String>> f13365j;

    /* renamed from: k  reason: collision with root package name */
    private String f13366k = "";

    /* renamed from: l  reason: collision with root package name */
    private String f13367l = "";

    /* renamed from: m  reason: collision with root package name */
    String f13368m = "";

    /* renamed from: n  reason: collision with root package name */
    String f13369n = "";

    /* renamed from: o  reason: collision with root package name */
    boolean f13370o;

    /* renamed from: p  reason: collision with root package name */
    int f13371p;

    /* renamed from: q  reason: collision with root package name */
    int f13372q;

    interface a {
        void a(s sVar, h0 h0Var, Map<String, List<String>> map);
    }

    s(h0 h0Var, a aVar) {
        this.f13359d = h0Var;
        this.f13360e = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        r1 = "UTF-8";
        r2 = r7.f13362g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005c, code lost:
        if (r2 == null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        if (r2.isEmpty() != false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        r1 = r7.f13362g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        if ((r9 instanceof java.io.ByteArrayOutputStream) == false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        r2 = r7.f13357b.getHeaderField(com.uwetrottmann.trakt5.TraktV2.HEADER_CONTENT_TYPE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
        if (r7.f13361f == null) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
        if (r2 == null) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007e, code lost:
        if (r2.contains("application/octet-stream") == false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0087, code lost:
        if (((java.io.ByteArrayOutputStream) r9).size() == 0) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0089, code lost:
        r7.f13369n = r7.f13361f.h(((java.io.ByteArrayOutputStream) r9).toByteArray());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0099, code lost:
        r7.f13369n = ((java.io.ByteArrayOutputStream) r9).toString(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a5, code lost:
        if (r9 == null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a7, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00aa, code lost:
        if (r8 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ac, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.io.InputStream r8, java.io.OutputStream r9) throws java.lang.Exception {
        /*
            r7 = this;
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ all -> 0x00ba }
            r0.<init>(r8)     // Catch:{ all -> 0x00ba }
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r1]     // Catch:{ all -> 0x00b0 }
        L_0x0009:
            r3 = 0
            int r4 = r0.read(r2, r3, r1)     // Catch:{ all -> 0x00b0 }
            r5 = -1
            if (r4 == r5) goto L_0x0058
            int r5 = r7.f13371p     // Catch:{ all -> 0x00b0 }
            int r5 = r5 + r4
            r7.f13371p = r5     // Catch:{ all -> 0x00b0 }
            boolean r6 = r7.f13364i     // Catch:{ all -> 0x00b0 }
            if (r6 == 0) goto L_0x0054
            int r6 = r7.f13363h     // Catch:{ all -> 0x00b0 }
            if (r5 > r6) goto L_0x001f
            goto L_0x0054
        L_0x001f:
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ all -> 0x00b0 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r2.<init>()     // Catch:{ all -> 0x00b0 }
            java.lang.String r3 = "Data exceeds expected maximum ("
            r2.append(r3)     // Catch:{ all -> 0x00b0 }
            int r3 = r7.f13371p     // Catch:{ all -> 0x00b0 }
            r2.append(r3)     // Catch:{ all -> 0x00b0 }
            java.lang.String r3 = "/"
            r2.append(r3)     // Catch:{ all -> 0x00b0 }
            int r3 = r7.f13363h     // Catch:{ all -> 0x00b0 }
            r2.append(r3)     // Catch:{ all -> 0x00b0 }
            java.lang.String r3 = "): "
            r2.append(r3)     // Catch:{ all -> 0x00b0 }
            java.net.HttpURLConnection r3 = r7.f13357b     // Catch:{ all -> 0x00b0 }
            java.net.URL r3 = r3.getURL()     // Catch:{ all -> 0x00b0 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b0 }
            r2.append(r3)     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00b0 }
            r1.<init>(r2)     // Catch:{ all -> 0x00b0 }
            throw r1     // Catch:{ all -> 0x00b0 }
        L_0x0054:
            r9.write(r2, r3, r4)     // Catch:{ all -> 0x00b0 }
            goto L_0x0009
        L_0x0058:
            java.lang.String r1 = "UTF-8"
            java.lang.String r2 = r7.f13362g     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x0066
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x00b0 }
            if (r2 != 0) goto L_0x0066
            java.lang.String r1 = r7.f13362g     // Catch:{ all -> 0x00b0 }
        L_0x0066:
            boolean r2 = r9 instanceof java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x00a2
            java.net.HttpURLConnection r2 = r7.f13357b     // Catch:{ all -> 0x00b0 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r2 = r2.getHeaderField(r3)     // Catch:{ all -> 0x00b0 }
            com.adcolony.sdk.g r3 = r7.f13361f     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x0099
            if (r2 == 0) goto L_0x0099
            java.lang.String r3 = "application/octet-stream"
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x0099
            r2 = r9
            java.io.ByteArrayOutputStream r2 = (java.io.ByteArrayOutputStream) r2     // Catch:{ all -> 0x00b0 }
            int r2 = r2.size()     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x0099
            com.adcolony.sdk.g r1 = r7.f13361f     // Catch:{ all -> 0x00b0 }
            r2 = r9
            java.io.ByteArrayOutputStream r2 = (java.io.ByteArrayOutputStream) r2     // Catch:{ all -> 0x00b0 }
            byte[] r2 = r2.toByteArray()     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = r1.h(r2)     // Catch:{ all -> 0x00b0 }
            r7.f13369n = r1     // Catch:{ all -> 0x00b0 }
            goto L_0x00a2
        L_0x0099:
            r2 = r9
            java.io.ByteArrayOutputStream r2 = (java.io.ByteArrayOutputStream) r2     // Catch:{ all -> 0x00b0 }
            java.lang.String r1 = r2.toString(r1)     // Catch:{ all -> 0x00b0 }
            r7.f13369n = r1     // Catch:{ all -> 0x00b0 }
        L_0x00a2:
            r0.close()     // Catch:{ all -> 0x00ba }
            if (r9 == 0) goto L_0x00aa
            r9.close()
        L_0x00aa:
            if (r8 == 0) goto L_0x00af
            r8.close()
        L_0x00af:
            return
        L_0x00b0:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x00b5 }
            goto L_0x00b9
        L_0x00b5:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ all -> 0x00ba }
        L_0x00b9:
            throw r1     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r0 = move-exception
            if (r9 == 0) goto L_0x00c0
            r9.close()
        L_0x00c0:
            if (r8 == 0) goto L_0x00c5
            r8.close()
        L_0x00c5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.s.a(java.io.InputStream, java.io.OutputStream):void");
    }

    private void b(String str, String str2) {
        try {
            String substring = str2.substring(0, str2.lastIndexOf("/") + 1);
            if (!str2.equals("") && !substring.equals(a.f().O0().j()) && !new File(str).renameTo(new File(str2))) {
                new e0.a().c("Moving of ").c(str).c(" failed.").d(e0.f13112g);
            }
        } catch (Exception e2) {
            new e0.a().c("Exception: ").c(e2.toString()).d(e0.f13113h);
            e2.printStackTrace();
        }
    }

    private boolean d() throws IOException {
        boolean z2;
        f1 a2 = this.f13359d.a();
        String E = c0.E(a2, "content_type");
        String E2 = c0.E(a2, "content");
        f1 F = a2.F("dictionaries");
        f1 F2 = a2.F("dictionaries_mapping");
        this.f13368m = c0.E(a2, ImagesContract.URL);
        if (F != null) {
            g.c(F.x());
        }
        if (a.f().g() && F2 != null) {
            this.f13361f = g.a(c0.F(F2, AdActivity.REQUEST_KEY_EXTRA), c0.F(F2, "response"));
        }
        String E3 = c0.E(a2, "user_agent");
        int a3 = c0.a(a2, "read_timeout", DateTimeConstants.MILLIS_PER_MINUTE);
        int a4 = c0.a(a2, "connect_timeout", DateTimeConstants.MILLIS_PER_MINUTE);
        boolean t2 = c0.t(a2, "no_redirect");
        this.f13368m = c0.E(a2, ImagesContract.URL);
        this.f13366k = c0.E(a2, "filepath");
        StringBuilder sb = new StringBuilder();
        sb.append(a.f().O0().j());
        String str = this.f13366k;
        sb.append(str.substring(str.lastIndexOf("/") + 1));
        this.f13367l = sb.toString();
        this.f13362g = c0.E(a2, "encoding");
        int a5 = c0.a(a2, "max_size", 0);
        this.f13363h = a5;
        if (a5 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f13364i = z2;
        this.f13371p = 0;
        this.f13358c = null;
        this.f13357b = null;
        this.f13365j = null;
        if (!this.f13368m.startsWith(AdPayload.FILE_SCHEME)) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f13368m).openConnection();
            this.f13357b = httpURLConnection;
            httpURLConnection.setReadTimeout(a3);
            this.f13357b.setConnectTimeout(a4);
            this.f13357b.setInstanceFollowRedirects(!t2);
            if (E3 != null && !E3.equals("")) {
                this.f13357b.setRequestProperty("User-Agent", E3);
            }
            if (this.f13361f != null) {
                this.f13357b.setRequestProperty(TraktV2.HEADER_CONTENT_TYPE, "application/octet-stream");
                this.f13357b.setRequestProperty("Req-Dict-Id", this.f13361f.g());
                this.f13357b.setRequestProperty("Resp-Dict-Id", this.f13361f.j());
            } else {
                this.f13357b.setRequestProperty("Accept-Charset", h.f13158a.name());
                if (!E.equals("")) {
                    this.f13357b.setRequestProperty(TraktV2.HEADER_CONTENT_TYPE, E);
                }
            }
            if (this.f13359d.c().equals("WebServices.post")) {
                this.f13357b.setDoOutput(true);
                g gVar = this.f13361f;
                if (gVar != null) {
                    byte[] d2 = gVar.d(E2);
                    this.f13357b.setFixedLengthStreamingMode(d2.length);
                    this.f13357b.getOutputStream().write(d2);
                    this.f13357b.getOutputStream().flush();
                } else {
                    this.f13357b.setFixedLengthStreamingMode(E2.getBytes(h.f13158a).length);
                    new PrintStream(this.f13357b.getOutputStream()).print(E2);
                }
            }
        } else if (this.f13368m.startsWith("file:///android_asset/")) {
            Context a6 = a.a();
            if (a6 != null) {
                this.f13358c = a6.getAssets().open(this.f13368m.substring(22));
            }
        } else {
            this.f13358c = new FileInputStream(this.f13368m.substring(7));
        }
        if (this.f13357b == null && this.f13358c == null) {
            return false;
        }
        return true;
    }

    private void e() throws Exception {
        OutputStream outputStream;
        InputStream inputStream;
        String c2 = this.f13359d.c();
        if (this.f13358c != null) {
            if (this.f13366k.length() == 0) {
                outputStream = new ByteArrayOutputStream(CodedOutputStream.DEFAULT_BUFFER_SIZE);
            } else {
                outputStream = new FileOutputStream(new File(this.f13366k).getAbsolutePath());
            }
        } else if (c2.equals("WebServices.download")) {
            this.f13358c = this.f13357b.getInputStream();
            outputStream = new FileOutputStream(this.f13367l);
        } else if (c2.equals("WebServices.get")) {
            this.f13358c = this.f13357b.getInputStream();
            outputStream = new ByteArrayOutputStream(CodedOutputStream.DEFAULT_BUFFER_SIZE);
        } else if (c2.equals("WebServices.post")) {
            this.f13357b.connect();
            if (this.f13357b.getResponseCode() < 200 || this.f13357b.getResponseCode() > 299) {
                inputStream = this.f13357b.getErrorStream();
            } else {
                inputStream = this.f13357b.getInputStream();
            }
            this.f13358c = inputStream;
            outputStream = new ByteArrayOutputStream(CodedOutputStream.DEFAULT_BUFFER_SIZE);
        } else {
            outputStream = null;
        }
        HttpURLConnection httpURLConnection = this.f13357b;
        if (httpURLConnection != null) {
            this.f13372q = httpURLConnection.getResponseCode();
            this.f13365j = this.f13357b.getHeaderFields();
        }
        a(this.f13358c, outputStream);
    }

    /* access modifiers changed from: package-private */
    public h0 c() {
        return this.f13359d;
    }

    public void run() {
        boolean z2;
        boolean z3 = false;
        this.f13370o = false;
        try {
            if (d()) {
                e();
                if (this.f13359d.c().equals("WebServices.post")) {
                    if (this.f13372q != 200) {
                        z2 = false;
                        this.f13370o = z2;
                    }
                }
                z2 = true;
                this.f13370o = z2;
            }
        } catch (MalformedURLException e2) {
            new e0.a().c("MalformedURLException: ").c(e2.toString()).d(e0.f13114i);
            this.f13370o = true;
        } catch (OutOfMemoryError unused) {
            e0.a a2 = new e0.a().c("Out of memory error - disabling AdColony. (").a(this.f13371p).c("/").a(this.f13363h);
            a2.c("): " + this.f13368m).d(e0.f13113h);
            a.f().R(true);
        } catch (IOException e3) {
            new e0.a().c("Download of ").c(this.f13368m).c(" failed: ").c(e3.toString()).d(e0.f13112g);
            int i2 = this.f13372q;
            if (i2 == 0) {
                i2 = 504;
            }
            this.f13372q = i2;
        } catch (IllegalStateException e4) {
            new e0.a().c("okhttp error: ").c(e4.toString()).d(e0.f13113h);
            e4.printStackTrace();
        } catch (DataFormatException e5) {
            new e0.a().c("Exception, possibly trying to decompress plain response: ").c(e5.toString()).d(e0.f13114i);
            e5.printStackTrace();
        } catch (IllegalArgumentException e6) {
            new e0.a().c("Exception, possibly response encoded with different dictionary: ").c(e6.toString()).d(e0.f13114i);
            e6.printStackTrace();
        } catch (AssertionError e7) {
            new e0.a().c("okhttp error: ").c(e7.toString()).d(e0.f13113h);
            e7.printStackTrace();
        } catch (Exception e8) {
            new e0.a().c("Exception: ").c(e8.toString()).d(e0.f13113h);
            e8.printStackTrace();
        }
        z3 = true;
        if (z3) {
            if (this.f13359d.c().equals("WebServices.download")) {
                b(this.f13367l, this.f13366k);
            }
            this.f13360e.a(this, this.f13359d, this.f13365j);
        }
    }
}
