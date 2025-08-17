package androidx.media3.extractor.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
import androidx.media3.common.util.Util;
import com.google.common.base.Ascii;

@Deprecated
public class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new Parcelable.Creator<VorbisComment>() {
        /* renamed from: a */
        public VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }

        /* renamed from: b */
        public VorbisComment[] newArray(int i2) {
            return new VorbisComment[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final String f8286b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8287c;

    public VorbisComment(String str, String str2) {
        this.f8286b = Ascii.f(str);
        this.f8287c = str2;
    }

    public /* synthetic */ Format D() {
        return d.b(this);
    }

    public /* synthetic */ byte[] E() {
        return d.a(this);
    }

    public void H(MediaMetadata.Builder builder) {
        String str = this.f8286b;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 62359119:
                if (str.equals("ALBUM")) {
                    c2 = 0;
                    break;
                }
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    c2 = 1;
                    break;
                }
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                builder.O(this.f8287c);
                return;
            case 1:
                builder.o0(this.f8287c);
                return;
            case 2:
                builder.V(this.f8287c);
                return;
            case 3:
                builder.N(this.f8287c);
                return;
            case 4:
                builder.P(this.f8287c);
                return;
            default:
                return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        if (!this.f8286b.equals(vorbisComment.f8286b) || !this.f8287c.equals(vorbisComment.f8287c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f8286b.hashCode()) * 31) + this.f8287c.hashCode();
    }

    public String toString() {
        return "VC: " + this.f8286b + "=" + this.f8287c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8286b);
        parcel.writeString(this.f8287c);
    }

    protected VorbisComment(Parcel parcel) {
        this.f8286b = (String) Util.i(parcel.readString());
        this.f8287c = (String) Util.i(parcel.readString());
    }
}
