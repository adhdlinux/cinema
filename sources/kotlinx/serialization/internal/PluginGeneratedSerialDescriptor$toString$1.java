package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class PluginGeneratedSerialDescriptor$toString$1 extends Lambda implements Function1<Integer, CharSequence> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PluginGeneratedSerialDescriptor f41059f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PluginGeneratedSerialDescriptor$toString$1(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        super(1);
        this.f41059f = pluginGeneratedSerialDescriptor;
    }

    public final CharSequence a(int i2) {
        return this.f41059f.f(i2) + ": " + this.f41059f.h(i2).i();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return a(((Number) obj).intValue());
    }
}
