package androidx.media3.exoplayer.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource$InvalidResponseCodeException;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.ByteStreams;
import com.uwetrottmann.trakt5.TraktV2;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class HttpMediaDrmCallback implements MediaDrmCallback {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource.Factory f6243a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6244b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f6245c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, String> f6246d;

    public HttpMediaDrmCallback(String str, boolean z2, DataSource.Factory factory) {
        boolean z3;
        if (!z2 || !TextUtils.isEmpty(str)) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.a(z3);
        this.f6243a = factory;
        this.f6244b = str;
        this.f6245c = z2;
        this.f6246d = new HashMap();
    }

    private static byte[] c(DataSource.Factory factory, String str, byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        DataSourceInputStream dataSourceInputStream;
        StatsDataSource statsDataSource = new StatsDataSource(factory.a());
        DataSpec a2 = new DataSpec.Builder().j(str).e(map).d(2).c(bArr).b(1).a();
        int i2 = 0;
        DataSpec dataSpec = a2;
        while (true) {
            try {
                dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpec);
                byte[] d2 = ByteStreams.d(dataSourceInputStream);
                Util.m(dataSourceInputStream);
                return d2;
            } catch (HttpDataSource$InvalidResponseCodeException e2) {
                String d3 = d(e2, i2);
                if (d3 != null) {
                    i2++;
                    dataSpec = dataSpec.a().j(d3).a();
                    Util.m(dataSourceInputStream);
                } else {
                    throw e2;
                }
            } catch (Exception e3) {
                throw new MediaDrmCallbackException(a2, (Uri) Assertions.f(statsDataSource.p()), statsDataSource.d(), statsDataSource.o(), e3);
            } catch (Throwable th) {
                Util.m(dataSourceInputStream);
                throw th;
            }
        }
    }

    private static String d(HttpDataSource$InvalidResponseCodeException httpDataSource$InvalidResponseCodeException, int i2) {
        boolean z2;
        Map<String, List<String>> map;
        List list;
        int i3 = httpDataSource$InvalidResponseCodeException.f4892e;
        if ((i3 == 307 || i3 == 308) && i2 < 5) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && (map = httpDataSource$InvalidResponseCodeException.f4894g) != null && (list = map.get("Location")) != null && !list.isEmpty()) {
            return (String) list.get(0);
        }
        return null;
    }

    public byte[] a(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException {
        String str;
        String b2 = keyRequest.b();
        if (this.f6245c || TextUtils.isEmpty(b2)) {
            b2 = this.f6244b;
        }
        if (!TextUtils.isEmpty(b2)) {
            HashMap hashMap = new HashMap();
            UUID uuid2 = C.f3934e;
            if (uuid2.equals(uuid)) {
                str = "text/xml";
            } else if (C.f3932c.equals(uuid)) {
                str = TraktV2.CONTENT_TYPE_JSON;
            } else {
                str = "application/octet-stream";
            }
            hashMap.put(TraktV2.HEADER_CONTENT_TYPE, str);
            if (uuid2.equals(uuid)) {
                hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            synchronized (this.f6246d) {
                hashMap.putAll(this.f6246d);
            }
            return c(this.f6243a, b2, keyRequest.a(), hashMap);
        }
        throw new MediaDrmCallbackException(new DataSpec.Builder().i(Uri.EMPTY).a(), Uri.EMPTY, ImmutableMap.k(), 0, new IllegalStateException("No license URL"));
    }

    public byte[] b(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws MediaDrmCallbackException {
        return c(this.f6243a, provisionRequest.b() + "&signedRequest=" + Util.H(provisionRequest.a()), (byte[]) null, Collections.emptyMap());
    }

    public void e(String str, String str2) {
        Assertions.f(str);
        Assertions.f(str2);
        synchronized (this.f6246d) {
            this.f6246d.put(str, str2);
        }
    }
}
