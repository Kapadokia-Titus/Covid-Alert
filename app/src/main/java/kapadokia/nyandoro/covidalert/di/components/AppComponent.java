package kapadokia.nyandoro.covidalert.di.components;

import javax.inject.Singleton;

import dagger.Component;
import kapadokia.nyandoro.covidalert.di.modules.ContextModule;
import kapadokia.nyandoro.covidalert.di.modules.NetworkModule;
import kapadokia.nyandoro.covidalert.ui.HomeActivity;

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class})
public interface AppComponent {

    void inject(HomeActivity homeActivity);
}
