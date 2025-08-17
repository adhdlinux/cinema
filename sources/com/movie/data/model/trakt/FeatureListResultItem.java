package com.movie.data.model.trakt;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

public final class FeatureListResultItem {
    @SerializedName("comment_count")
    private final int commentCount;
    @SerializedName("like_count")
    private final int likeCount;
    @SerializedName("list")
    private final FeatureList list;

    public FeatureListResultItem(int i2, int i3, FeatureList featureList) {
        Intrinsics.f(featureList, "list");
        this.commentCount = i2;
        this.likeCount = i3;
        this.list = featureList;
    }

    public static /* synthetic */ FeatureListResultItem copy$default(FeatureListResultItem featureListResultItem, int i2, int i3, FeatureList featureList, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = featureListResultItem.commentCount;
        }
        if ((i4 & 2) != 0) {
            i3 = featureListResultItem.likeCount;
        }
        if ((i4 & 4) != 0) {
            featureList = featureListResultItem.list;
        }
        return featureListResultItem.copy(i2, i3, featureList);
    }

    public final int component1() {
        return this.commentCount;
    }

    public final int component2() {
        return this.likeCount;
    }

    public final FeatureList component3() {
        return this.list;
    }

    public final FeatureListResultItem copy(int i2, int i3, FeatureList featureList) {
        Intrinsics.f(featureList, "list");
        return new FeatureListResultItem(i2, i3, featureList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeatureListResultItem)) {
            return false;
        }
        FeatureListResultItem featureListResultItem = (FeatureListResultItem) obj;
        return this.commentCount == featureListResultItem.commentCount && this.likeCount == featureListResultItem.likeCount && Intrinsics.a(this.list, featureListResultItem.list);
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final FeatureList getList() {
        return this.list;
    }

    public int hashCode() {
        return (((this.commentCount * 31) + this.likeCount) * 31) + this.list.hashCode();
    }

    public String toString() {
        return "FeatureListResultItem(commentCount=" + this.commentCount + ", likeCount=" + this.likeCount + ", list=" + this.list + ')';
    }
}
