package com.movie.ui.customdialog;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class u implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddMagnetDialog f33219b;

    public /* synthetic */ u(AddMagnetDialog addMagnetDialog) {
        this.f33219b = addMagnetDialog;
    }

    public final void accept(Object obj) {
        this.f33219b.C0((TorrentObject) obj);
    }
}
