package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f2477d = {"_display_name", "_size"};

    /* renamed from: e  reason: collision with root package name */
    private static final File f2478e = new File("/");

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, PathStrategy> f2479f = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private PathStrategy f2480b;

    /* renamed from: c  reason: collision with root package name */
    private int f2481c = 0;

    static class Api21Impl {
        private Api21Impl() {
        }

        static File[] a(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    interface PathStrategy {
        Uri a(File file);

        File b(Uri uri);
    }

    static class SimplePathStrategy implements PathStrategy {

        /* renamed from: a  reason: collision with root package name */
        private final String f2482a;

        /* renamed from: b  reason: collision with root package name */
        private final HashMap<String, File> f2483b = new HashMap<>();

        SimplePathStrategy(String str) {
            this.f2482a = str;
        }

        public Uri a(File file) {
            String str;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                for (Map.Entry next : this.f2483b.entrySet()) {
                    String path = ((File) next.getValue()).getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = next;
                    }
                }
                if (entry != null) {
                    String path2 = ((File) entry.getValue()).getPath();
                    if (path2.endsWith("/")) {
                        str = canonicalPath.substring(path2.length());
                    } else {
                        str = canonicalPath.substring(path2.length() + 1);
                    }
                    return new Uri.Builder().scheme("content").authority(this.f2482a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(str, "/")).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        public File b(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f2483b.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                }
            } else {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f2483b.put(str, file.getCanonicalFile());
                } catch (IOException e2) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e2);
                }
            } else {
                throw new IllegalArgumentException("Name must not be empty");
            }
        }
    }

    private static File a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static Object[] b(Object[] objArr, int i2) {
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, i2);
        return objArr2;
    }

    private static String[] c(String[] strArr, int i2) {
        String[] strArr2 = new String[i2];
        System.arraycopy(strArr, 0, strArr2, 0, i2);
        return strArr2;
    }

    static XmlResourceParser d(Context context, String str, ProviderInfo providerInfo, int i2) {
        if (providerInfo != null) {
            if (providerInfo.metaData == null && i2 != 0) {
                Bundle bundle = new Bundle(1);
                providerInfo.metaData = bundle;
                bundle.putInt("android.support.FILE_PROVIDER_PATHS", i2);
            }
            XmlResourceParser loadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
            if (loadXmlMetaData != null) {
                return loadXmlMetaData;
            }
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
    }

    private static PathStrategy e(Context context, String str, int i2) {
        PathStrategy pathStrategy;
        HashMap<String, PathStrategy> hashMap = f2479f;
        synchronized (hashMap) {
            pathStrategy = hashMap.get(str);
            if (pathStrategy == null) {
                try {
                    pathStrategy = h(context, str, i2);
                    hashMap.put(str, pathStrategy);
                } catch (IOException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                } catch (XmlPullParserException e3) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e3);
                }
            }
        }
        return pathStrategy;
    }

    public static Uri f(Context context, String str, File file) {
        return e(context, str, 0).a(file);
    }

    private static int g(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    private static PathStrategy h(Context context, String str, int i2) throws IOException, XmlPullParserException {
        SimplePathStrategy simplePathStrategy = new SimplePathStrategy(str);
        XmlResourceParser d2 = d(context, str, context.getPackageManager().resolveContentProvider(str, 128), i2);
        while (true) {
            int next = d2.next();
            if (next == 1) {
                return simplePathStrategy;
            }
            if (next == 2) {
                String name = d2.getName();
                File file = null;
                String attributeValue = d2.getAttributeValue((String) null, "name");
                String attributeValue2 = d2.getAttributeValue((String) null, "path");
                if ("root-path".equals(name)) {
                    file = f2478e;
                } else if ("files-path".equals(name)) {
                    file = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    file = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    file = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(context, (String) null);
                    if (externalFilesDirs.length > 0) {
                        file = externalFilesDirs[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] externalCacheDirs = ContextCompat.getExternalCacheDirs(context);
                    if (externalCacheDirs.length > 0) {
                        file = externalCacheDirs[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] a2 = Api21Impl.a(context);
                    if (a2.length > 0) {
                        file = a2[0];
                    }
                }
                if (file != null) {
                    simplePathStrategy.c(attributeValue, a(file, attributeValue2));
                }
            }
        }
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            String str = providerInfo.authority.split(";")[0];
            HashMap<String, PathStrategy> hashMap = f2479f;
            synchronized (hashMap) {
                hashMap.remove(str);
            }
            this.f2480b = e(context, str, this.f2481c);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.f2480b.b(uri).delete() ? 1 : 0;
    }

    public String getType(Uri uri) {
        String mimeTypeFromExtension;
        File b2 = this.f2480b.b(uri);
        int lastIndexOf = b2.getName().lastIndexOf(46);
        if (lastIndexOf < 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(b2.getName().substring(lastIndexOf + 1))) == null) {
            return "application/octet-stream";
        }
        return mimeTypeFromExtension;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate() {
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.f2480b.b(uri), g(str));
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i2;
        String str3;
        File b2 = this.f2480b.b(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = f2477d;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i3 = 0;
        for (String str4 : strArr) {
            if ("_display_name".equals(str4)) {
                strArr3[i3] = "_display_name";
                i2 = i3 + 1;
                if (queryParameter == null) {
                    str3 = b2.getName();
                } else {
                    str3 = queryParameter;
                }
                objArr[i3] = str3;
            } else if ("_size".equals(str4)) {
                strArr3[i3] = "_size";
                i2 = i3 + 1;
                objArr[i3] = Long.valueOf(b2.length());
            }
            i3 = i2;
        }
        String[] c2 = c(strArr3, i3);
        Object[] b3 = b(objArr, i3);
        MatrixCursor matrixCursor = new MatrixCursor(c2, 1);
        matrixCursor.addRow(b3);
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
