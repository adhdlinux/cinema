package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class SerialDescriptorKt$elementDescriptors$1$1 implements Iterator<SerialDescriptor>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private int f40932b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SerialDescriptor f40933c;

    SerialDescriptorKt$elementDescriptors$1$1(SerialDescriptor serialDescriptor) {
        this.f40933c = serialDescriptor;
        this.f40932b = serialDescriptor.e();
    }

    /* renamed from: a */
    public SerialDescriptor next() {
        SerialDescriptor serialDescriptor = this.f40933c;
        int e2 = serialDescriptor.e();
        int i2 = this.f40932b;
        this.f40932b = i2 - 1;
        return serialDescriptor.h(e2 - i2);
    }

    public boolean hasNext() {
        return this.f40932b > 0;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
