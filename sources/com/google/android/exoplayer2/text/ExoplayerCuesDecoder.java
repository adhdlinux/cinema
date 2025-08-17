package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public final class ExoplayerCuesDecoder implements SubtitleDecoder {

    /* renamed from: a  reason: collision with root package name */
    private final CueDecoder f27242a = new CueDecoder();

    /* renamed from: b  reason: collision with root package name */
    private final SubtitleInputBuffer f27243b = new SubtitleInputBuffer();

    /* renamed from: c  reason: collision with root package name */
    private final Deque<SubtitleOutputBuffer> f27244c = new ArrayDeque();

    /* renamed from: d  reason: collision with root package name */
    private int f27245d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27246e;

    private static final class SingleEventSubtitle implements Subtitle {

        /* renamed from: b  reason: collision with root package name */
        private final long f27248b;

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableList<Cue> f27249c;

        public SingleEventSubtitle(long j2, ImmutableList<Cue> immutableList) {
            this.f27248b = j2;
            this.f27249c = immutableList;
        }

        public int a(long j2) {
            return this.f27248b > j2 ? 0 : -1;
        }

        public List<Cue> b(long j2) {
            return j2 >= this.f27248b ? this.f27249c : ImmutableList.r();
        }

        public long c(int i2) {
            boolean z2;
            if (i2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            return this.f27248b;
        }

        public int d() {
            return 1;
        }
    }

    public ExoplayerCuesDecoder() {
        for (int i2 = 0; i2 < 2; i2++) {
            this.f27244c.addFirst(new SubtitleOutputBuffer() {
                public void p() {
                    ExoplayerCuesDecoder.this.i(this);
                }
            });
        }
        this.f27245d = 0;
    }

    /* access modifiers changed from: private */
    public void i(SubtitleOutputBuffer subtitleOutputBuffer) {
        boolean z2;
        if (this.f27244c.size() < 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        Assertions.a(!this.f27244c.contains(subtitleOutputBuffer));
        subtitleOutputBuffer.f();
        this.f27244c.addFirst(subtitleOutputBuffer);
    }

    public void b(long j2) {
    }

    /* renamed from: f */
    public SubtitleInputBuffer d() throws SubtitleDecoderException {
        Assertions.g(!this.f27246e);
        if (this.f27245d != 0) {
            return null;
        }
        this.f27245d = 1;
        return this.f27243b;
    }

    public void flush() {
        Assertions.g(!this.f27246e);
        this.f27243b.f();
        this.f27245d = 0;
    }

    /* renamed from: g */
    public SubtitleOutputBuffer a() throws SubtitleDecoderException {
        Assertions.g(!this.f27246e);
        if (this.f27245d != 2 || this.f27244c.isEmpty()) {
            return null;
        }
        SubtitleOutputBuffer removeFirst = this.f27244c.removeFirst();
        if (this.f27243b.k()) {
            removeFirst.e(4);
        } else {
            SubtitleInputBuffer subtitleInputBuffer = this.f27243b;
            SingleEventSubtitle singleEventSubtitle = new SingleEventSubtitle(subtitleInputBuffer.f23963f, this.f27242a.a(((ByteBuffer) Assertions.e(subtitleInputBuffer.f23961d)).array()));
            removeFirst.q(this.f27243b.f23963f, singleEventSubtitle, 0);
        }
        this.f27243b.f();
        this.f27245d = 0;
        return removeFirst;
    }

    /* renamed from: h */
    public void c(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        boolean z2;
        boolean z3 = true;
        Assertions.g(!this.f27246e);
        if (this.f27245d == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        if (this.f27243b != subtitleInputBuffer) {
            z3 = false;
        }
        Assertions.a(z3);
        this.f27245d = 2;
    }

    public void release() {
        this.f27246e = true;
    }
}
