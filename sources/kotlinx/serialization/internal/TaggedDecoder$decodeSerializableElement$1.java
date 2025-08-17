package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.DeserializationStrategy;

final class TaggedDecoder$decodeSerializableElement$1 extends Lambda implements Function0<T> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ TaggedDecoder<Tag> f41084f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ DeserializationStrategy<T> f41085g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ T f41086h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaggedDecoder$decodeSerializableElement$1(TaggedDecoder<Tag> taggedDecoder, DeserializationStrategy<T> deserializationStrategy, T t2) {
        super(0);
        this.f41084f = taggedDecoder;
        this.f41085g = deserializationStrategy;
        this.f41086h = t2;
    }

    public final T invoke() {
        return this.f41084f.I(this.f41085g, this.f41086h);
    }
}
