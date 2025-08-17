package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.ArrayUtils;

@Deprecated
public class AggregateTranslator extends CharSequenceTranslator {

    /* renamed from: b  reason: collision with root package name */
    private final CharSequenceTranslator[] f41440b;

    public AggregateTranslator(CharSequenceTranslator... charSequenceTranslatorArr) {
        this.f41440b = (CharSequenceTranslator[]) ArrayUtils.a(charSequenceTranslatorArr);
    }

    public int b(CharSequence charSequence, int i2, Writer writer) throws IOException {
        for (CharSequenceTranslator b2 : this.f41440b) {
            int b3 = b2.b(charSequence, i2, writer);
            if (b3 != 0) {
                return b3;
            }
        }
        return 0;
    }
}
