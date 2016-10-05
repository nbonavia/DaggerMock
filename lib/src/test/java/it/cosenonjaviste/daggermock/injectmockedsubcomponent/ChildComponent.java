package it.cosenonjaviste.daggermock.injectmockedsubcomponent;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = ChildComponentModule.class)
public interface ChildComponent {

    void inject(MainClass object);

    void inject(ChildClass object);
}
