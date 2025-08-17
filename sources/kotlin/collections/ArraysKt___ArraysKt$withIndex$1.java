package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Lambda;

final class ArraysKt___ArraysKt$withIndex$1 extends Lambda implements Function0<Iterator<? extends T>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ T[] f40316f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$1(T[] tArr) {
        super(0);
        this.f40316f = tArr;
    }

    /* renamed from: b */
    public final Iterator<T> invoke() {
        return ArrayIteratorKt.a(this.f40316f);
    }
}
