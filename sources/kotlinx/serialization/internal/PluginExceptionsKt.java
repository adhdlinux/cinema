package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class PluginExceptionsKt {
    public static final void a(int i2, int i3, SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i4 = (~i2) & i3;
        for (int i5 = 0; i5 < 32; i5++) {
            if ((i4 & 1) != 0) {
                arrayList.add(serialDescriptor.f(i5));
            }
            i4 >>>= 1;
        }
        throw new MissingFieldException(arrayList, serialDescriptor.i());
    }
}
