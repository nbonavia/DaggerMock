package it.cosenonjaviste.daggermock.injectmockedsubcomponent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.MockUtil;

import javax.inject.Inject;

import it.cosenonjaviste.daggermock.DaggerMockRule;

public class TestSubcomponentInjection {

    @Rule
    public DaggerMockRule<TestRootComponent> rule;

    @Inject
    MainClass mainClass;

    @Inject
    ChildClass childClass;

    public TestSubcomponentInjection() {
        ChildComponentModule childComponentModule = new ChildComponentModule();
        rule = new DaggerMockRule<TestRootComponent>(TestRootComponent.class, childComponentModule);

        rule.set(new DaggerMockRule.ComponentSetter<TestRootComponent>() {
            @Override
            public void setComponent(TestRootComponent t) {
                ChildComponentHolder.set(t.childComponent());
                TestRootComponentHolder.set(t);

                rule.provides(ChildClass.class, Mockito.spy(new ChildClass()));
                rule.provides(MainClass.class, Mockito.spy(new MainClass()));
            }
        });
    }

    @Before
    public void beforeTest() {
        TestRootComponentHolder.get().inject(this);
    }

    @Test
    public void testMasterChildMocking() {
        MockUtil mockUtil = new MockUtil();
        Assert.assertTrue("Injected MainClass is not mocked", mockUtil.isMock(mainClass));
        Assert.assertTrue("Injected ChildClass is not mocked", mockUtil.isMock(childClass));
        Assert.assertTrue("MainClass Injected ChildClass is not mocked", mockUtil.isMock(mainClass.childClass));
    }
}
