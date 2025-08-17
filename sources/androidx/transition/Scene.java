package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

public class Scene {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f11737a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f11738b;

    static Scene b(View view) {
        return (Scene) view.getTag(R$id.transition_current_scene);
    }

    static void c(View view, Scene scene) {
        view.setTag(R$id.transition_current_scene, scene);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f11737a) == this && (runnable = this.f11738b) != null) {
            runnable.run();
        }
    }
}
