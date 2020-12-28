package com.abhinesh.getretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abhinesh.getretrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful){
                Log.d("Response",response.body()?.userId.toString())
                Log.d("Response",response.body()?.id.toString())
                Log.d("Response",response.body()?.title!!)
                tvHello.text = response.body()?.title
                Log.d("Response",response.body()?.body!!)
            } else {
                Log.d("Response",response.errorBody().toString())
                tvHello.text = response.code().toString()
            }
        })
    }
}