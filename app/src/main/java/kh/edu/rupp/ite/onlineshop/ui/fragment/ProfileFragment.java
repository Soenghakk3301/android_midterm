package kh.edu.rupp.ite.onlineshop.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import kh.edu.rupp.ite.onlineshop.api.model.ProfileModel;
import kh.edu.rupp.ite.onlineshop.api.service.ApiService;
import kh.edu.rupp.ite.onlineshop.databinding.FragmentProfileBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // load profile from api
        loadProfileFromServer();
    }

    // performed loading Profile info from the server (api)
    private void loadProfileFromServer() {

        // create Retrofit client object with json
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy/MM-dd'T'HH:mm:ssX")
                .create();

        Retrofit httpClient = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // create service object
        ApiService apiService = httpClient.create(ApiService.class);

        // implement the loadProfile() function
        Call<ProfileModel> task = apiService.loadProfile();
        task.enqueue(new Callback<ProfileModel>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {

                if (response.isSuccessful())
                    showProfile(response.body());
                else
                    Toast.makeText(getContext(), "Load product list failed", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {
                Toast.makeText(getContext(), "Load product list failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    // == helper method ==
    private void showProfile(ProfileModel profile) {
        Picasso.get().load(profile.getImageUrl()).into(binding.imgProfile);
        binding.txtUsername.setText(String.format("%s %s", profile.getFirstname(), profile.getLastname()));
        binding.txtEmail.setText(profile.getEmail());
        binding.edTxtEmail.setText(profile.getEmail());
        binding.edTxtPhoneNumber.setText(profile.getPhoneNumber());
        binding.edTxtGender.setText(profile.getGender());
        binding.edTxtBirthday.setText(profile.getBirthday());
        binding.edTxtAddress.setText(profile.getAddress());
    }
}
