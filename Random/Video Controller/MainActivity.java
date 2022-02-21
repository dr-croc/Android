public class MainActivity extends AppCompatActivity {
    private VideoView videoView;

 private AlertDialog.Builder alertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView =findViewById(R.id.videoView);

        //Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"R.raw.videoNameInRawDirectory);
        videoView.setVideoURI(uri);

        // to control the video through media control
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);

        videoView.start();
        
    }

}
