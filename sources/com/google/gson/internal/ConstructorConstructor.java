package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class ConstructorConstructor {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Type, InstanceCreator<?>> f30918a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f30919b;

    /* renamed from: c  reason: collision with root package name */
    private final List<ReflectionAccessFilter> f30920c;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map, boolean z2, List<ReflectionAccessFilter> list) {
        this.f30918a = map;
        this.f30919b = z2;
        this.f30920c = list;
    }

    static String a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        } else if (!Modifier.isAbstract(modifiers)) {
            return null;
        } else {
            return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + TroubleshootingGuide.a("r8-abstract-class");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        r4 = com.google.gson.internal.reflect.ReflectionHelper.p(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> com.google.gson.internal.ObjectConstructor<T> c(java.lang.Class<? super T> r4, com.google.gson.ReflectionAccessFilter.FilterResult r5) {
        /*
            int r0 = r4.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isAbstract(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            r0 = 0
            java.lang.Class[] r2 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x005e }
            java.lang.reflect.Constructor r2 = r4.getDeclaredConstructor(r2)     // Catch:{ NoSuchMethodException -> 0x005e }
            com.google.gson.ReflectionAccessFilter$FilterResult r3 = com.google.gson.ReflectionAccessFilter.FilterResult.ALLOW
            if (r5 == r3) goto L_0x002b
            boolean r1 = com.google.gson.internal.ReflectionAccessFilterHelper.a(r2, r1)
            if (r1 == 0) goto L_0x002c
            com.google.gson.ReflectionAccessFilter$FilterResult r1 = com.google.gson.ReflectionAccessFilter.FilterResult.BLOCK_ALL
            if (r5 != r1) goto L_0x002b
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isPublic(r1)
            if (r1 == 0) goto L_0x002c
        L_0x002b:
            r0 = 1
        L_0x002c:
            if (r0 != 0) goto L_0x004a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Unable to invoke no-args constructor of "
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter."
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.google.gson.internal.ConstructorConstructor$7 r5 = new com.google.gson.internal.ConstructorConstructor$7
            r5.<init>(r4)
            return r5
        L_0x004a:
            if (r5 != r3) goto L_0x0058
            java.lang.String r4 = com.google.gson.internal.reflect.ReflectionHelper.p(r2)
            if (r4 == 0) goto L_0x0058
            com.google.gson.internal.ConstructorConstructor$8 r5 = new com.google.gson.internal.ConstructorConstructor$8
            r5.<init>(r4)
            return r5
        L_0x0058:
            com.google.gson.internal.ConstructorConstructor$9 r4 = new com.google.gson.internal.ConstructorConstructor$9
            r4.<init>(r2)
            return r4
        L_0x005e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.ConstructorConstructor.c(java.lang.Class, com.google.gson.ReflectionAccessFilter$FilterResult):com.google.gson.internal.ObjectConstructor");
    }

    private static <T> ObjectConstructor<T> d(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() {
                    public T a() {
                        return new TreeSet();
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() {
                    public T a() {
                        return new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() {
                    public T a() {
                        return new ArrayDeque();
                    }
                };
            }
            return new ObjectConstructor<T>() {
                public T a() {
                    return new ArrayList();
                }
            };
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() {
                    public T a() {
                        return new ConcurrentSkipListMap();
                    }
                };
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() {
                    public T a() {
                        return new ConcurrentHashMap();
                    }
                };
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() {
                    public T a() {
                        return new TreeMap();
                    }
                };
            }
            if (type instanceof ParameterizedType) {
                if (!String.class.isAssignableFrom(TypeToken.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) {
                    return new ObjectConstructor<T>() {
                        public T a() {
                            return new LinkedHashMap();
                        }
                    };
                }
            }
            return new ObjectConstructor<T>() {
                public T a() {
                    return new LinkedTreeMap();
                }
            };
        }
    }

    private static <T> ObjectConstructor<T> e(final Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() {
                public T a() {
                    Type type = type;
                    if (type instanceof ParameterizedType) {
                        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                        if (type2 instanceof Class) {
                            return EnumSet.noneOf((Class) type2);
                        }
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                    throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                }
            };
        }
        if (cls == EnumMap.class) {
            return new ObjectConstructor<T>() {
                public T a() {
                    Type type = type;
                    if (type instanceof ParameterizedType) {
                        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                        if (type2 instanceof Class) {
                            return new EnumMap((Class) type2);
                        }
                        throw new JsonIOException("Invalid EnumMap type: " + type.toString());
                    }
                    throw new JsonIOException("Invalid EnumMap type: " + type.toString());
                }
            };
        }
        return null;
    }

    private <T> ObjectConstructor<T> f(final Class<? super T> cls) {
        if (this.f30919b) {
            return new ObjectConstructor<T>() {
                public T a() {
                    try {
                        return UnsafeAllocator.f30987a.d(cls);
                    } catch (Exception e2) {
                        throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e2);
                    }
                }
            };
        }
        final String str = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (cls.getDeclaredConstructors().length == 0) {
            str = str + " Or adjust your R8 configuration to keep the no-args constructor of the class.";
        }
        return new ObjectConstructor<T>() {
            public T a() {
                throw new JsonIOException(str);
            }
        };
    }

    public <T> ObjectConstructor<T> b(TypeToken<T> typeToken) {
        final Type d2 = typeToken.d();
        Class<? super T> c2 = typeToken.c();
        final InstanceCreator instanceCreator = this.f30918a.get(d2);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>() {
                public T a() {
                    return instanceCreator.a(d2);
                }
            };
        }
        final InstanceCreator instanceCreator2 = this.f30918a.get(c2);
        if (instanceCreator2 != null) {
            return new ObjectConstructor<T>() {
                public T a() {
                    return instanceCreator2.a(d2);
                }
            };
        }
        ObjectConstructor<T> e2 = e(d2, c2);
        if (e2 != null) {
            return e2;
        }
        ReflectionAccessFilter.FilterResult b2 = ReflectionAccessFilterHelper.b(this.f30920c, c2);
        ObjectConstructor<T> c3 = c(c2, b2);
        if (c3 != null) {
            return c3;
        }
        ObjectConstructor<T> d3 = d(d2, c2);
        if (d3 != null) {
            return d3;
        }
        final String a2 = a(c2);
        if (a2 != null) {
            return new ObjectConstructor<T>() {
                public T a() {
                    throw new JsonIOException(a2);
                }
            };
        }
        if (b2 == ReflectionAccessFilter.FilterResult.ALLOW) {
            return f(c2);
        }
        final String str = "Unable to create instance of " + c2 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
        return new ObjectConstructor<T>() {
            public T a() {
                throw new JsonIOException(str);
            }
        };
    }

    public String toString() {
        return this.f30918a.toString();
    }
}
