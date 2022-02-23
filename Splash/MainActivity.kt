class MainActivity : AppCompatActivity() {

    private  lateinit var  binding:ActivityMainBinding

    lateinit var  handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        Handler().postDelayed({
            startActivity(Intent(this, log_in::class.java))
            finish() // pressing back will not go back
        }, 3000)
        
    }
}
