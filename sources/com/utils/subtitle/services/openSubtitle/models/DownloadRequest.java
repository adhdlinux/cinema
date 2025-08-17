package com.utils.subtitle.services.openSubtitle.models;

import kotlin.jvm.internal.Intrinsics;

public final class DownloadRequest {
    private final int file_id;
    private final String file_name;
    private final Boolean force_download;
    private final Integer in_fps;
    private final Integer out_fps;
    private final String sub_format;
    private final Integer timeshift;

    public DownloadRequest(int i2, String str, Boolean bool, Integer num, Integer num2, String str2, Integer num3) {
        this.file_id = i2;
        this.file_name = str;
        this.force_download = bool;
        this.in_fps = num;
        this.out_fps = num2;
        this.sub_format = str2;
        this.timeshift = num3;
    }

    public static /* synthetic */ DownloadRequest copy$default(DownloadRequest downloadRequest, int i2, String str, Boolean bool, Integer num, Integer num2, String str2, Integer num3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = downloadRequest.file_id;
        }
        if ((i3 & 2) != 0) {
            str = downloadRequest.file_name;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            bool = downloadRequest.force_download;
        }
        Boolean bool2 = bool;
        if ((i3 & 8) != 0) {
            num = downloadRequest.in_fps;
        }
        Integer num4 = num;
        if ((i3 & 16) != 0) {
            num2 = downloadRequest.out_fps;
        }
        Integer num5 = num2;
        if ((i3 & 32) != 0) {
            str2 = downloadRequest.sub_format;
        }
        String str4 = str2;
        if ((i3 & 64) != 0) {
            num3 = downloadRequest.timeshift;
        }
        return downloadRequest.copy(i2, str3, bool2, num4, num5, str4, num3);
    }

    public final int component1() {
        return this.file_id;
    }

    public final String component2() {
        return this.file_name;
    }

    public final Boolean component3() {
        return this.force_download;
    }

    public final Integer component4() {
        return this.in_fps;
    }

    public final Integer component5() {
        return this.out_fps;
    }

    public final String component6() {
        return this.sub_format;
    }

    public final Integer component7() {
        return this.timeshift;
    }

    public final DownloadRequest copy(int i2, String str, Boolean bool, Integer num, Integer num2, String str2, Integer num3) {
        return new DownloadRequest(i2, str, bool, num, num2, str2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.file_id == downloadRequest.file_id && Intrinsics.a(this.file_name, downloadRequest.file_name) && Intrinsics.a(this.force_download, downloadRequest.force_download) && Intrinsics.a(this.in_fps, downloadRequest.in_fps) && Intrinsics.a(this.out_fps, downloadRequest.out_fps) && Intrinsics.a(this.sub_format, downloadRequest.sub_format) && Intrinsics.a(this.timeshift, downloadRequest.timeshift);
    }

    public final int getFile_id() {
        return this.file_id;
    }

    public final String getFile_name() {
        return this.file_name;
    }

    public final Boolean getForce_download() {
        return this.force_download;
    }

    public final Integer getIn_fps() {
        return this.in_fps;
    }

    public final Integer getOut_fps() {
        return this.out_fps;
    }

    public final String getSub_format() {
        return this.sub_format;
    }

    public final Integer getTimeshift() {
        return this.timeshift;
    }

    public int hashCode() {
        int i2 = this.file_id * 31;
        String str = this.file_name;
        int i3 = 0;
        int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.force_download;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.in_fps;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.out_fps;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.sub_format;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.timeshift;
        if (num3 != null) {
            i3 = num3.hashCode();
        }
        return hashCode5 + i3;
    }

    public String toString() {
        return "DownloadRequest(file_id=" + this.file_id + ", file_name=" + this.file_name + ", force_download=" + this.force_download + ", in_fps=" + this.in_fps + ", out_fps=" + this.out_fps + ", sub_format=" + this.sub_format + ", timeshift=" + this.timeshift + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DownloadRequest(int r8, java.lang.String r9, java.lang.Boolean r10, java.lang.Integer r11, java.lang.Integer r12, java.lang.String r13, java.lang.Integer r14, int r15, kotlin.jvm.internal.DefaultConstructorMarker r16) {
        /*
            r7 = this;
            r0 = r15 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r9
        L_0x0008:
            r2 = r15 & 4
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r10
        L_0x000f:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r11
        L_0x0016:
            r4 = r15 & 16
            if (r4 == 0) goto L_0x001c
            r4 = r1
            goto L_0x001d
        L_0x001c:
            r4 = r12
        L_0x001d:
            r5 = r15 & 32
            if (r5 == 0) goto L_0x0023
            r5 = r1
            goto L_0x0024
        L_0x0023:
            r5 = r13
        L_0x0024:
            r6 = r15 & 64
            if (r6 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r1 = r14
        L_0x002a:
            r9 = r7
            r10 = r8
            r11 = r0
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.subtitle.services.openSubtitle.models.DownloadRequest.<init>(int, java.lang.String, java.lang.Boolean, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
