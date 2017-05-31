package me.sheepyang.armsdemo.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;
import me.sheepyang.armsdemo.di.module.TestModule;
import me.sheepyang.armsdemo.mvp.ui.activity.TestActivity;

@ActivityScope
@Component(modules = TestModule.class, dependencies = AppComponent.class)
public interface TestComponent {
    void inject(TestActivity activity);
}