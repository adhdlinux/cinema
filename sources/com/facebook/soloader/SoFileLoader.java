package com.facebook.soloader;

public interface SoFileLoader {
    void load(String str, int i2);

    void loadBytes(String str, ElfByteChannel elfByteChannel, int i2);
}
