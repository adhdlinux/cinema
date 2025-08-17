package com.original.tase.helper.http;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.original.Constants;
import com.original.tase.Logger;
import com.utils.Utils;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.TlsVersion;

public class HttpHelper {

    /* renamed from: c  reason: collision with root package name */
    private static volatile HttpHelper f33894c;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f33895d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private CookieJar f33896a;

    /* renamed from: b  reason: collision with root package name */
    private OkHttpClient f33897b;

    public static class Network {
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [java.net.HttpURLConnection, java.net.URLConnection] */
        /* JADX WARNING: type inference failed for: r0v2 */
        /* JADX WARNING: type inference failed for: r0v4 */
        /* JADX WARNING: type inference failed for: r0v6, types: [java.io.InputStream] */
        /* JADX WARNING: type inference failed for: r0v7 */
        /* JADX WARNING: type inference failed for: r0v10 */
        /* JADX WARNING: type inference failed for: r0v11 */
        /* JADX WARNING: Can't wrap try/catch for region: R(13:1|2|3|4|5|(1:7)|(3:9|(2:12|10)|43)|13|(3:14|15|16)|(2:19|20)|21|22|23) */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:(2:26|27)|(2:30|31)|32|33) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0055 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0067 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String a(java.lang.String r3, boolean r4, java.util.Map<java.lang.String, java.lang.String> r5) throws java.io.IOException, java.net.URISyntaxException {
            /*
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x006e }
                r1.<init>(r3)     // Catch:{ all -> 0x006e }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ all -> 0x006e }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ all -> 0x006e }
                r2 = 15000(0x3a98, float:2.102E-41)
                r1.setConnectTimeout(r2)     // Catch:{ all -> 0x0059 }
                r1.setReadTimeout(r2)     // Catch:{ all -> 0x0059 }
                r2 = 0
                r1.setInstanceFollowRedirects(r2)     // Catch:{ all -> 0x0059 }
                if (r4 == 0) goto L_0x001f
                java.lang.String r4 = "HEAD"
                r1.setRequestMethod(r4)     // Catch:{ all -> 0x0059 }
            L_0x001f:
                if (r5 == 0) goto L_0x0045
                java.util.Set r4 = r5.entrySet()     // Catch:{ all -> 0x0059 }
                java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0059 }
            L_0x0029:
                boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0059 }
                if (r5 == 0) goto L_0x0045
                java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0059 }
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x0059 }
                java.lang.Object r2 = r5.getKey()     // Catch:{ all -> 0x0059 }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0059 }
                java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x0059 }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0059 }
                r1.addRequestProperty(r2, r5)     // Catch:{ all -> 0x0059 }
                goto L_0x0029
            L_0x0045:
                java.lang.String r3 = c(r3, r1)     // Catch:{ all -> 0x0059 }
                java.io.InputStream r4 = r1.getInputStream()     // Catch:{ Exception -> 0x004f }
                r0 = r4
                goto L_0x0050
            L_0x004f:
            L_0x0050:
                if (r0 == 0) goto L_0x0055
                r0.close()     // Catch:{ IOException -> 0x0055 }
            L_0x0055:
                r1.disconnect()     // Catch:{ all -> 0x0059 }
                return r3
            L_0x0059:
                r3 = move-exception
                if (r1 == 0) goto L_0x006a
                java.io.InputStream r0 = r1.getInputStream()     // Catch:{ Exception -> 0x0061 }
                goto L_0x0062
            L_0x0061:
            L_0x0062:
                if (r0 == 0) goto L_0x0067
                r0.close()     // Catch:{ IOException -> 0x0067 }
            L_0x0067:
                r1.disconnect()     // Catch:{ all -> 0x006b }
            L_0x006a:
                throw r3     // Catch:{ all -> 0x006b }
            L_0x006b:
                r0 = r1
                goto L_0x006f
            L_0x006e:
            L_0x006f:
                if (r0 == 0) goto L_0x007d
                java.io.InputStream r3 = r0.getInputStream()
                if (r3 == 0) goto L_0x007a
                r3.close()
            L_0x007a:
                r0.disconnect()
            L_0x007d:
                java.lang.String r3 = ""
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.http.HttpHelper.Network.a(java.lang.String, boolean, java.util.Map):java.lang.String");
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [java.net.HttpURLConnection, java.net.URLConnection] */
        /* JADX WARNING: type inference failed for: r0v2 */
        /* JADX WARNING: type inference failed for: r0v4 */
        /* JADX WARNING: type inference failed for: r0v6, types: [java.io.InputStream] */
        /* JADX WARNING: type inference failed for: r0v7 */
        /* JADX WARNING: type inference failed for: r0v10 */
        /* JADX WARNING: type inference failed for: r0v11 */
        /* JADX WARNING: Can't wrap try/catch for region: R(15:1|2|3|4|5|(1:7)|(3:9|(2:12|10)|43)|13|14|15|16|(2:19|20)|21|22|23) */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:(2:26|27)|(2:30|31)|32|33) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0083 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x008d  */
        /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String b(java.lang.String r3, java.lang.String r4, boolean r5, java.util.Map<java.lang.String, java.lang.String> r6) throws java.io.IOException, java.net.URISyntaxException {
            /*
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x008a }
                r1.<init>(r3)     // Catch:{ all -> 0x008a }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ all -> 0x008a }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ all -> 0x008a }
                r2 = 15000(0x3a98, float:2.102E-41)
                r1.setConnectTimeout(r2)     // Catch:{ all -> 0x0075 }
                r1.setReadTimeout(r2)     // Catch:{ all -> 0x0075 }
                r2 = 0
                r1.setInstanceFollowRedirects(r2)     // Catch:{ all -> 0x0075 }
                java.lang.String r2 = "POST"
                r1.setRequestMethod(r2)     // Catch:{ all -> 0x0075 }
                r2 = 1
                r1.setDoOutput(r2)     // Catch:{ all -> 0x0075 }
                if (r5 == 0) goto L_0x0028
                java.lang.String r5 = "HEAD"
                r1.setRequestMethod(r5)     // Catch:{ all -> 0x0075 }
            L_0x0028:
                if (r6 == 0) goto L_0x004e
                java.util.Set r5 = r6.entrySet()     // Catch:{ all -> 0x0075 }
                java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0075 }
            L_0x0032:
                boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0075 }
                if (r6 == 0) goto L_0x004e
                java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0075 }
                java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x0075 }
                java.lang.Object r2 = r6.getKey()     // Catch:{ all -> 0x0075 }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0075 }
                java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x0075 }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0075 }
                r1.addRequestProperty(r2, r6)     // Catch:{ all -> 0x0075 }
                goto L_0x0032
            L_0x004e:
                java.io.OutputStream r5 = r1.getOutputStream()     // Catch:{ all -> 0x0075 }
                java.lang.String r6 = "UTF-8"
                byte[] r4 = r4.getBytes(r6)     // Catch:{ all -> 0x0075 }
                r5.write(r4)     // Catch:{ all -> 0x0075 }
                r5.flush()     // Catch:{ all -> 0x0075 }
                r5.close()     // Catch:{ all -> 0x0075 }
                java.lang.String r3 = c(r3, r1)     // Catch:{ all -> 0x0075 }
                java.io.InputStream r4 = r1.getInputStream()     // Catch:{ Exception -> 0x006b }
                r0 = r4
                goto L_0x006c
            L_0x006b:
            L_0x006c:
                if (r0 == 0) goto L_0x0071
                r0.close()     // Catch:{ IOException -> 0x0071 }
            L_0x0071:
                r1.disconnect()     // Catch:{ all -> 0x0075 }
                return r3
            L_0x0075:
                r3 = move-exception
                if (r1 == 0) goto L_0x0086
                java.io.InputStream r0 = r1.getInputStream()     // Catch:{ Exception -> 0x007d }
                goto L_0x007e
            L_0x007d:
            L_0x007e:
                if (r0 == 0) goto L_0x0083
                r0.close()     // Catch:{ IOException -> 0x0083 }
            L_0x0083:
                r1.disconnect()     // Catch:{ all -> 0x0087 }
            L_0x0086:
                throw r3     // Catch:{ all -> 0x0087 }
            L_0x0087:
                r0 = r1
                goto L_0x008b
            L_0x008a:
            L_0x008b:
                if (r0 == 0) goto L_0x0099
                java.io.InputStream r3 = r0.getInputStream()
                if (r3 == 0) goto L_0x0096
                r3.close()
            L_0x0096:
                r0.disconnect()
            L_0x0099:
                java.lang.String r3 = ""
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.http.HttpHelper.Network.b(java.lang.String, java.lang.String, boolean, java.util.Map):java.lang.String");
        }

        public static String c(String str, HttpURLConnection httpURLConnection) throws IOException, URISyntaxException {
            URI uri = new URI(str.replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "").replace("\r", ""));
            int responseCode = httpURLConnection.getResponseCode();
            String headerField = httpURLConnection.getHeaderField("Location");
            if (responseCode < 300 || responseCode >= 400) {
                return null;
            }
            try {
                return uri.resolve(headerField).toString();
            } catch (IllegalArgumentException unused) {
                throw new URISyntaxException(headerField, "Unable to parse invalid URL");
            }
        }
    }

    private HttpHelper() {
        if (this.f33896a == null) {
            this.f33896a = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(Utils.v()));
        }
        if (this.f33897b == null) {
            this.f33897b = c();
        }
    }

    public static String B(String str, String str2, HashMap hashMap) {
        try {
            return Network.b(str, str2, false, hashMap);
        } catch (IOException | URISyntaxException unused) {
            return str;
        }
    }

    private static OkHttpClient.Builder a(OkHttpClient.Builder builder) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ConnectionSpec.CLEARTEXT);
        arrayList.add(ConnectionSpec.MODERN_TLS);
        arrayList.add(b());
        arrayList.add(ConnectionSpec.COMPATIBLE_TLS);
        return builder.connectionSpecs(arrayList);
    }

    private static ConnectionSpec b() {
        return new ConnectionSpec.Builder(ConnectionSpec.COMPATIBLE_TLS).tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1).cipherSuites(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA).build();
    }

    public static String d(String str, HashMap hashMap) {
        try {
            return Network.a(str, false, hashMap);
        } catch (IOException | URISyntaxException unused) {
            return str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        if (r7.containsKey("content-range") != false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00b5, code lost:
        if (r7.containsKey("content-length") != false) goto L_0x00b7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long h(okhttp3.Response r12, boolean r13, boolean... r14) {
        /*
            java.lang.String r0 = "/"
            java.lang.String r1 = "Content-Range"
            java.lang.String r2 = "Content-Length"
            r3 = -1
            if (r12 != 0) goto L_0x000b
            return r3
        L_0x000b:
            r5 = 0
            r6 = 1
            okhttp3.Headers r7 = r12.headers()     // Catch:{ all -> 0x0122 }
            if (r7 == 0) goto L_0x0128
            okhttp3.Headers r7 = r12.headers()     // Catch:{ all -> 0x0122 }
            java.util.Map r7 = r7.toMultimap()     // Catch:{ all -> 0x0122 }
            if (r7 == 0) goto L_0x0128
            r8 = 0
            if (r13 == 0) goto L_0x00a9
            boolean r10 = r7.containsKey(r1)     // Catch:{ all -> 0x0122 }
            java.lang.String r11 = "content-range"
            if (r10 != 0) goto L_0x002f
            boolean r10 = r7.containsKey(r11)     // Catch:{ all -> 0x0122 }
            if (r10 == 0) goto L_0x00a9
        L_0x002f:
            boolean r2 = r7.containsKey(r1)     // Catch:{ all -> 0x0122 }
            if (r2 == 0) goto L_0x003c
            java.lang.Object r1 = r7.get(r1)     // Catch:{ all -> 0x0122 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0122 }
            goto L_0x0042
        L_0x003c:
            java.lang.Object r1 = r7.get(r11)     // Catch:{ all -> 0x0122 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0122 }
        L_0x0042:
            if (r1 == 0) goto L_0x0128
            int r2 = r1.size()     // Catch:{ all -> 0x0122 }
            if (r2 <= 0) goto L_0x0128
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0122 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0122 }
            if (r1 == 0) goto L_0x0128
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x0122 }
            if (r2 != 0) goto L_0x0128
            boolean r2 = r1.contains(r0)     // Catch:{ all -> 0x0122 }
            if (r2 == 0) goto L_0x0063
            java.lang.String[] r0 = r1.split(r0)     // Catch:{ all -> 0x0122 }
            goto L_0x0064
        L_0x0063:
            r0 = 0
        L_0x0064:
            if (r0 == 0) goto L_0x0070
            int r2 = r0.length     // Catch:{ all -> 0x0122 }
            r7 = 2
            if (r2 != r7) goto L_0x0070
            r0 = r0[r6]     // Catch:{ all -> 0x0122 }
            java.lang.String r1 = r0.trim()     // Catch:{ all -> 0x0122 }
        L_0x0070:
            boolean r0 = r1.isEmpty()     // Catch:{ all -> 0x0122 }
            if (r0 != 0) goto L_0x0128
            boolean r0 = com.original.tase.utils.Utils.o(r1)     // Catch:{ all -> 0x0122 }
            if (r0 == 0) goto L_0x0128
            java.lang.Long r0 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0122 }
            long r0 = r0.longValue()     // Catch:{ all -> 0x0122 }
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x00a8
            okhttp3.ResponseBody r2 = r12.body()     // Catch:{ all -> 0x011d }
            long r0 = r2.contentLength()     // Catch:{ all -> 0x011d }
            if (r14 == 0) goto L_0x00a8
            int r2 = r14.length     // Catch:{ all -> 0x011d }
            if (r2 <= 0) goto L_0x00a8
            okhttp3.Response r2 = r12.networkResponse()     // Catch:{ all -> 0x011d }
            if (r2 == 0) goto L_0x00a8
            okhttp3.Response r2 = r12.networkResponse()     // Catch:{ all -> 0x011d }
            boolean[] r3 = new boolean[r6]     // Catch:{ all -> 0x011d }
            r3[r5] = r6     // Catch:{ all -> 0x011d }
            long r12 = h(r2, r13, r3)     // Catch:{ all -> 0x011d }
            return r12
        L_0x00a8:
            return r0
        L_0x00a9:
            boolean r0 = r7.containsKey(r2)     // Catch:{ all -> 0x0122 }
            java.lang.String r1 = "content-length"
            if (r0 != 0) goto L_0x00b7
            boolean r0 = r7.containsKey(r1)     // Catch:{ all -> 0x0122 }
            if (r0 == 0) goto L_0x0128
        L_0x00b7:
            boolean r0 = r7.containsKey(r2)     // Catch:{ all -> 0x0122 }
            if (r0 == 0) goto L_0x00c4
            java.lang.Object r0 = r7.get(r2)     // Catch:{ all -> 0x0122 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0122 }
            goto L_0x00ca
        L_0x00c4:
            java.lang.Object r0 = r7.get(r1)     // Catch:{ all -> 0x0122 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0122 }
        L_0x00ca:
            if (r0 == 0) goto L_0x0128
            int r1 = r0.size()     // Catch:{ all -> 0x0122 }
            if (r1 <= 0) goto L_0x0128
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0122 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0122 }
            if (r0 == 0) goto L_0x0128
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0122 }
            if (r1 != 0) goto L_0x0128
            boolean r1 = com.original.tase.utils.Utils.o(r0)     // Catch:{ all -> 0x0122 }
            if (r1 == 0) goto L_0x0128
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0122 }
            long r0 = r0.longValue()     // Catch:{ all -> 0x0122 }
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x0121
            okhttp3.ResponseBody r2 = r12.body()     // Catch:{ all -> 0x011d }
            if (r2 == 0) goto L_0x0121
            okhttp3.ResponseBody r2 = r12.body()     // Catch:{ all -> 0x011d }
            long r0 = r2.contentLength()     // Catch:{ all -> 0x011d }
            if (r14 == 0) goto L_0x011c
            int r2 = r14.length     // Catch:{ all -> 0x011d }
            if (r2 <= 0) goto L_0x011c
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x011c
            okhttp3.Response r2 = r12.networkResponse()     // Catch:{ all -> 0x011d }
            if (r2 == 0) goto L_0x011c
            okhttp3.Response r2 = r12.networkResponse()     // Catch:{ all -> 0x011d }
            boolean[] r3 = new boolean[r6]     // Catch:{ all -> 0x011d }
            r3[r5] = r6     // Catch:{ all -> 0x011d }
            long r12 = h(r2, r13, r3)     // Catch:{ all -> 0x011d }
            return r12
        L_0x011c:
            return r0
        L_0x011d:
            r2 = move-exception
            r3 = r0
            r0 = r2
            goto L_0x0123
        L_0x0121:
            return r0
        L_0x0122:
            r0 = move-exception
        L_0x0123:
            boolean[] r1 = new boolean[r5]
            com.original.tase.Logger.d(r0, r1)
        L_0x0128:
            okhttp3.ResponseBody r0 = r12.body()
            if (r0 == 0) goto L_0x0137
            okhttp3.ResponseBody r12 = r12.body()
            long r3 = r12.contentLength()
            goto L_0x0170
        L_0x0137:
            if (r14 == 0) goto L_0x014f
            int r14 = r14.length
            if (r14 <= 0) goto L_0x014f
            okhttp3.Response r14 = r12.networkResponse()
            if (r14 == 0) goto L_0x014f
            okhttp3.Response r12 = r12.networkResponse()
            boolean[] r14 = new boolean[r6]
            r14[r5] = r6
            long r12 = h(r12, r13, r14)
            return r12
        L_0x014f:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            okhttp3.Request r12 = r12.request()
            okhttp3.HttpUrl r12 = r12.url()
            r13.append(r12)
            java.lang.String r12 = " size = "
            r13.append(r12)
            r13.append(r3)
            java.lang.String r12 = r13.toString()
            java.lang.String r13 = "HttpHelper "
            com.original.tase.Logger.b(r13, r12)
        L_0x0170:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.http.HttpHelper.h(okhttp3.Response, boolean, boolean[]):long");
    }

    public static HttpHelper i() {
        if (f33894c == null) {
            synchronized (HttpHelper.class) {
                f33894c = new HttpHelper();
            }
        }
        return f33894c;
    }

    @SafeVarargs
    private final String j(String str, RequestBody requestBody, boolean z2, Map<String, String>... mapArr) {
        Map<String, String> map;
        if (str.isEmpty()) {
            return "";
        }
        Request.Builder tag = new Request.Builder().url(str).post(requestBody).addHeader("User-Agent", Constants.C).tag(f33895d);
        if (!(mapArr == null || mapArr.length <= 0 || (map = mapArr[0]) == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()).toLowerCase().equals("user-agent")) {
                    tag.header("User-Agent", (String) next.getValue());
                } else {
                    tag.addHeader((String) next.getKey(), (String) next.getValue());
                }
            }
        }
        if (z2) {
            tag.addHeader(TraktV2.HEADER_CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8");
        }
        return u(tag.build());
    }

    public boolean A(HttpUrl httpUrl, HttpUrl httpUrl2) {
        boolean z2;
        boolean z3;
        if (!(httpUrl == null || httpUrl2 == null)) {
            try {
                if (!(httpUrl.encodedQuery() == null && httpUrl2.encodedQuery() == null) && (httpUrl.encodedQuery() == null || httpUrl2.encodedQuery() == null || !httpUrl.encodedQuery().equals(httpUrl2.encodedQuery()))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!(httpUrl.encodedFragment() == null && httpUrl2.encodedFragment() == null) && (httpUrl.encodedFragment() == null || httpUrl2.encodedFragment() == null || !httpUrl.encodedFragment().equals(httpUrl2.encodedFragment()))) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!httpUrl.encodedUsername().equals(httpUrl2.encodedUsername()) || !httpUrl.encodedPassword().equals(httpUrl2.encodedPassword()) || !httpUrl.username().equals(httpUrl2.username()) || httpUrl.password() != httpUrl2.password() || !httpUrl.encodedPath().equals(httpUrl2.encodedPath()) || !z3 || !z2) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                Logger.d(th, false);
            }
        }
        return false;
    }

    @SafeVarargs
    public final Response C(String str, String str2, Map<String, String>... mapArr) {
        Map<String, String> map;
        RequestBody create = RequestBody.create(str2, MediaType.parse("application/json; charset=utf-8"));
        if (mapArr.length > 0) {
            Map<String, String> map2 = mapArr[0];
            if (map2.containsKey(TraktV2.HEADER_CONTENT_TYPE)) {
                create = RequestBody.create(str2, MediaType.parse(map2.get(TraktV2.HEADER_CONTENT_TYPE)));
            } else if (map2.containsKey("content-type")) {
                create = RequestBody.create(str2, MediaType.parse(map2.get("content-type")));
            }
        }
        Request.Builder tag = new Request.Builder().url(str).post(create).tag(f33895d);
        if (mapArr.length > 0 && (map = mapArr[0]) != null) {
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()).toLowerCase().equals("user-agent")) {
                    tag.header("User-Agent", (String) next.getValue());
                } else {
                    tag.addHeader((String) next.getKey(), (String) next.getValue());
                }
            }
        }
        Response x2 = x(tag.build(), new int[0]);
        if (x2 == null || x2.code() == 404) {
            return null;
        }
        return x2;
    }

    public void D(String str, String str2) {
        String[] strArr;
        if (!str.isEmpty() && !str2.isEmpty()) {
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            HttpUrl parse = HttpUrl.parse(str);
            if (parse != null) {
                CookieJar cookieJar = this.f33897b.cookieJar();
                if (str2.contains("|||")) {
                    strArr = str2.split("\\|\\|\\|");
                } else {
                    strArr = new String[]{str2};
                }
                for (String parse2 : strArr) {
                    Cookie parse3 = Cookie.parse(parse, parse2);
                    if (parse3 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(parse3);
                        cookieJar.saveFromResponse(parse, arrayList);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.OkHttpClient c() {
        /*
            r5 = this;
            okhttp3.OkHttpClient$Builder r0 = new okhttp3.OkHttpClient$Builder
            r0.<init>()
            com.original.tase.helper.http.TLSSocketFactory r1 = new com.original.tase.helper.http.TLSSocketFactory     // Catch:{ KeyManagementException -> 0x0015, NoSuchAlgorithmException -> 0x0010, KeyStoreException -> 0x000b }
            r1.<init>()     // Catch:{ KeyManagementException -> 0x0015, NoSuchAlgorithmException -> 0x0010, KeyStoreException -> 0x000b }
            goto L_0x001a
        L_0x000b:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0019
        L_0x0010:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0019
        L_0x0015:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0019:
            r1 = 0
        L_0x001a:
            com.original.tase.helper.http.HttpHelper$3 r2 = new com.original.tase.helper.http.HttpHelper$3
            r2.<init>()
            r0.hostnameVerifier(r2)
            com.original.tase.helper.http.interceptor.ForceNoCacheSegmentInterceptor r2 = new com.original.tase.helper.http.interceptor.ForceNoCacheSegmentInterceptor
            r2.<init>()
            okhttp3.OkHttpClient$Builder r0 = r0.addInterceptor(r2)
            com.original.tase.helper.http.interceptor.PostRewriteResponseCodeInterceptor r2 = new com.original.tase.helper.http.interceptor.PostRewriteResponseCodeInterceptor
            r2.<init>()
            okhttp3.OkHttpClient$Builder r0 = r0.addNetworkInterceptor(r2)
            com.original.tase.helper.http.interceptor.HeadersInterceptor r2 = new com.original.tase.helper.http.interceptor.HeadersInterceptor
            r2.<init>()
            okhttp3.OkHttpClient$Builder r0 = r0.addInterceptor(r2)
            com.original.tase.helper.http.interceptor.PostRedirectInterceptor r2 = new com.original.tase.helper.http.interceptor.PostRedirectInterceptor
            r2.<init>()
            okhttp3.OkHttpClient$Builder r0 = r0.addInterceptor(r2)
            com.original.tase.helper.http.interceptor.CloseConnectionInterceptor r2 = new com.original.tase.helper.http.interceptor.CloseConnectionInterceptor
            r2.<init>()
            okhttp3.OkHttpClient$Builder r0 = r0.addInterceptor(r2)
            com.original.tase.helper.http.interceptor.CacheInterceptor r2 = new com.original.tase.helper.http.interceptor.CacheInterceptor
            r2.<init>()
            okhttp3.OkHttpClient$Builder r0 = r0.addNetworkInterceptor(r2)
            com.original.tase.helper.http.interceptor.RemoveHeadersInterceptor r2 = new com.original.tase.helper.http.interceptor.RemoveHeadersInterceptor
            r2.<init>()
            okhttp3.OkHttpClient$Builder r0 = r0.addInterceptor(r2)
            com.original.tase.helper.http.cloudflare.CloudflareKiller r2 = new com.original.tase.helper.http.cloudflare.CloudflareKiller
            r2.<init>()
            okhttp3.OkHttpClient$Builder r0 = r0.addInterceptor(r2)
            com.original.tase.helper.http.DdosGuardIntercetor.DdosGuardIntercetor r2 = new com.original.tase.helper.http.DdosGuardIntercetor.DdosGuardIntercetor
            r2.<init>()
            okhttp3.OkHttpClient$Builder r0 = r0.addInterceptor(r2)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS
            r3 = 15
            okhttp3.OkHttpClient$Builder r0 = r0.connectTimeout(r3, r2)
            okhttp3.OkHttpClient$Builder r0 = r0.readTimeout(r3, r2)
            okhttp3.OkHttpClient$Builder r0 = r0.writeTimeout(r3, r2)
            r2 = 1
            okhttp3.OkHttpClient$Builder r0 = r0.followRedirects(r2)
            okhttp3.CookieJar r2 = r5.f33896a
            okhttp3.OkHttpClient$Builder r0 = r0.cookieJar(r2)
            if (r1 == 0) goto L_0x0097
            javax.net.ssl.X509TrustManager r2 = r1.c()
            r0.sslSocketFactory(r1, r2)
        L_0x0097:
            okhttp3.OkHttpClient$Builder r0 = a(r0)
            okhttp3.OkHttpClient r0 = r0.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.http.HttpHelper.c():okhttp3.OkHttpClient");
    }

    public final Response e(String str, Map<String, String>... mapArr) {
        Map<String, String> map;
        if (str.isEmpty()) {
            return null;
        }
        Request.Builder tag = new Request.Builder().url(str).addHeader("User-Agent", Constants.C).tag(f33895d);
        if (!(mapArr == null || mapArr.length <= 0 || (map = mapArr[0]) == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()).toLowerCase().equals("user-agent")) {
                    tag.header("User-Agent", (String) next.getValue());
                } else {
                    tag.addHeader((String) next.getKey(), (String) next.getValue());
                }
            }
        }
        Response x2 = x(tag.build(), new int[0]);
        if (x2 == null) {
            return null;
        }
        if (x2.code() != 404) {
            return x2;
        }
        if (x2.body() != null) {
            x2.body().close();
        }
        return null;
    }

    public long f(String str, Map<String, String>... mapArr) {
        Map<String, String> map;
        if (str.isEmpty()) {
            return 0;
        }
        HashMap hashMap = new HashMap();
        if (!(mapArr == null || mapArr.length <= 0 || (map = mapArr[0]) == null)) {
            hashMap.putAll(map);
        }
        return h(w(str, false, hashMap), false, false);
    }

    public String g(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        StringBuilder sb = new StringBuilder();
        if (parse != null) {
            for (Cookie next : this.f33897b.cookieJar().loadForRequest(parse)) {
                sb.append(next.name());
                sb.append("=");
                sb.append(next.value());
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public void k() {
        for (Call cancel : this.f33897b.dispatcher().queuedCalls()) {
            cancel.cancel();
        }
        for (Call cancel2 : this.f33897b.dispatcher().runningCalls()) {
            cancel2.cancel();
        }
        this.f33897b.dispatcher().executorService().shutdown();
    }

    @SafeVarargs
    public final String l(String str, String str2, Map<String, String>... mapArr) {
        return j(str, RequestBody.create(str2, MediaType.parse("application/x-www-form-urlencoded")), true, mapArr);
    }

    @SafeVarargs
    public final String m(String str, Map<String, String>... mapArr) {
        Map<String, String> map;
        if (str.isEmpty()) {
            return "";
        }
        Request.Builder tag = new Request.Builder().url(str).addHeader("User-Agent", Constants.C).tag(f33895d);
        if (!(mapArr == null || mapArr.length <= 0 || (map = mapArr[0]) == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()).toLowerCase().equals("user-agent")) {
                    tag.header("User-Agent", (String) next.getValue());
                } else {
                    tag.addHeader((String) next.getKey(), (String) next.getValue());
                }
            }
        }
        return u(tag.build());
    }

    public boolean n(String str, String str2) {
        return A(HttpUrl.parse(str), HttpUrl.parse(str2));
    }

    public String o(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("Referer", str2);
        return m(str, hashMap);
    }

    @SafeVarargs
    public final String p(String str, String str2, String str3, Map<String, String>... mapArr) {
        Map<String, String> map;
        if (str.isEmpty()) {
            return "";
        }
        Request.Builder tag = new Request.Builder().url(str).addHeader("User-Agent", str2).tag(f33895d);
        if (!(mapArr == null || mapArr.length <= 0 || (map = mapArr[0]) == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()).toLowerCase().equals("user-agent")) {
                    tag.header("User-Agent", (String) next.getValue());
                } else {
                    tag.addHeader((String) next.getKey(), (String) next.getValue());
                }
            }
        }
        if (str3 != null && !str3.isEmpty()) {
            tag.addHeader("Referer", str3);
        }
        return u(tag.build());
    }

    @SafeVarargs
    public final String q(String str, String str2, boolean z2, Map<String, String>... mapArr) {
        RequestBody requestBody;
        if (z2) {
            requestBody = RequestBody.create(str2, MediaType.parse("application/x-www-form-urlencoded"));
        } else {
            if (mapArr.length > 0) {
                Map<String, String> map = mapArr[0];
                if (map.containsKey(TraktV2.HEADER_CONTENT_TYPE)) {
                    requestBody = RequestBody.create(str2, MediaType.parse(map.get(TraktV2.HEADER_CONTENT_TYPE)));
                } else if (map.containsKey("content-type")) {
                    requestBody = RequestBody.create(str2, MediaType.parse(map.get("content-type")));
                }
            }
            requestBody = null;
        }
        if (requestBody == null) {
            requestBody = RequestBody.create(str2, MediaType.parse("application/x-www-form-urlencoded"));
        }
        return j(str, requestBody, z2, mapArr);
    }

    @SafeVarargs
    public final String r(String str, String str2, Map<String, String>... mapArr) {
        Map<String, String> map;
        if (str.isEmpty()) {
            return "";
        }
        Request.Builder tag = new Request.Builder().url(str).addHeader("User-Agent", Constants.C).tag(f33895d);
        if (!(mapArr == null || mapArr.length <= 0 || (map = mapArr[0]) == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()).toLowerCase().equals("user-agent")) {
                    tag.header("User-Agent", (String) next.getValue());
                } else {
                    tag.addHeader((String) next.getKey(), (String) next.getValue());
                }
            }
        }
        if (str2 != null && !str2.isEmpty()) {
            tag.addHeader("Referer", str2);
        }
        return u(tag.build());
    }

    public String s(String str, boolean z2, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("Referer", str2);
        return t(str, z2, hashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
        if (r6.containsKey("range") != false) goto L_0x003d;
     */
    @java.lang.SafeVarargs
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String t(java.lang.String r8, boolean r9, java.util.Map<java.lang.String, java.lang.String>... r10) {
        /*
            r7 = this;
            r0 = 0
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x0052 }
            r6.<init>()     // Catch:{ all -> 0x0052 }
            if (r10 == 0) goto L_0x0012
            int r1 = r10.length     // Catch:{ all -> 0x0052 }
            if (r1 <= 0) goto L_0x0012
            r10 = r10[r0]     // Catch:{ all -> 0x0052 }
            if (r10 == 0) goto L_0x0012
            r6.putAll(r10)     // Catch:{ all -> 0x0052 }
        L_0x0012:
            if (r9 == 0) goto L_0x001d
            boolean r10 = com.original.tase.utils.SourceObservableUtils.c(r8)     // Catch:{ all -> 0x0052 }
            if (r10 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r4 = 0
            goto L_0x001e
        L_0x001d:
            r4 = r9
        L_0x001e:
            java.lang.String r9 = "Range"
            if (r4 != 0) goto L_0x0027
            java.lang.String r10 = "bytes=0-1"
            r6.put(r9, r10)     // Catch:{ all -> 0x0052 }
        L_0x0027:
            okhttp3.Response r10 = r7.w(r8, r4, r6)     // Catch:{ all -> 0x0052 }
            if (r10 != 0) goto L_0x0049
            if (r4 != 0) goto L_0x0049
            boolean r1 = r6.containsKey(r9)     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = "range"
            if (r1 != 0) goto L_0x003d
            boolean r1 = r6.containsKey(r2)     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x0049
        L_0x003d:
            r6.remove(r9)     // Catch:{ all -> 0x0052 }
            r6.remove(r2)     // Catch:{ all -> 0x0052 }
            okhttp3.Response r9 = r7.w(r8, r4, r6)     // Catch:{ all -> 0x0052 }
            r2 = r9
            goto L_0x004a
        L_0x0049:
            r2 = r10
        L_0x004a:
            r5 = 1
            r1 = r7
            r3 = r8
            java.lang.String r8 = r1.v(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0052 }
            goto L_0x0058
        L_0x0052:
            r9 = move-exception
            boolean[] r10 = new boolean[r0]
            com.original.tase.Logger.d(r9, r10)
        L_0x0058:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.http.HttpHelper.t(java.lang.String, boolean, java.util.Map[]):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ce A[Catch:{ all -> 0x00ba, all -> 0x00dc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String u(okhttp3.Request r9) {
        /*
            r8 = this;
            r0 = 0
            int[] r1 = new int[r0]
            okhttp3.Response r1 = r8.x(r9, r1)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x000c
            return r2
        L_0x000c:
            okhttp3.HttpUrl r3 = r9.url()
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "yesmovie"
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L_0x0055
            java.lang.String r3 = "set-cookie"
            java.lang.String r3 = r1.header(r3)
            if (r3 == 0) goto L_0x0055
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0055
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            okhttp3.HttpUrl r5 = r9.url()
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r8.g(r5)
            r4.append(r5)
            java.lang.String r5 = ";"
            r4.append(r5)
            okhttp3.HttpUrl r5 = r9.url()
            java.lang.String r5 = r5.toString()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r8.D(r4, r3)
        L_0x0055:
            int r3 = r1.code()
            r4 = 404(0x194, float:5.66E-43)
            if (r3 == r4) goto L_0x0115
            int r3 = r1.code()
            r4 = 400(0x190, float:5.6E-43)
            if (r3 != r4) goto L_0x0067
            goto L_0x0115
        L_0x0067:
            int r3 = r1.code()
            r4 = 500(0x1f4, float:7.0E-43)
            if (r3 < r4) goto L_0x0088
            okhttp3.HttpUrl r3 = r9.url()     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = "/api.thetvdb.com/"
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x0082 }
            if (r3 == 0) goto L_0x0088
            java.lang.String r9 = "TvdbApi Error"
            return r9
        L_0x0082:
            r3 = move-exception
            boolean[] r4 = new boolean[r0]
            com.original.tase.Logger.d(r3, r4)
        L_0x0088:
            java.lang.String r3 = r9.method()     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = "GET"
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ all -> 0x00dc }
            if (r3 != 0) goto L_0x00a0
            java.lang.String r3 = r9.method()     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = "POST"
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x00e2
        L_0x00a0:
            java.lang.String r3 = "Range"
            java.util.List r3 = r9.headers(r3)     // Catch:{ all -> 0x00ba }
            int r3 = r3.size()     // Catch:{ all -> 0x00ba }
            if (r3 > 0) goto L_0x00b8
            java.lang.String r3 = "range"
            java.util.List r3 = r9.headers(r3)     // Catch:{ all -> 0x00ba }
            int r3 = r3.size()     // Catch:{ all -> 0x00ba }
            if (r3 <= 0) goto L_0x00c0
        L_0x00b8:
            r3 = 1
            goto L_0x00c1
        L_0x00ba:
            r3 = move-exception
            boolean[] r4 = new boolean[r0]     // Catch:{ all -> 0x00dc }
            com.original.tase.Logger.d(r3, r4)     // Catch:{ all -> 0x00dc }
        L_0x00c0:
            r3 = 0
        L_0x00c1:
            boolean[] r4 = new boolean[r0]     // Catch:{ all -> 0x00dc }
            long r3 = h(r1, r3, r4)     // Catch:{ all -> 0x00dc }
            r5 = 10485760(0xa00000, double:5.180654E-317)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x00e2
            okhttp3.ResponseBody r3 = r1.body()     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x00db
            okhttp3.ResponseBody r3 = r1.body()     // Catch:{ all -> 0x00dc }
            r3.close()     // Catch:{ all -> 0x00dc }
        L_0x00db:
            return r2
        L_0x00dc:
            r3 = move-exception
            boolean[] r4 = new boolean[r0]
            com.original.tase.Logger.d(r3, r4)
        L_0x00e2:
            okhttp3.ResponseBody r3 = r1.body()     // Catch:{ all -> 0x00eb }
            java.lang.String r2 = r3.string()     // Catch:{ all -> 0x00eb }
            goto L_0x00f1
        L_0x00eb:
            r3 = move-exception
            boolean[] r0 = new boolean[r0]
            com.original.tase.Logger.d(r3, r0)
        L_0x00f1:
            okhttp3.ResponseBody r0 = r1.body()
            if (r0 != 0) goto L_0x00f8
            return r2
        L_0x00f8:
            okhttp3.ResponseBody r0 = r1.body()
            r0.close()
            java.lang.String r0 = "Attention Required! | Cloudflare"
            boolean r0 = r2.contains(r0)
            if (r0 == 0) goto L_0x0114
            okhttp3.HttpUrl r9 = r9.url()
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = "Need Verify Recaptcha"
            com.original.tase.Logger.b(r0, r9)
        L_0x0114:
            return r2
        L_0x0115:
            okhttp3.ResponseBody r9 = r1.body()     // Catch:{ all -> 0x011e }
            java.lang.String r2 = r9.string()     // Catch:{ all -> 0x011e }
            goto L_0x0124
        L_0x011e:
            r9 = move-exception
            boolean[] r0 = new boolean[r0]
            com.original.tase.Logger.d(r9, r0)
        L_0x0124:
            okhttp3.ResponseBody r9 = r1.body()
            if (r9 == 0) goto L_0x0131
            okhttp3.ResponseBody r9 = r1.body()
            r9.close()
        L_0x0131:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.http.HttpHelper.u(okhttp3.Request):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
        if (n(r9, r3) == false) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String v(okhttp3.Response r8, java.lang.String r9, boolean r10, boolean r11, java.util.Map<java.lang.String, java.lang.String> r12) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x000f
            okhttp3.Response r1 = r8.priorResponse()     // Catch:{ all -> 0x0008 }
            goto L_0x0010
        L_0x0008:
            r8 = move-exception
            boolean[] r10 = new boolean[r0]
            com.original.tase.Logger.d(r8, r10)
            return r9
        L_0x000f:
            r1 = 0
        L_0x0010:
            if (r8 == 0) goto L_0x001f
            okhttp3.ResponseBody r2 = r8.body()
            if (r2 == 0) goto L_0x001f
            okhttp3.ResponseBody r2 = r8.body()
            r2.close()
        L_0x001f:
            if (r1 == 0) goto L_0x002e
            okhttp3.ResponseBody r2 = r1.body()
            if (r2 == 0) goto L_0x002e
            okhttp3.ResponseBody r2 = r1.body()
            r2.close()
        L_0x002e:
            java.lang.String r2 = ""
            if (r8 == 0) goto L_0x0051
            okhttp3.ResponseBody r3 = r8.body()
            if (r3 == 0) goto L_0x0051
            okhttp3.Request r3 = r8.request()
            okhttp3.HttpUrl r3 = r3.url()
            java.lang.String r3 = r3.toString()
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0051
            boolean r4 = r7.n(r9, r3)
            if (r4 != 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r3 = r2
        L_0x0052:
            boolean r4 = r3.isEmpty()
            java.lang.String r5 = "location"
            if (r4 != 0) goto L_0x0060
            boolean r4 = r7.n(r3, r9)
            if (r4 == 0) goto L_0x0083
        L_0x0060:
            if (r1 == 0) goto L_0x0083
            java.lang.String r4 = "Location"
            java.lang.String r4 = r8.header(r4, r2)
            if (r4 == 0) goto L_0x0070
            boolean r6 = r4.isEmpty()
            if (r6 == 0) goto L_0x0074
        L_0x0070:
            java.lang.String r4 = r1.header(r5, r2)
        L_0x0074:
            if (r4 == 0) goto L_0x0083
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L_0x0083
            boolean r1 = r7.n(r9, r4)
            if (r1 != 0) goto L_0x0083
            r3 = r4
        L_0x0083:
            if (r11 == 0) goto L_0x00af
            boolean r11 = r3.isEmpty()
            if (r11 != 0) goto L_0x0091
            boolean r11 = r7.n(r9, r3)
            if (r11 == 0) goto L_0x00af
        L_0x0091:
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ all -> 0x00af }
            r11.<init>()     // Catch:{ all -> 0x00af }
            if (r12 == 0) goto L_0x009b
            r11.putAll(r12)     // Catch:{ all -> 0x00af }
        L_0x009b:
            boolean r12 = com.original.tase.utils.SourceObservableUtils.c(r9)     // Catch:{ all -> 0x00af }
            if (r12 == 0) goto L_0x00a2
            r0 = r10
        L_0x00a2:
            if (r10 != 0) goto L_0x00ab
            java.lang.String r10 = "Range"
            java.lang.String r12 = "bytes=0-1"
            r11.put(r10, r12)     // Catch:{ all -> 0x00af }
        L_0x00ab:
            java.lang.String r3 = com.original.tase.helper.http.HttpHelper.Network.a(r9, r0, r11)     // Catch:{ all -> 0x00af }
        L_0x00af:
            if (r8 == 0) goto L_0x00be
            java.lang.String r8 = r8.header(r5, r2)
            if (r8 == 0) goto L_0x00be
            boolean r9 = r8.isEmpty()
            if (r9 != 0) goto L_0x00be
            r3 = r8
        L_0x00be:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.http.HttpHelper.v(okhttp3.Response, java.lang.String, boolean, boolean, java.util.Map):java.lang.String");
    }

    public Response w(String str, boolean z2, Map<String, String> map) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        Request.Builder tag = new Request.Builder().url(str).addHeader("User-Agent", Constants.C).tag(f33895d);
        if (z2) {
            tag = tag.head();
        }
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()).toLowerCase().equals("user-agent")) {
                    tag.header("User-Agent", (String) next.getValue());
                } else {
                    tag.addHeader((String) next.getKey(), (String) next.getValue());
                }
            }
        }
        return x(tag.build(), new int[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0103 A[Catch:{ all -> 0x015d, all -> 0x0166 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0104 A[ADDED_TO_REGION, Catch:{ all -> 0x015d, all -> 0x0166 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response x(okhttp3.Request r11, int... r12) {
        /*
            r10 = this;
            r0 = 0
            if (r12 == 0) goto L_0x000a
            int r1 = r12.length
            if (r1 > 0) goto L_0x0007
            goto L_0x000a
        L_0x0007:
            r12 = r12[r0]
            goto L_0x000b
        L_0x000a:
            r12 = 0
        L_0x000b:
            r1 = 1
            if (r12 <= 0) goto L_0x0010
            r2 = 1
            goto L_0x0011
        L_0x0010:
            r2 = 0
        L_0x0011:
            r3 = 0
            okhttp3.OkHttpClient r4 = r10.f33897b     // Catch:{ all -> 0x00f4 }
            okhttp3.HttpUrl r5 = r11.url()     // Catch:{ all -> 0x00f4 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00f4 }
            java.lang.String r6 = "/api.thetvdb.com/"
            boolean r5 = r5.contains(r6)     // Catch:{ all -> 0x00f4 }
            if (r5 == 0) goto L_0x003d
            okhttp3.OkHttpClient$Builder r4 = r4.newBuilder()     // Catch:{ all -> 0x00f4 }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x00f4 }
            r6 = 30
            okhttp3.OkHttpClient$Builder r4 = r4.connectTimeout(r6, r5)     // Catch:{ all -> 0x00f4 }
            okhttp3.OkHttpClient$Builder r4 = r4.writeTimeout(r6, r5)     // Catch:{ all -> 0x00f4 }
            okhttp3.OkHttpClient$Builder r4 = r4.readTimeout(r6, r5)     // Catch:{ all -> 0x00f4 }
            okhttp3.OkHttpClient r4 = r4.build()     // Catch:{ all -> 0x00f4 }
            goto L_0x0075
        L_0x003d:
            okhttp3.HttpUrl r5 = r11.url()     // Catch:{ all -> 0x00f4 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00f4 }
            java.lang.String r6 = ".gomovieshd.to/"
            boolean r5 = r5.contains(r6)     // Catch:{ all -> 0x00f4 }
            if (r5 != 0) goto L_0x005d
            okhttp3.HttpUrl r5 = r11.url()     // Catch:{ all -> 0x00f4 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00f4 }
            java.lang.String r6 = ".cmovieshd.com/"
            boolean r5 = r5.contains(r6)     // Catch:{ all -> 0x00f4 }
            if (r5 == 0) goto L_0x0075
        L_0x005d:
            okhttp3.OkHttpClient$Builder r4 = r4.newBuilder()     // Catch:{ all -> 0x00f4 }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x00f4 }
            r6 = 10
            okhttp3.OkHttpClient$Builder r4 = r4.connectTimeout(r6, r5)     // Catch:{ all -> 0x00f4 }
            okhttp3.OkHttpClient$Builder r4 = r4.readTimeout(r6, r5)     // Catch:{ all -> 0x00f4 }
            okhttp3.OkHttpClient$Builder r4 = r4.writeTimeout(r6, r5)     // Catch:{ all -> 0x00f4 }
            okhttp3.OkHttpClient r4 = r4.build()     // Catch:{ all -> 0x00f4 }
        L_0x0075:
            okhttp3.Call r4 = r4.newCall(r11)     // Catch:{ all -> 0x00f4 }
            okhttp3.Response r4 = r4.execute()     // Catch:{ all -> 0x00f4 }
            if (r4 != 0) goto L_0x0080
            return r3
        L_0x0080:
            int r5 = r4.code()     // Catch:{ all -> 0x00ef }
            r6 = 429(0x1ad, float:6.01E-43)
            if (r5 != r6) goto L_0x00ee
            if (r2 != 0) goto L_0x008c
            r5 = 1
            goto L_0x008d
        L_0x008c:
            r5 = 0
        L_0x008d:
            okhttp3.HttpUrl r6 = r11.url()     // Catch:{ all -> 0x00ef }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00ef }
            boolean r7 = com.original.tase.helper.GoogleVideoHelper.n(r6)     // Catch:{ all -> 0x00ef }
            if (r7 == 0) goto L_0x00bc
            boolean r7 = com.original.tase.helper.GoogleVideoHelper.l(r6)     // Catch:{ all -> 0x00ef }
            if (r7 == 0) goto L_0x00a4
            r7 = 20
            goto L_0x00ad
        L_0x00a4:
            boolean r7 = com.original.tase.helper.GoogleVideoHelper.b(r6)     // Catch:{ all -> 0x00ef }
            if (r7 == 0) goto L_0x00ac
            r7 = 5
            goto L_0x00ad
        L_0x00ac:
            r7 = 2
        L_0x00ad:
            boolean r8 = com.original.tase.helper.GoogleVideoHelper.e(r6)     // Catch:{ all -> 0x00ef }
            if (r8 != 0) goto L_0x00b9
            boolean r6 = com.original.tase.helper.GoogleVideoHelper.f(r6)     // Catch:{ all -> 0x00ef }
            if (r6 == 0) goto L_0x00bc
        L_0x00b9:
            if (r12 >= r7) goto L_0x00bc
            r5 = 1
        L_0x00bc:
            if (r5 == 0) goto L_0x00ed
            okhttp3.ResponseBody r5 = r4.body()     // Catch:{ all -> 0x00ef }
            if (r5 == 0) goto L_0x00cb
            okhttp3.ResponseBody r5 = r4.body()     // Catch:{ all -> 0x00ef }
            r5.close()     // Catch:{ all -> 0x00ef }
        L_0x00cb:
            int r12 = r12 + 1
            okhttp3.Request$Builder r5 = r11.newBuilder()     // Catch:{ all -> 0x00e4 }
            okhttp3.CacheControl r6 = okhttp3.CacheControl.FORCE_NETWORK     // Catch:{ all -> 0x00e4 }
            okhttp3.Request$Builder r5 = r5.cacheControl(r6)     // Catch:{ all -> 0x00e4 }
            okhttp3.Request r5 = r5.build()     // Catch:{ all -> 0x00e4 }
            int[] r6 = new int[r1]     // Catch:{ all -> 0x00e4 }
            r6[r0] = r12     // Catch:{ all -> 0x00e4 }
            okhttp3.Response r11 = r10.x(r5, r6)     // Catch:{ all -> 0x00e4 }
            return r11
        L_0x00e4:
            r5 = move-exception
            boolean[] r6 = new boolean[r1]     // Catch:{ all -> 0x00ef }
            r6[r0] = r1     // Catch:{ all -> 0x00ef }
            com.original.tase.Logger.d(r5, r6)     // Catch:{ all -> 0x00ef }
            return r4
        L_0x00ed:
            return r3
        L_0x00ee:
            return r4
        L_0x00ef:
            r5 = move-exception
            r9 = r5
            r5 = r4
            r4 = r9
            goto L_0x00f6
        L_0x00f4:
            r4 = move-exception
            r5 = r3
        L_0x00f6:
            boolean[] r6 = new boolean[r1]     // Catch:{ all -> 0x0166 }
            boolean r7 = r4 instanceof java.lang.StackOverflowError     // Catch:{ all -> 0x0166 }
            r6[r0] = r7     // Catch:{ all -> 0x0166 }
            com.original.tase.Logger.d(r4, r6)     // Catch:{ all -> 0x0166 }
            boolean r6 = r4 instanceof java.lang.StackOverflowError     // Catch:{ all -> 0x0166 }
            if (r6 == 0) goto L_0x0104
            return r3
        L_0x0104:
            if (r5 == 0) goto L_0x0113
            okhttp3.ResponseBody r6 = r5.body()     // Catch:{ all -> 0x0166 }
            if (r6 == 0) goto L_0x0113
            okhttp3.ResponseBody r5 = r5.body()     // Catch:{ all -> 0x0166 }
            r5.close()     // Catch:{ all -> 0x0166 }
        L_0x0113:
            if (r2 == 0) goto L_0x0116
            return r3
        L_0x0116:
            boolean r2 = r4 instanceof java.io.IOException     // Catch:{ all -> 0x0166 }
            if (r2 == 0) goto L_0x0132
            java.lang.String r2 = r4.getMessage()     // Catch:{ all -> 0x0166 }
            if (r2 == 0) goto L_0x0132
            java.lang.String r2 = r4.getMessage()     // Catch:{ all -> 0x0166 }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ all -> 0x0166 }
            java.lang.String r4 = "unexpected end of stream on"
            boolean r2 = r2.contains(r4)     // Catch:{ all -> 0x0166 }
            if (r2 == 0) goto L_0x0132
            r2 = 1
            goto L_0x0133
        L_0x0132:
            r2 = 0
        L_0x0133:
            if (r2 == 0) goto L_0x0165
            int r12 = r12 + r1
            okhttp3.Request$Builder r11 = r11.newBuilder()     // Catch:{ all -> 0x015d }
            java.lang.String r2 = "X-Request-CC"
            java.lang.String r4 = "true"
            okhttp3.Request$Builder r11 = r11.addHeader(r2, r4)     // Catch:{ all -> 0x015d }
            java.lang.String r2 = "Connection"
            java.lang.String r4 = "close"
            okhttp3.Request$Builder r11 = r11.addHeader(r2, r4)     // Catch:{ all -> 0x015d }
            okhttp3.CacheControl r2 = okhttp3.CacheControl.FORCE_NETWORK     // Catch:{ all -> 0x015d }
            okhttp3.Request$Builder r11 = r11.cacheControl(r2)     // Catch:{ all -> 0x015d }
            okhttp3.Request r11 = r11.build()     // Catch:{ all -> 0x015d }
            int[] r2 = new int[r1]     // Catch:{ all -> 0x015d }
            r2[r0] = r12     // Catch:{ all -> 0x015d }
            okhttp3.Response r11 = r10.x(r11, r2)     // Catch:{ all -> 0x015d }
            return r11
        L_0x015d:
            r11 = move-exception
            boolean[] r12 = new boolean[r1]     // Catch:{ all -> 0x0166 }
            r12[r0] = r1     // Catch:{ all -> 0x0166 }
            com.original.tase.Logger.d(r11, r12)     // Catch:{ all -> 0x0166 }
        L_0x0165:
            return r3
        L_0x0166:
            r11 = move-exception
            boolean[] r12 = new boolean[r0]
            com.original.tase.Logger.d(r11, r12)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.http.HttpHelper.x(okhttp3.Request, int[]):okhttp3.Response");
    }

    @SafeVarargs
    public final String y(String str, RequestBody requestBody, Map<String, String>... mapArr) {
        return j(str, requestBody, false, mapArr);
    }

    public void z(Object obj) {
        for (Call next : this.f33897b.dispatcher().queuedCalls()) {
            if (next.request().tag() != null && next.request().tag().equals(obj)) {
                next.cancel();
            }
        }
        for (Call next2 : this.f33897b.dispatcher().runningCalls()) {
            if (next2.request().tag() != null && next2.request().tag().equals(obj)) {
                next2.cancel();
            }
        }
    }
}
