package kapadokia.nyandoro.covidalert.remote;

import io.reactivex.Single;
import kapadokia.nyandoro.covidalert.model.Countries;
import kapadokia.nyandoro.covidalert.model.CountryInfo;
import retrofit2.http.GET;

public interface StatisticsService {

    @GET("countries/:query?yesterday=true&strict=true&query =kenya")
    Single<Countries> getByCountryName();

    @GET("/countries?yesterday=&sort=")
    Single<Countries> getAllCountries();
}
