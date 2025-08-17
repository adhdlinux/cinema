package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableMap;
import com.uwetrottmann.trakt5.TraktV2;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class HttpMediaDrmCallback implements MediaDrmCallback {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource.Factory f24107a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24108b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f24109c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, String> f24110d;

    public HttpMediaDrmCallback(String str, boolean z2, DataSource.Factory factory) {
        boolean z3;
        if (!z2 || !TextUtils.isEmpty(str)) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.a(z3);
        this.f24107a = factory;
        this.f24108b = str;
        this.f24109c = z2;
        this.f24110d = new HashMap();
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
                byte[] c12 = Util.c1(dataSourceInputStream);
                Util.n(dataSourceInputStream);
                return c12;
            } catch (HttpDataSource$InvalidResponseCodeException e2) {
                String d2 = d(e2, i2);
                if (d2 != null) {
                    i2++;
                    dataSpec = dataSpec.a().j(d2).a();
                    Util.n(dataSourceInputStream);
                } else {
                    throw e2;
                }
            } catch (Exception e3) {
                throw new MediaDrmCallbackException(a2, (Uri) Assertions.e(statsDataSource.s()), statsDataSource.d(), statsDataSource.q(), e3);
            } catch (Throwable th) {
                Util.n(dataSourceInputStream);
                throw th;
            }
        }
    }

    private static String d(HttpDataSource$InvalidResponseCodeException httpDataSource$InvalidResponseCodeException, int i2) {
        boolean z2;
        Map<String, List<String>> map;
        List list;
        int i3 = httpDataSource$InvalidResponseCodeException.f28444e;
        if ((i3 == 307 || i3 == 308) && i2 < 5) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && (map = httpDataSource$InvalidResponseCodeException.f28446g) != null && (list = map.get("Location")) != null && !list.isEmpty()) {
            return (String) list.get(0);
        }
        return null;
    }

    public byte[] a(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws MediaDrmCallbackException {
        return c(this.f24107a, provisionRequest.b() + "&signedRequest=" + Util.D(provisionRequest.a()), (byte[]) null, Collections.emptyMap());
    }

    public byte[] b(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException {
        String str;
        String b2 = keyRequest.b();
        if (this.f24109c || TextUtils.isEmpty(b2)) {
            b2 = this.f24108b;
        }
        if (!TextUtils.isEmpty(b2)) {
            HashMap hashMap = new HashMap();
            UUID uuid2 = C.f22820e;
            if (uuid2.equals(uuid)) {
                str = "text/xml";
            } else if (C.f22818c.equals(uuid)) {
                str = TraktV2.CONTENT_TYPE_JSON;
            } else {
                str = "application/octet-stream";
            }
            hashMap.put(TraktV2.HEADER_CONTENT_TYPE, str);
            if (uuid2.equals(uuid)) {
                hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            synchronized (this.f24110d) {
                hashMap.putAll(this.f24110d);
            }
            return c(this.f24107a, b2, keyRequest.a(), hashMap);
        }
        throw new MediaDrmCallbackException(new DataSpec.Builder().i(Uri.EMPTY).a(), Uri.EMPTY, ImmutableMap.k(), 0, new IllegalStateException("No license URL"));
    }

    public void e(String str, String str2) {
        Assertions.e(str);
        Assertions.e(str2);
        synchronized (this.f24110d) {
            this.f24110d.put(str, str2);
        }
    }
}
