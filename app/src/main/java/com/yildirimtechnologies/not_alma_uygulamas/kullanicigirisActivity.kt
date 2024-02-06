package com.yildirimtechnologies.not_alma_uygulamas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.yildirimtechnologies.not_alma_uygulamas.databinding.ActivityKullanicigirisBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class kullanicigirisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKullanicigirisBinding
    private lateinit var db: AppDatabase
    private lateinit var userDao: UserDao
    private lateinit var Notlar : Notlar
    val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKullanicigirisBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "KaydedilenNotlar").build()
        userDao = db.userDao()
    }

    fun kayitButon(view: View) {
        val notlar = Notlar(binding.baslikText.text.toString(), binding.uzunText.text.toString())
        compositeDisposable.add(
            userDao.insert(notlar)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse)
        )
    }
    private fun handleResponse(){
        val intent = Intent(this,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}