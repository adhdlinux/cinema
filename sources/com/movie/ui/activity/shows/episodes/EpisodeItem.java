package com.movie.ui.activity.shows.episodes;

import android.os.Parcel;
import android.os.Parcelable;
import com.movie.data.model.tmvdb.SeasonTMDB;
import com.original.tase.helper.DateTimeHelper;
import com.uwetrottmann.thetvdb.entities.Episode;

public class EpisodeItem implements Parcelable, Comparable<EpisodeItem> {
    public static final Parcelable.Creator<EpisodeItem> CREATOR = new Parcelable.Creator<EpisodeItem>() {
        /* renamed from: a */
        public EpisodeItem createFromParcel(Parcel parcel) {
            return new EpisodeItem(parcel);
        }

        /* renamed from: b */
        public EpisodeItem[] newArray(int i2) {
            return new EpisodeItem[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public Integer f32694b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f32695c;

    /* renamed from: d  reason: collision with root package name */
    public String f32696d;

    /* renamed from: e  reason: collision with root package name */
    public long f32697e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f32698f;

    /* renamed from: g  reason: collision with root package name */
    public String f32699g;

    /* renamed from: h  reason: collision with root package name */
    public String f32700h;

    /* renamed from: i  reason: collision with root package name */
    public String f32701i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f32702j;

    /* renamed from: k  reason: collision with root package name */
    public String f32703k;

    /* renamed from: l  reason: collision with root package name */
    public Integer f32704l;

    public EpisodeItem(SeasonTMDB.EpisodesBean episodesBean, boolean z2, int i2, String str) {
        this.f32694b = Integer.valueOf(episodesBean.getEpisode_number());
        this.f32699g = episodesBean.getStill_path();
        this.f32695c = Boolean.valueOf(z2);
        this.f32698f = Integer.valueOf(i2);
        this.f32700h = episodesBean.getOverview();
        this.f32696d = episodesBean.getName();
        this.f32701i = episodesBean.getAir_date();
        this.f32702j = DateTimeHelper.f(DateTimeHelper.i(episodesBean.getAir_date()));
        this.f32703k = str;
    }

    /* renamed from: b */
    public int compareTo(EpisodeItem episodeItem) {
        return this.f32694b.intValue() > episodeItem.f32694b.intValue() ? 1 : -1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        if (this.f32694b == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.f32694b.intValue());
        }
        Boolean bool = this.f32695c;
        if (bool == null) {
            i3 = 0;
        } else if (bool.booleanValue()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.f32696d);
        if (this.f32698f == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.f32698f.intValue());
        }
        parcel.writeString(this.f32699g);
        parcel.writeString(this.f32700h);
        parcel.writeString(this.f32701i);
        parcel.writeByte(this.f32702j ? (byte) 1 : 0);
        parcel.writeString(this.f32703k);
        if (this.f32704l == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeInt(this.f32704l.intValue());
    }

    public EpisodeItem(Episode episode, boolean z2, int i2, String str) {
        this.f32694b = episode.airedEpisodeNumber;
        this.f32699g = "http://thetvdb.com/banners/" + episode.filename;
        this.f32695c = Boolean.valueOf(z2);
        this.f32698f = Integer.valueOf(i2);
        this.f32700h = episode.overview;
        this.f32696d = episode.episodeName;
        String str2 = episode.firstAired;
        this.f32701i = str2;
        this.f32702j = DateTimeHelper.f(DateTimeHelper.i(str2));
        this.f32703k = str;
    }

    public EpisodeItem(Integer num, Boolean bool, String str, Integer num2, String str2, String str3, boolean z2, String str4, Integer num3, String str5) {
        this.f32694b = num;
        this.f32695c = bool;
        this.f32696d = str;
        this.f32698f = num2;
        this.f32699g = str2;
        this.f32700h = str3;
        this.f32702j = z2;
        this.f32703k = str4;
        this.f32704l = num3;
        this.f32701i = str5;
    }

    protected EpisodeItem(Parcel parcel) {
        Boolean bool;
        if (parcel.readByte() == 0) {
            this.f32694b = null;
        } else {
            this.f32694b = Integer.valueOf(parcel.readInt());
        }
        byte readByte = parcel.readByte();
        boolean z2 = false;
        if (readByte == 0) {
            bool = null;
        } else {
            bool = Boolean.valueOf(readByte == 1);
        }
        this.f32695c = bool;
        this.f32696d = parcel.readString();
        if (parcel.readByte() == 0) {
            this.f32698f = null;
        } else {
            this.f32698f = Integer.valueOf(parcel.readInt());
        }
        this.f32699g = parcel.readString();
        this.f32700h = parcel.readString();
        this.f32701i = parcel.readString();
        this.f32702j = parcel.readByte() != 0 ? true : z2;
        this.f32703k = parcel.readString();
        if (parcel.readByte() == 0) {
            this.f32704l = null;
        } else {
            this.f32704l = Integer.valueOf(parcel.readInt());
        }
    }
}
