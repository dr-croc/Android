class MainActivity : AppCompatActivity() {

    private  lateinit var  binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences: SharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE)

        binding.btnSave.setOnClickListener {
            var name : String = binding.edtEnterName.text.toString()
            var age : String = binding.edtAge.text.toString()

            val editor: SharedPreferences.Editor =  sharedPreferences.edit()

            editor.putString("userName", name)
            editor.putString("userAge", age)
            editor.commit()
        }
        binding.btnView.setOnClickListener {
            if(sharedPreferences.contains("userName") && sharedPreferences.contains("userAge"))
            {
                var name = sharedPreferences.getString("userName", " Data not found")
                var age = sharedPreferences.getString("userAge", " Data not found")
                binding.txtResult.setText("name :"+ name +" Age : "+ age)
            }
            else
            {
                Toast.makeText(applicationContext,"No data found" ,Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnClear.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            binding.txtResult.setText("")
        }
    }
}
