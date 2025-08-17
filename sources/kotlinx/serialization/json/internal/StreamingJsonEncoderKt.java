package kotlinx.serialization.json.internal;

import java.util.Set;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class StreamingJsonEncoderKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<SerialDescriptor> f41275a = SetsKt__SetsKt.d(BuiltinSerializersKt.u(UInt.f40282c).getDescriptor(), BuiltinSerializersKt.v(ULong.f40287c).getDescriptor(), BuiltinSerializersKt.t(UByte.f40277c).getDescriptor(), BuiltinSerializersKt.w(UShort.f40293c).getDescriptor());

    public static final boolean a(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "<this>");
        if (!serialDescriptor.isInline() || !f41275a.contains(serialDescriptor)) {
            return false;
        }
        return true;
    }
}
