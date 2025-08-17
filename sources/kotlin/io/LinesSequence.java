package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

final class LinesSequence implements Sequence<String> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final BufferedReader f40390a;

    public LinesSequence(BufferedReader bufferedReader) {
        Intrinsics.f(bufferedReader, "reader");
        this.f40390a = bufferedReader;
    }

    public Iterator<String> iterator() {
        return new LinesSequence$iterator$1(this);
    }
}
