import androidx.appcompat.app.AppCompatActivity;

import android.hardware.lights.LightsManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AsyncCache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView txt_name;
    private Button button1;
    private RequestQueue requestQueue;

    /*String name, age;
    private  static  String JSON_url ="https://run.mocky.io/v3/4f371412-f726-48e4-b57f-5013e25caf6f";
    ArrayList<HashMap<String,String>> friendsList;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_name = findViewById(R.id.am_txt_showData);
        button1 = findViewById(R.id.am_btn_fetchData);

        requestQueue = Volley.newRequestQueue(this);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();
            }
        });





       /* friendsList = new ArrayList<>();
        lv = findViewById(R.id.listView);*/

    }

    private void jsonParse() {
        String url ="https://mocki.io/v1/dc1d925a-fa83-4b7b-bcf4-756c5eabc918";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("Friends");

                            for(int i=0; i<jsonArray.length();i++)
                            {
                                JSONObject friends = jsonArray.getJSONObject(i);
                                String first_name = friends.getString("name");
                                txt_name.append(first_name);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(request);

    }

    /*public class GetData extends AsyncTask<String, String, String>{


        @Override
        protected String doInBackground(String... strings) {
            String current  =  "";

            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(JSON_url);
                    urlConnection = (HttpURLConnection) url.openConnection();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            }
            catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }*/

}


//        RequestQueue requestQueue;
//        requestQueue = Volley.newRequestQueue(this);
//
//        JsonObjectRequest jsonObjectRequest =  new JsonObjectRequest(Request.Method.GET,
//                "https://jsonplaceholder.typicode.com/todos/1",
//                null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            Log.d("myApp","The Response is "+ response.getString("completed"));
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//               // Log.d("myApp","Something went wrong");
//                Toast.makeText(getApplicationContext(), "Issues", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        requestQueue.add(jsonObjectRequest);


/*
{
        "Friends":[
        {
        "age": 28,
        "name": "Mohammad"
        },

        {
        "age": 25,
        "name": "Hussein"
        },

        {
        "age": 30,
        "name": "Ali"
        }
        ]
        }*/
