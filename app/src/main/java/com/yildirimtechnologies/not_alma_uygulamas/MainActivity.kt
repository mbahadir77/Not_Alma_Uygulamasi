package com.yildirimtechnologies.not_alma_uygulamas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yildirimtechnologies.not_alma_uygulamas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
    private fun handleResponse(notList: List<Notlar>){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NotAdapter(notList)
        binding.recyclerView.adapter = adapter
    }
    fun notekleme (view : View){
        intent = Intent(this,kullanicigirisActivity::class.java)
        startActivity(intent)

    }

}