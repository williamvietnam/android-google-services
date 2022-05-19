package com.rikkeisoft.lifecycle.demo_mvvm_livedata;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rikkeisoft.lifecycle.demo_mvvm_livedata.main.MainFragment;
import com.rikkeisoft.lifecycle.demo_mvvm_livedata.result.MVVMResultFragment;
import com.rikkeisoft.myapp.R;
import com.rikkeisoft.myapp.databinding.ActivityMvvmBinding;

public class MvvmContainerActivity extends AppCompatActivity {
    private ActivityMvvmBinding binding;
    private MainFragment mainFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMvvmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        showMainFragment();
    }

    public void showMainFragment() {
        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());

        if (mainFragment == null) {
            mainFragment = new MainFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, mainFragment, MainFragment.class.getName())
                    .addToBackStack(MainFragment.class.getName())
                    .show(mainFragment)
                    .commit();
        }
    }

    public void showResultMVVMFragment() {
        MVVMResultFragment mvvmResultFragment = new MVVMResultFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, mvvmResultFragment, MVVMResultFragment.class.getName())
                .addToBackStack(MVVMResultFragment.class.getName())
                .show(mvvmResultFragment)
                .commit();
    }

}
