package kh.edu.rupp.ite.onlineshop.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import kh.edu.rupp.ite.onlineshop.api.model.ProductModel;
import kh.edu.rupp.ite.onlineshop.databinding.ViewHolderProductBinding;

public class ProductListAdapter extends ListAdapter<ProductModel, ProductListAdapter.ProductViewHolder> {

    public ProductListAdapter() {
        super(new DiffUtil.ItemCallback<ProductModel>() {
            @Override
            public boolean areItemsTheSame(@NonNull ProductModel oldItem, @NonNull ProductModel newItem) {
                return newItem == oldItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull ProductModel oldItem, @NonNull ProductModel newItem) {
                return newItem.getId() == oldItem.getId();
            }
        });
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolderProductBinding binding = ViewHolderProductBinding.inflate(inflater, parent, false);

        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        ProductModel item = getItem(position);
        holder.bind(item);
    }

    // == Product ViewHolder ==
    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        private final ViewHolderProductBinding itemBinding;

        public ProductViewHolder(ViewHolderProductBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        // helper bind() method
        @SuppressLint("SetTextI18n")
        public void bind(ProductModel product) {
            Picasso.get().load(product.getImageUrl()).into(itemBinding.imgProduct);

            itemBinding.txtProductName.setText(product.getName());

            itemBinding.txtProductPrice.setText("$" + product.getPrice());
        }
    }


}

