package androidx.preference;

import java.util.Set;

public abstract class PreferenceDataStore {
    public boolean a(String str, boolean z2) {
        return z2;
    }

    public float b(String str, float f2) {
        return f2;
    }

    public int c(String str, int i2) {
        return i2;
    }

    public long d(String str, long j2) {
        return j2;
    }

    public String e(String str, String str2) {
        return str2;
    }

    public Set<String> f(String str, Set<String> set) {
        return set;
    }

    public void g(String str, boolean z2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void h(String str, float f2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void i(String str, int i2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void j(String str, long j2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void k(String str, String str2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void l(String str, Set<String> set) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }
}
