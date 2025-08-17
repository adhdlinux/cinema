package com.database.daos;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.database.entitys.MovieEntity;
import com.database.entitys.TvWatchedEpisode;
import com.facebook.react.uimanager.ViewProps;
import d0.b;
import java.util.ArrayList;
import java.util.List;

public final class TvWatchedEpisodeDAO_Impl implements TvWatchedEpisodeDAO {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f19247a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedSQLiteStatement f19248b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f19249c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f19250d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedSQLiteStatement f19251e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f19252f;

    public TvWatchedEpisodeDAO_Impl(RoomDatabase roomDatabase) {
        this.f19247a = roomDatabase;
        this.f19248b = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "INSERT INTO TvWatchedEpisode(tmdbID,imdbIDStr,tvdbID,traktID,season,episode,position,duration,subtitlepath) VALUES(?,?,?,?,?,?,?,?,?)";
            }
        };
        this.f19249c = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE TvWatchedEpisode SET tmdbID =?, imdbIDStr=?,tvdbID=?, traktID=?,season=?,episode=?,position=?,duration=?,subtitlepath=? WHERE ((tmdbID > 0 AND tmdbID=?) OR (imdbIDStr IS NOT NULL AND imdbIDStr=? ) OR (traktID >0 AND traktID=?) OR (tvdbID > 0 AND tvdbID=?)) AND season=? AND episode=?";
            }
        };
        this.f19250d = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM TvWatchedEpisode WHERE ((tmdbID > 0 AND tmdbID=?) OR (imdbIDStr IS NOT NULL AND imdbIDStr=? ) OR (traktID >0 AND traktID=?) OR (tvdbID > 0 AND tvdbID=?)) AND season=? AND episode=?";
            }
        };
        this.f19251e = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM TvWatchedEpisode";
            }
        };
        this.f19252f = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM TvWatchedEpisode WHERE ((tmdbID > 0 AND tmdbID=?) OR (imdbIDStr IS NOT NULL AND imdbIDStr=? ) OR (traktID >0 AND traktID=?) OR (tvdbID > 0 AND tvdbID=?)) AND season=? AND episode=?";
            }
        };
    }

    private TvWatchedEpisode m(Cursor cursor) {
        Long l2;
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("tmdbID");
        int columnIndex3 = cursor.getColumnIndex("imdbIDStr");
        int columnIndex4 = cursor.getColumnIndex("tvdbID");
        int columnIndex5 = cursor.getColumnIndex("traktID");
        int columnIndex6 = cursor.getColumnIndex("season");
        int columnIndex7 = cursor.getColumnIndex("episode");
        int columnIndex8 = cursor.getColumnIndex(ViewProps.POSITION);
        int columnIndex9 = cursor.getColumnIndex("duration");
        int columnIndex10 = cursor.getColumnIndex("subtitlepath");
        int columnIndex11 = cursor.getColumnIndex("collected_at");
        int columnIndex12 = cursor.getColumnIndex("watched_at");
        TvWatchedEpisode tvWatchedEpisode = new TvWatchedEpisode();
        if (columnIndex != -1) {
            tvWatchedEpisode.n(cursor.getInt(columnIndex));
        }
        if (columnIndex2 != -1) {
            tvWatchedEpisode.s(cursor.getLong(columnIndex2));
        }
        if (columnIndex3 != -1) {
            tvWatchedEpisode.o(cursor.getString(columnIndex3));
        }
        if (columnIndex4 != -1) {
            tvWatchedEpisode.u(cursor.getLong(columnIndex4));
        }
        if (columnIndex5 != -1) {
            tvWatchedEpisode.t(cursor.getLong(columnIndex5));
        }
        if (columnIndex6 != -1) {
            tvWatchedEpisode.q(cursor.getInt(columnIndex6));
        }
        if (columnIndex7 != -1) {
            tvWatchedEpisode.m(cursor.getInt(columnIndex7));
        }
        if (columnIndex8 != -1) {
            tvWatchedEpisode.p(cursor.getLong(columnIndex8));
        }
        if (columnIndex9 != -1) {
            tvWatchedEpisode.l(cursor.getLong(columnIndex9));
        }
        if (columnIndex10 != -1) {
            tvWatchedEpisode.r(cursor.getString(columnIndex10));
        }
        Long l3 = null;
        if (columnIndex11 != -1) {
            if (cursor.isNull(columnIndex11)) {
                l2 = null;
            } else {
                l2 = Long.valueOf(cursor.getLong(columnIndex11));
            }
            tvWatchedEpisode.k(MovieEntity.Converter.a(l2));
        }
        if (columnIndex12 != -1) {
            if (!cursor.isNull(columnIndex12)) {
                l3 = Long.valueOf(cursor.getLong(columnIndex12));
            }
            tvWatchedEpisode.v(MovieEntity.Converter.a(l3));
        }
        return tvWatchedEpisode;
    }

    public int a() {
        this.f19247a.b();
        SupportSQLiteStatement a2 = this.f19251e.a();
        this.f19247a.c();
        try {
            int j2 = a2.j();
            this.f19247a.t();
            return j2;
        } finally {
            this.f19247a.g();
            this.f19251e.f(a2);
        }
    }

    public /* synthetic */ void b(TvWatchedEpisode... tvWatchedEpisodeArr) {
        b.a(this, tvWatchedEpisodeArr);
    }

    public int c(long j2, String str, long j3, long j4, int i2, int i3) {
        this.f19247a.b();
        SupportSQLiteStatement a2 = this.f19250d.a();
        a2.X(1, j2);
        if (str == null) {
            a2.d0(2);
        } else {
            a2.R(2, str);
        }
        a2.X(3, j4);
        a2.X(4, j3);
        a2.X(5, (long) i2);
        a2.X(6, (long) i3);
        this.f19247a.c();
        try {
            int j5 = a2.j();
            this.f19247a.t();
            return j5;
        } finally {
            this.f19247a.g();
            this.f19250d.f(a2);
        }
    }

    public void d(long j2, String str, long j3, long j4, int i2, int i3) {
        this.f19247a.b();
        SupportSQLiteStatement a2 = this.f19252f.a();
        a2.X(1, j2);
        if (str == null) {
            a2.d0(2);
        } else {
            a2.R(2, str);
        }
        a2.X(3, j3);
        a2.X(4, j4);
        a2.X(5, (long) i2);
        a2.X(6, (long) i3);
        this.f19247a.c();
        try {
            a2.j();
            this.f19247a.t();
        } finally {
            this.f19247a.g();
            this.f19252f.f(a2);
        }
    }

    public List<TvWatchedEpisode> e(long j2, String str, long j3, long j4, int i2, int i3) {
        RoomSQLiteQuery i4 = RoomSQLiteQuery.i("SELECT * FROM TvWatchedEpisode WHERE ((tmdbID > 0 AND tmdbID=?) OR (imdbIDStr IS NOT NULL AND imdbIDStr=? ) OR (traktID >0 AND traktID=?) OR (tvdbID > 0 AND tvdbID=?)) AND season=? AND episode=?", 6);
        i4.X(1, j2);
        if (str == null) {
            i4.d0(2);
        } else {
            i4.R(2, str);
        }
        i4.X(3, j3);
        i4.X(4, j4);
        i4.X(5, (long) i2);
        i4.X(6, (long) i3);
        this.f19247a.b();
        Cursor b2 = DBUtil.b(this.f19247a, i4, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(m(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i4.release();
        }
    }

    public TvWatchedEpisode f(int i2) {
        TvWatchedEpisode tvWatchedEpisode;
        RoomSQLiteQuery i3 = RoomSQLiteQuery.i("SELECT * FROM TvWatchedEpisode WHERE season=? ORDER BY (season * 100 + episode) DESC LIMIT 1", 1);
        i3.X(1, (long) i2);
        this.f19247a.b();
        Cursor b2 = DBUtil.b(this.f19247a, i3, false);
        try {
            if (b2.moveToFirst()) {
                tvWatchedEpisode = m(b2);
            } else {
                tvWatchedEpisode = null;
            }
            return tvWatchedEpisode;
        } finally {
            b2.close();
            i3.release();
        }
    }

    public int g(long j2, String str, long j3, long j4, int i2, int i3, long j5, long j6, String str2) {
        long j7 = j2;
        String str3 = str;
        long j8 = j3;
        long j9 = j4;
        String str4 = str2;
        this.f19247a.b();
        SupportSQLiteStatement a2 = this.f19249c.a();
        a2.X(1, j7);
        if (str3 == null) {
            a2.d0(2);
        } else {
            a2.R(2, str3);
        }
        a2.X(3, j8);
        a2.X(4, j9);
        long j10 = (long) i2;
        a2.X(5, j10);
        long j11 = (long) i3;
        a2.X(6, j11);
        long j12 = j11;
        a2.X(7, j5);
        a2.X(8, j6);
        if (str4 == null) {
            a2.d0(9);
        } else {
            a2.R(9, str4);
        }
        a2.X(10, j7);
        if (str3 == null) {
            a2.d0(11);
        } else {
            a2.R(11, str3);
        }
        a2.X(12, j9);
        a2.X(13, j8);
        a2.X(14, j10);
        a2.X(15, j12);
        this.f19247a.c();
        try {
            int j13 = a2.j();
            this.f19247a.t();
            return j13;
        } finally {
            this.f19247a.g();
            this.f19249c.f(a2);
        }
    }

    public List<TvWatchedEpisode> h(long j2, String str, long j3, long j4, int i2) {
        RoomSQLiteQuery i3 = RoomSQLiteQuery.i("SELECT * FROM TvWatchedEpisode WHERE ((tmdbID > 0 AND tmdbID=?) OR (imdbIDStr IS NOT NULL AND imdbIDStr=? ) OR (traktID >0 AND traktID=?) OR (tvdbID > 0 AND tvdbID=?)) AND season=?", 5);
        i3.X(1, j2);
        if (str == null) {
            i3.d0(2);
        } else {
            i3.R(2, str);
        }
        i3.X(3, j3);
        i3.X(4, j4);
        i3.X(5, (long) i2);
        this.f19247a.b();
        Cursor b2 = DBUtil.b(this.f19247a, i3, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(m(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i3.release();
        }
    }

    public long i(long j2, String str, long j3, long j4, int i2, int i3, long j5, long j6, String str2) {
        String str3 = str;
        String str4 = str2;
        this.f19247a.b();
        SupportSQLiteStatement a2 = this.f19248b.a();
        long j7 = j2;
        a2.X(1, j2);
        if (str3 == null) {
            a2.d0(2);
        } else {
            a2.R(2, str);
        }
        long j8 = j3;
        a2.X(3, j3);
        long j9 = j4;
        a2.X(4, j4);
        a2.X(5, (long) i2);
        a2.X(6, (long) i3);
        a2.X(7, j5);
        a2.X(8, j6);
        if (str4 == null) {
            a2.d0(9);
        } else {
            a2.R(9, str4);
        }
        this.f19247a.c();
        try {
            long P = a2.P();
            this.f19247a.t();
            return P;
        } finally {
            this.f19247a.g();
            this.f19248b.f(a2);
        }
    }

    public List<TvWatchedEpisode> j(long j2, String str, long j3, long j4) {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT * FROM TvWatchedEpisode WHERE ((tmdbID > 0 AND tmdbID=?) OR (imdbIDStr IS NOT NULL AND imdbIDStr=? ) OR (traktID >0 AND traktID=?) OR (tvdbID > 0 AND tvdbID=?))", 4);
        i2.X(1, j2);
        if (str == null) {
            i2.d0(2);
        } else {
            i2.R(2, str);
        }
        i2.X(3, j3);
        i2.X(4, j4);
        this.f19247a.b();
        Cursor b2 = DBUtil.b(this.f19247a, i2, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(m(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i2.release();
        }
    }

    public List<TvWatchedEpisode> k() {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT * FROM TvWatchedEpisode", 0);
        this.f19247a.b();
        Cursor b2 = DBUtil.b(this.f19247a, i2, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(m(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i2.release();
        }
    }

    public /* synthetic */ void l(TvWatchedEpisode... tvWatchedEpisodeArr) {
        b.b(this, tvWatchedEpisodeArr);
    }
}
