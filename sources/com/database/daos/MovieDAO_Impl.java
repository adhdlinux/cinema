package com.database.daos;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.database.entitys.MovieEntity;
import com.facebook.react.uimanager.ViewProps;
import d0.a;
import java.util.ArrayList;
import java.util.List;

public final class MovieDAO_Impl implements MovieDAO {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f19226a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedSQLiteStatement f19227b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f19228c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f19229d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedSQLiteStatement f19230e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f19231f;

    /* renamed from: g  reason: collision with root package name */
    private final SharedSQLiteStatement f19232g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedSQLiteStatement f19233h;

    /* renamed from: i  reason: collision with root package name */
    private final SharedSQLiteStatement f19234i;

    /* renamed from: j  reason: collision with root package name */
    private final SharedSQLiteStatement f19235j;

    /* renamed from: k  reason: collision with root package name */
    private final SharedSQLiteStatement f19236k;

    public MovieDAO_Impl(RoomDatabase roomDatabase) {
        this.f19226a = roomDatabase;
        this.f19227b = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "INSERT INTO MovieEntity(tmdbID,imdbIDStr,traktID,tvdbID,position,duration,subtitlepath,poster_path,backdrop_path,name,realeaseDate,overview,genres,vote,createdDate,isFavorite,isWatched,isTV,numberSeason, collected_at, watched_at) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?, ?)";
            }
        };
        this.f19228c = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE MovieEntity SET tmdbID=?, imdbIDStr=?, traktID=?, tvdbID=?, position= CASE WHEN ? > 0 THEN ? ELSE position END, duration=?,subtitlepath=?,poster_path=?,backdrop_path=?,name=?,realeaseDate=?,overview=?,genres=?,vote=?,createdDate=?,isFavorite=?, isWatched=?, isTV=?, numberSeason=?,collected_at= CASE WHEN ? IS NOT NULL THEN ? ELSE collected_at END, watched_at= CASE WHEN ? IS NOT NULL THEN ? ELSE watched_at END WHERE ((tmdbID > 0 AND tmdbID=?) OR (imdbIDStr IS NOT NULL AND imdbIDStr=? ) OR (traktID >0 AND traktID=?) OR (tvdbID > 0 AND tvdbID=?))";
            }
        };
        this.f19229d = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM MovieEntity WHERE ((tmdbID > 0 AND tmdbID=?) OR (imdbIDStr IS NOT NULL AND imdbIDStr=? ) OR (traktID >0 AND traktID=?) OR (tvdbID > 0 AND tvdbID=?))";
            }
        };
        this.f19230e = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE MovieEntity SET numberSeason=? WHERE ((tmdbID > 0 AND tmdbID=?) OR (imdbIDStr IS NOT NULL AND imdbIDStr=? ) OR (traktID >0 AND traktID=?) OR (tvdbID > 0 AND tvdbID=?))";
            }
        };
        this.f19231f = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE MovieEntity SET position=?,subtitlepath=? WHERE ((tmdbID > 0 AND tmdbID=?) OR (imdbIDStr IS NOT NULL AND imdbIDStr=? ) OR (traktID >0 AND traktID=?) OR (tvdbID > 0 AND tvdbID=?))";
            }
        };
        this.f19232g = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM MovieEntity";
            }
        };
        this.f19233h = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE MovieEntity SET collected_at = NULL";
            }
        };
        this.f19234i = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE MovieEntity SET watched_at = NULL";
            }
        };
        this.f19235j = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE MovieEntity SET collected_at=? WHERE ((tmdbID > 0 AND tmdbID=?) OR (imdbIDStr IS NOT NULL AND imdbIDStr=? ) OR (traktID >0 AND traktID=?) OR (tvdbID > 0 AND tvdbID=?)) ";
            }
        };
        this.f19236k = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE MovieEntity SET watched_at=? WHERE ((tmdbID > 0 AND tmdbID=?) OR (imdbIDStr IS NOT NULL AND imdbIDStr=? ) OR (traktID >0 AND traktID=?) OR (tvdbID > 0 AND tvdbID=?)) ";
            }
        };
    }

    private MovieEntity t(Cursor cursor) {
        Long l2;
        Integer num;
        Boolean bool;
        Integer num2;
        Boolean bool2;
        boolean z2;
        Integer num3;
        Boolean bool3;
        boolean z3;
        Long l3;
        Double d2;
        Cursor cursor2 = cursor;
        int columnIndex = cursor2.getColumnIndex("id");
        int columnIndex2 = cursor2.getColumnIndex("tmdbID");
        int columnIndex3 = cursor2.getColumnIndex("imdbIDStr");
        int columnIndex4 = cursor2.getColumnIndex("traktID");
        int columnIndex5 = cursor2.getColumnIndex("tvdbID");
        int columnIndex6 = cursor2.getColumnIndex(ViewProps.POSITION);
        int columnIndex7 = cursor2.getColumnIndex("duration");
        int columnIndex8 = cursor2.getColumnIndex("subtitlepath");
        int columnIndex9 = cursor2.getColumnIndex("poster_path");
        int columnIndex10 = cursor2.getColumnIndex("backdrop_path");
        int columnIndex11 = cursor2.getColumnIndex("name");
        int columnIndex12 = cursor2.getColumnIndex("realeaseDate");
        int columnIndex13 = cursor2.getColumnIndex("overview");
        int columnIndex14 = cursor2.getColumnIndex("genres");
        int columnIndex15 = cursor2.getColumnIndex("vote");
        int columnIndex16 = cursor2.getColumnIndex("createdDate");
        int columnIndex17 = cursor2.getColumnIndex("isFavorite");
        int columnIndex18 = cursor2.getColumnIndex("isWatched");
        int columnIndex19 = cursor2.getColumnIndex("isTV");
        int columnIndex20 = cursor2.getColumnIndex("numberSeason");
        int columnIndex21 = cursor2.getColumnIndex("collected_at");
        int columnIndex22 = cursor2.getColumnIndex("watched_at");
        MovieEntity movieEntity = new MovieEntity();
        int i2 = columnIndex14;
        if (columnIndex != -1) {
            movieEntity.setId(cursor2.getInt(columnIndex));
        }
        if (columnIndex2 != -1) {
            movieEntity.setTmdbID(cursor2.getLong(columnIndex2));
        }
        if (columnIndex3 != -1) {
            movieEntity.setImdbIDStr(cursor2.getString(columnIndex3));
        }
        if (columnIndex4 != -1) {
            movieEntity.setTraktID(cursor2.getLong(columnIndex4));
        }
        if (columnIndex5 != -1) {
            movieEntity.setTvdbID(cursor2.getLong(columnIndex5));
        }
        if (columnIndex6 != -1) {
            movieEntity.setPosition(cursor2.getLong(columnIndex6));
        }
        if (columnIndex7 != -1) {
            movieEntity.setDuration(cursor2.getLong(columnIndex7));
        }
        if (columnIndex8 != -1) {
            movieEntity.setSubtitlepath(cursor2.getString(columnIndex8));
        }
        if (columnIndex9 != -1) {
            movieEntity.setPoster_path(cursor2.getString(columnIndex9));
        }
        if (columnIndex10 != -1) {
            movieEntity.setBackdrop_path(cursor2.getString(columnIndex10));
        }
        if (columnIndex11 != -1) {
            movieEntity.setName(cursor2.getString(columnIndex11));
        }
        if (columnIndex12 != -1) {
            movieEntity.setRealeaseDate(cursor2.getString(columnIndex12));
        }
        if (columnIndex13 != -1) {
            movieEntity.setOverview(cursor2.getString(columnIndex13));
        }
        int i3 = i2;
        if (i3 != -1) {
            movieEntity.setGenres(MovieEntity.Converter.c(cursor2.getString(i3)));
        }
        Long l4 = null;
        int i4 = columnIndex15;
        if (i4 != -1) {
            if (cursor2.isNull(i4)) {
                d2 = null;
            } else {
                d2 = Double.valueOf(cursor2.getDouble(i4));
            }
            movieEntity.setVote(d2);
        }
        int i5 = columnIndex16;
        if (i5 != -1) {
            if (cursor2.isNull(i5)) {
                l3 = null;
            } else {
                l3 = Long.valueOf(cursor2.getLong(i5));
            }
            movieEntity.setCreatedDate(MovieEntity.Converter.a(l3));
        }
        boolean z4 = true;
        int i6 = columnIndex17;
        if (i6 != -1) {
            if (cursor2.isNull(i6)) {
                num3 = null;
            } else {
                num3 = Integer.valueOf(cursor2.getInt(i6));
            }
            if (num3 == null) {
                bool3 = null;
            } else {
                if (num3.intValue() != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                bool3 = Boolean.valueOf(z3);
            }
            movieEntity.setFavorite(bool3);
        }
        int i7 = columnIndex18;
        if (i7 != -1) {
            if (cursor2.isNull(i7)) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(cursor2.getInt(i7));
            }
            if (num2 == null) {
                bool2 = null;
            } else {
                if (num2.intValue() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                bool2 = Boolean.valueOf(z2);
            }
            movieEntity.setWatched(bool2);
        }
        int i8 = columnIndex19;
        if (i8 != -1) {
            if (cursor2.isNull(i8)) {
                num = null;
            } else {
                num = Integer.valueOf(cursor2.getInt(i8));
            }
            if (num == null) {
                bool = null;
            } else {
                if (num.intValue() == 0) {
                    z4 = false;
                }
                bool = Boolean.valueOf(z4);
            }
            movieEntity.setTV(bool);
        }
        int i9 = columnIndex20;
        if (i9 != -1) {
            movieEntity.setNumberSeason(cursor2.getInt(i9));
        }
        int i10 = columnIndex21;
        if (i10 != -1) {
            if (cursor2.isNull(i10)) {
                l2 = null;
            } else {
                l2 = Long.valueOf(cursor2.getLong(i10));
            }
            movieEntity.setCollected_at(MovieEntity.Converter.a(l2));
        }
        int i11 = columnIndex22;
        if (i11 != -1) {
            if (!cursor2.isNull(i11)) {
                l4 = Long.valueOf(cursor2.getLong(i11));
            }
            movieEntity.setWatched_at(MovieEntity.Converter.a(l4));
        }
        return movieEntity;
    }

    public int a() {
        this.f19226a.b();
        SupportSQLiteStatement a2 = this.f19232g.a();
        this.f19226a.c();
        try {
            int j2 = a2.j();
            this.f19226a.t();
            return j2;
        } finally {
            this.f19226a.g();
            this.f19232g.f(a2);
        }
    }

    public /* synthetic */ void b(MovieEntity... movieEntityArr) {
        a.b(this, movieEntityArr);
    }

    public List<MovieEntity> c(Boolean bool, int i2) {
        Integer num;
        RoomSQLiteQuery i3 = RoomSQLiteQuery.i("SELECT * FROM MovieEntity WHERE watched_at IS NOT NULL AND isTV=? ORDER BY watched_at DESC LIMIT ?", 2);
        if (bool == null) {
            num = null;
        } else {
            num = Integer.valueOf(bool.booleanValue() ? 1 : 0);
        }
        if (num == null) {
            i3.d0(1);
        } else {
            i3.X(1, (long) num.intValue());
        }
        i3.X(2, (long) i2);
        this.f19226a.b();
        Cursor b2 = DBUtil.b(this.f19226a, i3, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(t(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i3.release();
        }
    }

    public List<MovieEntity> d(Boolean bool) {
        Integer num;
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT * FROM MovieEntity WHERE watched_at IS NOT NULL AND isTV=? ORDER BY watched_at DESC", 1);
        if (bool == null) {
            num = null;
        } else {
            num = Integer.valueOf(bool.booleanValue() ? 1 : 0);
        }
        if (num == null) {
            i2.d0(1);
        } else {
            i2.X(1, (long) num.intValue());
        }
        this.f19226a.b();
        Cursor b2 = DBUtil.b(this.f19226a, i2, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(t(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i2.release();
        }
    }

    public List<MovieEntity> e() {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT * FROM MovieEntity WHERE watched_at IS NOT NULL ORDER BY watched_at DESC", 0);
        this.f19226a.b();
        Cursor b2 = DBUtil.b(this.f19226a, i2, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(t(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i2.release();
        }
    }

    public int f() {
        this.f19226a.b();
        SupportSQLiteStatement a2 = this.f19233h.a();
        this.f19226a.c();
        try {
            int j2 = a2.j();
            this.f19226a.t();
            return j2;
        } finally {
            this.f19226a.g();
            this.f19233h.f(a2);
        }
    }

    public /* synthetic */ int g(MovieEntity... movieEntityArr) {
        return a.a(this, movieEntityArr);
    }

    public MovieEntity h(int i2) {
        MovieEntity movieEntity;
        RoomSQLiteQuery i3 = RoomSQLiteQuery.i("SELECT * FROM MovieEntity WHERE id = ?", 1);
        i3.X(1, (long) i2);
        this.f19226a.b();
        Cursor b2 = DBUtil.b(this.f19226a, i3, false);
        try {
            if (b2.moveToFirst()) {
                movieEntity = t(b2);
            } else {
                movieEntity = null;
            }
            return movieEntity;
        } finally {
            b2.close();
            i3.release();
        }
    }

    public void i(int i2, long j2, String str, long j3, long j4) {
        this.f19226a.b();
        SupportSQLiteStatement a2 = this.f19230e.a();
        a2.X(1, (long) i2);
        a2.X(2, j2);
        if (str == null) {
            a2.d0(3);
        } else {
            a2.R(3, str);
        }
        a2.X(4, j3);
        a2.X(5, j4);
        this.f19226a.c();
        try {
            a2.j();
            this.f19226a.t();
        } finally {
            this.f19226a.g();
            this.f19230e.f(a2);
        }
    }

    public List<MovieEntity> j(boolean z2) {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT * FROM MovieEntity WHERE isTV=? AND collected_at IS NOT NULL ORDER BY collected_at DESC", 1);
        i2.X(1, z2 ? 1 : 0);
        this.f19226a.b();
        Cursor b2 = DBUtil.b(this.f19226a, i2, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(t(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i2.release();
        }
    }

    public void k(Long l2, long j2, String str, long j3, long j4) {
        this.f19226a.b();
        SupportSQLiteStatement a2 = this.f19235j.a();
        if (l2 == null) {
            a2.d0(1);
        } else {
            a2.X(1, l2.longValue());
        }
        a2.X(2, j2);
        if (str == null) {
            a2.d0(3);
        } else {
            a2.R(3, str);
        }
        a2.X(4, j3);
        a2.X(5, j4);
        this.f19226a.c();
        try {
            a2.j();
            this.f19226a.t();
        } finally {
            this.f19226a.g();
            this.f19235j.f(a2);
        }
    }

    public MovieEntity l(long j2, String str, long j3, long j4) {
        MovieEntity movieEntity;
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT * FROM MovieEntity WHERE ((tmdbID > 0 AND tmdbID=?) OR (imdbIDStr IS NOT NULL AND imdbIDStr=? ) OR (traktID >0 AND traktID=?) OR (tvdbID > 0 AND tvdbID=?))", 4);
        i2.X(1, j2);
        if (str == null) {
            i2.d0(2);
        } else {
            i2.R(2, str);
        }
        i2.X(3, j3);
        i2.X(4, j4);
        this.f19226a.b();
        Cursor b2 = DBUtil.b(this.f19226a, i2, false);
        try {
            if (b2.moveToFirst()) {
                movieEntity = t(b2);
            } else {
                movieEntity = null;
            }
            return movieEntity;
        } finally {
            b2.close();
            i2.release();
        }
    }

    public int m(long j2, String str, long j3, long j4) {
        this.f19226a.b();
        SupportSQLiteStatement a2 = this.f19229d.a();
        a2.X(1, j2);
        if (str == null) {
            a2.d0(2);
        } else {
            a2.R(2, str);
        }
        a2.X(3, j3);
        a2.X(4, j4);
        this.f19226a.c();
        try {
            int j5 = a2.j();
            this.f19226a.t();
            return j5;
        } finally {
            this.f19226a.g();
            this.f19229d.f(a2);
        }
    }

    public List<MovieEntity> n() {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT * FROM MovieEntity WHERE collected_at IS NOT NULL ORDER BY collected_at DESC", 0);
        this.f19226a.b();
        Cursor b2 = DBUtil.b(this.f19226a, i2, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(t(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i2.release();
        }
    }

    public int o() {
        this.f19226a.b();
        SupportSQLiteStatement a2 = this.f19234i.a();
        this.f19226a.c();
        try {
            int j2 = a2.j();
            this.f19226a.t();
            return j2;
        } finally {
            this.f19226a.g();
            this.f19234i.f(a2);
        }
    }

    public void p(Long l2, long j2, String str, long j3, long j4) {
        this.f19226a.b();
        SupportSQLiteStatement a2 = this.f19236k.a();
        if (l2 == null) {
            a2.d0(1);
        } else {
            a2.X(1, l2.longValue());
        }
        a2.X(2, j2);
        if (str == null) {
            a2.d0(3);
        } else {
            a2.R(3, str);
        }
        a2.X(4, j3);
        a2.X(5, j4);
        this.f19226a.c();
        try {
            a2.j();
            this.f19226a.t();
        } finally {
            this.f19226a.g();
            this.f19236k.f(a2);
        }
    }

    public int q(long j2, String str, long j3, long j4, long j5, long j6, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Double d2, Long l2, Boolean bool, Boolean bool2, Boolean bool3, int i2, Long l3, Long l4) {
        Integer num;
        Integer num2;
        long j7 = j2;
        String str9 = str;
        long j8 = j3;
        long j9 = j4;
        long j10 = j5;
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        String str14 = str6;
        String str15 = str7;
        this.f19226a.b();
        SupportSQLiteStatement a2 = this.f19228c.a();
        a2.X(1, j7);
        if (str9 == null) {
            a2.d0(2);
        } else {
            a2.R(2, str9);
        }
        a2.X(3, j8);
        a2.X(4, j9);
        a2.X(5, j10);
        a2.X(6, j10);
        a2.X(7, j6);
        if (str10 == null) {
            a2.d0(8);
        } else {
            a2.R(8, str10);
        }
        if (str11 == null) {
            a2.d0(9);
        } else {
            a2.R(9, str11);
        }
        if (str12 == null) {
            a2.d0(10);
        } else {
            a2.R(10, str12);
        }
        if (str13 == null) {
            a2.d0(11);
        } else {
            a2.R(11, str13);
        }
        if (str14 == null) {
            a2.d0(12);
        } else {
            a2.R(12, str14);
        }
        String str16 = str7;
        if (str16 == null) {
            a2.d0(13);
        } else {
            a2.R(13, str16);
        }
        String str17 = str8;
        if (str17 == null) {
            a2.d0(14);
        } else {
            a2.R(14, str17);
        }
        if (d2 == null) {
            a2.d0(15);
        } else {
            a2.l(15, d2.doubleValue());
        }
        if (l2 == null) {
            a2.d0(16);
        } else {
            a2.X(16, l2.longValue());
        }
        Integer num3 = null;
        if (bool == null) {
            num = null;
        } else {
            num = Integer.valueOf(bool.booleanValue() ? 1 : 0);
        }
        if (num == null) {
            a2.d0(17);
        } else {
            a2.X(17, (long) num.intValue());
        }
        if (bool2 == null) {
            num2 = null;
        } else {
            num2 = Integer.valueOf(bool2.booleanValue() ? 1 : 0);
        }
        if (num2 == null) {
            a2.d0(18);
        } else {
            a2.X(18, (long) num2.intValue());
        }
        if (bool3 != null) {
            num3 = Integer.valueOf(bool3.booleanValue() ? 1 : 0);
        }
        if (num3 == null) {
            a2.d0(19);
        } else {
            a2.X(19, (long) num3.intValue());
        }
        a2.X(20, (long) i2);
        if (l3 == null) {
            a2.d0(21);
        } else {
            a2.X(21, l3.longValue());
        }
        if (l3 == null) {
            a2.d0(22);
        } else {
            a2.X(22, l3.longValue());
        }
        if (l4 == null) {
            a2.d0(23);
        } else {
            a2.X(23, l4.longValue());
        }
        if (l4 == null) {
            a2.d0(24);
        } else {
            a2.X(24, l4.longValue());
        }
        a2.X(25, j7);
        if (str9 == null) {
            a2.d0(26);
        } else {
            a2.R(26, str9);
        }
        a2.X(27, j8);
        a2.X(28, j9);
        this.f19226a.c();
        try {
            int j11 = a2.j();
            this.f19226a.t();
            return j11;
        } finally {
            this.f19226a.g();
            this.f19228c.f(a2);
        }
    }

    public List<MovieEntity> r(int i2) {
        RoomSQLiteQuery i3 = RoomSQLiteQuery.i("SELECT * FROM MovieEntity WHERE watched_at IS NOT NULL ORDER BY watched_at DESC LIMIT ?", 1);
        i3.X(1, (long) i2);
        this.f19226a.b();
        Cursor b2 = DBUtil.b(this.f19226a, i3, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(t(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i3.release();
        }
    }

    public long s(long j2, String str, long j3, long j4, long j5, long j6, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Double d2, Long l2, Boolean bool, Boolean bool2, Boolean bool3, int i2, Long l3, Long l4) {
        Integer num;
        Integer num2;
        String str9 = str;
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        String str14 = str6;
        String str15 = str7;
        String str16 = str8;
        this.f19226a.b();
        SupportSQLiteStatement a2 = this.f19227b.a();
        long j7 = j2;
        a2.X(1, j2);
        if (str9 == null) {
            a2.d0(2);
        } else {
            a2.R(2, str9);
        }
        a2.X(3, j3);
        a2.X(4, j4);
        a2.X(5, j5);
        a2.X(6, j6);
        if (str10 == null) {
            a2.d0(7);
        } else {
            a2.R(7, str10);
        }
        if (str11 == null) {
            a2.d0(8);
        } else {
            a2.R(8, str11);
        }
        if (str12 == null) {
            a2.d0(9);
        } else {
            a2.R(9, str12);
        }
        if (str13 == null) {
            a2.d0(10);
        } else {
            a2.R(10, str13);
        }
        if (str14 == null) {
            a2.d0(11);
        } else {
            a2.R(11, str14);
        }
        if (str15 == null) {
            a2.d0(12);
        } else {
            a2.R(12, str15);
        }
        if (str16 == null) {
            a2.d0(13);
        } else {
            a2.R(13, str16);
        }
        if (d2 == null) {
            a2.d0(14);
        } else {
            a2.l(14, d2.doubleValue());
        }
        if (l2 == null) {
            a2.d0(15);
        } else {
            a2.X(15, l2.longValue());
        }
        Integer num3 = null;
        if (bool == null) {
            num = null;
        } else {
            num = Integer.valueOf(bool.booleanValue() ? 1 : 0);
        }
        if (num == null) {
            a2.d0(16);
        } else {
            a2.X(16, (long) num.intValue());
        }
        if (bool2 == null) {
            num2 = null;
        } else {
            num2 = Integer.valueOf(bool2.booleanValue() ? 1 : 0);
        }
        if (num2 == null) {
            a2.d0(17);
        } else {
            a2.X(17, (long) num2.intValue());
        }
        if (bool3 != null) {
            num3 = Integer.valueOf(bool3.booleanValue() ? 1 : 0);
        }
        if (num3 == null) {
            a2.d0(18);
        } else {
            a2.X(18, (long) num3.intValue());
        }
        a2.X(19, (long) i2);
        if (l3 == null) {
            a2.d0(20);
        } else {
            a2.X(20, l3.longValue());
        }
        if (l4 == null) {
            a2.d0(21);
        } else {
            a2.X(21, l4.longValue());
        }
        this.f19226a.c();
        try {
            long P = a2.P();
            this.f19226a.t();
            return P;
        } finally {
            this.f19226a.g();
            this.f19227b.f(a2);
        }
    }
}
