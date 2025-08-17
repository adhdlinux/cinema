package kotlin.jvm.internal;

import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

public class ReflectionFactory {
    public KFunction a(FunctionReference functionReference) {
        return functionReference;
    }

    public KClass b(Class cls) {
        return new ClassReference(cls);
    }

    public KDeclarationContainer c(Class cls, String str) {
        return new PackageReference(cls, str);
    }

    public KType d(KType kType) {
        TypeReference typeReference = (TypeReference) kType;
        return new TypeReference(kType.d(), kType.f(), typeReference.k(), typeReference.j() | 2);
    }

    public KProperty0 e(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public String f(FunctionBase functionBase) {
        String obj = functionBase.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            return obj.substring(21);
        }
        return obj;
    }

    public String g(Lambda lambda) {
        return f(lambda);
    }

    public KType h(KClassifier kClassifier, List<KTypeProjection> list, boolean z2) {
        return new TypeReference(kClassifier, list, z2);
    }
}
