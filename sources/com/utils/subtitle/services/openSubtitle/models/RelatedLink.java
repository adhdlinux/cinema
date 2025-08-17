package com.utils.subtitle.services.openSubtitle.models;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.jvm.internal.Intrinsics;

public final class RelatedLink {
    private final String img_url;
    private final String label;
    private final String url;

    public RelatedLink(String str, String str2, String str3) {
        Intrinsics.f(str, "img_url");
        Intrinsics.f(str2, "label");
        Intrinsics.f(str3, ImagesContract.URL);
        this.img_url = str;
        this.label = str2;
        this.url = str3;
    }

    public static /* synthetic */ RelatedLink copy$default(RelatedLink relatedLink, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = relatedLink.img_url;
        }
        if ((i2 & 2) != 0) {
            str2 = relatedLink.label;
        }
        if ((i2 & 4) != 0) {
            str3 = relatedLink.url;
        }
        return relatedLink.copy(str, str2, str3);
    }

    public final String component1() {
        return this.img_url;
    }

    public final String component2() {
        return this.label;
    }

    public final String component3() {
        return this.url;
    }

    public final RelatedLink copy(String str, String str2, String str3) {
        Intrinsics.f(str, "img_url");
        Intrinsics.f(str2, "label");
        Intrinsics.f(str3, ImagesContract.URL);
        return new RelatedLink(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RelatedLink)) {
            return false;
        }
        RelatedLink relatedLink = (RelatedLink) obj;
        return Intrinsics.a(this.img_url, relatedLink.img_url) && Intrinsics.a(this.label, relatedLink.label) && Intrinsics.a(this.url, relatedLink.url);
    }

    public final String getImg_url() {
        return this.img_url;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((this.img_url.hashCode() * 31) + this.label.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "RelatedLink(img_url=" + this.img_url + ", label=" + this.label + ", url=" + this.url + ')';
    }
}
