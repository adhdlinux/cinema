package com.bumptech.glide.provider;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

public final class ImageHeaderParserRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f17009a = new ArrayList();

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.f17009a.add(imageHeaderParser);
    }

    public synchronized List<ImageHeaderParser> b() {
        return this.f17009a;
    }
}
