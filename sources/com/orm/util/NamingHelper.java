package com.orm.util;

import com.orm.dsl.Column;
import com.orm.dsl.Table;
import java.lang.reflect.Field;

public class NamingHelper {
    public static String a(Class<?> cls) {
        Class<Table> cls2 = Table.class;
        if (!cls.isAnnotationPresent(cls2)) {
            return c(cls.getSimpleName());
        }
        Table table = (Table) cls.getAnnotation(cls2);
        if ("".equals(table.name())) {
            return c(cls.getSimpleName());
        }
        return table.name();
    }

    public static String b(Field field) {
        Class cls = Column.class;
        if (field.isAnnotationPresent(cls)) {
            return ((Column) field.getAnnotation(cls)).name();
        }
        return c(field.getName());
    }

    public static String c(String str) {
        char c2;
        char c3;
        if (str.equalsIgnoreCase("_id")) {
            return "_id";
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (i2 > 0) {
                c2 = charArray[i2 - 1];
            } else {
                c2 = 0;
            }
            char c4 = charArray[i2];
            boolean z2 = true;
            if (i2 < charArray.length - 1) {
                c3 = charArray[i2 + 1];
            } else {
                c3 = 0;
            }
            if (i2 != 0) {
                z2 = false;
            }
            if (z2 || Character.isLowerCase(c4) || Character.isDigit(c4)) {
                sb.append(Character.toUpperCase(c4));
            } else if (Character.isUpperCase(c4)) {
                if (!Character.isLetterOrDigit(c2)) {
                    sb.append(c4);
                } else if (Character.isLowerCase(c2)) {
                    sb.append('_');
                    sb.append(c4);
                } else if (c3 <= 0 || !Character.isLowerCase(c3)) {
                    sb.append(c4);
                } else {
                    sb.append('_');
                    sb.append(c4);
                }
            }
        }
        return sb.toString();
    }
}
