package com.movie.ui.customdialog;

import com.movie.data.model.TorrentObject;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddMagnetDialog f33197b;

    public /* synthetic */ a0(AddMagnetDialog addMagnetDialog) {
        this.f33197b = addMagnetDialog;
    }

    public final void accept(Object obj) {
        this.f33197b.z0((TorrentObject) obj);
    }
}
