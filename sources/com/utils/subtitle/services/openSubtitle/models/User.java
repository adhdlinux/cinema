package com.utils.subtitle.services.openSubtitle.models;

import com.applovin.sdk.AppLovinEventTypes;
import kotlin.jvm.internal.Intrinsics;

public final class User {
    private final int allowed_downloads;
    private final int allowed_translations;
    private final int downloads_count;
    private final boolean ext_installed;
    private final String level;
    private final int remaining_downloads;
    private final int user_id;
    private final boolean vip;

    public User(int i2, int i3, boolean z2, String str, int i4, boolean z3, int i5, int i6) {
        Intrinsics.f(str, AppLovinEventTypes.USER_COMPLETED_LEVEL);
        this.allowed_downloads = i2;
        this.allowed_translations = i3;
        this.ext_installed = z2;
        this.level = str;
        this.user_id = i4;
        this.vip = z3;
        this.remaining_downloads = i5;
        this.downloads_count = i6;
    }

    public static /* synthetic */ User copy$default(User user, int i2, int i3, boolean z2, String str, int i4, boolean z3, int i5, int i6, int i7, Object obj) {
        User user2 = user;
        int i8 = i7;
        return user.copy((i8 & 1) != 0 ? user2.allowed_downloads : i2, (i8 & 2) != 0 ? user2.allowed_translations : i3, (i8 & 4) != 0 ? user2.ext_installed : z2, (i8 & 8) != 0 ? user2.level : str, (i8 & 16) != 0 ? user2.user_id : i4, (i8 & 32) != 0 ? user2.vip : z3, (i8 & 64) != 0 ? user2.remaining_downloads : i5, (i8 & 128) != 0 ? user2.downloads_count : i6);
    }

    public final int component1() {
        return this.allowed_downloads;
    }

    public final int component2() {
        return this.allowed_translations;
    }

    public final boolean component3() {
        return this.ext_installed;
    }

    public final String component4() {
        return this.level;
    }

    public final int component5() {
        return this.user_id;
    }

    public final boolean component6() {
        return this.vip;
    }

    public final int component7() {
        return this.remaining_downloads;
    }

    public final int component8() {
        return this.downloads_count;
    }

    public final User copy(int i2, int i3, boolean z2, String str, int i4, boolean z3, int i5, int i6) {
        Intrinsics.f(str, AppLovinEventTypes.USER_COMPLETED_LEVEL);
        return new User(i2, i3, z2, str, i4, z3, i5, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return this.allowed_downloads == user.allowed_downloads && this.allowed_translations == user.allowed_translations && this.ext_installed == user.ext_installed && Intrinsics.a(this.level, user.level) && this.user_id == user.user_id && this.vip == user.vip && this.remaining_downloads == user.remaining_downloads && this.downloads_count == user.downloads_count;
    }

    public final int getAllowed_downloads() {
        return this.allowed_downloads;
    }

    public final int getAllowed_translations() {
        return this.allowed_translations;
    }

    public final int getDownloads_count() {
        return this.downloads_count;
    }

    public final boolean getExt_installed() {
        return this.ext_installed;
    }

    public final String getLevel() {
        return this.level;
    }

    public final int getRemaining_downloads() {
        return this.remaining_downloads;
    }

    public final int getUser_id() {
        return this.user_id;
    }

    public final boolean getVip() {
        return this.vip;
    }

    public int hashCode() {
        int i2 = ((this.allowed_downloads * 31) + this.allowed_translations) * 31;
        boolean z2 = this.ext_installed;
        boolean z3 = true;
        if (z2) {
            z2 = true;
        }
        int hashCode = (((((i2 + (z2 ? 1 : 0)) * 31) + this.level.hashCode()) * 31) + this.user_id) * 31;
        boolean z4 = this.vip;
        if (!z4) {
            z3 = z4;
        }
        return ((((hashCode + (z3 ? 1 : 0)) * 31) + this.remaining_downloads) * 31) + this.downloads_count;
    }

    public String toString() {
        return "User(allowed_downloads=" + this.allowed_downloads + ", allowed_translations=" + this.allowed_translations + ", ext_installed=" + this.ext_installed + ", level=" + this.level + ", user_id=" + this.user_id + ", vip=" + this.vip + ", remaining_downloads=" + this.remaining_downloads + ", downloads_count=" + this.downloads_count + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ User(int r13, int r14, boolean r15, java.lang.String r16, int r17, boolean r18, int r19, int r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r10 = 0
            goto L_0x000b
        L_0x0009:
            r10 = r19
        L_0x000b:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0011
            r11 = 0
            goto L_0x0013
        L_0x0011:
            r11 = r20
        L_0x0013:
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.subtitle.services.openSubtitle.models.User.<init>(int, int, boolean, java.lang.String, int, boolean, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
