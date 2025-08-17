package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class Relay {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long FILE_HEADER_SIZE = 32;
    public static final ByteString PREFIX_CLEAN;
    public static final ByteString PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;
    private Source upstream;
    private final Buffer upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Relay edit(File file, Source source, ByteString byteString, long j2) throws IOException {
            Intrinsics.f(file, "file");
            Intrinsics.f(source, "upstream");
            Intrinsics.f(byteString, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, source, 0, byteString, j2, (DefaultConstructorMarker) null);
            randomAccessFile.setLength(0);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1, -1);
            return relay;
        }

        public final Relay read(File file) throws IOException {
            Intrinsics.f(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.e(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            Buffer buffer = new Buffer();
            fileOperator.read(0, buffer, 32);
            ByteString byteString = Relay.PREFIX_CLEAN;
            if (Intrinsics.a(buffer.Q((long) byteString.size()), byteString)) {
                long readLong = buffer.readLong();
                long readLong2 = buffer.readLong();
                Buffer buffer2 = new Buffer();
                fileOperator.read(readLong + 32, buffer2, readLong2);
                return new Relay(randomAccessFile, (Source) null, readLong, buffer2.c0(), 0, (DefaultConstructorMarker) null);
            }
            throw new IOException("unreadable cache file");
        }
    }

    public final class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            Intrinsics.c(file);
            FileChannel channel = file.getChannel();
            Intrinsics.e(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                RandomAccessFile randomAccessFile = null;
                this.fileOperator = null;
                Relay relay = Relay.this;
                synchronized (relay) {
                    relay.setSourceCount(relay.getSourceCount() - 1);
                    if (relay.getSourceCount() == 0) {
                        RandomAccessFile file = relay.getFile();
                        relay.setFile((RandomAccessFile) null);
                        randomAccessFile = file;
                    }
                    Unit unit = Unit.f40298a;
                }
                if (randomAccessFile != null) {
                    Util.closeQuietly((Closeable) randomAccessFile);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
            r6 = r8.getUpstreamPos() - r8.getBuffer().size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
            if (r1.sourcePos >= r6) goto L_0x0155;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
            r4 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
            if (r4 != 2) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
            r10 = java.lang.Math.min(r2, r1.this$0.getUpstreamPos() - r1.sourcePos);
            r2 = r1.fileOperator;
            kotlin.jvm.internal.Intrinsics.c(r2);
            r2.read(r1.sourcePos + 32, r20, r10);
            r1.sourcePos += r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x007a, code lost:
            return r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r0 = r1.this$0.getUpstream();
            kotlin.jvm.internal.Intrinsics.c(r0);
            r14 = r0.read(r1.this$0.getUpstreamBuffer(), r1.this$0.getBufferMaxSize());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
            if (r14 != -1) goto L_0x00b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0099, code lost:
            r0 = r1.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a2, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a4, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            kotlin.jvm.internal.Intrinsics.d(r2, "null cannot be cast to non-null type java.lang.Object");
            r2.notifyAll();
            r0 = kotlin.Unit.f40298a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b2, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b3, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            r11 = java.lang.Math.min(r14, r2);
            r1.this$0.getUpstreamBuffer().q(r20, 0, r11);
            r1.sourcePos += r11;
            r13 = r1.fileOperator;
            kotlin.jvm.internal.Intrinsics.c(r13);
            r4 = r14;
            r13.write(r1.this$0.getUpstreamPos() + 32, r1.this$0.getUpstreamBuffer().clone(), r4);
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ee, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r2.getBuffer().write(r2.getUpstreamBuffer(), r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0108, code lost:
            if (r2.getBuffer().size() <= r2.getBufferMaxSize()) goto L_0x011e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x010a, code lost:
            r2.getBuffer().skip(r2.getBuffer().size() - r2.getBufferMaxSize());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x011e, code lost:
            r2.setUpstreamPos(r2.getUpstreamPos() + r4);
            r0 = kotlin.Unit.f40298a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0129, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x012b, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            kotlin.jvm.internal.Intrinsics.d(r2, "null cannot be cast to non-null type java.lang.Object");
            r2.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0137, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0138, code lost:
            return r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x013f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0140, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0142, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            kotlin.jvm.internal.Intrinsics.d(r2, "null cannot be cast to non-null type java.lang.Object");
            r2.notifyAll();
            r3 = kotlin.Unit.f40298a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0151, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            r9 = java.lang.Math.min(r2, r8.getUpstreamPos() - r1.sourcePos);
            r8.getBuffer().q(r20, r1.sourcePos - r6, r9);
            r1.sourcePos += r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0175, code lost:
            return r9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(okio.Buffer r20, long r21) throws java.io.IOException {
            /*
                r19 = this;
                r1 = r19
                r2 = r21
                java.lang.String r0 = "sink"
                r5 = r20
                kotlin.jvm.internal.Intrinsics.f(r5, r0)
                okhttp3.internal.cache2.FileOperator r0 = r1.fileOperator
                r4 = 1
                if (r0 == 0) goto L_0x0012
                r0 = 1
                goto L_0x0013
            L_0x0012:
                r0 = 0
            L_0x0013:
                if (r0 == 0) goto L_0x0179
                okhttp3.internal.cache2.Relay r8 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r8)
            L_0x0018:
                long r6 = r8.getUpstreamPos()     // Catch:{ all -> 0x0176 }
                long r9 = r1.sourcePos     // Catch:{ all -> 0x0176 }
                r0 = 2
                r11 = -1
                int r13 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
                if (r13 != 0) goto L_0x0041
                boolean r6 = r8.getComplete()     // Catch:{ all -> 0x0176 }
                if (r6 == 0) goto L_0x002d
                monitor-exit(r8)
                return r11
            L_0x002d:
                java.lang.Thread r6 = r8.getUpstreamReader()     // Catch:{ all -> 0x0176 }
                if (r6 == 0) goto L_0x0039
                okio.Timeout r0 = r1.timeout     // Catch:{ all -> 0x0176 }
                r0.waitUntilNotified(r8)     // Catch:{ all -> 0x0176 }
                goto L_0x0018
            L_0x0039:
                java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0176 }
                r8.setUpstreamReader(r6)     // Catch:{ all -> 0x0176 }
                goto L_0x0055
            L_0x0041:
                long r6 = r8.getUpstreamPos()     // Catch:{ all -> 0x0176 }
                okio.Buffer r4 = r8.getBuffer()     // Catch:{ all -> 0x0176 }
                long r9 = r4.size()     // Catch:{ all -> 0x0176 }
                long r6 = r6 - r9
                long r9 = r1.sourcePos     // Catch:{ all -> 0x0176 }
                int r4 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
                if (r4 >= 0) goto L_0x0155
                r4 = 2
            L_0x0055:
                monitor-exit(r8)
                r8 = 32
                if (r4 != r0) goto L_0x007b
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this
                long r6 = r0.getUpstreamPos()
                long r10 = r1.sourcePos
                long r6 = r6 - r10
                long r10 = java.lang.Math.min(r2, r6)
                okhttp3.internal.cache2.FileOperator r2 = r1.fileOperator
                kotlin.jvm.internal.Intrinsics.c(r2)
                long r3 = r1.sourcePos
                long r3 = r3 + r8
                r5 = r20
                r6 = r10
                r2.read(r3, r5, r6)
                long r2 = r1.sourcePos
                long r2 = r2 + r10
                r1.sourcePos = r2
                return r10
            L_0x007b:
                r10 = 0
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013f }
                okio.Source r0 = r0.getUpstream()     // Catch:{ all -> 0x013f }
                kotlin.jvm.internal.Intrinsics.c(r0)     // Catch:{ all -> 0x013f }
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013f }
                okio.Buffer r4 = r4.getUpstreamBuffer()     // Catch:{ all -> 0x013f }
                okhttp3.internal.cache2.Relay r6 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013f }
                long r6 = r6.getBufferMaxSize()     // Catch:{ all -> 0x013f }
                long r14 = r0.read(r4, r6)     // Catch:{ all -> 0x013f }
                int r0 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
                if (r0 != 0) goto L_0x00b7
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013f }
                long r2 = r0.getUpstreamPos()     // Catch:{ all -> 0x013f }
                r0.commit(r2)     // Catch:{ all -> 0x013f }
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                r2.setUpstreamReader(r10)     // Catch:{ all -> 0x00b4 }
                java.lang.String r0 = "null cannot be cast to non-null type java.lang.Object"
                kotlin.jvm.internal.Intrinsics.d(r2, r0)     // Catch:{ all -> 0x00b4 }
                r2.notifyAll()     // Catch:{ all -> 0x00b4 }
                kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x00b4 }
                monitor-exit(r2)
                return r11
            L_0x00b4:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x00b7:
                long r11 = java.lang.Math.min(r14, r2)     // Catch:{ all -> 0x013f }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013f }
                okio.Buffer r2 = r0.getUpstreamBuffer()     // Catch:{ all -> 0x013f }
                r6 = 0
                r3 = r20
                r4 = r6
                r6 = r11
                r2.q(r3, r4, r6)     // Catch:{ all -> 0x013f }
                long r2 = r1.sourcePos     // Catch:{ all -> 0x013f }
                long r2 = r2 + r11
                r1.sourcePos = r2     // Catch:{ all -> 0x013f }
                okhttp3.internal.cache2.FileOperator r13 = r1.fileOperator     // Catch:{ all -> 0x013f }
                kotlin.jvm.internal.Intrinsics.c(r13)     // Catch:{ all -> 0x013f }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013f }
                long r2 = r0.getUpstreamPos()     // Catch:{ all -> 0x013f }
                long r2 = r2 + r8
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013f }
                okio.Buffer r0 = r0.getUpstreamBuffer()     // Catch:{ all -> 0x013f }
                okio.Buffer r16 = r0.clone()     // Catch:{ all -> 0x013f }
                r4 = r14
                r14 = r2
                r17 = r4
                r13.write(r14, r16, r17)     // Catch:{ all -> 0x013f }
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x013f }
                monitor-enter(r2)     // Catch:{ all -> 0x013f }
                okio.Buffer r0 = r2.getBuffer()     // Catch:{ all -> 0x013c }
                okio.Buffer r3 = r2.getUpstreamBuffer()     // Catch:{ all -> 0x013c }
                r0.write(r3, r4)     // Catch:{ all -> 0x013c }
                okio.Buffer r0 = r2.getBuffer()     // Catch:{ all -> 0x013c }
                long r6 = r0.size()     // Catch:{ all -> 0x013c }
                long r8 = r2.getBufferMaxSize()     // Catch:{ all -> 0x013c }
                int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r0 <= 0) goto L_0x011e
                okio.Buffer r0 = r2.getBuffer()     // Catch:{ all -> 0x013c }
                okio.Buffer r3 = r2.getBuffer()     // Catch:{ all -> 0x013c }
                long r6 = r3.size()     // Catch:{ all -> 0x013c }
                long r8 = r2.getBufferMaxSize()     // Catch:{ all -> 0x013c }
                long r6 = r6 - r8
                r0.skip(r6)     // Catch:{ all -> 0x013c }
            L_0x011e:
                long r6 = r2.getUpstreamPos()     // Catch:{ all -> 0x013c }
                long r6 = r6 + r4
                r2.setUpstreamPos(r6)     // Catch:{ all -> 0x013c }
                kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x013c }
                monitor-exit(r2)     // Catch:{ all -> 0x013f }
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                r2.setUpstreamReader(r10)     // Catch:{ all -> 0x0139 }
                java.lang.String r0 = "null cannot be cast to non-null type java.lang.Object"
                kotlin.jvm.internal.Intrinsics.d(r2, r0)     // Catch:{ all -> 0x0139 }
                r2.notifyAll()     // Catch:{ all -> 0x0139 }
                monitor-exit(r2)
                return r11
            L_0x0139:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x013c:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x013f }
                throw r0     // Catch:{ all -> 0x013f }
            L_0x013f:
                r0 = move-exception
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                r2.setUpstreamReader(r10)     // Catch:{ all -> 0x0152 }
                java.lang.String r3 = "null cannot be cast to non-null type java.lang.Object"
                kotlin.jvm.internal.Intrinsics.d(r2, r3)     // Catch:{ all -> 0x0152 }
                r2.notifyAll()     // Catch:{ all -> 0x0152 }
                kotlin.Unit r3 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0152 }
                monitor-exit(r2)
                throw r0
            L_0x0152:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x0155:
                long r9 = r8.getUpstreamPos()     // Catch:{ all -> 0x0176 }
                long r11 = r1.sourcePos     // Catch:{ all -> 0x0176 }
                long r9 = r9 - r11
                long r9 = java.lang.Math.min(r2, r9)     // Catch:{ all -> 0x0176 }
                okio.Buffer r2 = r8.getBuffer()     // Catch:{ all -> 0x0176 }
                long r3 = r1.sourcePos     // Catch:{ all -> 0x0176 }
                long r6 = r3 - r6
                r3 = r20
                r4 = r6
                r6 = r9
                r2.q(r3, r4, r6)     // Catch:{ all -> 0x0176 }
                long r2 = r1.sourcePos     // Catch:{ all -> 0x0176 }
                long r2 = r2 + r9
                r1.sourcePos = r2     // Catch:{ all -> 0x0176 }
                monitor-exit(r8)
                return r9
            L_0x0176:
                r0 = move-exception
                monitor-exit(r8)
                throw r0
            L_0x0179:
                java.lang.String r0 = "Check failed."
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }

    static {
        ByteString.Companion companion = ByteString.f41331e;
        PREFIX_CLEAN = companion.d("OkHttp cache v1\n");
        PREFIX_DIRTY = companion.d("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j2, ByteString byteString, long j3) {
        boolean z2;
        this.file = randomAccessFile;
        this.upstream = source;
        this.upstreamPos = j2;
        this.metadata = byteString;
        this.bufferMaxSize = j3;
        this.upstreamBuffer = new Buffer();
        if (this.upstream == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.complete = z2;
        this.buffer = new Buffer();
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, Source source, long j2, ByteString byteString, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(randomAccessFile, source, j2, byteString, j3);
    }

    /* access modifiers changed from: private */
    public final void writeHeader(ByteString byteString, long j2, long j3) throws IOException {
        boolean z2;
        Buffer buffer2 = new Buffer();
        buffer2.h0(byteString);
        buffer2.G0(j2);
        buffer2.G0(j3);
        if (buffer2.size() == 32) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            RandomAccessFile randomAccessFile = this.file;
            Intrinsics.c(randomAccessFile);
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.e(channel, "file!!.channel");
            new FileOperator(channel).write(0, buffer2, 32);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void writeMetadata(long j2) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.h0(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.c(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        Intrinsics.e(channel, "file!!.channel");
        new FileOperator(channel).write(32 + j2, buffer2, (long) this.metadata.size());
    }

    public final void commit(long j2) throws IOException {
        writeMetadata(j2);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.c(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j2, (long) this.metadata.size());
        RandomAccessFile randomAccessFile2 = this.file;
        Intrinsics.c(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
            Unit unit = Unit.f40298a;
        }
        Source source = this.upstream;
        if (source != null) {
            Util.closeQuietly((Closeable) source);
        }
        this.upstream = null;
    }

    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final Source getUpstream() {
        return this.upstream;
    }

    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z2) {
        this.complete = z2;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i2) {
        this.sourceCount = i2;
    }

    public final void setUpstream(Source source) {
        this.upstream = source;
    }

    public final void setUpstreamPos(long j2) {
        this.upstreamPos = j2;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }
}
