 am.amBtnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismissKeyboard(MainActivity.this); // to dismiss key
                String apiKey = "9760ba6f5170f47a7a52b9a340e50c53";
                String cityName = am.amEdtEnterCity.getText().toString();
                String url = "https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=9760ba6f5170f47a7a52b9a340e50c53";

                // to request for data
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // find the json object where your data is
                        try {
                            JSONObject object = response.getJSONObject("main");
                            String temp = object.getString("temp");
                            String humid = object.getString("humidity");
                            Double cel = Double.parseDouble(temp)-273.15;
                            String celcius = cel.toString().substring(0,5);

                            JSONObject object2 = response.getJSONObject("wind");
                            String speed = object2.getString("speed");
                            am.amTxtSetTemp.setText(celcius+ " °");
                            am.amTxtSetHumid.setText(humid);
                            am.amTxtSetWind.setText(speed+" ms");

                            // to get the json array
                            JSONArray jsonArray = response.getJSONArray("weather");
                            JSONObject mousam = jsonArray.getJSONObject(0);
                            am.amTxtSetWeather.setText(mousam.getString("main"));


                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), "Check Internet Connection", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                        new Response.ErrorListener() { // to check error
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Pleas enter Valid Country", Toast.LENGTH_SHORT).show();
                    }
                } );
                queue.add(request);
            }
        });

