package androidx.media3.datasource.okhttp;

import android.net.Uri;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.BaseDataSource;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource$Factory;
import androidx.media3.datasource.HttpDataSource$HttpDataSourceException;
import androidx.media3.datasource.HttpDataSource$InvalidContentTypeException;
import androidx.media3.datasource.HttpDataSource$InvalidResponseCodeException;
import androidx.media3.datasource.HttpDataSource$RequestProperties;
import androidx.media3.datasource.HttpUtil;
import androidx.media3.datasource.TransferListener;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.common.base.Predicate;
import com.google.common.io.ByteStreams;
import com.google.common.util.concurrent.SettableFuture;
import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private final Call.Factory f5033e;

    /* renamed from: f  reason: collision with root package name */
    private final HttpDataSource$RequestProperties f5034f;

    /* renamed from: g  reason: collision with root package name */
    private final String f5035g;

    /* renamed from: h  reason: collision with root package name */
    private final CacheControl f5036h;

    /* renamed from: i  reason: collision with root package name */
    private final HttpDataSource$RequestProperties f5037i;

    /* renamed from: j  reason: collision with root package name */
    private final Predicate<String> f5038j;

    /* renamed from: k  reason: collision with root package name */
    private DataSpec f5039k;

    /* renamed from: l  reason: collision with root package name */
    private Response f5040l;

    /* renamed from: m  reason: collision with root package name */
    private InputStream f5041m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f5042n;

    /* renamed from: o  reason: collision with root package name */
    private long f5043o;

    /* renamed from: p  reason: collision with root package name */
    private long f5044p;

    public static final class Factory implements HttpDataSource$Factory {

        /* renamed from: a  reason: collision with root package name */
        private final HttpDataSource$RequestProperties f5047a = new HttpDataSource$RequestProperties();

        /* renamed from: b  reason: collision with root package name */
        private final Call.Factory f5048b;

        /* renamed from: c  reason: collision with root package name */
        private String f5049c;

        /* renamed from: d  reason: collision with root package name */
        private TransferListener f5050d;

        /* renamed from: e  reason: collision with root package name */
        private CacheControl f5051e;

        /* renamed from: f  reason: collision with root package name */
        private Predicate<String> f5052f;

        public Factory(Call.Factory factory) {
            this.f5048b = factory;
        }

        /* renamed from: c */
        public OkHttpDataSource a() {
            OkHttpDataSource okHttpDataSource = new OkHttpDataSource(this.f5048b, this.f5049c, this.f5051e, this.f5047a, this.f5052f);
            TransferListener transferListener = this.f5050d;
            if (transferListener != null) {
                okHttpDataSource.n(transferListener);
            }
            return okHttpDataSource;
        }

        /* renamed from: d */
        public final Factory b(Map<String, String> map) {
            this.f5047a.a(map);
            return this;
        }

        public Factory e(String str) {
            this.f5049c = str;
            return this;
        }
    }

    static {
        MediaLibraryInfo.a("media3.datasource.okhttp");
    }

    private void s() {
        Response response = this.f5040l;
        if (response != null) {
            ((ResponseBody) Assertions.f(response.body())).close();
            this.f5040l = null;
        }
        this.f5041m = null;
    }

    private Response t(Call call) throws IOException {
        final SettableFuture C = SettableFuture.C();
        call.enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                C.B(iOException);
            }

            public void onResponse(Call call, Response response) {
                C.A(response);
            }
        });
        try {
            return (Response) C.get();
        } catch (InterruptedException unused) {
            call.cancel();
            throw new InterruptedIOException();
        } catch (ExecutionException e2) {
            throw new IOException(e2);
        }
    }

    private Request u(DataSpec dataSpec) throws HttpDataSource$HttpDataSourceException {
        RequestBody requestBody;
        long j2 = dataSpec.f4829g;
        long j3 = dataSpec.f4830h;
        HttpUrl parse = HttpUrl.parse(dataSpec.f4823a.toString());
        if (parse != null) {
            Request.Builder url = new Request.Builder().url(parse);
            CacheControl cacheControl = this.f5036h;
            if (cacheControl != null) {
                url.cacheControl(cacheControl);
            }
            HashMap hashMap = new HashMap();
            HttpDataSource$RequestProperties httpDataSource$RequestProperties = this.f5037i;
            if (httpDataSource$RequestProperties != null) {
                hashMap.putAll(httpDataSource$RequestProperties.b());
            }
            hashMap.putAll(this.f5034f.b());
            hashMap.putAll(dataSpec.f4827e);
            for (Map.Entry entry : hashMap.entrySet()) {
                url.header((String) entry.getKey(), (String) entry.getValue());
            }
            String a2 = HttpUtil.a(j2, j3);
            if (a2 != null) {
                url.addHeader("Range", a2);
            }
            String str = this.f5035g;
            if (str != null) {
                url.addHeader("User-Agent", str);
            }
            if (!dataSpec.d(1)) {
                url.addHeader("Accept-Encoding", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
            }
            byte[] bArr = dataSpec.f4826d;
            if (bArr != null) {
                requestBody = RequestBody.create(bArr);
            } else if (dataSpec.f4825c == 2) {
                requestBody = RequestBody.create(Util.f4719f);
            } else {
                requestBody = null;
            }
            url.method(dataSpec.b(), requestBody);
            return url.build();
        }
        throw new HttpDataSource$HttpDataSourceException("Malformed URL", dataSpec, (int) GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION, 1);
    }

    private int v(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f5043o;
        if (j2 != -1) {
            long j3 = j2 - this.f5044p;
            if (j3 == 0) {
                return -1;
            }
            i3 = (int) Math.min((long) i3, j3);
        }
        int read = ((InputStream) Util.i(this.f5041m)).read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        this.f5044p += (long) read;
        o(read);
        return read;
    }

    private void w(long j2, DataSpec dataSpec) throws HttpDataSource$HttpDataSourceException {
        if (j2 != 0) {
            byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            while (j2 > 0) {
                try {
                    int read = ((InputStream) Util.i(this.f5041m)).read(bArr, 0, (int) Math.min(j2, (long) CodedOutputStream.DEFAULT_BUFFER_SIZE));
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        j2 -= (long) read;
                        o(read);
                    } else {
                        throw new HttpDataSource$HttpDataSourceException(dataSpec, 2008, 1);
                    }
                } catch (IOException e2) {
                    if (e2 instanceof HttpDataSource$HttpDataSourceException) {
                        throw ((HttpDataSource$HttpDataSourceException) e2);
                    }
                    throw new HttpDataSource$HttpDataSourceException(dataSpec, 2000, 1);
                }
            }
        }
    }

    public Uri b() {
        Response response = this.f5040l;
        if (response == null) {
            return null;
        }
        return Uri.parse(response.request().url().toString());
    }

    public void close() {
        if (this.f5042n) {
            this.f5042n = false;
            p();
            s();
        }
    }

    public Map<String, List<String>> d() {
        Response response = this.f5040l;
        return response == null ? Collections.emptyMap() : response.headers().toMultimap();
    }

    public long i(DataSpec dataSpec) throws HttpDataSource$HttpDataSourceException {
        String str;
        byte[] bArr;
        DataSourceException dataSourceException;
        this.f5039k = dataSpec;
        long j2 = 0;
        this.f5044p = 0;
        this.f5043o = 0;
        q(dataSpec);
        try {
            Response t2 = t(this.f5033e.newCall(u(dataSpec)));
            this.f5040l = t2;
            ResponseBody responseBody = (ResponseBody) Assertions.f(t2.body());
            this.f5041m = responseBody.byteStream();
            int code = t2.code();
            long j3 = -1;
            if (!t2.isSuccessful()) {
                if (code == 416) {
                    if (dataSpec.f4829g == HttpUtil.c(t2.headers().get("Content-Range"))) {
                        this.f5042n = true;
                        r(dataSpec);
                        long j4 = dataSpec.f4830h;
                        if (j4 != -1) {
                            return j4;
                        }
                        return 0;
                    }
                }
                try {
                    bArr = ByteStreams.d((InputStream) Assertions.f(this.f5041m));
                } catch (IOException unused) {
                    bArr = Util.f4719f;
                }
                byte[] bArr2 = bArr;
                Map<String, List<String>> multimap = t2.headers().toMultimap();
                s();
                if (code == 416) {
                    dataSourceException = new DataSourceException(2008);
                } else {
                    dataSourceException = null;
                }
                throw new HttpDataSource$InvalidResponseCodeException(code, t2.message(), dataSourceException, multimap, dataSpec, bArr2);
            }
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                str = contentType.toString();
            } else {
                str = "";
            }
            Predicate<String> predicate = this.f5038j;
            if (predicate == null || predicate.apply(str)) {
                if (code == 200) {
                    long j5 = dataSpec.f4829g;
                    if (j5 != 0) {
                        j2 = j5;
                    }
                }
                long j6 = dataSpec.f4830h;
                if (j6 != -1) {
                    this.f5043o = j6;
                } else {
                    long contentLength = responseBody.contentLength();
                    if (contentLength != -1) {
                        j3 = contentLength - j2;
                    }
                    this.f5043o = j3;
                }
                this.f5042n = true;
                r(dataSpec);
                try {
                    w(j2, dataSpec);
                    return this.f5043o;
                } catch (HttpDataSource$HttpDataSourceException e2) {
                    s();
                    throw e2;
                }
            } else {
                s();
                throw new HttpDataSource$InvalidContentTypeException(str, dataSpec);
            }
        } catch (IOException e3) {
            throw HttpDataSource$HttpDataSourceException.c(e3, dataSpec, 1);
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws HttpDataSource$HttpDataSourceException {
        try {
            return v(bArr, i2, i3);
        } catch (IOException e2) {
            throw HttpDataSource$HttpDataSourceException.c(e2, (DataSpec) Util.i(this.f5039k), 2);
        }
    }

    private OkHttpDataSource(Call.Factory factory, String str, CacheControl cacheControl, HttpDataSource$RequestProperties httpDataSource$RequestProperties, Predicate<String> predicate) {
        super(true);
        this.f5033e = (Call.Factory) Assertions.f(factory);
        this.f5035g = str;
        this.f5036h = cacheControl;
        this.f5037i = httpDataSource$RequestProperties;
        this.f5038j = predicate;
        this.f5034f = new HttpDataSource$RequestProperties();
    }
}
