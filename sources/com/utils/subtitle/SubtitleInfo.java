package com.utils.subtitle;

import android.os.Parcel;
import android.os.Parcelable;

public class SubtitleInfo implements Parcelable {
    public static final Parcelable.Creator<SubtitleInfo> CREATOR = new Parcelable.Creator<SubtitleInfo>() {
        /* renamed from: a */
        public SubtitleInfo createFromParcel(Parcel parcel) {
            return new SubtitleInfo(parcel);
        }

        /* renamed from: b */
        public SubtitleInfo[] newArray(int i2) {
            return new SubtitleInfo[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public String f37702b;

    /* renamed from: c  reason: collision with root package name */
    public String f37703c;

    /* renamed from: d  reason: collision with root package name */
    public String f37704d;

    /* renamed from: e  reason: collision with root package name */
    public int f37705e;

    /* renamed from: f  reason: collision with root package name */
    public Source f37706f;

    public enum Source {
        SubceneCrawl(0),
        OpenSubtitleRest(1),
        OpenSubtitleApi(2),
        Yifysubtitles(3),
        Local(4),
        Subtitlecat(5),
        SubDL(6),
        opensubtitlesIO(7);
        

        /* renamed from: b  reason: collision with root package name */
        private int f37716b;

        private Source(int i2) {
            this.f37716b = i2;
        }
    }

    public SubtitleInfo() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        parcel.writeString(this.f37702b);
        parcel.writeString(this.f37703c);
        parcel.writeString(this.f37704d);
        parcel.writeInt(this.f37705e);
        Source source = this.f37706f;
        if (source == null) {
            i3 = -1;
        } else {
            i3 = source.ordinal();
        }
        parcel.writeInt(i3);
    }

    public SubtitleInfo(String str, String str2, String str3, int i2, Source source) {
        this.f37702b = str;
        this.f37703c = str2;
        this.f37704d = str3;
        this.f37705e = i2;
        this.f37706f = source;
    }

    protected SubtitleInfo(Parcel parcel) {
        this.f37702b = parcel.readString();
        this.f37703c = parcel.readString();
        this.f37704d = parcel.readString();
        this.f37705e = parcel.readInt();
        this.f37706f = Source.values()[parcel.readInt()];
    }
}
