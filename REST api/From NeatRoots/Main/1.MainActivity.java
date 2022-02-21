import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        apiInterface  = RetroFitInstance.getRetrofit().create(ApiInterface.class);

        apiInterface.getPosts().enqueue(new Callback<List<PostPojo>>() { // Call back is used to see if any data came from the api
            @Override
            public void onResponse(Call<List<PostPojo>> call, Response<List<PostPojo>> response) {

                if(response.body().size()>0)
                {
                    List<PostPojo> postList = response.body();
                    Adapter adapter = new Adapter(postList, getApplicationContext());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);


                    Toast.makeText(getApplicationContext(), "List exists", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Nothing came up", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<PostPojo>> call, Throwable t) { // executes when we dont get any response from the api, or net connection or wrong code
                // throwable t is the error message
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
