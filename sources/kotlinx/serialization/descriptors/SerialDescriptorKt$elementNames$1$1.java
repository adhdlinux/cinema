package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class SerialDescriptorKt$elementNames$1$1 implements Iterator<String>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    private int f40934b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SerialDescriptor f40935c;

    SerialDescriptorKt$elementNames$1$1(SerialDescriptor serialDescriptor) {
        this.f40935c = serialDescriptor;
        this.f40934b = serialDescriptor.e();
    }

    /* renamed from: a */
    public String next() {
        SerialDescriptor serialDescriptor = this.f40935c;
        int e2 = serialDescriptor.e();
        int i2 = this.f40934b;
        this.f40934b = i2 - 1;
        return serialDescriptor.f(e2 - i2);
    }

    public boolean hasNext() {
        return this.f40934b > 0;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
