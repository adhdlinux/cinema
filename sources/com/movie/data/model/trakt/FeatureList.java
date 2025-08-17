package com.movie.data.model.trakt;

import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.gson.annotations.SerializedName;
import com.google.protobuf.CodedOutputStream;
import com.uwetrottmann.trakt5.entities.User;
import kotlin.jvm.internal.Intrinsics;

public final class FeatureList {
    @SerializedName("allow_comments")
    private final boolean allowComments;
    @SerializedName("comment_count")
    private final int commentCount;
    @SerializedName("created_at")
    private final String createdAt;
    @SerializedName("description")
    private final String description;
    @SerializedName("display_numbers")
    private final boolean displayNumbers;
    @SerializedName("ids")
    private final ListIds ids;
    @SerializedName("item_count")
    private final int itemCount;
    @SerializedName("likes")
    private final int likes;
    @SerializedName("name")
    private final String name;
    @SerializedName("privacy")
    private final String privacy;
    @SerializedName("sort_by")
    private final String sortBy;
    @SerializedName("sort_how")
    private final String sortHow;
    @SerializedName("updated_at")
    private final String updatedAt;
    @SerializedName("user")
    private final User user;

    public static final class ListIds {
        @SerializedName("slug")
        private final String slug;
        @SerializedName("trakt")
        private final int trakt;

        public ListIds(String str, int i2) {
            Intrinsics.f(str, "slug");
            this.slug = str;
            this.trakt = i2;
        }

        public static /* synthetic */ ListIds copy$default(ListIds listIds, String str, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = listIds.slug;
            }
            if ((i3 & 2) != 0) {
                i2 = listIds.trakt;
            }
            return listIds.copy(str, i2);
        }

        public final String component1() {
            return this.slug;
        }

        public final int component2() {
            return this.trakt;
        }

        public final ListIds copy(String str, int i2) {
            Intrinsics.f(str, "slug");
            return new ListIds(str, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListIds)) {
                return false;
            }
            ListIds listIds = (ListIds) obj;
            return Intrinsics.a(this.slug, listIds.slug) && this.trakt == listIds.trakt;
        }

        public final String getSlug() {
            return this.slug;
        }

        public final int getTrakt() {
            return this.trakt;
        }

        public int hashCode() {
            return (this.slug.hashCode() * 31) + this.trakt;
        }

        public String toString() {
            return "ListIds(slug=" + this.slug + ", trakt=" + this.trakt + ')';
        }
    }

    public FeatureList(boolean z2, int i2, String str, String str2, boolean z3, ListIds listIds, int i3, int i4, String str3, String str4, String str5, String str6, String str7, User user2) {
        Intrinsics.f(str, "createdAt");
        Intrinsics.f(str2, MediaTrack.ROLE_DESCRIPTION);
        Intrinsics.f(listIds, "ids");
        Intrinsics.f(str3, "name");
        Intrinsics.f(str4, "privacy");
        Intrinsics.f(str5, "sortBy");
        Intrinsics.f(str6, "sortHow");
        Intrinsics.f(str7, "updatedAt");
        Intrinsics.f(user2, "user");
        this.allowComments = z2;
        this.commentCount = i2;
        this.createdAt = str;
        this.description = str2;
        this.displayNumbers = z3;
        this.ids = listIds;
        this.itemCount = i3;
        this.likes = i4;
        this.name = str3;
        this.privacy = str4;
        this.sortBy = str5;
        this.sortHow = str6;
        this.updatedAt = str7;
        this.user = user2;
    }

    public static /* synthetic */ FeatureList copy$default(FeatureList featureList, boolean z2, int i2, String str, String str2, boolean z3, ListIds listIds, int i3, int i4, String str3, String str4, String str5, String str6, String str7, User user2, int i5, Object obj) {
        FeatureList featureList2 = featureList;
        int i6 = i5;
        return featureList.copy((i6 & 1) != 0 ? featureList2.allowComments : z2, (i6 & 2) != 0 ? featureList2.commentCount : i2, (i6 & 4) != 0 ? featureList2.createdAt : str, (i6 & 8) != 0 ? featureList2.description : str2, (i6 & 16) != 0 ? featureList2.displayNumbers : z3, (i6 & 32) != 0 ? featureList2.ids : listIds, (i6 & 64) != 0 ? featureList2.itemCount : i3, (i6 & 128) != 0 ? featureList2.likes : i4, (i6 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0 ? featureList2.name : str3, (i6 & 512) != 0 ? featureList2.privacy : str4, (i6 & 1024) != 0 ? featureList2.sortBy : str5, (i6 & 2048) != 0 ? featureList2.sortHow : str6, (i6 & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0 ? featureList2.updatedAt : str7, (i6 & 8192) != 0 ? featureList2.user : user2);
    }

    public final boolean component1() {
        return this.allowComments;
    }

    public final String component10() {
        return this.privacy;
    }

    public final String component11() {
        return this.sortBy;
    }

    public final String component12() {
        return this.sortHow;
    }

    public final String component13() {
        return this.updatedAt;
    }

    public final User component14() {
        return this.user;
    }

    public final int component2() {
        return this.commentCount;
    }

    public final String component3() {
        return this.createdAt;
    }

    public final String component4() {
        return this.description;
    }

    public final boolean component5() {
        return this.displayNumbers;
    }

    public final ListIds component6() {
        return this.ids;
    }

    public final int component7() {
        return this.itemCount;
    }

    public final int component8() {
        return this.likes;
    }

    public final String component9() {
        return this.name;
    }

    public final FeatureList copy(boolean z2, int i2, String str, String str2, boolean z3, ListIds listIds, int i3, int i4, String str3, String str4, String str5, String str6, String str7, User user2) {
        String str8 = str;
        Intrinsics.f(str8, "createdAt");
        String str9 = str2;
        Intrinsics.f(str9, MediaTrack.ROLE_DESCRIPTION);
        ListIds listIds2 = listIds;
        Intrinsics.f(listIds2, "ids");
        String str10 = str3;
        Intrinsics.f(str10, "name");
        String str11 = str4;
        Intrinsics.f(str11, "privacy");
        String str12 = str5;
        Intrinsics.f(str12, "sortBy");
        String str13 = str6;
        Intrinsics.f(str13, "sortHow");
        String str14 = str7;
        Intrinsics.f(str14, "updatedAt");
        User user3 = user2;
        Intrinsics.f(user3, "user");
        return new FeatureList(z2, i2, str8, str9, z3, listIds2, i3, i4, str10, str11, str12, str13, str14, user3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeatureList)) {
            return false;
        }
        FeatureList featureList = (FeatureList) obj;
        return this.allowComments == featureList.allowComments && this.commentCount == featureList.commentCount && Intrinsics.a(this.createdAt, featureList.createdAt) && Intrinsics.a(this.description, featureList.description) && this.displayNumbers == featureList.displayNumbers && Intrinsics.a(this.ids, featureList.ids) && this.itemCount == featureList.itemCount && this.likes == featureList.likes && Intrinsics.a(this.name, featureList.name) && Intrinsics.a(this.privacy, featureList.privacy) && Intrinsics.a(this.sortBy, featureList.sortBy) && Intrinsics.a(this.sortHow, featureList.sortHow) && Intrinsics.a(this.updatedAt, featureList.updatedAt) && Intrinsics.a(this.user, featureList.user);
    }

    public final boolean getAllowComments() {
        return this.allowComments;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getDisplayNumbers() {
        return this.displayNumbers;
    }

    public final ListIds getIds() {
        return this.ids;
    }

    public final int getItemCount() {
        return this.itemCount;
    }

    public final int getLikes() {
        return this.likes;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPrivacy() {
        return this.privacy;
    }

    public final String getSortBy() {
        return this.sortBy;
    }

    public final String getSortHow() {
        return this.sortHow;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        boolean z2 = this.allowComments;
        boolean z3 = true;
        if (z2) {
            z2 = true;
        }
        int hashCode = (((((((z2 ? 1 : 0) * true) + this.commentCount) * 31) + this.createdAt.hashCode()) * 31) + this.description.hashCode()) * 31;
        boolean z4 = this.displayNumbers;
        if (!z4) {
            z3 = z4;
        }
        return ((((((((((((((((((hashCode + (z3 ? 1 : 0)) * 31) + this.ids.hashCode()) * 31) + this.itemCount) * 31) + this.likes) * 31) + this.name.hashCode()) * 31) + this.privacy.hashCode()) * 31) + this.sortBy.hashCode()) * 31) + this.sortHow.hashCode()) * 31) + this.updatedAt.hashCode()) * 31) + this.user.hashCode();
    }

    public String toString() {
        return "FeatureList(allowComments=" + this.allowComments + ", commentCount=" + this.commentCount + ", createdAt=" + this.createdAt + ", description=" + this.description + ", displayNumbers=" + this.displayNumbers + ", ids=" + this.ids + ", itemCount=" + this.itemCount + ", likes=" + this.likes + ", name=" + this.name + ", privacy=" + this.privacy + ", sortBy=" + this.sortBy + ", sortHow=" + this.sortHow + ", updatedAt=" + this.updatedAt + ", user=" + this.user + ')';
    }
}
