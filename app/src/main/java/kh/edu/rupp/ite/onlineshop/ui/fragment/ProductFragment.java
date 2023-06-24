package kh.edu.rupp.ite.onlineshop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import kh.edu.rupp.ite.onlineshop.adapter.ProductListAdapter;
import kh.edu.rupp.ite.onlineshop.api.model.ProductModel;
import kh.edu.rupp.ite.onlineshop.api.service.ApiService;
import kh.edu.rupp.ite.onlineshop.databinding.FragmentProductBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductFragment extends Fragment {

    private FragmentProductBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentProductBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // load product list from api
        loadProductListFromServer();
    }

    // performed loading ProductList from the server (api)
    private  void loadProductListFromServer() {

        // crete Retrofit client object
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit httpClient = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // create service object
        ApiService apiService = httpClient.create(ApiService.class);

        Call<List<ProductModel>> task = apiService.loadProductList();
        task.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {

                if (response.isSuccessful())
                    showProductList(response.body());
                else
                    Toast.makeText(getContext(), "Load product list failed", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Load product list failed", Toast.LENGTH_LONG).show();
            }
        });


    }

    // == helper method ==
    private void showProductList(List<ProductModel> productList) {

        // create LayoutManager and set to recyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);

        // Create adapter set adapter for recyclerView
        ProductListAdapter adapter = new ProductListAdapter();
        adapter.submitList(productList);
        binding.recyclerView.setAdapter(adapter);
    }
}
