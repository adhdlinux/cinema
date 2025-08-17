package kotlinx.serialization.builtins;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Triple;
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
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.time.Duration;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanArraySerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteArraySerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.CharArraySerializer;
import kotlinx.serialization.internal.CharSerializer;
import kotlinx.serialization.internal.DoubleArraySerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.DurationSerializer;
import kotlinx.serialization.internal.FloatArraySerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntArraySerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongArraySerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.MapEntrySerializer;
import kotlinx.serialization.internal.NullableSerializer;
import kotlinx.serialization.internal.PairSerializer;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.ShortArraySerializer;
import kotlinx.serialization.internal.ShortSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.internal.UByteArraySerializer;
import kotlinx.serialization.internal.UByteSerializer;
import kotlinx.serialization.internal.UIntArraySerializer;
import kotlinx.serialization.internal.UIntSerializer;
import kotlinx.serialization.internal.ULongArraySerializer;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.internal.UShortArraySerializer;
import kotlinx.serialization.internal.UShortSerializer;
import kotlinx.serialization.internal.UnitSerializer;

public final class BuiltinSerializersKt {
    public static final KSerializer<Character> A(CharCompanionObject charCompanionObject) {
        Intrinsics.f(charCompanionObject, "<this>");
        return CharSerializer.f40959a;
    }

    public static final KSerializer<Double> B(DoubleCompanionObject doubleCompanionObject) {
        Intrinsics.f(doubleCompanionObject, "<this>");
        return DoubleSerializer.f40974a;
    }

    public static final KSerializer<Float> C(FloatCompanionObject floatCompanionObject) {
        Intrinsics.f(floatCompanionObject, "<this>");
        return FloatSerializer.f40997a;
    }

    public static final KSerializer<Integer> D(IntCompanionObject intCompanionObject) {
        Intrinsics.f(intCompanionObject, "<this>");
        return IntSerializer.f41006a;
    }

    public static final KSerializer<Long> E(LongCompanionObject longCompanionObject) {
        Intrinsics.f(longCompanionObject, "<this>");
        return LongSerializer.f41017a;
    }

    public static final KSerializer<Short> F(ShortCompanionObject shortCompanionObject) {
        Intrinsics.f(shortCompanionObject, "<this>");
        return ShortSerializer.f41075a;
    }

    public static final KSerializer<String> G(StringCompanionObject stringCompanionObject) {
        Intrinsics.f(stringCompanionObject, "<this>");
        return StringSerializer.f41077a;
    }

    public static final KSerializer<Duration> H(Duration.Companion companion) {
        Intrinsics.f(companion, "<this>");
        return DurationSerializer.f40976a;
    }

    public static final <T, E extends T> KSerializer<E[]> a(KClass<T> kClass, KSerializer<E> kSerializer) {
        Intrinsics.f(kClass, "kClass");
        Intrinsics.f(kSerializer, "elementSerializer");
        return new ReferenceArraySerializer(kClass, kSerializer);
    }

    public static final KSerializer<boolean[]> b() {
        return BooleanArraySerializer.f40946c;
    }

    public static final KSerializer<byte[]> c() {
        return ByteArraySerializer.f40951c;
    }

    public static final KSerializer<char[]> d() {
        return CharArraySerializer.f40958c;
    }

    public static final KSerializer<double[]> e() {
        return DoubleArraySerializer.f40973c;
    }

    public static final KSerializer<float[]> f() {
        return FloatArraySerializer.f40996c;
    }

    public static final KSerializer<int[]> g() {
        return IntArraySerializer.f41005c;
    }

    public static final <T> KSerializer<List<T>> h(KSerializer<T> kSerializer) {
        Intrinsics.f(kSerializer, "elementSerializer");
        return new ArrayListSerializer(kSerializer);
    }

    public static final KSerializer<long[]> i() {
        return LongArraySerializer.f41016c;
    }

    public static final <K, V> KSerializer<Map.Entry<K, V>> j(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        Intrinsics.f(kSerializer, "keySerializer");
        Intrinsics.f(kSerializer2, "valueSerializer");
        return new MapEntrySerializer(kSerializer, kSerializer2);
    }

    public static final <K, V> KSerializer<Map<K, V>> k(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        Intrinsics.f(kSerializer, "keySerializer");
        Intrinsics.f(kSerializer2, "valueSerializer");
        return new LinkedHashMapSerializer(kSerializer, kSerializer2);
    }

    public static final <K, V> KSerializer<Pair<K, V>> l(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        Intrinsics.f(kSerializer, "keySerializer");
        Intrinsics.f(kSerializer2, "valueSerializer");
        return new PairSerializer(kSerializer, kSerializer2);
    }

    public static final KSerializer<short[]> m() {
        return ShortArraySerializer.f41074c;
    }

    public static final <A, B, C> KSerializer<Triple<A, B, C>> n(KSerializer<A> kSerializer, KSerializer<B> kSerializer2, KSerializer<C> kSerializer3) {
        Intrinsics.f(kSerializer, "aSerializer");
        Intrinsics.f(kSerializer2, "bSerializer");
        Intrinsics.f(kSerializer3, "cSerializer");
        return new TripleSerializer(kSerializer, kSerializer2, kSerializer3);
    }

    public static final KSerializer<UByteArray> o() {
        return UByteArraySerializer.f41096c;
    }

    public static final KSerializer<UIntArray> p() {
        return UIntArraySerializer.f41101c;
    }

    public static final KSerializer<ULongArray> q() {
        return ULongArraySerializer.f41106c;
    }

    public static final KSerializer<UShortArray> r() {
        return UShortArraySerializer.f41111c;
    }

    public static final <T> KSerializer<T> s(KSerializer<T> kSerializer) {
        Intrinsics.f(kSerializer, "<this>");
        if (kSerializer.getDescriptor().b()) {
            return kSerializer;
        }
        return new NullableSerializer(kSerializer);
    }

    public static final KSerializer<UByte> t(UByte.Companion companion) {
        Intrinsics.f(companion, "<this>");
        return UByteSerializer.f41097a;
    }

    public static final KSerializer<UInt> u(UInt.Companion companion) {
        Intrinsics.f(companion, "<this>");
        return UIntSerializer.f41102a;
    }

    public static final KSerializer<ULong> v(ULong.Companion companion) {
        Intrinsics.f(companion, "<this>");
        return ULongSerializer.f41107a;
    }

    public static final KSerializer<UShort> w(UShort.Companion companion) {
        Intrinsics.f(companion, "<this>");
        return UShortSerializer.f41112a;
    }

    public static final KSerializer<Unit> x(Unit unit) {
        Intrinsics.f(unit, "<this>");
        return UnitSerializer.f41114b;
    }

    public static final KSerializer<Boolean> y(BooleanCompanionObject booleanCompanionObject) {
        Intrinsics.f(booleanCompanionObject, "<this>");
        return BooleanSerializer.f40947a;
    }

    public static final KSerializer<Byte> z(ByteCompanionObject byteCompanionObject) {
        Intrinsics.f(byteCompanionObject, "<this>");
        return ByteSerializer.f40952a;
    }
}
