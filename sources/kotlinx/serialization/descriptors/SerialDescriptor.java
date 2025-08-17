package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;

public interface SerialDescriptor {

    public static final class DefaultImpls {
        public static List<Annotation> a(SerialDescriptor serialDescriptor) {
            return CollectionsKt__CollectionsKt.f();
        }

        public static boolean b(SerialDescriptor serialDescriptor) {
            return false;
        }

        public static boolean c(SerialDescriptor serialDescriptor) {
            return false;
        }
    }

    boolean b();

    int c(String str);

    SerialKind d();

    int e();

    String f(int i2);

    List<Annotation> g(int i2);

    List<Annotation> getAnnotations();

    SerialDescriptor h(int i2);

    String i();

    boolean isInline();

    boolean j(int i2);
}
