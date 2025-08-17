package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
public abstract class CodePointTranslator extends CharSequenceTranslator {
    public final int b(CharSequence charSequence, int i2, Writer writer) throws IOException {
        return f(Character.codePointAt(charSequence, i2), writer) ? 1 : 0;
    }

    public abstract boolean f(int i2, Writer writer) throws IOException;
}
