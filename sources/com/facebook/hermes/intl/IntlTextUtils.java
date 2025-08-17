package com.facebook.hermes.intl;

public class IntlTextUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static boolean isASCIIDigit(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean isASCIILetter(char c2) {
        return (c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z');
    }

    public static boolean isASCIILetterOrDigit(char c2) {
        return isASCIILetter(c2) || isASCIIDigit(c2);
    }

    public static boolean isAlpha(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        int i6;
        if (i3 >= charSequence.length() || (i6 = (i3 - i2) + 1) < i4 || i6 > i5) {
            return false;
        }
        while (i2 <= i3) {
            if (!isASCIILetter(charSequence.charAt(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static boolean isAlphaNum(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        int i6;
        if (i3 >= charSequence.length() || (i6 = (i3 - i2) + 1) < i4 || i6 > i5) {
            return false;
        }
        while (i2 <= i3) {
            if (!isASCIILetterOrDigit(charSequence.charAt(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static boolean isDigit(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        int i6;
        if (i3 >= charSequence.length() || (i6 = (i3 - i2) + 1) < i4 || i6 > i5) {
            return false;
        }
        while (i2 <= i3) {
            if (!isASCIIDigit(charSequence.charAt(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static boolean isDigitAlphanum3(CharSequence charSequence, int i2, int i3) {
        if ((i3 - i2) + 1 != 4 || !isASCIILetter(charSequence.charAt(i2)) || !isAlphaNum(charSequence, i2 + 1, i3, 3, 3)) {
            return false;
        }
        return true;
    }

    public static boolean isExtensionSingleton(CharSequence charSequence, int i2, int i3) {
        return isAlphaNum(charSequence, i2, i3, 1, 1);
    }

    public static boolean isOtherExtension(CharSequence charSequence, int i2, int i3) {
        return isAlphaNum(charSequence, i2, i3, 2, 8);
    }

    public static boolean isPrivateUseExtension(CharSequence charSequence, int i2, int i3) {
        return isAlphaNum(charSequence, i2, i3, 1, 8);
    }

    public static boolean isTranformedExtensionTKey(CharSequence charSequence, int i2, int i3) {
        return i3 == i2 + 1 && isASCIILetter(charSequence.charAt(i2)) && isASCIIDigit(charSequence.charAt(i3));
    }

    public static boolean isTranformedExtensionTValueItem(CharSequence charSequence, int i2, int i3) {
        return isAlphaNum(charSequence, i2, i3, 3, 8);
    }

    public static boolean isUnicodeExtensionAttribute(CharSequence charSequence, int i2, int i3) {
        return isAlphaNum(charSequence, i2, i3, 3, 8);
    }

    public static boolean isUnicodeExtensionKey(CharSequence charSequence, int i2, int i3) {
        return i3 == i2 + 1 && isASCIILetterOrDigit(charSequence.charAt(i2)) && isASCIILetter(charSequence.charAt(i3));
    }

    public static boolean isUnicodeExtensionKeyTypeItem(CharSequence charSequence, int i2, int i3) {
        return isAlphaNum(charSequence, i2, i3, 3, 8);
    }

    public static boolean isUnicodeLanguageSubtag(CharSequence charSequence, int i2, int i3) {
        if (isAlpha(charSequence, i2, i3, 2, 3) || isAlpha(charSequence, i2, i3, 5, 8)) {
            return true;
        }
        if ((i3 - i2) + 1 == 4 && charSequence.charAt(i2) == 'r' && charSequence.charAt(i2 + 1) == 'o' && charSequence.charAt(i2 + 2) == 'o' && charSequence.charAt(i2 + 3) == 't') {
            return true;
        }
        return false;
    }

    public static boolean isUnicodeRegionSubtag(CharSequence charSequence, int i2, int i3) {
        return isAlpha(charSequence, i2, i3, 2, 2) || isDigit(charSequence, i2, i3, 3, 3);
    }

    public static boolean isUnicodeScriptSubtag(CharSequence charSequence, int i2, int i3) {
        return isAlpha(charSequence, i2, i3, 4, 4);
    }

    public static boolean isUnicodeVariantSubtag(CharSequence charSequence, int i2, int i3) {
        return isAlphaNum(charSequence, i2, i3, 5, 8) || isDigitAlphanum3(charSequence, i2, i3);
    }
}
