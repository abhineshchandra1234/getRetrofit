package com.abhinesh.getretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.abhinesh.getretrofit.adapter.MyAdapter
import com.abhinesh.getretrofit.repository.Repository
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        //val myPost = Post(2,2,"Abhinesh","Android Developer")
        //viewModel.pushPost2(2,2,"Abhinesh","Android")
        viewModel.pushPost3("TSP/564861/0319", "contractor_id")
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                val obj = JSONObject(response.toString())
                val tempEmp = obj.getString("success")
                Log.d("Main", "Succesful")
//                Log.d("Main", response.code().toString())
//                Log.d("Main", response.body().toString())
            } else {
                Log.d("Error", response.hashCode().toString())
                //Toast.makeText(this,response.errorBody().toString(), Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setupRecyclerview(){
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}