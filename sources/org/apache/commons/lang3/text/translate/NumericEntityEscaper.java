package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
public class NumericEntityEscaper extends CodePointTranslator {

    /* renamed from: b  reason: collision with root package name */
    private final int f41456b;

    /* renamed from: c  reason: collision with root package name */
    private final int f41457c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f41458d;

    private NumericEntityEscaper(int i2, int i3, boolean z2) {
        this.f41456b = i2;
        this.f41457c = i3;
        this.f41458d = z2;
    }

    public static NumericEntityEscaper g(int i2, int i3) {
        return new NumericEntityEscaper(i2, i3, true);
    }

    public boolean f(int i2, Writer writer) throws IOException {
        if (this.f41458d) {
            if (i2 < this.f41456b || i2 > this.f41457c) {
                return false;
            }
        } else if (i2 >= this.f41456b && i2 <= this.f41457c) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i2, 10));
        writer.write(59);
        return true;
    }

    public NumericEntityEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }
}
