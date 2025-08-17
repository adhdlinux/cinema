package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.JsonSchemaCacheKt;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;

public final class JsonNamesMapKt {

    /* renamed from: a  reason: collision with root package name */
    private static final DescriptorSchemaCache.Key<Map<String, Integer>> f41216a = new DescriptorSchemaCache.Key<>();

    public static final Map<String, Integer> a(SerialDescriptor serialDescriptor) {
        String[] names;
        Intrinsics.f(serialDescriptor, "<this>");
        int e2 = serialDescriptor.e();
        Map<String, Integer> map = null;
        for (int i2 = 0; i2 < e2; i2++) {
            ArrayList arrayList = new ArrayList();
            for (Object next : serialDescriptor.g(i2)) {
                if (next instanceof JsonNames) {
                    arrayList.add(next);
                }
            }
            JsonNames jsonNames = (JsonNames) CollectionsKt___CollectionsKt.S(arrayList);
            if (!(jsonNames == null || (names = jsonNames.names()) == null)) {
                for (String str : names) {
                    if (map == null) {
                        map = CreateMapForCacheKt.a(serialDescriptor.e());
                    }
                    Intrinsics.c(map);
                    b(map, serialDescriptor, str, i2);
                }
            }
        }
        if (map == null) {
            return MapsKt__MapsKt.g();
        }
        return map;
    }

    private static final void b(Map<String, Integer> map, SerialDescriptor serialDescriptor, String str, int i2) {
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i2));
            return;
        }
        throw new JsonException("The suggested name '" + str + "' for property " + serialDescriptor.f(i2) + " is already one of the names for property " + serialDescriptor.f(((Number) MapsKt__MapsKt.h(map, str)).intValue()) + " in " + serialDescriptor);
    }

    public static final DescriptorSchemaCache.Key<Map<String, Integer>> c() {
        return f41216a;
    }

    public static final int d(SerialDescriptor serialDescriptor, Json json, String str) {
        Intrinsics.f(serialDescriptor, "<this>");
        Intrinsics.f(json, "json");
        Intrinsics.f(str, "name");
        int c2 = serialDescriptor.c(str);
        if (c2 != -3 || !json.e().j()) {
            return c2;
        }
        Integer num = (Integer) ((Map) JsonSchemaCacheKt.a(json).b(serialDescriptor, f41216a, new JsonNamesMapKt$getJsonNameIndex$alternativeNamesMap$1(serialDescriptor))).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final int e(SerialDescriptor serialDescriptor, Json json, String str, String str2) {
        Intrinsics.f(serialDescriptor, "<this>");
        Intrinsics.f(json, "json");
        Intrinsics.f(str, "name");
        Intrinsics.f(str2, "suffix");
        int d2 = d(serialDescriptor, json, str);
        if (d2 != -3) {
            return d2;
        }
        throw new SerializationException(serialDescriptor.i() + " does not contain element with name '" + str + '\'' + str2);
    }

    public static /* synthetic */ int f(SerialDescriptor serialDescriptor, Json json, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        return e(serialDescriptor, json, str, str2);
    }
}
