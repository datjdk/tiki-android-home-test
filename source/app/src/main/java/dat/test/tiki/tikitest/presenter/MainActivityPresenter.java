package dat.test.tiki.tikitest.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dat.test.tiki.tikitest.R;
import dat.test.tiki.tikitest.api.AppApiService;
import dat.test.tiki.tikitest.api.AppApiUtils;
import dat.test.tiki.tikitest.model.TikiDeal;
import dat.test.tiki.tikitest.model.TikiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter {

    private MainActivityView mainActivityView;

    public MainActivityPresenter(MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
    }

    public void startPopulating() {
        List<String> data1 = new ArrayList<>();
        data1.add("Mẹ & Bé");
        data1.add("Dịch vụ");
        data1.add("Sức khỏe");
        data1.add("Tiêu dùng");
        data1.add("Nội thất");
        data1.add("Giảm giá");
        data1.add("Thể thao");
        data1.add("Điện tử");
        mainActivityView.populateCategoriesList(data1);

        List<TikiService> data2 = new ArrayList<>();
        data2.add(new TikiService(R.drawable.ic_airplane, "Vé máy bay"));
        data2.add(new TikiService(R.drawable.ic_car, "Mua bảo hiềm online"));
        data2.add(new TikiService(R.drawable.ic_phone, "Mua thẻ điện thoại"));
        data2.add(new TikiService(R.drawable.ic_car, "Thẻ game"));
        data2.add(new TikiService(R.drawable.ic_phone, "Service 1"));
        data2.add(new TikiService(R.drawable.ic_airplane, "Service 2"));
        data2.add(new TikiService(R.drawable.ic_phone, "Service 3"));
        data2.add(new TikiService(R.drawable.ic_airplane, "Service 4"));
        mainActivityView.populateServicesList(data2);

        AppApiService mService = AppApiUtils.getApiService();
        mService.getKeyWords().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.body() != null && response.body().size() > 0) {
                    mainActivityView.populateHotKeyWordsList(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
            }
        });

        List<TikiDeal> deals = new ArrayList<>();
        deals.add(new TikiDeal(-1, "deal 1"));
        deals.add(new TikiDeal(-1, "deal 2"));
        deals.add(new TikiDeal(-1, "deal 3"));
        deals.add(new TikiDeal(-1, "deal 4"));
        deals.add(new TikiDeal(-1, "deal 5"));
        mainActivityView.populateDealsList(deals);

        Log.d("tiki", "MainActivityPresenter: done");
    }

    public interface MainActivityView {
        void populateCategoriesList(List<String> data);
        void populateServicesList(List<TikiService> data);
        void populateHotKeyWordsList(List<String> data);
        void populateDealsList(List<TikiDeal> data);
    }
}
