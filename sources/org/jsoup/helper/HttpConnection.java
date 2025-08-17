package org.jsoup.helper;

import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import org.jsoup.Connection;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.parser.TokenQueue;

public class HttpConnection implements Connection {

    /* renamed from: a  reason: collision with root package name */
    private Connection.Request f41504a = new Request();

    /* renamed from: b  reason: collision with root package name */
    private Connection.Response f41505b = new Response();

    private static abstract class Base<T extends Connection.Base> implements Connection.Base<T> {

        /* renamed from: a  reason: collision with root package name */
        URL f41506a;

        /* renamed from: b  reason: collision with root package name */
        Connection.Method f41507b;

        /* renamed from: c  reason: collision with root package name */
        Map<String, List<String>> f41508c;

        /* renamed from: d  reason: collision with root package name */
        Map<String, String> f41509d;

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
            if ((r0 & r4) != false) goto L_0x002a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean D(byte[] r8) {
            /*
                int r0 = r8.length
                r1 = 1
                r2 = 0
                r3 = 3
                if (r0 < r3) goto L_0x0029
                byte r0 = r8[r2]
                r0 = r0 & 255(0xff, float:3.57E-43)
                r4 = 239(0xef, float:3.35E-43)
                if (r0 != r4) goto L_0x0029
                byte r0 = r8[r1]
                r0 = r0 & 255(0xff, float:3.57E-43)
                r4 = 187(0xbb, float:2.62E-43)
                if (r0 != r4) goto L_0x0018
                r0 = 1
                goto L_0x0019
            L_0x0018:
                r0 = 0
            L_0x0019:
                r4 = 2
                byte r4 = r8[r4]
                r4 = r4 & 255(0xff, float:3.57E-43)
                r5 = 191(0xbf, float:2.68E-43)
                if (r4 != r5) goto L_0x0024
                r4 = 1
                goto L_0x0025
            L_0x0024:
                r4 = 0
            L_0x0025:
                r0 = r0 & r4
                if (r0 == 0) goto L_0x0029
                goto L_0x002a
            L_0x0029:
                r3 = 0
            L_0x002a:
                int r0 = r8.length
            L_0x002b:
                if (r3 >= r0) goto L_0x005d
                byte r4 = r8[r3]
                r5 = r4 & 128(0x80, float:1.794E-43)
                if (r5 != 0) goto L_0x0034
                goto L_0x005a
            L_0x0034:
                r5 = r4 & 224(0xe0, float:3.14E-43)
                r6 = 192(0xc0, float:2.69E-43)
                if (r5 != r6) goto L_0x003d
                int r4 = r3 + 1
                goto L_0x004e
            L_0x003d:
                r5 = r4 & 240(0xf0, float:3.36E-43)
                r7 = 224(0xe0, float:3.14E-43)
                if (r5 != r7) goto L_0x0046
                int r4 = r3 + 2
                goto L_0x004e
            L_0x0046:
                r4 = r4 & 248(0xf8, float:3.48E-43)
                r5 = 240(0xf0, float:3.36E-43)
                if (r4 != r5) goto L_0x005c
                int r4 = r3 + 3
            L_0x004e:
                if (r3 >= r4) goto L_0x005a
                int r3 = r3 + 1
                byte r5 = r8[r3]
                r5 = r5 & r6
                r7 = 128(0x80, float:1.794E-43)
                if (r5 == r7) goto L_0x004e
                return r2
            L_0x005a:
                int r3 = r3 + r1
                goto L_0x002b
            L_0x005c:
                return r2
            L_0x005d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Base.D(byte[]):boolean");
        }

        private Map.Entry<String, List<String>> E(String str) {
            String a2 = Normalizer.a(str);
            for (Map.Entry<String, List<String>> next : this.f41508c.entrySet()) {
                if (Normalizer.a(next.getKey()).equals(a2)) {
                    return next;
                }
            }
            return null;
        }

        private static String x(String str) {
            try {
                byte[] bytes = str.getBytes("ISO-8859-1");
                if (!D(bytes)) {
                    return str;
                }
                return new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }

        private List<String> y(String str) {
            Validate.j(str);
            for (Map.Entry next : this.f41508c.entrySet()) {
                if (str.equalsIgnoreCase((String) next.getKey())) {
                    return (List) next.getValue();
                }
            }
            return Collections.emptyList();
        }

        public boolean A(String str, String str2) {
            Validate.h(str);
            Validate.h(str2);
            for (String equalsIgnoreCase : C(str)) {
                if (str2.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
            return false;
        }

        public String B(String str) {
            Validate.k(str, "Header name must not be null");
            List<String> y2 = y(str);
            if (y2.size() > 0) {
                return StringUtil.h(y2, ", ");
            }
            return null;
        }

        public List<String> C(String str) {
            Validate.h(str);
            return y(str);
        }

        public T b(String str, String str2) {
            Validate.i(str, "Header name must not be empty");
            n(str);
            w(str, str2);
            return this;
        }

        public URL h() {
            return this.f41506a;
        }

        public T i(String str, String str2) {
            Validate.i(str, "Cookie name must not be empty");
            Validate.k(str2, "Cookie value must not be null");
            this.f41509d.put(str, str2);
            return this;
        }

        public Map<String, String> l() {
            return this.f41509d;
        }

        public Connection.Method method() {
            return this.f41507b;
        }

        public T n(String str) {
            Validate.i(str, "Header name must not be empty");
            Map.Entry<String, List<String>> E = E(str);
            if (E != null) {
                this.f41508c.remove(E.getKey());
            }
            return this;
        }

        public T p(URL url) {
            Validate.k(url, "URL must not be null");
            this.f41506a = url;
            return this;
        }

        public T q(Connection.Method method) {
            Validate.k(method, "Method must not be null");
            this.f41507b = method;
            return this;
        }

        public boolean r(String str) {
            Validate.i(str, "Header name must not be empty");
            if (y(str).size() != 0) {
                return true;
            }
            return false;
        }

        public Map<String, List<String>> t() {
            return this.f41508c;
        }

        public T w(String str, String str2) {
            Validate.h(str);
            if (str2 == null) {
                str2 = "";
            }
            List C = C(str);
            if (C.isEmpty()) {
                C = new ArrayList();
                this.f41508c.put(str, C);
            }
            C.add(x(str2));
            return this;
        }

        public boolean z(String str) {
            Validate.i(str, "Cookie name must not be empty");
            return this.f41509d.containsKey(str);
        }

        private Base() {
            this.f41508c = new LinkedHashMap();
            this.f41509d = new LinkedHashMap();
        }
    }

    public static class Request extends Base<Connection.Request> implements Connection.Request {

        /* renamed from: e  reason: collision with root package name */
        private Proxy f41510e;

        /* renamed from: f  reason: collision with root package name */
        private int f41511f = HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT;

        /* renamed from: g  reason: collision with root package name */
        private int f41512g = 1048576;

        /* renamed from: h  reason: collision with root package name */
        private boolean f41513h = true;

        /* renamed from: i  reason: collision with root package name */
        private Collection<Connection.KeyVal> f41514i = new ArrayList();

        /* renamed from: j  reason: collision with root package name */
        private String f41515j = null;

        /* renamed from: k  reason: collision with root package name */
        private boolean f41516k = false;

        /* renamed from: l  reason: collision with root package name */
        private boolean f41517l = false;

        /* renamed from: m  reason: collision with root package name */
        private Parser f41518m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public boolean f41519n = false;

        /* renamed from: o  reason: collision with root package name */
        private boolean f41520o = true;

        /* renamed from: p  reason: collision with root package name */
        private String f41521p = "UTF-8";

        Request() {
            super();
            this.f41507b = Connection.Method.GET;
            w("Accept-Encoding", "gzip");
            w("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
            this.f41518m = Parser.a();
        }

        public /* bridge */ /* synthetic */ List C(String str) {
            return super.C(str);
        }

        /* renamed from: G */
        public Request o(Parser parser) {
            this.f41518m = parser;
            this.f41519n = true;
            return this;
        }

        /* renamed from: H */
        public Request a(int i2) {
            boolean z2;
            if (i2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Validate.e(z2, "Timeout milliseconds must be 0 (infinite) or greater");
            this.f41511f = i2;
            return this;
        }

        public Connection.Request c(boolean z2) {
            this.f41517l = z2;
            return this;
        }

        public boolean d() {
            return this.f41516k;
        }

        public String e() {
            return this.f41521p;
        }

        public Connection.Request f(String str) {
            this.f41515j = str;
            return this;
        }

        public boolean g() {
            return this.f41520o;
        }

        public /* bridge */ /* synthetic */ URL h() {
            return super.h();
        }

        public Proxy j() {
            return this.f41510e;
        }

        public Collection<Connection.KeyVal> k() {
            return this.f41514i;
        }

        public /* bridge */ /* synthetic */ Map l() {
            return super.l();
        }

        public boolean m() {
            return this.f41513h;
        }

        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        public Parser parser() {
            return this.f41518m;
        }

        public /* bridge */ /* synthetic */ boolean r(String str) {
            return super.r(str);
        }

        public boolean s() {
            return this.f41517l;
        }

        public /* bridge */ /* synthetic */ Map t() {
            return super.t();
        }

        public int timeout() {
            return this.f41511f;
        }

        public String u() {
            return this.f41515j;
        }

        public int v() {
            return this.f41512g;
        }
    }

    private HttpConnection() {
    }

    public static Connection g(String str) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.d(str);
        return httpConnection;
    }

    /* access modifiers changed from: private */
    public static String h(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\"", "%22");
    }

    private static String i(String str) {
        try {
            return j(new URL(str)).toExternalForm();
        } catch (Exception unused) {
            return str;
        }
    }

    static URL j(URL url) {
        try {
            return new URL(new URI(url.toExternalForm().replaceAll(" ", "%20")).toASCIIString());
        } catch (Exception unused) {
            return url;
        }
    }

    /* access modifiers changed from: private */
    public static boolean l(Connection.Request request) {
        for (Connection.KeyVal b2 : request.k()) {
            if (b2.b()) {
                return true;
            }
        }
        return false;
    }

    public Connection a(int i2) {
        this.f41504a.a(i2);
        return this;
    }

    public Connection b(String str, String str2) {
        this.f41504a.b(str, str2);
        return this;
    }

    public Connection c(boolean z2) {
        this.f41504a.c(z2);
        return this;
    }

    public Connection d(String str) {
        Validate.i(str, "Must supply a valid URL");
        try {
            this.f41504a.p(new URL(i(str)));
            return this;
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Malformed URL: " + str, e2);
        }
    }

    public Document get() throws IOException {
        this.f41504a.q(Connection.Method.GET);
        k();
        return this.f41505b.parse();
    }

    public Connection.Response k() throws IOException {
        Response I = Response.I(this.f41504a);
        this.f41505b = I;
        return I;
    }

    public static class Response extends Base<Connection.Response> implements Connection.Response {

        /* renamed from: o  reason: collision with root package name */
        private static SSLSocketFactory f41522o;

        /* renamed from: p  reason: collision with root package name */
        private static final Pattern f41523p = Pattern.compile("(application|text)/\\w*\\+?xml.*");

        /* renamed from: e  reason: collision with root package name */
        private int f41524e;

        /* renamed from: f  reason: collision with root package name */
        private String f41525f;

        /* renamed from: g  reason: collision with root package name */
        private ByteBuffer f41526g;

        /* renamed from: h  reason: collision with root package name */
        private InputStream f41527h;

        /* renamed from: i  reason: collision with root package name */
        private String f41528i;

        /* renamed from: j  reason: collision with root package name */
        private String f41529j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f41530k = false;

        /* renamed from: l  reason: collision with root package name */
        private boolean f41531l = false;

        /* renamed from: m  reason: collision with root package name */
        private int f41532m = 0;

        /* renamed from: n  reason: collision with root package name */
        private Connection.Request f41533n;

        Response() {
            super();
        }

        private static HttpURLConnection G(Connection.Request request) throws IOException {
            URLConnection uRLConnection;
            if (request.j() == null) {
                uRLConnection = request.h().openConnection();
            } else {
                uRLConnection = request.h().openConnection(request.j());
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            httpURLConnection.setRequestMethod(request.method().name());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(request.timeout());
            httpURLConnection.setReadTimeout(request.timeout() / 2);
            if ((httpURLConnection instanceof HttpsURLConnection) && !request.g()) {
                M();
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                httpsURLConnection.setSSLSocketFactory(f41522o);
                httpsURLConnection.setHostnameVerifier(K());
            }
            if (request.method().a()) {
                httpURLConnection.setDoOutput(true);
            }
            if (request.l().size() > 0) {
                httpURLConnection.addRequestProperty("Cookie", L(request));
            }
            for (Map.Entry next : request.t().entrySet()) {
                for (String addRequestProperty : (List) next.getValue()) {
                    httpURLConnection.addRequestProperty((String) next.getKey(), addRequestProperty);
                }
            }
            return httpURLConnection;
        }

        private static LinkedHashMap<String, List<String>> H(HttpURLConnection httpURLConnection) {
            LinkedHashMap<String, List<String>> linkedHashMap = new LinkedHashMap<>();
            int i2 = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i2);
                String headerField = httpURLConnection.getHeaderField(i2);
                if (headerFieldKey == null && headerField == null) {
                    return linkedHashMap;
                }
                i2++;
                if (!(headerFieldKey == null || headerField == null)) {
                    if (linkedHashMap.containsKey(headerFieldKey)) {
                        linkedHashMap.get(headerFieldKey).add(headerField);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(headerField);
                        linkedHashMap.put(headerFieldKey, arrayList);
                    }
                }
            }
        }

        static Response I(Connection.Request request) throws IOException {
            return J(request, (Response) null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0080 A[Catch:{ IOException -> 0x01dd }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00a1 A[Catch:{ IOException -> 0x01dd }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x010e A[Catch:{ IOException -> 0x01dd }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static org.jsoup.helper.HttpConnection.Response J(org.jsoup.Connection.Request r8, org.jsoup.helper.HttpConnection.Response r9) throws java.io.IOException {
            /*
                java.lang.String r0 = "Location"
                java.lang.String r1 = "Request must not be null"
                org.jsoup.helper.Validate.k(r8, r1)
                java.net.URL r1 = r8.h()
                java.lang.String r1 = r1.getProtocol()
                java.lang.String r2 = "http"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x0028
                java.lang.String r2 = "https"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0020
                goto L_0x0028
            L_0x0020:
                java.net.MalformedURLException r8 = new java.net.MalformedURLException
                java.lang.String r9 = "Only http & https protocols supported"
                r8.<init>(r9)
                throw r8
            L_0x0028:
                org.jsoup.Connection$Method r1 = r8.method()
                boolean r1 = r1.a()
                java.lang.String r2 = r8.u()
                r3 = 1
                if (r2 == 0) goto L_0x0039
                r2 = 1
                goto L_0x003a
            L_0x0039:
                r2 = 0
            L_0x003a:
                if (r1 != 0) goto L_0x0054
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Cannot set a request body for HTTP method "
                r4.append(r5)
                org.jsoup.Connection$Method r5 = r8.method()
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                org.jsoup.helper.Validate.c(r2, r4)
            L_0x0054:
                java.util.Collection r4 = r8.k()
                int r4 = r4.size()
                r5 = 0
                if (r4 <= 0) goto L_0x0067
                if (r1 == 0) goto L_0x0063
                if (r2 == 0) goto L_0x0067
            L_0x0063:
                P(r8)
                goto L_0x006e
            L_0x0067:
                if (r1 == 0) goto L_0x006e
                java.lang.String r1 = Q(r8)
                goto L_0x006f
            L_0x006e:
                r1 = r5
            L_0x006f:
                long r6 = java.lang.System.nanoTime()
                java.net.HttpURLConnection r2 = G(r8)
                r2.connect()     // Catch:{ IOException -> 0x01dd }
                boolean r4 = r2.getDoOutput()     // Catch:{ IOException -> 0x01dd }
                if (r4 == 0) goto L_0x0087
                java.io.OutputStream r4 = r2.getOutputStream()     // Catch:{ IOException -> 0x01dd }
                S(r8, r4, r1)     // Catch:{ IOException -> 0x01dd }
            L_0x0087:
                int r1 = r2.getResponseCode()     // Catch:{ IOException -> 0x01dd }
                org.jsoup.helper.HttpConnection$Response r4 = new org.jsoup.helper.HttpConnection$Response     // Catch:{ IOException -> 0x01dd }
                r4.<init>(r9)     // Catch:{ IOException -> 0x01dd }
                r4.R(r2, r9)     // Catch:{ IOException -> 0x01dd }
                r4.f41533n = r8     // Catch:{ IOException -> 0x01dd }
                boolean r9 = r4.r(r0)     // Catch:{ IOException -> 0x01dd }
                if (r9 == 0) goto L_0x010e
                boolean r9 = r8.m()     // Catch:{ IOException -> 0x01dd }
                if (r9 == 0) goto L_0x010e
                r9 = 307(0x133, float:4.3E-43)
                if (r1 == r9) goto L_0x00b9
                org.jsoup.Connection$Method r9 = org.jsoup.Connection.Method.GET     // Catch:{ IOException -> 0x01dd }
                r8.q(r9)     // Catch:{ IOException -> 0x01dd }
                java.util.Collection r9 = r8.k()     // Catch:{ IOException -> 0x01dd }
                r9.clear()     // Catch:{ IOException -> 0x01dd }
                r8.f(r5)     // Catch:{ IOException -> 0x01dd }
                java.lang.String r9 = "Content-Type"
                r8.n(r9)     // Catch:{ IOException -> 0x01dd }
            L_0x00b9:
                java.lang.String r9 = r4.B(r0)     // Catch:{ IOException -> 0x01dd }
                if (r9 == 0) goto L_0x00d4
                java.lang.String r0 = "http:/"
                boolean r0 = r9.startsWith(r0)     // Catch:{ IOException -> 0x01dd }
                if (r0 == 0) goto L_0x00d4
                r0 = 6
                char r1 = r9.charAt(r0)     // Catch:{ IOException -> 0x01dd }
                r3 = 47
                if (r1 == r3) goto L_0x00d4
                java.lang.String r9 = r9.substring(r0)     // Catch:{ IOException -> 0x01dd }
            L_0x00d4:
                java.net.URL r0 = r8.h()     // Catch:{ IOException -> 0x01dd }
                java.net.URL r9 = org.jsoup.helper.StringUtil.l(r0, r9)     // Catch:{ IOException -> 0x01dd }
                java.net.URL r9 = org.jsoup.helper.HttpConnection.j(r9)     // Catch:{ IOException -> 0x01dd }
                r8.p(r9)     // Catch:{ IOException -> 0x01dd }
                java.util.Map<java.lang.String, java.lang.String> r9 = r4.f41509d     // Catch:{ IOException -> 0x01dd }
                java.util.Set r9 = r9.entrySet()     // Catch:{ IOException -> 0x01dd }
                java.util.Iterator r9 = r9.iterator()     // Catch:{ IOException -> 0x01dd }
            L_0x00ed:
                boolean r0 = r9.hasNext()     // Catch:{ IOException -> 0x01dd }
                if (r0 == 0) goto L_0x0109
                java.lang.Object r0 = r9.next()     // Catch:{ IOException -> 0x01dd }
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ IOException -> 0x01dd }
                java.lang.Object r1 = r0.getKey()     // Catch:{ IOException -> 0x01dd }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x01dd }
                java.lang.Object r0 = r0.getValue()     // Catch:{ IOException -> 0x01dd }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x01dd }
                r8.i(r1, r0)     // Catch:{ IOException -> 0x01dd }
                goto L_0x00ed
            L_0x0109:
                org.jsoup.helper.HttpConnection$Response r8 = J(r8, r4)     // Catch:{ IOException -> 0x01dd }
                return r8
            L_0x010e:
                r9 = 200(0xc8, float:2.8E-43)
                if (r1 < r9) goto L_0x0116
                r9 = 400(0x190, float:5.6E-43)
                if (r1 < r9) goto L_0x011c
            L_0x0116:
                boolean r9 = r8.d()     // Catch:{ IOException -> 0x01dd }
                if (r9 == 0) goto L_0x01cd
            L_0x011c:
                java.lang.String r9 = r4.F()     // Catch:{ IOException -> 0x01dd }
                if (r9 == 0) goto L_0x014d
                boolean r0 = r8.s()     // Catch:{ IOException -> 0x01dd }
                if (r0 != 0) goto L_0x014d
                java.lang.String r0 = "text/"
                boolean r0 = r9.startsWith(r0)     // Catch:{ IOException -> 0x01dd }
                if (r0 != 0) goto L_0x014d
                java.util.regex.Pattern r0 = f41523p     // Catch:{ IOException -> 0x01dd }
                java.util.regex.Matcher r0 = r0.matcher(r9)     // Catch:{ IOException -> 0x01dd }
                boolean r0 = r0.matches()     // Catch:{ IOException -> 0x01dd }
                if (r0 == 0) goto L_0x013d
                goto L_0x014d
            L_0x013d:
                org.jsoup.UnsupportedMimeTypeException r0 = new org.jsoup.UnsupportedMimeTypeException     // Catch:{ IOException -> 0x01dd }
                java.lang.String r1 = "Unhandled content type. Must be text/*, application/xml, or application/xhtml+xml"
                java.net.URL r8 = r8.h()     // Catch:{ IOException -> 0x01dd }
                java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x01dd }
                r0.<init>(r1, r9, r8)     // Catch:{ IOException -> 0x01dd }
                throw r0     // Catch:{ IOException -> 0x01dd }
            L_0x014d:
                if (r9 == 0) goto L_0x016f
                java.util.regex.Pattern r0 = f41523p     // Catch:{ IOException -> 0x01dd }
                java.util.regex.Matcher r9 = r0.matcher(r9)     // Catch:{ IOException -> 0x01dd }
                boolean r9 = r9.matches()     // Catch:{ IOException -> 0x01dd }
                if (r9 == 0) goto L_0x016f
                boolean r9 = r8 instanceof org.jsoup.helper.HttpConnection.Request     // Catch:{ IOException -> 0x01dd }
                if (r9 == 0) goto L_0x016f
                r9 = r8
                org.jsoup.helper.HttpConnection$Request r9 = (org.jsoup.helper.HttpConnection.Request) r9     // Catch:{ IOException -> 0x01dd }
                boolean r9 = r9.f41519n     // Catch:{ IOException -> 0x01dd }
                if (r9 != 0) goto L_0x016f
                org.jsoup.parser.Parser r9 = org.jsoup.parser.Parser.f()     // Catch:{ IOException -> 0x01dd }
                r8.o(r9)     // Catch:{ IOException -> 0x01dd }
            L_0x016f:
                java.lang.String r9 = r4.f41529j     // Catch:{ IOException -> 0x01dd }
                java.lang.String r9 = org.jsoup.helper.DataUtil.d(r9)     // Catch:{ IOException -> 0x01dd }
                r4.f41528i = r9     // Catch:{ IOException -> 0x01dd }
                int r9 = r2.getContentLength()     // Catch:{ IOException -> 0x01dd }
                if (r9 == 0) goto L_0x01c4
                org.jsoup.Connection$Method r9 = r8.method()     // Catch:{ IOException -> 0x01dd }
                org.jsoup.Connection$Method r0 = org.jsoup.Connection.Method.HEAD     // Catch:{ IOException -> 0x01dd }
                if (r9 == r0) goto L_0x01c4
                r4.f41527h = r5     // Catch:{ IOException -> 0x01dd }
                java.io.InputStream r9 = r2.getErrorStream()     // Catch:{ IOException -> 0x01dd }
                if (r9 == 0) goto L_0x0192
                java.io.InputStream r9 = r2.getErrorStream()     // Catch:{ IOException -> 0x01dd }
                goto L_0x0196
            L_0x0192:
                java.io.InputStream r9 = r2.getInputStream()     // Catch:{ IOException -> 0x01dd }
            L_0x0196:
                r4.f41527h = r9     // Catch:{ IOException -> 0x01dd }
                java.lang.String r9 = "Content-Encoding"
                java.lang.String r0 = "gzip"
                boolean r9 = r4.A(r9, r0)     // Catch:{ IOException -> 0x01dd }
                if (r9 == 0) goto L_0x01ab
                java.util.zip.GZIPInputStream r9 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x01dd }
                java.io.InputStream r0 = r4.f41527h     // Catch:{ IOException -> 0x01dd }
                r9.<init>(r0)     // Catch:{ IOException -> 0x01dd }
                r4.f41527h = r9     // Catch:{ IOException -> 0x01dd }
            L_0x01ab:
                java.io.InputStream r9 = r4.f41527h     // Catch:{ IOException -> 0x01dd }
                int r0 = r8.v()     // Catch:{ IOException -> 0x01dd }
                r1 = 32768(0x8000, float:4.5918E-41)
                org.jsoup.internal.ConstrainableInputStream r9 = org.jsoup.internal.ConstrainableInputStream.k(r9, r1, r0)     // Catch:{ IOException -> 0x01dd }
                int r8 = r8.timeout()     // Catch:{ IOException -> 0x01dd }
                long r0 = (long) r8     // Catch:{ IOException -> 0x01dd }
                org.jsoup.internal.ConstrainableInputStream r8 = r9.i(r6, r0)     // Catch:{ IOException -> 0x01dd }
                r4.f41527h = r8     // Catch:{ IOException -> 0x01dd }
                goto L_0x01ca
            L_0x01c4:
                java.nio.ByteBuffer r8 = org.jsoup.helper.DataUtil.c()     // Catch:{ IOException -> 0x01dd }
                r4.f41526g = r8     // Catch:{ IOException -> 0x01dd }
            L_0x01ca:
                r4.f41530k = r3
                return r4
            L_0x01cd:
                org.jsoup.HttpStatusException r9 = new org.jsoup.HttpStatusException     // Catch:{ IOException -> 0x01dd }
                java.lang.String r0 = "HTTP error fetching URL"
                java.net.URL r8 = r8.h()     // Catch:{ IOException -> 0x01dd }
                java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x01dd }
                r9.<init>(r0, r1, r8)     // Catch:{ IOException -> 0x01dd }
                throw r9     // Catch:{ IOException -> 0x01dd }
            L_0x01dd:
                r8 = move-exception
                r2.disconnect()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.J(org.jsoup.Connection$Request, org.jsoup.helper.HttpConnection$Response):org.jsoup.helper.HttpConnection$Response");
        }

        private static HostnameVerifier K() {
            return new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            };
        }

        private static String L(Connection.Request request) {
            StringBuilder m2 = StringUtil.m();
            boolean z2 = true;
            for (Map.Entry next : request.l().entrySet()) {
                if (!z2) {
                    m2.append("; ");
                } else {
                    z2 = false;
                }
                m2.append((String) next.getKey());
                m2.append('=');
                m2.append((String) next.getValue());
            }
            return m2.toString();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:5|6|7|8|9|10|11) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static synchronized void M() throws java.io.IOException {
            /*
                java.lang.Class<org.jsoup.helper.HttpConnection$Response> r0 = org.jsoup.helper.HttpConnection.Response.class
                monitor-enter(r0)
                javax.net.ssl.SSLSocketFactory r1 = f41522o     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                r1 = 1
                javax.net.ssl.TrustManager[] r1 = new javax.net.ssl.TrustManager[r1]     // Catch:{ all -> 0x0032 }
                org.jsoup.helper.HttpConnection$Response$2 r2 = new org.jsoup.helper.HttpConnection$Response$2     // Catch:{ all -> 0x0032 }
                r2.<init>()     // Catch:{ all -> 0x0032 }
                r3 = 0
                r1[r3] = r2     // Catch:{ all -> 0x0032 }
                java.lang.String r2 = "SSL"
                javax.net.ssl.SSLContext r2 = javax.net.ssl.SSLContext.getInstance(r2)     // Catch:{ KeyManagementException | NoSuchAlgorithmException -> 0x0028 }
                java.security.SecureRandom r3 = new java.security.SecureRandom     // Catch:{ KeyManagementException | NoSuchAlgorithmException -> 0x0028 }
                r3.<init>()     // Catch:{ KeyManagementException | NoSuchAlgorithmException -> 0x0028 }
                r4 = 0
                r2.init(r4, r1, r3)     // Catch:{ KeyManagementException | NoSuchAlgorithmException -> 0x0028 }
                javax.net.ssl.SSLSocketFactory r1 = r2.getSocketFactory()     // Catch:{ KeyManagementException | NoSuchAlgorithmException -> 0x0028 }
                f41522o = r1     // Catch:{ KeyManagementException | NoSuchAlgorithmException -> 0x0028 }
                goto L_0x0030
            L_0x0028:
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0032 }
                java.lang.String r2 = "Can't create unsecure trust manager"
                r1.<init>(r2)     // Catch:{ all -> 0x0032 }
                throw r1     // Catch:{ all -> 0x0032 }
            L_0x0030:
                monitor-exit(r0)
                return
            L_0x0032:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.M():void");
        }

        private void O() {
            InputStream inputStream = this.f41527h;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.f41527h = null;
                    throw th;
                }
                this.f41527h = null;
            }
        }

        private static void P(Connection.Request request) throws IOException {
            boolean z2;
            URL h2 = request.h();
            StringBuilder m2 = StringUtil.m();
            m2.append(h2.getProtocol());
            m2.append("://");
            m2.append(h2.getAuthority());
            m2.append(h2.getPath());
            m2.append("?");
            if (h2.getQuery() != null) {
                m2.append(h2.getQuery());
                z2 = false;
            } else {
                z2 = true;
            }
            for (Connection.KeyVal next : request.k()) {
                Validate.c(next.b(), "InputStream data not supported in URL query string.");
                if (!z2) {
                    m2.append('&');
                } else {
                    z2 = false;
                }
                m2.append(URLEncoder.encode(next.key(), "UTF-8"));
                m2.append('=');
                m2.append(URLEncoder.encode(next.value(), "UTF-8"));
            }
            request.p(new URL(m2.toString()));
            request.k().clear();
        }

        private static String Q(Connection.Request request) {
            if (!request.r(TraktV2.HEADER_CONTENT_TYPE)) {
                if (HttpConnection.l(request)) {
                    String e2 = DataUtil.e();
                    request.b(TraktV2.HEADER_CONTENT_TYPE, "multipart/form-data; boundary=" + e2);
                    return e2;
                }
                request.b(TraktV2.HEADER_CONTENT_TYPE, "application/x-www-form-urlencoded; charset=" + request.e());
            }
            return null;
        }

        private void R(HttpURLConnection httpURLConnection, Connection.Response response) throws IOException {
            this.f41507b = Connection.Method.valueOf(httpURLConnection.getRequestMethod());
            this.f41506a = httpURLConnection.getURL();
            this.f41524e = httpURLConnection.getResponseCode();
            this.f41525f = httpURLConnection.getResponseMessage();
            this.f41529j = httpURLConnection.getContentType();
            N(H(httpURLConnection));
            if (response != null) {
                for (Map.Entry next : response.l().entrySet()) {
                    if (!z((String) next.getKey())) {
                        i((String) next.getKey(), (String) next.getValue());
                    }
                }
            }
        }

        private static void S(Connection.Request request, OutputStream outputStream, String str) throws IOException {
            String str2;
            Collection<Connection.KeyVal> k2 = request.k();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, request.e()));
            if (str != null) {
                for (Connection.KeyVal next : k2) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    bufferedWriter.write(HttpConnection.h(next.key()));
                    bufferedWriter.write("\"");
                    if (next.b()) {
                        bufferedWriter.write("; filename=\"");
                        bufferedWriter.write(HttpConnection.h(next.value()));
                        bufferedWriter.write("\"\r\nContent-Type: ");
                        if (next.a() != null) {
                            str2 = next.a();
                        } else {
                            str2 = "application/octet-stream";
                        }
                        bufferedWriter.write(str2);
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.flush();
                        DataUtil.a(next.d(), outputStream);
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(next.value());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else if (request.u() != null) {
                bufferedWriter.write(request.u());
            } else {
                boolean z2 = true;
                for (Connection.KeyVal next2 : k2) {
                    if (!z2) {
                        bufferedWriter.append('&');
                    } else {
                        z2 = false;
                    }
                    bufferedWriter.write(URLEncoder.encode(next2.key(), request.e()));
                    bufferedWriter.write(61);
                    bufferedWriter.write(URLEncoder.encode(next2.value(), request.e()));
                }
            }
            bufferedWriter.close();
        }

        public /* bridge */ /* synthetic */ boolean A(String str, String str2) {
            return super.A(str, str2);
        }

        public /* bridge */ /* synthetic */ String B(String str) {
            return super.B(str);
        }

        public /* bridge */ /* synthetic */ List C(String str) {
            return super.C(str);
        }

        public String F() {
            return this.f41529j;
        }

        /* access modifiers changed from: package-private */
        public void N(Map<String, List<String>> map) {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                if (str != null) {
                    List<String> list = (List) next.getValue();
                    if (str.equalsIgnoreCase("Set-Cookie")) {
                        for (String str2 : list) {
                            if (str2 != null) {
                                TokenQueue tokenQueue = new TokenQueue(str2);
                                String trim = tokenQueue.b("=").trim();
                                String trim2 = tokenQueue.g(";").trim();
                                if (trim.length() > 0) {
                                    i(trim, trim2);
                                }
                            }
                        }
                    }
                    for (String w2 : list) {
                        w(str, w2);
                    }
                }
            }
        }

        public /* bridge */ /* synthetic */ URL h() {
            return super.h();
        }

        public /* bridge */ /* synthetic */ Map l() {
            return super.l();
        }

        public Document parse() throws IOException {
            Validate.e(this.f41530k, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            if (this.f41526g != null) {
                this.f41527h = new ByteArrayInputStream(this.f41526g.array());
                this.f41531l = false;
            }
            Validate.c(this.f41531l, "Input stream already read and parsed, cannot re-read.");
            Document f2 = DataUtil.f(this.f41527h, this.f41528i, this.f41506a.toExternalForm(), this.f41533n.parser());
            this.f41528i = f2.z0().a().name();
            this.f41531l = true;
            O();
            return f2;
        }

        public /* bridge */ /* synthetic */ boolean r(String str) {
            return super.r(str);
        }

        public /* bridge */ /* synthetic */ boolean z(String str) {
            return super.z(str);
        }

        private Response(Response response) throws IOException {
            super();
            if (response != null) {
                int i2 = response.f41532m + 1;
                this.f41532m = i2;
                if (i2 >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", new Object[]{response.h()}));
                }
            }
        }
    }
}
