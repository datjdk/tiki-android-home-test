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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dat.test.tiki.tikitest.R;
import dat.test.tiki.tikitest.model.TikiService;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {
    private Context context;
    private List<TikiService> mData;
    private LayoutInflater mInflater;

    public ServiceAdapter(Context context, List<TikiService> data) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    public void updateData(List<TikiService> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = mInflater.inflate(R.layout.service_item, viewGroup, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        TikiService service = mData.get(position);
        holder.mServiceName.setText(service.getServiceName());
        holder.mImageViewService.setImageResource(service.getServiceLogo());
    }

    @Override
    public int getItemCount() {
        return mData != null? mData.size(): 0;
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_view_service)
        ImageView mImageViewService;

        @BindView(R.id.text_view_service_name)
        TextView mServiceName;

        ServiceViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, mServiceName.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
