import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    lateinit var  txt: TextView
    lateinit var  btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn = findViewById(R.id.btn_result_kt)
        txt = findViewById(R.id.txt_resut_kt)
        btn.setOnClickListener {
            txt.setText(
                getAppFromModel().app_name + "\n Downloads :"+
                getAppFromModel().appDownload+ "\n Rating :"+
                getAppFromModel().appRating
            )
        }
    }

    fun getAppFromModel(): mvc_model_2 {
        // retuning an object from my model
        return mvc_model_2("master Coding app", 90000, 4)
    }
}
