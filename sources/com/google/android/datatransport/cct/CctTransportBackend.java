package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.hermes.intl.Constants;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.LogResponse;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

final class CctTransportBackend implements TransportBackend {

    /* renamed from: a  reason: collision with root package name */
    private final DataEncoder f22274a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f22275b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f22276c;

    /* renamed from: d  reason: collision with root package name */
    final URL f22277d;

    /* renamed from: e  reason: collision with root package name */
    private final Clock f22278e;

    /* renamed from: f  reason: collision with root package name */
    private final Clock f22279f;

    /* renamed from: g  reason: collision with root package name */
    private final int f22280g;

    static final class HttpRequest {

        /* renamed from: a  reason: collision with root package name */
        final URL f22281a;

        /* renamed from: b  reason: collision with root package name */
        final BatchedLogRequest f22282b;

        /* renamed from: c  reason: collision with root package name */
        final String f22283c;

        HttpRequest(URL url, BatchedLogRequest batchedLogRequest, String str) {
            this.f22281a = url;
            this.f22282b = batchedLogRequest;
            this.f22283c = str;
        }

        /* access modifiers changed from: package-private */
        public HttpRequest a(URL url) {
            return new HttpRequest(url, this.f22282b, this.f22283c);
        }
    }

    static final class HttpResponse {

        /* renamed from: a  reason: collision with root package name */
        final int f22284a;

        /* renamed from: b  reason: collision with root package name */
        final URL f22285b;

        /* renamed from: c  reason: collision with root package name */
        final long f22286c;

        HttpResponse(int i2, URL url, long j2) {
            this.f22284a = i2;
            this.f22285b = url;
            this.f22286c = j2;
        }
    }

    CctTransportBackend(Context context, Clock clock, Clock clock2, int i2) {
        this.f22274a = BatchedLogRequest.b();
        this.f22276c = context;
        this.f22275b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f22277d = n(CCTDestination.f22266c);
        this.f22278e = clock2;
        this.f22279f = clock;
        this.f22280g = i2;
    }

    /* access modifiers changed from: private */
    public HttpResponse e(HttpRequest httpRequest) throws IOException {
        GZIPOutputStream gZIPOutputStream;
        InputStream m2;
        Logging.a("CctTransportBackend", "Making request to: %s", httpRequest.f22281a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpRequest.f22281a.openConnection();
        httpURLConnection.setConnectTimeout(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
        httpURLConnection.setReadTimeout(this.f22280g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", new Object[]{"3.1.3"}));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty(TraktV2.HEADER_CONTENT_TYPE, TraktV2.CONTENT_TYPE_JSON);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = httpRequest.f22283c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream);
                this.f22274a.a(httpRequest.f22282b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                gZIPOutputStream.close();
                if (outputStream != null) {
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                Logging.e("CctTransportBackend", "Status Code: " + responseCode);
                Logging.e("CctTransportBackend", "Content-Type: " + httpURLConnection.getHeaderField(TraktV2.HEADER_CONTENT_TYPE));
                Logging.e("CctTransportBackend", "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                    return new HttpResponse(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0);
                }
                if (responseCode != 200) {
                    return new HttpResponse(responseCode, (URL) null, 0);
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    m2 = m(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                    HttpResponse httpResponse = new HttpResponse(responseCode, (URL) null, LogResponse.b(new BufferedReader(new InputStreamReader(m2))).c());
                    if (m2 != null) {
                        m2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return httpResponse;
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
                throw th;
            } catch (Throwable th3) {
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th3;
            }
        } catch (ConnectException | UnknownHostException e2) {
            Logging.c("CctTransportBackend", "Couldn't open connection, returning with 500", e2);
            return new HttpResponse(500, (URL) null, 0);
        } catch (EncodingException | IOException e3) {
            Logging.c("CctTransportBackend", "Couldn't encode request, returning with 400", e3);
            return new HttpResponse(400, (URL) null, 0);
        } catch (Throwable th4) {
            th3.addSuppressed(th4);
        }
    }

    private static int f(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.b();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.b();
        }
        if (NetworkConnectionInfo.MobileSubtype.a(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private static int g(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.NetworkType.NONE.b();
        }
        return networkInfo.getType();
    }

    private static int h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            Logging.c("CctTransportBackend", "Unable to find version code for package", e2);
            return -1;
        }
    }

    private BatchedLogRequest i(BackendRequest backendRequest) {
        LogEvent.Builder builder;
        HashMap hashMap = new HashMap();
        for (EventInternal next : backendRequest.b()) {
            String j2 = next.j();
            if (!hashMap.containsKey(j2)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(j2, arrayList);
            } else {
                ((List) hashMap.get(j2)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal = (EventInternal) ((List) entry.getValue()).get(0);
            LogRequest.Builder b2 = LogRequest.a().f(QosTier.DEFAULT).g(this.f22279f.a()).h(this.f22278e.a()).b(ClientInfo.a().c(ClientInfo.ClientType.ANDROID_FIREBASE).b(AndroidClientInfo.a().m(Integer.valueOf(eventInternal.g("sdk-version"))).j(eventInternal.b("model")).f(eventInternal.b("hardware")).d(eventInternal.b("device")).l(eventInternal.b(AppLovinEventTypes.USER_VIEWED_PRODUCT)).k(eventInternal.b("os-uild")).h(eventInternal.b("manufacturer")).e(eventInternal.b("fingerprint")).c(eventInternal.b("country")).g(eventInternal.b(Constants.LOCALE)).i(eventInternal.b("mcc_mnc")).b(eventInternal.b("application_build")).a()).a());
            try {
                b2.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                b2.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal2 : (List) entry.getValue()) {
                EncodedPayload e2 = eventInternal2.e();
                Encoding b3 = e2.b();
                if (b3.equals(Encoding.b("proto"))) {
                    builder = LogEvent.j(e2.a());
                } else if (b3.equals(Encoding.b("json"))) {
                    builder = LogEvent.i(new String(e2.a(), Charset.forName("UTF-8")));
                } else {
                    Logging.f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b3);
                }
                builder.c(eventInternal2.f()).d(eventInternal2.k()).h(eventInternal2.h("tz-offset")).e(NetworkConnectionInfo.a().c(NetworkConnectionInfo.NetworkType.a(eventInternal2.g("net-type"))).b(NetworkConnectionInfo.MobileSubtype.a(eventInternal2.g("mobile-subtype"))).a());
                if (eventInternal2.d() != null) {
                    builder.b(eventInternal2.d());
                }
                arrayList3.add(builder.a());
            }
            b2.c(arrayList3);
            arrayList2.add(b2.a());
        }
        return BatchedLogRequest.a(arrayList2);
    }

    private static TelephonyManager j(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    static long k() {
        Calendar.getInstance();
        return (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ HttpRequest l(HttpRequest httpRequest, HttpResponse httpResponse) {
        URL url = httpResponse.f22285b;
        if (url == null) {
            return null;
        }
        Logging.a("CctTransportBackend", "Following redirect to: %s", url);
        return httpRequest.a(httpResponse.f22285b);
    }

    private static InputStream m(InputStream inputStream, String str) throws IOException {
        if ("gzip".equals(str)) {
            return new GZIPInputStream(inputStream);
        }
        return inputStream;
    }

    private static URL n(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Invalid url: " + str, e2);
        }
    }

    public EventInternal a(EventInternal eventInternal) {
        NetworkInfo activeNetworkInfo = this.f22275b.getActiveNetworkInfo();
        return eventInternal.l().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c(AppLovinEventTypes.USER_VIEWED_PRODUCT, Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", k()).a("net-type", g(activeNetworkInfo)).a("mobile-subtype", f(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c(Constants.LOCALE, Locale.getDefault().getLanguage()).c("mcc_mnc", j(this.f22276c).getSimOperator()).c("application_build", Integer.toString(h(this.f22276c))).d();
    }

    public BackendResponse b(BackendRequest backendRequest) {
        BatchedLogRequest i2 = i(backendRequest);
        URL url = this.f22277d;
        String str = null;
        if (backendRequest.c() != null) {
            try {
                CCTDestination c2 = CCTDestination.c(backendRequest.c());
                if (c2.d() != null) {
                    str = c2.d();
                }
                if (c2.e() != null) {
                    url = n(c2.e());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.a();
            }
        }
        try {
            HttpResponse httpResponse = (HttpResponse) Retries.a(5, new HttpRequest(url, i2, str), new a(this), new b());
            int i3 = httpResponse.f22284a;
            if (i3 == 200) {
                return BackendResponse.e(httpResponse.f22286c);
            }
            if (i3 < 500) {
                if (i3 != 404) {
                    if (i3 == 400) {
                        return BackendResponse.d();
                    }
                    return BackendResponse.a();
                }
            }
            return BackendResponse.f();
        } catch (IOException e2) {
            Logging.c("CctTransportBackend", "Could not make request to the backend", e2);
            return BackendResponse.f();
        }
    }

    CctTransportBackend(Context context, Clock clock, Clock clock2) {
        this(context, clock, clock2, 40000);
    }
}
