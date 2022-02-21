class MainActivity : AppCompatActivity() {

    private  lateinit var  binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.btnClick.setOnClickListener {
           Toast.makeText(this,"You have done it ",Toast.LENGTH_LONG).show()
       }
    }
}
