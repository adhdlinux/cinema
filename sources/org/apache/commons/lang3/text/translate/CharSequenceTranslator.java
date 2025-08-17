package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

@Deprecated
public abstract class CharSequenceTranslator {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f41441a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(int i2) {
        return Integer.toHexString(i2).toUpperCase(Locale.ENGLISH);
    }

    public abstract int b(CharSequence charSequence, int i2, Writer writer) throws IOException;

    public final String c(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            d(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final void d(CharSequence charSequence, Writer writer) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (charSequence != null) {
            int length = charSequence.length();
            int i2 = 0;
            while (i2 < length) {
                int b2 = b(charSequence, i2, writer);
                if (b2 == 0) {
                    char charAt = charSequence.charAt(i2);
                    writer.write(charAt);
                    i2++;
                    if (Character.isHighSurrogate(charAt) && i2 < length) {
                        char charAt2 = charSequence.charAt(i2);
                        if (Character.isLowSurrogate(charAt2)) {
                            writer.write(charAt2);
                            i2++;
                        }
                    }
                } else {
                    for (int i3 = 0; i3 < b2; i3++) {
                        i2 += Character.charCount(Character.codePointAt(charSequence, i2));
                    }
                }
            }
        }
    }

    public final CharSequenceTranslator e(CharSequenceTranslator... charSequenceTranslatorArr) {
        CharSequenceTranslator[] charSequenceTranslatorArr2 = new CharSequenceTranslator[(charSequenceTranslatorArr.length + 1)];
        charSequenceTranslatorArr2[0] = this;
        System.arraycopy(charSequenceTranslatorArr, 0, charSequenceTranslatorArr2, 1, charSequenceTranslatorArr.length);
        return new AggregateTranslator(charSequenceTranslatorArr2);
    }
}
