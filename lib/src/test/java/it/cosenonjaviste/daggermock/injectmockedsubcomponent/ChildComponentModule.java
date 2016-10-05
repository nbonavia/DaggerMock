package it.cosenonjaviste.daggermock.injectmockedsubcomponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ChildComponentModule {

    @Singleton
    @Provides
    public ChildClass provideInjectedClass() {
        return new ChildClass();
    }

    @Singleton
    @Provides
    public MainClass provideMainClass() {
        return new MainClass();
    }
}
