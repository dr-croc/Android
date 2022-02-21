binding.btnGoToNextPage.setOnClickListener {
            val snackBar = Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG)

            snackBar.setActionTextColor(Color.BLUE)
            val snackBarView = snackBar.view
            snackBarView.setBackgroundColor(Color.BLACK)
            val textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
            textView.setTextColor(Color.WHITE)
            snackBar.show()
        }
