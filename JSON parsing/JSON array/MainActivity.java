public class MainActivity extends AppCompatActivity {

    private TextView txt_name;
    private Button button1;
    private RequestQueue requestQueue;

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

    }

    private void jsonParse() {
        String url = "https://mocki.io/v1/dc1d925a-fa83-4b7b-bcf4-756c5eabc918";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("Friends");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject friends = jsonArray.getJSONObject(i);
                                String first_name = friends.getString("name");
                                txt_name.append(first_name+"\n");
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
}
