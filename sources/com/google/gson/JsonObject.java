package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

public final class JsonObject extends JsonElement {

    /* renamed from: b  reason: collision with root package name */
    private final LinkedTreeMap<String, JsonElement> f30891b = new LinkedTreeMap<>(false);

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).f30891b.equals(this.f30891b));
    }

    public int hashCode() {
        return this.f30891b.hashCode();
    }

    public void k(String str, JsonElement jsonElement) {
        LinkedTreeMap<String, JsonElement> linkedTreeMap = this.f30891b;
        if (jsonElement == null) {
            jsonElement = JsonNull.f30890b;
        }
        linkedTreeMap.put(str, jsonElement);
    }

    public Set<Map.Entry<String, JsonElement>> l() {
        return this.f30891b.entrySet();
    }

    public JsonElement m(String str) {
        return this.f30891b.get(str);
    }

    public JsonArray n(String str) {
        return (JsonArray) this.f30891b.get(str);
    }
}
