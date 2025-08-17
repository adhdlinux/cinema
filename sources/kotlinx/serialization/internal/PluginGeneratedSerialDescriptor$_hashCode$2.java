package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class PluginGeneratedSerialDescriptor$_hashCode$2 extends Lambda implements Function0<Integer> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PluginGeneratedSerialDescriptor f41057f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PluginGeneratedSerialDescriptor$_hashCode$2(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        super(0);
        this.f41057f = pluginGeneratedSerialDescriptor;
    }

    /* renamed from: b */
    public final Integer invoke() {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = this.f41057f;
        return Integer.valueOf(PluginGeneratedSerialDescriptorKt.a(pluginGeneratedSerialDescriptor, pluginGeneratedSerialDescriptor.p()));
    }
}
