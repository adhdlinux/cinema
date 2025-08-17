package kotlinx.serialization.internal;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

public abstract class CollectionSerializer<E, C extends Collection<? extends E>, B> extends CollectionLikeSerializer<E, C, B> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionSerializer(KSerializer<E> kSerializer) {
        super(kSerializer, (DefaultConstructorMarker) null);
        Intrinsics.f(kSerializer, "element");
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public Iterator<E> d(C c2) {
        Intrinsics.f(c2, "<this>");
        return c2.iterator();
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public int e(C c2) {
        Intrinsics.f(c2, "<this>");
        return c2.size();
    }
}
