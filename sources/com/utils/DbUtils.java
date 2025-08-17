package com.utils;

import android.content.Context;
import android.net.Uri;
import timber.log.Timber;

public final class DbUtils {
    private DbUtils() {
        throw new AssertionError("No instances.");
    }

    public static void a(Context context, Uri uri) {
        try {
            context.getContentResolver().takePersistableUriPermission(uri, 3);
        } catch (SecurityException e2) {
            Timber.e(e2, "Could not persist r/w permission for backup file URI.", new Object[0]);
        }
    }
}
