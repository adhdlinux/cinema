package com.movie.ui.activity;

import android.view.View;
import android.widget.ListView;
import butterknife.internal.Utils;
import com.yoku.marumovie.R;

public class TestCrappers_ViewBinding extends BaseActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private TestCrappers f32176b;

    public TestCrappers_ViewBinding(TestCrappers testCrappers, View view) {
        super(testCrappers, view);
        this.f32176b = testCrappers;
        testCrappers.lvSources = (ListView) Utils.findRequiredViewAsType(view, R.id.lvSources, "field 'lvSources'", ListView.class);
    }

    public void unbind() {
        TestCrappers testCrappers = this.f32176b;
        if (testCrappers != null) {
            this.f32176b = null;
            testCrappers.lvSources = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
