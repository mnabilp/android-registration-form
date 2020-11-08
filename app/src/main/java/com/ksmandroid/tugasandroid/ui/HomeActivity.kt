package com.ksmandroid.tugasandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ksmandroid.tugasandroid.R
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.intentFor

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btn_registration_form.setOnClickListener {
            startActivity(intentFor<RegistrationFormActivity>())
        }
    }

}