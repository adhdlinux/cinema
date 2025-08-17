package com.movie.ui.activity.player.text;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.text.SubtitleDecoderFactory;
import androidx.media3.extractor.text.SubtitleDecoder;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class CustomSubtitleDecoderFactory implements SubtitleDecoderFactory {

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Unit> f32469b;

    public CustomSubtitleDecoderFactory() {
        this((Function0) null, 1, (DefaultConstructorMarker) null);
    }

    public CustomSubtitleDecoderFactory(Function0<Unit> function0) {
        this.f32469b = function0;
    }

    public SubtitleDecoder a(Format format) {
        Intrinsics.f(format, "format");
        return new CustomDecoder(format, this.f32469b);
    }

    public boolean c(Format format) {
        Intrinsics.f(format, "format");
        return CollectionsKt___CollectionsKt.z(CollectionsKt__CollectionsKt.i("text/vtt", "text/x-ssa", "application/ttml+xml", "application/x-mp4-vtt", "application/x-subrip"), format.f4015n);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomSubtitleDecoderFactory(Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : function0);
    }
}
