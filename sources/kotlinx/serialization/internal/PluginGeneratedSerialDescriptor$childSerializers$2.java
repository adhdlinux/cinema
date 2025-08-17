package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;

final class PluginGeneratedSerialDescriptor$childSerializers$2 extends Lambda implements Function0<KSerializer<?>[]> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PluginGeneratedSerialDescriptor f41058f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PluginGeneratedSerialDescriptor$childSerializers$2(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        super(0);
        this.f41058f = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.childSerializers();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.serialization.KSerializer<?>[] invoke() {
        /*
            r1 = this;
            kotlinx.serialization.internal.PluginGeneratedSerialDescriptor r0 = r1.f41058f
            kotlinx.serialization.internal.GeneratedSerializer r0 = r0.f41046b
            if (r0 == 0) goto L_0x000e
            kotlinx.serialization.KSerializer[] r0 = r0.childSerializers()
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            kotlinx.serialization.KSerializer<?>[] r0 = kotlinx.serialization.internal.PluginHelperInterfacesKt.f41061a
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$childSerializers$2.invoke():kotlinx.serialization.KSerializer[]");
    }
}
