package com.startapp;

import com.startapp.common.parser.JSONStreamException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Class> f34548a;

    static {
        HashMap hashMap = new HashMap();
        f34548a = hashMap;
        hashMap.put("int[]", Integer.class);
        f34548a.put("long[]", Long.class);
        f34548a.put("double[]", Double.class);
        f34548a.put("float[]", Float.class);
        f34548a.put("bool[]", Boolean.class);
        f34548a.put("char[]", Character.class);
        f34548a.put("byte[]", Byte.class);
        f34548a.put("void[]", Void.class);
        f34548a.put("short[]", Short.class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0273, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x027b, code lost:
        throw new com.startapp.common.parser.JSONStreamException("Unknown error occurred ", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012c A[Catch:{ Exception -> 0x027c, all -> 0x0273 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0169 A[Catch:{ Exception -> 0x027c, all -> 0x0273 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0273 A[ExcHandler: all (r0v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:42:0x00d4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T a(java.lang.Class<T> r20, org.json.JSONObject r21) throws com.startapp.common.parser.JSONStreamException {
        /*
            r0 = r20
            r1 = r21
            java.lang.String r2 = "Problem instantiating object class "
            java.lang.Class<com.startapp.i0> r3 = com.startapp.i0.class
            java.lang.annotation.Annotation r4 = r0.getAnnotation(r3)     // Catch:{ Exception -> 0x0284 }
            com.startapp.i0 r4 = (com.startapp.i0) r4     // Catch:{ Exception -> 0x0284 }
            java.lang.Class<java.net.HttpCookie> r5 = java.net.HttpCookie.class
            boolean r5 = r0.equals(r5)     // Catch:{ Exception -> 0x0284 }
            java.lang.String r6 = "."
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0033
            java.lang.reflect.Constructor[] r2 = r20.getDeclaredConstructors()     // Catch:{ Exception -> 0x0284 }
            r2 = r2[r8]     // Catch:{ Exception -> 0x0284 }
            r2.setAccessible(r7)     // Catch:{ Exception -> 0x0284 }
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0284 }
            java.lang.String r10 = "name"
            r5[r8] = r10     // Catch:{ Exception -> 0x0284 }
            java.lang.String r10 = "value"
            r5[r7] = r10     // Catch:{ Exception -> 0x0284 }
            java.lang.Object r2 = r2.newInstance(r5)     // Catch:{ Exception -> 0x0284 }
            goto L_0x0097
        L_0x0033:
            boolean r5 = r20.isPrimitive()     // Catch:{ Exception -> 0x0284 }
            if (r5 == 0) goto L_0x003e
            java.lang.Object r0 = r20.newInstance()     // Catch:{ Exception -> 0x0284 }
            return r0
        L_0x003e:
            java.lang.annotation.Annotation r5 = r0.getAnnotation(r3)     // Catch:{ Exception -> 0x0284 }
            if (r5 == 0) goto L_0x0088
            boolean r5 = r4.extendsClass()     // Catch:{ Exception -> 0x0284 }
            if (r5 == 0) goto L_0x004b
            goto L_0x0088
        L_0x004b:
            boolean r5 = r4.extendsClass()     // Catch:{ Exception -> 0x0284 }
            if (r5 != 0) goto L_0x0086
            java.lang.String r0 = r4.decider()     // Catch:{ ClassNotFoundException -> 0x007f, JSONException -> 0x0078 }
            java.lang.String r0 = r1.getString(r0)     // Catch:{ ClassNotFoundException -> 0x007f, JSONException -> 0x0078 }
            java.lang.String r3 = r4.packageName()     // Catch:{ ClassNotFoundException -> 0x007f, JSONException -> 0x0078 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x007f, JSONException -> 0x0078 }
            r4.<init>()     // Catch:{ ClassNotFoundException -> 0x007f, JSONException -> 0x0078 }
            r4.append(r3)     // Catch:{ ClassNotFoundException -> 0x007f, JSONException -> 0x0078 }
            r4.append(r6)     // Catch:{ ClassNotFoundException -> 0x007f, JSONException -> 0x0078 }
            r4.append(r0)     // Catch:{ ClassNotFoundException -> 0x007f, JSONException -> 0x0078 }
            java.lang.String r0 = r4.toString()     // Catch:{ ClassNotFoundException -> 0x007f, JSONException -> 0x0078 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x007f, JSONException -> 0x0078 }
            java.lang.Object r0 = a(r0, (org.json.JSONObject) r1)     // Catch:{ ClassNotFoundException -> 0x007f, JSONException -> 0x0078 }
            return r0
        L_0x0078:
            r0 = move-exception
            com.startapp.common.parser.JSONStreamException r1 = new com.startapp.common.parser.JSONStreamException     // Catch:{ Exception -> 0x0284 }
            r1.<init>(r2, r0)     // Catch:{ Exception -> 0x0284 }
            throw r1     // Catch:{ Exception -> 0x0284 }
        L_0x007f:
            r0 = move-exception
            com.startapp.common.parser.JSONStreamException r1 = new com.startapp.common.parser.JSONStreamException     // Catch:{ Exception -> 0x0284 }
            r1.<init>(r2, r0)     // Catch:{ Exception -> 0x0284 }
            throw r1     // Catch:{ Exception -> 0x0284 }
        L_0x0086:
            r2 = 0
            goto L_0x0097
        L_0x0088:
            java.lang.Class[] r2 = new java.lang.Class[r8]     // Catch:{ Exception -> 0x0284 }
            java.lang.reflect.Constructor r2 = r0.getDeclaredConstructor(r2)     // Catch:{ Exception -> 0x0284 }
            r2.setAccessible(r7)     // Catch:{ Exception -> 0x0284 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0284 }
            java.lang.Object r2 = r2.newInstance(r5)     // Catch:{ Exception -> 0x0284 }
        L_0x0097:
            java.lang.reflect.Field[] r5 = r20.getDeclaredFields()
            if (r4 == 0) goto L_0x00b8
            boolean r4 = r4.extendsClass()
            if (r4 == 0) goto L_0x00b8
            int r4 = r5.length
            java.lang.Class r0 = r20.getSuperclass()
            java.lang.reflect.Field[] r0 = r0.getDeclaredFields()
            int r10 = r0.length
            int r11 = r4 + r10
            java.lang.reflect.Field[] r11 = new java.lang.reflect.Field[r11]
            java.lang.System.arraycopy(r5, r8, r11, r8, r4)
            java.lang.System.arraycopy(r0, r8, r11, r4, r10)
            r5 = r11
        L_0x00b8:
            int r0 = r5.length
            r4 = 0
        L_0x00ba:
            if (r4 >= r0) goto L_0x0283
            r10 = r5[r4]
            int r11 = r10.getModifiers()
            boolean r12 = java.lang.reflect.Modifier.isStatic(r11)
            if (r12 != 0) goto L_0x027c
            boolean r11 = java.lang.reflect.Modifier.isTransient(r11)
            if (r11 == 0) goto L_0x00d0
            goto L_0x027c
        L_0x00d0:
            java.lang.String r11 = com.startapp.p.a((java.lang.reflect.Field) r10)
            boolean r12 = r1.has(r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            if (r12 == 0) goto L_0x027c
            r10.setAccessible(r7)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.annotation.Annotation[] r12 = r10.getDeclaredAnnotations()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            int r12 = r12.length     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Class<com.startapp.common.parser.TypeParser> r13 = com.startapp.common.parser.TypeParser.class
            if (r12 <= 0) goto L_0x0119
            java.lang.annotation.Annotation[] r12 = r10.getDeclaredAnnotations()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r12 = r12[r8]     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Class r14 = r12.annotationType()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Class<com.startapp.j0> r15 = com.startapp.j0.class
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            if (r14 == 0) goto L_0x0119
            com.startapp.j0 r12 = (com.startapp.j0) r12     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Class r14 = r12.type()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Class r15 = r12.key()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Class r16 = r12.value()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            boolean r17 = r12.complex()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Class r18 = r12.innerValue()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Class r12 = r12.parser()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r7 = r16
            r8 = r18
            r19 = 1
            goto L_0x0122
        L_0x0119:
            r12 = r13
            r7 = 0
            r8 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r19 = 0
        L_0x0122:
            java.lang.Class r9 = r10.getType()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.annotation.Annotation r9 = r9.getAnnotation(r3)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            if (r9 == 0) goto L_0x0169
            java.lang.Class r7 = r10.getType()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.annotation.Annotation r7 = r7.getAnnotation(r3)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            com.startapp.i0 r7 = (com.startapp.i0) r7     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            org.json.JSONObject r8 = r1.getJSONObject(r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.String r9 = r7.decider()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.String r7 = r7.packageName()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r9.<init>()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r9.append(r7)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r9.append(r6)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r9.append(r8)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            org.json.JSONObject r8 = r1.getJSONObject(r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Object r7 = a(r7, (org.json.JSONObject) r8)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r10.set(r2, r7)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            goto L_0x027c
        L_0x0169:
            if (r12 == r13) goto L_0x0182
            java.lang.Object r7 = r12.newInstance()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            com.startapp.common.parser.TypeParser r7 = (com.startapp.common.parser.TypeParser) r7     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Class r8 = r10.getType()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Object r9 = r1.opt(r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Object r7 = r7.parse(r8, r9)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r10.set(r2, r7)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            goto L_0x027c
        L_0x0182:
            if (r17 == 0) goto L_0x0195
            java.lang.Class r7 = r10.getType()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            org.json.JSONObject r8 = r1.getJSONObject(r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Object r7 = a(r7, (org.json.JSONObject) r8)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r10.set(r2, r7)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            goto L_0x027c
        L_0x0195:
            if (r19 == 0) goto L_0x0214
            java.lang.Class<java.util.Map> r9 = java.util.Map.class
            boolean r9 = r9.isAssignableFrom(r14)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            if (r9 != 0) goto L_0x01a7
            java.lang.Class<java.util.Collection> r9 = java.util.Collection.class
            boolean r9 = r9.isAssignableFrom(r14)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            if (r9 == 0) goto L_0x0214
        L_0x01a7:
            java.lang.Class<java.util.HashMap> r9 = java.util.HashMap.class
            boolean r9 = r14.equals(r9)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            if (r9 == 0) goto L_0x01c0
            org.json.JSONObject r9 = r1.getJSONObject(r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.util.Iterator r11 = r9.keys()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.util.Map r7 = a(r15, r7, r8, r9, r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r10.set(r2, r7)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            goto L_0x027c
        L_0x01c0:
            java.lang.Class<java.util.ArrayList> r8 = java.util.ArrayList.class
            boolean r8 = r14.equals(r8)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            if (r8 == 0) goto L_0x01d5
            org.json.JSONArray r8 = r1.getJSONArray(r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.util.List r7 = a((java.lang.Class) r7, (org.json.JSONArray) r8)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r10.set(r2, r7)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            goto L_0x027c
        L_0x01d5:
            java.lang.Class<java.util.HashSet> r8 = java.util.HashSet.class
            boolean r8 = r14.equals(r8)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            if (r8 == 0) goto L_0x01ea
            org.json.JSONArray r8 = r1.getJSONArray(r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.util.Set r7 = b(r7, r8)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r10.set(r2, r7)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            goto L_0x027c
        L_0x01ea:
            java.lang.Class<java.util.EnumSet> r8 = java.util.EnumSet.class
            boolean r8 = r14.equals(r8)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            if (r8 == 0) goto L_0x027c
            org.json.JSONArray r8 = r1.getJSONArray(r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.util.HashSet r9 = new java.util.HashSet     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r9.<init>()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r11 = 0
        L_0x01fc:
            int r12 = r8.length()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            if (r11 >= r12) goto L_0x0210
            java.lang.String r12 = r8.getString(r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Enum r12 = java.lang.Enum.valueOf(r7, r12)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r9.add(r12)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            int r11 = r11 + 1
            goto L_0x01fc
        L_0x0210:
            r10.set(r2, r9)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            goto L_0x027c
        L_0x0214:
            java.lang.Class r7 = r10.getType()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            boolean r7 = r7.isEnum()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            if (r7 == 0) goto L_0x022c
            java.lang.Object r7 = r1.get(r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Enum r7 = java.lang.Enum.valueOf(r14, r7)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r10.set(r2, r7)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            goto L_0x027c
        L_0x022c:
            java.lang.Class r7 = r10.getType()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            boolean r7 = r7.isPrimitive()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            if (r7 == 0) goto L_0x0246
            java.lang.Object r7 = r1.get(r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Class r8 = r10.getType()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Object r7 = a(r1, r10, r7, r8)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r10.set(r2, r7)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            goto L_0x027c
        L_0x0246:
            java.lang.Class r7 = r10.getType()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            boolean r7 = r7.isArray()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            if (r7 == 0) goto L_0x0258
            java.lang.Object r7 = a(r1, r14, r10)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r10.set(r2, r7)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            goto L_0x027c
        L_0x0258:
            java.lang.Object r7 = r1.get(r11)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Class r8 = r10.getType()     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            java.lang.Object r7 = a((java.lang.Object) r7, (java.lang.Class<?>) r8)     // Catch:{ Exception -> 0x027c, all -> 0x0273 }
            r8 = 0
            boolean r9 = r7.equals(r8)     // Catch:{ Exception -> 0x027d, all -> 0x0273 }
            if (r9 == 0) goto L_0x026f
            r10.set(r2, r8)     // Catch:{ Exception -> 0x027d, all -> 0x0273 }
            goto L_0x027d
        L_0x026f:
            r10.set(r2, r7)     // Catch:{ Exception -> 0x027d, all -> 0x0273 }
            goto L_0x027d
        L_0x0273:
            r0 = move-exception
            com.startapp.common.parser.JSONStreamException r1 = new com.startapp.common.parser.JSONStreamException
            java.lang.String r2 = "Unknown error occurred "
            r1.<init>(r2, r0)
            throw r1
        L_0x027c:
            r8 = 0
        L_0x027d:
            int r4 = r4 + 1
            r7 = 1
            r8 = 0
            goto L_0x00ba
        L_0x0283:
            return r2
        L_0x0284:
            r0 = move-exception
            com.startapp.common.parser.JSONStreamException r1 = new com.startapp.common.parser.JSONStreamException
            java.lang.String r2 = "Can't deserialize the object. Failed to instantiate object."
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.g0.a(java.lang.Class, org.json.JSONObject):java.lang.Object");
    }

    public static <V> Set<V> b(Class<V> cls, JSONArray jSONArray) throws JSONException, JSONStreamException {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject == null) {
                hashSet.add(jSONArray.get(i2));
            } else {
                hashSet.add(a(cls, optJSONObject));
            }
        }
        return hashSet;
    }

    public static <T> Object a(JSONObject jSONObject, Class<T> cls, Field field) throws JSONStreamException, JSONException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException, IllegalArgumentException, NoSuchFieldException {
        Class<String> cls2;
        Object obj;
        if (cls != null) {
            JSONArray jSONArray = jSONObject.getJSONArray(p.a(field));
            int length = jSONArray.length();
            Object newInstance = Array.newInstance(cls, length);
            for (int i2 = 0; i2 < length; i2++) {
                Array.set(newInstance, i2, a(cls, jSONArray.getJSONObject(i2)));
            }
            return (Object[]) newInstance;
        }
        JSONArray jSONArray2 = jSONObject.getJSONArray(p.a(field));
        int length2 = jSONArray2.length();
        Class cls3 = f34548a.get(field.getType().getSimpleName());
        Object newInstance2 = Array.newInstance((Class) cls3.getField("TYPE").get((Object) null), length2);
        for (int i3 = 0; i3 < length2; i3++) {
            String string = jSONArray2.getString(i3);
            Class<Character> cls4 = Character.class;
            if (cls3.equals(cls4)) {
                cls2 = Character.TYPE;
            } else {
                cls2 = String.class;
            }
            Constructor constructor = cls3.getConstructor(new Class[]{cls2});
            if (cls3.equals(cls4)) {
                obj = constructor.newInstance(new Object[]{Character.valueOf(string.charAt(0))});
            } else {
                obj = constructor.newInstance(new Object[]{string});
            }
            Array.set(newInstance2, i3, obj);
        }
        return newInstance2;
    }

    public static <K, V> Map a(Class cls, Class cls2, Class cls3, JSONObject jSONObject, Iterator it2) throws JSONException, JSONStreamException {
        HashMap hashMap = new HashMap();
        while (it2.hasNext()) {
            Object next = it2.next();
            Object cast = cls.equals(Integer.class) ? cls.cast(Integer.valueOf(Integer.parseInt((String) next))) : next;
            if (cls.isEnum()) {
                cast = Enum.valueOf(cls, cast.toString());
            }
            String str = (String) next;
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray(str);
                if (optJSONArray != null) {
                    hashMap.put(cast, b(cls3, optJSONArray));
                } else if (cls2.isEnum()) {
                    hashMap.put(cast, Enum.valueOf(cls2, (String) jSONObject.get(str)));
                } else {
                    hashMap.put(cast, jSONObject.get(str));
                }
            } else {
                hashMap.put(cast, a(cls2, optJSONObject));
            }
        }
        return hashMap;
    }

    public static <V> List a(Class cls, JSONArray jSONArray) throws JSONException, JSONStreamException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject == null) {
                arrayList.add(jSONArray.get(i2));
            } else {
                arrayList.add(a(cls, optJSONObject));
            }
        }
        return arrayList;
    }

    public static Object a(Object obj, Class<?> cls) {
        if (obj.getClass().equals(cls)) {
            return obj;
        }
        Class<Integer> cls2 = Integer.class;
        Class<Long> cls3 = Long.class;
        if (!cls.equals(cls2)) {
            return (!cls.equals(cls3) || !obj.getClass().equals(cls2)) ? obj : Long.valueOf(((Integer) obj).longValue());
        }
        if (obj.getClass().equals(Double.class)) {
            return Integer.valueOf(((Double) obj).intValue());
        }
        if (obj.getClass().equals(cls3)) {
            return Integer.valueOf(((Long) obj).intValue());
        }
        return obj;
    }

    public static Object a(JSONObject jSONObject, Field field, Object obj, Class<?> cls) throws JSONException {
        if (obj.getClass().equals(cls)) {
            return obj;
        }
        if (obj.getClass().equals(String.class)) {
            if (cls.equals(Integer.TYPE)) {
                return Integer.valueOf(jSONObject.getInt(p.a(field)));
            }
            return obj;
        } else if (cls.equals(Integer.TYPE)) {
            return Integer.valueOf(((Number) obj).intValue());
        } else {
            if (cls.equals(Float.TYPE)) {
                return Float.valueOf(((Number) obj).floatValue());
            }
            if (cls.equals(Long.TYPE)) {
                return Long.valueOf(((Number) obj).longValue());
            }
            return cls.equals(Double.TYPE) ? Double.valueOf(((Number) obj).doubleValue()) : obj;
        }
    }
}
