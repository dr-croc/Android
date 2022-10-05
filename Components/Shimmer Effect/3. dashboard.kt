package com.example.whatsappclonejava.dashBoard

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.whatsappclonejava.R
import com.example.whatsappclonejava.UserProfile.UserModelClass
import com.example.whatsappclonejava.databinding.ActivityDashBoardBinding
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.Exception


class DashBoard : AppCompatActivity() {

    lateinit var bind_dashboard:  ActivityDashBoardBinding
    lateinit var database: FirebaseDatabase
    lateinit var usersList: ArrayList<UserModelClass>
    lateinit var userAdapter: UserAdapter
    lateinit var shimmer_: ShimmerFrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind_dashboard = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(bind_dashboard.root)

        supportActionBar!!.title = "Whats App"

        database = FirebaseDatabase.getInstance()
        usersList = ArrayList<UserModelClass>()

        userAdapter  = UserAdapter(applicationContext, usersList)

        // for shimmer effect
        shimmer_ = findViewById(R.id.shimmer)
        shimmer_.startShimmer()

        bind_dashboard.dashboardRecyclerView.adapter = userAdapter
        // getting data from firebase databse
            database.reference.child("users").addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    usersList.clear()// clear the list before hand
                    for(snapshot1 in snapshot.children) // adding the childerns of the user, which are unique uid, to the user list
                    {
                        val user: UserModelClass? = snapshot1.getValue(UserModelClass::class.java)
                        if(!user?.uid.equals(FirebaseAuth.getInstance().uid))
                        {
                            usersList.add(user!!)
                        }
                    }
                    userAdapter.notifyDataSetChanged()

                    // after shimmer effect
                    shimmer_.stopShimmer()
                    shimmer_.visibility =View.GONE
                    bind_dashboard.dashboardRecyclerView.visibility = View.VISIBLE
                }
                override fun onCancelled(error: DatabaseError) {
                }
            })
    }

    // for the action bar icons
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    // for top menu item selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_search)
        {
            Toast.makeText(applicationContext, "Search Clicked", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
