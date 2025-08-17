package rx.exceptions;

import java.util.List;

public final class Exceptions {
    private Exceptions() {
    }

    public static void a(List<? extends Throwable> list) {
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                Throwable th = (Throwable) list.get(0);
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                } else if (th instanceof Error) {
                    throw ((Error) th);
                } else {
                    throw new RuntimeException(th);
                }
            } else {
                throw new CompositeException("Multiple exceptions", list);
            }
        }
    }

    public static void b(Throwable th) {
        if (th instanceof OnErrorNotImplementedException) {
            throw ((OnErrorNotImplementedException) th);
        } else if (th instanceof OnErrorFailedException) {
            OnErrorFailedException onErrorFailedException = (OnErrorFailedException) th;
            Throwable cause = onErrorFailedException.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw onErrorFailedException;
        } else if (th instanceof StackOverflowError) {
            throw ((StackOverflowError) th);
        } else if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
