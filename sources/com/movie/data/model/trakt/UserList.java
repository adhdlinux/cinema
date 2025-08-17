package com.movie.data.model.trakt;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.gson.annotations.SerializedName;
import com.google.protobuf.CodedOutputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;

public final class UserList {
    @SerializedName("allow_comments")
    private final Boolean allowComments;
    @SerializedName("comment_count")
    private final Integer commentCount;
    @SerializedName("created_at")
    private final String createdAt;
    @SerializedName("description")
    private final String description;
    @SerializedName("display_numbers")
    private final Boolean displayNumbers;
    @SerializedName("ids")
    private final Ids ids;
    @SerializedName("item_count")
    private final Integer itemCount;
    @SerializedName("likes")
    private final Integer likes;
    @SerializedName("name")
    private final String name;
    @SerializedName("privacy")
    private final String privacy;
    @SerializedName("share_link")
    private final String shareLink;
    @SerializedName("sort_by")
    private final String sortBy;
    @SerializedName("sort_how")
    private final String sortHow;
    @SerializedName("type")
    private final String type;
    @SerializedName("updated_at")
    private final String updatedAt;

    public UserList() {
        this((Integer) null, (Integer) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (Ids) null, (String) null, (Integer) null, 32767, (DefaultConstructorMarker) null);
    }

    public UserList(Integer num, Integer num2, Boolean bool, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool2, String str8, Ids ids2, String str9, Integer num3) {
        this.itemCount = num;
        this.commentCount = num2;
        this.allowComments = bool;
        this.description = str;
        this.privacy = str2;
        this.createdAt = str3;
        this.sortBy = str4;
        this.type = str5;
        this.shareLink = str6;
        this.updatedAt = str7;
        this.displayNumbers = bool2;
        this.name = str8;
        this.ids = ids2;
        this.sortHow = str9;
        this.likes = num3;
    }

    public static /* synthetic */ UserList copy$default(UserList userList, Integer num, Integer num2, Boolean bool, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool2, String str8, Ids ids2, String str9, Integer num3, int i2, Object obj) {
        UserList userList2 = userList;
        int i3 = i2;
        return userList.copy((i3 & 1) != 0 ? userList2.itemCount : num, (i3 & 2) != 0 ? userList2.commentCount : num2, (i3 & 4) != 0 ? userList2.allowComments : bool, (i3 & 8) != 0 ? userList2.description : str, (i3 & 16) != 0 ? userList2.privacy : str2, (i3 & 32) != 0 ? userList2.createdAt : str3, (i3 & 64) != 0 ? userList2.sortBy : str4, (i3 & 128) != 0 ? userList2.type : str5, (i3 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0 ? userList2.shareLink : str6, (i3 & 512) != 0 ? userList2.updatedAt : str7, (i3 & 1024) != 0 ? userList2.displayNumbers : bool2, (i3 & 2048) != 0 ? userList2.name : str8, (i3 & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0 ? userList2.ids : ids2, (i3 & 8192) != 0 ? userList2.sortHow : str9, (i3 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? userList2.likes : num3);
    }

    public final Integer component1() {
        return this.itemCount;
    }

    public final String component10() {
        return this.updatedAt;
    }

    public final Boolean component11() {
        return this.displayNumbers;
    }

    public final String component12() {
        return this.name;
    }

    public final Ids component13() {
        return this.ids;
    }

    public final String component14() {
        return this.sortHow;
    }

    public final Integer component15() {
        return this.likes;
    }

    public final Integer component2() {
        return this.commentCount;
    }

    public final Boolean component3() {
        return this.allowComments;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.privacy;
    }

    public final String component6() {
        return this.createdAt;
    }

    public final String component7() {
        return this.sortBy;
    }

    public final String component8() {
        return this.type;
    }

    public final String component9() {
        return this.shareLink;
    }

    public final UserList copy(Integer num, Integer num2, Boolean bool, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool2, String str8, Ids ids2, String str9, Integer num3) {
        return new UserList(num, num2, bool, str, str2, str3, str4, str5, str6, str7, bool2, str8, ids2, str9, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserList)) {
            return false;
        }
        UserList userList = (UserList) obj;
        return Intrinsics.a(this.itemCount, userList.itemCount) && Intrinsics.a(this.commentCount, userList.commentCount) && Intrinsics.a(this.allowComments, userList.allowComments) && Intrinsics.a(this.description, userList.description) && Intrinsics.a(this.privacy, userList.privacy) && Intrinsics.a(this.createdAt, userList.createdAt) && Intrinsics.a(this.sortBy, userList.sortBy) && Intrinsics.a(this.type, userList.type) && Intrinsics.a(this.shareLink, userList.shareLink) && Intrinsics.a(this.updatedAt, userList.updatedAt) && Intrinsics.a(this.displayNumbers, userList.displayNumbers) && Intrinsics.a(this.name, userList.name) && Intrinsics.a(this.ids, userList.ids) && Intrinsics.a(this.sortHow, userList.sortHow) && Intrinsics.a(this.likes, userList.likes);
    }

    public final Boolean getAllowComments() {
        return this.allowComments;
    }

    public final Integer getCommentCount() {
        return this.commentCount;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Boolean getDisplayNumbers() {
        return this.displayNumbers;
    }

    public final Ids getIds() {
        return this.ids;
    }

    public final Integer getItemCount() {
        return this.itemCount;
    }

    public final Integer getLikes() {
        return this.likes;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPrivacy() {
        return this.privacy;
    }

    public final String getShareLink() {
        return this.shareLink;
    }

    public final String getSortBy() {
        return this.sortBy;
    }

    public final String getSortHow() {
        return this.sortHow;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        Integer num = this.itemCount;
        int i2 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.commentCount;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.allowComments;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.description;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.privacy;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.createdAt;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sortBy;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.type;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.shareLink;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.updatedAt;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool2 = this.displayNumbers;
        int hashCode11 = (hashCode10 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str8 = this.name;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Ids ids2 = this.ids;
        int hashCode13 = (hashCode12 + (ids2 == null ? 0 : ids2.hashCode())) * 31;
        String str9 = this.sortHow;
        int hashCode14 = (hashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num3 = this.likes;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        return hashCode14 + i2;
    }

    public String toString() {
        return "UserList(itemCount=" + this.itemCount + ", commentCount=" + this.commentCount + ", allowComments=" + this.allowComments + ", description=" + this.description + ", privacy=" + this.privacy + ", createdAt=" + this.createdAt + ", sortBy=" + this.sortBy + ", type=" + this.type + ", shareLink=" + this.shareLink + ", updatedAt=" + this.updatedAt + ", displayNumbers=" + this.displayNumbers + ", name=" + this.name + ", ids=" + this.ids + ", sortHow=" + this.sortHow + ", likes=" + this.likes + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserList(java.lang.Integer r17, java.lang.Integer r18, java.lang.Boolean r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.Boolean r27, java.lang.String r28, com.movie.data.model.trakt.Ids r29, java.lang.String r30, java.lang.Integer r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r19
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r20
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r21
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r22
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r23
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r24
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r25
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r26
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r27
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r28
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r29
        L_0x006b:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0071
            r15 = r2
            goto L_0x0073
        L_0x0071:
            r15 = r30
        L_0x0073:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r2 = r31
        L_0x007a:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r15
            r32 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.data.model.trakt.UserList.<init>(java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, com.movie.data.model.trakt.Ids, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
