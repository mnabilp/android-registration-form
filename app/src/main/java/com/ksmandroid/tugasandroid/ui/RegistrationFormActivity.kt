package com.ksmandroid.tugasandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.RadioButton
import com.ksmandroid.tugasandroid.R
import kotlinx.android.synthetic.main.activity_registration_form.*

class RegistrationFormActivity : AppCompatActivity(), View.OnClickListener {

    private var userName = ""
    private var userId = ""
    private var userMajor = ""
    private var userGender = ""
    private var userAddress = ""
    private var birthDateDay = ""
    private var birthDateMonth = ""
    private var birthDateYear = ""

    private val inputData: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            userName = et_name_item_registration_form.text.toString().trim()
            userId = et_nim_item_registration_form.text.toString().trim()
            userMajor = et_jurusan_item_registration_form.text.toString().trim()
            userAddress = et_alamat_item_registration_form.text.toString().trim()
            birthDateDay = et_tanggal_lahir_item_registration_form.text.toString().trim()
            birthDateMonth = et_bulan_lahir_item_registration_form.text.toString().trim()
            birthDateYear = et_tahun_lahir_item_registration_form.text.toString().trim()

            enableSaveBtn()
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_form)

        et_name_item_registration_form.addTextChangedListener(inputData)
        et_nim_item_registration_form.addTextChangedListener(inputData)
        et_jurusan_item_registration_form.addTextChangedListener(inputData)
        rbg_jenis_kelamin_registration_form.setOnCheckedChangeListener { _, radiobutton ->
            val userGender: RadioButton = findViewById(radiobutton)
            this.userGender = userGender.text.toString().trim()
        }
        et_alamat_item_registration_form.addTextChangedListener(inputData)
        et_tanggal_lahir_item_registration_form.addTextChangedListener(inputData)
        et_bulan_lahir_item_registration_form.addTextChangedListener(inputData)
        et_tahun_lahir_item_registration_form.addTextChangedListener(inputData)

        initiateUI()
    }

    private fun initiateUI() {
        btn_back_registration_form.setOnClickListener(this)
        btn_save_registration_form.setOnClickListener(this)
    }

    private fun enableSaveBtn() {
        btn_save_registration_form.setEnabled(
            !userName.isEmpty() && !userAddress.isEmpty() &&
                    !userId.isEmpty() && !userMajor.isEmpty() && !birthDateDay.isEmpty()
                    && !birthDateMonth.isEmpty() && !birthDateYear.isEmpty()
        )
        if (!userName.isEmpty() && !userAddress.isEmpty() &&
            !userId.isEmpty() && !userMajor.isEmpty() && !birthDateDay.isEmpty()
            && !birthDateMonth.isEmpty() && !birthDateYear.isEmpty()
        ) {
            btn_save_registration_form.setBackgroundColor(getColor(R.color.colorGrayLighter))
            btn_save_registration_form.setTextColor(getColor(R.color.colorWhite))
        } else if (userName.isEmpty() && userAddress.isEmpty() &&
            userId.isEmpty() && userMajor.isEmpty() && birthDateDay.isEmpty()
            && birthDateMonth.isEmpty() && birthDateYear.isEmpty()
        ) {
            btn_save_registration_form.setBackgroundColor(getColor(R.color.colorGray))
            btn_save_registration_form.setTextColor(getColor(R.color.colorDarkerGray))
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_save_registration_form -> {
                val intent = Intent(this, DisplayFormActivity::class.java)

                intent.putExtra("USER_NAME", userName)
                intent.putExtra("USER_ID", userId)
                intent.putExtra("USER_MAJOR", userMajor)
                intent.putExtra("USER_GENDER", userGender)
                intent.putExtra("USER_ADDRESS", userAddress)
                intent.putExtra("USER_BIRTHDATE_DAY", birthDateDay)
                intent.putExtra("USER_BIRTHDATE_MONTH", birthDateMonth)
                intent.putExtra("USER_BIRTHDATE_YEAR", birthDateYear)

                startActivity(intent)
            }
            R.id.btn_back_registration_form -> {
                onBackPressed()
            }
        }
    }
}