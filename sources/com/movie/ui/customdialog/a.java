package com.movie.ui.customdialog;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddMagnetDialog f33196b;

    public /* synthetic */ a(AddMagnetDialog addMagnetDialog) {
        this.f33196b = addMagnetDialog;
    }

    public final void accept(Object obj) {
        this.f33196b.q0((TorrentObject) obj);
    }
}
