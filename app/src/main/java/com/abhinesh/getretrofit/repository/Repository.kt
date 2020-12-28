package com.abhinesh.getretrofit.repository

import com.abhinesh.getretrofit.api.RetrofitInstance
import com.abhinesh.getretrofit.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}