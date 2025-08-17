package com.facebook.react.modules.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class ProgressResponseBody extends ResponseBody {
    private BufferedSource mBufferedSource;
    /* access modifiers changed from: private */
    public final ProgressListener mProgressListener;
    /* access modifiers changed from: private */
    public final ResponseBody mResponseBody;
    /* access modifiers changed from: private */
    public long mTotalBytesRead = 0;

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        this.mResponseBody = responseBody;
        this.mProgressListener = progressListener;
    }

    static /* synthetic */ long access$014(ProgressResponseBody progressResponseBody, long j2) {
        long j3 = progressResponseBody.mTotalBytesRead + j2;
        progressResponseBody.mTotalBytesRead = j3;
        return j3;
    }

    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    public MediaType contentType() {
        return this.mResponseBody.contentType();
    }

    public BufferedSource source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = Okio.d(source(this.mResponseBody.source()));
        }
        return this.mBufferedSource;
    }

    public long totalBytesRead() {
        return this.mTotalBytesRead;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) {
            public long read(Buffer buffer, long j2) throws IOException {
                long j3;
                boolean z2;
                long read = super.read(buffer, j2);
                ProgressResponseBody progressResponseBody = ProgressResponseBody.this;
                int i2 = (read > -1 ? 1 : (read == -1 ? 0 : -1));
                if (i2 != 0) {
                    j3 = read;
                } else {
                    j3 = 0;
                }
                ProgressResponseBody.access$014(progressResponseBody, j3);
                ProgressListener access$200 = ProgressResponseBody.this.mProgressListener;
                long access$000 = ProgressResponseBody.this.mTotalBytesRead;
                long contentLength = ProgressResponseBody.this.mResponseBody.contentLength();
                if (i2 == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                access$200.onProgress(access$000, contentLength, z2);
                return read;
            }
        };
    }
}
