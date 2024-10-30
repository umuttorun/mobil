package com.umut.storingdata

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.umut.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var kayit :SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        kayit = getSharedPreferences("com.umut.storingdata", MODE_PRIVATE)
        val userAge = kayit.getInt("age",0)
        if(userAge == 0){
            binding.textView.text = "Your age: "
        }
        else{
            binding.textView.text = userAge.toString()!!
        }


    }

    fun save(view: View){
   val age = binding.editText.text.toString().toIntOrNull()
        if(age!=null){
            binding.textView.text = age.toString()!!
            kayit.edit().putInt("age",age).apply()
        }
        else{
            binding.textView.text = "please enter your age by numbers"
        }
    }
    fun delete(view: View){
      val userAge = kayit.getInt("age",0)
        if(userAge!=0){
            kayit.edit().remove("age").apply()
            binding.textView.text = "Your age: "
    }

    }


}