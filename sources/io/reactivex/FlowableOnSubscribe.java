package io.reactivex;

public interface FlowableOnSubscribe<T> {
    void a(FlowableEmitter<T> flowableEmitter) throws Exception;
}
