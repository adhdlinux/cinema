package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

public abstract class MapLikeSerializer<Key, Value, Collection, Builder extends Map<Key, Value>> extends AbstractCollectionSerializer<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    /* renamed from: a  reason: collision with root package name */
    private final KSerializer<Key> f41028a;

    /* renamed from: b  reason: collision with root package name */
    private final KSerializer<Value> f41029b;

    private MapLikeSerializer(KSerializer<Key> kSerializer, KSerializer<Value> kSerializer2) {
        super((DefaultConstructorMarker) null);
        this.f41028a = kSerializer;
        this.f41029b = kSerializer2;
    }

    public /* synthetic */ MapLikeSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    public abstract SerialDescriptor getDescriptor();

    public final KSerializer<Key> m() {
        return this.f41028a;
    }

    public final KSerializer<Value> n() {
        return this.f41029b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public final void g(CompositeDecoder compositeDecoder, Builder builder, int i2, int i3) {
        boolean z2;
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(builder, "builder");
        if (i3 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            IntProgression i4 = RangesKt___RangesKt.i(RangesKt___RangesKt.j(0, i3 * 2), 2);
            int a2 = i4.a();
            int b2 = i4.b();
            int d2 = i4.d();
            if ((d2 > 0 && a2 <= b2) || (d2 < 0 && b2 <= a2)) {
                while (true) {
                    h(compositeDecoder, i2 + a2, builder, false);
                    if (a2 != b2) {
                        a2 += d2;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public final void h(CompositeDecoder compositeDecoder, int i2, Builder builder, boolean z2) {
        int i3;
        Value value;
        Intrinsics.f(compositeDecoder, "decoder");
        Intrinsics.f(builder, "builder");
        Object c2 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), i2, this.f41028a, (Object) null, 8, (Object) null);
        boolean z3 = true;
        if (z2) {
            i3 = compositeDecoder.o(getDescriptor());
            if (i3 != i2 + 1) {
                z3 = false;
            }
            if (!z3) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i2 + ", returned index for value: " + i3).toString());
            }
        } else {
            i3 = i2 + 1;
        }
        int i4 = i3;
        if (!builder.containsKey(c2) || (this.f41029b.getDescriptor().d() instanceof PrimitiveKind)) {
            value = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), i4, this.f41029b, (Object) null, 8, (Object) null);
        } else {
            value = compositeDecoder.y(getDescriptor(), i4, this.f41029b, MapsKt__MapsKt.h(builder, c2));
        }
        builder.put(c2, value);
    }

    public void serialize(Encoder encoder, Collection collection) {
        Intrinsics.f(encoder, "encoder");
        int e2 = e(collection);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder j2 = encoder.j(descriptor, e2);
        Iterator d2 = d(collection);
        int i2 = 0;
        while (d2.hasNext()) {
            Map.Entry entry = (Map.Entry) d2.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i3 = i2 + 1;
            j2.C(getDescriptor(), i2, m(), key);
            j2.C(getDescriptor(), i3, n(), value);
            i2 = i3 + 1;
        }
        j2.c(descriptor);
    }
}
