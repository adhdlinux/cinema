package androidx.media3.exoplayer.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
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
    public final String f6443b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6444c;

    /* renamed from: d  reason: collision with root package name */
    public final List<VariantInfo> f6445d;

    public HlsTrackMetadataEntry(String str, String str2, List<VariantInfo> list) {
        this.f6443b = str;
        this.f6444c = str2;
        this.f6445d = Collections.unmodifiableList(new ArrayList(list));
    }

    public /* synthetic */ Format D() {
        return d.b(this);
    }

    public /* synthetic */ byte[] E() {
        return d.a(this);
    }

    public /* synthetic */ void H(MediaMetadata.Builder builder) {
        d.c(this, builder);
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
        if (!TextUtils.equals(this.f6443b, hlsTrackMetadataEntry.f6443b) || !TextUtils.equals(this.f6444c, hlsTrackMetadataEntry.f6444c) || !this.f6445d.equals(hlsTrackMetadataEntry.f6445d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        String str = this.f6443b;
        int i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i4 = i2 * 31;
        String str2 = this.f6444c;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((i4 + i3) * 31) + this.f6445d.hashCode();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("HlsTrackMetadataEntry");
        if (this.f6443b != null) {
            str = " [" + this.f6443b + ", " + this.f6444c + "]";
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6443b);
        parcel.writeString(this.f6444c);
        int size = this.f6445d.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeParcelable(this.f6445d.get(i3), 0);
        }
    }

    HlsTrackMetadataEntry(Parcel parcel) {
        this.f6443b = parcel.readString();
        this.f6444c = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add((VariantInfo) parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.f6445d = Collections.unmodifiableList(arrayList);
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
        public final int f6446b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6447c;

        /* renamed from: d  reason: collision with root package name */
        public final String f6448d;

        /* renamed from: e  reason: collision with root package name */
        public final String f6449e;

        /* renamed from: f  reason: collision with root package name */
        public final String f6450f;

        /* renamed from: g  reason: collision with root package name */
        public final String f6451g;

        public VariantInfo(int i2, int i3, String str, String str2, String str3, String str4) {
            this.f6446b = i2;
            this.f6447c = i3;
            this.f6448d = str;
            this.f6449e = str2;
            this.f6450f = str3;
            this.f6451g = str4;
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
            if (this.f6446b != variantInfo.f6446b || this.f6447c != variantInfo.f6447c || !TextUtils.equals(this.f6448d, variantInfo.f6448d) || !TextUtils.equals(this.f6449e, variantInfo.f6449e) || !TextUtils.equals(this.f6450f, variantInfo.f6450f) || !TextUtils.equals(this.f6451g, variantInfo.f6451g)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2;
            int i3;
            int i4;
            int i5 = ((this.f6446b * 31) + this.f6447c) * 31;
            String str = this.f6448d;
            int i6 = 0;
            if (str != null) {
                i2 = str.hashCode();
            } else {
                i2 = 0;
            }
            int i7 = (i5 + i2) * 31;
            String str2 = this.f6449e;
            if (str2 != null) {
                i3 = str2.hashCode();
            } else {
                i3 = 0;
            }
            int i8 = (i7 + i3) * 31;
            String str3 = this.f6450f;
            if (str3 != null) {
                i4 = str3.hashCode();
            } else {
                i4 = 0;
            }
            int i9 = (i8 + i4) * 31;
            String str4 = this.f6451g;
            if (str4 != null) {
                i6 = str4.hashCode();
            }
            return i9 + i6;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f6446b);
            parcel.writeInt(this.f6447c);
            parcel.writeString(this.f6448d);
            parcel.writeString(this.f6449e);
            parcel.writeString(this.f6450f);
            parcel.writeString(this.f6451g);
        }

        VariantInfo(Parcel parcel) {
            this.f6446b = parcel.readInt();
            this.f6447c = parcel.readInt();
            this.f6448d = parcel.readString();
            this.f6449e = parcel.readString();
            this.f6450f = parcel.readString();
            this.f6451g = parcel.readString();
        }
    }
}
