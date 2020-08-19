package kapadokia.nyandoro.covidalert.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import kapadokia.nyandoro.covidalert.model.Countries;
import kapadokia.nyandoro.covidalert.repository.StatisticsRepository;

public class StatisticsViewModel extends ViewModel {

    private StatisticsRepository statisticsRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<Countries> countriesMutableLiveData = new MutableLiveData<>();

    @Inject
    public StatisticsViewModel (StatisticsRepository statisticsRepository){
        this.statisticsRepository = statisticsRepository;
    }

    public MutableLiveData<Countries> getCountriesMutableLiveData(){
      loadData();
      return countriesMutableLiveData;
    }

    private void loadData() {
        disposable.add(statisticsRepository.modelSingleAllCountries()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<Countries>() {
            @Override
            public void onSuccess(Countries countries) {
                getCountriesMutableLiveData().setValue(countries);
            }

            @Override
            public void onError(Throwable e) {

            }
        })
        );
    }
}
