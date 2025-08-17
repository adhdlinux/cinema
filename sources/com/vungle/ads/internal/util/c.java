package com.vungle.ads.internal.util;

import com.vungle.ads.internal.util.FileUtility;
import java.io.InputStream;
import java.io.ObjectInputStream;

public final /* synthetic */ class c implements FileUtility.ObjectInputStreamProvider {
    public final ObjectInputStream provideObjectInputStream(InputStream inputStream) {
        return FileUtility.m223objectInputStreamProvider$lambda0(inputStream);
    }
}
