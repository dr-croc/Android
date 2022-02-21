public class MainActivity extends AppCompatActivity {

    String url ="https://jsonplaceholder.typicode.com/";
    TextView txt;
    myApi api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.tv);
        et = findViewById(R.id.enterPostId);
        bt = findViewById(R.id.get);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        api  = retrofit.create(myApi.class);

        createPost();
        
    }
  
  private  void  createPost()
    {
        // for the first way
        //Users myUser = new Users(23,"My channel","Welcome to my channel");
       // Call<Users> call = api.createPost(myUser);

        // for the second way
        Call<Users> call2 = api.createPost(26,"Welcome to try it", "Subscribe");

        /*call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Wasn't a succesfull fectching for posting", Toast.LENGTH_SHORT).show();
                }
                *//*
                * even though you are posting data to server but the server also sending info to you. So you need to receive the data
                * *//*
                Users myentry = response.body();
                String data = "";

                data+= " Code : "+response.code()+"\n" +
                        " User Id : "+myUser.getUserId()+"\n" +
                        "Id : "+myUser.getId()+"\n"+
                        "Title : "+myUser.getTitle()+"\n"+
                        "TEXT : "+myUser.getText()+"\n";

                txt.setText(data);

            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Couldn't fetch data for posting", Toast.LENGTH_SHORT).show();
            }
        });*/

        call2.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Wasn't a succesfull fectching for posting", Toast.LENGTH_SHORT).show();
                }
                /*
                 * even though you are posting data to server but the server also sending info to you. So you need to receive the data
                 * */
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
                Toast.makeText(getApplicationContext(), "Couldn't fetch data for posting", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
