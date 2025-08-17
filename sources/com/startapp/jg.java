package com.startapp;

import com.startapp.ig;
import java.util.ArrayDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class jg implements ig.a {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadPoolExecutor f34786a = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: b  reason: collision with root package name */
    public final ArrayDeque<ig> f34787b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    public ig f34788c = null;

    public void a(ig igVar) {
        igVar.f34710a = this;
        this.f34787b.add(igVar);
        if (this.f34788c == null) {
            ig poll = this.f34787b.poll();
            this.f34788c = poll;
            if (poll != null) {
                poll.executeOnExecutor(this.f34786a, new Object[0]);
            }
        }
    }
}
