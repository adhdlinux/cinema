package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DefaultDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final Context f28394a;

    /* renamed from: b  reason: collision with root package name */
    private final List<TransferListener> f28395b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final DataSource f28396c;

    /* renamed from: d  reason: collision with root package name */
    private DataSource f28397d;

    /* renamed from: e  reason: collision with root package name */
    private DataSource f28398e;

    /* renamed from: f  reason: collision with root package name */
    private DataSource f28399f;

    /* renamed from: g  reason: collision with root package name */
    private DataSource f28400g;

    /* renamed from: h  reason: collision with root package name */
    private DataSource f28401h;

    /* renamed from: i  reason: collision with root package name */
    private DataSource f28402i;

    /* renamed from: j  reason: collision with root package name */
    private DataSource f28403j;

    /* renamed from: k  reason: collision with root package name */
    private DataSource f28404k;

    public static final class Factory implements DataSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final Context f28405a;

        /* renamed from: b  reason: collision with root package name */
        private final DataSource.Factory f28406b;

        /* renamed from: c  reason: collision with root package name */
        private TransferListener f28407c;

        public Factory(Context context) {
            this(context, new DefaultHttpDataSource.Factory());
        }

        /* renamed from: b */
        public DefaultDataSource a() {
            DefaultDataSource defaultDataSource = new DefaultDataSource(this.f28405a, this.f28406b.a());
            TransferListener transferListener = this.f28407c;
            if (transferListener != null) {
                defaultDataSource.p(transferListener);
            }
            return defaultDataSource;
        }

        public Factory(Context context, DataSource.Factory factory) {
            this.f28405a = context.getApplicationContext();
            this.f28406b = factory;
        }
    }

    public DefaultDataSource(Context context, DataSource dataSource) {
        this.f28394a = context.getApplicationContext();
        this.f28396c = (DataSource) Assertions.e(dataSource);
    }

    private void q(DataSource dataSource) {
        for (int i2 = 0; i2 < this.f28395b.size(); i2++) {
            dataSource.p(this.f28395b.get(i2));
        }
    }

    private DataSource s() {
        if (this.f28398e == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f28394a);
            this.f28398e = assetDataSource;
            q(assetDataSource);
        }
        return this.f28398e;
    }

    private DataSource t() {
        if (this.f28399f == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f28394a);
            this.f28399f = contentDataSource;
            q(contentDataSource);
        }
        return this.f28399f;
    }

    private DataSource u() {
        if (this.f28402i == null) {
            DataSchemeDataSource dataSchemeDataSource = new DataSchemeDataSource();
            this.f28402i = dataSchemeDataSource;
            q(dataSchemeDataSource);
        }
        return this.f28402i;
    }

    private DataSource v() {
        if (this.f28397d == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.f28397d = fileDataSource;
            q(fileDataSource);
        }
        return this.f28397d;
    }

    private DataSource w() {
        if (this.f28403j == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f28394a);
            this.f28403j = rawResourceDataSource;
            q(rawResourceDataSource);
        }
        return this.f28403j;
    }

    private DataSource x() {
        if (this.f28400g == null) {
            try {
                DataSource dataSource = (DataSource) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f28400g = dataSource;
                q(dataSource);
            } catch (ClassNotFoundException unused) {
                Log.i("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.f28400g == null) {
                this.f28400g = this.f28396c;
            }
        }
        return this.f28400g;
    }

    private DataSource y() {
        if (this.f28401h == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.f28401h = udpDataSource;
            q(udpDataSource);
        }
        return this.f28401h;
    }

    private void z(DataSource dataSource, TransferListener transferListener) {
        if (dataSource != null) {
            dataSource.p(transferListener);
        }
    }

    public Uri b() {
        DataSource dataSource = this.f28404k;
        if (dataSource == null) {
            return null;
        }
        return dataSource.b();
    }

    public void close() throws IOException {
        DataSource dataSource = this.f28404k;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.f28404k = null;
            }
        }
    }

    public Map<String, List<String>> d() {
        DataSource dataSource = this.f28404k;
        return dataSource == null ? Collections.emptyMap() : dataSource.d();
    }

    public long i(DataSpec dataSpec) throws IOException {
        boolean z2;
        if (this.f28404k == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        String scheme = dataSpec.f28339a.getScheme();
        if (Util.z0(dataSpec.f28339a)) {
            String path = dataSpec.f28339a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.f28404k = v();
            } else {
                this.f28404k = s();
            }
        } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
            this.f28404k = s();
        } else if ("content".equals(scheme)) {
            this.f28404k = t();
        } else if ("rtmp".equals(scheme)) {
            this.f28404k = x();
        } else if ("udp".equals(scheme)) {
            this.f28404k = y();
        } else if ("data".equals(scheme)) {
            this.f28404k = u();
        } else if ("rawresource".equals(scheme) || UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
            this.f28404k = w();
        } else {
            this.f28404k = this.f28396c;
        }
        return this.f28404k.i(dataSpec);
    }

    public void p(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f28396c.p(transferListener);
        this.f28395b.add(transferListener);
        z(this.f28397d, transferListener);
        z(this.f28398e, transferListener);
        z(this.f28399f, transferListener);
        z(this.f28400g, transferListener);
        z(this.f28401h, transferListener);
        z(this.f28402i, transferListener);
        z(this.f28403j, transferListener);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return ((DataSource) Assertions.e(this.f28404k)).read(bArr, i2, i3);
    }
}
