package kotlinx.serialization.internal;

import kotlinx.serialization.KSerializer;

public interface GeneratedSerializer<T> extends KSerializer<T> {

    public static final class DefaultImpls {
        public static <T> KSerializer<?>[] a(GeneratedSerializer<T> generatedSerializer) {
            return PluginHelperInterfacesKt.f41061a;
        }
    }

    KSerializer<?>[] childSerializers();

    KSerializer<?>[] typeParametersSerializers();
}
