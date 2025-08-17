package com.movie.ui.customdialog;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class n implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddMagnetDialog f33210b;

    public /* synthetic */ n(AddMagnetDialog addMagnetDialog) {
        this.f33210b = addMagnetDialog;
    }

    public final void accept(Object obj) {
        this.f33210b.w0((TorrentObject) obj);
    }
}
