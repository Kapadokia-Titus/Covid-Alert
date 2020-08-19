package kapadokia.nyandoro.covidalert.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kapadokia.nyandoro.covidalert.remote.StatisticsService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public abstract class NetworkModule {

    @Provides
    @Singleton
    static Retrofit providerRetrofit(){

        return new Retrofit.Builder()
                .baseUrl("https://corona.lmao.ninja/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    static StatisticsService providerStatisticService(Retrofit retrofit){
        return retrofit.create(StatisticsService.class);
    }
}
