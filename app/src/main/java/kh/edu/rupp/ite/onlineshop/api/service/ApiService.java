package kh.edu.rupp.ite.onlineshop.api.service;

import java.util.List;

import kh.edu.rupp.ite.onlineshop.api.model.ProductModel;
import kh.edu.rupp.ite.onlineshop.api.model.ProfileModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/kimsongsao/ferupp/main/products.json")
    Call<List<ProductModel>> loadProductList();

    @GET("/kimsongsao/ferupp/main/profile.json")
    Call<ProfileModel> loadProfile();
}
