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

       // putPost(); // when you dont pass anything by put post it will automatically set it at null
        patchPost(); // but in patch post if you send null it wont change the vlaue

    }
  
    private void putPost()
    {
        Users myuser = new Users(23, null, "Hi there");
        Call<Users> call = api.putpost(3,myuser);

        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Wasn't a succesfull fectching for post", Toast.LENGTH_SHORT).show();
                }
                Users myentry = response.body();
                String data = "";

                data+= " Code : "+response.code()+"\n" +
                        " User Id : "+myentry.getUserId()+"\n" +
                        "Id : "+myentry.getId()+"\n"+
                        "Title : "+myentry.getTitle()+"\n"+
                        "TEXT : "+myentry.getText()+"\n";

                txt.setText(data);
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Couldn't fetch data for put post", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void patchPost()
    {
        Users myuser = new Users(23, null , "Hi there");
        Call<Users> call = api.patchpost(3,myuser);

        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Wasn't a succesfull fectching for post", Toast.LENGTH_SHORT).show();
                }
                Users myentry = response.body();
                String data = "";

                data+= " Code : "+response.code()+"\n" +
                        " User Id : "+myentry.getUserId()+"\n" +
                        "Id : "+myentry.getId()+"\n"+
                        "Title : "+myentry.getTitle()+"\n"+
                        "TEXT : "+myentry.getText()+"\n";

                txt.setText(data);
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Couldn't fetch data for put post", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
