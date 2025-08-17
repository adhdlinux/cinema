package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;
import com.google.android.exoplayer2.util.Util;

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
    public final String f25386b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25387c;

    public VorbisComment(String str, String str2) {
        this.f25386b = str;
        this.f25387c = str2;
    }

    public /* synthetic */ Format D() {
        return a.b(this);
    }

    public /* synthetic */ byte[] E() {
        return a.a(this);
    }

    public void a(MediaMetadata.Builder builder) {
        String str = this.f25386b;
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
                builder.N(this.f25387c);
                return;
            case 1:
                builder.m0(this.f25387c);
                return;
            case 2:
                builder.U(this.f25387c);
                return;
            case 3:
                builder.M(this.f25387c);
                return;
            case 4:
                builder.O(this.f25387c);
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
        if (!this.f25386b.equals(vorbisComment.f25386b) || !this.f25387c.equals(vorbisComment.f25387c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f25386b.hashCode()) * 31) + this.f25387c.hashCode();
    }

    public String toString() {
        return "VC: " + this.f25386b + "=" + this.f25387c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f25386b);
        parcel.writeString(this.f25387c);
    }

    protected VorbisComment(Parcel parcel) {
        this.f25386b = (String) Util.j(parcel.readString());
        this.f25387c = (String) Util.j(parcel.readString());
    }
}
