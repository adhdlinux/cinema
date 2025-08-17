package com.facebook.react.uimanager.events;

public interface EventDispatcher {
    void addBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener);

    void addListener(EventDispatcherListener eventDispatcherListener);

    void dispatchAllEvents();

    void dispatchEvent(Event event);

    void onCatalystInstanceDestroyed();

    @Deprecated
    void registerEventEmitter(int i2, RCTEventEmitter rCTEventEmitter);

    void registerEventEmitter(int i2, RCTModernEventEmitter rCTModernEventEmitter);

    void removeBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener);

    void removeListener(EventDispatcherListener eventDispatcherListener);

    void unregisterEventEmitter(int i2);
}
