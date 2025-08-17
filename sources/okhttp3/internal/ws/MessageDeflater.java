package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import okio.Buffer;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Sink;

public final class MessageDeflater implements Closeable {
    private final Buffer deflatedBytes;
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z2) {
        this.noContextTakeover = z2;
        Buffer buffer = new Buffer();
        this.deflatedBytes = buffer;
        Deflater deflater2 = new Deflater(-1, true);
        this.deflater = deflater2;
        this.deflaterSink = new DeflaterSink((Sink) buffer, deflater2);
    }

    private final boolean endsWith(Buffer buffer, ByteString byteString) {
        return buffer.x(buffer.size() - ((long) byteString.size()), byteString);
    }

    public void close() throws IOException {
        this.deflaterSink.close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        kotlin.io.CloseableKt.a(r2, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0058, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void deflate(okio.Buffer r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "buffer"
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            okio.Buffer r0 = r7.deflatedBytes
            long r0 = r0.size()
            r2 = 0
            r4 = 1
            r5 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 == 0) goto L_0x0068
            boolean r0 = r7.noContextTakeover
            if (r0 == 0) goto L_0x0021
            java.util.zip.Deflater r0 = r7.deflater
            r0.reset()
        L_0x0021:
            okio.DeflaterSink r0 = r7.deflaterSink
            long r1 = r8.size()
            r0.write(r8, r1)
            okio.DeflaterSink r0 = r7.deflaterSink
            r0.flush()
            okio.Buffer r0 = r7.deflatedBytes
            okio.ByteString r1 = okhttp3.internal.ws.MessageDeflaterKt.EMPTY_DEFLATE_BLOCK
            boolean r0 = r7.endsWith(r0, r1)
            if (r0 == 0) goto L_0x0059
            okio.Buffer r0 = r7.deflatedBytes
            long r0 = r0.size()
            r2 = 4
            long r2 = (long) r2
            long r0 = r0 - r2
            okio.Buffer r2 = r7.deflatedBytes
            r3 = 0
            okio.Buffer$UnsafeCursor r2 = okio.Buffer.m0(r2, r3, r4, r3)
            r2.i(r0)     // Catch:{ all -> 0x0052 }
            kotlin.io.CloseableKt.a(r2, r3)
            goto L_0x005e
        L_0x0052:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r0 = move-exception
            kotlin.io.CloseableKt.a(r2, r8)
            throw r0
        L_0x0059:
            okio.Buffer r0 = r7.deflatedBytes
            r0.writeByte(r5)
        L_0x005e:
            okio.Buffer r0 = r7.deflatedBytes
            long r1 = r0.size()
            r8.write(r0, r1)
            return
        L_0x0068:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Failed requirement."
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.MessageDeflater.deflate(okio.Buffer):void");
    }
}
