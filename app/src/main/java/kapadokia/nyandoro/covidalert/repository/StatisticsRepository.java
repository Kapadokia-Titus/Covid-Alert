package kapadokia.nyandoro.covidalert.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import kapadokia.nyandoro.covidalert.model.Countries;
import kapadokia.nyandoro.covidalert.remote.StatisticsService;

public class StatisticsRepository {

    private StatisticsService statisticsService;

    @Inject
    public StatisticsRepository(StatisticsService statisticsService){
        this.statisticsService = statisticsService;
    }

    // fetching all countries
    public Single<Countries> modelSingleAllCountries(){
        return statisticsService.getByCountryName();
    }
}
