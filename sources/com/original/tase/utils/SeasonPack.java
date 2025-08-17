package com.original.tase.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.TitleHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeasonPack implements Parcelable {
    public static final Parcelable.Creator<SeasonPack> CREATOR = new Parcelable.Creator<SeasonPack>() {
        /* renamed from: a */
        public SeasonPack createFromParcel(Parcel parcel) {
            return new SeasonPack(parcel);
        }

        /* renamed from: b */
        public SeasonPack[] newArray(int i2) {
            return new SeasonPack[i2];
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static String f34053g = "(.*?)[._ -]([Ss]\\d+)[._ -][^EeSs]";

    /* renamed from: b  reason: collision with root package name */
    String f34054b;

    /* renamed from: c  reason: collision with root package name */
    String f34055c;

    /* renamed from: d  reason: collision with root package name */
    String f34056d;

    /* renamed from: e  reason: collision with root package name */
    String f34057e;

    /* renamed from: f  reason: collision with root package name */
    String f34058f;

    public SeasonPack(String str, String str2) {
        this.f34054b = str;
        this.f34056d = str2;
    }

    public static SeasonPack c(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.contains(" - ")) {
            str = str.replace(" - ", "-");
        }
        Matcher matcher = Pattern.compile(f34053g).matcher(str.replace(Regex.a(str, "([Ss]eason[. -]\\d+)", 1), "").replaceAll("([\\]\\[\\(\\)])", ""));
        if (matcher.find()) {
            return new SeasonPack(matcher.group(1), matcher.group(2));
        }
        return null;
    }

    public boolean b(MovieInfo movieInfo, String str) {
        String h2 = TitleHelper.h(this.f34054b.toLowerCase().replace(movieInfo.year, "") + this.f34056d.toLowerCase(), "");
        StringBuilder sb = new StringBuilder();
        sb.append(movieInfo.getName().toLowerCase());
        sb.append(str.toLowerCase());
        return h2.startsWith(TitleHelper.h(sb.toString(), ""));
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SeasonPack{title='" + this.f34054b + '\'' + ", season='" + this.f34056d + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f34054b);
        parcel.writeString(this.f34055c);
        parcel.writeString(this.f34056d);
        parcel.writeString(this.f34057e);
        parcel.writeString(this.f34058f);
    }

    protected SeasonPack(Parcel parcel) {
        this.f34054b = parcel.readString();
        this.f34055c = parcel.readString();
        this.f34056d = parcel.readString();
        this.f34057e = parcel.readString();
        this.f34058f = parcel.readString();
    }
}
