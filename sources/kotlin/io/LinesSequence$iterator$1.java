package kotlin.io;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class LinesSequence$iterator$1 implements Iterator<String>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private String f40391b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f40392c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ LinesSequence f40393d;

    LinesSequence$iterator$1(LinesSequence linesSequence) {
        this.f40393d = linesSequence;
    }

    /* renamed from: a */
    public String next() {
        if (hasNext()) {
            String str = this.f40391b;
            this.f40391b = null;
            Intrinsics.c(str);
            return str;
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        if (this.f40391b == null && !this.f40392c) {
            String readLine = this.f40393d.f40390a.readLine();
            this.f40391b = readLine;
            if (readLine == null) {
                this.f40392c = true;
            }
        }
        if (this.f40391b != null) {
            return true;
        }
        return false;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
