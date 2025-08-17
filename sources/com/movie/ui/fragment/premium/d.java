package com.movie.ui.fragment.premium;

import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FilesBottomSheetFragment f33559b;

    public /* synthetic */ d(FilesBottomSheetFragment filesBottomSheetFragment) {
        this.f33559b = filesBottomSheetFragment;
    }

    public final void accept(Object obj) {
        this.f33559b.V((MediaSource) obj);
    }
}
