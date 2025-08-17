package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

public final class JsonArray extends JsonElement implements Iterable<JsonElement> {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<JsonElement> f30889b = new ArrayList<>();

    private JsonElement m() {
        int size = this.f30889b.size();
        if (size == 1) {
            return this.f30889b.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }

    public int a() {
        return m().a();
    }

    public String e() {
        return m().e();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonArray) && ((JsonArray) obj).f30889b.equals(this.f30889b));
    }

    public int hashCode() {
        return this.f30889b.hashCode();
    }

    public Iterator<JsonElement> iterator() {
        return this.f30889b.iterator();
    }

    public void k(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.f30890b;
        }
        this.f30889b.add(jsonElement);
    }

    public JsonElement l(int i2) {
        return this.f30889b.get(i2);
    }
}
