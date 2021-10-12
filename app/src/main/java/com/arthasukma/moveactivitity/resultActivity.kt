package com.arthasukma.moveactivitity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_result2.*
import kotlinx.android.synthetic.main.activity_result2.*

class resultActivity : AppCompatActivity() {
    companion object{
        const val RESULT_CODE = 200
        const val EXTRA_COLOR = "extra_color"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        btn_result.setOnClickListener {
            if(rg_color.checkedRadioButtonId != 0){
                var value = "#ffffff"
                when(rg_color.checkedRadioButtonId){
                    R.id.radio_biru -> value = "#0000ff"
                    R.id.radio_hitam -> value = "#000000"
                    R.id.radio_hijau -> value = "#00ff00"
                    R.id.radio_merah -> value = "#dc143c"
                }
                Log.d("selected Color", value.toString())
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_COLOR, value)
                setResult(200, resultIntent)
                finish()
            }
        }
    }
}