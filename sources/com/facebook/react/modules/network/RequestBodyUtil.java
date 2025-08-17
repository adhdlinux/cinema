package com.facebook.react.modules.network;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.logging.FLog;
import com.facebook.common.time.Clock;
import com.facebook.common.util.UriUtil;
import com.facebook.react.common.ReactConstants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.GZIPOutputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

class RequestBodyUtil {
    private static final String CONTENT_ENCODING_GZIP = "gzip";
    private static final String NAME = "RequestBodyUtil";
    private static final String TEMP_FILE_SUFFIX = "temp";

    RequestBodyUtil() {
    }

    public static RequestBody create(final MediaType mediaType, final InputStream inputStream) {
        return new RequestBody() {
            public long contentLength() {
                try {
                    return (long) inputStream.available();
                } catch (IOException unused) {
                    return 0;
                }
            }

            public MediaType contentType() {
                return MediaType.this;
            }

            public void writeTo(BufferedSink bufferedSink) throws IOException {
                Source source = null;
                try {
                    source = Okio.l(inputStream);
                    bufferedSink.y(source);
                } finally {
                    Util.closeQuietly((Closeable) source);
                }
            }
        };
    }

    public static RequestBody createGzip(MediaType mediaType, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            return RequestBody.create(mediaType, byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            return null;
        }
    }

    public static ProgressRequestBody createProgressRequest(RequestBody requestBody, ProgressListener progressListener) {
        return new ProgressRequestBody(requestBody, progressListener);
    }

    private static InputStream getDownloadFileInputStream(Context context, Uri uri) throws IOException {
        FileOutputStream fileOutputStream;
        File createTempFile = File.createTempFile(NAME, TEMP_FILE_SUFFIX, context.getApplicationContext().getCacheDir());
        createTempFile.deleteOnExit();
        InputStream openStream = new URL(uri.toString()).openStream();
        try {
            ReadableByteChannel newChannel = Channels.newChannel(openStream);
            try {
                fileOutputStream = new FileOutputStream(createTempFile);
                fileOutputStream.getChannel().transferFrom(newChannel, 0, Clock.MAX_TIME);
                FileInputStream fileInputStream = new FileInputStream(createTempFile);
                fileOutputStream.close();
                newChannel.close();
                return fileInputStream;
            } catch (Throwable th) {
                newChannel.close();
                throw th;
            }
        } finally {
            openStream.close();
        }
    }

    public static RequestBody getEmptyBody(String str) {
        if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH")) {
            return RequestBody.create((MediaType) null, ByteString.f41332f);
        }
        return null;
    }

    public static InputStream getFileInputStream(Context context, String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse.getScheme().startsWith(UriUtil.HTTP_SCHEME)) {
                return getDownloadFileInputStream(context, parse);
            }
            return context.getContentResolver().openInputStream(parse);
        } catch (Exception e2) {
            FLog.e(ReactConstants.TAG, "Could not retrieve file for contentUri " + str, (Throwable) e2);
            return null;
        }
    }

    public static boolean isGzipEncoding(String str) {
        return CONTENT_ENCODING_GZIP.equalsIgnoreCase(str);
    }
}
