package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

public abstract class AbstractCollectionSerializer<Element, Collection, Builder> implements KSerializer<Collection> {
    private AbstractCollectionSerializer() {
    }

    public /* synthetic */ AbstractCollectionSerializer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void i(AbstractCollectionSerializer abstractCollectionSerializer, CompositeDecoder compositeDecoder, int i2, Object obj, boolean z2, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 8) != 0) {
                z2 = true;
            }
            abstractCollectionSerializer.h(compositeDecoder, i2, obj, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
    }

    private final int j(CompositeDecoder compositeDecoder, Builder builder) {
        int k2 = compositeDecoder.k(getDescriptor());
        c(builder, k2);
        return k2;
    }

    /* access modifiers changed from: protected */
    public abstract Builder a();

    /* access modifiers changed from: protected */
    public abstract int b(Builder builder);

    /* access modifiers changed from: protected */
    public abstract void c(Builder builder, int i2);

    /* access modifiers changed from: protected */
    public abstract Iterator<Element> d(Collection collection);

    public Collection deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return f(decoder, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract int e(Collection collection);

    public final Collection f(Decoder decoder, Collection collection) {
        Object obj;
        Intrinsics.f(decoder, "decoder");
        if (collection == null || (obj = k(collection)) == null) {
            obj = a();
        }
        int b2 = b(obj);
        CompositeDecoder b3 = decoder.b(getDescriptor());
        if (!b3.p()) {
            while (true) {
                int o2 = b3.o(getDescriptor());
                if (o2 == -1) {
                    break;
                }
                i(this, b3, b2 + o2, obj, false, 8, (Object) null);
            }
        } else {
            g(b3, obj, b2, j(b3, obj));
        }
        b3.c(getDescriptor());
        return l(obj);
    }

    /* access modifiers changed from: protected */
    public abstract void g(CompositeDecoder compositeDecoder, Builder builder, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract void h(CompositeDecoder compositeDecoder, int i2, Builder builder, boolean z2);

    /* access modifiers changed from: protected */
    public abstract Builder k(Collection collection);

    /* access modifiers changed from: protected */
    public abstract Collection l(Builder builder);
}
