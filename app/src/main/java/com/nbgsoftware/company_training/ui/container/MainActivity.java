package com.nbgsoftware.company_training.ui.container;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.nbgsoftware.company_training.R;
import com.nbgsoftware.company_training.databinding.ActivityMainBinding;
import com.nbgsoftware.company_training.ui.quiz.start.StartFragment;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private ActivityMainBinding binding;
    private MainPresenter presenter;
    private StartFragment startFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new MainPresenter();
        presenter.setView(this);

        showStartQuizScreen();
    }

    @Override
    public void showStartQuizScreen() {
        if (startFragment == null){
            startFragment = new StartFragment();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, startFragment, StartFragment.class.getName())
                .addToBackStack(StartFragment.class.getName())
                .show(startFragment)
                .commit();
    }

    @Override
    public void showQuizDetailScreen() {

    }

    @Override
    public void showResultQuizScreen() {

    }
}