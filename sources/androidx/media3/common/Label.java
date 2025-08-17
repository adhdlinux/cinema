package androidx.media3.common;

import androidx.media3.common.util.Util;

public class Label {

    /* renamed from: c  reason: collision with root package name */
    private static final String f4067c = Util.B0(0);

    /* renamed from: d  reason: collision with root package name */
    private static final String f4068d = Util.B0(1);

    /* renamed from: a  reason: collision with root package name */
    public final String f4069a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4070b;

    public Label(String str, String str2) {
        this.f4069a = Util.R0(str);
        this.f4070b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Label label = (Label) obj;
        if (!Util.c(this.f4069a, label.f4069a) || !Util.c(this.f4070b, label.f4070b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int hashCode = this.f4070b.hashCode() * 31;
        String str = this.f4069a;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        return hashCode + i2;
    }
}
