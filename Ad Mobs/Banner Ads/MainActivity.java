public class MainActivity extends AppCompatActivity {
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        adView = findViewById(R.id.home_banner);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest); // this will show the add in app

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Toast.makeText(getApplicationContext(), "Banner Add closed", Toast.LENGTH_SHORT).show();  // it will work when you enter and leave the add
            }
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Toast.makeText(getApplicationContext(), "Failled to load", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAdOpened() {
                super.onAdOpened();
                Toast.makeText(getApplicationContext(), "Add opened", Toast.LENGTH_SHORT).show(); // it will work when you click the add and go to destination
            }
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Toast.makeText(getApplicationContext(), "Add loaded succesfully", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAdClicked() {
                super.onAdClicked();
                Toast.makeText(getApplicationContext(), "Add clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
