package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;

public final class ProgramInformation {

    /* renamed from: a  reason: collision with root package name */
    public final String f26318a;

    /* renamed from: b  reason: collision with root package name */
    public final String f26319b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26320c;

    /* renamed from: d  reason: collision with root package name */
    public final String f26321d;

    /* renamed from: e  reason: collision with root package name */
    public final String f26322e;

    public ProgramInformation(String str, String str2, String str3, String str4, String str5) {
        this.f26318a = str;
        this.f26319b = str2;
        this.f26320c = str3;
        this.f26321d = str4;
        this.f26322e = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgramInformation)) {
            return false;
        }
        ProgramInformation programInformation = (ProgramInformation) obj;
        if (!Util.c(this.f26318a, programInformation.f26318a) || !Util.c(this.f26319b, programInformation.f26319b) || !Util.c(this.f26320c, programInformation.f26320c) || !Util.c(this.f26321d, programInformation.f26321d) || !Util.c(this.f26322e, programInformation.f26322e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5;
        String str = this.f26318a;
        int i6 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i7 = (527 + i2) * 31;
        String str2 = this.f26319b;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i8 = (i7 + i3) * 31;
        String str3 = this.f26320c;
        if (str3 != null) {
            i4 = str3.hashCode();
        } else {
            i4 = 0;
        }
        int i9 = (i8 + i4) * 31;
        String str4 = this.f26321d;
        if (str4 != null) {
            i5 = str4.hashCode();
        } else {
            i5 = 0;
        }
        int i10 = (i9 + i5) * 31;
        String str5 = this.f26322e;
        if (str5 != null) {
            i6 = str5.hashCode();
        }
        return i10 + i6;
    }
}
