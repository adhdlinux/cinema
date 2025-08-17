package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.DeserializationStrategy;

final class TaggedDecoder$decodeNullableSerializableElement$1 extends Lambda implements Function0<T> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ TaggedDecoder<Tag> f41081f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ DeserializationStrategy<T> f41082g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ T f41083h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaggedDecoder$decodeNullableSerializableElement$1(TaggedDecoder<Tag> taggedDecoder, DeserializationStrategy<T> deserializationStrategy, T t2) {
        super(0);
        this.f41081f = taggedDecoder;
        this.f41082g = deserializationStrategy;
        this.f41083h = t2;
    }

    public final T invoke() {
        if (this.f41081f.D()) {
            return this.f41081f.I(this.f41082g, this.f41083h);
        }
        return this.f41081f.j();
    }
}
