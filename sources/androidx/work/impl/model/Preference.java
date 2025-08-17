package androidx.work.impl.model;

public class Preference {

    /* renamed from: a  reason: collision with root package name */
    public String f12488a;

    /* renamed from: b  reason: collision with root package name */
    public Long f12489b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Preference(String str, boolean z2) {
        this(str, z2 ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        if (!this.f12488a.equals(preference.f12488a)) {
            return false;
        }
        Long l2 = this.f12489b;
        Long l3 = preference.f12489b;
        if (l2 != null) {
            return l2.equals(l3);
        }
        if (l3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2;
        int hashCode = this.f12488a.hashCode() * 31;
        Long l2 = this.f12489b;
        if (l2 != null) {
            i2 = l2.hashCode();
        } else {
            i2 = 0;
        }
        return hashCode + i2;
    }

    public Preference(String str, long j2) {
        this.f12488a = str;
        this.f12489b = Long.valueOf(j2);
    }
}
