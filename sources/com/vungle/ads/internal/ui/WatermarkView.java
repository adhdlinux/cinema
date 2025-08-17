package com.vungle.ads.internal.ui;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

public class WatermarkView extends ImageView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WatermarkView(Context context, String str) {
        super(context);
        Intrinsics.f(context, "context");
        Intrinsics.f(str, "watermark");
        byte[] decode = Base64.decode(str, 0);
        Intrinsics.e(decode, "overlayBytes");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray(decode, 0, decode.length));
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        bitmapDrawable.setTileModeXY(tileMode, tileMode);
        bitmapDrawable.setTargetDensity(context.getResources().getDisplayMetrics());
        setBackground(bitmapDrawable);
        setClickable(false);
        setFocusable(false);
    }
}
