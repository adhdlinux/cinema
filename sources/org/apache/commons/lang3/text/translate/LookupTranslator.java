package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;

@Deprecated
public class LookupTranslator extends CharSequenceTranslator {

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, String> f41452b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashSet<Character> f41453c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private final int f41454d;

    /* renamed from: e  reason: collision with root package name */
    private final int f41455e;

    public LookupTranslator(CharSequence[]... charSequenceArr) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        if (charSequenceArr != null) {
            int i4 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.f41452b.put(charSequenceArr2[0].toString(), charSequenceArr2[1].toString());
                this.f41453c.add(Character.valueOf(charSequenceArr2[0].charAt(0)));
                int length = charSequenceArr2[0].length();
                i2 = length < i2 ? length : i2;
                if (length > i4) {
                    i4 = length;
                }
            }
            i3 = i4;
        }
        this.f41454d = i2;
        this.f41455e = i3;
    }

    public int b(CharSequence charSequence, int i2, Writer writer) throws IOException {
        if (!this.f41453c.contains(Character.valueOf(charSequence.charAt(i2)))) {
            return 0;
        }
        int i3 = this.f41455e;
        if (i2 + i3 > charSequence.length()) {
            i3 = charSequence.length() - i2;
        }
        while (i3 >= this.f41454d) {
            String str = this.f41452b.get(charSequence.subSequence(i2, i2 + i3).toString());
            if (str != null) {
                writer.write(str);
                return i3;
            }
            i3--;
        }
        return 0;
    }
}
