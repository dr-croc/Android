    private lateinit var bd : ActivityRegistrationBinding
    lateinit var email: String
    lateinit var  password: String
    lateinit var  auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bd = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(bd.root)

        auth = Firebase.auth

        bd.regBtn.setOnClickListener {
          
            email = bd.regEmail.text.toString()
            password = bd.regPassword.text.toString()

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){ task -> // this thing doesnt come automatically. Do it manually
                if (task.isSuccessful){
                    Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(applicationContext, " Not Successful", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
