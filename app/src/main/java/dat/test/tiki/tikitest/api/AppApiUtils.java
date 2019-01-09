package dat.test.tiki.tikitest.api;

import dat.test.tiki.tikitest.utils.AppGenerator;

public class AppApiUtils {

    public static AppApiService getApiService() {
        return RetrofitClient.getClient(AppGenerator.KEY_WORD_BASE_URL).create(AppApiService.class);
    }
}
