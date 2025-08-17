package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;

final class EnumDescriptor$elementDescriptors$2 extends Lambda implements Function0<SerialDescriptor[]> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ int f40986f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ String f40987g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ EnumDescriptor f40988h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnumDescriptor$elementDescriptors$2(int i2, String str, EnumDescriptor enumDescriptor) {
        super(0);
        this.f40986f = i2;
        this.f40987g = str;
        this.f40988h = enumDescriptor;
    }

    /* renamed from: b */
    public final SerialDescriptor[] invoke() {
        int i2 = this.f40986f;
        SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            serialDescriptorArr[i3] = SerialDescriptorsKt.d(this.f40987g + '.' + this.f40988h.f(i3), StructureKind.OBJECT.f40942a, new SerialDescriptor[0], (Function1) null, 8, (Object) null);
        }
        return serialDescriptorArr;
    }
}
