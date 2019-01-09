package dat.test.tiki.tikitest.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dat.test.tiki.tikitest.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context context;
    private List<String> mData;
    private LayoutInflater mInflater;

    public CategoryAdapter(Context context, List<String> data) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    public void updateData(List<String> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int position) {
        View view = mInflater.inflate(R.layout.category_item, viewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.mCategory.setText(animal);
    }

    @Override
    public int getItemCount() {
        return mData != null? mData.size(): 0;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvCategory)
        TextView mCategory;

        CategoryViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, mCategory.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
