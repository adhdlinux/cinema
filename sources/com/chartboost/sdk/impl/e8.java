package com.chartboost.sdk.impl;

import android.os.Build;
import android.os.Handler;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.internal.Model.CBError;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;

public class e8 implements Runnable, Comparable {

    /* renamed from: b  reason: collision with root package name */
    public final Executor f17610b;

    /* renamed from: c  reason: collision with root package name */
    public final f8 f17611c;

    /* renamed from: d  reason: collision with root package name */
    public final r2 f17612d;

    /* renamed from: e  reason: collision with root package name */
    public final gb f17613e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f17614f;

    /* renamed from: g  reason: collision with root package name */
    public final l2 f17615g;

    /* renamed from: h  reason: collision with root package name */
    public final z4 f17616h;

    /* renamed from: i  reason: collision with root package name */
    public o2 f17617i;

    /* renamed from: j  reason: collision with root package name */
    public p2 f17618j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f17619k = true;

    public e8(Executor executor, f8 f8Var, r2 r2Var, gb gbVar, Handler handler, l2 l2Var, z4 z4Var) {
        this.f17610b = executor;
        this.f17611c = f8Var;
        this.f17612d = r2Var;
        this.f17613e = gbVar;
        this.f17614f = handler;
        this.f17615g = l2Var;
        this.f17616h = z4Var;
    }

    public static boolean b(int i2) {
        return ((100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    public final o2 a(int i2) {
        CBError.a aVar = CBError.a.NETWORK_FAILURE;
        return o2.a(new CBError(aVar, "Failure due to HTTP status code " + i2));
    }

    public final void b() {
        l2 l2Var = this.f17615g;
        if (l2Var != null && l2Var.f18093e != null && (l2Var instanceof id)) {
            File parentFile = this.f17615g.f18093e.getParentFile();
            File file = new File(parentFile, this.f17615g.f18093e.getName() + DefaultDiskStorage.FileType.TEMP);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public final void c(HttpsURLConnection httpsURLConnection) {
        FileOutputStream fileOutputStream;
        File file = new File(this.f17615g.f18093e.getParentFile(), this.f17615g.f18093e.getName() + DefaultDiskStorage.FileType.TEMP);
        if (this.f17615g instanceof id) {
            if (file.exists()) {
                return;
            }
            if (!file.createNewFile()) {
                throw new IOException("Video temp file was not created and doesn't exist");
            }
        }
        l2 l2Var = this.f17615g;
        if (l2Var instanceof id) {
            a(l2Var.e(), a(httpsURLConnection));
        }
        InputStream inputStream = httpsURLConnection.getInputStream();
        try {
            fileOutputStream = new FileOutputStream(file);
            if (this.f17615g instanceof id) {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        if (file.exists()) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            throw new IOException("Temp file was deleted during download");
                        }
                    }
                }
            } else {
                t3.a(inputStream, fileOutputStream);
            }
            fileOutputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
            if (file.renameTo(this.f17615g.f18093e)) {
                return;
            }
            if (!file.delete()) {
                String str = "Unable to delete " + file.getAbsolutePath() + " after failing to rename to " + this.f17615g.f18093e.getAbsolutePath();
                a(str);
                throw new IOException(str);
            }
            String str2 = "Unable to move " + file.getAbsolutePath() + " to " + this.f17615g.f18093e.getAbsolutePath();
            a(str2);
            throw new IOException(str2);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
        throw th;
    }

    public void run() {
        o2 o2Var = this.f17617i;
        if (o2Var != null) {
            try {
                CBError cBError = o2Var.f18285b;
                if (cBError == null) {
                    this.f17615g.a(o2Var.f18284a, this.f17618j);
                } else {
                    this.f17615g.a(cBError, this.f17618j);
                }
            } catch (Exception e2) {
                w7.a("NetworkDispatcher", "deliver result: ", e2);
            }
        } else if (this.f17615g.f18092d.compareAndSet(0, 1)) {
            long b2 = this.f17613e.b();
            try {
                if (this.f17612d.e()) {
                    p2 a2 = a(this.f17615g);
                    this.f17618j = a2;
                    if (a2.c()) {
                        this.f17617i = this.f17615g.a(this.f17618j);
                    } else {
                        this.f17617i = a(this.f17618j.b());
                    }
                } else {
                    this.f17617i = a();
                }
                this.f17615g.f18094f = this.f17613e.b() - b2;
                int i2 = this.f17615g.f18097i;
                if (i2 != 0) {
                    if (i2 != 1) {
                        return;
                    }
                    this.f17610b.execute(this);
                    return;
                }
            } catch (InterruptedIOException | SocketException | UnknownHostException | SSLException e3) {
                if (this.f17612d.e()) {
                    this.f17617i = a(e3);
                } else {
                    this.f17617i = a();
                }
                a((tb) tb.g.DISPATCHER_EXCEPTION, e3.toString());
                this.f17615g.f18094f = this.f17613e.b() - b2;
                int i3 = this.f17615g.f18097i;
                if (i3 != 0) {
                    if (i3 != 1) {
                        return;
                    }
                }
            } catch (Throwable th) {
                this.f17615g.f18094f = this.f17613e.b() - b2;
                int i4 = this.f17615g.f18097i;
                if (i4 == 0) {
                    this.f17614f.post(this);
                } else if (i4 == 1) {
                    this.f17610b.execute(this);
                }
                throw th;
            }
            this.f17614f.post(this);
        }
    }

    public final o2 a() {
        return o2.a(new CBError(CBError.a.INTERNET_UNAVAILABLE, "Internet Unavailable"));
    }

    public final o2 a(IOException iOException) {
        return o2.a(new CBError(CBError.a.NETWORK_FAILURE, iOException.toString()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        if (r0 != null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r2 = r2.getErrorStream();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] b(javax.net.ssl.HttpsURLConnection r2) {
        /*
            r1 = this;
            r0 = 0
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ IOException -> 0x0009 }
        L_0x0005:
            r0 = r2
            goto L_0x000e
        L_0x0007:
            r2 = move-exception
            goto L_0x0023
        L_0x0009:
            java.io.InputStream r2 = r2.getErrorStream()     // Catch:{ all -> 0x0007 }
            goto L_0x0005
        L_0x000e:
            if (r0 == 0) goto L_0x001a
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0007 }
            r2.<init>(r0)     // Catch:{ all -> 0x0007 }
            byte[] r2 = com.chartboost.sdk.impl.t3.a(r2)     // Catch:{ all -> 0x0007 }
            goto L_0x001d
        L_0x001a:
            r2 = 0
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0007 }
        L_0x001d:
            if (r0 == 0) goto L_0x0022
            r0.close()     // Catch:{ IOException -> 0x0022 }
        L_0x0022:
            return r2
        L_0x0023:
            if (r0 == 0) goto L_0x0028
            r0.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.e8.b(javax.net.ssl.HttpsURLConnection):byte[]");
    }

    public final o2 a(Throwable th) {
        return o2.a(new CBError(CBError.a.MISCELLANEOUS, th.toString()));
    }

    public final void a(tb tbVar, String str) {
        try {
            b();
            this.f17616h.track(d4.a(tbVar, str));
        } catch (Exception unused) {
        }
    }

    public final p2 a(l2 l2Var) {
        int i2 = 10000;
        int i3 = 0;
        while (true) {
            try {
                return a(l2Var, i2);
            } catch (SocketTimeoutException e2) {
                if (i3 < 1) {
                    i2 *= 2;
                    i3++;
                } else {
                    throw e2;
                }
            }
        }
    }

    public final p2 a(l2 l2Var, int i2) {
        long b2;
        this.f17619k = true;
        m2 a2 = l2Var.a();
        Map map = a2.f18181a;
        HttpsURLConnection a3 = this.f17611c.a(l2Var);
        a3.setSSLSocketFactory(v2.a());
        a3.setConnectTimeout(i2);
        a3.setReadTimeout(i2);
        a3.setUseCaches(false);
        a3.setDoInput(true);
        try {
            a(map, a3);
            a3.setRequestMethod(l2Var.c());
            a(a2, a3);
            b2 = this.f17613e.b();
            int responseCode = a3.getResponseCode();
            long b3 = this.f17613e.b();
            l2Var.f18095g = b3 - b2;
            if (responseCode != -1) {
                p2 p2Var = new p2(responseCode, a(a3, responseCode, b3));
                a3.disconnect();
                return p2Var;
            }
            throw new IOException("Could not retrieve response code from HttpsURLConnection.");
        } catch (Throwable th) {
            a3.disconnect();
            throw th;
        }
    }

    public final void a(Map map, HttpsURLConnection httpsURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpsURLConnection.addRequestProperty(str, (String) map.get(str));
            }
        }
    }

    public final void a(m2 m2Var, HttpsURLConnection httpsURLConnection) {
        if ("POST".equals(this.f17615g.c()) && m2Var.f18182b != null) {
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setFixedLengthStreamingMode(m2Var.f18182b.length);
            String str = m2Var.f18183c;
            if (str != null) {
                httpsURLConnection.addRequestProperty(TraktV2.HEADER_CONTENT_TYPE, str);
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            try {
                dataOutputStream.write(m2Var.f18182b);
                dataOutputStream.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            return;
        }
        throw th;
    }

    public final byte[] a(HttpsURLConnection httpsURLConnection, int i2, long j2) {
        byte[] bArr;
        byte[] bArr2 = new byte[0];
        try {
            if (!b(i2)) {
                bArr = new byte[0];
            } else if (this.f17615g.f18093e != null) {
                c(httpsURLConnection);
                return bArr2;
            } else {
                bArr = b(httpsURLConnection);
            }
            bArr2 = bArr;
            return bArr2;
        } finally {
            this.f17615g.f18096h = this.f17613e.b() - j2;
        }
    }

    public final void a(String str) {
        this.f17616h.track(d4.a(tb.g.RESPONSE_DATA_WRITE_ERROR, str));
    }

    public final void a(String str, long j2) {
        if (this.f17619k) {
            this.f17619k = false;
            this.f17615g.a(str, j2);
        }
    }

    /* renamed from: a */
    public int compareTo(e8 e8Var) {
        return this.f17615g.d().b() - e8Var.f17615g.d().b();
    }

    public final long a(HttpsURLConnection httpsURLConnection) {
        if (Build.VERSION.SDK_INT < 24) {
            return (long) httpsURLConnection.getContentLength();
        }
        return httpsURLConnection.getContentLengthLong();
    }
}
