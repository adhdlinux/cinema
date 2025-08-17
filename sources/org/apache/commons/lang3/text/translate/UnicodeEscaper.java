package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
public class UnicodeEscaper extends CodePointTranslator {

    /* renamed from: b  reason: collision with root package name */
    private final int f41464b;

    /* renamed from: c  reason: collision with root package name */
    private final int f41465c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f41466d;

    public UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    public boolean f(int i2, Writer writer) throws IOException {
        if (this.f41466d) {
            if (i2 < this.f41464b || i2 > this.f41465c) {
                return false;
            }
        } else if (i2 >= this.f41464b && i2 <= this.f41465c) {
            return false;
        }
        if (i2 > 65535) {
            writer.write(g(i2));
            return true;
        }
        writer.write("\\u");
        char[] cArr = CharSequenceTranslator.f41441a;
        writer.write(cArr[(i2 >> 12) & 15]);
        writer.write(cArr[(i2 >> 8) & 15]);
        writer.write(cArr[(i2 >> 4) & 15]);
        writer.write(cArr[i2 & 15]);
        return true;
    }

    /* access modifiers changed from: protected */
    public String g(int i2) {
        return "\\u" + CharSequenceTranslator.a(i2);
    }

    protected UnicodeEscaper(int i2, int i3, boolean z2) {
        this.f41464b = i2;
        this.f41465c = i3;
        this.f41466d = z2;
    }
}
