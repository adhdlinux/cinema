package com.chartboost.sdk.impl;

import b0.y;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class rc {

    /* renamed from: a  reason: collision with root package name */
    public final String f18526a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18527b;

    /* renamed from: c  reason: collision with root package name */
    public final File f18528c;

    /* renamed from: d  reason: collision with root package name */
    public final File f18529d;

    /* renamed from: e  reason: collision with root package name */
    public final long f18530e;

    /* renamed from: f  reason: collision with root package name */
    public final String f18531f;

    /* renamed from: g  reason: collision with root package name */
    public long f18532g;

    public rc(String str, String str2, File file, File file2, long j2, String str3, long j3) {
        Intrinsics.f(str, ImagesContract.URL);
        Intrinsics.f(str2, "filename");
        Intrinsics.f(str3, "queueFilePath");
        this.f18526a = str;
        this.f18527b = str2;
        this.f18528c = file;
        this.f18529d = file2;
        this.f18530e = j2;
        this.f18531f = str3;
        this.f18532g = j3;
    }

    public final long a() {
        return this.f18530e;
    }

    public final File b() {
        return this.f18529d;
    }

    public final long c() {
        return this.f18532g;
    }

    public final String d() {
        return this.f18527b;
    }

    public final File e() {
        return this.f18528c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rc)) {
            return false;
        }
        rc rcVar = (rc) obj;
        return Intrinsics.a(this.f18526a, rcVar.f18526a) && Intrinsics.a(this.f18527b, rcVar.f18527b) && Intrinsics.a(this.f18528c, rcVar.f18528c) && Intrinsics.a(this.f18529d, rcVar.f18529d) && this.f18530e == rcVar.f18530e && Intrinsics.a(this.f18531f, rcVar.f18531f) && this.f18532g == rcVar.f18532g;
    }

    public final String f() {
        return this.f18531f;
    }

    public final String g() {
        return this.f18526a;
    }

    public int hashCode() {
        int hashCode = ((this.f18526a.hashCode() * 31) + this.f18527b.hashCode()) * 31;
        File file = this.f18528c;
        int i2 = 0;
        int hashCode2 = (hashCode + (file == null ? 0 : file.hashCode())) * 31;
        File file2 = this.f18529d;
        if (file2 != null) {
            i2 = file2.hashCode();
        }
        return ((((((hashCode2 + i2) * 31) + y.a(this.f18530e)) * 31) + this.f18531f.hashCode()) * 31) + y.a(this.f18532g);
    }

    public String toString() {
        return "VideoAsset(url=" + this.f18526a + ", filename=" + this.f18527b + ", localFile=" + this.f18528c + ", directory=" + this.f18529d + ", creationDate=" + this.f18530e + ", queueFilePath=" + this.f18531f + ", expectedFileSize=" + this.f18532g + ')';
    }

    public final void a(long j2) {
        this.f18532g = j2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ rc(String str, String str2, File file, File file2, long j2, String str3, long j3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, file, file2, (i2 & 16) != 0 ? ab.a() : j2, (i2 & 32) != 0 ? "" : str3, (i2 & 64) != 0 ? 0 : j3);
    }
}
