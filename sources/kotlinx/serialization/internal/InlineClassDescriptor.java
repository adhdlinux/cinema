package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class InlineClassDescriptor extends PluginGeneratedSerialDescriptor {

    /* renamed from: m  reason: collision with root package name */
    private final boolean f41001m = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InlineClassDescriptor(String str, GeneratedSerializer<?> generatedSerializer) {
        super(str, generatedSerializer, 1);
        Intrinsics.f(str, "name");
        Intrinsics.f(generatedSerializer, "generatedSerializer");
    }

    public boolean equals(Object obj) {
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj instanceof InlineClassDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.a(i(), serialDescriptor.i())) {
                InlineClassDescriptor inlineClassDescriptor = (InlineClassDescriptor) obj;
                if (!inlineClassDescriptor.isInline() || !Arrays.equals(p(), inlineClassDescriptor.p())) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2 && e() == serialDescriptor.e()) {
                    int e2 = e();
                    int i2 = 0;
                    while (i2 < e2) {
                        if (Intrinsics.a(h(i2).i(), serialDescriptor.h(i2).i()) && Intrinsics.a(h(i2).d(), serialDescriptor.h(i2).d())) {
                            i2++;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode() * 31;
    }

    public boolean isInline() {
        return this.f41001m;
    }
}
