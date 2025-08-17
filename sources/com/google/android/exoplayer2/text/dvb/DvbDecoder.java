package com.google.android.exoplayer2.text.dvb;

import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

public final class DvbDecoder extends SimpleSubtitleDecoder {

    /* renamed from: o  reason: collision with root package name */
    private final DvbParser f27364o;

    public DvbDecoder(List<byte[]> list) {
        super("DvbDecoder");
        ParsableByteArray parsableByteArray = new ParsableByteArray(list.get(0));
        this.f27364o = new DvbParser(parsableByteArray.N(), parsableByteArray.N());
    }

    /* access modifiers changed from: protected */
    public Subtitle z(byte[] bArr, int i2, boolean z2) {
        if (z2) {
            this.f27364o.r();
        }
        return new DvbSubtitle(this.f27364o.b(bArr, i2));
    }
}
