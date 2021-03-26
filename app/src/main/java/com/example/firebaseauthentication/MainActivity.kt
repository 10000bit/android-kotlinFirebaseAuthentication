package com.example.firebaseauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebaseauthentication.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val auth = Firebase.auth

        if (auth.currentUser == null) {
            startActivity(
                Intent(this, LoginActivity::class.java))
            finish()
        } else {
            //auth.currentUser?.uid
            binding.textView.text = auth.currentUser?.uid
        }

        binding.signoutbutton.setOnClickListener {
            auth.signOut()
            startActivity(
                Intent(this, LoginActivity::class.java))
            finish()

        }
    }
}