package com.facebook.react.modules.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class AsyncLocalStorageUtil {
    static String buildKeySelection(int i2) {
        String[] strArr = new String[i2];
        Arrays.fill(strArr, "?");
        return "key IN (" + TextUtils.join(", ", strArr) + ")";
    }

    static String[] buildKeySelectionArgs(ReadableArray readableArray, int i2, int i3) {
        String[] strArr = new String[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            strArr[i4] = readableArray.getString(i2 + i4);
        }
        return strArr;
    }

    private static void deepMergeInto(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject2.optJSONObject(next);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(next);
            if (optJSONObject == null || optJSONObject2 == null) {
                jSONObject.put(next, jSONObject2.get(next));
            } else {
                deepMergeInto(optJSONObject2, optJSONObject);
                jSONObject.put(next, optJSONObject2);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static String getItemImpl(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor query = sQLiteDatabase.query("catalystLocalStorage", new String[]{AppMeasurementSdk.ConditionalUserProperty.VALUE}, "key=?", new String[]{str}, (String) null, (String) null, (String) null);
        try {
            if (!query.moveToFirst()) {
                query.close();
                return null;
            }
            String string = query.getString(0);
            query.close();
            return string;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    static boolean mergeImpl(SQLiteDatabase sQLiteDatabase, String str, String str2) throws JSONException {
        String itemImpl = getItemImpl(sQLiteDatabase, str);
        if (itemImpl != null) {
            JSONObject jSONObject = new JSONObject(itemImpl);
            deepMergeInto(jSONObject, new JSONObject(str2));
            str2 = jSONObject.toString();
        }
        return setItemImpl(sQLiteDatabase, str, str2);
    }

    static boolean setItemImpl(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, str2);
        if (-1 != sQLiteDatabase.insertWithOnConflict("catalystLocalStorage", (String) null, contentValues, 5)) {
            return true;
        }
        return false;
    }
}
