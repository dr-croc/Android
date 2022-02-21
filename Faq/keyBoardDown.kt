// create this method and call it from your button. You will need  this > @RequiresApi(Build.VERSION_CODES.M). Alt enter to get.
// if the keyboard is not opened, it wont show any error

@RequiresApi(Build.VERSION_CODES.M)
    fun dismissKeyboard(activity: Activity) {
        val imm: InputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (null != activity.currentFocus) imm.hideSoftInputFromWindow(
            activity.currentFocus!!
                .applicationWindowToken, 0
        )
    }
