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

              //  getComments();
        api  = retrofit.create(myApi.class);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getComments();
            }
        });
    }
    
    private void getComments() {
        int value = Integer.parseInt(et.getText().toString());
        Call<List<Comment>> comments  = api.getComments(value);

        comments.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Wasn't a succesfull fectching", Toast.LENGTH_SHORT).show();
                }
                List<Comment> list = response.body();
                for (Comment myComment: list)
                {
                    txt.append(
                            "User Id : "+myComment.getPostId()+"\n" +
                                    "ID: "+myComment.getId()+"\n"+
                                    "Email : "+myComment.getEmail()+"\n"+
                                    "Name : "+myComment.getName()+"\n"+
                                    "TEXT : "+myComment.getBody()+"\n\n");
                }
            }
            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Couldn't fetch data", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
