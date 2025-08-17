package org.threeten.bp.format;

import com.facebook.hermes.intl.Constants;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class DecimalStyle {
    private static final ConcurrentMap<Locale, DecimalStyle> CACHE = new ConcurrentHashMap(16, 0.75f, 2);
    public static final DecimalStyle STANDARD = new DecimalStyle('0', '+', '-', '.');
    private final char decimalSeparator;
    private final char negativeSign;
    private final char positiveSign;
    private final char zeroDigit;

    private DecimalStyle(char c2, char c3, char c4, char c5) {
        this.zeroDigit = c2;
        this.positiveSign = c3;
        this.negativeSign = c4;
        this.decimalSeparator = c5;
    }

    private static DecimalStyle create(Locale locale) {
        DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance(locale);
        char zeroDigit2 = instance.getZeroDigit();
        char minusSign = instance.getMinusSign();
        char decimalSeparator2 = instance.getDecimalSeparator();
        if (zeroDigit2 == '0' && minusSign == '-' && decimalSeparator2 == '.') {
            return STANDARD;
        }
        return new DecimalStyle(zeroDigit2, '+', minusSign, decimalSeparator2);
    }

    public static Set<Locale> getAvailableLocales() {
        return new HashSet(Arrays.asList(DecimalFormatSymbols.getAvailableLocales()));
    }

    public static DecimalStyle of(Locale locale) {
        Jdk8Methods.requireNonNull(locale, Constants.LOCALE);
        ConcurrentMap<Locale, DecimalStyle> concurrentMap = CACHE;
        DecimalStyle decimalStyle = concurrentMap.get(locale);
        if (decimalStyle != null) {
            return decimalStyle;
        }
        concurrentMap.putIfAbsent(locale, create(locale));
        return concurrentMap.get(locale);
    }

    public static DecimalStyle ofDefaultLocale() {
        return of(Locale.getDefault());
    }

    /* access modifiers changed from: package-private */
    public String convertNumberToI18N(String str) {
        char c2 = this.zeroDigit;
        if (c2 == '0') {
            return str;
        }
        int i2 = c2 - '0';
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            charArray[i3] = (char) (charArray[i3] + i2);
        }
        return new String(charArray);
    }

    /* access modifiers changed from: package-private */
    public int convertToDigit(char c2) {
        int i2 = c2 - this.zeroDigit;
        if (i2 < 0 || i2 > 9) {
            return -1;
        }
        return i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecimalStyle)) {
            return false;
        }
        DecimalStyle decimalStyle = (DecimalStyle) obj;
        if (this.zeroDigit == decimalStyle.zeroDigit && this.positiveSign == decimalStyle.positiveSign && this.negativeSign == decimalStyle.negativeSign && this.decimalSeparator == decimalStyle.decimalSeparator) {
            return true;
        }
        return false;
    }

    public char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public char getNegativeSign() {
        return this.negativeSign;
    }

    public char getPositiveSign() {
        return this.positiveSign;
    }

    public char getZeroDigit() {
        return this.zeroDigit;
    }

    public int hashCode() {
        return this.zeroDigit + this.positiveSign + this.negativeSign + this.decimalSeparator;
    }

    public String toString() {
        return "DecimalStyle[" + this.zeroDigit + this.positiveSign + this.negativeSign + this.decimalSeparator + "]";
    }

    public DecimalStyle withDecimalSeparator(char c2) {
        if (c2 == this.decimalSeparator) {
            return this;
        }
        return new DecimalStyle(this.zeroDigit, this.positiveSign, this.negativeSign, c2);
    }

    public DecimalStyle withNegativeSign(char c2) {
        if (c2 == this.negativeSign) {
            return this;
        }
        return new DecimalStyle(this.zeroDigit, this.positiveSign, c2, this.decimalSeparator);
    }

    public DecimalStyle withPositiveSign(char c2) {
        if (c2 == this.positiveSign) {
            return this;
        }
        return new DecimalStyle(this.zeroDigit, c2, this.negativeSign, this.decimalSeparator);
    }

    public DecimalStyle withZeroDigit(char c2) {
        if (c2 == this.zeroDigit) {
            return this;
        }
        return new DecimalStyle(c2, this.positiveSign, this.negativeSign, this.decimalSeparator);
    }
}
