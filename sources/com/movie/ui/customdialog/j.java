package com.movie.ui.customdialog;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class j implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddMagnetDialog f33206b;

    public /* synthetic */ j(AddMagnetDialog addMagnetDialog) {
        this.f33206b = addMagnetDialog;
    }

    public final void accept(Object obj) {
        this.f33206b.n0((TorrentObject) obj);
    }
}
