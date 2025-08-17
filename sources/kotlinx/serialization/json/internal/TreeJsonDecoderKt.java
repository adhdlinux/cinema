package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;

public final class TreeJsonDecoderKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: kotlinx.serialization.json.internal.JsonTreeDecoder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: kotlinx.serialization.json.internal.JsonPrimitiveDecoder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: kotlinx.serialization.json.internal.JsonTreeListDecoder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: kotlinx.serialization.json.internal.JsonTreeDecoder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: kotlinx.serialization.json.internal.JsonTreeDecoder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: kotlinx.serialization.json.internal.JsonTreeDecoder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T a(kotlinx.serialization.json.Json r8, kotlinx.serialization.json.JsonElement r9, kotlinx.serialization.DeserializationStrategy<T> r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "element"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            java.lang.String r0 = "deserializer"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            boolean r0 = r9 instanceof kotlinx.serialization.json.JsonObject
            if (r0 == 0) goto L_0x0023
            kotlinx.serialization.json.internal.JsonTreeDecoder r0 = new kotlinx.serialization.json.internal.JsonTreeDecoder
            r3 = r9
            kotlinx.serialization.json.JsonObject r3 = (kotlinx.serialization.json.JsonObject) r3
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            r1 = r0
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0044
        L_0x0023:
            boolean r0 = r9 instanceof kotlinx.serialization.json.JsonArray
            if (r0 == 0) goto L_0x002f
            kotlinx.serialization.json.internal.JsonTreeListDecoder r0 = new kotlinx.serialization.json.internal.JsonTreeListDecoder
            kotlinx.serialization.json.JsonArray r9 = (kotlinx.serialization.json.JsonArray) r9
            r0.<init>(r8, r9)
            goto L_0x0044
        L_0x002f:
            boolean r0 = r9 instanceof kotlinx.serialization.json.JsonLiteral
            if (r0 == 0) goto L_0x0035
            r0 = 1
            goto L_0x003b
        L_0x0035:
            kotlinx.serialization.json.JsonNull r0 = kotlinx.serialization.json.JsonNull.f41166d
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r9, r0)
        L_0x003b:
            if (r0 == 0) goto L_0x0049
            kotlinx.serialization.json.internal.JsonPrimitiveDecoder r0 = new kotlinx.serialization.json.internal.JsonPrimitiveDecoder
            kotlinx.serialization.json.JsonPrimitive r9 = (kotlinx.serialization.json.JsonPrimitive) r9
            r0.<init>(r8, r9)
        L_0x0044:
            java.lang.Object r8 = r0.G(r10)
            return r8
        L_0x0049:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.TreeJsonDecoderKt.a(kotlinx.serialization.json.Json, kotlinx.serialization.json.JsonElement, kotlinx.serialization.DeserializationStrategy):java.lang.Object");
    }

    public static final <T> T b(Json json, String str, JsonObject jsonObject, DeserializationStrategy<T> deserializationStrategy) {
        Intrinsics.f(json, "<this>");
        Intrinsics.f(str, "discriminator");
        Intrinsics.f(jsonObject, "element");
        Intrinsics.f(deserializationStrategy, "deserializer");
        return new JsonTreeDecoder(json, jsonObject, str, deserializationStrategy.getDescriptor()).G(deserializationStrategy);
    }
}
