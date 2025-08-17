package com.startapp.simple.bloomfilter.codec;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

public class StringBuilderWriter extends Writer implements Serializable {
    private static final long serialVersionUID = -8956169446715407818L;
    private final StringBuilder builder;

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    public Writer append(char c2) {
        this.builder.append(c2);
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        return this.builder.toString();
    }

    public void write(String str) {
        if (str != null) {
            this.builder.append(str);
        }
    }

    /* renamed from: append  reason: collision with other method in class */
    public Appendable m108append(char c2) throws IOException {
        this.builder.append(c2);
        return this;
    }

    public void write(char[] cArr, int i2, int i3) {
        if (cArr != null) {
            this.builder.append(cArr, i2, i3);
        }
    }

    public StringBuilderWriter(int i2) {
        this.builder = new StringBuilder(i2);
    }

    public Writer append(CharSequence charSequence) {
        this.builder.append(charSequence);
        return this;
    }

    /* renamed from: append  reason: collision with other method in class */
    public Appendable m109append(CharSequence charSequence) throws IOException {
        this.builder.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i2, int i3) {
        this.builder.append(charSequence, i2, i3);
        return this;
    }

    /* renamed from: append  reason: collision with other method in class */
    public Appendable m110append(CharSequence charSequence, int i2, int i3) throws IOException {
        this.builder.append(charSequence, i2, i3);
        return this;
    }
}
