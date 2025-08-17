package com.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.database.daos.CategoryDao;
import com.database.daos.CategoryDao_Impl;
import com.database.daos.CrawlCountDAO;
import com.database.daos.CrawlCountDAO_Impl;
import com.database.daos.MovieDAO;
import com.database.daos.MovieDAO_Impl;
import com.database.daos.TvWatchedEpisodeDAO;
import com.database.daos.TvWatchedEpisodeDAO_Impl;
import com.database.daos.UserListDao;
import com.database.daos.UserListDao_Impl;
import com.database.daos.premiumDAO.torrents.CachedTorrentFileDAO;
import com.database.daos.premiumDAO.torrents.CachedTorrentFileDAO_Impl;
import com.database.daos.premiumDAO.torrents.TorrentDAO;
import com.database.daos.premiumDAO.torrents.TorrentDAO_Impl;
import com.facebook.react.uimanager.ViewProps;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public final class MvDatabase_Impl extends MvDatabase {
    private volatile MovieDAO C;
    private volatile CachedTorrentFileDAO D;
    private volatile TvWatchedEpisodeDAO E;
    private volatile CrawlCountDAO F;
    private volatile TorrentDAO G;
    private volatile CategoryDao H;
    private volatile UserListDao I;

    public MovieDAO A() {
        MovieDAO movieDAO;
        if (this.C != null) {
            return this.C;
        }
        synchronized (this) {
            if (this.C == null) {
                this.C = new MovieDAO_Impl(this);
            }
            movieDAO = this.C;
        }
        return movieDAO;
    }

    public TorrentDAO D() {
        TorrentDAO torrentDAO;
        if (this.G != null) {
            return this.G;
        }
        synchronized (this) {
            if (this.G == null) {
                this.G = new TorrentDAO_Impl(this);
            }
            torrentDAO = this.G;
        }
        return torrentDAO;
    }

    public TvWatchedEpisodeDAO E() {
        TvWatchedEpisodeDAO tvWatchedEpisodeDAO;
        if (this.E != null) {
            return this.E;
        }
        synchronized (this) {
            if (this.E == null) {
                this.E = new TvWatchedEpisodeDAO_Impl(this);
            }
            tvWatchedEpisodeDAO = this.E;
        }
        return tvWatchedEpisodeDAO;
    }

    public UserListDao F() {
        UserListDao userListDao;
        if (this.I != null) {
            return this.I;
        }
        synchronized (this) {
            if (this.I == null) {
                this.I = new UserListDao_Impl(this);
            }
            userListDao = this.I;
        }
        return userListDao;
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker e() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "MovieEntity", "TvWatchedEpisode", "GenreEntity", "CrawlCount", "RealDebridEntity", "TorrentEntity", "CachedTorrentFileEntity", "CategoryEntity", "UserListEntity");
    }

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper f(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.f11382a.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f11383b).c(databaseConfiguration.f11384c).b(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(16) {
            public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `MovieEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `tmdbID` INTEGER NOT NULL, `imdbIDStr` TEXT, `traktID` INTEGER NOT NULL, `tvdbID` INTEGER NOT NULL, `position` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `subtitlepath` TEXT, `poster_path` TEXT, `backdrop_path` TEXT, `name` TEXT, `realeaseDate` TEXT, `overview` TEXT, `genres` TEXT, `vote` REAL, `createdDate` INTEGER, `isFavorite` INTEGER, `isWatched` INTEGER NOT NULL, `isTV` INTEGER, `numberSeason` INTEGER NOT NULL, `collected_at` INTEGER, `watched_at` INTEGER)");
                supportSQLiteDatabase.g("CREATE  INDEX `index_MovieEntity_tmdbID` ON `MovieEntity` (`tmdbID`)");
                supportSQLiteDatabase.g("CREATE  INDEX `index_MovieEntity_imdbIDStr` ON `MovieEntity` (`imdbIDStr`)");
                supportSQLiteDatabase.g("CREATE  INDEX `index_MovieEntity_traktID` ON `MovieEntity` (`traktID`)");
                supportSQLiteDatabase.g("CREATE  INDEX `index_MovieEntity_tvdbID` ON `MovieEntity` (`tvdbID`)");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `TvWatchedEpisode` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `tmdbID` INTEGER NOT NULL, `imdbIDStr` TEXT, `tvdbID` INTEGER NOT NULL, `traktID` INTEGER NOT NULL, `season` INTEGER NOT NULL, `episode` INTEGER NOT NULL, `position` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `subtitlepath` TEXT, `collected_at` INTEGER, `watched_at` INTEGER)");
                supportSQLiteDatabase.g("CREATE  INDEX `index_TvWatchedEpisode_season` ON `TvWatchedEpisode` (`season`)");
                supportSQLiteDatabase.g("CREATE  INDEX `index_TvWatchedEpisode_episode` ON `TvWatchedEpisode` (`episode`)");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `GenreEntity` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `isTV` INTEGER NOT NULL, `sortField` TEXT, PRIMARY KEY(`id`, `name`, `isTV`))");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `CrawlCount` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `provider` TEXT, `host` TEXT, `count` INTEGER NOT NULL)");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `RealDebridEntity` (`tmdbID` INTEGER NOT NULL, `imdbIDStr` TEXT, `traktID` INTEGER NOT NULL, `tvdbID` INTEGER NOT NULL, `season` INTEGER NOT NULL, `episode` INTEGER NOT NULL, `percent` REAL NOT NULL, `status` TEXT, `id` TEXT NOT NULL, `name` TEXT, `hash` TEXT, `filesize` INTEGER NOT NULL, `fileLink` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `TorrentEntity` (`hash` TEXT NOT NULL, `id` TEXT NOT NULL, `type` TEXT NOT NULL, `fileIDs` TEXT, `movieEntityID` INTEGER NOT NULL, PRIMARY KEY(`hash`, `type`), FOREIGN KEY(`movieEntityID`) REFERENCES `MovieEntity`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `CachedTorrentFileEntity` (`id` TEXT NOT NULL, `fullName` TEXT, `fileSize` INTEGER NOT NULL, `movieEntityID` INTEGER NOT NULL, `season` INTEGER NOT NULL, `episode` INTEGER NOT NULL, `type` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `CategoryEntity` (`category_source` INTEGER NOT NULL, `category_type` INTEGER NOT NULL, `category_id` INTEGER NOT NULL, `category_source_type` INTEGER NOT NULL, `category_name` TEXT, `category_restricted` INTEGER, PRIMARY KEY(`category_source`, `category_type`, `category_id`, `category_source_type`))");
                supportSQLiteDatabase.g("CREATE  INDEX `index_CategoryEntity_category_source` ON `CategoryEntity` (`category_source`)");
                supportSQLiteDatabase.g("CREATE  INDEX `index_CategoryEntity_category_type` ON `CategoryEntity` (`category_type`)");
                supportSQLiteDatabase.g("CREATE  INDEX `index_CategoryEntity_category_id` ON `CategoryEntity` (`category_id`)");
                supportSQLiteDatabase.g("CREATE  INDEX `index_CategoryEntity_category_source_type` ON `CategoryEntity` (`category_source_type`)");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `UserListEntity` (`name` TEXT NOT NULL, `id` TEXT NOT NULL, `owner` TEXT NOT NULL, `pivacy` TEXT NOT NULL, `enable` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.g("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '59f3f2c6eea6a57947436526559d5b9c')");
            }

            public void b(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `MovieEntity`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `TvWatchedEpisode`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `GenreEntity`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `CrawlCount`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `RealDebridEntity`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `TorrentEntity`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `CachedTorrentFileEntity`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `CategoryEntity`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `UserListEntity`");
            }

            /* access modifiers changed from: protected */
            public void c(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (MvDatabase_Impl.this.f11459h != null) {
                    int size = MvDatabase_Impl.this.f11459h.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.Callback) MvDatabase_Impl.this.f11459h.get(i2)).a(supportSQLiteDatabase);
                    }
                }
            }

            public void d(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = MvDatabase_Impl.this.f11452a = supportSQLiteDatabase;
                supportSQLiteDatabase.g("PRAGMA foreign_keys = ON");
                MvDatabase_Impl.this.o(supportSQLiteDatabase);
                if (MvDatabase_Impl.this.f11459h != null) {
                    int size = MvDatabase_Impl.this.f11459h.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.Callback) MvDatabase_Impl.this.f11459h.get(i2)).c(supportSQLiteDatabase);
                    }
                }
            }

            public void e(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void f(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.a(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public void h(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(22);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
                hashMap.put("tmdbID", new TableInfo.Column("tmdbID", "INTEGER", true, 0));
                hashMap.put("imdbIDStr", new TableInfo.Column("imdbIDStr", AdPreferences.TYPE_TEXT, false, 0));
                hashMap.put("traktID", new TableInfo.Column("traktID", "INTEGER", true, 0));
                hashMap.put("tvdbID", new TableInfo.Column("tvdbID", "INTEGER", true, 0));
                hashMap.put(ViewProps.POSITION, new TableInfo.Column(ViewProps.POSITION, "INTEGER", true, 0));
                hashMap.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0));
                hashMap.put("subtitlepath", new TableInfo.Column("subtitlepath", AdPreferences.TYPE_TEXT, false, 0));
                hashMap.put("poster_path", new TableInfo.Column("poster_path", AdPreferences.TYPE_TEXT, false, 0));
                hashMap.put("backdrop_path", new TableInfo.Column("backdrop_path", AdPreferences.TYPE_TEXT, false, 0));
                hashMap.put("name", new TableInfo.Column("name", AdPreferences.TYPE_TEXT, false, 0));
                hashMap.put("realeaseDate", new TableInfo.Column("realeaseDate", AdPreferences.TYPE_TEXT, false, 0));
                hashMap.put("overview", new TableInfo.Column("overview", AdPreferences.TYPE_TEXT, false, 0));
                hashMap.put("genres", new TableInfo.Column("genres", AdPreferences.TYPE_TEXT, false, 0));
                String str = "name";
                hashMap.put("vote", new TableInfo.Column("vote", "REAL", false, 0));
                hashMap.put("createdDate", new TableInfo.Column("createdDate", "INTEGER", false, 0));
                hashMap.put("isFavorite", new TableInfo.Column("isFavorite", "INTEGER", false, 0));
                hashMap.put("isWatched", new TableInfo.Column("isWatched", "INTEGER", true, 0));
                hashMap.put("isTV", new TableInfo.Column("isTV", "INTEGER", false, 0));
                String str2 = "isTV";
                hashMap.put("numberSeason", new TableInfo.Column("numberSeason", "INTEGER", true, 0));
                hashMap.put("collected_at", new TableInfo.Column("collected_at", "INTEGER", false, 0));
                hashMap.put("watched_at", new TableInfo.Column("watched_at", "INTEGER", false, 0));
                HashSet hashSet = new HashSet(0);
                String str3 = "watched_at";
                HashSet hashSet2 = new HashSet(4);
                String str4 = "collected_at";
                String str5 = "subtitlepath";
                String str6 = "duration";
                hashSet2.add(new TableInfo.Index("index_MovieEntity_tmdbID", false, Arrays.asList(new String[]{"tmdbID"})));
                hashSet2.add(new TableInfo.Index("index_MovieEntity_imdbIDStr", false, Arrays.asList(new String[]{"imdbIDStr"})));
                hashSet2.add(new TableInfo.Index("index_MovieEntity_traktID", false, Arrays.asList(new String[]{"traktID"})));
                hashSet2.add(new TableInfo.Index("index_MovieEntity_tvdbID", false, Arrays.asList(new String[]{"tvdbID"})));
                TableInfo tableInfo = new TableInfo("MovieEntity", hashMap, hashSet, hashSet2);
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase2, "MovieEntity");
                if (tableInfo.equals(a2)) {
                    HashMap hashMap2 = new HashMap(12);
                    hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
                    hashMap2.put("tmdbID", new TableInfo.Column("tmdbID", "INTEGER", true, 0));
                    hashMap2.put("imdbIDStr", new TableInfo.Column("imdbIDStr", AdPreferences.TYPE_TEXT, false, 0));
                    hashMap2.put("tvdbID", new TableInfo.Column("tvdbID", "INTEGER", true, 0));
                    hashMap2.put("traktID", new TableInfo.Column("traktID", "INTEGER", true, 0));
                    hashMap2.put("season", new TableInfo.Column("season", "INTEGER", true, 0));
                    hashMap2.put("episode", new TableInfo.Column("episode", "INTEGER", true, 0));
                    hashMap2.put(ViewProps.POSITION, new TableInfo.Column(ViewProps.POSITION, "INTEGER", true, 0));
                    String str7 = str6;
                    hashMap2.put(str7, new TableInfo.Column(str7, "INTEGER", true, 0));
                    String str8 = str5;
                    hashMap2.put(str8, new TableInfo.Column(str8, AdPreferences.TYPE_TEXT, false, 0));
                    String str9 = str4;
                    hashMap2.put(str9, new TableInfo.Column(str9, "INTEGER", false, 0));
                    String str10 = str3;
                    hashMap2.put(str10, new TableInfo.Column(str10, "INTEGER", false, 0));
                    HashSet hashSet3 = new HashSet(0);
                    HashSet hashSet4 = new HashSet(2);
                    String str11 = "\n Found:\n";
                    String str12 = "season";
                    hashSet4.add(new TableInfo.Index("index_TvWatchedEpisode_season", false, Arrays.asList(new String[]{"season"})));
                    hashSet4.add(new TableInfo.Index("index_TvWatchedEpisode_episode", false, Arrays.asList(new String[]{"episode"})));
                    TableInfo tableInfo2 = new TableInfo("TvWatchedEpisode", hashMap2, hashSet3, hashSet4);
                    TableInfo a3 = TableInfo.a(supportSQLiteDatabase2, "TvWatchedEpisode");
                    if (tableInfo2.equals(a3)) {
                        HashMap hashMap3 = new HashMap(4);
                        hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
                        String str13 = str;
                        hashMap3.put(str13, new TableInfo.Column(str13, AdPreferences.TYPE_TEXT, true, 2));
                        String str14 = str2;
                        hashMap3.put(str14, new TableInfo.Column(str14, "INTEGER", true, 3));
                        hashMap3.put("sortField", new TableInfo.Column("sortField", AdPreferences.TYPE_TEXT, false, 0));
                        TableInfo tableInfo3 = new TableInfo("GenreEntity", hashMap3, new HashSet(0), new HashSet(0));
                        TableInfo a4 = TableInfo.a(supportSQLiteDatabase2, "GenreEntity");
                        if (tableInfo3.equals(a4)) {
                            HashMap hashMap4 = new HashMap(4);
                            hashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
                            hashMap4.put("provider", new TableInfo.Column("provider", AdPreferences.TYPE_TEXT, false, 0));
                            hashMap4.put("host", new TableInfo.Column("host", AdPreferences.TYPE_TEXT, false, 0));
                            hashMap4.put("count", new TableInfo.Column("count", "INTEGER", true, 0));
                            TableInfo tableInfo4 = new TableInfo("CrawlCount", hashMap4, new HashSet(0), new HashSet(0));
                            TableInfo a5 = TableInfo.a(supportSQLiteDatabase2, "CrawlCount");
                            if (tableInfo4.equals(a5)) {
                                HashMap hashMap5 = new HashMap(13);
                                hashMap5.put("tmdbID", new TableInfo.Column("tmdbID", "INTEGER", true, 0));
                                hashMap5.put("imdbIDStr", new TableInfo.Column("imdbIDStr", AdPreferences.TYPE_TEXT, false, 0));
                                hashMap5.put("traktID", new TableInfo.Column("traktID", "INTEGER", true, 0));
                                hashMap5.put("tvdbID", new TableInfo.Column("tvdbID", "INTEGER", true, 0));
                                String str15 = str12;
                                hashMap5.put(str15, new TableInfo.Column(str15, "INTEGER", true, 0));
                                hashMap5.put("episode", new TableInfo.Column("episode", "INTEGER", true, 0));
                                hashMap5.put("percent", new TableInfo.Column("percent", "REAL", true, 0));
                                hashMap5.put("status", new TableInfo.Column("status", AdPreferences.TYPE_TEXT, false, 0));
                                hashMap5.put("id", new TableInfo.Column("id", AdPreferences.TYPE_TEXT, true, 1));
                                hashMap5.put(str13, new TableInfo.Column(str13, AdPreferences.TYPE_TEXT, false, 0));
                                hashMap5.put("hash", new TableInfo.Column("hash", AdPreferences.TYPE_TEXT, false, 0));
                                hashMap5.put("filesize", new TableInfo.Column("filesize", "INTEGER", true, 0));
                                hashMap5.put("fileLink", new TableInfo.Column("fileLink", AdPreferences.TYPE_TEXT, false, 0));
                                TableInfo tableInfo5 = new TableInfo("RealDebridEntity", hashMap5, new HashSet(0), new HashSet(0));
                                TableInfo a6 = TableInfo.a(supportSQLiteDatabase2, "RealDebridEntity");
                                if (tableInfo5.equals(a6)) {
                                    HashMap hashMap6 = new HashMap(5);
                                    hashMap6.put("hash", new TableInfo.Column("hash", AdPreferences.TYPE_TEXT, true, 1));
                                    hashMap6.put("id", new TableInfo.Column("id", AdPreferences.TYPE_TEXT, true, 0));
                                    hashMap6.put("type", new TableInfo.Column("type", AdPreferences.TYPE_TEXT, true, 2));
                                    hashMap6.put("fileIDs", new TableInfo.Column("fileIDs", AdPreferences.TYPE_TEXT, false, 0));
                                    hashMap6.put("movieEntityID", new TableInfo.Column("movieEntityID", "INTEGER", true, 0));
                                    HashSet hashSet5 = new HashSet(1);
                                    hashSet5.add(new TableInfo.ForeignKey("MovieEntity", "CASCADE", "NO ACTION", Arrays.asList(new String[]{"movieEntityID"}), Arrays.asList(new String[]{"id"})));
                                    TableInfo tableInfo6 = new TableInfo("TorrentEntity", hashMap6, hashSet5, new HashSet(0));
                                    TableInfo a7 = TableInfo.a(supportSQLiteDatabase2, "TorrentEntity");
                                    if (tableInfo6.equals(a7)) {
                                        HashMap hashMap7 = new HashMap(7);
                                        hashMap7.put("id", new TableInfo.Column("id", AdPreferences.TYPE_TEXT, true, 1));
                                        hashMap7.put("fullName", new TableInfo.Column("fullName", AdPreferences.TYPE_TEXT, false, 0));
                                        hashMap7.put("fileSize", new TableInfo.Column("fileSize", "INTEGER", true, 0));
                                        hashMap7.put("movieEntityID", new TableInfo.Column("movieEntityID", "INTEGER", true, 0));
                                        hashMap7.put(str15, new TableInfo.Column(str15, "INTEGER", true, 0));
                                        hashMap7.put("episode", new TableInfo.Column("episode", "INTEGER", true, 0));
                                        hashMap7.put("type", new TableInfo.Column("type", AdPreferences.TYPE_TEXT, true, 0));
                                        TableInfo tableInfo7 = new TableInfo("CachedTorrentFileEntity", hashMap7, new HashSet(0), new HashSet(0));
                                        TableInfo a8 = TableInfo.a(supportSQLiteDatabase2, "CachedTorrentFileEntity");
                                        if (tableInfo7.equals(a8)) {
                                            HashMap hashMap8 = new HashMap(6);
                                            hashMap8.put("category_source", new TableInfo.Column("category_source", "INTEGER", true, 1));
                                            hashMap8.put("category_type", new TableInfo.Column("category_type", "INTEGER", true, 2));
                                            hashMap8.put("category_id", new TableInfo.Column("category_id", "INTEGER", true, 3));
                                            hashMap8.put("category_source_type", new TableInfo.Column("category_source_type", "INTEGER", true, 4));
                                            hashMap8.put("category_name", new TableInfo.Column("category_name", AdPreferences.TYPE_TEXT, false, 0));
                                            hashMap8.put("category_restricted", new TableInfo.Column("category_restricted", "INTEGER", false, 0));
                                            HashSet hashSet6 = new HashSet(0);
                                            HashSet hashSet7 = new HashSet(4);
                                            hashSet7.add(new TableInfo.Index("index_CategoryEntity_category_source", false, Arrays.asList(new String[]{"category_source"})));
                                            hashSet7.add(new TableInfo.Index("index_CategoryEntity_category_type", false, Arrays.asList(new String[]{"category_type"})));
                                            hashSet7.add(new TableInfo.Index("index_CategoryEntity_category_id", false, Arrays.asList(new String[]{"category_id"})));
                                            hashSet7.add(new TableInfo.Index("index_CategoryEntity_category_source_type", false, Arrays.asList(new String[]{"category_source_type"})));
                                            TableInfo tableInfo8 = new TableInfo("CategoryEntity", hashMap8, hashSet6, hashSet7);
                                            TableInfo a9 = TableInfo.a(supportSQLiteDatabase2, "CategoryEntity");
                                            if (tableInfo8.equals(a9)) {
                                                HashMap hashMap9 = new HashMap(5);
                                                hashMap9.put(str13, new TableInfo.Column(str13, AdPreferences.TYPE_TEXT, true, 0));
                                                hashMap9.put("id", new TableInfo.Column("id", AdPreferences.TYPE_TEXT, true, 1));
                                                hashMap9.put("owner", new TableInfo.Column("owner", AdPreferences.TYPE_TEXT, true, 0));
                                                hashMap9.put("pivacy", new TableInfo.Column("pivacy", AdPreferences.TYPE_TEXT, true, 0));
                                                hashMap9.put("enable", new TableInfo.Column("enable", "INTEGER", true, 0));
                                                TableInfo tableInfo9 = new TableInfo("UserListEntity", hashMap9, new HashSet(0), new HashSet(0));
                                                TableInfo a10 = TableInfo.a(supportSQLiteDatabase2, "UserListEntity");
                                                if (!tableInfo9.equals(a10)) {
                                                    throw new IllegalStateException("Migration didn't properly handle UserListEntity(com.database.entitys.UserListEntity).\n Expected:\n" + tableInfo9 + str11 + a10);
                                                }
                                                return;
                                            }
                                            throw new IllegalStateException("Migration didn't properly handle CategoryEntity(com.database.entitys.CategoryEntity).\n Expected:\n" + tableInfo8 + str11 + a9);
                                        }
                                        throw new IllegalStateException("Migration didn't properly handle CachedTorrentFileEntity(com.database.entitys.premiumEntitys.torrents.CachedTorrentFileEntity).\n Expected:\n" + tableInfo7 + str11 + a8);
                                    }
                                    throw new IllegalStateException("Migration didn't properly handle TorrentEntity(com.database.entitys.premiumEntitys.torrents.TorrentEntity).\n Expected:\n" + tableInfo6 + str11 + a7);
                                }
                                throw new IllegalStateException("Migration didn't properly handle RealDebridEntity(com.database.entitys.premiumEntitys.RealDebridEntity).\n Expected:\n" + tableInfo5 + str11 + a6);
                            }
                            throw new IllegalStateException("Migration didn't properly handle CrawlCount(com.database.entitys.CrawlCount).\n Expected:\n" + tableInfo4 + str11 + a5);
                        }
                        throw new IllegalStateException("Migration didn't properly handle GenreEntity(com.database.entitys.GenreEntity).\n Expected:\n" + tableInfo3 + str11 + a4);
                    }
                    throw new IllegalStateException("Migration didn't properly handle TvWatchedEpisode(com.database.entitys.TvWatchedEpisode).\n Expected:\n" + tableInfo2 + str11 + a3);
                }
                throw new IllegalStateException("Migration didn't properly handle MovieEntity(com.database.entitys.MovieEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
            }
        }, "59f3f2c6eea6a57947436526559d5b9c", "b689d9614e9d4405dff0b55029b0ed71")).a());
    }

    public CategoryDao w() {
        CategoryDao categoryDao;
        if (this.H != null) {
            return this.H;
        }
        synchronized (this) {
            if (this.H == null) {
                this.H = new CategoryDao_Impl(this);
            }
            categoryDao = this.H;
        }
        return categoryDao;
    }

    public CrawlCountDAO x() {
        CrawlCountDAO crawlCountDAO;
        if (this.F != null) {
            return this.F;
        }
        synchronized (this) {
            if (this.F == null) {
                this.F = new CrawlCountDAO_Impl(this);
            }
            crawlCountDAO = this.F;
        }
        return crawlCountDAO;
    }

    public CachedTorrentFileDAO y() {
        CachedTorrentFileDAO cachedTorrentFileDAO;
        if (this.D != null) {
            return this.D;
        }
        synchronized (this) {
            if (this.D == null) {
                this.D = new CachedTorrentFileDAO_Impl(this);
            }
            cachedTorrentFileDAO = this.D;
        }
        return cachedTorrentFileDAO;
    }
}
