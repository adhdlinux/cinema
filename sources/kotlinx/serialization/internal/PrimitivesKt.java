package kotlinx.serialization.internal;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.time.Duration;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class PrimitivesKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<KClass<? extends Object>, KSerializer<? extends Object>> f41066a = MapsKt__MapsKt.j(TuplesKt.a(Reflection.b(String.class), BuiltinSerializersKt.G(StringCompanionObject.f40434a)), TuplesKt.a(Reflection.b(Character.TYPE), BuiltinSerializersKt.A(CharCompanionObject.f40409a)), TuplesKt.a(Reflection.b(char[].class), BuiltinSerializersKt.d()), TuplesKt.a(Reflection.b(Double.TYPE), BuiltinSerializersKt.B(DoubleCompanionObject.f40418a)), TuplesKt.a(Reflection.b(double[].class), BuiltinSerializersKt.e()), TuplesKt.a(Reflection.b(Float.TYPE), BuiltinSerializersKt.C(FloatCompanionObject.f40419a)), TuplesKt.a(Reflection.b(float[].class), BuiltinSerializersKt.f()), TuplesKt.a(Reflection.b(Long.TYPE), BuiltinSerializersKt.E(LongCompanionObject.f40421a)), TuplesKt.a(Reflection.b(long[].class), BuiltinSerializersKt.i()), TuplesKt.a(Reflection.b(ULong.class), BuiltinSerializersKt.v(ULong.f40287c)), TuplesKt.a(Reflection.b(ULongArray.class), BuiltinSerializersKt.q()), TuplesKt.a(Reflection.b(Integer.TYPE), BuiltinSerializersKt.D(IntCompanionObject.f40420a)), TuplesKt.a(Reflection.b(int[].class), BuiltinSerializersKt.g()), TuplesKt.a(Reflection.b(UInt.class), BuiltinSerializersKt.u(UInt.f40282c)), TuplesKt.a(Reflection.b(UIntArray.class), BuiltinSerializersKt.p()), TuplesKt.a(Reflection.b(Short.TYPE), BuiltinSerializersKt.F(ShortCompanionObject.f40432a)), TuplesKt.a(Reflection.b(short[].class), BuiltinSerializersKt.m()), TuplesKt.a(Reflection.b(UShort.class), BuiltinSerializersKt.w(UShort.f40293c)), TuplesKt.a(Reflection.b(UShortArray.class), BuiltinSerializersKt.r()), TuplesKt.a(Reflection.b(Byte.TYPE), BuiltinSerializersKt.z(ByteCompanionObject.f40407a)), TuplesKt.a(Reflection.b(byte[].class), BuiltinSerializersKt.c()), TuplesKt.a(Reflection.b(UByte.class), BuiltinSerializersKt.t(UByte.f40277c)), TuplesKt.a(Reflection.b(UByteArray.class), BuiltinSerializersKt.o()), TuplesKt.a(Reflection.b(Boolean.TYPE), BuiltinSerializersKt.y(BooleanCompanionObject.f40406a)), TuplesKt.a(Reflection.b(boolean[].class), BuiltinSerializersKt.b()), TuplesKt.a(Reflection.b(Unit.class), BuiltinSerializersKt.x(Unit.f40298a)), TuplesKt.a(Reflection.b(Duration.class), BuiltinSerializersKt.H(Duration.f40567c)));

    public static final SerialDescriptor a(String str, PrimitiveKind primitiveKind) {
        Intrinsics.f(str, "serialName");
        Intrinsics.f(primitiveKind, "kind");
        d(str);
        return new PrimitiveSerialDescriptor(str, primitiveKind);
    }

    public static final <T> KSerializer<T> b(KClass<T> kClass) {
        Intrinsics.f(kClass, "<this>");
        return f41066a.get(kClass);
    }

    private static final String c(String str) {
        if (!(str.length() > 0)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char charAt = str.charAt(0);
        sb.append(Character.isLowerCase(charAt) ? CharsKt__CharKt.f(charAt) : String.valueOf(charAt));
        String substring = str.substring(1);
        Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
        sb.append(substring);
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void d(java.lang.String r4) {
        /*
            java.util.Map<kotlin.reflect.KClass<? extends java.lang.Object>, kotlinx.serialization.KSerializer<? extends java.lang.Object>> r0 = f41066a
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x006c
            java.lang.Object r1 = r0.next()
            kotlin.reflect.KClass r1 = (kotlin.reflect.KClass) r1
            java.lang.String r1 = r1.e()
            kotlin.jvm.internal.Intrinsics.c(r1)
            java.lang.String r1 = c(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "kotlin."
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r3 = 1
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.t(r4, r2, r3)
            if (r2 != 0) goto L_0x0040
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.t(r4, r1, r3)
            if (r2 != 0) goto L_0x0040
            goto L_0x000a
        L_0x0040:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r4 = " there already exist "
            r2.append(r4)
            java.lang.String r4 = c(r1)
            r2.append(r4)
            java.lang.String r4 = "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            java.lang.String r4 = kotlin.text.StringsKt__IndentKt.f(r4)
            r0.<init>(r4)
            throw r0
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PrimitivesKt.d(java.lang.String):void");
    }
}
