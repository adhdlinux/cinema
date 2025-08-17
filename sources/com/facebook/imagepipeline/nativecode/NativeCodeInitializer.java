package com.facebook.imagepipeline.nativecode;

import android.content.Context;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.soloader.SoLoader;
import java.io.IOException;

@Nullsafe(Nullsafe.Mode.LOCAL)
@DoNotStrip
public class NativeCodeInitializer {
    @DoNotStrip
    public static void init(Context context) throws IOException {
        SoLoader.init(context, 0);
    }
}
