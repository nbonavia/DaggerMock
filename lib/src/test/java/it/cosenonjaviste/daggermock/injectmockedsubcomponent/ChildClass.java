package it.cosenonjaviste.daggermock.injectmockedsubcomponent;

/**
 * Created by nebo on 05/10/2016.
 */
public class ChildClass {

    public ChildClass() {
        ChildComponentHolder.get().inject(this);
    }

    public String getName() {
        return "John Doe";
    }
}
