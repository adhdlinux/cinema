package com.movie.ui.customdialog;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class y implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddMagnetDialog f33223b;

    public /* synthetic */ y(AddMagnetDialog addMagnetDialog) {
        this.f33223b = addMagnetDialog;
    }

    public final void accept(Object obj) {
        this.f33223b.G0((TorrentObject) obj);
    }
}
