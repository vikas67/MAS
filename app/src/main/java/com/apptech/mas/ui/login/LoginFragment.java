package com.apptech.mas.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.apptech.mas.R;
import com.apptech.mas.databinding.LoginFragmentBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class LoginFragment extends Fragment {

    private LoginViewModel mViewModel;
    ActionBar supportActionBar;
    LoginFragmentBinding binding;
    NavController navigation;
    BottomNavigationView navBar;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = LoginFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navigation = Navigation.findNavController(view);
        binding.LoginButton.setOnClickListener(v -> navigation.navigate(R.id.action_loginFragment_to_nav_home));

    }

    @Override
    public void onResume() {
        super.onResume();
        supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        navBar = getActivity().findViewById(R.id.bottom_navigation);

        if (navBar != null)
            navBar.setVisibility(View.GONE);
        if (supportActionBar != null)
            supportActionBar.hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (navBar != null)
            navBar.setVisibility(View.VISIBLE);
        if (supportActionBar != null)
            supportActionBar.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
























