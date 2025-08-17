package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TableInfo {

    /* renamed from: a  reason: collision with root package name */
    public final String f11535a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Column> f11536b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<ForeignKey> f11537c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<Index> f11538d;

    public static class Column {

        /* renamed from: a  reason: collision with root package name */
        public final String f11539a;

        /* renamed from: b  reason: collision with root package name */
        public final String f11540b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11541c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f11542d;

        /* renamed from: e  reason: collision with root package name */
        public final int f11543e;

        /* renamed from: f  reason: collision with root package name */
        public final String f11544f;

        /* renamed from: g  reason: collision with root package name */
        private final int f11545g;

        @Deprecated
        public Column(String str, String str2, boolean z2, int i2) {
            this(str, str2, z2, i2, (String) null, 0);
        }

        private static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains(AdPreferences.TYPE_TEXT)) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            if (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) {
                return 4;
            }
            return 1;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Column column = (Column) obj;
            if (this.f11543e != column.f11543e || !this.f11539a.equals(column.f11539a) || this.f11542d != column.f11542d) {
                return false;
            }
            if (this.f11545g == 1 && column.f11545g == 2 && (str3 = this.f11544f) != null && !str3.equals(column.f11544f)) {
                return false;
            }
            if (this.f11545g == 2 && column.f11545g == 1 && (str2 = column.f11544f) != null && !str2.equals(this.f11544f)) {
                return false;
            }
            int i2 = this.f11545g;
            if ((i2 == 0 || i2 != column.f11545g || ((str = this.f11544f) == null ? column.f11544f == null : str.equals(column.f11544f))) && this.f11541c == column.f11541c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2;
            int hashCode = ((this.f11539a.hashCode() * 31) + this.f11541c) * 31;
            if (this.f11542d) {
                i2 = 1231;
            } else {
                i2 = 1237;
            }
            return ((hashCode + i2) * 31) + this.f11543e;
        }

        public String toString() {
            return "Column{name='" + this.f11539a + '\'' + ", type='" + this.f11540b + '\'' + ", affinity='" + this.f11541c + '\'' + ", notNull=" + this.f11542d + ", primaryKeyPosition=" + this.f11543e + ", defaultValue='" + this.f11544f + '\'' + '}';
        }

        public Column(String str, String str2, boolean z2, int i2, String str3, int i3) {
            this.f11539a = str;
            this.f11540b = str2;
            this.f11542d = z2;
            this.f11543e = i2;
            this.f11541c = a(str2);
            this.f11544f = str3;
            this.f11545g = i3;
        }
    }

    public static class ForeignKey {

        /* renamed from: a  reason: collision with root package name */
        public final String f11546a;

        /* renamed from: b  reason: collision with root package name */
        public final String f11547b;

        /* renamed from: c  reason: collision with root package name */
        public final String f11548c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f11549d;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f11550e;

        public ForeignKey(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f11546a = str;
            this.f11547b = str2;
            this.f11548c = str3;
            this.f11549d = Collections.unmodifiableList(list);
            this.f11550e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (this.f11546a.equals(foreignKey.f11546a) && this.f11547b.equals(foreignKey.f11547b) && this.f11548c.equals(foreignKey.f11548c) && this.f11549d.equals(foreignKey.f11549d)) {
                return this.f11550e.equals(foreignKey.f11550e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f11546a.hashCode() * 31) + this.f11547b.hashCode()) * 31) + this.f11548c.hashCode()) * 31) + this.f11549d.hashCode()) * 31) + this.f11550e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f11546a + '\'' + ", onDelete='" + this.f11547b + '\'' + ", onUpdate='" + this.f11548c + '\'' + ", columnNames=" + this.f11549d + ", referenceColumnNames=" + this.f11550e + '}';
        }
    }

    static class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {

        /* renamed from: b  reason: collision with root package name */
        final int f11551b;

        /* renamed from: c  reason: collision with root package name */
        final int f11552c;

        /* renamed from: d  reason: collision with root package name */
        final String f11553d;

        /* renamed from: e  reason: collision with root package name */
        final String f11554e;

        ForeignKeyWithSequence(int i2, int i3, String str, String str2) {
            this.f11551b = i2;
            this.f11552c = i3;
            this.f11553d = str;
            this.f11554e = str2;
        }

        /* renamed from: a */
        public int compareTo(ForeignKeyWithSequence foreignKeyWithSequence) {
            int i2 = this.f11551b - foreignKeyWithSequence.f11551b;
            if (i2 == 0) {
                return this.f11552c - foreignKeyWithSequence.f11552c;
            }
            return i2;
        }
    }

    public static class Index {

        /* renamed from: a  reason: collision with root package name */
        public final String f11555a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f11556b;

        /* renamed from: c  reason: collision with root package name */
        public final List<String> f11557c;

        public Index(String str, boolean z2, List<String> list) {
            this.f11555a = str;
            this.f11556b = z2;
            this.f11557c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Index index = (Index) obj;
            if (this.f11556b != index.f11556b || !this.f11557c.equals(index.f11557c)) {
                return false;
            }
            if (this.f11555a.startsWith("index_")) {
                return index.f11555a.startsWith("index_");
            }
            return this.f11555a.equals(index.f11555a);
        }

        public int hashCode() {
            int i2;
            if (this.f11555a.startsWith("index_")) {
                i2 = -1184239155;
            } else {
                i2 = this.f11555a.hashCode();
            }
            return (((i2 * 31) + (this.f11556b ? 1 : 0)) * 31) + this.f11557c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f11555a + '\'' + ", unique=" + this.f11556b + ", columns=" + this.f11557c + '}';
        }
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        Set<Index> set3;
        this.f11535a = str;
        this.f11536b = Collections.unmodifiableMap(map);
        this.f11537c = Collections.unmodifiableSet(set);
        if (set2 == null) {
            set3 = null;
        } else {
            set3 = Collections.unmodifiableSet(set2);
        }
        this.f11538d = set3;
    }

    public static TableInfo a(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return new TableInfo(str, b(supportSQLiteDatabase, str), d(supportSQLiteDatabase, str), f(supportSQLiteDatabase, str));
    }

    private static Map<String, Column> b(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        boolean z2;
        Cursor Z = supportSQLiteDatabase.Z("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (Z.getColumnCount() > 0) {
                int columnIndex = Z.getColumnIndex("name");
                int columnIndex2 = Z.getColumnIndex("type");
                int columnIndex3 = Z.getColumnIndex("notnull");
                int columnIndex4 = Z.getColumnIndex("pk");
                int columnIndex5 = Z.getColumnIndex("dflt_value");
                while (Z.moveToNext()) {
                    String string = Z.getString(columnIndex);
                    String string2 = Z.getString(columnIndex2);
                    if (Z.getInt(columnIndex3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    hashMap.put(string, new Column(string, string2, z2, Z.getInt(columnIndex4), Z.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            Z.close();
        }
    }

    private static List<ForeignKeyWithSequence> c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < count; i2++) {
            cursor.moveToPosition(i2);
            arrayList.add(new ForeignKeyWithSequence(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Set<ForeignKey> d(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor Z = supportSQLiteDatabase.Z("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = Z.getColumnIndex("id");
            int columnIndex2 = Z.getColumnIndex("seq");
            int columnIndex3 = Z.getColumnIndex("table");
            int columnIndex4 = Z.getColumnIndex("on_delete");
            int columnIndex5 = Z.getColumnIndex("on_update");
            List<ForeignKeyWithSequence> c2 = c(Z);
            int count = Z.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Z.moveToPosition(i2);
                if (Z.getInt(columnIndex2) == 0) {
                    int i3 = Z.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (ForeignKeyWithSequence next : c2) {
                        if (next.f11551b == i3) {
                            arrayList.add(next.f11553d);
                            arrayList2.add(next.f11554e);
                        }
                    }
                    hashSet.add(new ForeignKey(Z.getString(columnIndex3), Z.getString(columnIndex4), Z.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            Z.close();
        }
    }

    /* JADX INFO: finally extract failed */
    private static Index e(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z2) {
        Cursor Z = supportSQLiteDatabase.Z("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = Z.getColumnIndex("seqno");
            int columnIndex2 = Z.getColumnIndex("cid");
            int columnIndex3 = Z.getColumnIndex("name");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (Z.moveToNext()) {
                        if (Z.getInt(columnIndex2) >= 0) {
                            int i2 = Z.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i2), Z.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    Index index = new Index(str, z2, arrayList);
                    Z.close();
                    return index;
                }
            }
            Z.close();
            return null;
        } catch (Throwable th) {
            Z.close();
            throw th;
        }
    }

    private static Set<Index> f(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Cursor Z = supportSQLiteDatabase.Z("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = Z.getColumnIndex("name");
            int columnIndex2 = Z.getColumnIndex("origin");
            int columnIndex3 = Z.getColumnIndex("unique");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    HashSet hashSet = new HashSet();
                    while (Z.moveToNext()) {
                        if ("c".equals(Z.getString(columnIndex2))) {
                            String string = Z.getString(columnIndex);
                            boolean z2 = true;
                            if (Z.getInt(columnIndex3) != 1) {
                                z2 = false;
                            }
                            Index e2 = e(supportSQLiteDatabase, string, z2);
                            if (e2 == null) {
                                Z.close();
                                return null;
                            }
                            hashSet.add(e2);
                        }
                    }
                    Z.close();
                    return hashSet;
                }
            }
            return null;
        } finally {
            Z.close();
        }
    }

    public boolean equals(Object obj) {
        Set<Index> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        String str = this.f11535a;
        if (str == null ? tableInfo.f11535a != null : !str.equals(tableInfo.f11535a)) {
            return false;
        }
        Map<String, Column> map = this.f11536b;
        if (map == null ? tableInfo.f11536b != null : !map.equals(tableInfo.f11536b)) {
            return false;
        }
        Set<ForeignKey> set2 = this.f11537c;
        if (set2 == null ? tableInfo.f11537c != null : !set2.equals(tableInfo.f11537c)) {
            return false;
        }
        Set<Index> set3 = this.f11538d;
        if (set3 == null || (set = tableInfo.f11538d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        int i2;
        int i3;
        String str = this.f11535a;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = i2 * 31;
        Map<String, Column> map = this.f11536b;
        if (map != null) {
            i3 = map.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (i5 + i3) * 31;
        Set<ForeignKey> set = this.f11537c;
        if (set != null) {
            i4 = set.hashCode();
        }
        return i6 + i4;
    }

    public String toString() {
        return "TableInfo{name='" + this.f11535a + '\'' + ", columns=" + this.f11536b + ", foreignKeys=" + this.f11537c + ", indices=" + this.f11538d + '}';
    }
}
