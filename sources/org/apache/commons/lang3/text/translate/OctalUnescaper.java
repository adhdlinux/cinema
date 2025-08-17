package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
public class OctalUnescaper extends CharSequenceTranslator {
    private boolean f(char c2) {
        return c2 >= '0' && c2 <= '7';
    }

    private boolean g(char c2) {
        return c2 >= '0' && c2 <= '3';
    }

    public int b(CharSequence charSequence, int i2, Writer writer) throws IOException {
        int length = (charSequence.length() - i2) - 1;
        StringBuilder sb = new StringBuilder();
        if (charSequence.charAt(i2) != '\\' || length <= 0) {
            return 0;
        }
        int i3 = i2 + 1;
        if (!f(charSequence.charAt(i3))) {
            return 0;
        }
        int i4 = i2 + 2;
        int i5 = i2 + 3;
        sb.append(charSequence.charAt(i3));
        if (length > 1 && f(charSequence.charAt(i4))) {
            sb.append(charSequence.charAt(i4));
            if (length > 2 && g(charSequence.charAt(i3)) && f(charSequence.charAt(i5))) {
                sb.append(charSequence.charAt(i5));
            }
        }
        writer.write(Integer.parseInt(sb.toString(), 8));
        return sb.length() + 1;
    }
}
