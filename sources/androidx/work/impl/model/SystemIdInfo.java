package androidx.work.impl.model;

public class SystemIdInfo {

    /* renamed from: a  reason: collision with root package name */
    public final String f12493a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12494b;

    public SystemIdInfo(String str, int i2) {
        this.f12493a = str;
        this.f12494b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemIdInfo)) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
        if (this.f12494b != systemIdInfo.f12494b) {
            return false;
        }
        return this.f12493a.equals(systemIdInfo.f12493a);
    }

    public int hashCode() {
        return (this.f12493a.hashCode() * 31) + this.f12494b;
    }
}
