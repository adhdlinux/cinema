package androidx.media3.datasource;

import android.content.Context;
import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DefaultDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4844a;

    /* renamed from: b  reason: collision with root package name */
    private final List<TransferListener> f4845b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final DataSource f4846c;

    /* renamed from: d  reason: collision with root package name */
    private DataSource f4847d;

    /* renamed from: e  reason: collision with root package name */
    private DataSource f4848e;

    /* renamed from: f  reason: collision with root package name */
    private DataSource f4849f;

    /* renamed from: g  reason: collision with root package name */
    private DataSource f4850g;

    /* renamed from: h  reason: collision with root package name */
    private DataSource f4851h;

    /* renamed from: i  reason: collision with root package name */
    private DataSource f4852i;

    /* renamed from: j  reason: collision with root package name */
    private DataSource f4853j;

    /* renamed from: k  reason: collision with root package name */
    private DataSource f4854k;

    public static final class Factory implements DataSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final Context f4855a;

        /* renamed from: b  reason: collision with root package name */
        private final DataSource.Factory f4856b;

        /* renamed from: c  reason: collision with root package name */
        private TransferListener f4857c;

        public Factory(Context context) {
            this(context, new DefaultHttpDataSource.Factory());
        }

        /* renamed from: c */
        public DefaultDataSource a() {
            DefaultDataSource defaultDataSource = new DefaultDataSource(this.f4855a, this.f4856b.a());
            TransferListener transferListener = this.f4857c;
            if (transferListener != null) {
                defaultDataSource.n(transferListener);
            }
            return defaultDataSource;
        }

        public Factory(Context context, DataSource.Factory factory) {
            this.f4855a = context.getApplicationContext();
            this.f4856b = factory;
        }
    }

    public DefaultDataSource(Context context, DataSource dataSource) {
        this.f4844a = context.getApplicationContext();
        this.f4846c = (DataSource) Assertions.f(dataSource);
    }

    private void o(DataSource dataSource) {
        for (int i2 = 0; i2 < this.f4845b.size(); i2++) {
            dataSource.n(this.f4845b.get(i2));
        }
    }

    private DataSource p() {
        if (this.f4848e == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f4844a);
            this.f4848e = assetDataSource;
            o(assetDataSource);
        }
        return this.f4848e;
    }

    private DataSource q() {
        if (this.f4849f == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f4844a);
            this.f4849f = contentDataSource;
            o(contentDataSource);
        }
        return this.f4849f;
    }

    private DataSource r() {
        if (this.f4852i == null) {
            DataSchemeDataSource dataSchemeDataSource = new DataSchemeDataSource();
            this.f4852i = dataSchemeDataSource;
            o(dataSchemeDataSource);
        }
        return this.f4852i;
    }

    private DataSource s() {
        if (this.f4847d == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.f4847d = fileDataSource;
            o(fileDataSource);
        }
        return this.f4847d;
    }

    private DataSource t() {
        if (this.f4853j == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f4844a);
            this.f4853j = rawResourceDataSource;
            o(rawResourceDataSource);
        }
        return this.f4853j;
    }

    private DataSource u() {
        if (this.f4850g == null) {
            try {
                DataSource dataSource = (DataSource) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f4850g = dataSource;
                o(dataSource);
            } catch (ClassNotFoundException unused) {
                Log.h("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.f4850g == null) {
                this.f4850g = this.f4846c;
            }
        }
        return this.f4850g;
    }

    private DataSource v() {
        if (this.f4851h == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.f4851h = udpDataSource;
            o(udpDataSource);
        }
        return this.f4851h;
    }

    private void w(DataSource dataSource, TransferListener transferListener) {
        if (dataSource != null) {
            dataSource.n(transferListener);
        }
    }

    public Uri b() {
        DataSource dataSource = this.f4854k;
        if (dataSource == null) {
            return null;
        }
        return dataSource.b();
    }

    public void close() throws IOException {
        DataSource dataSource = this.f4854k;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.f4854k = null;
            }
        }
    }

    public Map<String, List<String>> d() {
        DataSource dataSource = this.f4854k;
        return dataSource == null ? Collections.emptyMap() : dataSource.d();
    }

    public long i(DataSpec dataSpec) throws IOException {
        boolean z2;
        if (this.f4854k == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        String scheme = dataSpec.f4823a.getScheme();
        if (Util.I0(dataSpec.f4823a)) {
            String path = dataSpec.f4823a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.f4854k = s();
            } else {
                this.f4854k = p();
            }
        } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
            this.f4854k = p();
        } else if ("content".equals(scheme)) {
            this.f4854k = q();
        } else if ("rtmp".equals(scheme)) {
            this.f4854k = u();
        } else if ("udp".equals(scheme)) {
            this.f4854k = v();
        } else if ("data".equals(scheme)) {
            this.f4854k = r();
        } else if ("rawresource".equals(scheme) || UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
            this.f4854k = t();
        } else {
            this.f4854k = this.f4846c;
        }
        return this.f4854k.i(dataSpec);
    }

    public void n(TransferListener transferListener) {
        Assertions.f(transferListener);
        this.f4846c.n(transferListener);
        this.f4845b.add(transferListener);
        w(this.f4847d, transferListener);
        w(this.f4848e, transferListener);
        w(this.f4849f, transferListener);
        w(this.f4850g, transferListener);
        w(this.f4851h, transferListener);
        w(this.f4852i, transferListener);
        w(this.f4853j, transferListener);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return ((DataSource) Assertions.f(this.f4854k)).read(bArr, i2, i3);
    }
}
