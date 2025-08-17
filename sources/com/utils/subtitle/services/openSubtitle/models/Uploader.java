package com.utils.subtitle.services.openSubtitle.models;

import kotlin.jvm.internal.Intrinsics;

public final class Uploader {
    private final String name;
    private final String rank;
    private final int uploader_id;

    public Uploader(String str, String str2, int i2) {
        Intrinsics.f(str, "name");
        Intrinsics.f(str2, "rank");
        this.name = str;
        this.rank = str2;
        this.uploader_id = i2;
    }

    public static /* synthetic */ Uploader copy$default(Uploader uploader, String str, String str2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = uploader.name;
        }
        if ((i3 & 2) != 0) {
            str2 = uploader.rank;
        }
        if ((i3 & 4) != 0) {
            i2 = uploader.uploader_id;
        }
        return uploader.copy(str, str2, i2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.rank;
    }

    public final int component3() {
        return this.uploader_id;
    }

    public final Uploader copy(String str, String str2, int i2) {
        Intrinsics.f(str, "name");
        Intrinsics.f(str2, "rank");
        return new Uploader(str, str2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uploader)) {
            return false;
        }
        Uploader uploader = (Uploader) obj;
        return Intrinsics.a(this.name, uploader.name) && Intrinsics.a(this.rank, uploader.rank) && this.uploader_id == uploader.uploader_id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRank() {
        return this.rank;
    }

    public final int getUploader_id() {
        return this.uploader_id;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.rank.hashCode()) * 31) + this.uploader_id;
    }

    public String toString() {
        return "Uploader(name=" + this.name + ", rank=" + this.rank + ", uploader_id=" + this.uploader_id + ')';
    }
}
