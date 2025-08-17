package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;

public class FileDecoder implements ResourceDecoder<File, File> {
    /* renamed from: c */
    public Resource<File> b(File file, int i2, int i3, Options options) {
        return new FileResource(file);
    }

    /* renamed from: d */
    public boolean a(File file, Options options) {
        return true;
    }
}
