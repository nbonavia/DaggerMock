package it.cosenonjaviste.daggermock.injectmockedsubcomponent;

public class ChildComponentHolder {
    private static ChildComponent component;

    public static ChildComponent get() {
        return component;
    }

    public static void set(ChildComponent component) {
        ChildComponentHolder.component = component;
    }
}
