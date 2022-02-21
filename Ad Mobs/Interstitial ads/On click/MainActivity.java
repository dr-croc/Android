import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        loadAd();
        

        Button button = findViewById(R.id.am1_second_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ad != null)
                {
                    ad.show(MainActivity.this);// THIS WILL VISIBLE THE ADD
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "FAILED TO LOAD", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    private void loadAd()
    {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, getString(R.string.ad), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                super.onAdLoaded(interstitialAd);
                Toast.makeText(getApplicationContext(), "loaded", Toast.LENGTH_SHORT).show();
                ad = interstitialAd; // if the add loaded then we set the add
                ad.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                        super.onAdFailedToShowFullScreenContent(adError);
                        Toast.makeText(getApplicationContext(), "Failed to show full screen", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        super.onAdShowedFullScreenContent();
                        Toast.makeText(getApplicationContext(), "Showed Full Screen", Toast.LENGTH_SHORT).show();

                        // reset the interstial add to avoid repitation
                       // ad =null;
                    }

                    @Override
                    public void onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent();
                        Toast.makeText(getApplicationContext(), "Dismissed full screen", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Toast.makeText(getApplicationContext(), "Not loaded", Toast.LENGTH_SHORT).show();
                ad = null; // if the add fail to load , we set it to null
            }

        });
    }
}
