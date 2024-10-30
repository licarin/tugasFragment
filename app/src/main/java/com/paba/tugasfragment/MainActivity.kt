package com.paba.tugasfragment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var angka = 99
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.frameContainer)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        showFragmentSatu()

        val button1 = findViewById<Button>(R.id.fSatu)
        val button2 = findViewById<Button>(R.id.fDua)
        val button3 = findViewById<Button>(R.id.fTiga)

        button1.setOnClickListener {
            angka -= 1
            showFragmentSatu()
        }

        button2.setOnClickListener {
            angka -= 2
            showFragmentDua()
        }

        button3.setOnClickListener {
            angka -= 3
            showFragmentTiga()
        }
    }

    private fun showFragmentSatu() {
        val mFragmentManager = supportFragmentManager
        val mfSatu = fSatu().apply {
            arguments = Bundle().apply {
                putString("ANGKA", angka.toString())
            }
        }
        mFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, mfSatu, fSatu::class.java.simpleName).commit()
    }

    private fun showFragmentDua() {
        val mFragmentManager = supportFragmentManager
        val mfDua = fDua().apply {
            arguments = Bundle().apply {
                putString("ANGKA", angka.toString())
            }
        }
        mFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, mfDua, fDua::class.java.simpleName).commit()
    }

    private fun showFragmentTiga() {
        val mFragmentManager = supportFragmentManager
        val mfTiga = fTiga().apply {
            arguments = Bundle().apply {
                putString("ANGKA", angka.toString())
            }
        }
        mFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, mfTiga, fTiga::class.java.simpleName).commit()
    }
}