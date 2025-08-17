package com.utils.subtitle.services.openSubtitle.models;

import kotlin.jvm.internal.Intrinsics;

public final class File {
    private final int cd_number;
    private final int file_id;
    private final String file_name;

    public File(int i2, int i3, String str) {
        Intrinsics.f(str, "file_name");
        this.cd_number = i2;
        this.file_id = i3;
        this.file_name = str;
    }

    public static /* synthetic */ File copy$default(File file, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = file.cd_number;
        }
        if ((i4 & 2) != 0) {
            i3 = file.file_id;
        }
        if ((i4 & 4) != 0) {
            str = file.file_name;
        }
        return file.copy(i2, i3, str);
    }

    public final int component1() {
        return this.cd_number;
    }

    public final int component2() {
        return this.file_id;
    }

    public final String component3() {
        return this.file_name;
    }

    public final File copy(int i2, int i3, String str) {
        Intrinsics.f(str, "file_name");
        return new File(i2, i3, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof File)) {
            return false;
        }
        File file = (File) obj;
        return this.cd_number == file.cd_number && this.file_id == file.file_id && Intrinsics.a(this.file_name, file.file_name);
    }

    public final int getCd_number() {
        return this.cd_number;
    }

    public final int getFile_id() {
        return this.file_id;
    }

    public final String getFile_name() {
        return this.file_name;
    }

    public int hashCode() {
        return (((this.cd_number * 31) + this.file_id) * 31) + this.file_name.hashCode();
    }

    public String toString() {
        return "File(cd_number=" + this.cd_number + ", file_id=" + this.file_id + ", file_name=" + this.file_name + ')';
    }
}
