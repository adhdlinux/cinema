package com.bumptech.glide.manager;

class ApplicationLifecycle implements Lifecycle {
    ApplicationLifecycle() {
    }

    public void a(LifecycleListener lifecycleListener) {
    }

    public void b(LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }
}
