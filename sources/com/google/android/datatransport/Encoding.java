package com.google.android.datatransport;

public final class Encoding {

    /* renamed from: a  reason: collision with root package name */
    private final String f22261a;

    private Encoding(String str) {
        if (str != null) {
            this.f22261a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public static Encoding b(String str) {
        return new Encoding(str);
    }

    public String a() {
        return this.f22261a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.f22261a.equals(((Encoding) obj).f22261a);
    }

    public int hashCode() {
        return this.f22261a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f22261a + "\"}";
    }
}
