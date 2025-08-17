package com.movie.ui.customdialog;

import com.database.entitys.premiumEntitys.torrents.TorrentEntity;
import io.reactivex.functions.Function;

public final /* synthetic */ class i implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddMagnetDialog f33205b;

    public /* synthetic */ i(AddMagnetDialog addMagnetDialog) {
        this.f33205b = addMagnetDialog;
    }

    public final Object apply(Object obj) {
        return this.f33205b.m0((TorrentEntity) obj);
    }
}
