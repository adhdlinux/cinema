package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public final class RawResourceDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private final Resources f28493e;

    /* renamed from: f  reason: collision with root package name */
    private final String f28494f;

    /* renamed from: g  reason: collision with root package name */
    private Uri f28495g;

    /* renamed from: h  reason: collision with root package name */
    private AssetFileDescriptor f28496h;

    /* renamed from: i  reason: collision with root package name */
    private InputStream f28497i;

    /* renamed from: j  reason: collision with root package name */
    private long f28498j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f28499k;

    public static class RawResourceDataSourceException extends DataSourceException {
        public RawResourceDataSourceException(String str, Throwable th, int i2) {
            super(str, th, i2);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f28493e = context.getResources();
        this.f28494f = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i2) {
        return Uri.parse("rawresource:///" + i2);
    }

    public Uri b() {
        return this.f28495g;
    }

    public void close() throws RawResourceDataSourceException {
        this.f28495g = null;
        try {
            InputStream inputStream = this.f28497i;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f28497i = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.f28496h;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.f28496h = null;
                if (this.f28499k) {
                    this.f28499k = false;
                    t();
                }
            } catch (IOException e2) {
                throw new RawResourceDataSourceException((String) null, e2, 2000);
            } catch (Throwable th) {
                this.f28496h = null;
                if (this.f28499k) {
                    this.f28499k = false;
                    t();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new RawResourceDataSourceException((String) null, e3, 2000);
        } catch (Throwable th2) {
            this.f28497i = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.f28496h;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.f28496h = null;
                if (this.f28499k) {
                    this.f28499k = false;
                    t();
                }
                throw th2;
            } catch (IOException e4) {
                throw new RawResourceDataSourceException((String) null, e4, 2000);
            } catch (Throwable th3) {
                this.f28496h = null;
                if (this.f28499k) {
                    this.f28499k = false;
                    t();
                }
                throw th3;
            }
        }
    }

    public long i(DataSpec dataSpec) throws RawResourceDataSourceException {
        int i2;
        String str;
        DataSpec dataSpec2 = dataSpec;
        Uri uri = dataSpec2.f28339a;
        this.f28495g = uri;
        if (TextUtils.equals("rawresource", uri.getScheme()) || (TextUtils.equals(UriUtil.QUALIFIED_RESOURCE_SCHEME, uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) Assertions.e(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                i2 = Integer.parseInt((String) Assertions.e(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", (Throwable) null, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
            }
        } else if (TextUtils.equals(UriUtil.QUALIFIED_RESOURCE_SCHEME, uri.getScheme())) {
            String str2 = (String) Assertions.e(uri.getPath());
            if (str2.startsWith("/")) {
                str2 = str2.substring(1);
            }
            String host = uri.getHost();
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(host)) {
                str = "";
            } else {
                str = host + ":";
            }
            sb.append(str);
            sb.append(str2);
            i2 = this.f28493e.getIdentifier(sb.toString(), "raw", this.f28494f);
            if (i2 == 0) {
                throw new RawResourceDataSourceException("Resource not found.", (Throwable) null, 2005);
            }
        } else {
            throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource", (Throwable) null, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
        }
        u(dataSpec);
        try {
            AssetFileDescriptor openRawResourceFd = this.f28493e.openRawResourceFd(i2);
            this.f28496h = openRawResourceFd;
            if (openRawResourceFd != null) {
                long length = openRawResourceFd.getLength();
                FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
                this.f28497i = fileInputStream;
                int i3 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
                if (i3 != 0) {
                    try {
                        if (dataSpec2.f28345g > length) {
                            throw new RawResourceDataSourceException((String) null, (Throwable) null, 2008);
                        }
                    } catch (RawResourceDataSourceException e2) {
                        throw e2;
                    } catch (IOException e3) {
                        throw new RawResourceDataSourceException((String) null, e3, 2000);
                    }
                }
                long startOffset = openRawResourceFd.getStartOffset();
                long skip = fileInputStream.skip(dataSpec2.f28345g + startOffset) - startOffset;
                if (skip == dataSpec2.f28345g) {
                    if (i3 == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        if (channel.size() == 0) {
                            this.f28498j = -1;
                        } else {
                            long size = channel.size() - channel.position();
                            this.f28498j = size;
                            if (size < 0) {
                                throw new RawResourceDataSourceException((String) null, (Throwable) null, 2008);
                            }
                        }
                    } else {
                        long j2 = length - skip;
                        this.f28498j = j2;
                        if (j2 < 0) {
                            throw new DataSourceException(2008);
                        }
                    }
                    long j3 = dataSpec2.f28346h;
                    if (j3 != -1) {
                        long j4 = this.f28498j;
                        if (j4 != -1) {
                            j3 = Math.min(j4, j3);
                        }
                        this.f28498j = j3;
                    }
                    this.f28499k = true;
                    v(dataSpec);
                    long j5 = dataSpec2.f28346h;
                    if (j5 != -1) {
                        return j5;
                    }
                    return this.f28498j;
                }
                throw new RawResourceDataSourceException((String) null, (Throwable) null, 2008);
            }
            throw new RawResourceDataSourceException("Resource is compressed: " + uri, (Throwable) null, 2000);
        } catch (Resources.NotFoundException e4) {
            throw new RawResourceDataSourceException((String) null, e4, 2005);
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws RawResourceDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f28498j;
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
        int read = ((InputStream) Util.j(this.f28497i)).read(bArr, i2, i3);
        if (read != -1) {
            long j3 = this.f28498j;
            if (j3 != -1) {
                this.f28498j = j3 - ((long) read);
            }
            s(read);
            return read;
        } else if (this.f28498j == -1) {
            return -1;
        } else {
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
    }
}
