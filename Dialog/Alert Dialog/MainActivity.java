
 public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
        exitByBackKey();

        //moveTaskToBack(false);

        return true;
    }
    return super.onKeyDown(keyCode, event);
}

protected void exitByBackKey() {

    AlertDialog alertbox = new AlertDialog.Builder(this)
    .setMessage("Do you want to exit application?")
    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

        // do something when the button is clicked
        public void onClick(DialogInterface arg0, int arg1) {

            finish();
            //close();


        }
    })
    .setNegativeButton("No", new DialogInterface.OnClickListener() {

        // do something when the button is clicked
        public void onClick(DialogInterface arg0, int arg1) {
                       }
    })
      .show();

}
