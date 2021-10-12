package com.arthasukma.moveactivitity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arthasukma.moveactivitity.model.user
import kotlinx.android.synthetic.main.activity_explicit_intent.*

class parcelActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER ="extra user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcel)

        val user = intent.getParcelableArrayListExtra<user>(EXTRA_USER) as user
        btn_back.setOnClickListener {
            val backItem = Intent (this@parcelActivity,MainActivity::class.java)
            startActivity(backItem)
        }
    }
}