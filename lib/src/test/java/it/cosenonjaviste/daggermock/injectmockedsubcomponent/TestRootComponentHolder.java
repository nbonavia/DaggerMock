package it.cosenonjaviste.daggermock.injectmockedsubcomponent;

/**
 * Created by nebo on 05/10/2016.
 */
public class TestRootComponentHolder {
    private static TestRootComponent component;

    public static TestRootComponent get() {
        return component;
    }

    public static void set(TestRootComponent component) {
        TestRootComponentHolder.component = component;
    }
}
