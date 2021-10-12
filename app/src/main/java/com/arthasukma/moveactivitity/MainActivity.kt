package com.arthasukma.moveactivitity

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val RESULT_CODE = 200
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_simple_intent.setOnClickListener {
            val simpleIntent = Intent(this@MainActivity, SimpleActivity::class.java)
            startActivity(simpleIntent)
        }

        btn_intent_with_data.setOnClickListener {
            val dataIntent = Intent(this@MainActivity, ExplicitIntentActivity::class.java)
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_NAME, "Meisya Nurdianita")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_EMAIL, "Meisyanrdnt08@gmail.com")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_AGE, "19 Tahun")
            startActivity(dataIntent)


        }

        btn_intent_with_paracelable.setOnClickListener {
            val parcelIntent = Intent(this@MainActivity, parcelActivity::class.java)
            startActivity(parcelIntent)
        }

        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "089673643839"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }

        btn_intent_result.setOnClickListener {
            val intent = Intent(this@MainActivity, resultActivity::class.java)
            startActivityForResult(intent, RESULT_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == 200){
            val color = data?.getStringExtra(resultActivity.EXTRA_COLOR)
            Log.d("Color", color.toString())
            view_result.setBackgroundColor(Color.parseColor(color.toString()))
        }


    }
}