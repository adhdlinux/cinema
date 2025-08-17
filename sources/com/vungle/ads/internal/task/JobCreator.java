package com.vungle.ads.internal.task;

public interface JobCreator {
    Job create(String str) throws UnknownTagException;
}
