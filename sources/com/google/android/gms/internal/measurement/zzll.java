package com.google.android.gms.internal.measurement;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class zzll {
    static String zza(zzlj zzlj, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzlj, sb, 0);
        return sb.toString();
    }

    static final void zzb(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i2, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i2, str, zzb2);
            }
        } else {
            sb.append(10);
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzmj.zza(zzjb.zzm((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzjb) {
                sb.append(": \"");
                sb.append(zzmj.zza((zzjb) obj));
                sb.append('\"');
            } else if (obj instanceof zzkc) {
                sb.append(" {");
                zzd((zzkc) obj, sb, i2 + 2);
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i5 = i2 + 2;
                zzb(sb, i5, "key", entry.getKey());
                zzb(sb, i5, AppMeasurementSdk.ConditionalUserProperty.VALUE, entry.getValue());
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static final String zzc(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static void zzd(zzlj zzlj, StringBuilder sb, int i2) {
        String str;
        boolean z2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : zzlj.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str2 : treeSet) {
            if (str2.startsWith("get")) {
                str = str2.substring(3);
            } else {
                str = str2;
            }
            if (str.endsWith("List") && !str.endsWith("OrBuilderList") && !str.equals("List")) {
                String concat = String.valueOf(str.substring(0, 1).toLowerCase()).concat(String.valueOf(str.substring(1, str.length() - 4)));
                Method method2 = (Method) hashMap.get(str2);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i2, zzc(concat), zzkc.zzbK(method2, zzlj, new Object[0]));
                }
            }
            if (str.endsWith("Map") && !str.equals("Map")) {
                String concat2 = String.valueOf(str.substring(0, 1).toLowerCase()).concat(String.valueOf(str.substring(1, str.length() - 3)));
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i2, zzc(concat2), zzkc.zzbK(method3, zzlj, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set".concat(str))) != null && (!str.endsWith("Bytes") || !hashMap.containsKey("get".concat(String.valueOf(str.substring(0, str.length() - 5)))))) {
                String concat3 = String.valueOf(str.substring(0, 1).toLowerCase()).concat(String.valueOf(str.substring(1)));
                Method method4 = (Method) hashMap.get("get".concat(str));
                Method method5 = (Method) hashMap.get("has".concat(str));
                if (method4 != null) {
                    Object zzbK = zzkc.zzbK(method4, zzlj, new Object[0]);
                    if (method5 == null) {
                        if (zzbK instanceof Boolean) {
                            if (!((Boolean) zzbK).booleanValue()) {
                            }
                        } else if (zzbK instanceof Integer) {
                            if (((Integer) zzbK).intValue() == 0) {
                            }
                        } else if (zzbK instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzbK).floatValue()) == 0) {
                            }
                        } else if (!(zzbK instanceof Double)) {
                            if (zzbK instanceof String) {
                                z2 = zzbK.equals("");
                            } else if (zzbK instanceof zzjb) {
                                z2 = zzbK.equals(zzjb.zzb);
                            } else if (zzbK instanceof zzlj) {
                                if (zzbK == ((zzlj) zzbK).zzbR()) {
                                }
                            } else if ((zzbK instanceof Enum) && ((Enum) zzbK).ordinal() == 0) {
                            }
                            if (z2) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzbK).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzkc.zzbK(method5, zzlj, new Object[0])).booleanValue()) {
                    }
                    zzb(sb, i2, zzc(concat3), zzbK);
                }
            }
        }
        if (!(zzlj instanceof zzjz)) {
            zzmm zzmm = ((zzkc) zzlj).zzc;
            if (zzmm != null) {
                zzmm.zzg(sb, i2);
                return;
            }
            return;
        }
        zzjz zzjz = (zzjz) zzlj;
        throw null;
    }
}
