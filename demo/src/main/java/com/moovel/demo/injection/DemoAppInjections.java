package com.moovel.demo.injection;


import android.app.Activity;

import com.andretietz.demolib.injection.ActivityModule;
import com.andretietz.demolib.injection.ActivityModuleSubcomponentBuilder;
import com.andretietz.demolib.injection.scopes.ActivityScope;
import com.moovel.demo.screens.DemoActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = DemoAppInjections.DemoActivitySubcomponent.class)
public abstract class DemoAppInjections {

    @Binds
    @IntoMap
    @ActivityKey(DemoActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
            DemoActivitySubcomponent.Builder builder);

    @ActivityScope
    @Subcomponent(modules = ActivityModule.class)
    interface DemoActivitySubcomponent extends AndroidInjector<DemoActivity> {
        @Subcomponent.Builder
        abstract class Builder extends ActivityModuleSubcomponentBuilder<DemoActivity> {
        }
    }
}
