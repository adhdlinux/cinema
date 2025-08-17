package com.database.entitys;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;

public class MovieEntity implements Parcelable, Cloneable {
    public static final Parcelable.Creator<MovieEntity> CREATOR = new Parcelable.Creator<MovieEntity>() {
        /* renamed from: a */
        public MovieEntity createFromParcel(Parcel parcel) {
            return new MovieEntity(parcel);
        }

        /* renamed from: b */
        public MovieEntity[] newArray(int i2) {
            return new MovieEntity[i2];
        }
    };
    private String backdrop_path;
    private OffsetDateTime collected_at;
    @Deprecated
    private OffsetDateTime createdDate;
    private long duration;
    private List<String> genres;
    private int id;
    private String imdbIDStr;
    @Deprecated
    private Boolean isFavorite;
    private Boolean isTV;
    @Deprecated
    private Boolean isWatched;
    private String name;
    private int numberSeason;
    private String overview;
    private long position;
    private String poster_path;
    private String realeaseDate;
    private String subtitlepath = "";
    private long tmdbID;
    private long traktID;
    private long tvdbID;
    private Double vote = Double.valueOf(0.0d);
    private OffsetDateTime watched_at;

    public static class Converter {
        public static OffsetDateTime a(Long l2) {
            if (l2 == null) {
                return null;
            }
            return OffsetDateTime.ofInstant(Instant.ofEpochSecond(l2.longValue()), ZoneOffset.UTC);
        }

        public static String b(List<String> list) {
            if (list == null || list.size() <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String append : list) {
                sb.append(append);
                sb.append(",");
            }
            String sb2 = sb.toString();
            return sb2.substring(0, sb2.length() - 1);
        }

        public static List<String> c(String str) {
            return Arrays.asList(str.split(","));
        }
    }

    public MovieEntity() {
        Boolean bool = Boolean.FALSE;
        this.isFavorite = bool;
        this.isWatched = bool;
        this.isTV = bool;
    }

    public int describeContents() {
        return 0;
    }

    public String getBackdrop_path() {
        return this.backdrop_path;
    }

    public OffsetDateTime getCollected_at() {
        return this.collected_at;
    }

    @Deprecated
    public OffsetDateTime getCreatedDate() {
        return this.createdDate;
    }

    public long getDuration() {
        return this.duration;
    }

    @Deprecated
    public Boolean getFavorite() {
        return this.isFavorite;
    }

    public List<String> getGenres() {
        List<String> list = this.genres;
        if (list == null) {
            return new ArrayList();
        }
        return list;
    }

    public int getId() {
        return this.id;
    }

    public String getImdbIDStr() {
        return this.imdbIDStr;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberSeason() {
        return this.numberSeason;
    }

    public String getOverview() {
        return this.overview;
    }

    public long getPosition() {
        return this.position;
    }

    public String getPoster_path() {
        return this.poster_path;
    }

    public String getRealeaseDate() {
        return this.realeaseDate;
    }

    public String getSubtitlepath() {
        return this.subtitlepath;
    }

    public Boolean getTV() {
        return this.isTV;
    }

    public long getTmdbID() {
        return this.tmdbID;
    }

    public long getTraktID() {
        return this.traktID;
    }

    public long getTvdbID() {
        return this.tvdbID;
    }

    public Double getVote() {
        return this.vote;
    }

    @Deprecated
    public Boolean getWatched() {
        return this.isWatched;
    }

    public OffsetDateTime getWatched_at() {
        return this.watched_at;
    }

    public void setBackdrop_path(String str) {
        this.backdrop_path = str;
    }

    public void setCollected_at(OffsetDateTime offsetDateTime) {
        this.collected_at = offsetDateTime;
    }

    @Deprecated
    public void setCreatedDate(OffsetDateTime offsetDateTime) {
        this.createdDate = offsetDateTime;
    }

    public void setDuration(long j2) {
        this.duration = j2;
    }

    @Deprecated
    public void setFavorite(Boolean bool) {
        this.isFavorite = bool;
    }

    public void setGenres(List<String> list) {
        this.genres = list;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setImdbIDStr(String str) {
        this.imdbIDStr = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNumberSeason(int i2) {
        this.numberSeason = i2;
    }

    public void setOverview(String str) {
        this.overview = str;
    }

    public void setPosition(long j2) {
        this.position = j2;
    }

    public void setPoster_path(String str) {
        this.poster_path = str;
    }

    public void setRealeaseDate(String str) {
        this.realeaseDate = str;
    }

    public void setSubtitlepath(String str) {
        this.subtitlepath = str;
    }

    public void setTV(Boolean bool) {
        this.isTV = bool;
    }

    public void setTmdbID(long j2) {
        this.tmdbID = j2;
    }

    public void setTraktID(long j2) {
        this.traktID = j2;
    }

    public void setTvdbID(long j2) {
        this.tvdbID = j2;
    }

    public void setVote(Double d2) {
        this.vote = d2;
    }

    @Deprecated
    public void setWatched(Boolean bool) {
        this.isWatched = bool;
    }

    public void setWatched_at(OffsetDateTime offsetDateTime) {
        this.watched_at = offsetDateTime;
    }

    public String toString() {
        return "MovieEntity{id=" + this.id + ", tmdbID=" + this.tmdbID + ", imdbIDStr='" + this.imdbIDStr + '\'' + ", traktID=" + this.traktID + ", tvdbID=" + this.tvdbID + ", position=" + this.position + ", duration=" + this.duration + ", subtitlepath='" + this.subtitlepath + '\'' + ", poster_path='" + this.poster_path + '\'' + ", backdrop_path='" + this.backdrop_path + '\'' + ", name='" + this.name + '\'' + ", realeaseDate='" + this.realeaseDate + '\'' + ", overview='" + this.overview + '\'' + ", genres=" + this.genres + ", vote=" + this.vote + ", createdDate=" + this.createdDate + ", isFavorite=" + this.isFavorite + ", isTV=" + this.isTV + ", numberSeason=" + this.numberSeason + '}';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4;
        long j2;
        parcel.writeInt(this.id);
        parcel.writeLong(this.tmdbID);
        parcel.writeString(this.imdbIDStr);
        parcel.writeLong(this.traktID);
        parcel.writeLong(this.tvdbID);
        parcel.writeLong(this.position);
        parcel.writeLong(this.duration);
        parcel.writeString(this.subtitlepath);
        parcel.writeString(this.poster_path);
        parcel.writeString(this.backdrop_path);
        parcel.writeString(this.name);
        parcel.writeString(this.realeaseDate);
        parcel.writeString(this.overview);
        parcel.writeStringList(this.genres);
        int i5 = 0;
        if (this.vote == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(this.vote.doubleValue());
        }
        Boolean bool = this.isFavorite;
        if (bool == null) {
            i3 = 0;
        } else if (bool.booleanValue()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        parcel.writeByte((byte) i3);
        Boolean bool2 = this.isWatched;
        if (bool2 == null) {
            i4 = 0;
        } else if (bool2.booleanValue()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        parcel.writeByte((byte) i4);
        Boolean bool3 = this.isTV;
        if (bool3 != null) {
            if (bool3.booleanValue()) {
                i5 = 1;
            } else {
                i5 = 2;
            }
        }
        parcel.writeByte((byte) i5);
        parcel.writeInt(this.numberSeason);
        OffsetDateTime offsetDateTime = this.collected_at;
        long j3 = 0;
        if (offsetDateTime == null) {
            j2 = 0;
        } else {
            j2 = offsetDateTime.toEpochSecond();
        }
        parcel.writeLong(j2);
        OffsetDateTime offsetDateTime2 = this.watched_at;
        if (offsetDateTime2 != null) {
            j3 = offsetDateTime2.toEpochSecond();
        }
        parcel.writeLong(j3);
    }

    public MovieEntity clone() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        Parcel obtain2 = Parcel.obtain();
        obtain2.unmarshall(marshall, 0, marshall.length);
        obtain2.setDataPosition(0);
        return CREATOR.createFromParcel(obtain2);
    }

    protected MovieEntity(Parcel parcel) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        OffsetDateTime offsetDateTime;
        Boolean bool4 = Boolean.FALSE;
        this.isFavorite = bool4;
        this.isWatched = bool4;
        this.isTV = bool4;
        this.id = parcel.readInt();
        this.tmdbID = parcel.readLong();
        this.imdbIDStr = parcel.readString();
        this.traktID = parcel.readLong();
        this.tvdbID = parcel.readLong();
        this.position = parcel.readLong();
        this.duration = parcel.readLong();
        this.subtitlepath = parcel.readString();
        this.poster_path = parcel.readString();
        this.backdrop_path = parcel.readString();
        this.name = parcel.readString();
        this.realeaseDate = parcel.readString();
        this.overview = parcel.readString();
        this.genres = parcel.createStringArrayList();
        OffsetDateTime offsetDateTime2 = null;
        if (parcel.readByte() == 0) {
            this.vote = null;
        } else {
            this.vote = Double.valueOf(parcel.readDouble());
        }
        byte readByte = parcel.readByte();
        boolean z2 = false;
        if (readByte == 0) {
            bool = null;
        } else {
            bool = Boolean.valueOf(readByte == 1);
        }
        this.isFavorite = bool;
        byte readByte2 = parcel.readByte();
        if (readByte2 == 0) {
            bool2 = null;
        } else {
            bool2 = Boolean.valueOf(readByte2 == 1);
        }
        this.isWatched = bool2;
        byte readByte3 = parcel.readByte();
        if (readByte3 == 0) {
            bool3 = null;
        } else {
            bool3 = Boolean.valueOf(readByte3 == 1 ? true : z2);
        }
        this.isTV = bool3;
        this.numberSeason = parcel.readInt();
        long readLong = parcel.readLong();
        long readLong2 = parcel.readLong();
        if (readLong == 0) {
            offsetDateTime = null;
        } else {
            offsetDateTime = OffsetDateTime.ofInstant(Instant.ofEpochSecond(readLong, 0), ZoneOffset.UTC);
        }
        this.collected_at = offsetDateTime;
        this.watched_at = readLong2 != 0 ? OffsetDateTime.ofInstant(Instant.ofEpochSecond(readLong2, 0), ZoneOffset.UTC) : offsetDateTime2;
    }
}
