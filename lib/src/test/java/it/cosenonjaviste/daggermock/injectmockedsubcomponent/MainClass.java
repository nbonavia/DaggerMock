package it.cosenonjaviste.daggermock.injectmockedsubcomponent;


import javax.inject.Inject;

public class MainClass {

    @Inject
    ChildClass childClass;

    public MainClass() {
        ChildComponentHolder.get().inject(this);
    }
}
