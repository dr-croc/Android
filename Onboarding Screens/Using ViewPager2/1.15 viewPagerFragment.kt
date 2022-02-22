import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinrecyclerview.OnBoarding2.screens.first_screen
import com.example.kotlinrecyclerview.OnBoarding2.screens.second_Screen
import com.example.kotlinrecyclerview.OnBoarding2.screens.third_screen
import com.example.kotlinrecyclerview.R
import com.example.kotlinrecyclerview.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {
    // for binding
    var _binding: FragmentViewPagerBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View { // remove the ? after view
        /*
        * val  view =  inflater.inflate(R.layout.fragment_view_pager, container, false) > instead of this
        * now this to inflate the layout
        *  _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        * */

        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)

        val fragmentList = arrayListOf<Fragment>(
            first_screen(),
            second_Screen(),
            third_screen()
        )// create the fragment list

        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle) // sending to fragment adapter

        _binding!!.fragmentViewPager.adapter = adapter // bind the adapter

        return binding.root // return
    }

}
