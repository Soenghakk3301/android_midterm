package kh.edu.rupp.ite.onlineshop.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import kh.edu.rupp.ite.onlineshop.R;
import kh.edu.rupp.ite.onlineshop.databinding.ActivityLandingBinding;
import kh.edu.rupp.ite.onlineshop.ui.fragment.HomeFragment;
import kh.edu.rupp.ite.onlineshop.ui.fragment.MoreFragment;
import kh.edu.rupp.ite.onlineshop.ui.fragment.ProductFragment;
import kh.edu.rupp.ite.onlineshop.ui.fragment.ProfileFragment;

public class LandingActivity extends AppCompatActivity {

    private ActivityLandingBinding binding;

    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLandingBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //== setup listener ==
        // default fragment
        showFragment(new HomeFragment());

        // responding with clicked tab
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.ldHome)
                showFragment(new HomeFragment());
            else if (id == R.id.ldProduct) {
                showFragment(new ProductFragment());
            } else if (id == R.id.ldProfile) {
                showFragment(new ProfileFragment());
            } else {
                showFragment(new MoreFragment());
            }
            return true;
        });

    }

    // performed replacing a fragment into lyFragment
    private void showFragment(Fragment fragment) {

        // create fragment manager and set ot lyFragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(binding.lyFragment.getId(), fragment);
        transaction.commit();
    }
}
