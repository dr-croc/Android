class third_screen : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_third_screen, container, false)

        view.findViewById<TextView>(R.id.finish_screen).setOnClickListener {
            //findNavController().navigate(R.id.action_viewPagerFragment_to_home3)
            startActivity(Intent(activity, Home_activity::class.java))
            onBoardingFinished() // declares the end
        }
        return view
    }

    private  fun onBoardingFinished(){
        val sharedPreferences = requireActivity().getSharedPreferences("On boarding", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}
