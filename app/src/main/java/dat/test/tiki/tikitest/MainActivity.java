package dat.test.tiki.tikitest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dat.test.tiki.tikitest.adaper.KeyWordAdapter;
import dat.test.tiki.tikitest.adaper.ServiceAdapter;
import dat.test.tiki.tikitest.adaper.TikiDealAdapter;
import dat.test.tiki.tikitest.model.TikiDeal;
import dat.test.tiki.tikitest.model.TikiService;
import dat.test.tiki.tikitest.presenter.MainActivityPresenter;
import dat.test.tiki.tikitest.adaper.CategoryAdapter;
import dat.test.tiki.tikitest.utils.AppGenerator;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.MainActivityView {

    // screen presenter
    private MainActivityPresenter mainActivityPresenter;

    CategoryAdapter categoryAdapter;
    ServiceAdapter serviceAdapter;
    KeyWordAdapter keyWordAdapter;
    TikiDealAdapter dealAdapter;

    @BindView(R.id.recycler_view_category)
    RecyclerView recyclerViewCategory;

    @BindView(R.id.recycler_view_service)
    RecyclerView recyclerViewService;

    @BindView(R.id.recycler_view_hot_key_word)
    RecyclerView recyclerViewHotKeyWord;

    @BindView(R.id.recycler_view_deal)
    RecyclerView recyclerViewDeal;

    @BindView(R.id.button_register)
    Button btnRegister;
    @BindView(R.id.button_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // set layout
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewService.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewHotKeyWord.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewDeal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // buttons
        btnLogin.setBackground(AppGenerator.getRoundBackground(this, getResources().getColor(R.color.bg_login)));
        btnRegister.setBackground(AppGenerator.getRoundBackground(this, getResources().getColor(R.color.bg_register)));

        // category view
        categoryAdapter = new CategoryAdapter(this, null);
        recyclerViewCategory.setAdapter(categoryAdapter);

        // service view
        serviceAdapter = new ServiceAdapter(this, null);
        recyclerViewService.setAdapter(serviceAdapter);

        // hot key word view
        keyWordAdapter = new KeyWordAdapter(this, null);
        recyclerViewHotKeyWord.setAdapter(keyWordAdapter);

        // deals
        dealAdapter = new TikiDealAdapter(this, null);
        recyclerViewDeal.setAdapter(dealAdapter);

        mainActivityPresenter = new MainActivityPresenter(this);
        mainActivityPresenter.startPopulating();

        Log.d("tiki", "MainActivity: stated");
    }

    @Override
    public void populateCategoriesList(List<String> data) {
        categoryAdapter.updateData(data);
    }

    @Override
    public void populateServicesList(List<TikiService> data) {
        serviceAdapter.updateData(data);
    }

    @Override
    public void populateHotKeyWordsList(List<String> data) {
        keyWordAdapter.updateData(data);
    }

    @Override
    public void populateDealsList(List<TikiDeal> data) {
        dealAdapter.updateData(data);
    }
}
