class log_in : AppCompatActivity() {

    private  lateinit var binding: ActivityLogInBinding
    var auth: FirebaseAuth? = null
    lateinit var email : String
    lateinit var password : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_log_in)*/
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.logInButton.setOnClickListener {
            email = binding.logInEmail.text.toString()
            password = binding.logInPassword.text.toString()
            // condtions befor sending for login
             logIn(email, password) 
        }
    }


fun  logIn(email:String, password:String){
        auth?.signInWithEmailAndPassword(email,password)
            ?.addOnSuccessListener {
                Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, home::class.java))
                finish()
            }
    }
