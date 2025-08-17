package com.facebook.react.uimanager.events;

import com.facebook.common.logging.FLog;

public class BlackHoleEventDispatcher implements EventDispatcher {
    private static final EventDispatcher sEventDispatcher = new BlackHoleEventDispatcher();

    private BlackHoleEventDispatcher() {
    }

    public static EventDispatcher get() {
        return sEventDispatcher;
    }

    public void addBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener) {
    }

    public void addListener(EventDispatcherListener eventDispatcherListener) {
    }

    public void dispatchAllEvents() {
    }

    public void dispatchEvent(Event event) {
        String simpleName = getClass().getSimpleName();
        FLog.d(simpleName, "Trying to emit event to JS, but the React instance isn't ready. Event: " + event.getEventName());
    }

    public void onCatalystInstanceDestroyed() {
    }

    public void registerEventEmitter(int i2, RCTEventEmitter rCTEventEmitter) {
    }

    public void registerEventEmitter(int i2, RCTModernEventEmitter rCTModernEventEmitter) {
    }

    public void removeBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener) {
    }

    public void removeListener(EventDispatcherListener eventDispatcherListener) {
    }

    public void unregisterEventEmitter(int i2) {
    }
}
