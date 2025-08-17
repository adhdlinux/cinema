package com.utils.subtitle.services.openSubtitle.models;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.ar.core.ImageMetadata;
import com.google.protobuf.CodedOutputStream;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;

public final class Attributes {
    private final boolean ai_translated;
    private final String comments;
    private final int download_count;
    private final FeatureDetails feature_details;
    private final List<File> files;
    private final boolean foreign_parts_only;
    private final double fps;
    private final boolean from_trusted;
    private final boolean hd;
    private final boolean hearing_impaired;
    private final String language;
    private final int legacy_subtitle_id;
    private final boolean machine_translated;
    private final int new_download_count;
    private final double ratings;
    private final List<RelatedLink> related_links;
    private final String release;
    private final String subtitle_id;
    private final String upload_date;
    private final Uploader uploader;
    private final String url;
    private final int votes;

    public Attributes(boolean z2, String str, int i2, FeatureDetails featureDetails, List<File> list, boolean z3, double d2, boolean z4, boolean z5, boolean z6, String str2, int i3, boolean z7, int i4, double d3, List<RelatedLink> list2, String str3, String str4, String str5, Uploader uploader2, String str6, int i5) {
        FeatureDetails featureDetails2 = featureDetails;
        List<File> list3 = list;
        String str7 = str2;
        List<RelatedLink> list4 = list2;
        String str8 = str3;
        String str9 = str4;
        String str10 = str5;
        Uploader uploader3 = uploader2;
        String str11 = str6;
        Intrinsics.f(str, "comments");
        Intrinsics.f(featureDetails2, "feature_details");
        Intrinsics.f(list3, "files");
        Intrinsics.f(str7, "language");
        Intrinsics.f(list4, "related_links");
        Intrinsics.f(str8, "release");
        Intrinsics.f(str9, "subtitle_id");
        Intrinsics.f(str10, "upload_date");
        Intrinsics.f(uploader3, "uploader");
        Intrinsics.f(str11, ImagesContract.URL);
        this.ai_translated = z2;
        this.comments = str;
        this.download_count = i2;
        this.feature_details = featureDetails2;
        this.files = list3;
        this.foreign_parts_only = z3;
        this.fps = d2;
        this.from_trusted = z4;
        this.hd = z5;
        this.hearing_impaired = z6;
        this.language = str7;
        this.legacy_subtitle_id = i3;
        this.machine_translated = z7;
        this.new_download_count = i4;
        this.ratings = d3;
        this.related_links = list4;
        this.release = str8;
        this.subtitle_id = str9;
        this.upload_date = str10;
        this.uploader = uploader3;
        this.url = str11;
        this.votes = i5;
    }

    public static /* synthetic */ Attributes copy$default(Attributes attributes, boolean z2, String str, int i2, FeatureDetails featureDetails, List list, boolean z3, double d2, boolean z4, boolean z5, boolean z6, String str2, int i3, boolean z7, int i4, double d3, List list2, String str3, String str4, String str5, Uploader uploader2, String str6, int i5, int i6, Object obj) {
        Attributes attributes2 = attributes;
        int i7 = i6;
        return attributes.copy((i7 & 1) != 0 ? attributes2.ai_translated : z2, (i7 & 2) != 0 ? attributes2.comments : str, (i7 & 4) != 0 ? attributes2.download_count : i2, (i7 & 8) != 0 ? attributes2.feature_details : featureDetails, (i7 & 16) != 0 ? attributes2.files : list, (i7 & 32) != 0 ? attributes2.foreign_parts_only : z3, (i7 & 64) != 0 ? attributes2.fps : d2, (i7 & 128) != 0 ? attributes2.from_trusted : z4, (i7 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0 ? attributes2.hd : z5, (i7 & 512) != 0 ? attributes2.hearing_impaired : z6, (i7 & 1024) != 0 ? attributes2.language : str2, (i7 & 2048) != 0 ? attributes2.legacy_subtitle_id : i3, (i7 & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0 ? attributes2.machine_translated : z7, (i7 & 8192) != 0 ? attributes2.new_download_count : i4, (i7 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? attributes2.ratings : d3, (i7 & 32768) != 0 ? attributes2.related_links : list2, (65536 & i7) != 0 ? attributes2.release : str3, (i7 & 131072) != 0 ? attributes2.subtitle_id : str4, (i7 & 262144) != 0 ? attributes2.upload_date : str5, (i7 & ImageMetadata.LENS_APERTURE) != 0 ? attributes2.uploader : uploader2, (i7 & 1048576) != 0 ? attributes2.url : str6, (i7 & 2097152) != 0 ? attributes2.votes : i5);
    }

    public final boolean component1() {
        return this.ai_translated;
    }

    public final boolean component10() {
        return this.hearing_impaired;
    }

    public final String component11() {
        return this.language;
    }

    public final int component12() {
        return this.legacy_subtitle_id;
    }

    public final boolean component13() {
        return this.machine_translated;
    }

    public final int component14() {
        return this.new_download_count;
    }

    public final double component15() {
        return this.ratings;
    }

    public final List<RelatedLink> component16() {
        return this.related_links;
    }

    public final String component17() {
        return this.release;
    }

    public final String component18() {
        return this.subtitle_id;
    }

    public final String component19() {
        return this.upload_date;
    }

    public final String component2() {
        return this.comments;
    }

    public final Uploader component20() {
        return this.uploader;
    }

    public final String component21() {
        return this.url;
    }

    public final int component22() {
        return this.votes;
    }

    public final int component3() {
        return this.download_count;
    }

    public final FeatureDetails component4() {
        return this.feature_details;
    }

    public final List<File> component5() {
        return this.files;
    }

    public final boolean component6() {
        return this.foreign_parts_only;
    }

    public final double component7() {
        return this.fps;
    }

    public final boolean component8() {
        return this.from_trusted;
    }

    public final boolean component9() {
        return this.hd;
    }

    public final Attributes copy(boolean z2, String str, int i2, FeatureDetails featureDetails, List<File> list, boolean z3, double d2, boolean z4, boolean z5, boolean z6, String str2, int i3, boolean z7, int i4, double d3, List<RelatedLink> list2, String str3, String str4, String str5, Uploader uploader2, String str6, int i5) {
        boolean z8 = z2;
        Intrinsics.f(str, "comments");
        Intrinsics.f(featureDetails, "feature_details");
        Intrinsics.f(list, "files");
        Intrinsics.f(str2, "language");
        Intrinsics.f(list2, "related_links");
        Intrinsics.f(str3, "release");
        Intrinsics.f(str4, "subtitle_id");
        Intrinsics.f(str5, "upload_date");
        Intrinsics.f(uploader2, "uploader");
        Intrinsics.f(str6, ImagesContract.URL);
        return new Attributes(z2, str, i2, featureDetails, list, z3, d2, z4, z5, z6, str2, i3, z7, i4, d3, list2, str3, str4, str5, uploader2, str6, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attributes)) {
            return false;
        }
        Attributes attributes = (Attributes) obj;
        return this.ai_translated == attributes.ai_translated && Intrinsics.a(this.comments, attributes.comments) && this.download_count == attributes.download_count && Intrinsics.a(this.feature_details, attributes.feature_details) && Intrinsics.a(this.files, attributes.files) && this.foreign_parts_only == attributes.foreign_parts_only && Double.compare(this.fps, attributes.fps) == 0 && this.from_trusted == attributes.from_trusted && this.hd == attributes.hd && this.hearing_impaired == attributes.hearing_impaired && Intrinsics.a(this.language, attributes.language) && this.legacy_subtitle_id == attributes.legacy_subtitle_id && this.machine_translated == attributes.machine_translated && this.new_download_count == attributes.new_download_count && Double.compare(this.ratings, attributes.ratings) == 0 && Intrinsics.a(this.related_links, attributes.related_links) && Intrinsics.a(this.release, attributes.release) && Intrinsics.a(this.subtitle_id, attributes.subtitle_id) && Intrinsics.a(this.upload_date, attributes.upload_date) && Intrinsics.a(this.uploader, attributes.uploader) && Intrinsics.a(this.url, attributes.url) && this.votes == attributes.votes;
    }

    public final boolean getAi_translated() {
        return this.ai_translated;
    }

    public final String getComments() {
        return this.comments;
    }

    public final int getDownload_count() {
        return this.download_count;
    }

    public final FeatureDetails getFeature_details() {
        return this.feature_details;
    }

    public final List<File> getFiles() {
        return this.files;
    }

    public final boolean getForeign_parts_only() {
        return this.foreign_parts_only;
    }

    public final double getFps() {
        return this.fps;
    }

    public final boolean getFrom_trusted() {
        return this.from_trusted;
    }

    public final boolean getHd() {
        return this.hd;
    }

    public final boolean getHearing_impaired() {
        return this.hearing_impaired;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final int getLegacy_subtitle_id() {
        return this.legacy_subtitle_id;
    }

    public final boolean getMachine_translated() {
        return this.machine_translated;
    }

    public final int getNew_download_count() {
        return this.new_download_count;
    }

    public final double getRatings() {
        return this.ratings;
    }

    public final List<RelatedLink> getRelated_links() {
        return this.related_links;
    }

    public final String getRelease() {
        return this.release;
    }

    public final String getSubtitle_id() {
        return this.subtitle_id;
    }

    public final String getUpload_date() {
        return this.upload_date;
    }

    public final Uploader getUploader() {
        return this.uploader;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getVotes() {
        return this.votes;
    }

    public int hashCode() {
        boolean z2 = this.ai_translated;
        boolean z3 = true;
        if (z2) {
            z2 = true;
        }
        int hashCode = (((((((((z2 ? 1 : 0) * true) + this.comments.hashCode()) * 31) + this.download_count) * 31) + this.feature_details.hashCode()) * 31) + this.files.hashCode()) * 31;
        boolean z4 = this.foreign_parts_only;
        if (z4) {
            z4 = true;
        }
        int a2 = (((hashCode + (z4 ? 1 : 0)) * 31) + Double.doubleToLongBits(this.fps)) * 31;
        boolean z5 = this.from_trusted;
        if (z5) {
            z5 = true;
        }
        int i2 = (a2 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.hd;
        if (z6) {
            z6 = true;
        }
        int i3 = (i2 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.hearing_impaired;
        if (z7) {
            z7 = true;
        }
        int hashCode2 = (((((i3 + (z7 ? 1 : 0)) * 31) + this.language.hashCode()) * 31) + this.legacy_subtitle_id) * 31;
        boolean z8 = this.machine_translated;
        if (!z8) {
            z3 = z8;
        }
        return ((((((((((((((((((hashCode2 + (z3 ? 1 : 0)) * 31) + this.new_download_count) * 31) + Double.doubleToLongBits(this.ratings)) * 31) + this.related_links.hashCode()) * 31) + this.release.hashCode()) * 31) + this.subtitle_id.hashCode()) * 31) + this.upload_date.hashCode()) * 31) + this.uploader.hashCode()) * 31) + this.url.hashCode()) * 31) + this.votes;
    }

    public String toString() {
        return "Attributes(ai_translated=" + this.ai_translated + ", comments=" + this.comments + ", download_count=" + this.download_count + ", feature_details=" + this.feature_details + ", files=" + this.files + ", foreign_parts_only=" + this.foreign_parts_only + ", fps=" + this.fps + ", from_trusted=" + this.from_trusted + ", hd=" + this.hd + ", hearing_impaired=" + this.hearing_impaired + ", language=" + this.language + ", legacy_subtitle_id=" + this.legacy_subtitle_id + ", machine_translated=" + this.machine_translated + ", new_download_count=" + this.new_download_count + ", ratings=" + this.ratings + ", related_links=" + this.related_links + ", release=" + this.release + ", subtitle_id=" + this.subtitle_id + ", upload_date=" + this.upload_date + ", uploader=" + this.uploader + ", url=" + this.url + ", votes=" + this.votes + ')';
    }
}
