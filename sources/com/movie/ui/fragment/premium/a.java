package com.movie.ui.fragment.premium;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FilesBottomSheetFragment f33527b;

    public /* synthetic */ a(FilesBottomSheetFragment filesBottomSheetFragment) {
        this.f33527b = filesBottomSheetFragment;
    }

    public final void accept(Object obj) {
        this.f33527b.X((TorrentObject) obj);
    }
}
