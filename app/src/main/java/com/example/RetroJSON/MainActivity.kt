package com.example.RetroJSON

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Api().getData().enqueue(object : Callback<List<Nameage>> {
            override fun onFailure(call: Call<List<Nameage>>, t: Throwable) {
                Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Nameage>>, response: Response<List<Nameage>>) {

              val jsondata =  response.body()

                jsondata?.let {
                    showData(it)
                }
            }

        })
    }

    private fun showData(onlinedata: List<Nameage>){
        textRecycle.layoutManager = LinearLayoutManager(this)
        textRecycle.adapter = NameageAdapter(onlinedata)
    }


}
