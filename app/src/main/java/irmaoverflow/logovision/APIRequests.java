package irmaoverflow.logovision;

import android.util.Log;

import com.yelp.fusion.client.connection.YelpFusionApi;
import com.yelp.fusion.client.connection.YelpFusionApiFactory;
import com.yelp.fusion.client.models.Business;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Randy on 2/9/18.
 */

public class APIRequests {
    YelpFusionApi yelpClient;

    //Should run upon application launch
    public YelpFusionApi initClient() {
        try {
            YelpFusionApiFactory yelpBuild = new YelpFusionApiFactory();
            YelpFusionApi yelpClient = yelpBuild.createAPI(CONFIG.yelpClientID, CONFIG.yelpSecret);
            return yelpClient;
        }
        catch(IOException e) {
            Log.v("yelpClient", e.getStackTrace().toString());
            return null;
        }
    }

    public void getBusiness(String id) {
        Callback<Business> callBack = new Callback<Business>() {
            @Override
            public void onResponse(Call<Business> call, Response<Business> response) {
                Business business = response.body();
                // Update UI text with the Business object.
            }
            @Override
            public void onFailure(Call<Business> call, Throwable t) {
                // HTTP error happened, do something to handle it.

            }
        };
    }


}
