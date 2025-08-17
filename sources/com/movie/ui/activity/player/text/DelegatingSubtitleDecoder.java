package com.movie.ui.activity.player.text;

import androidx.media3.extractor.text.SimpleSubtitleDecoder;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import kotlin.jvm.internal.Intrinsics;

public final class DelegatingSubtitleDecoder extends SimpleSubtitleDecoder {

    /* renamed from: p  reason: collision with root package name */
    private final SubtitleParser f32470p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DelegatingSubtitleDecoder(String str, SubtitleParser subtitleParser) {
        super(str);
        Intrinsics.f(str, "name");
        Intrinsics.f(subtitleParser, "subtitleParser");
        this.f32470p = subtitleParser;
    }

    /* access modifiers changed from: protected */
    public Subtitle B(byte[] bArr, int i2, boolean z2) {
        Intrinsics.f(bArr, "data");
        if (z2) {
            this.f32470p.reset();
        }
        Subtitle b2 = this.f32470p.b(bArr, 0, i2);
        Intrinsics.e(b2, "parseToLegacySubtitle(...)");
        return b2;
    }

    public final SubtitleParser D() {
        return this.f32470p;
    }
}
