package kotlinx.serialization.modules;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

public abstract class ContextualProvider {

    public static final class Argless extends ContextualProvider {

        /* renamed from: a  reason: collision with root package name */
        private final KSerializer<?> f41287a;

        public KSerializer<?> a(List<? extends KSerializer<?>> list) {
            Intrinsics.f(list, "typeArgumentsSerializers");
            return this.f41287a;
        }

        public final KSerializer<?> b() {
            return this.f41287a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Argless) && Intrinsics.a(((Argless) obj).f41287a, this.f41287a);
        }

        public int hashCode() {
            return this.f41287a.hashCode();
        }
    }

    public static final class WithTypeArguments extends ContextualProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Function1<List<? extends KSerializer<?>>, KSerializer<?>> f41288a;

        public KSerializer<?> a(List<? extends KSerializer<?>> list) {
            Intrinsics.f(list, "typeArgumentsSerializers");
            return this.f41288a.invoke(list);
        }

        public final Function1<List<? extends KSerializer<?>>, KSerializer<?>> b() {
            return this.f41288a;
        }
    }

    private ContextualProvider() {
    }

    public abstract KSerializer<?> a(List<? extends KSerializer<?>> list);
}
