package com.apptech.mas.ui.add_sales;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apptech.mas.R;
import com.apptech.mas.databinding.AddSalesFragmentBinding;

public class AddSalesFragment extends Fragment {

    private AddSalesViewModel mViewModel;
    AddSalesFragmentBinding binding;

    public static AddSalesFragment newInstance() {
        return new AddSalesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = AddSalesFragmentBinding.inflate(inflater ,container , false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddSalesViewModel.class);
        // TODO: Use the ViewModel
    }

}