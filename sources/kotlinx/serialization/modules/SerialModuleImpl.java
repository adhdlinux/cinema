package kotlinx.serialization.modules;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.modules.ContextualProvider;

public final class SerialModuleImpl extends SerializersModule {

    /* renamed from: a  reason: collision with root package name */
    private final Map<KClass<?>, ContextualProvider> f41289a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> f41290b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<KClass<?>, Function1<?, SerializationStrategy<?>>> f41291c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<KClass<?>, Map<String, KSerializer<?>>> f41292d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<KClass<?>, Function1<String, DeserializationStrategy<?>>> f41293e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SerialModuleImpl(Map<KClass<?>, ? extends ContextualProvider> map, Map<KClass<?>, ? extends Map<KClass<?>, ? extends KSerializer<?>>> map2, Map<KClass<?>, ? extends Function1<?, ? extends SerializationStrategy<?>>> map3, Map<KClass<?>, ? extends Map<String, ? extends KSerializer<?>>> map4, Map<KClass<?>, ? extends Function1<? super String, ? extends DeserializationStrategy<?>>> map5) {
        super((DefaultConstructorMarker) null);
        Intrinsics.f(map, "class2ContextualFactory");
        Intrinsics.f(map2, "polyBase2Serializers");
        Intrinsics.f(map3, "polyBase2DefaultSerializerProvider");
        Intrinsics.f(map4, "polyBase2NamedSerializers");
        Intrinsics.f(map5, "polyBase2DefaultDeserializerProvider");
        this.f41289a = map;
        this.f41290b = map2;
        this.f41291c = map3;
        this.f41292d = map4;
        this.f41293e = map5;
    }

    public void a(SerializersModuleCollector serializersModuleCollector) {
        Intrinsics.f(serializersModuleCollector, "collector");
        for (Map.Entry next : this.f41289a.entrySet()) {
            KClass kClass = (KClass) next.getKey();
            ContextualProvider contextualProvider = (ContextualProvider) next.getValue();
            if (contextualProvider instanceof ContextualProvider.Argless) {
                Intrinsics.d(kClass, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                KSerializer<?> b2 = ((ContextualProvider.Argless) contextualProvider).b();
                Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                serializersModuleCollector.c(kClass, b2);
            } else if (contextualProvider instanceof ContextualProvider.WithTypeArguments) {
                serializersModuleCollector.e(kClass, ((ContextualProvider.WithTypeArguments) contextualProvider).b());
            }
        }
        for (Map.Entry next2 : this.f41290b.entrySet()) {
            KClass kClass2 = (KClass) next2.getKey();
            for (Map.Entry entry : ((Map) next2.getValue()).entrySet()) {
                KClass kClass3 = (KClass) entry.getKey();
                KSerializer kSerializer = (KSerializer) entry.getValue();
                Intrinsics.d(kClass2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.d(kClass3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.d(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                serializersModuleCollector.a(kClass2, kClass3, kSerializer);
            }
        }
        for (Map.Entry next3 : this.f41291c.entrySet()) {
            KClass kClass4 = (KClass) next3.getKey();
            Function1 function1 = (Function1) next3.getValue();
            Intrinsics.d(kClass4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            Intrinsics.d(function1, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'value')] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicSerializerProvider<kotlin.Any> }");
            serializersModuleCollector.d(kClass4, (Function1) TypeIntrinsics.b(function1, 1));
        }
        for (Map.Entry next4 : this.f41293e.entrySet()) {
            KClass kClass5 = (KClass) next4.getKey();
            Function1 function12 = (Function1) next4.getValue();
            Intrinsics.d(kClass5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            Intrinsics.d(function12, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'className')] kotlin.String?, kotlinx.serialization.DeserializationStrategy<out kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicDeserializerProvider<out kotlin.Any> }");
            serializersModuleCollector.b(kClass5, (Function1) TypeIntrinsics.b(function12, 1));
        }
    }

    public <T> KSerializer<T> b(KClass<T> kClass, List<? extends KSerializer<?>> list) {
        KSerializer<?> kSerializer;
        Intrinsics.f(kClass, "kClass");
        Intrinsics.f(list, "typeArgumentsSerializers");
        ContextualProvider contextualProvider = this.f41289a.get(kClass);
        if (contextualProvider != null) {
            kSerializer = contextualProvider.a(list);
        } else {
            kSerializer = null;
        }
        if (kSerializer instanceof KSerializer) {
            return kSerializer;
        }
        return null;
    }

    public <T> DeserializationStrategy<? extends T> d(KClass<? super T> kClass, String str) {
        KSerializer kSerializer;
        Function1 function1;
        Intrinsics.f(kClass, "baseClass");
        Map map = this.f41292d.get(kClass);
        if (map != null) {
            kSerializer = (KSerializer) map.get(str);
        } else {
            kSerializer = null;
        }
        if (!(kSerializer instanceof KSerializer)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Function1<String, DeserializationStrategy<?>> function12 = this.f41293e.get(kClass);
        if (TypeIntrinsics.e(function12, 1)) {
            function1 = function12;
        } else {
            function1 = null;
        }
        if (function1 != null) {
            return (DeserializationStrategy) function1.invoke(str);
        }
        return null;
    }

    public <T> SerializationStrategy<T> e(KClass<? super T> kClass, T t2) {
        KSerializer kSerializer;
        Function1 function1;
        Intrinsics.f(kClass, "baseClass");
        Intrinsics.f(t2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (!PlatformKt.i(t2, kClass)) {
            return null;
        }
        Map map = this.f41290b.get(kClass);
        if (map != null) {
            kSerializer = (KSerializer) map.get(Reflection.b(t2.getClass()));
        } else {
            kSerializer = null;
        }
        if (!(kSerializer instanceof SerializationStrategy)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Function1<?, SerializationStrategy<?>> function12 = this.f41291c.get(kClass);
        if (TypeIntrinsics.e(function12, 1)) {
            function1 = function12;
        } else {
            function1 = null;
        }
        if (function1 != null) {
            return (SerializationStrategy) function1.invoke(t2);
        }
        return null;
    }
}
