package com.dotanphu.foodapp.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dotanphu.foodapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {
            if (binding.edtEmail.text.toString()
                    .equals("sonmapvnn123") && binding.edtPassword.text.toString().equals("123456")
            ) {
                intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Sai tài khoản or mật khẩu", Toast.LENGTH_LONG).show()
            }
        }

        binding.imgGoogle.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data =
                    Uri.parse("https://play.google.com/store/apps/details?id=com.example.android")
                setPackage("com.android.vending")
            }
            startActivity(intent)
        }
    }
}