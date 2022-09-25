import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt_resut);
        btn = findViewById(R.id.btn_result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(
                        getAppFromModel().getAppName()+"\n Download : "+
                        getAppFromModel().getAppDownload() + "\n App Rating : "+
                                getAppFromModel().getAppRating()
                        );
            }
        });

    }


    public  mvc_model getAppFromModel()
    {
        // retuning an object from my model
        return new mvc_model("master Coding app", 90000,4);
    }

    // so here
    // Full meaning of MVC
    // Model View Controller
    // Model -> mvc_model.java -> where we are getting the data base from
    // View -> TextView -> for showing the data
    // Controller -> MainActivity.java -> button request from the activity for the data
}
