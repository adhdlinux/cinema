package androidx.transition;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        n0();
    }

    private void n0() {
        k0(1);
        d0(new Fade(2)).d0(new ChangeBounds()).d0(new Fade(1));
    }
}
