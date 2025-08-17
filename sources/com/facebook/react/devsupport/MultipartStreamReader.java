package com.facebook.react.devsupport;

import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public class MultipartStreamReader {
    private static final String CRLF = "\r\n";
    private final String mBoundary;
    private long mLastProgressEvent;
    private final BufferedSource mSource;

    public interface ChunkListener {
        void onChunkComplete(Map<String, String> map, Buffer buffer, boolean z2) throws IOException;

        void onChunkProgress(Map<String, String> map, long j2, long j3) throws IOException;
    }

    public MultipartStreamReader(BufferedSource bufferedSource, String str) {
        this.mSource = bufferedSource;
        this.mBoundary = str;
    }

    private void emitChunk(Buffer buffer, boolean z2, ChunkListener chunkListener) throws IOException {
        ByteString e2 = ByteString.e("\r\n\r\n");
        long B = buffer.B(e2);
        if (B == -1) {
            chunkListener.onChunkComplete((Map<String, String>) null, buffer, z2);
            return;
        }
        Buffer buffer2 = new Buffer();
        Buffer buffer3 = new Buffer();
        buffer.read(buffer2, B);
        buffer.skip((long) e2.size());
        buffer.i0(buffer3);
        chunkListener.onChunkComplete(parseHeaders(buffer2), buffer3, z2);
    }

    private void emitProgress(Map<String, String> map, long j2, boolean z2, ChunkListener chunkListener) throws IOException {
        long j3;
        if (map != null && chunkListener != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastProgressEvent > 16 || z2) {
                this.mLastProgressEvent = currentTimeMillis;
                if (map.get("Content-Length") != null) {
                    j3 = Long.parseLong(map.get("Content-Length"));
                } else {
                    j3 = 0;
                }
                chunkListener.onChunkProgress(map, j2, j3);
            }
        }
    }

    private Map<String, String> parseHeaders(Buffer buffer) {
        HashMap hashMap = new HashMap();
        for (String str : buffer.f0().split(CRLF)) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                hashMap.put(str.substring(0, indexOf).trim(), str.substring(indexOf + 1).trim());
            }
        }
        return hashMap;
    }

    public boolean readAllParts(ChunkListener chunkListener) throws IOException {
        boolean z2;
        long j2;
        ByteString e2 = ByteString.e("\r\n--" + this.mBoundary + CRLF);
        ByteString e3 = ByteString.e("\r\n--" + this.mBoundary + "--" + CRLF);
        ByteString e4 = ByteString.e("\r\n\r\n");
        Buffer buffer = new Buffer();
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        Map<String, String> map = null;
        while (true) {
            long max = Math.max(j3 - ((long) e3.size()), j4);
            long D = buffer.D(e2, max);
            if (D == -1) {
                D = buffer.D(e3, max);
                z2 = true;
            } else {
                z2 = false;
            }
            if (D == -1) {
                long size = buffer.size();
                if (map == null) {
                    long D2 = buffer.D(e4, max);
                    if (D2 >= 0) {
                        this.mSource.read(buffer, D2);
                        Buffer buffer2 = new Buffer();
                        j2 = j4;
                        buffer.q(buffer2, max, D2 - max);
                        j5 = buffer2.size() + ((long) e4.size());
                        map = parseHeaders(buffer2);
                    } else {
                        j2 = j4;
                    }
                } else {
                    j2 = j4;
                    emitProgress(map, buffer.size() - j5, false, chunkListener);
                }
                if (this.mSource.read(buffer, (long) CodedOutputStream.DEFAULT_BUFFER_SIZE) <= 0) {
                    return false;
                }
                j3 = size;
                j4 = j2;
            } else {
                long j6 = j4;
                long j7 = D - j6;
                if (j6 > 0) {
                    Buffer buffer3 = new Buffer();
                    buffer.skip(j6);
                    buffer.read(buffer3, j7);
                    emitProgress(map, buffer3.size() - j5, true, chunkListener);
                    emitChunk(buffer3, z2, chunkListener);
                    j5 = 0;
                    map = null;
                } else {
                    ChunkListener chunkListener2 = chunkListener;
                    buffer.skip(D);
                }
                if (z2) {
                    return true;
                }
                j4 = (long) e2.size();
                j3 = j4;
            }
        }
    }
}
