package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.EnumSet;

@Deprecated
public class NumericEntityUnescaper extends CharSequenceTranslator {

    /* renamed from: b  reason: collision with root package name */
    private final EnumSet<OPTION> f41459b;

    public enum OPTION {
        semiColonRequired,
        semiColonOptional,
        errorIfNoSemiColon
    }

    public NumericEntityUnescaper(OPTION... optionArr) {
        if (optionArr.length > 0) {
            this.f41459b = EnumSet.copyOf(Arrays.asList(optionArr));
            return;
        }
        this.f41459b = EnumSet.copyOf(Arrays.asList(new OPTION[]{OPTION.semiColonRequired}));
    }

    public int b(CharSequence charSequence, int i2, Writer writer) throws IOException {
        int i3;
        int i4;
        int i5;
        int length = charSequence.length();
        if (charSequence.charAt(i2) == '&' && i2 < length - 2 && charSequence.charAt(i2 + 1) == '#') {
            int i6 = i2 + 2;
            char charAt = charSequence.charAt(i6);
            if (charAt == 'x' || charAt == 'X') {
                i6++;
                if (i6 == length) {
                    return 0;
                }
                i3 = 1;
            } else {
                i3 = 0;
            }
            int i7 = i6;
            while (i7 < length && ((charSequence.charAt(i7) >= '0' && charSequence.charAt(i7) <= '9') || ((charSequence.charAt(i7) >= 'a' && charSequence.charAt(i7) <= 'f') || (charSequence.charAt(i7) >= 'A' && charSequence.charAt(i7) <= 'F')))) {
                i7++;
            }
            if (i7 == length || charSequence.charAt(i7) != ';') {
                i4 = 0;
            } else {
                i4 = 1;
            }
            if (i4 == 0) {
                if (f(OPTION.semiColonRequired)) {
                    return 0;
                }
                if (f(OPTION.errorIfNoSemiColon)) {
                    throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
                }
            }
            if (i3 != 0) {
                try {
                    i5 = Integer.parseInt(charSequence.subSequence(i6, i7).toString(), 16);
                } catch (NumberFormatException unused) {
                }
            } else {
                i5 = Integer.parseInt(charSequence.subSequence(i6, i7).toString(), 10);
            }
            if (i5 > 65535) {
                char[] chars = Character.toChars(i5);
                writer.write(chars[0]);
                writer.write(chars[1]);
            } else {
                writer.write(i5);
            }
            return ((i7 + 2) - i6) + i3 + i4;
        }
        return 0;
    }

    public boolean f(OPTION option) {
        EnumSet<OPTION> enumSet = this.f41459b;
        return enumSet != null && enumSet.contains(option);
    }
}
