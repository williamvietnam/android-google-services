package com.rikkeisoft.project_training.container;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;
import com.rikkeisoft.project_training.R;
import com.rikkeisoft.project_training.databinding.ActivityContainerBinding;
import com.rikkeisoft.project_training.views.new_way.NewWayFragment;
import com.rikkeisoft.project_training.views.old_way.OldWayFragment;
import com.rikkeisoft.project_training.views.tab_game.GameFragment;

public class ContainerActivity extends AppCompatActivity {

    private ActivityContainerBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContainerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showOldWayFragment();

        binding.bottomNav.setOnItemSelectedListener(onItemSelectedListener);
    }

    private final NavigationBarView.OnItemSelectedListener onItemSelectedListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.navigationOldWay) {
                showOldWayFragment();
                Toast.makeText(ContainerActivity.this, "Sử dụng RecyclerView Adapter", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == R.id.navigationNewWay) {
                showNewWayFragment();
                Toast.makeText(ContainerActivity.this, "Sử dụng DiffUtil & ListAdapter", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == R.id.navigationGame) {
                showGameFragment();
                return true;
            }
            return false;
        }
    };

    private void showOldWayFragment() {
        OldWayFragment oldWayFragment = new OldWayFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, oldWayFragment, OldWayFragment.class.getName())
                .addToBackStack(OldWayFragment.class.getName())
                .show(oldWayFragment)
                .commit();
    }

    private void showNewWayFragment() {
        NewWayFragment newWayFragment = new NewWayFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, newWayFragment, NewWayFragment.class.getName())
                .addToBackStack(NewWayFragment.class.getName())
                .show(newWayFragment)
                .commit();
    }

    private void showGameFragment() {
        GameFragment gameFragment = new GameFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, gameFragment, GameFragment.class.getName())
                .addToBackStack(GameFragment.class.getName())
                .show(gameFragment)
                .commit();
    }
}
