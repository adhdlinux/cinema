package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

public abstract class NamedValueDecoder extends TaggedDecoder<String> {
    /* access modifiers changed from: protected */
    public String b0(String str, String str2) {
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
    public String c0(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "desc");
        return serialDescriptor.f(i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d0 */
    public final String X(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "<this>");
        return e0(c0(serialDescriptor, i2));
    }

    /* access modifiers changed from: protected */
    public final String e0(String str) {
        Intrinsics.f(str, "nestedName");
        String str2 = (String) W();
        if (str2 == null) {
            str2 = "";
        }
        return b0(str2, str);
    }
}
