package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class SerialDescriptorKt$special$$inlined$Iterable$2 implements Iterable<String>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SerialDescriptor f40931b;

    public SerialDescriptorKt$special$$inlined$Iterable$2(SerialDescriptor serialDescriptor) {
        this.f40931b = serialDescriptor;
    }

    public Iterator<String> iterator() {
        return new SerialDescriptorKt$elementNames$1$1(this.f40931b);
    }
}
