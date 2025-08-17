package io.reactivex.exceptions;

import io.reactivex.internal.util.ExceptionHelper;

public final class Exceptions {
    private Exceptions() {
        throw new IllegalStateException("No instances!");
    }

    public static RuntimeException a(Throwable th) {
        throw ExceptionHelper.d(th);
    }

    public static void b(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
