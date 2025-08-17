package com.google.android.exoplayer2.source.rtsp;

import java.util.TreeSet;

final class RtpPacketReorderingQueue {

    /* renamed from: a  reason: collision with root package name */
    private final TreeSet<RtpPacketContainer> f26779a = new TreeSet<>(new b());

    /* renamed from: b  reason: collision with root package name */
    private int f26780b;

    /* renamed from: c  reason: collision with root package name */
    private int f26781c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f26782d;

    private static final class RtpPacketContainer {

        /* renamed from: a  reason: collision with root package name */
        public final RtpPacket f26783a;

        /* renamed from: b  reason: collision with root package name */
        public final long f26784b;

        public RtpPacketContainer(RtpPacket rtpPacket, long j2) {
            this.f26783a = rtpPacket;
            this.f26784b = j2;
        }
    }

    public RtpPacketReorderingQueue() {
        g();
    }

    private synchronized void b(RtpPacketContainer rtpPacketContainer) {
        this.f26780b = rtpPacketContainer.f26783a.f26766g;
        this.f26779a.add(rtpPacketContainer);
    }

    /* access modifiers changed from: private */
    public static int c(int i2, int i3) {
        int min;
        int i4 = i2 - i3;
        if (Math.abs(i4) <= 1000 || (min = (Math.min(i2, i3) - Math.max(i2, i3)) + 65535) >= 1000) {
            return i4;
        }
        if (i2 < i3) {
            return min;
        }
        return -min;
    }

    public synchronized boolean e(RtpPacket rtpPacket, long j2) {
        if (this.f26779a.size() < 5000) {
            int i2 = rtpPacket.f26766g;
            if (!this.f26782d) {
                g();
                this.f26781c = RtpPacket.c(i2);
                this.f26782d = true;
                b(new RtpPacketContainer(rtpPacket, j2));
                return true;
            } else if (Math.abs(c(i2, RtpPacket.b(this.f26780b))) >= 1000) {
                this.f26781c = RtpPacket.c(i2);
                this.f26779a.clear();
                b(new RtpPacketContainer(rtpPacket, j2));
                return true;
            } else if (c(i2, this.f26781c) <= 0) {
                return false;
            } else {
                b(new RtpPacketContainer(rtpPacket, j2));
                return true;
            }
        } else {
            throw new IllegalStateException("Queue size limit of 5000 reached.");
        }
    }

    public synchronized RtpPacket f(long j2) {
        if (this.f26779a.isEmpty()) {
            return null;
        }
        RtpPacketContainer first = this.f26779a.first();
        int i2 = first.f26783a.f26766g;
        if (i2 != RtpPacket.b(this.f26781c) && j2 < first.f26784b) {
            return null;
        }
        this.f26779a.pollFirst();
        this.f26781c = i2;
        return first.f26783a;
    }

    public synchronized void g() {
        this.f26779a.clear();
        this.f26782d = false;
        this.f26781c = -1;
        this.f26780b = -1;
    }
}
