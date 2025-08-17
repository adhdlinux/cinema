package org.apache.commons.lang3.text.translate;

@Deprecated
public class JavaUnicodeEscaper extends UnicodeEscaper {
    public JavaUnicodeEscaper(int i2, int i3, boolean z2) {
        super(i2, i3, z2);
    }

    public static JavaUnicodeEscaper h(int i2, int i3) {
        return new JavaUnicodeEscaper(i2, i3, false);
    }

    /* access modifiers changed from: protected */
    public String g(int i2) {
        char[] chars = Character.toChars(i2);
        return "\\u" + CharSequenceTranslator.a(chars[0]) + "\\u" + CharSequenceTranslator.a(chars[1]);
    }
}
