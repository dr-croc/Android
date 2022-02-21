1.// paste it inside the main activity and call this function
if( ! CheckNetwork.isInternetAvailable(this)) //returns true if internet available
        {
            checkInternetEntering(); 
        }

2. // create method
  
   void checkInternetEntering()
    {
        //if there is no internet do this
        setContentView(R.layout.activity_main);

        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)//alert the person knowing they are about to close
                .setTitle("No internet connection available")
                .setMessage("Please Check you're Mobile data or Wifi network.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();
    }

3. // create class
  
class CheckNetwork {

    private static final String TAG = CheckNetwork.class.getSimpleName();

    public static boolean isInternetAvailable(Context context)
    {
        NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

        if (info == null)
        {
            Log.d(TAG,"no internet connection");
            return false;
        }
        else
        {
            if(info.isConnected())
            {
                Log.d(TAG," internet connection available...");
                return true;
            }
            else
            {
                Log.d(TAG," internet connection");
                return true;
            }

        }
    }
}
  
