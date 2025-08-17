package io.reactivex.subjects;

import io.reactivex.Observable;
import io.reactivex.Observer;

public abstract class Subject<T> extends Observable<T> implements Observer<T> {
    public final Subject<T> b() {
        if (this instanceof SerializedSubject) {
            return this;
        }
        return new SerializedSubject(this);
    }
}
