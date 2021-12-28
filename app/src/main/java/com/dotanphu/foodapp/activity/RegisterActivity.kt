package com.dotanphu.foodapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.dotanphu.foodapp.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnSignUp.setOnClickListener {
            CheckRegister()
        }

    }

    private var name = ""
    private var email = ""
    private var password = ""
    private fun CheckRegister() {
        //input du lieu
        name = binding.edtName.text.toString().trim()
        email = binding.edtEmail.text.toString().trim()
        password = binding.edtPassword.text.toString().trim()
        val cPassword = binding.edtConFirmPassword.text.toString().trim()
        //validate data
        if (name.isEmpty()) {
            //empty name
            Toast.makeText(this, "Please enter the name", Toast.LENGTH_SHORT).show()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Please enter the correct email format", Toast.LENGTH_SHORT).show()
        } else if (password.isEmpty()) {
            Toast.makeText(this, "Please enter the password", Toast.LENGTH_SHORT).show()
        } else if (cPassword.isEmpty()) {
            Toast.makeText(this, "Please re-enter your password", Toast.LENGTH_SHORT).show()
        } else if (password != cPassword) {
            Toast.makeText(this, "Password not same, enter again", Toast.LENGTH_SHORT).show()
        } else {
            createUserAccount()
        }
    }

    private fun createUserAccount() {
        //tao user trong firebase auth
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            updateUserInfor()
        }.addOnFailureListener {
            Toast.makeText(this, "Account creation failed please check again", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun updateUserInfor() {
        //lấy uid người dùng hiện tại vì người dùng đã được đăng ký để có thể lấy ngay
        val uid = firebaseAuth.uid

        //setup dữ liệu để thêm vào db
        val hashMap: HashMap<String, Any> = HashMap()
        hashMap["uid"] = uid!!
        hashMap["email"] = email
        hashMap["name"] = name
        hashMap["password"] = password

        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(uid).setValue(hashMap).addOnSuccessListener {
            Toast.makeText(this, "Account successfully created", Toast.LENGTH_SHORT)
                .show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }.addOnFailureListener {
            Toast.makeText(this, "Account creation failed", Toast.LENGTH_SHORT)
                .show()
        }
    }
}