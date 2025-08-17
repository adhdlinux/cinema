package com.google.protobuf;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.protobuf.GeneratedMessageLite;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final char[] INDENT_BUFFER;
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    static {
        char[] cArr = new char[80];
        INDENT_BUFFER = cArr;
        Arrays.fill(cArr, ' ');
    }

    private MessageLiteToString() {
    }

    private static void indent(int i2, StringBuilder sb) {
        int i3;
        while (i2 > 0) {
            char[] cArr = INDENT_BUFFER;
            if (i2 > cArr.length) {
                i3 = cArr.length;
            } else {
                i3 = i2;
            }
            sb.append(cArr, 0, i3);
            i2 -= i3;
        }
    }

    private static boolean isDefaultValue(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Float) {
            if (Float.floatToRawIntBits(((Float) obj).floatValue()) == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Double) {
            if (Double.doubleToRawLongBits(((Double) obj).doubleValue()) == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof String) {
            return obj.equals("");
        } else {
            if (obj instanceof ByteString) {
                return obj.equals(ByteString.EMPTY);
            }
            if (obj instanceof MessageLite) {
                if (obj == ((MessageLite) obj).getDefaultInstanceForType()) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof Enum) || ((Enum) obj).ordinal() != 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    private static String pascalCaseToSnakeCase(String str) {
        if (str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(str.charAt(0)));
        for (int i2 = 1; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    static void printField(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object printField : (List) obj) {
                printField(sb, i2, str, printField);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry printField2 : ((Map) obj).entrySet()) {
                printField(sb, i2, str, printField2);
            }
        } else {
            sb.append(10);
            indent(i2, sb);
            sb.append(pascalCaseToSnakeCase(str));
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(TextFormatEscaper.escapeText((String) obj));
                sb.append('\"');
            } else if (obj instanceof ByteString) {
                sb.append(": \"");
                sb.append(TextFormatEscaper.escapeBytes((ByteString) obj));
                sb.append('\"');
            } else if (obj instanceof GeneratedMessageLite) {
                sb.append(" {");
                reflectivePrintWithIndent((GeneratedMessageLite) obj, sb, i2 + 2);
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                indent(i2, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i3 = i2 + 2;
                printField(sb, i3, "key", entry.getKey());
                printField(sb, i3, AppMeasurementSdk.ConditionalUserProperty.VALUE, entry.getValue());
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                indent(i2, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static void reflectivePrintWithIndent(MessageLite messageLite, StringBuilder sb, int i2) {
        int i3;
        boolean z2;
        Method method;
        Method method2;
        MessageLite messageLite2 = messageLite;
        StringBuilder sb2 = sb;
        int i4 = i2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = messageLite.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i5 = 0;
        while (true) {
            i3 = 3;
            if (i5 >= length) {
                break;
            }
            Method method3 = declaredMethods[i5];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i5++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i3);
            if (substring.endsWith(LIST_SUFFIX) && !substring.endsWith(BUILDER_LIST_SUFFIX) && !substring.equals(LIST_SUFFIX) && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                printField(sb2, i4, substring.substring(0, substring.length() - 4), GeneratedMessageLite.invokeOrDie(method2, messageLite2, new Object[0]));
            } else if (!substring.endsWith(MAP_SUFFIX) || substring.equals(MAP_SUFFIX) || (method = (Method) entry.getValue()) == null || !method.getReturnType().equals(Map.class) || method.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method.getModifiers())) {
                if (hashSet.contains("set" + substring)) {
                    if (substring.endsWith(BYTES_SUFFIX)) {
                        if (treeMap.containsKey("get" + substring.substring(0, substring.length() - 5))) {
                        }
                    }
                    Method method4 = (Method) entry.getValue();
                    Method method5 = (Method) hashMap.get("has" + substring);
                    if (method4 != null) {
                        Object invokeOrDie = GeneratedMessageLite.invokeOrDie(method4, messageLite2, new Object[0]);
                        if (method5 != null) {
                            z2 = ((Boolean) GeneratedMessageLite.invokeOrDie(method5, messageLite2, new Object[0])).booleanValue();
                        } else if (!isDefaultValue(invokeOrDie)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            printField(sb2, i4, substring, invokeOrDie);
                        }
                    }
                }
            } else {
                printField(sb2, i4, substring.substring(0, substring.length() - 3), GeneratedMessageLite.invokeOrDie(method, messageLite2, new Object[0]));
            }
            i3 = 3;
        }
        if (messageLite2 instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> it2 = ((GeneratedMessageLite.ExtendableMessage) messageLite2).extensions.iterator();
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                printField(sb2, i4, "[" + ((GeneratedMessageLite.ExtensionDescriptor) next.getKey()).getNumber() + "]", next.getValue());
            }
        }
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) messageLite2).unknownFields;
        if (unknownFieldSetLite != null) {
            unknownFieldSetLite.printWithIndent(sb2, i4);
        }
    }

    static String toString(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        reflectivePrintWithIndent(messageLite, sb, 0);
        return sb.toString();
    }
}
