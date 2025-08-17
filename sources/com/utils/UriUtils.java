package com.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public final class UriUtils {
    public static DisplayNameAndSize a(Context context, Uri uri) {
        String str;
        int columnIndex;
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equals("content")) {
            throw new RuntimeException("Only scheme content:// is accepted");
        }
        DisplayNameAndSize displayNameAndSize = new DisplayNameAndSize();
        displayNameAndSize.f37232b = -1;
        Cursor query = context.getContentResolver().query(uri, new String[]{"_data", "_display_name", "_size"}, (String) null, (String[]) null, (String) null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    int columnIndex2 = query.getColumnIndex("_size");
                    if (columnIndex2 != -1) {
                        displayNameAndSize.f37232b = query.getLong(columnIndex2);
                    }
                    int columnIndex3 = query.getColumnIndex("_display_name");
                    if (columnIndex3 != -1) {
                        str = query.getString(columnIndex3);
                    } else {
                        str = null;
                    }
                    if ((columnIndex3 == -1 || str == null) && (columnIndex = query.getColumnIndex("_data")) != -1) {
                        str = query.getString(columnIndex);
                    }
                    displayNameAndSize.f37231a = str;
                }
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        if (query != null) {
            query.close();
        }
        if (displayNameAndSize.f37231a == null) {
            displayNameAndSize.f37231a = uri.getLastPathSegment();
        }
        return displayNameAndSize;
    }
}
