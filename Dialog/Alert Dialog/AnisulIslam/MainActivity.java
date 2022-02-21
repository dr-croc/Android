public class MainActivity extends AppCompatActivity implements View.OnClickListener{
 private Button exit;

 private AlertDialog.Builder alertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exit = findViewById(R.id.exitButton);
        exit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        // for setting title
        alertDialogBuilder.setTitle("Alert Title");

        // for setting message
        alertDialogBuilder.setMessage("Do you want to exit");

        // for setting icon
        alertDialogBuilder.setIcon(R.drawable.minus);

        // if you want that your alert diallog will not cancel out even if any part of screen pressed

        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Toast.makeText(MainActivity.this, "Come back again", Toast.LENGTH_SHORT).show();
            }
        });



        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(MainActivity.this, "Returned Back", Toast.LENGTH_SHORT).show();
            }
        });



        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });



        // to show the alert dialog we need to write this code as well
        AlertDialog alertDialog = alertDialogBuilder.create();

        // this show method will show the alertDialog
        alertDialog.show();



    }
}
