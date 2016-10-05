package it.cosenonjaviste.daggermock.injectmockedsubcomponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ChildComponentModule.class)
public interface TestRootComponent {
    ChildComponent childComponent();

    void inject(TestSubcomponentInjection object);
}
