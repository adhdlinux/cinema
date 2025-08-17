package com.facebook.imagepipeline.nativecode;

import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.infer.annotation.Nullsafe;
import java.lang.reflect.InvocationTargetException;

@Nullsafe(Nullsafe.Mode.STRICT)
public final class NativeImageTranscoderFactory {
    private NativeImageTranscoderFactory() {
    }

    public static ImageTranscoderFactory getNativeImageTranscoderFactory(int i2, boolean z2, boolean z3) {
        Class<NativeJpegTranscoderFactory> cls = NativeJpegTranscoderFactory.class;
        try {
            Class cls2 = Boolean.TYPE;
            return cls.getConstructor(new Class[]{Integer.TYPE, cls2, cls2}).newInstance(new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z3)});
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e2);
        }
    }
}
