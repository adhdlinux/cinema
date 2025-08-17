package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

public final class LineReader {

    /* renamed from: a  reason: collision with root package name */
    private final Readable f30691a;

    /* renamed from: b  reason: collision with root package name */
    private final Reader f30692b;

    /* renamed from: c  reason: collision with root package name */
    private final CharBuffer f30693c;

    /* renamed from: d  reason: collision with root package name */
    private final char[] f30694d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Queue<String> f30695e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    private final LineBuffer f30696f = new LineBuffer() {
        /* access modifiers changed from: protected */
        public void d(String str, String str2) {
            LineReader.this.f30695e.add(str);
        }
    };

    public LineReader(Readable readable) {
        Reader reader;
        CharBuffer e2 = CharStreams.e();
        this.f30693c = e2;
        this.f30694d = e2.array();
        this.f30691a = (Readable) Preconditions.l(readable);
        if (readable instanceof Reader) {
            reader = (Reader) readable;
        } else {
            reader = null;
        }
        this.f30692b = reader;
    }

    public String b() throws IOException {
        int i2;
        while (true) {
            if (this.f30695e.peek() != null) {
                break;
            }
            Java8Compatibility.a(this.f30693c);
            Reader reader = this.f30692b;
            if (reader != null) {
                char[] cArr = this.f30694d;
                i2 = reader.read(cArr, 0, cArr.length);
            } else {
                i2 = this.f30691a.read(this.f30693c);
            }
            if (i2 == -1) {
                this.f30696f.b();
                break;
            }
            this.f30696f.a(this.f30694d, 0, i2);
        }
        return this.f30695e.poll();
    }
}
