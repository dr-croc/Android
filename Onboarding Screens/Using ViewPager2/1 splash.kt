import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.kotlinrecyclerview.Home.Home_activity
import com.example.kotlinrecyclerview.MainActivity
import com.example.kotlinrecyclerview.R

class Splash : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Handler().postDelayed({
            //findNavController().navigate(R.id.action_splash_to_viewPagerFragment)
            // point 14
            if(onBoardingFinished()){
                Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show()
                startActivity(Intent(activity, Home_activity::class.java))
            }
            else{
                findNavController().navigate(R.id.action_splash_to_viewPagerFragment) // from my nav.xml
            }
        },3000)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
    // point 14
    private  fun onBoardingFinished() : Boolean{
        val sharedPreferences = requireActivity().getSharedPreferences("On boarding", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("Finished",false)
    }
}
