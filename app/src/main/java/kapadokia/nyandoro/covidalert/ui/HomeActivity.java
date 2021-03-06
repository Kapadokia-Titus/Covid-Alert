package kapadokia.nyandoro.covidalert.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import kapadokia.nyandoro.covidalert.BaseApplication;
import kapadokia.nyandoro.covidalert.R;
import kapadokia.nyandoro.covidalert.databinding.ActivityHomeBinding;
import kapadokia.nyandoro.covidalert.model.Countries;
import kapadokia.nyandoro.covidalert.viewModel.StatisticsViewModel;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private static final String TAG = "HomeActivity";

    private StatisticsViewModel statisticsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        ((BaseApplication)getApplication()).getAppComponent().inject(this);

        statisticsViewModel = new ViewModelProvider(getViewModelStore(), viewModelFactory).get(StatisticsViewModel.class);
        statisticsViewModel.getCountriesMutableLiveData().observe(this, new Observer<Countries>() {
            @Override
            public void onChanged(Countries countries) {
                Log.d("result", "onChanged: " + countries.getCountry());
                List<Countries> country = new ArrayList<>();
                country.add(countries);
                binding.setCountries(country);
            }
        });
    }
}