package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.Util;

public final class ProgramInformation {

    /* renamed from: a  reason: collision with root package name */
    public final String f6089a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6090b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6091c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6092d;

    /* renamed from: e  reason: collision with root package name */
    public final String f6093e;

    public ProgramInformation(String str, String str2, String str3, String str4, String str5) {
        this.f6089a = str;
        this.f6090b = str2;
        this.f6091c = str3;
        this.f6092d = str4;
        this.f6093e = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgramInformation)) {
            return false;
        }
        ProgramInformation programInformation = (ProgramInformation) obj;
        if (!Util.c(this.f6089a, programInformation.f6089a) || !Util.c(this.f6090b, programInformation.f6090b) || !Util.c(this.f6091c, programInformation.f6091c) || !Util.c(this.f6092d, programInformation.f6092d) || !Util.c(this.f6093e, programInformation.f6093e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5;
        String str = this.f6089a;
        int i6 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i7 = (527 + i2) * 31;
        String str2 = this.f6090b;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i8 = (i7 + i3) * 31;
        String str3 = this.f6091c;
        if (str3 != null) {
            i4 = str3.hashCode();
        } else {
            i4 = 0;
        }
        int i9 = (i8 + i4) * 31;
        String str4 = this.f6092d;
        if (str4 != null) {
            i5 = str4.hashCode();
        } else {
            i5 = 0;
        }
        int i10 = (i9 + i5) * 31;
        String str5 = this.f6093e;
        if (str5 != null) {
            i6 = str5.hashCode();
        }
        return i10 + i6;
    }
}
