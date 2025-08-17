package kotlinx.serialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;

final class SerialDescriptorImpl$_hashCode$2 extends Lambda implements Function0<Integer> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ SerialDescriptorImpl f40928f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SerialDescriptorImpl$_hashCode$2(SerialDescriptorImpl serialDescriptorImpl) {
        super(0);
        this.f40928f = serialDescriptorImpl;
    }

    /* renamed from: b */
    public final Integer invoke() {
        SerialDescriptorImpl serialDescriptorImpl = this.f40928f;
        return Integer.valueOf(PluginGeneratedSerialDescriptorKt.a(serialDescriptorImpl, serialDescriptorImpl.f40926k));
    }
}
