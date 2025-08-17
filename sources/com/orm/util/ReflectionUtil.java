package com.orm.util;

import android.util.Log;
import com.orm.SugarRecord;
import com.orm.dsl.Ignore;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReflectionUtil {
    private static List<Field> a(List<Field> list, Class<?> cls) {
        Collections.addAll(list, cls.getDeclaredFields());
        if (cls.getSuperclass() != null) {
            return a(list, cls.getSuperclass());
        }
        return list;
    }

    public static List<Field> b(Class cls) {
        List<Field> a2 = SugarConfig.a(cls);
        if (a2 != null) {
            return a2;
        }
        Log.d(SugarRecord.SUGAR, "Fetching properties");
        ArrayList<Field> arrayList = new ArrayList<>();
        a(arrayList, cls);
        ArrayList arrayList2 = new ArrayList();
        for (Field field : arrayList) {
            if (!field.isAnnotationPresent(Ignore.class) && !Modifier.isStatic(field.getModifiers()) && !Modifier.isTransient(field.getModifiers())) {
                arrayList2.add(field);
            }
        }
        SugarConfig.b(cls, arrayList2);
        return arrayList2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.math.BigDecimal} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.math.BigDecimal} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.math.BigDecimal} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v29, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.math.BigDecimal} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.math.BigDecimal} */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:80|81|82|83|104) */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:82:0x0175 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(android.database.Cursor r9, java.lang.reflect.Field r10, java.lang.Object r11) {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "field set error"
            r2 = 1
            r10.setAccessible(r2)
            java.lang.Class r3 = r10.getType()     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.String r4 = com.orm.util.NamingHelper.b(r10)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            int r5 = r9.getColumnIndex(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r5 >= 0) goto L_0x001e
            java.lang.String r9 = "SUGAR"
            java.lang.String r10 = "Invalid colName, you should upgrade database"
            android.util.Log.e(r9, r10)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            return
        L_0x001e:
            boolean r6 = r9.isNull(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r6 == 0) goto L_0x0025
            return
        L_0x0025:
            java.lang.String r6 = "id"
            boolean r4 = r4.equalsIgnoreCase(r6)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 == 0) goto L_0x003a
            long r2 = r9.getLong(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.Long r9 = java.lang.Long.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r10.set(r11, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x003a:
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 != 0) goto L_0x01ff
            java.lang.Class<java.lang.Long> r4 = java.lang.Long.class
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 == 0) goto L_0x004c
            goto L_0x01ff
        L_0x004c:
            boolean r4 = r3.equals(r0)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r6 = 0
            java.lang.String r7 = "null"
            if (r4 == 0) goto L_0x0068
            java.lang.String r9 = r9.getString(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r9 == 0) goto L_0x0062
            boolean r0 = r9.equals(r7)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r0 == 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r6 = r9
        L_0x0063:
            r10.set(r11, r6)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x0068:
            java.lang.Class r4 = java.lang.Double.TYPE     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 != 0) goto L_0x01f3
            java.lang.Class<java.lang.Double> r4 = java.lang.Double.class
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 == 0) goto L_0x007a
            goto L_0x01f3
        L_0x007a:
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 != 0) goto L_0x01e1
            java.lang.Class<java.lang.Boolean> r4 = java.lang.Boolean.class
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 == 0) goto L_0x008c
            goto L_0x01e1
        L_0x008c:
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 != 0) goto L_0x01d5
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 == 0) goto L_0x009e
            goto L_0x01d5
        L_0x009e:
            java.lang.Class r4 = java.lang.Float.TYPE     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 != 0) goto L_0x01c9
            java.lang.Class<java.lang.Float> r4 = java.lang.Float.class
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 == 0) goto L_0x00b0
            goto L_0x01c9
        L_0x00b0:
            java.lang.Class r4 = java.lang.Short.TYPE     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 != 0) goto L_0x01bd
            java.lang.Class<java.lang.Short> r4 = java.lang.Short.class
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 == 0) goto L_0x00c2
            goto L_0x01bd
        L_0x00c2:
            java.lang.Class<java.math.BigDecimal> r4 = java.math.BigDecimal.class
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 == 0) goto L_0x00e1
            java.lang.String r9 = r9.getString(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r9 == 0) goto L_0x00d7
            boolean r0 = r9.equals(r7)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r0 == 0) goto L_0x00d7
            goto L_0x00dc
        L_0x00d7:
            java.math.BigDecimal r6 = new java.math.BigDecimal     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r6.<init>(r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
        L_0x00dc:
            r10.set(r11, r6)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x00e1:
            java.lang.Class<java.sql.Timestamp> r4 = java.sql.Timestamp.class
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 == 0) goto L_0x00f7
            long r2 = r9.getLong(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.sql.Timestamp r9 = new java.sql.Timestamp     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r9.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r10.set(r11, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x00f7:
            java.lang.Class<java.util.Date> r4 = java.util.Date.class
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 == 0) goto L_0x010d
            long r2 = r9.getLong(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.util.Date r9 = new java.util.Date     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r9.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r10.set(r11, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x010d:
            java.lang.Class<java.util.Calendar> r4 = java.util.Calendar.class
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 == 0) goto L_0x0125
            long r2 = r9.getLong(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.util.Calendar r9 = java.util.Calendar.getInstance()     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r9.setTimeInMillis(r2)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r10.set(r11, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x0125:
            java.lang.Class<byte[]> r4 = byte[].class
            boolean r4 = r3.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r4 == 0) goto L_0x0147
            byte[] r0 = r9.getBlob(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            if (r0 != 0) goto L_0x013e
            java.lang.String r9 = ""
            byte[] r9 = r9.getBytes()     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r10.set(r11, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x013e:
            byte[] r9 = r9.getBlob(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r10.set(r11, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x0147:
            java.lang.Class<java.lang.Enum> r4 = java.lang.Enum.class
            boolean r3 = r4.isAssignableFrom(r3)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.String r4 = "Sugar"
            if (r3 == 0) goto L_0x018f
            java.lang.Class r3 = r10.getType()     // Catch:{ Exception -> 0x0175 }
            java.lang.String r6 = "valueOf"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0175 }
            r8 = 0
            r7[r8] = r0     // Catch:{ Exception -> 0x0175 }
            java.lang.reflect.Method r0 = r3.getMethod(r6, r7)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r9 = r9.getString(r5)     // Catch:{ Exception -> 0x0175 }
            java.lang.Class r3 = r10.getType()     // Catch:{ Exception -> 0x0175 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0175 }
            r2[r8] = r9     // Catch:{ Exception -> 0x0175 }
            java.lang.Object r9 = r0.invoke(r3, r2)     // Catch:{ Exception -> 0x0175 }
            r10.set(r11, r9)     // Catch:{ Exception -> 0x0175 }
            goto L_0x021c
        L_0x0175:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r9.<init>()     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.String r11 = "Enum cannot be read from Sqlite3 database. Please check the type of field "
            r9.append(r11)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.String r10 = r10.getName()     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r9.append(r10)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.String r9 = r9.toString()     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            android.util.Log.e(r4, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x018f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r9.<init>()     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.String r11 = "Class cannot be read from Sqlite3 database. Please check the type of field "
            r9.append(r11)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.String r11 = r10.getName()     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r9.append(r11)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.String r11 = "("
            r9.append(r11)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.Class r10 = r10.getType()     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.String r10 = r10.getName()     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r9.append(r10)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.String r10 = ")"
            r9.append(r10)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.String r9 = r9.toString()     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            android.util.Log.e(r4, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x01bd:
            short r9 = r9.getShort(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.Short r9 = java.lang.Short.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r10.set(r11, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x01c9:
            float r9 = r9.getFloat(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.Float r9 = java.lang.Float.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r10.set(r11, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x01d5:
            int r9 = r9.getInt(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r10.set(r11, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x01e1:
            java.lang.String r9 = r9.getString(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.String r0 = "1"
            boolean r9 = r9.equals(r0)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r10.set(r11, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x01f3:
            double r2 = r9.getDouble(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.Double r9 = java.lang.Double.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r10.set(r11, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x01ff:
            long r2 = r9.getLong(r5)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            java.lang.Long r9 = java.lang.Long.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            r10.set(r11, r9)     // Catch:{ IllegalArgumentException -> 0x0214, IllegalAccessException -> 0x020b }
            goto L_0x021c
        L_0x020b:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            android.util.Log.e(r1, r9)
            goto L_0x021c
        L_0x0214:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            android.util.Log.e(r1, r9)
        L_0x021c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.orm.util.ReflectionUtil.c(android.database.Cursor, java.lang.reflect.Field, java.lang.Object):void");
    }
}
