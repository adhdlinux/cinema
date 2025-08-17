package com.database;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.database.daos.CategoryDao;
import com.database.daos.CrawlCountDAO;
import com.database.daos.MovieDAO;
import com.database.daos.TvWatchedEpisodeDAO;
import com.database.daos.UserListDao;
import com.database.daos.premiumDAO.torrents.CachedTorrentFileDAO;
import com.database.daos.premiumDAO.torrents.TorrentDAO;
import com.google.common.io.ByteStreams;
import com.utils.PrefUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.joda.time.DateTime;

public abstract class MvDatabase extends RoomDatabase {
    static final Migration A = new Migration(14, 15) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `UserListEntity` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `owner` TEXT NOT NULL, `pivacy` TEXT NOT NULL, PRIMARY KEY(`id`))");
        }
    };
    static final Migration B = new Migration(15, 16) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("ALTER TABLE UserListEntity ADD COLUMN enable INTEGER NOT NULL DEFAULT 1");
        }
    };

    /* renamed from: l  reason: collision with root package name */
    static MvDatabase f19196l;

    /* renamed from: m  reason: collision with root package name */
    private static final Object f19197m = new Object();

    /* renamed from: n  reason: collision with root package name */
    static final Migration f19198n = new Migration(1, 2) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `CrawlCount` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `provider` TEXT, `host` TEXT, `count` INTEGER NOT NULL)");
        }
    };

    /* renamed from: o  reason: collision with root package name */
    static final Migration f19199o = new Migration(2, 3) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `TvWatchedEpisode_new2` (`tmdbID` INTEGER NOT NULL , `season` INTEGER NOT NULL,`episode` INTEGER NOT NULL, `position` INTEGER NOT NULL, PRIMARY KEY(`tmdbID`,`season`,`episode`), FOREIGN KEY(`tmdbID`) REFERENCES `MovieEntity`(`tmdbID`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
            supportSQLiteDatabase.g("CREATE  INDEX `index_TvWatchedEpisode_tmdbID2` ON `TvWatchedEpisode_new2` (`tmdbID`)");
            supportSQLiteDatabase.g("CREATE  INDEX `index_TvWatchedEpisode_season` ON `TvWatchedEpisode_new2` (`season`)");
            supportSQLiteDatabase.g("CREATE  INDEX `index_TvWatchedEpisode_episode` ON `TvWatchedEpisode_new2` (`episode`)");
            supportSQLiteDatabase.g("INSERT OR IGNORE INTO TvWatchedEpisode_new2 (`tmdbID`,`season`,`episode`,`position`) SELECT `tmdbID`,`season`,`episode`,`position`FROM TvWatchedEpisode");
            supportSQLiteDatabase.g("DROP TABLE TvWatchedEpisode");
            supportSQLiteDatabase.g("ALTER TABLE TvWatchedEpisode_new2 RENAME TO TvWatchedEpisode");
        }
    };

    /* renamed from: p  reason: collision with root package name */
    static final Migration f19200p = new Migration(3, 4) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("ALTER TABLE MovieEntity  ADD COLUMN tvdbID INTEGER NOT NULL DEFAULT -1");
        }
    };

    /* renamed from: q  reason: collision with root package name */
    static final Migration f19201q = new Migration(4, 5) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("ALTER TABLE MovieEntity  ADD COLUMN subtitlepath TEXT");
            supportSQLiteDatabase.g("ALTER TABLE TvWatchedEpisode  ADD COLUMN subtitlepath TEXT");
        }
    };

    /* renamed from: r  reason: collision with root package name */
    static final Migration f19202r = new Migration(5, 6) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("ALTER TABLE MovieEntity  ADD COLUMN duration INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.g("ALTER TABLE TvWatchedEpisode  ADD COLUMN duration INTEGER NOT NULL DEFAULT 0");
        }
    };

    /* renamed from: s  reason: collision with root package name */
    static final Migration f19203s = new Migration(6, 7) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("ALTER TABLE MovieEntity  ADD COLUMN imdbIDStr TEXT");
        }
    };

    /* renamed from: t  reason: collision with root package name */
    static final Migration f19204t = new Migration(7, 8) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `TvWatchedEpisode_2` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `tmdbID` INTEGER NOT NULL, `imdbIDStr` TEXT, `tvdbID` INTEGER NOT NULL, `traktID` INTEGER NOT NULL, `season` INTEGER NOT NULL, `episode` INTEGER NOT NULL, `position` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `subtitlepath` TEXT)");
            supportSQLiteDatabase.g("CREATE  INDEX `index_TvWatchedEpisode_season_2` ON `TvWatchedEpisode_2` (`season`)");
            supportSQLiteDatabase.g("CREATE  INDEX `index_TvWatchedEpisode_episode_2` ON `TvWatchedEpisode_2` (`episode`)");
            supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `MovieEntity_2` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `tmdbID` INTEGER NOT NULL, `imdbIDStr` TEXT, `traktID` INTEGER NOT NULL, `tvdbID` INTEGER NOT NULL, `position` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `subtitlepath` TEXT, `poster_path` TEXT, `backdrop_path` TEXT, `name` TEXT, `realeaseDate` TEXT, `overview` TEXT, `genres` TEXT, `vote` REAL, `createdDate` INTEGER, `isFavorite` INTEGER, `isTV` INTEGER, `numberSeason` INTEGER NOT NULL)");
            supportSQLiteDatabase.g("CREATE  INDEX `index_MovieEntity_tmdbID_2` ON `MovieEntity_2` (`tmdbID`)");
            supportSQLiteDatabase.g("CREATE  INDEX `index_MovieEntity_imdbIDStr_2` ON `MovieEntity_2` (`imdbIDStr`)");
            supportSQLiteDatabase.g("CREATE  INDEX `index_MovieEntity_traktID_2` ON `MovieEntity_2` (`traktID`)");
            supportSQLiteDatabase.g("CREATE  INDEX `index_MovieEntity_tvdbID_2` ON `MovieEntity_2` (`tvdbID`)");
            supportSQLiteDatabase.g("INSERT OR IGNORE INTO TvWatchedEpisode_2 (`tmdbID`,`imdbIDStr`,`tvdbID`,`traktID`,`season`,`episode`,`position`,`duration`,`subtitlepath`) SELECT `tmdbID`,NULL,0,0,`season`,`episode`,`position`,`duration`,`subtitlepath`FROM TvWatchedEpisode");
            supportSQLiteDatabase.g("INSERT OR IGNORE INTO MovieEntity_2 (`tmdbID`, `imdbIDStr`, `traktID`, `tvdbID`, `position`, `duration`, `subtitlepath`, `poster_path`, `backdrop_path`, `name`, `realeaseDate`, `overview`, `genres`, `vote`, `createdDate`, `isFavorite`, `isTV`, `numberSeason`)SELECT `tmdbID`,NULL,0,0,`position`,`duration`,`subtitlepath`,`poster_path`, `backdrop_path`, `name`, `realeaseDate`, `overview`, `genres`, `vote`, `createdDate`, `isFavorite`, `isTV`, `numberSeason`FROM MovieEntity");
            supportSQLiteDatabase.g("DROP TABLE TvWatchedEpisode");
            supportSQLiteDatabase.g("DROP TABLE MovieEntity");
            supportSQLiteDatabase.g("ALTER TABLE TvWatchedEpisode_2 RENAME TO TvWatchedEpisode");
            supportSQLiteDatabase.g("ALTER TABLE MovieEntity_2 RENAME TO MovieEntity");
        }
    };

    /* renamed from: u  reason: collision with root package name */
    static final Migration f19205u = new Migration(8, 9) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `RealDebridEntity` (`id` TEXT NOT NULL, `tmdbID` INTEGER NOT NULL, `imdbIDStr` TEXT, `traktID` INTEGER NOT NULL, `tvdbID` INTEGER NOT NULL, `season` INTEGER NOT NULL, `episode` INTEGER NOT NULL, `percent` REAL NOT NULL, `status` TEXT, `name` TEXT, `hash` TEXT, `filesize` INTEGER NOT NULL, `fileLink` TEXT, PRIMARY KEY(`id`))");
        }
    };

    /* renamed from: v  reason: collision with root package name */
    static final Migration f19206v = new Migration(9, 10) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `TorrentEntity` (`hash` TEXT NOT NULL, `id` TEXT NOT NULL, `type` TEXT NOT NULL, `fileIDs` TEXT, `movieEntityID` INTEGER NOT NULL, PRIMARY KEY(`hash`, `type`), FOREIGN KEY(`movieEntityID`) REFERENCES `MovieEntity`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        }
    };

    /* renamed from: w  reason: collision with root package name */
    static final Migration f19207w = new Migration(10, 11) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("ALTER TABLE MovieEntity ADD COLUMN isWatched INTEGER DEFAULT 1 NOT NULL");
        }
    };

    /* renamed from: x  reason: collision with root package name */
    static final Migration f19208x = new Migration(11, 12) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("ALTER TABLE MovieEntity ADD COLUMN collected_at INTEGER");
            supportSQLiteDatabase.g("ALTER TABLE MovieEntity ADD COLUMN watched_at INTEGER ");
            supportSQLiteDatabase.g("ALTER TABLE TvWatchedEpisode ADD COLUMN collected_at INTEGER");
            supportSQLiteDatabase.g("ALTER TABLE TvWatchedEpisode ADD COLUMN watched_at INTEGER ");
            supportSQLiteDatabase.g("UPDATE MovieEntity SET collected_at = createdDate WHERE isFavorite = 1");
            supportSQLiteDatabase.g("UPDATE MovieEntity SET watched_at = createdDate WHERE isWatched = 1");
        }
    };

    /* renamed from: y  reason: collision with root package name */
    static final Migration f19209y = new Migration(12, 13) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `TorrentEntity2` (`hash` TEXT NOT NULL, `id` TEXT NOT NULL, `type` TEXT NOT NULL, `fileIDs` TEXT, `movieEntityID` INTEGER NOT NULL, PRIMARY KEY(`hash`, `type`), FOREIGN KEY(`movieEntityID`) REFERENCES `MovieEntity`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
            supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `CachedTorrentFileEntity` (`id` TEXT NOT NULL, `fullName` TEXT, `fileSize` INTEGER NOT NULL, `movieEntityID` INTEGER NOT NULL, `season` INTEGER NOT NULL, `episode` INTEGER NOT NULL, `type` TEXT NOT NULL, PRIMARY KEY(`id`))");
            supportSQLiteDatabase.g("INSERT OR IGNORE INTO TorrentEntity2 (`hash`,`id`,`type`,`fileIDs`,`movieEntityID`) SELECT `hash`,`id`,`type`,`fileIDs`,`movieEntityID`FROM TorrentEntity");
            supportSQLiteDatabase.g("DROP TABLE TorrentEntity");
            supportSQLiteDatabase.g("ALTER TABLE TorrentEntity2 RENAME TO TorrentEntity");
        }
    };

    /* renamed from: z  reason: collision with root package name */
    static final Migration f19210z = new Migration(13, 14) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `CategoryEntity` (`category_source` INTEGER NOT NULL, `category_type` INTEGER NOT NULL, `category_id` INTEGER NOT NULL, `category_source_type` INTEGER NOT NULL, `category_name` TEXT, `category_restricted` INTEGER, PRIMARY KEY(`category_source`, `category_type`, `category_id`, `category_source_type`))");
            supportSQLiteDatabase.g("CREATE  INDEX `index_CategoryEntity_category_source` ON `CategoryEntity` (`category_source`)");
            supportSQLiteDatabase.g("CREATE  INDEX `index_CategoryEntity_category_type` ON `CategoryEntity` (`category_type`)");
            supportSQLiteDatabase.g("CREATE  INDEX `index_CategoryEntity_category_id` ON `CategoryEntity` (`category_id`)");
            supportSQLiteDatabase.g("CREATE  INDEX `index_CategoryEntity_category_source_type` ON `CategoryEntity` (`category_source_type`)");
        }
    };

    public static void B(Context context, Uri uri) throws IOException, ClassNotFoundException {
        ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        byte[] bArr = new byte[((int) dataInputStream.readLong())];
        dataInputStream.read(bArr);
        byte[] bArr2 = new byte[((int) dataInputStream.readLong())];
        dataInputStream.read(bArr2);
        byte[] bArr3 = new byte[((int) dataInputStream.readLong())];
        dataInputStream.read(bArr3);
        byte[] bArr4 = new byte[((int) dataInputStream.readLong())];
        dataInputStream.read(bArr4);
        dataInputStream.close();
        fileInputStream.close();
        openFileDescriptor.close();
        FileOutputStream fileOutputStream = new FileOutputStream(context.getDatabasePath("MvDatabaseDB").getAbsolutePath(), false);
        fileOutputStream.write(bArr);
        fileOutputStream.close();
        FileOutputStream fileOutputStream2 = new FileOutputStream(context.getDatabasePath("MvDatabaseDB-shm").getAbsolutePath(), false);
        fileOutputStream2.write(bArr2);
        fileOutputStream2.close();
        FileOutputStream fileOutputStream3 = new FileOutputStream(context.getDatabasePath("MvDatabaseDB-wal").getAbsolutePath(), false);
        fileOutputStream3.write(bArr3);
        fileOutputStream3.close();
        PrefUtils.m(context, PrefUtils.b(bArr4));
    }

    public static void C(Context context, String str) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(str);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        byte[] bArr = new byte[((int) dataInputStream.readLong())];
        dataInputStream.read(bArr);
        byte[] bArr2 = new byte[((int) dataInputStream.readLong())];
        dataInputStream.read(bArr2);
        byte[] bArr3 = new byte[((int) dataInputStream.readLong())];
        dataInputStream.read(bArr3);
        byte[] bArr4 = new byte[((int) dataInputStream.readLong())];
        dataInputStream.read(bArr4);
        dataInputStream.close();
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(context.getDatabasePath("MvDatabaseDB").getAbsolutePath(), false);
        fileOutputStream.write(bArr);
        fileOutputStream.close();
        FileOutputStream fileOutputStream2 = new FileOutputStream(context.getDatabasePath("MvDatabaseDB-shm").getAbsolutePath(), false);
        fileOutputStream2.write(bArr2);
        fileOutputStream2.close();
        FileOutputStream fileOutputStream3 = new FileOutputStream(context.getDatabasePath("MvDatabaseDB-wal").getAbsolutePath(), false);
        fileOutputStream3.write(bArr3);
        fileOutputStream3.close();
        PrefUtils.m(context, PrefUtils.b(bArr4));
    }

    public static void u(Context context, Uri uri) throws IOException {
        DateTime.now().toString("yyyy_MM_dd");
        FileInputStream fileInputStream = new FileInputStream(context.getDatabasePath("MvDatabaseDB").getAbsolutePath());
        FileInputStream fileInputStream2 = new FileInputStream(context.getDatabasePath("MvDatabaseDB-shm").getAbsolutePath());
        FileInputStream fileInputStream3 = new FileInputStream(context.getDatabasePath("MvDatabaseDB-wal").getAbsolutePath());
        FileOutputStream fileOutputStream = new FileOutputStream(context.getContentResolver().openFileDescriptor(uri, "rw").getFileDescriptor());
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        dataOutputStream.writeLong(fileInputStream.getChannel().size());
        dataOutputStream.write(ByteStreams.d(fileInputStream));
        dataOutputStream.writeLong(fileInputStream2.getChannel().size());
        dataOutputStream.write(ByteStreams.d(fileInputStream2));
        dataOutputStream.writeLong(fileInputStream3.getChannel().size());
        dataOutputStream.write(ByteStreams.d(fileInputStream3));
        byte[] a2 = PrefUtils.a(context.getSharedPreferences("hdmovies", 0).getAll());
        dataOutputStream.writeLong((long) a2.length);
        dataOutputStream.write(a2);
        dataOutputStream.close();
        fileOutputStream.close();
        fileInputStream.close();
        fileInputStream2.close();
        fileInputStream3.close();
    }

    public static void v(Context context, String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(context.getDatabasePath("MvDatabaseDB").getAbsolutePath());
        FileInputStream fileInputStream2 = new FileInputStream(context.getDatabasePath("MvDatabaseDB-shm").getAbsolutePath());
        FileInputStream fileInputStream3 = new FileInputStream(context.getDatabasePath("MvDatabaseDB-wal").getAbsolutePath());
        FileOutputStream fileOutputStream = new FileOutputStream(str, false);
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        dataOutputStream.writeLong(fileInputStream.getChannel().size());
        dataOutputStream.write(ByteStreams.d(fileInputStream));
        dataOutputStream.writeLong(fileInputStream2.getChannel().size());
        dataOutputStream.write(ByteStreams.d(fileInputStream2));
        dataOutputStream.writeLong(fileInputStream3.getChannel().size());
        dataOutputStream.write(ByteStreams.d(fileInputStream3));
        byte[] a2 = PrefUtils.a(context.getSharedPreferences("hdmovies", 0).getAll());
        dataOutputStream.writeLong((long) a2.length);
        dataOutputStream.write(a2);
        dataOutputStream.close();
        fileOutputStream.close();
        fileInputStream.close();
        fileInputStream2.close();
        fileInputStream3.close();
    }

    public static MvDatabase z(Context context) {
        MvDatabase mvDatabase;
        synchronized (f19197m) {
            if (f19196l == null) {
                f19196l = Room.a(context, MvDatabase.class, "MvDatabaseDB").b(f19198n, f19199o, f19200p, f19201q, f19202r, f19203s, f19204t, f19205u, f19206v, f19207w, f19208x, f19209y, f19210z, A, B).d();
            }
            mvDatabase = f19196l;
        }
        return mvDatabase;
    }

    public abstract MovieDAO A();

    public abstract TorrentDAO D();

    public abstract TvWatchedEpisodeDAO E();

    public abstract UserListDao F();

    public abstract CategoryDao w();

    public abstract CrawlCountDAO x();

    public abstract CachedTorrentFileDAO y();
}
