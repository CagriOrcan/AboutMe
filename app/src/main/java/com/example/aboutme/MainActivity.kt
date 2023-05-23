package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Çağrı Orcan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //findViewById<Button>(R.id.btnDoneButton).setOnClickListener {
            //addNickname(it)
        binding.btnDoneButton.setOnClickListener {
            addNickname(it)
        }
        binding.myName = myName

        }

    private fun addNickname(view: View){
        binding.apply {
            myName?.nickname = binding.etNickName.text.toString()
            invalidateAll()
            etNickName.visibility = View.GONE
            view.visibility = View.GONE
            tvNickName.visibility = View.VISIBLE
        }
        // Hide Keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

    }




