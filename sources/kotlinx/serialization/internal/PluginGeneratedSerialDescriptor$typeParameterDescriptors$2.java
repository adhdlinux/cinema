package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

final class PluginGeneratedSerialDescriptor$typeParameterDescriptors$2 extends Lambda implements Function0<SerialDescriptor[]> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PluginGeneratedSerialDescriptor f41060f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PluginGeneratedSerialDescriptor$typeParameterDescriptors$2(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        super(0);
        this.f41060f = pluginGeneratedSerialDescriptor;
    }

    /* renamed from: b */
    public final SerialDescriptor[] invoke() {
        ArrayList arrayList;
        KSerializer[] typeParametersSerializers;
        GeneratedSerializer k2 = this.f41060f.f41046b;
        if (k2 == null || (typeParametersSerializers = k2.typeParametersSerializers()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(typeParametersSerializers.length);
            for (KSerializer descriptor : typeParametersSerializers) {
                arrayList.add(descriptor.getDescriptor());
            }
        }
        return Platform_commonKt.b(arrayList);
    }
}
