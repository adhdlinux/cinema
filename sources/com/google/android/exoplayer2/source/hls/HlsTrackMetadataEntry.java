package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HlsTrackMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<HlsTrackMetadataEntry> CREATOR = new Parcelable.Creator<HlsTrackMetadataEntry>() {
        /* renamed from: a */
        public HlsTrackMetadataEntry createFromParcel(Parcel parcel) {
            return new HlsTrackMetadataEntry(parcel);
        }

        /* renamed from: b */
        public HlsTrackMetadataEntry[] newArray(int i2) {
            return new HlsTrackMetadataEntry[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final String f26531b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26532c;

    /* renamed from: d  reason: collision with root package name */
    public final List<VariantInfo> f26533d;

    public HlsTrackMetadataEntry(String str, String str2, List<VariantInfo> list) {
        this.f26531b = str;
        this.f26532c = str2;
        this.f26533d = Collections.unmodifiableList(new ArrayList(list));
    }

    public /* synthetic */ Format D() {
        return a.b(this);
    }

    public /* synthetic */ byte[] E() {
        return a.a(this);
    }

    public /* synthetic */ void a(MediaMetadata.Builder builder) {
        a.c(this, builder);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HlsTrackMetadataEntry.class != obj.getClass()) {
            return false;
        }
        HlsTrackMetadataEntry hlsTrackMetadataEntry = (HlsTrackMetadataEntry) obj;
        if (!TextUtils.equals(this.f26531b, hlsTrackMetadataEntry.f26531b) || !TextUtils.equals(this.f26532c, hlsTrackMetadataEntry.f26532c) || !this.f26533d.equals(hlsTrackMetadataEntry.f26533d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        String str = this.f26531b;
        int i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i4 = i2 * 31;
        String str2 = this.f26532c;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((i4 + i3) * 31) + this.f26533d.hashCode();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("HlsTrackMetadataEntry");
        if (this.f26531b != null) {
            str = " [" + this.f26531b + ", " + this.f26532c + "]";
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f26531b);
        parcel.writeString(this.f26532c);
        int size = this.f26533d.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeParcelable(this.f26533d.get(i3), 0);
        }
    }

    HlsTrackMetadataEntry(Parcel parcel) {
        this.f26531b = parcel.readString();
        this.f26532c = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add((VariantInfo) parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.f26533d = Collections.unmodifiableList(arrayList);
    }

    public static final class VariantInfo implements Parcelable {
        public static final Parcelable.Creator<VariantInfo> CREATOR = new Parcelable.Creator<VariantInfo>() {
            /* renamed from: a */
            public VariantInfo createFromParcel(Parcel parcel) {
                return new VariantInfo(parcel);
            }

            /* renamed from: b */
            public VariantInfo[] newArray(int i2) {
                return new VariantInfo[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public final int f26534b;

        /* renamed from: c  reason: collision with root package name */
        public final int f26535c;

        /* renamed from: d  reason: collision with root package name */
        public final String f26536d;

        /* renamed from: e  reason: collision with root package name */
        public final String f26537e;

        /* renamed from: f  reason: collision with root package name */
        public final String f26538f;

        /* renamed from: g  reason: collision with root package name */
        public final String f26539g;

        public VariantInfo(int i2, int i3, String str, String str2, String str3, String str4) {
            this.f26534b = i2;
            this.f26535c = i3;
            this.f26536d = str;
            this.f26537e = str2;
            this.f26538f = str3;
            this.f26539g = str4;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || VariantInfo.class != obj.getClass()) {
                return false;
            }
            VariantInfo variantInfo = (VariantInfo) obj;
            if (this.f26534b != variantInfo.f26534b || this.f26535c != variantInfo.f26535c || !TextUtils.equals(this.f26536d, variantInfo.f26536d) || !TextUtils.equals(this.f26537e, variantInfo.f26537e) || !TextUtils.equals(this.f26538f, variantInfo.f26538f) || !TextUtils.equals(this.f26539g, variantInfo.f26539g)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2;
            int i3;
            int i4;
            int i5 = ((this.f26534b * 31) + this.f26535c) * 31;
            String str = this.f26536d;
            int i6 = 0;
            if (str != null) {
                i2 = str.hashCode();
            } else {
                i2 = 0;
            }
            int i7 = (i5 + i2) * 31;
            String str2 = this.f26537e;
            if (str2 != null) {
                i3 = str2.hashCode();
            } else {
                i3 = 0;
            }
            int i8 = (i7 + i3) * 31;
            String str3 = this.f26538f;
            if (str3 != null) {
                i4 = str3.hashCode();
            } else {
                i4 = 0;
            }
            int i9 = (i8 + i4) * 31;
            String str4 = this.f26539g;
            if (str4 != null) {
                i6 = str4.hashCode();
            }
            return i9 + i6;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f26534b);
            parcel.writeInt(this.f26535c);
            parcel.writeString(this.f26536d);
            parcel.writeString(this.f26537e);
            parcel.writeString(this.f26538f);
            parcel.writeString(this.f26539g);
        }

        VariantInfo(Parcel parcel) {
            this.f26534b = parcel.readInt();
            this.f26535c = parcel.readInt();
            this.f26536d = parcel.readString();
            this.f26537e = parcel.readString();
            this.f26538f = parcel.readString();
            this.f26539g = parcel.readString();
        }
    }
}
