package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class SerialDescriptorKt$special$$inlined$Iterable$1 implements Iterable<SerialDescriptor>, KMappedMarker {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SerialDescriptor f40930b;

    public SerialDescriptorKt$special$$inlined$Iterable$1(SerialDescriptor serialDescriptor) {
        this.f40930b = serialDescriptor;
    }

    public Iterator<SerialDescriptor> iterator() {
        return new SerialDescriptorKt$elementDescriptors$1$1(this.f40930b);
    }
}
