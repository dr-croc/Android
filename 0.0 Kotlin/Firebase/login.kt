class login : AppCompatActivity() {

    private  lateinit var  log: ActivityLoginBinding
    lateinit var email: String
    lateinit var  password: String
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        log = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(log.root)

        auth = Firebase.auth

        log.logBtn.setOnClickListener {
            email = log.logEmail.text.toString()
            password = log.logPassword.toString()

            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener (this){task ->
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
