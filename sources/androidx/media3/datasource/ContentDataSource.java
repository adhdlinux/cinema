package androidx.media3.datasource;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.media3.common.util.Util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class ContentDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private final ContentResolver f4806e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f4807f;

    /* renamed from: g  reason: collision with root package name */
    private AssetFileDescriptor f4808g;

    /* renamed from: h  reason: collision with root package name */
    private FileInputStream f4809h;

    /* renamed from: i  reason: collision with root package name */
    private long f4810i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4811j;

    public static class ContentDataSourceException extends DataSourceException {
        public ContentDataSourceException(IOException iOException, int i2) {
            super((Throwable) iOException, i2);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f4806e = context.getContentResolver();
    }

    public Uri b() {
        return this.f4807f;
    }

    public void close() throws ContentDataSourceException {
        this.f4807f = null;
        try {
            FileInputStream fileInputStream = this.f4809h;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.f4809h = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.f4808g;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.f4808g = null;
                if (this.f4811j) {
                    this.f4811j = false;
                    p();
                }
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2, 2000);
            } catch (Throwable th) {
                this.f4808g = null;
                if (this.f4811j) {
                    this.f4811j = false;
                    p();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new ContentDataSourceException(e3, 2000);
        } catch (Throwable th2) {
            this.f4809h = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.f4808g;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.f4808g = null;
                if (this.f4811j) {
                    this.f4811j = false;
                    p();
                }
                throw th2;
            } catch (IOException e4) {
                throw new ContentDataSourceException(e4, 2000);
            } catch (Throwable th3) {
                this.f4808g = null;
                if (this.f4811j) {
                    this.f4811j = false;
                    p();
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
            Uri normalizeScheme = dataSpec2.f4823a.normalizeScheme();
            this.f4807f = normalizeScheme;
            q(dataSpec);
            if ("content".equals(normalizeScheme.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptor = this.f4806e.openTypedAssetFileDescriptor(normalizeScheme, "*/*", bundle);
            } else {
                assetFileDescriptor = this.f4806e.openAssetFileDescriptor(normalizeScheme, "r");
            }
            this.f4808g = assetFileDescriptor;
            if (assetFileDescriptor != null) {
                long length = assetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
                this.f4809h = fileInputStream;
                int i3 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
                if (i3 != 0) {
                    if (dataSpec2.f4829g > length) {
                        throw new ContentDataSourceException((IOException) null, 2008);
                    }
                }
                long startOffset = assetFileDescriptor.getStartOffset();
                long j2 = length;
                long skip = fileInputStream.skip(dataSpec2.f4829g + startOffset) - startOffset;
                if (skip == dataSpec2.f4829g) {
                    if (i3 == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.f4810i = -1;
                        } else {
                            long position = size - channel.position();
                            this.f4810i = position;
                            if (position < 0) {
                                throw new ContentDataSourceException((IOException) null, 2008);
                            }
                        }
                    } else {
                        long j3 = j2 - skip;
                        this.f4810i = j3;
                        if (j3 < 0) {
                            throw new ContentDataSourceException((IOException) null, 2008);
                        }
                    }
                    long j4 = dataSpec2.f4830h;
                    if (j4 != -1) {
                        long j5 = this.f4810i;
                        if (j5 != -1) {
                            j4 = Math.min(j5, j4);
                        }
                        this.f4810i = j4;
                    }
                    this.f4811j = true;
                    r(dataSpec);
                    long j6 = dataSpec2.f4830h;
                    if (j6 != -1) {
                        return j6;
                    }
                    return this.f4810i;
                }
                throw new ContentDataSourceException((IOException) null, 2008);
            }
            throw new ContentDataSourceException(new IOException("Could not open file descriptor for: " + normalizeScheme), 2000);
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
        long j2 = this.f4810i;
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
        int read = ((FileInputStream) Util.i(this.f4809h)).read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        long j3 = this.f4810i;
        if (j3 != -1) {
            this.f4810i = j3 - ((long) read);
        }
        o(read);
        return read;
    }
}
