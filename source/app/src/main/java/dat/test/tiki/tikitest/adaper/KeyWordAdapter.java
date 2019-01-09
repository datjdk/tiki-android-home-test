package dat.test.tiki.tikitest.adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dat.test.tiki.tikitest.utils.AppGenerator;
import dat.test.tiki.tikitest.R;

public class KeyWordAdapter extends RecyclerView.Adapter<KeyWordAdapter.KeyWordViewHolder> {
    private List<String> mData;

    private Context context;
    private LayoutInflater mInflater;

    public KeyWordAdapter(Context context, List<String> data) {
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
    public KeyWordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.key_word_item, viewGroup, false);
        return new KeyWordAdapter.KeyWordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KeyWordViewHolder holder, int i) {
        String keyWord = mData.get(i);
        holder.layoutKeyWord.setBackground(AppGenerator.getRoundBackground(context, AppGenerator.getRandomColor()));
        holder.mKeyWord.setText(formatKeyWord(keyWord, 1));
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size(): 0;
    }

    public class KeyWordViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.layout_key_word)
        View layoutKeyWord;
        @BindView(R.id.text_view_key_word)
        TextView mKeyWord;

        KeyWordViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, mKeyWord.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // format displayed key word
    private String formatKeyWord(String keyWord, int limit) {
        if (!TextUtils.isEmpty(keyWord)) {
            StringBuilder sb = new StringBuilder(keyWord);
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == ' ') {
                    sb.setCharAt(i, '\n');
                    return sb.toString();
                }
            }
        }
        return keyWord;
    }


}
