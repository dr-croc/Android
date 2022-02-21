import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast

import com.example.kotlinviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var  binding: ActivityMainBinding
    lateinit var radioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDisplay.setOnClickListener {
            val selectedButton: Int = binding.radioGroup!!.checkedRadioButtonId
            radioButton = findViewById(selectedButton)
            Toast.makeText(baseContext, radioButton.text, Toast.LENGTH_SHORT).show()
            binding.result.setText(radioButton.text)
        }
    }
}
