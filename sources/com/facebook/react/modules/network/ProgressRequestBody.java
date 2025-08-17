package com.facebook.react.modules.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

public class ProgressRequestBody extends RequestBody {
    private long mContentLength = 0;
    /* access modifiers changed from: private */
    public final ProgressListener mProgressListener;
    private final RequestBody mRequestBody;

    public ProgressRequestBody(RequestBody requestBody, ProgressListener progressListener) {
        this.mRequestBody = requestBody;
        this.mProgressListener = progressListener;
    }

    private Sink outputStreamSink(BufferedSink bufferedSink) {
        return Okio.h(new CountingOutputStream(bufferedSink.k0()) {
            private void sendProgressUpdate() throws IOException {
                boolean z2;
                long count = getCount();
                long contentLength = ProgressRequestBody.this.contentLength();
                ProgressListener access$000 = ProgressRequestBody.this.mProgressListener;
                if (count == contentLength) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                access$000.onProgress(count, contentLength, z2);
            }

            public void write(byte[] bArr, int i2, int i3) throws IOException {
                super.write(bArr, i2, i3);
                sendProgressUpdate();
            }

            public void write(int i2) throws IOException {
                super.write(i2);
                sendProgressUpdate();
            }
        });
    }

    public long contentLength() throws IOException {
        if (this.mContentLength == 0) {
            this.mContentLength = this.mRequestBody.contentLength();
        }
        return this.mContentLength;
    }

    public MediaType contentType() {
        return this.mRequestBody.contentType();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        BufferedSink c2 = Okio.c(outputStreamSink(bufferedSink));
        contentLength();
        this.mRequestBody.writeTo(c2);
        c2.flush();
    }
}
