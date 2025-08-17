package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Predicate;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

public class DefaultHttpDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private final boolean f28411e;

    /* renamed from: f  reason: collision with root package name */
    private final int f28412f;

    /* renamed from: g  reason: collision with root package name */
    private final int f28413g;

    /* renamed from: h  reason: collision with root package name */
    private final String f28414h;

    /* renamed from: i  reason: collision with root package name */
    private final HttpDataSource$RequestProperties f28415i;

    /* renamed from: j  reason: collision with root package name */
    private final HttpDataSource$RequestProperties f28416j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f28417k;

    /* renamed from: l  reason: collision with root package name */
    private Predicate<String> f28418l;

    /* renamed from: m  reason: collision with root package name */
    private DataSpec f28419m;

    /* renamed from: n  reason: collision with root package name */
    private HttpURLConnection f28420n;

    /* renamed from: o  reason: collision with root package name */
    private InputStream f28421o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f28422p;

    /* renamed from: q  reason: collision with root package name */
    private int f28423q;

    /* renamed from: r  reason: collision with root package name */
    private long f28424r;

    /* renamed from: s  reason: collision with root package name */
    private long f28425s;

    public static final class Factory implements HttpDataSource$Factory {

        /* renamed from: a  reason: collision with root package name */
        private final HttpDataSource$RequestProperties f28426a = new HttpDataSource$RequestProperties();

        /* renamed from: b  reason: collision with root package name */
        private TransferListener f28427b;

        /* renamed from: c  reason: collision with root package name */
        private Predicate<String> f28428c;

        /* renamed from: d  reason: collision with root package name */
        private String f28429d;

        /* renamed from: e  reason: collision with root package name */
        private int f28430e = 8000;

        /* renamed from: f  reason: collision with root package name */
        private int f28431f = 8000;

        /* renamed from: g  reason: collision with root package name */
        private boolean f28432g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f28433h;

        /* renamed from: b */
        public DefaultHttpDataSource a() {
            DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.f28429d, this.f28430e, this.f28431f, this.f28432g, this.f28426a, this.f28428c, this.f28433h);
            TransferListener transferListener = this.f28427b;
            if (transferListener != null) {
                defaultHttpDataSource.p(transferListener);
            }
            return defaultHttpDataSource;
        }

        public Factory c(String str) {
            this.f28429d = str;
            return this;
        }
    }

    private static class NullFilteringHeadersMap extends ForwardingMap<String, List<String>> {

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, List<String>> f28434b;

        public NullFilteringHeadersMap(Map<String, List<String>> map) {
            this.f28434b = map;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean j(Map.Entry entry) {
            return entry.getKey() != null;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean k(String str) {
            return str != null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Map<String, List<String>> a() {
            return this.f28434b;
        }

        public boolean containsKey(Object obj) {
            return obj != null && super.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return super.d(obj);
        }

        public Set<Map.Entry<String, List<String>>> entrySet() {
            return Sets.b(super.entrySet(), new c());
        }

        public boolean equals(Object obj) {
            return obj != null && super.e(obj);
        }

        public int hashCode() {
            return super.f();
        }

        /* renamed from: i */
        public List<String> get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }

        public boolean isEmpty() {
            if (!super.isEmpty()) {
                return super.size() == 1 && super.containsKey((Object) null);
            }
            return true;
        }

        public Set<String> keySet() {
            return Sets.b(super.keySet(), new b());
        }

        public int size() {
            return super.size() - (super.containsKey((Object) null) ? 1 : 0);
        }
    }

    private HttpURLConnection A(URL url, int i2, byte[] bArr, long j2, long j3, boolean z2, boolean z3, Map<String, String> map) throws IOException {
        String str;
        boolean z4;
        HttpURLConnection C = C(url);
        C.setConnectTimeout(this.f28412f);
        C.setReadTimeout(this.f28413g);
        HashMap hashMap = new HashMap();
        HttpDataSource$RequestProperties httpDataSource$RequestProperties = this.f28415i;
        if (httpDataSource$RequestProperties != null) {
            hashMap.putAll(httpDataSource$RequestProperties.a());
        }
        hashMap.putAll(this.f28416j.a());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            C.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String a2 = HttpUtil.a(j2, j3);
        if (a2 != null) {
            C.setRequestProperty("Range", a2);
        }
        String str2 = this.f28414h;
        if (str2 != null) {
            C.setRequestProperty("User-Agent", str2);
        }
        if (z2) {
            str = "gzip";
        } else {
            str = InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY;
        }
        C.setRequestProperty("Accept-Encoding", str);
        C.setInstanceFollowRedirects(z3);
        if (bArr != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        C.setDoOutput(z4);
        C.setRequestMethod(DataSpec.c(i2));
        if (bArr != null) {
            C.setFixedLengthStreamingMode(bArr.length);
            C.connect();
            OutputStream outputStream = C.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            C.connect();
        }
        return C;
    }

    private static void B(HttpURLConnection httpURLConnection, long j2) {
        int i2;
        if (httpURLConnection != null && (i2 = Util.f28808a) >= 19 && i2 <= 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j2 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j2 <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = ((Class) Assertions.e(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    private int D(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f28424r;
        if (j2 != -1) {
            long j3 = j2 - this.f28425s;
            if (j3 == 0) {
                return -1;
            }
            i3 = (int) Math.min((long) i3, j3);
        }
        int read = ((InputStream) Util.j(this.f28421o)).read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        this.f28425s += (long) read;
        s(read);
        return read;
    }

    private void E(long j2, DataSpec dataSpec) throws IOException {
        if (j2 != 0) {
            byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            while (j2 > 0) {
                int read = ((InputStream) Util.j(this.f28421o)).read(bArr, 0, (int) Math.min(j2, (long) CodedOutputStream.DEFAULT_BUFFER_SIZE));
                if (Thread.currentThread().isInterrupted()) {
                    throw new HttpDataSource$HttpDataSourceException((IOException) new InterruptedIOException(), dataSpec, 2000, 1);
                } else if (read != -1) {
                    j2 -= (long) read;
                    s(read);
                } else {
                    throw new HttpDataSource$HttpDataSourceException(dataSpec, 2008, 1);
                }
            }
        }
    }

    private void w() {
        HttpURLConnection httpURLConnection = this.f28420n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.f28420n = null;
        }
    }

    private URL x(URL url, String str, DataSpec dataSpec) throws HttpDataSource$HttpDataSourceException {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!UriUtil.HTTPS_SCHEME.equals(protocol) && !UriUtil.HTTP_SCHEME.equals(protocol)) {
                    throw new HttpDataSource$HttpDataSourceException("Unsupported protocol redirect: " + protocol, dataSpec, 2001, 1);
                } else if (this.f28411e || protocol.equals(url.getProtocol())) {
                    return url2;
                } else {
                    throw new HttpDataSource$HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", dataSpec, 2001, 1);
                }
            } catch (MalformedURLException e2) {
                throw new HttpDataSource$HttpDataSourceException((IOException) e2, dataSpec, 2001, 1);
            }
        } else {
            throw new HttpDataSource$HttpDataSourceException("Null location redirect", dataSpec, 2001, 1);
        }
    }

    private static boolean y(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    private HttpURLConnection z(DataSpec dataSpec) throws IOException {
        HttpURLConnection A;
        boolean z2;
        URL url;
        DataSpec dataSpec2 = dataSpec;
        URL url2 = new URL(dataSpec2.f28339a.toString());
        int i2 = dataSpec2.f28341c;
        byte[] bArr = dataSpec2.f28342d;
        long j2 = dataSpec2.f28345g;
        long j3 = dataSpec2.f28346h;
        boolean d2 = dataSpec2.d(1);
        if (!this.f28411e && !this.f28417k) {
            return A(url2, i2, bArr, j2, j3, d2, true, dataSpec2.f28343e);
        }
        URL url3 = url2;
        int i3 = i2;
        byte[] bArr2 = bArr;
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            if (i4 <= 20) {
                long j4 = j2;
                long j5 = j2;
                int i6 = i3;
                int i7 = i5;
                URL url4 = url3;
                long j6 = j3;
                A = A(url3, i3, bArr2, j4, j3, d2, false, dataSpec2.f28343e);
                int responseCode = A.getResponseCode();
                String headerField = A.getHeaderField("Location");
                if ((i6 == 1 || i6 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                    A.disconnect();
                    url3 = x(url4, headerField, dataSpec2);
                    i3 = i6;
                } else if (i6 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return A;
                } else {
                    A.disconnect();
                    if (!this.f28417k || responseCode != 302) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        bArr2 = null;
                        url = url4;
                        i3 = 1;
                    } else {
                        i3 = i6;
                        url = url4;
                    }
                    url3 = x(url, headerField, dataSpec2);
                }
                i4 = i7;
                j2 = j5;
                j3 = j6;
            } else {
                throw new HttpDataSource$HttpDataSourceException((IOException) new NoRouteToHostException("Too many redirects: " + i5), dataSpec2, 2001, 1);
            }
        }
        return A;
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection C(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public Uri b() {
        HttpURLConnection httpURLConnection = this.f28420n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public void close() throws HttpDataSource$HttpDataSourceException {
        try {
            InputStream inputStream = this.f28421o;
            if (inputStream != null) {
                long j2 = this.f28424r;
                long j3 = -1;
                if (j2 != -1) {
                    j3 = j2 - this.f28425s;
                }
                B(this.f28420n, j3);
                inputStream.close();
            }
            this.f28421o = null;
            w();
            if (this.f28422p) {
                this.f28422p = false;
                t();
            }
        } catch (IOException e2) {
            throw new HttpDataSource$HttpDataSourceException(e2, (DataSpec) Util.j(this.f28419m), 2000, 3);
        } catch (Throwable th) {
            this.f28421o = null;
            w();
            if (this.f28422p) {
                this.f28422p = false;
                t();
            }
            throw th;
        }
    }

    public Map<String, List<String>> d() {
        HttpURLConnection httpURLConnection = this.f28420n;
        if (httpURLConnection == null) {
            return ImmutableMap.k();
        }
        return new NullFilteringHeadersMap(httpURLConnection.getHeaderFields());
    }

    public long i(DataSpec dataSpec) throws HttpDataSource$HttpDataSourceException {
        byte[] bArr;
        DataSourceException dataSourceException;
        this.f28419m = dataSpec;
        long j2 = 0;
        this.f28425s = 0;
        this.f28424r = 0;
        u(dataSpec);
        try {
            HttpURLConnection z2 = z(dataSpec);
            this.f28420n = z2;
            this.f28423q = z2.getResponseCode();
            String responseMessage = z2.getResponseMessage();
            int i2 = this.f28423q;
            long j3 = -1;
            if (i2 < 200 || i2 > 299) {
                Map<String, List<String>> headerFields = z2.getHeaderFields();
                if (this.f28423q == 416) {
                    if (dataSpec.f28345g == HttpUtil.c(z2.getHeaderField("Content-Range"))) {
                        this.f28422p = true;
                        v(dataSpec);
                        long j4 = dataSpec.f28346h;
                        if (j4 != -1) {
                            return j4;
                        }
                        return 0;
                    }
                }
                InputStream errorStream = z2.getErrorStream();
                if (errorStream != null) {
                    try {
                        bArr = Util.c1(errorStream);
                    } catch (IOException unused) {
                        bArr = Util.f28813f;
                    }
                } else {
                    bArr = Util.f28813f;
                }
                byte[] bArr2 = bArr;
                w();
                if (this.f28423q == 416) {
                    dataSourceException = new DataSourceException(2008);
                } else {
                    dataSourceException = null;
                }
                throw new HttpDataSource$InvalidResponseCodeException(this.f28423q, responseMessage, dataSourceException, headerFields, dataSpec, bArr2);
            }
            String contentType = z2.getContentType();
            Predicate<String> predicate = this.f28418l;
            if (predicate == null || predicate.apply(contentType)) {
                if (this.f28423q == 200) {
                    long j5 = dataSpec.f28345g;
                    if (j5 != 0) {
                        j2 = j5;
                    }
                }
                boolean y2 = y(z2);
                if (!y2) {
                    long j6 = dataSpec.f28346h;
                    if (j6 != -1) {
                        this.f28424r = j6;
                    } else {
                        long b2 = HttpUtil.b(z2.getHeaderField("Content-Length"), z2.getHeaderField("Content-Range"));
                        if (b2 != -1) {
                            j3 = b2 - j2;
                        }
                        this.f28424r = j3;
                    }
                } else {
                    this.f28424r = dataSpec.f28346h;
                }
                try {
                    this.f28421o = z2.getInputStream();
                    if (y2) {
                        this.f28421o = new GZIPInputStream(this.f28421o);
                    }
                    this.f28422p = true;
                    v(dataSpec);
                    try {
                        E(j2, dataSpec);
                        return this.f28424r;
                    } catch (IOException e2) {
                        w();
                        if (e2 instanceof HttpDataSource$HttpDataSourceException) {
                            throw ((HttpDataSource$HttpDataSourceException) e2);
                        }
                        throw new HttpDataSource$HttpDataSourceException(e2, dataSpec, 2000, 1);
                    }
                } catch (IOException e3) {
                    w();
                    throw new HttpDataSource$HttpDataSourceException(e3, dataSpec, 2000, 1);
                }
            } else {
                w();
                throw new HttpDataSource$InvalidContentTypeException(contentType, dataSpec);
            }
        } catch (IOException e4) {
            w();
            throw HttpDataSource$HttpDataSourceException.c(e4, dataSpec, 1);
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws HttpDataSource$HttpDataSourceException {
        try {
            return D(bArr, i2, i3);
        } catch (IOException e2) {
            throw HttpDataSource$HttpDataSourceException.c(e2, (DataSpec) Util.j(this.f28419m), 2);
        }
    }

    @Deprecated
    public DefaultHttpDataSource() {
        this((String) null, 8000, 8000);
    }

    @Deprecated
    public DefaultHttpDataSource(String str, int i2, int i3) {
        this(str, i2, i3, false, (HttpDataSource$RequestProperties) null);
    }

    @Deprecated
    public DefaultHttpDataSource(String str, int i2, int i3, boolean z2, HttpDataSource$RequestProperties httpDataSource$RequestProperties) {
        this(str, i2, i3, z2, httpDataSource$RequestProperties, (Predicate<String>) null, false);
    }

    private DefaultHttpDataSource(String str, int i2, int i3, boolean z2, HttpDataSource$RequestProperties httpDataSource$RequestProperties, Predicate<String> predicate, boolean z3) {
        super(true);
        this.f28414h = str;
        this.f28412f = i2;
        this.f28413g = i3;
        this.f28411e = z2;
        this.f28415i = httpDataSource$RequestProperties;
        this.f28418l = predicate;
        this.f28416j = new HttpDataSource$RequestProperties();
        this.f28417k = z3;
    }
}
