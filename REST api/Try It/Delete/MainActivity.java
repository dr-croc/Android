public class MainActivity extends AppCompatActivity {

    String url ="https://jsonplaceholder.typicode.com/";
    TextView txt;
    myApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.tv);

        // FOR TIME OUT
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(80, TimeUnit.SECONDS)
                .writeTimeout(80, TimeUnit.SECONDS)
                .readTimeout(80, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        api  = retrofit.create(myApi.class);

        deletePost();
    }
  
     public  void deletePost ()
    {
        Call<Void> call = api.deletepost(4);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Wasn't a succesfull", Toast.LENGTH_SHORT).show();

                }
                txt.setText(String.valueOf(response.code()));
                // output is : 200
                /*
                The HTTP 200 OK success status response code indicates that the request has succeeded. .
                */
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Couldn't fetch data for delete ", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
