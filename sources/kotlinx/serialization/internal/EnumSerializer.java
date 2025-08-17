package kotlinx.serialization.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.Enum;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class EnumSerializer<T extends Enum<T>> implements KSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T[] f40989a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public SerialDescriptor f40990b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f40991c;

    public EnumSerializer(String str, T[] tArr) {
        Intrinsics.f(str, "serialName");
        Intrinsics.f(tArr, "values");
        this.f40989a = tArr;
        this.f40991c = LazyKt__LazyJVMKt.b(new EnumSerializer$descriptor$2(this, str));
    }

    /* access modifiers changed from: private */
    public final SerialDescriptor c(String str) {
        EnumDescriptor enumDescriptor = new EnumDescriptor(str, this.f40989a.length);
        for (T name : this.f40989a) {
            PluginGeneratedSerialDescriptor.m(enumDescriptor, name.name(), false, 2, (Object) null);
        }
        return enumDescriptor;
    }

    /* renamed from: d */
    public T deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        int e2 = decoder.e(getDescriptor());
        boolean z2 = false;
        if (e2 >= 0 && e2 < this.f40989a.length) {
            z2 = true;
        }
        if (z2) {
            return this.f40989a[e2];
        }
        throw new SerializationException(e2 + " is not among valid " + getDescriptor().i() + " enum values, values size is " + this.f40989a.length);
    }

    /* renamed from: e */
    public void serialize(Encoder encoder, T t2) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(t2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        int E = ArraysKt___ArraysKt.E(this.f40989a, t2);
        if (E != -1) {
            encoder.k(getDescriptor(), E);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t2);
        sb.append(" is not a valid enum ");
        sb.append(getDescriptor().i());
        sb.append(", must be one of ");
        String arrays = Arrays.toString(this.f40989a);
        Intrinsics.e(arrays, "toString(this)");
        sb.append(arrays);
        throw new SerializationException(sb.toString());
    }

    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.f40991c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().i() + '>';
    }
}
