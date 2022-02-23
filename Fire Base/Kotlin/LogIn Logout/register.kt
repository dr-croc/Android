lateinit var  firebaseAuth: FirebaseAuth // declare as a global
// inside main
firebaseAuth = FirebaseAuth.getInstance()

// send value
registerUser(name, email, password) 


fun registerUser(name: String?, email: String?, password: String?) {
        firebaseAuth.createUserWithEmailAndPassword(email!!, password!!)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Task Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, home::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Failed Registration", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
