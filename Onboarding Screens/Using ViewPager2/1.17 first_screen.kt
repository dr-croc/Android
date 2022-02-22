import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlinrecyclerview.R
import com.example.kotlinrecyclerview.databinding.FragmentFirstScreenBinding
import com.example.kotlinrecyclerview.databinding.FragmentViewPagerBinding

class first_screen : Fragment() {

    var _bind: FragmentFirstScreenBinding? = null
    val binding get() = _bind!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _bind = FragmentFirstScreenBinding.inflate(inflater, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.fragment_view_pager) // getting the viewPager from fragment_view_pager


        _bind!!.next.setOnClickListener {
            viewPager?.currentItem = 1 // starts from 0. so 1 means second onboarding view
        }
        return binding!!.root
    }
}
