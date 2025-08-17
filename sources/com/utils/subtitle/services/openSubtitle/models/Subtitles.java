package com.utils.subtitle.services.openSubtitle.models;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class Subtitles {
    private final List<Data> data;
    private final int page;
    private final int per_page;
    private final int total_count;
    private final int total_pages;

    public Subtitles(List<Data> list, int i2, int i3, int i4, int i5) {
        Intrinsics.f(list, "data");
        this.data = list;
        this.page = i2;
        this.per_page = i3;
        this.total_count = i4;
        this.total_pages = i5;
    }

    public static /* synthetic */ Subtitles copy$default(Subtitles subtitles, List<Data> list, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            list = subtitles.data;
        }
        if ((i6 & 2) != 0) {
            i2 = subtitles.page;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = subtitles.per_page;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = subtitles.total_count;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = subtitles.total_pages;
        }
        return subtitles.copy(list, i7, i8, i9, i5);
    }

    public final List<Data> component1() {
        return this.data;
    }

    public final int component2() {
        return this.page;
    }

    public final int component3() {
        return this.per_page;
    }

    public final int component4() {
        return this.total_count;
    }

    public final int component5() {
        return this.total_pages;
    }

    public final Subtitles copy(List<Data> list, int i2, int i3, int i4, int i5) {
        Intrinsics.f(list, "data");
        return new Subtitles(list, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Subtitles)) {
            return false;
        }
        Subtitles subtitles = (Subtitles) obj;
        return Intrinsics.a(this.data, subtitles.data) && this.page == subtitles.page && this.per_page == subtitles.per_page && this.total_count == subtitles.total_count && this.total_pages == subtitles.total_pages;
    }

    public final List<Data> getData() {
        return this.data;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPer_page() {
        return this.per_page;
    }

    public final int getTotal_count() {
        return this.total_count;
    }

    public final int getTotal_pages() {
        return this.total_pages;
    }

    public int hashCode() {
        return (((((((this.data.hashCode() * 31) + this.page) * 31) + this.per_page) * 31) + this.total_count) * 31) + this.total_pages;
    }

    public String toString() {
        return "Subtitles(data=" + this.data + ", page=" + this.page + ", per_page=" + this.per_page + ", total_count=" + this.total_count + ", total_pages=" + this.total_pages + ')';
    }
}
