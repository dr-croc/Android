
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast

import com.example.kotlinviewbinding.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private  lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDisplay.setOnClickListener {
            var totalAmount: Int = 0
            var result = StringBuilder()

            result.append("Seleted Items")

            if (binding.checkBox1.isChecked) {
                result.append("\nPizza 100$")
                totalAmount += 100
            }

            if (binding.checkBox2.isChecked) {
                result.append("\nCoffee 50$")
                totalAmount += 50
            }

            if (binding.checkBox3.isChecked) {
                result.append("\nPizza 120$")
                totalAmount += 120
            }

            result.append("\nIn total: " + totalAmount + "$")
            Toast.makeText(applicationContext, result.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
