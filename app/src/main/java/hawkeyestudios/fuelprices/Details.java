package hawkeyestudios.fuelprices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aman on 24/06/17.
 */

public interface Details {


    @GET("/price")
    Call<ArrayList<FuelDetails>> reposForUser(@Query("city") String city, @Query("fuel_type") String fuel);
}

