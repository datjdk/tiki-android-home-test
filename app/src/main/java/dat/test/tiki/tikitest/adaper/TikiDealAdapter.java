package dat.test.tiki.tikitest.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dat.test.tiki.tikitest.R;
import dat.test.tiki.tikitest.model.TikiDeal;
import dat.test.tiki.tikitest.utils.AppGenerator;

public class TikiDealAdapter extends RecyclerView.Adapter<TikiDealAdapter.TikiDealViewHolder> {
    private Context context;
    private List<TikiDeal> mData;
    private LayoutInflater mInflater;

    public TikiDealAdapter(Context context, List<TikiDeal> data) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    public void updateData(List<TikiDeal> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TikiDealViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.deals_item, viewGroup, false);
        return new TikiDealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TikiDealViewHolder holder, int pos) {
        TikiDeal tikiDeal = mData.get(pos);
//        holder.imgViewDeal.setImageResource(tikiDeal.getImage());

        loadRandomImage(holder.imgViewDeal, 120, 160, AppGenerator.RANDOM_IMAGE);

        holder.textViewTitle.setText(tikiDeal.getTitle());
    }

    @Override
    public int getItemCount() {
        return mData != null? mData.size(): 0;
    }

    public class TikiDealViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_view_deal)
        ImageView imgViewDeal;
        @BindView(R.id.text_view_title)
        TextView textViewTitle;

        public TikiDealViewHolder(@NonNull View v) {
            super(v);
            ButterKnife.bind(this, v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, textViewTitle.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void loadRandomImage(ImageView imageView, int width, int height, String ImageURL) {
        Picasso.get()
                .load(ImageURL)
                .resize(width, height).into(imageView);
    }
}
