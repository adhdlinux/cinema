package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
public class UnicodeUnpairedSurrogateRemover extends CodePointTranslator {
    public boolean f(int i2, Writer writer) throws IOException {
        return i2 >= 55296 && i2 <= 57343;
    }
}
