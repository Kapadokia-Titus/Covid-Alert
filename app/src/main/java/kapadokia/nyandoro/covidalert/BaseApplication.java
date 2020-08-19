package kapadokia.nyandoro.covidalert;

import android.app.Application;

import kapadokia.nyandoro.covidalert.di.components.AppComponent;
import kapadokia.nyandoro.covidalert.di.components.DaggerAppComponent;

public class BaseApplication extends Application {

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
