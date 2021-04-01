package com.apptech.mas.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.apptech.mas.R;
import com.apptech.mas.adapter.RecentSalesAdapter;
import com.apptech.mas.adapter.SliderAdapter;
import com.apptech.mas.databinding.FragmentHomeBinding;
import com.apptech.mas.model.silder.SliderList;
import com.apptech.mas.model.recent_sales.RecentSalesList;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private List<SliderList> sliderLists = new ArrayList<>();
    private List<RecentSalesList> recentSalesLists = new ArrayList<>();
    NavController navController;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        binding.recentSalesRecyclerView.setAdapter(new RecentSalesAdapter(requireContext(), recentSalesLists));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        fakeList();
        silder();

        binding.addsale.setOnClickListener(v -> navController.navigate(R.id.action_nav_home_to_addSalesFragment));
        binding.salesReturn.setOnClickListener(v -> navController.navigate(R.id.action_nav_home_to_salesReturnFragment));


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void silder() {
        SliderAdapter adapter = new SliderAdapter(getContext(), sliderLists);
        binding.imageSlider.setSliderAdapter(adapter);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSlider.setIndicatorSelectedColor(Color.WHITE);
        binding.imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        binding.imageSlider.setScrollTimeInSec(4);
        binding.imageSlider.startAutoCycle();
    }

    private void fakeList() {
        recentSalesLists.add(new RecentSalesList("PS3 Remote Controller", "1", "190", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.f5vQ7TJUk2pdLQGCNYZJSgHaE8%26pid%3DApi&f=1"));
        recentSalesLists.add(new RecentSalesList("Acer Gaming Mouse", "3", "65", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.k68ZuSUvphAi5J3mZe9UlwHaEo%26pid%3DApi&f=1"));
        recentSalesLists.add(new RecentSalesList("Klair Eye Drop", "50", "87", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.b4THmmPg4uigObTpkdHgggHaFj%26pid%3DApi&f=1"));

        sliderLists.add(new SliderList("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.oQ-yGggYyUQ2xbbMZ6z4uwHaCb%26pid%3DApi&f=1"));
        sliderLists.add(new SliderList("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.siUEDQxZiMKgTyg-nINppQHaCe%26pid%3DApi&f=1"));
        sliderLists.add(new SliderList("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.PYZLhClMaYpSF2lIBCVEygHaCd%26pid%3DApi&f=1"));
    }

}






























