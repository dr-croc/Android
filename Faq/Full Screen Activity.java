/*To get the full screen
Go to the styles.xm
Change the parent to No action bar
parent = "Theme.AppCompat.DayNight.NoActionBar"

to remove the you need work in  Main activity. Java 
brfore setContentView;
*/
super.onCreate(savedInstanceState);

//to delete the title baR
requestWindowFeature(Window.FEATURE_NO_TITLE);

// remove the notification bar or the title bar
getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
setContentView(R.layout.activity_main);
