package com.example.mvpsimple

class MainPresenter(private val mainView: MainView) {

    fun hitungLuasPersegiPjg(panjang: Float, lebar: Float) {
        if (panjang == 0F) {
            mainView.showError("Panjang tidak boleh 0")
            return
        }
        if (lebar == 0F){
            mainView.showError("Lebar tidak boleh 0")
            return
        }

        val luas = panjang * lebar
        mainView.updateLuas(luas)
    }
    fun hitungKelilingPersegiPjg(panjang: Float, lebar: Float){
        if (panjang == 0F) {
            mainView.showError("Panjang tidak boleh 0")
            return
        }
        if (lebar == 0F){
            mainView.showError("Lebar tidak boleh 0")
            return
        }

        val keliling = 2*(panjang+lebar)
        mainView.updateKeliling(keliling)

    }
    fun hitungLuasPersegi(sisi: Float) {
        if (sisi == 0F) {
            mainView.showErrorPersegi("Sisi tidak boleh 0")
            return
        }

        val luasPersegi = sisi * sisi
        mainView.updateLuasPersegi(luasPersegi)
    }

    fun hitungKelilingPersegi(sisi: Float){

        if (sisi == 0F){
            mainView.showErrorPersegi("Sisi tidak boleh 0")
            return
        }

        val kelilingPersegi = 4* sisi
        mainView.updateKelilingPersegi(kelilingPersegi)


    }
}