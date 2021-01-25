package com.marcheilla.appmarcheilla.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.marcheilla.appmarcheilla.R
import com.marcheilla.appmarcheilla.databinding.ActivityMainBinding
import com.marcheilla.appmarcheilla.ui.auth.AppMarcheillaAuth
import com.marcheilla.appmarcheilla.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.buttonLogout.setOnClickListener{
//            AppMarcheillaAuth.logout(this){
//                startActivity(Intent(this, AuthActivity::class.java))
//                finish()
//            }
//        }

        init()
    }

    private fun init() {
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> navigate(R.id.homeFragment)
                R.id.ic_news -> navigate(R.id.newsFragment)
                R.id.ic_favorit -> navigate(R.id.favoriteFragment)
                R.id.ic_profile -> navigate(R.id.profileFragment)
                else -> false
            }
        }
    }

    private fun navigate(id : Int): Boolean {
        findNavController(R.id.navHost).navigate(id)
        return true
    }


}