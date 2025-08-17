package androidx.media3.datasource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.List;

public final class RawResourceDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private final Context f4905e;

    /* renamed from: f  reason: collision with root package name */
    private DataSpec f4906f;

    /* renamed from: g  reason: collision with root package name */
    private AssetFileDescriptor f4907g;

    /* renamed from: h  reason: collision with root package name */
    private InputStream f4908h;

    /* renamed from: i  reason: collision with root package name */
    private long f4909i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4910j;

    public static class RawResourceDataSourceException extends DataSourceException {
        @Deprecated
        public RawResourceDataSourceException(String str) {
            super(str, (Throwable) null, 2000);
        }

        public RawResourceDataSourceException(String str, Throwable th, int i2) {
            super(str, th, i2);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f4905e = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i2) {
        return Uri.parse("rawresource:///" + i2);
    }

    private static AssetFileDescriptor s(Context context, DataSpec dataSpec) throws RawResourceDataSourceException {
        Resources resources;
        int i2;
        String str;
        Uri normalizeScheme = dataSpec.f4823a.normalizeScheme();
        if (TextUtils.equals("rawresource", normalizeScheme.getScheme())) {
            resources = context.getResources();
            List<String> pathSegments = normalizeScheme.getPathSegments();
            if (pathSegments.size() == 1) {
                i2 = t(pathSegments.get(0));
            } else {
                throw new RawResourceDataSourceException("rawresource:// URI must have exactly one path element, found " + pathSegments.size());
            }
        } else if (TextUtils.equals(UriUtil.QUALIFIED_RESOURCE_SCHEME, normalizeScheme.getScheme())) {
            String str2 = (String) Assertions.f(normalizeScheme.getPath());
            if (str2.startsWith("/")) {
                str2 = str2.substring(1);
            }
            if (TextUtils.isEmpty(normalizeScheme.getHost())) {
                str = context.getPackageName();
            } else {
                str = normalizeScheme.getHost();
            }
            if (str.equals(context.getPackageName())) {
                resources = context.getResources();
            } else {
                try {
                    resources = context.getPackageManager().getResourcesForApplication(str);
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new RawResourceDataSourceException("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e2, 2005);
                }
            }
            if (str2.matches("\\d+")) {
                i2 = t(str2);
            } else {
                i2 = resources.getIdentifier(str + ":" + str2, "raw", (String) null);
                if (i2 == 0) {
                    throw new RawResourceDataSourceException("Resource not found.", (Throwable) null, 2005);
                }
            }
        } else {
            throw new RawResourceDataSourceException("Unsupported URI scheme (" + normalizeScheme.getScheme() + "). Only " + UriUtil.QUALIFIED_RESOURCE_SCHEME + " is supported.", (Throwable) null, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
        }
        try {
            AssetFileDescriptor openRawResourceFd = resources.openRawResourceFd(i2);
            if (openRawResourceFd != null) {
                return openRawResourceFd;
            }
            throw new RawResourceDataSourceException("Resource is compressed: " + normalizeScheme, (Throwable) null, 2000);
        } catch (Resources.NotFoundException e3) {
            throw new RawResourceDataSourceException((String) null, e3, 2005);
        }
    }

    private static int t(String str) throws RawResourceDataSourceException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new RawResourceDataSourceException("Resource identifier must be an integer.", (Throwable) null, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
        }
    }

    public Uri b() {
        DataSpec dataSpec = this.f4906f;
        if (dataSpec != null) {
            return dataSpec.f4823a;
        }
        return null;
    }

    public void close() throws RawResourceDataSourceException {
        this.f4906f = null;
        try {
            InputStream inputStream = this.f4908h;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f4908h = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.f4907g;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.f4907g = null;
                if (this.f4910j) {
                    this.f4910j = false;
                    p();
                }
            } catch (IOException e2) {
                throw new RawResourceDataSourceException((String) null, e2, 2000);
            } catch (Throwable th) {
                this.f4907g = null;
                if (this.f4910j) {
                    this.f4910j = false;
                    p();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new RawResourceDataSourceException((String) null, e3, 2000);
        } catch (Throwable th2) {
            this.f4908h = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.f4907g;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.f4907g = null;
                if (this.f4910j) {
                    this.f4910j = false;
                    p();
                }
                throw th2;
            } catch (IOException e4) {
                throw new RawResourceDataSourceException((String) null, e4, 2000);
            } catch (Throwable th3) {
                this.f4907g = null;
                if (this.f4910j) {
                    this.f4910j = false;
                    p();
                }
                throw th3;
            }
        }
    }

    public long i(DataSpec dataSpec) throws RawResourceDataSourceException {
        this.f4906f = dataSpec;
        q(dataSpec);
        AssetFileDescriptor s2 = s(this.f4905e, dataSpec);
        this.f4907g = s2;
        long length = s2.getLength();
        FileInputStream fileInputStream = new FileInputStream(this.f4907g.getFileDescriptor());
        this.f4908h = fileInputStream;
        int i2 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        if (i2 != 0) {
            try {
                if (dataSpec.f4829g > length) {
                    throw new RawResourceDataSourceException((String) null, (Throwable) null, 2008);
                }
            } catch (RawResourceDataSourceException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RawResourceDataSourceException((String) null, e3, 2000);
            }
        }
        long startOffset = this.f4907g.getStartOffset();
        long skip = fileInputStream.skip(dataSpec.f4829g + startOffset) - startOffset;
        if (skip == dataSpec.f4829g) {
            if (i2 == 0) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.f4909i = -1;
                } else {
                    long size = channel.size() - channel.position();
                    this.f4909i = size;
                    if (size < 0) {
                        throw new RawResourceDataSourceException((String) null, (Throwable) null, 2008);
                    }
                }
            } else {
                long j2 = length - skip;
                this.f4909i = j2;
                if (j2 < 0) {
                    throw new DataSourceException(2008);
                }
            }
            long j3 = dataSpec.f4830h;
            if (j3 != -1) {
                long j4 = this.f4909i;
                if (j4 != -1) {
                    j3 = Math.min(j4, j3);
                }
                this.f4909i = j3;
            }
            this.f4910j = true;
            r(dataSpec);
            long j5 = dataSpec.f4830h;
            if (j5 != -1) {
                return j5;
            }
            return this.f4909i;
        }
        throw new RawResourceDataSourceException((String) null, (Throwable) null, 2008);
    }

    public int read(byte[] bArr, int i2, int i3) throws RawResourceDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f4909i;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new RawResourceDataSourceException((String) null, e2, 2000);
            }
        }
        int read = ((InputStream) Util.i(this.f4908h)).read(bArr, i2, i3);
        if (read != -1) {
            long j3 = this.f4909i;
            if (j3 != -1) {
                this.f4909i = j3 - ((long) read);
            }
            o(read);
            return read;
        } else if (this.f4909i == -1) {
            return -1;
        } else {
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
    }
}
