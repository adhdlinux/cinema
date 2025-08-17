package com.unity3d.scar.adapter.common.signals;

public interface ISignalCallbackListener<T> {
    void a(String str, String str2, T t2);

    void onFailure(String str);
}
