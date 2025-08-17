package kotlinx.serialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SerialDescriptorImpl$toString$1 extends Lambda implements Function1<Integer, CharSequence> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ SerialDescriptorImpl f40929f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SerialDescriptorImpl$toString$1(SerialDescriptorImpl serialDescriptorImpl) {
        super(1);
        this.f40929f = serialDescriptorImpl;
    }

    public final CharSequence a(int i2) {
        return this.f40929f.f(i2) + ": " + this.f40929f.h(i2).i();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return a(((Number) obj).intValue());
    }
}
