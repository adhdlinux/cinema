package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialKind;

public final class PluginGeneratedSerialDescriptorKt {
    public static final int a(SerialDescriptor serialDescriptor, SerialDescriptor[] serialDescriptorArr) {
        int i2;
        Intrinsics.f(serialDescriptor, "<this>");
        Intrinsics.f(serialDescriptorArr, "typeParams");
        int hashCode = (serialDescriptor.i().hashCode() * 31) + Arrays.hashCode(serialDescriptorArr);
        Iterable<SerialDescriptor> a2 = SerialDescriptorKt.a(serialDescriptor);
        Iterator<SerialDescriptor> it2 = a2.iterator();
        int i3 = 1;
        int i4 = 1;
        while (true) {
            int i5 = 0;
            if (!it2.hasNext()) {
                break;
            }
            int i6 = i4 * 31;
            String i7 = it2.next().i();
            if (i7 != null) {
                i5 = i7.hashCode();
            }
            i4 = i6 + i5;
        }
        for (SerialDescriptor d2 : a2) {
            int i8 = i3 * 31;
            SerialKind d3 = d2.d();
            if (d3 != null) {
                i2 = d3.hashCode();
            } else {
                i2 = 0;
            }
            i3 = i8 + i2;
        }
        return (((hashCode * 31) + i4) * 31) + i3;
    }
}
