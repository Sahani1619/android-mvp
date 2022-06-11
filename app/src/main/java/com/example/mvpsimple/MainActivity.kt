package com.example.mvpsimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView{
    private lateinit var etPanjang: EditText
    private lateinit var etSisi:EditText
    private lateinit var etLebar: EditText
    private lateinit var btnHitungLuas: Button
    private lateinit var btnHitungKeliling: Button
    private lateinit var btHitungLuasPersegi: Button
    private lateinit var btHitungKelilingPersegi: Button
    private lateinit var tvHasil: TextView
    private lateinit var tvJumlah: TextView
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        etPanjang = findViewById(R.id.et_panjang)
        etLebar = findViewById(R.id.et_lebar)
        etSisi = findViewById(R.id.et_sisi)
        btnHitungKeliling = findViewById(R.id.btn_hitung_keliling)
        btnHitungLuas = findViewById(R.id.btn_hitung_luas)
        btHitungLuasPersegi = findViewById(R.id.bt_hitung_luas_persegi)
        btHitungKelilingPersegi = findViewById(R.id.bt_hitung_keliling_Persegi)
        tvHasil = findViewById(R.id.tv_Hasil)
        tvJumlah = findViewById(R.id.tv_Jumlah)
        btnHitungLuas.setOnClickListener {
            val panjang = etPanjang.text.toString().toFloat()
            val lebar = etLebar.text.toString().toFloat()
            mainPresenter.hitungLuasPersegiPjg(panjang, lebar)
        }
        btnHitungKeliling.setOnClickListener {
            val panjang = etPanjang.text.toString().toFloat()
            val lebar = etLebar.text.toString().toFloat()
            mainPresenter.hitungKelilingPersegiPjg(panjang, lebar)
        }
        btHitungLuasPersegi.setOnClickListener {
            val sisi = etSisi.text.toString().toFloat()
            mainPresenter.hitungLuasPersegi(sisi)
        }
        btHitungKelilingPersegi.setOnClickListener {
            val sisi = etSisi.text.toString().toFloat()
            mainPresenter.hitungKelilingPersegi(sisi)
        }
    }
    override fun updateLuas(luas: Float) {
        tvHasil.text = luas.toString()
    }

    override fun updateKeliling(keliling: Float) {
        tvHasil.text = keliling.toString()
    }
    override fun showError(errorMsg: String) {
        tvHasil.text = errorMsg
    }
    override fun updateLuasPersegi(luasPersegi: Float) {
        tvJumlah.text = luasPersegi.toString()
    }
    override fun updateKelilingPersegi(kelilingPersegi: Float) {
        tvJumlah.text = kelilingPersegi.toString()
    }
    override fun showErrorPersegi(errorMsgPersegi: String) {
        tvJumlah.text = errorMsgPersegi
    }
}