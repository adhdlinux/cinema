package com.movie.ui.widget.glidepalette;

import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

public class PaletteTarget {

    /* renamed from: a  reason: collision with root package name */
    protected int f33680a;

    /* renamed from: b  reason: collision with root package name */
    protected ArrayList<Pair<View, Integer>> f33681b;

    /* renamed from: c  reason: collision with root package name */
    protected ArrayList<Pair<TextView, Integer>> f33682c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f33683d;

    /* renamed from: e  reason: collision with root package name */
    protected int f33684e;

    public void a() {
        this.f33681b.clear();
        this.f33682c.clear();
        this.f33681b = null;
        this.f33682c = null;
        this.f33683d = false;
        this.f33684e = 300;
    }
}
