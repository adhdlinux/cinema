package kotlinx.serialization.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

final class MapEntrySerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ KSerializer<K> f41022f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ KSerializer<V> f41023g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MapEntrySerializer$descriptor$1(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        super(1);
        this.f41022f = kSerializer;
        this.f41023g = kSerializer2;
    }

    public final void a(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.f(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder2 = classSerialDescriptorBuilder;
        ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder2, "key", this.f41022f.getDescriptor(), (List) null, false, 12, (Object) null);
        ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder2, AppMeasurementSdk.ConditionalUserProperty.VALUE, this.f41023g.getDescriptor(), (List) null, false, 12, (Object) null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((ClassSerialDescriptorBuilder) obj);
        return Unit.f40298a;
    }
}
