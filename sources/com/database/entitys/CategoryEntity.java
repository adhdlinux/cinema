package com.database.entitys;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

public class CategoryEntity implements Parcelable {
    public static final Parcelable.Creator<CategoryEntity> CREATOR = new Parcelable.Creator<CategoryEntity>() {
        /* renamed from: a */
        public CategoryEntity createFromParcel(Parcel parcel) {
            return new CategoryEntity(parcel);
        }

        /* renamed from: b */
        public CategoryEntity[] newArray(int i2) {
            return new CategoryEntity[i2];
        }
    };
    public Map<String, String> extras;
    Integer id;
    Boolean isRestricted;
    String name;
    Source source;
    SourceType sourceType;
    Type type;

    public enum Generic {
        Popular(-100),
        Trending(-99),
        NowPLaying(-98),
        Upcomming(-97),
        TopRated(-96),
        AiringToday(-95),
        OnTv(-94),
        Recommmended(-93),
        Watched(-92),
        Collected(-91),
        Anticipated(-90),
        BoxOffice(-89),
        Latest(-88);
        

        /* renamed from: b  reason: collision with root package name */
        private Integer f19284b;

        private Generic(Integer num) {
            this.f19284b = num;
        }

        public int getValue() {
            return this.f19284b.intValue();
        }
    }

    public enum Source {
        TMDB(0),
        TRAKT(1),
        TVDB(2),
        IMDB(3),
        LOCAL(4);
        

        /* renamed from: b  reason: collision with root package name */
        private final int f19286b;

        private Source(int i2) {
            this.f19286b = i2;
        }

        public int getValue() {
            return this.f19286b;
        }
    }

    public static class SourceConverter {
        public static int a(Source source) {
            return source.getValue();
        }

        public static Source b(int i2) {
            return Source.values()[i2];
        }
    }

    public enum SourceType {
        Genre(0),
        FeatureList(1),
        Generic(2),
        Search(3),
        Details(4),
        Related(4),
        UserList(5);
        

        /* renamed from: b  reason: collision with root package name */
        private Integer f19288b;

        private SourceType(Integer num) {
            this.f19288b = num;
        }

        public int getValue() {
            return this.f19288b.intValue();
        }
    }

    public static class SourceTypeConverter {
        public static int a(SourceType sourceType) {
            return sourceType.getValue();
        }

        public static SourceType b(int i2) {
            return SourceType.values()[i2];
        }
    }

    public enum Type {
        Movie(0),
        Show(1),
        Episode(2),
        MIX(3);
        

        /* renamed from: b  reason: collision with root package name */
        private Integer f19290b;

        private Type(Integer num) {
            this.f19290b = num;
        }

        public int getValue() {
            return this.f19290b.intValue();
        }
    }

    public static class TypeEntityConverter {
        public static int a(Type type) {
            return type.getValue();
        }

        public static Type b(int i2) {
            return Type.values()[i2];
        }
    }

    public CategoryEntity(Source source2, Type type2, Integer num, SourceType sourceType2, String str) {
        this.isRestricted = Boolean.FALSE;
        this.source = source2;
        this.type = type2;
        this.id = num;
        this.sourceType = sourceType2;
        this.name = str;
    }

    public int describeContents() {
        return 0;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getRestricted() {
        return this.isRestricted;
    }

    public Source getSource() {
        return this.source;
    }

    public SourceType getSourceType() {
        return this.sourceType;
    }

    public Type getType() {
        return this.type;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRestricted(Boolean bool) {
        this.isRestricted = bool;
    }

    public void setSource(Source source2) {
        this.source = source2;
    }

    public void setSourceType(SourceType sourceType2) {
        this.sourceType = sourceType2;
    }

    public void setType(Type type2) {
        this.type = type2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3 = 0;
        if (this.id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.id.intValue());
        }
        parcel.writeString(this.name);
        Boolean bool = this.isRestricted;
        if (bool != null) {
            if (bool.booleanValue()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
        }
        parcel.writeByte((byte) i3);
    }

    protected CategoryEntity(Parcel parcel) {
        boolean z2 = false;
        this.id = 0;
        this.isRestricted = Boolean.FALSE;
        Boolean bool = null;
        if (parcel.readByte() == 0) {
            this.id = null;
        } else {
            this.id = Integer.valueOf(parcel.readInt());
        }
        this.name = parcel.readString();
        byte readByte = parcel.readByte();
        if (readByte != 0) {
            bool = Boolean.valueOf(readByte == 1 ? true : z2);
        }
        this.isRestricted = bool;
    }
}
