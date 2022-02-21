import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById(R.id.logan);

        WebSettings webSettings = web.getSettings();

        webSettings.setJavaScriptEnabled(true);

        web.setWebViewClient(new WebViewClient());// to show the web in our own andorid

        web.getSettings().setBuiltInZoomControls(true);// to set the zoom control

        web.loadUrl("https://www.youtube.com/");
    }
}
