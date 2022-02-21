
public class MainActivity extends AppCompatActivity {

    String url ="https://jsonplaceholder.typicode.com/";
    TextView txt;
    myApi api;
    EditText et;
    Button bt;

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

        getUsers();
    }

    private void getUsers()
    {
        Call<List<Users>> users  = api.getUsers(3,4,"id","desc"); // create a api
      
        users.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                if(!response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Wasn't a succesfull fectching", Toast.LENGTH_SHORT).show();
                }

                List<Users> myUsers= response.body(); // you will the get whole data. in a list

                for(int i = 0; i< myUsers.size(); i++)
                {
                    txt.append(
                            " User Id : "+myUsers.get(i).getUserId()+"\n" +
                                    "ID: "+myUsers.get(i).getId()+"\n"+
                                    "Title : "+myUsers.get(i).getTitle()+"\n"+
                                    "TEXT : "+myUsers.get(i).getText()+"\n\n");
                }
            }
            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Couldn't fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
