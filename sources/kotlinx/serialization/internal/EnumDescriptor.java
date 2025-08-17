package kotlinx.serialization.internal;

import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialKind;

public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {

    /* renamed from: m  reason: collision with root package name */
    private final SerialKind f40984m = SerialKind.ENUM.f40938a;

    /* renamed from: n  reason: collision with root package name */
    private final Lazy f40985n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnumDescriptor(String str, int i2) {
        super(str, (GeneratedSerializer) null, i2, 2, (DefaultConstructorMarker) null);
        Intrinsics.f(str, "name");
        this.f40985n = LazyKt__LazyJVMKt.b(new EnumDescriptor$elementDescriptors$2(i2, str, this));
    }

    private final SerialDescriptor[] r() {
        return (SerialDescriptor[]) this.f40985n.getValue();
    }

    public SerialKind d() {
        return this.f40984m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        if (serialDescriptor.d() == SerialKind.ENUM.f40938a && Intrinsics.a(i(), serialDescriptor.i()) && Intrinsics.a(Platform_commonKt.a(this), Platform_commonKt.a(serialDescriptor))) {
            return true;
        }
        return false;
    }

    public SerialDescriptor h(int i2) {
        return r()[i2];
    }

    public int hashCode() {
        int i2;
        int hashCode = i().hashCode();
        int i3 = 1;
        for (String next : SerialDescriptorKt.b(this)) {
            int i4 = i3 * 31;
            if (next != null) {
                i2 = next.hashCode();
            } else {
                i2 = 0;
            }
            i3 = i4 + i2;
        }
        return (hashCode * 31) + i3;
    }

    public String toString() {
        Iterable<String> b2 = SerialDescriptorKt.b(this);
        return CollectionsKt___CollectionsKt.J(b2, ", ", i() + '(', ")", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }
}
