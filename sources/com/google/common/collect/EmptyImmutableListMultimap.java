package com.google.common.collect;

import java.util.Collection;

class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object> {

    /* renamed from: h  reason: collision with root package name */
    static final EmptyImmutableListMultimap f30505h = new EmptyImmutableListMultimap();

    private EmptyImmutableListMultimap() {
        super(ImmutableMap.k(), 0);
    }

    /* renamed from: j */
    public ImmutableMap<Object, Collection<Object>> asMap() {
        return super.asMap();
    }
}
