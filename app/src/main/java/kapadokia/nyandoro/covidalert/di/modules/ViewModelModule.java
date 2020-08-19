package kapadokia.nyandoro.covidalert.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kapadokia.nyandoro.covidalert.di.ViewModelKey;
import kapadokia.nyandoro.covidalert.model.Countries;
import kapadokia.nyandoro.covidalert.viewModel.StatisticsViewModel;
import kapadokia.nyandoro.covidalert.viewModel.ViewModelFactory;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(StatisticsViewModel.class)
    abstract ViewModel bindViewModel(StatisticsViewModel statisticsViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory viewModelFactory);
}
