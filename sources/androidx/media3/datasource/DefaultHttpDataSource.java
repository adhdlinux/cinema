package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.facebook.common.util.UriUtil;
import com.google.common.base.Predicate;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.io.ByteStreams;
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
    private final boolean f4858e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f4859f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4860g;

    /* renamed from: h  reason: collision with root package name */
    private final int f4861h;

    /* renamed from: i  reason: collision with root package name */
    private final String f4862i;

    /* renamed from: j  reason: collision with root package name */
    private final HttpDataSource$RequestProperties f4863j;

    /* renamed from: k  reason: collision with root package name */
    private final HttpDataSource$RequestProperties f4864k;

    /* renamed from: l  reason: collision with root package name */
    private final Predicate<String> f4865l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f4866m;

    /* renamed from: n  reason: collision with root package name */
    private DataSpec f4867n;

    /* renamed from: o  reason: collision with root package name */
    private HttpURLConnection f4868o;

    /* renamed from: p  reason: collision with root package name */
    private InputStream f4869p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f4870q;

    /* renamed from: r  reason: collision with root package name */
    private int f4871r;

    /* renamed from: s  reason: collision with root package name */
    private long f4872s;

    /* renamed from: t  reason: collision with root package name */
    private long f4873t;

    public static final class Factory implements HttpDataSource$Factory {

        /* renamed from: a  reason: collision with root package name */
        private final HttpDataSource$RequestProperties f4874a = new HttpDataSource$RequestProperties();

        /* renamed from: b  reason: collision with root package name */
        private TransferListener f4875b;

        /* renamed from: c  reason: collision with root package name */
        private Predicate<String> f4876c;

        /* renamed from: d  reason: collision with root package name */
        private String f4877d;

        /* renamed from: e  reason: collision with root package name */
        private int f4878e = 8000;

        /* renamed from: f  reason: collision with root package name */
        private int f4879f = 8000;

        /* renamed from: g  reason: collision with root package name */
        private boolean f4880g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f4881h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f4882i;

        /* renamed from: c */
        public DefaultHttpDataSource a() {
            DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.f4877d, this.f4878e, this.f4879f, this.f4880g, this.f4881h, this.f4874a, this.f4876c, this.f4882i);
            TransferListener transferListener = this.f4875b;
            if (transferListener != null) {
                defaultHttpDataSource.n(transferListener);
            }
            return defaultHttpDataSource;
        }

        /* renamed from: d */
        public Factory b(Map<String, String> map) {
            this.f4874a.a(map);
            return this;
        }

        public Factory e(String str) {
            this.f4877d = str;
            return this;
        }
    }

    private static class NullFilteringHeadersMap extends ForwardingMap<String, List<String>> {

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, List<String>> f4883b;

        public NullFilteringHeadersMap(Map<String, List<String>> map) {
            this.f4883b = map;
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
            return this.f4883b;
        }

        public boolean containsKey(Object obj) {
            return obj != null && super.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return super.d(obj);
        }

        public Set<Map.Entry<String, List<String>>> entrySet() {
            return Sets.b(super.entrySet(), new a());
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

    private void A(long j2, DataSpec dataSpec) throws IOException {
        if (j2 != 0) {
            byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            while (j2 > 0) {
                int read = ((InputStream) Util.i(this.f4869p)).read(bArr, 0, (int) Math.min(j2, (long) CodedOutputStream.DEFAULT_BUFFER_SIZE));
                if (Thread.currentThread().isInterrupted()) {
                    throw new HttpDataSource$HttpDataSourceException((IOException) new InterruptedIOException(), dataSpec, 2000, 1);
                } else if (read != -1) {
                    j2 -= (long) read;
                    o(read);
                } else {
                    throw new HttpDataSource$HttpDataSourceException(dataSpec, 2008, 1);
                }
            }
        }
    }

    private void s() {
        HttpURLConnection httpURLConnection = this.f4868o;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.f4868o = null;
        }
    }

    private URL t(URL url, String str, DataSpec dataSpec) throws HttpDataSource$HttpDataSourceException {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!UriUtil.HTTPS_SCHEME.equals(protocol) && !UriUtil.HTTP_SCHEME.equals(protocol)) {
                    throw new HttpDataSource$HttpDataSourceException("Unsupported protocol redirect: " + protocol, dataSpec, 2001, 1);
                } else if (this.f4858e || protocol.equals(url.getProtocol())) {
                    return url2;
                } else {
                    if (this.f4859f) {
                        try {
                            return new URL(url2.toString().replaceFirst(protocol, url.getProtocol()));
                        } catch (MalformedURLException e2) {
                            throw new HttpDataSource$HttpDataSourceException((IOException) e2, dataSpec, 2001, 1);
                        }
                    } else {
                        throw new HttpDataSource$HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", dataSpec, 2001, 1);
                    }
                }
            } catch (MalformedURLException e3) {
                throw new HttpDataSource$HttpDataSourceException((IOException) e3, dataSpec, 2001, 1);
            }
        } else {
            throw new HttpDataSource$HttpDataSourceException("Null location redirect", dataSpec, 2001, 1);
        }
    }

    private static boolean u(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    private HttpURLConnection v(DataSpec dataSpec) throws IOException {
        HttpURLConnection w2;
        boolean z2;
        URL url;
        DataSpec dataSpec2 = dataSpec;
        URL url2 = new URL(dataSpec2.f4823a.toString());
        int i2 = dataSpec2.f4825c;
        byte[] bArr = dataSpec2.f4826d;
        long j2 = dataSpec2.f4829g;
        long j3 = dataSpec2.f4830h;
        boolean d2 = dataSpec2.d(1);
        if (!this.f4858e && !this.f4859f && !this.f4866m) {
            return w(url2, i2, bArr, j2, j3, d2, true, dataSpec2.f4827e);
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
                w2 = w(url3, i3, bArr2, j4, j3, d2, false, dataSpec2.f4827e);
                int responseCode = w2.getResponseCode();
                String headerField = w2.getHeaderField("Location");
                if ((i6 == 1 || i6 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                    w2.disconnect();
                    url3 = t(url4, headerField, dataSpec2);
                    i3 = i6;
                } else if (i6 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return w2;
                } else {
                    w2.disconnect();
                    if (!this.f4866m || responseCode != 302) {
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
                    url3 = t(url, headerField, dataSpec2);
                }
                i4 = i7;
                j2 = j5;
                j3 = j6;
            } else {
                throw new HttpDataSource$HttpDataSourceException((IOException) new NoRouteToHostException("Too many redirects: " + i5), dataSpec2, 2001, 1);
            }
        }
        return w2;
    }

    private HttpURLConnection w(URL url, int i2, byte[] bArr, long j2, long j3, boolean z2, boolean z3, Map<String, String> map) throws IOException {
        String str;
        boolean z4;
        HttpURLConnection y2 = y(url);
        y2.setConnectTimeout(this.f4860g);
        y2.setReadTimeout(this.f4861h);
        HashMap hashMap = new HashMap();
        HttpDataSource$RequestProperties httpDataSource$RequestProperties = this.f4863j;
        if (httpDataSource$RequestProperties != null) {
            hashMap.putAll(httpDataSource$RequestProperties.b());
        }
        hashMap.putAll(this.f4864k.b());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            y2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String a2 = HttpUtil.a(j2, j3);
        if (a2 != null) {
            y2.setRequestProperty("Range", a2);
        }
        String str2 = this.f4862i;
        if (str2 != null) {
            y2.setRequestProperty("User-Agent", str2);
        }
        if (z2) {
            str = "gzip";
        } else {
            str = InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY;
        }
        y2.setRequestProperty("Accept-Encoding", str);
        y2.setInstanceFollowRedirects(z3);
        if (bArr != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        y2.setDoOutput(z4);
        y2.setRequestMethod(DataSpec.c(i2));
        if (bArr != null) {
            y2.setFixedLengthStreamingMode(bArr.length);
            y2.connect();
            OutputStream outputStream = y2.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            y2.connect();
        }
        return y2;
    }

    private static void x(HttpURLConnection httpURLConnection, long j2) {
        if (httpURLConnection != null && Util.f4714a <= 20) {
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
                    Method declaredMethod = ((Class) Assertions.f(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    private int z(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f4872s;
        if (j2 != -1) {
            long j3 = j2 - this.f4873t;
            if (j3 == 0) {
                return -1;
            }
            i3 = (int) Math.min((long) i3, j3);
        }
        int read = ((InputStream) Util.i(this.f4869p)).read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        this.f4873t += (long) read;
        o(read);
        return read;
    }

    public Uri b() {
        HttpURLConnection httpURLConnection = this.f4868o;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public void close() throws HttpDataSource$HttpDataSourceException {
        try {
            InputStream inputStream = this.f4869p;
            if (inputStream != null) {
                long j2 = this.f4872s;
                long j3 = -1;
                if (j2 != -1) {
                    j3 = j2 - this.f4873t;
                }
                x(this.f4868o, j3);
                inputStream.close();
            }
            this.f4869p = null;
            s();
            if (this.f4870q) {
                this.f4870q = false;
                p();
            }
        } catch (IOException e2) {
            throw new HttpDataSource$HttpDataSourceException(e2, (DataSpec) Util.i(this.f4867n), 2000, 3);
        } catch (Throwable th) {
            this.f4869p = null;
            s();
            if (this.f4870q) {
                this.f4870q = false;
                p();
            }
            throw th;
        }
    }

    public Map<String, List<String>> d() {
        HttpURLConnection httpURLConnection = this.f4868o;
        if (httpURLConnection == null) {
            return ImmutableMap.k();
        }
        return new NullFilteringHeadersMap(httpURLConnection.getHeaderFields());
    }

    public long i(DataSpec dataSpec) throws HttpDataSource$HttpDataSourceException {
        byte[] bArr;
        DataSourceException dataSourceException;
        this.f4867n = dataSpec;
        long j2 = 0;
        this.f4873t = 0;
        this.f4872s = 0;
        q(dataSpec);
        try {
            HttpURLConnection v2 = v(dataSpec);
            this.f4868o = v2;
            this.f4871r = v2.getResponseCode();
            String responseMessage = v2.getResponseMessage();
            int i2 = this.f4871r;
            long j3 = -1;
            if (i2 < 200 || i2 > 299) {
                Map<String, List<String>> headerFields = v2.getHeaderFields();
                if (this.f4871r == 416) {
                    if (dataSpec.f4829g == HttpUtil.c(v2.getHeaderField("Content-Range"))) {
                        this.f4870q = true;
                        r(dataSpec);
                        long j4 = dataSpec.f4830h;
                        if (j4 != -1) {
                            return j4;
                        }
                        return 0;
                    }
                }
                InputStream errorStream = v2.getErrorStream();
                if (errorStream != null) {
                    try {
                        bArr = ByteStreams.d(errorStream);
                    } catch (IOException unused) {
                        bArr = Util.f4719f;
                    }
                } else {
                    bArr = Util.f4719f;
                }
                byte[] bArr2 = bArr;
                s();
                if (this.f4871r == 416) {
                    dataSourceException = new DataSourceException(2008);
                } else {
                    dataSourceException = null;
                }
                throw new HttpDataSource$InvalidResponseCodeException(this.f4871r, responseMessage, dataSourceException, headerFields, dataSpec, bArr2);
            }
            String contentType = v2.getContentType();
            Predicate<String> predicate = this.f4865l;
            if (predicate == null || predicate.apply(contentType)) {
                if (this.f4871r == 200) {
                    long j5 = dataSpec.f4829g;
                    if (j5 != 0) {
                        j2 = j5;
                    }
                }
                boolean u2 = u(v2);
                if (!u2) {
                    long j6 = dataSpec.f4830h;
                    if (j6 != -1) {
                        this.f4872s = j6;
                    } else {
                        long b2 = HttpUtil.b(v2.getHeaderField("Content-Length"), v2.getHeaderField("Content-Range"));
                        if (b2 != -1) {
                            j3 = b2 - j2;
                        }
                        this.f4872s = j3;
                    }
                } else {
                    this.f4872s = dataSpec.f4830h;
                }
                try {
                    this.f4869p = v2.getInputStream();
                    if (u2) {
                        this.f4869p = new GZIPInputStream(this.f4869p);
                    }
                    this.f4870q = true;
                    r(dataSpec);
                    try {
                        A(j2, dataSpec);
                        return this.f4872s;
                    } catch (IOException e2) {
                        s();
                        if (e2 instanceof HttpDataSource$HttpDataSourceException) {
                            throw ((HttpDataSource$HttpDataSourceException) e2);
                        }
                        throw new HttpDataSource$HttpDataSourceException(e2, dataSpec, 2000, 1);
                    }
                } catch (IOException e3) {
                    s();
                    throw new HttpDataSource$HttpDataSourceException(e3, dataSpec, 2000, 1);
                }
            } else {
                s();
                throw new HttpDataSource$InvalidContentTypeException(contentType, dataSpec);
            }
        } catch (IOException e4) {
            s();
            throw HttpDataSource$HttpDataSourceException.c(e4, dataSpec, 1);
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws HttpDataSource$HttpDataSourceException {
        try {
            return z(bArr, i2, i3);
        } catch (IOException e2) {
            throw HttpDataSource$HttpDataSourceException.c(e2, (DataSpec) Util.i(this.f4867n), 2);
        }
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection y(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private DefaultHttpDataSource(String str, int i2, int i3, boolean z2, boolean z3, HttpDataSource$RequestProperties httpDataSource$RequestProperties, Predicate<String> predicate, boolean z4) {
        super(true);
        this.f4862i = str;
        this.f4860g = i2;
        this.f4861h = i3;
        this.f4858e = z2;
        this.f4859f = z3;
        if (!z2 || !z3) {
            this.f4863j = httpDataSource$RequestProperties;
            this.f4865l = predicate;
            this.f4864k = new HttpDataSource$RequestProperties();
            this.f4866m = z4;
            return;
        }
        throw new IllegalArgumentException("crossProtocolRedirectsForceOriginal should not be set if allowCrossProtocolRedirects is true");
    }
}
