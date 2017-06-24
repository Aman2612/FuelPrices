package hawkeyestudios.fuelprices;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button check;
    TextView liveUpdate;
    String city;
    String fuel;
    Spinner citySpin, fuelSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check = (Button) findViewById(R.id.check);
        liveUpdate = (TextView) findViewById(R.id.live);
        check.setOnClickListener(this);

        citySpin = (Spinner) findViewById(R.id.first);
        fuelSpin = (Spinner) findViewById(R.id.second);




    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id)
        {
            case R.id.check:

                city = citySpin.getSelectedItem().toString().toLowerCase();
                fuel = fuelSpin.getSelectedItem().toString().toLowerCase();

                Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://fuelpriceindia.herokuapp.com")                                   .addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = builder.build();
                Details client = retrofit.create(Details.class);

                Call<ArrayList<FuelDetails>> call = client.reposForUser(city,fuel);
                call.enqueue(new Callback<ArrayList<FuelDetails>>() {
                    @Override
                    public void onResponse(Call<ArrayList<FuelDetails>> call, Response<ArrayList<FuelDetails>> response) {

                        ArrayList<FuelDetails> end = response.body();
                        FuelDetails item = end.get(0);
                        String message = item.getCity();
                        liveUpdate.setText(message);

                    }

                    @Override
                    public void onFailure(Call<ArrayList<FuelDetails>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "BAD news", Toast.LENGTH_SHORT).show();
                        t.getCause();
                        t.getStackTrace();
                    }
                });

                break;
        }

    }
}
