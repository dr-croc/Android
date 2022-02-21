import androidx.appcompat.app.AppCompatActivity;

import android.hardware.lights.LightsManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {

    EditText edt1;
    TextView txt;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.am_edt_getData);
        txt = findViewById(R.id.am_txt_displayData);
        btn = findViewById(R.id.am_btn_fetchData);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String apiKey = "9760ba6f5170f47a7a52b9a340e50c53";
                String city = edt1.getText().toString();
                String url ="https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=9760ba6f5170f47a7a52b9a340e50c53";

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONObject object =  response.getJSONObject("main");
                                    String temperature = object.getString("temp");
                                    txt.setText(temperature);
                                } catch (JSONException e) {
                                    Toast.makeText(MainActivity.this, "This Error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
                queue.add(request);
            }
        });



    }

}
