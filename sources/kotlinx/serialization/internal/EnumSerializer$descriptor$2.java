package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.SerialDescriptor;

final class EnumSerializer$descriptor$2 extends Lambda implements Function0<SerialDescriptor> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ EnumSerializer<T> f40992f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ String f40993g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnumSerializer$descriptor$2(EnumSerializer<T> enumSerializer, String str) {
        super(0);
        this.f40992f = enumSerializer;
        this.f40993g = str;
    }

    /* renamed from: b */
    public final SerialDescriptor invoke() {
        SerialDescriptor b2 = this.f40992f.f40990b;
        return b2 == null ? this.f40992f.c(this.f40993g) : b2;
    }
}
