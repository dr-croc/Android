lateinit var email : String
lateinit  var password : String
lateinit var  name : String
var emailPattern =  "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()




            if(name.isBlank() || email.isBlank() || password.isBlank())
            { Toast.makeText(applicationContext, "Please fill up the credential", Toast.LENGTH_SHORT).show() }

            if(password.length< 6)
            { singUpBinding.edtSignUpPassword.setError("Password less than 6") }

            if(!email.matches(emailPattern))
            { Toast.makeText(applicationContext, "Email Can't Be accepted", Toast.LENGTH_SHORT).show()}
