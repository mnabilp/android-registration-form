package com.ksmandroid.tugasandroid.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ksmandroid.tugasandroid.R
import kotlinx.android.synthetic.main.activity_display_form.*

class DisplayFormActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_form)

        initiateUI()
    }

    private fun initiateUI() {

        btn_back_display_form.setOnClickListener(this)
        btn_close_display_form.setOnClickListener(this)

        val intent = intent

        tv_name_item_display_form.text = intent.getStringExtra("USER_NAME")
        tv_nim_item_display_form.text = intent.getStringExtra("USER_ID")
        tv_jurusan_item_display_form.text = intent.getStringExtra("USER_MAJOR")
        tv_jenis_kelamin_item_display_form.text = intent.getStringExtra("USER_GENDER")
        tv_alamat_item_display_form.text = intent.getStringExtra("USER_ADDRESS")
        tv_tanggal_lahir_item_display_form.text = intent.getStringExtra("USER_BIRTHDATE_DAY")
        tv_bulan_lahir_item_display_form.text = intent.getStringExtra("USER_BIRTHDATE_MONTH")
        tv_tahun_lahir_item_display_form.text = intent.getStringExtra("USER_BIRTHDATE_YEAR")


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_back_display_form -> {
                onBackPressed()
            }
            R.id.btn_close_display_form -> {
                val intent = Intent(this, HomeActivity::class.java)

                startActivity(intent)
            }
        }
    }
}