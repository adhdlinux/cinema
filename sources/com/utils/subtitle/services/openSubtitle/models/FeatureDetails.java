package com.utils.subtitle.services.openSubtitle.models;

import kotlin.jvm.internal.Intrinsics;

public final class FeatureDetails {
    private final int feature_id;
    private final String feature_type;
    private final int imdb_id;
    private final String movie_name;
    private final String title;
    private final int tmdb_id;
    private final int year;

    public FeatureDetails(int i2, String str, int i3, String str2, String str3, int i4, int i5) {
        Intrinsics.f(str, "feature_type");
        Intrinsics.f(str2, "movie_name");
        Intrinsics.f(str3, "title");
        this.feature_id = i2;
        this.feature_type = str;
        this.imdb_id = i3;
        this.movie_name = str2;
        this.title = str3;
        this.tmdb_id = i4;
        this.year = i5;
    }

    public static /* synthetic */ FeatureDetails copy$default(FeatureDetails featureDetails, int i2, String str, int i3, String str2, String str3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = featureDetails.feature_id;
        }
        if ((i6 & 2) != 0) {
            str = featureDetails.feature_type;
        }
        String str4 = str;
        if ((i6 & 4) != 0) {
            i3 = featureDetails.imdb_id;
        }
        int i7 = i3;
        if ((i6 & 8) != 0) {
            str2 = featureDetails.movie_name;
        }
        String str5 = str2;
        if ((i6 & 16) != 0) {
            str3 = featureDetails.title;
        }
        String str6 = str3;
        if ((i6 & 32) != 0) {
            i4 = featureDetails.tmdb_id;
        }
        int i8 = i4;
        if ((i6 & 64) != 0) {
            i5 = featureDetails.year;
        }
        return featureDetails.copy(i2, str4, i7, str5, str6, i8, i5);
    }

    public final int component1() {
        return this.feature_id;
    }

    public final String component2() {
        return this.feature_type;
    }

    public final int component3() {
        return this.imdb_id;
    }

    public final String component4() {
        return this.movie_name;
    }

    public final String component5() {
        return this.title;
    }

    public final int component6() {
        return this.tmdb_id;
    }

    public final int component7() {
        return this.year;
    }

    public final FeatureDetails copy(int i2, String str, int i3, String str2, String str3, int i4, int i5) {
        Intrinsics.f(str, "feature_type");
        Intrinsics.f(str2, "movie_name");
        Intrinsics.f(str3, "title");
        return new FeatureDetails(i2, str, i3, str2, str3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeatureDetails)) {
            return false;
        }
        FeatureDetails featureDetails = (FeatureDetails) obj;
        return this.feature_id == featureDetails.feature_id && Intrinsics.a(this.feature_type, featureDetails.feature_type) && this.imdb_id == featureDetails.imdb_id && Intrinsics.a(this.movie_name, featureDetails.movie_name) && Intrinsics.a(this.title, featureDetails.title) && this.tmdb_id == featureDetails.tmdb_id && this.year == featureDetails.year;
    }

    public final int getFeature_id() {
        return this.feature_id;
    }

    public final String getFeature_type() {
        return this.feature_type;
    }

    public final int getImdb_id() {
        return this.imdb_id;
    }

    public final String getMovie_name() {
        return this.movie_name;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTmdb_id() {
        return this.tmdb_id;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return (((((((((((this.feature_id * 31) + this.feature_type.hashCode()) * 31) + this.imdb_id) * 31) + this.movie_name.hashCode()) * 31) + this.title.hashCode()) * 31) + this.tmdb_id) * 31) + this.year;
    }

    public String toString() {
        return "FeatureDetails(feature_id=" + this.feature_id + ", feature_type=" + this.feature_type + ", imdb_id=" + this.imdb_id + ", movie_name=" + this.movie_name + ", title=" + this.title + ", tmdb_id=" + this.tmdb_id + ", year=" + this.year + ')';
    }
}
