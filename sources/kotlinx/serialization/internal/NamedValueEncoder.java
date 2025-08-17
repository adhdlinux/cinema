package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

public abstract class NamedValueEncoder extends TaggedEncoder<String> {
    /* access modifiers changed from: protected */
    public String d0(String str, String str2) {
        boolean z2;
        Intrinsics.f(str, "parentName");
        Intrinsics.f(str2, "childName");
        if (str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return str2;
        }
        return str + '.' + str2;
    }

    /* access modifiers changed from: protected */
    public String e0(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return serialDescriptor.f(i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f0 */
    public final String a0(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "<this>");
        return g0(e0(serialDescriptor, i2));
    }

    /* access modifiers changed from: protected */
    public final String g0(String str) {
        Intrinsics.f(str, "nestedName");
        String str2 = (String) Z();
        if (str2 == null) {
            str2 = "";
        }
        return d0(str2, str);
    }
}
