package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

public abstract class CollectionLikeSerializer<Element, Collection, Builder> extends AbstractCollectionSerializer<Element, Collection, Builder> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final KSerializer<Element> f40966a;

    private CollectionLikeSerializer(KSerializer<Element> kSerializer) {
        super((DefaultConstructorMarker) null);
        this.f40966a = kSerializer;
    }

    public /* synthetic */ CollectionLikeSerializer(KSerializer kSerializer, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer);
    }

    /* access modifiers changed from: protected */
    public final void g(CompositeDecoder compositeDecoder, Builder builder, int i2, int i3) {
        boolean z2;
        Intrinsics.f(compositeDecoder, "decoder");
        if (i3 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            for (int i4 = 0; i4 < i3; i4++) {
                h(compositeDecoder, i2 + i4, builder, false);
            }
            return;
        }
        throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
    }

    public abstract SerialDescriptor getDescriptor();

    /* access modifiers changed from: protected */
    public void h(CompositeDecoder compositeDecoder, int i2, Builder builder, boolean z2) {
        Intrinsics.f(compositeDecoder, "decoder");
        n(builder, i2, CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), i2, this.f40966a, (Object) null, 8, (Object) null));
    }

    /* access modifiers changed from: protected */
    public abstract void n(Builder builder, int i2, Element element);

    public void serialize(Encoder encoder, Collection collection) {
        Intrinsics.f(encoder, "encoder");
        int e2 = e(collection);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder j2 = encoder.j(descriptor, e2);
        Iterator d2 = d(collection);
        for (int i2 = 0; i2 < e2; i2++) {
            j2.C(getDescriptor(), i2, this.f40966a, d2.next());
        }
        j2.c(descriptor);
    }
}
