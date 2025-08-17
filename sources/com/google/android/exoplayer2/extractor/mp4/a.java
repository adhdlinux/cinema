package com.google.android.exoplayer2.extractor.mp4;

import com.google.common.base.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentedMp4Extractor f24701b;

    public /* synthetic */ a(FragmentedMp4Extractor fragmentedMp4Extractor) {
        this.f24701b = fragmentedMp4Extractor;
    }

    public final Object apply(Object obj) {
        return this.f24701b.n((Track) obj);
    }
}
