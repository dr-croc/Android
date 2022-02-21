public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_save, btn_load;
    private EditText edt_name, edt_password;
    private TextView txt_name, txt_passeword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_name = findViewById(R.id.edt_EnterName);
        edt_password = findViewById(R.id.edt_EnterPassword);
      
        txt_name = findViewById(R.id.txt_name);
        txt_passeword = findViewById(R.id.txt_password);
      
        btn_load = findViewById(R.id.btn_am1_load);
        btn_save = findViewById(R.id.btn_am1_save);

        btn_save.setOnClickListener(this);
        btn_load.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_am1_save)
        {
            String userName = edt_name.getText().toString();
            String userPassword = edt_password.getText().toString();

            if(userName.equals("")&& userPassword.equals(""))
            {
                Toast.makeText(this, "Please Enter some data", Toast.LENGTH_SHORT).show();
            }
            else
            {
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();  // this method will write the data

                //here you put the value or store the value with a key
                editor.putString("userNameKey",userName);
                editor.putString("passwordKey",userPassword);  
                
                editor.commit();  // to save the date
                Toast.makeText(this, "Data Stored Succesfully", Toast.LENGTH_SHORT).show();
            }
        }
        if(v.getId() == R.id.btn_am1_load)
        {
                // to read data
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
          
                if(sharedPreferences.contains("userNameKey")&& sharedPreferences.contains("passwordKey")) {
                  
                    // here the getString method first take the key and default value
                    String username = sharedPreferences.getString("userNameKey", "Data Not found");
                    String userPassword = sharedPreferences.getString("passwordKey", "Data Not found");

                    // set The value
                    txt_name.setText(username);
                    txt_passeword.setText(userPassword);
                }
        }
    }
    
    // to get the data in another activity
    public string getUserName()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("userNameKey", "Data Not found");
    }
    public string getUserPassword()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("passwordKey", "Data Not found");
    }
    
    
    
    
    
}
