package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class DatabaseConfiguration {

    /* renamed from: a  reason: collision with root package name */
    public final SupportSQLiteOpenHelper.Factory f11382a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f11383b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11384c;

    /* renamed from: d  reason: collision with root package name */
    public final RoomDatabase.MigrationContainer f11385d;

    /* renamed from: e  reason: collision with root package name */
    public final List<RoomDatabase.Callback> f11386e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f11387f;

    /* renamed from: g  reason: collision with root package name */
    public final RoomDatabase.JournalMode f11388g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f11389h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f11390i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f11391j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f11392k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f11393l;

    /* renamed from: m  reason: collision with root package name */
    private final Set<Integer> f11394m;

    /* renamed from: n  reason: collision with root package name */
    public final String f11395n;

    /* renamed from: o  reason: collision with root package name */
    public final File f11396o;

    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z3, boolean z4, boolean z5, Set<Integer> set, String str2, File file) {
        this.f11382a = factory;
        this.f11383b = context;
        this.f11384c = str;
        this.f11385d = migrationContainer;
        this.f11386e = list;
        this.f11387f = z2;
        this.f11388g = journalMode;
        this.f11389h = executor;
        this.f11390i = executor2;
        this.f11391j = z3;
        this.f11392k = z4;
        this.f11393l = z5;
        this.f11394m = set;
        this.f11395n = str2;
        this.f11396o = file;
    }

    public boolean a(int i2, int i3) {
        boolean z2;
        Set<Integer> set;
        if (i2 > i3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((!z2 || !this.f11393l) && this.f11392k && ((set = this.f11394m) == null || !set.contains(Integer.valueOf(i2)))) {
            return true;
        }
        return false;
    }
}
