package kapadokia.nyandoro.covidalert.adapter;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kapadokia.nyandoro.covidalert.model.Countries;
import kapadokia.nyandoro.covidalert.repository.StatisticsRepository;

public class HomeBindingAdapter {

    private static final String TAG = "HomeBindingAdapter";

    @BindingAdapter("countryList")
    public static void setCountries(RecyclerView view,StatisticsRepository repository){

        if (repository == null){
            return;
        }

        RecyclerView.LayoutManager layoutManager = view.getLayoutManager();

        if (layoutManager==null){
            view.setLayoutManager(new LinearLayoutManager(view.getContext()));
        }

        HomeAdapter adapter = (HomeAdapter) view.getAdapter();
        if (adapter==null){
            adapter = new HomeAdapter(repository, view.getContext());
            view.setAdapter(adapter);
        }
    }

}
