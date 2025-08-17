package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Function;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;

public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f40410c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Class<? extends Function<?>>, Integer> f40411d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<String, String> f40412e;

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, String> f40413f;

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, String> f40414g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final Map<String, String> f40415h;

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f40416b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x003d, code lost:
            if (r2 == null) goto L_0x0043;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String a(java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.Intrinsics.f(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto L_0x000e
                goto L_0x00b6
            L_0x000e:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L_0x006c
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r2 = r8.getEnclosingMethod()
                r3 = 2
                r4 = 36
                java.lang.String r5 = "name"
                if (r2 == 0) goto L_0x0043
                kotlin.jvm.internal.Intrinsics.e(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = r2.getName()
                r6.append(r2)
                r6.append(r4)
                java.lang.String r2 = r6.toString()
                java.lang.String r2 = kotlin.text.StringsKt__StringsKt.G0(r0, r2, r1, r3, r1)
                if (r2 != 0) goto L_0x0040
                goto L_0x0043
            L_0x0040:
                r1 = r2
                goto L_0x00b6
            L_0x0043:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                if (r8 == 0) goto L_0x0064
                kotlin.jvm.internal.Intrinsics.e(r0, r5)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = r8.getName()
                r2.append(r8)
                r2.append(r4)
                java.lang.String r8 = r2.toString()
                java.lang.String r1 = kotlin.text.StringsKt__StringsKt.G0(r0, r8, r1, r3, r1)
                goto L_0x00b6
            L_0x0064:
                kotlin.jvm.internal.Intrinsics.e(r0, r5)
                java.lang.String r1 = kotlin.text.StringsKt__StringsKt.F0(r0, r4, r1, r3, r1)
                goto L_0x00b6
            L_0x006c:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto L_0x00a1
                java.lang.Class r8 = r8.getComponentType()
                boolean r0 = r8.isPrimitive()
                java.lang.String r2 = "Array"
                if (r0 == 0) goto L_0x009e
                java.util.Map r0 = kotlin.jvm.internal.ClassReference.f40415h
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto L_0x009e
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r8)
                r0.append(r2)
                java.lang.String r8 = r0.toString()
                r1 = r8
            L_0x009e:
                if (r1 != 0) goto L_0x00b6
                goto L_0x0040
            L_0x00a1:
                java.util.Map r0 = kotlin.jvm.internal.ClassReference.f40415h
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto L_0x00b6
                java.lang.String r1 = r8.getSimpleName()
            L_0x00b6:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.ClassReference.Companion.a(java.lang.Class):java.lang.String");
        }
    }

    static {
        int i2 = 0;
        Iterable i3 = CollectionsKt__CollectionsKt.i(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(i3, 10));
        for (Object next : i3) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.o();
            }
            arrayList.add(TuplesKt.a((Class) next, Integer.valueOf(i2)));
            i2 = i4;
        }
        f40411d = MapsKt__MapsKt.s(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f40412e = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f40413f = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        Intrinsics.e(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            Intrinsics.e(str, "kotlinName");
            sb.append(StringsKt__StringsKt.I0(str, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            Pair a2 = TuplesKt.a(sb2, str + ".Companion");
            hashMap3.put(a2.c(), a2.d());
        }
        for (Map.Entry next2 : f40411d.entrySet()) {
            int intValue = ((Number) next2.getValue()).intValue();
            String name = ((Class) next2.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        f40414g = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.d(hashMap3.size()));
        for (Map.Entry entry : hashMap3.entrySet()) {
            linkedHashMap.put(entry.getKey(), StringsKt__StringsKt.I0((String) entry.getValue(), '.', (String) null, 2, (Object) null));
        }
        f40415h = linkedHashMap;
    }

    public ClassReference(Class<?> cls) {
        Intrinsics.f(cls, "jClass");
        this.f40416b = cls;
    }

    public Class<?> a() {
        return this.f40416b;
    }

    public String e() {
        return f40410c.a(a());
    }

    public boolean equals(Object obj) {
        return (obj instanceof ClassReference) && Intrinsics.a(JvmClassMappingKt.b(this), JvmClassMappingKt.b((KClass) obj));
    }

    public int hashCode() {
        return JvmClassMappingKt.b(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
