import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlinrecyclerview.R

class second_Screen : Fragment() {
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_second__screen, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.fragment_view_pager) // getting the viewPager from fragment_view_pager
        
        view.findViewById<TextView>(R.id.second_next).setOnClickListener {
            viewPager?.currentItem = 2 // 3rd screen of on boarding screen
        }
        return view
    }
}
