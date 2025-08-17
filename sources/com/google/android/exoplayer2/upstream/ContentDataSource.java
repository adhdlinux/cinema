package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.util.Util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class ContentDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private final ContentResolver f28322e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f28323f;

    /* renamed from: g  reason: collision with root package name */
    private AssetFileDescriptor f28324g;

    /* renamed from: h  reason: collision with root package name */
    private FileInputStream f28325h;

    /* renamed from: i  reason: collision with root package name */
    private long f28326i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f28327j;

    public static class ContentDataSourceException extends DataSourceException {
        public ContentDataSourceException(IOException iOException, int i2) {
            super((Throwable) iOException, i2);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f28322e = context.getContentResolver();
    }

    public Uri b() {
        return this.f28323f;
    }

    public void close() throws ContentDataSourceException {
        this.f28323f = null;
        try {
            FileInputStream fileInputStream = this.f28325h;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.f28325h = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.f28324g;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.f28324g = null;
                if (this.f28327j) {
                    this.f28327j = false;
                    t();
                }
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2, 2000);
            } catch (Throwable th) {
                this.f28324g = null;
                if (this.f28327j) {
                    this.f28327j = false;
                    t();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new ContentDataSourceException(e3, 2000);
        } catch (Throwable th2) {
            this.f28325h = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.f28324g;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.f28324g = null;
                if (this.f28327j) {
                    this.f28327j = false;
                    t();
                }
                throw th2;
            } catch (IOException e4) {
                throw new ContentDataSourceException(e4, 2000);
            } catch (Throwable th3) {
                this.f28324g = null;
                if (this.f28327j) {
                    this.f28327j = false;
                    t();
                }
                throw th3;
            }
        }
    }

    public long i(DataSpec dataSpec) throws ContentDataSourceException {
        AssetFileDescriptor assetFileDescriptor;
        DataSpec dataSpec2 = dataSpec;
        int i2 = 2000;
        try {
            Uri uri = dataSpec2.f28339a;
            this.f28323f = uri;
            u(dataSpec);
            if ("content".equals(dataSpec2.f28339a.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptor = this.f28322e.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                assetFileDescriptor = this.f28322e.openAssetFileDescriptor(uri, "r");
            }
            this.f28324g = assetFileDescriptor;
            if (assetFileDescriptor != null) {
                long length = assetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
                this.f28325h = fileInputStream;
                int i3 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
                if (i3 != 0) {
                    if (dataSpec2.f28345g > length) {
                        throw new ContentDataSourceException((IOException) null, 2008);
                    }
                }
                long startOffset = assetFileDescriptor.getStartOffset();
                long j2 = length;
                long skip = fileInputStream.skip(dataSpec2.f28345g + startOffset) - startOffset;
                if (skip == dataSpec2.f28345g) {
                    if (i3 == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.f28326i = -1;
                        } else {
                            long position = size - channel.position();
                            this.f28326i = position;
                            if (position < 0) {
                                throw new ContentDataSourceException((IOException) null, 2008);
                            }
                        }
                    } else {
                        long j3 = j2 - skip;
                        this.f28326i = j3;
                        if (j3 < 0) {
                            throw new ContentDataSourceException((IOException) null, 2008);
                        }
                    }
                    long j4 = dataSpec2.f28346h;
                    if (j4 != -1) {
                        long j5 = this.f28326i;
                        if (j5 != -1) {
                            j4 = Math.min(j5, j4);
                        }
                        this.f28326i = j4;
                    }
                    this.f28327j = true;
                    v(dataSpec);
                    long j6 = dataSpec2.f28346h;
                    if (j6 != -1) {
                        return j6;
                    }
                    return this.f28326i;
                }
                throw new ContentDataSourceException((IOException) null, 2008);
            }
            throw new ContentDataSourceException(new IOException("Could not open file descriptor for: " + uri), 2000);
        } catch (ContentDataSourceException e2) {
            throw e2;
        } catch (IOException e3) {
            if (e3 instanceof FileNotFoundException) {
                i2 = 2005;
            }
            throw new ContentDataSourceException(e3, i2);
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws ContentDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f28326i;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2, 2000);
            }
        }
        int read = ((FileInputStream) Util.j(this.f28325h)).read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        long j3 = this.f28326i;
        if (j3 != -1) {
            this.f28326i = j3 - ((long) read);
        }
        s(read);
        return read;
    }
}
