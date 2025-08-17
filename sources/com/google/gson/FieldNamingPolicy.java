package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

public enum FieldNamingPolicy implements FieldNamingStrategy {
    IDENTITY {
        public String a(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public String a(Field field) {
            return FieldNamingPolicy.c(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public String a(Field field) {
            return FieldNamingPolicy.c(FieldNamingPolicy.b(field.getName(), ' '));
        }
    },
    UPPER_CASE_WITH_UNDERSCORES {
        public String a(Field field) {
            return FieldNamingPolicy.b(field.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public String a(Field field) {
            return FieldNamingPolicy.b(field.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        public String a(Field field) {
            return FieldNamingPolicy.b(field.getName(), '-').toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS {
        public String a(Field field) {
            return FieldNamingPolicy.b(field.getName(), '.').toLowerCase(Locale.ENGLISH);
        }
    };

    static String b(String str, char c2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(c2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String c(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (!Character.isLetter(charAt)) {
                i2++;
            } else if (Character.isUpperCase(charAt)) {
                return str;
            } else {
                char upperCase = Character.toUpperCase(charAt);
                if (i2 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i2) + upperCase + str.substring(i2 + 1);
            }
        }
        return str;
    }
}
