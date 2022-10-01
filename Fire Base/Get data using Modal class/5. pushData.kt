import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.whatsappclonejava.MainActivity
import com.example.whatsappclonejava.databinding.ActivitySetUpProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class SetUpProfile : AppCompatActivity() {

   lateinit var profile_bind: ActivitySetUpProfileBinding

   lateinit var auth: FirebaseAuth
   lateinit var database: FirebaseDatabase
   lateinit var storage: FirebaseStorage

   lateinit var selectedImageUri: Uri

   lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profile_bind = ActivitySetUpProfileBinding.inflate(layoutInflater)
        setContentView(profile_bind.root)
        supportActionBar!!.title = "SetUp Profile"

        //get all the instance of your firebase
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        storage = FirebaseStorage.getInstance()

        // progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Setting up profile....")
        progressDialog.setCancelable(false)


        // on click -> opening the gallery for image, in startActivity for resutl we will set the image
        profile_bind.imgProfileImage.setOnClickListener {
            var intent: Intent = Intent()
            intent.setAction(Intent.ACTION_GET_CONTENT)
            intent.setType("images/*")
            startActivityForResult(intent, 405) // go to the onActivityResult where you get the image and set the image
        }

        profile_bind.btnSaveImageName.setOnClickListener {

            var name : String = profile_bind.edtProfileName.text.toString()
            if(name.isEmpty() || selectedImageUri == null)
            {
                profile_bind.edtProfileName.setError("No name")
                Toast.makeText(applicationContext, "NO image Detected", Toast.LENGTH_SHORT).show()
            }

            else
            {
                progressDialog.show()
                // saving the image in the storage
                var reference: StorageReference = storage.getReference().child("Profiles").child(auth.uid!!)// saves the image with unique uid and branch named 'Profiles'

                reference.putFile(selectedImageUri).addOnCompleteListener { task ->
                    if (task.isSuccessful){ // at this stage, image saved in the storage successfully
                        // now get the url, so that we can save the image
                        reference.downloadUrl.addOnSuccessListener { uri ->
                            var image_url_frm_firbase = uri.toString()
                            val uid = auth.uid
                            val phone = auth.currentUser!!.phoneNumber
                            val name: String = profile_bind.edtProfileName.text.toString()
                            var userModelClass = UserModelClass(uid,name,phone,image_url_frm_firbase)
                            // -> adding them in firebase database
                            database.getReference()
                                .child("users")
                                .child(uid!!) // under users branch using the unique id by different user will be created
                                .setValue(userModelClass)
                                .addOnSuccessListener { void ->
                                    progressDialog.dismiss()
                                    Toast.makeText(applicationContext, "Profile SetUp successful", Toast.LENGTH_SHORT).show()
                                    startActivity(Intent(applicationContext, MainActivity::class.java))
                                    finish()
                                }
                                .addOnFailureListener{ Exception  ->
                                    progressDialog.dismiss()
                                    Toast.makeText(applicationContext, "Failed to  SetUp Profile", Toast.LENGTH_SHORT).show()
                                }
                        }
                    }
                }
            }


        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data != null && requestCode == 405 && resultCode == RESULT_OK)
        {
            if(data.data !=null)
            {
                profile_bind.imgProfileImage.setImageURI(data.data)
                selectedImageUri = data.data!! // holding the image in a variable
            }
        }
    }
}

/*
* 1. get the instance
* 2. get the image from gallery
* 3. get the image uri from from OnActitvity.result
* 4. store the image in Storage
* 5. get the imageUri from there usingDowload url
* 6. then set the other value in the for storing them in the database
* 7. using the user model class, send the model class in the refrences
* 8. then check if the data stored successfully
* 9. then toast.
*
* */
