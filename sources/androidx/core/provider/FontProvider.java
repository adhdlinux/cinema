package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class FontProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<byte[]> f2638a = new a();

    static class Api16Impl {
        private Api16Impl() {
        }

        static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }

    private FontProvider() {
    }

    private static List<byte[]> b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private static List<List<byte[]>> d(FontRequest fontRequest, Resources resources) {
        if (fontRequest.b() != null) {
            return fontRequest.b();
        }
        return FontResourcesParserCompat.c(resources, fontRequest.c());
    }

    static FontsContractCompat.FontFamilyResult e(Context context, FontRequest fontRequest, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo f2 = f(context.getPackageManager(), fontRequest, context.getResources());
        if (f2 == null) {
            return FontsContractCompat.FontFamilyResult.a(1, (FontsContractCompat.FontInfo[]) null);
        }
        return FontsContractCompat.FontFamilyResult.a(0, h(context, fontRequest, f2.authority, cancellationSignal));
    }

    static ProviderInfo f(PackageManager packageManager, FontRequest fontRequest, Resources resources) throws PackageManager.NameNotFoundException {
        String e2 = fontRequest.e();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(e2, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + e2);
        } else if (resolveContentProvider.packageName.equals(fontRequest.f())) {
            List<byte[]> b2 = b(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(b2, f2638a);
            List<List<byte[]>> d2 = d(fontRequest, resources);
            for (int i2 = 0; i2 < d2.size(); i2++) {
                ArrayList arrayList = new ArrayList(d2.get(i2));
                Collections.sort(arrayList, f2638a);
                if (c(b2, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + e2 + ", but package was not " + fontRequest.f());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            byte b3 = bArr2[i2];
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        return 0;
    }

    static FontsContractCompat.FontInfo[] h(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        int i2;
        int i3;
        int i4;
        Uri uri;
        int i5;
        boolean z2;
        int i6;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str2).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath("file").build();
        Cursor cursor = null;
        try {
            Uri uri2 = build;
            cursor = Api16Impl.a(context.getContentResolver(), uri2, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{fontRequest.g()}, (String) null, cancellationSignal);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    if (columnIndex != -1) {
                        i2 = cursor.getInt(columnIndex);
                    } else {
                        i2 = 0;
                    }
                    if (columnIndex4 != -1) {
                        i3 = cursor.getInt(columnIndex4);
                    } else {
                        i3 = 0;
                    }
                    if (columnIndex3 == -1) {
                        i4 = i2;
                        uri = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        i4 = i2;
                        uri = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    if (columnIndex5 != -1) {
                        i5 = cursor.getInt(columnIndex5);
                    } else {
                        i5 = 400;
                    }
                    if (columnIndex6 == -1 || cursor.getInt(columnIndex6) != 1) {
                        i6 = i4;
                        z2 = false;
                    } else {
                        i6 = i4;
                        z2 = true;
                    }
                    arrayList2.add(FontsContractCompat.FontInfo.a(uri, i3, i5, z2, i6));
                }
                arrayList = arrayList2;
            }
            return (FontsContractCompat.FontInfo[]) arrayList.toArray(new FontsContractCompat.FontInfo[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
