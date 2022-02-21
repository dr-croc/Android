
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

       // putPost(); // when you dont pass anything by put post it will automatically set it at null
       // patchPost(); // but in patch post if you send null it wont change the vlaue

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

    /*private void getComments() {
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
    }*/

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
