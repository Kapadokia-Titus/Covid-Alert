package kapadokia.nyandoro.covidalert.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import kapadokia.nyandoro.covidalert.R;
import kapadokia.nyandoro.covidalert.databinding.SingleItemBinding;
import kapadokia.nyandoro.covidalert.model.Countries;
import kapadokia.nyandoro.covidalert.repository.StatisticsRepository;
import kapadokia.nyandoro.covidalert.viewModel.StatisticsViewModel;
import kapadokia.nyandoro.covidalert.viewModel.ViewModelFactory;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private static final String TAG = "HomeAdapter";

    private StatisticsRepository repository;
    private Context context;

    private StatisticsViewModel statisticsViewModel;

    @Inject
    private ViewModelProvider.Factory viewModelFactory;
    // constructor
    @Inject
    public HomeAdapter(StatisticsRepository repository, Context context){
        this.repository =repository;
        this.context=context;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        // view data binding
        SingleItemBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleItemBinding binding = DataBindingUtil.inflate
                (LayoutInflater.from(context), R.layout.single_item, parent, false);


        return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        statisticsViewModel = ViewModelProviders.of((FragmentActivity) context, viewModelFactory).get(StatisticsViewModel.class);
        statisticsViewModel.getCountriesMutableLiveData().observe((LifecycleOwner) context, new Observer<Countries>() {
            @Override
            public void onChanged(Countries countries) {
                holder.binding.setCountry(countries);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
