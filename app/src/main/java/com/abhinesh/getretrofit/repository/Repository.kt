package com.abhinesh.getretrofit.repository

import com.abhinesh.getretrofit.api.RetrofitInstance
import com.abhinesh.getretrofit.model.Post
import retrofit2.Response
import java.nio.ByteOrder

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPosts(userId, sort, order)
    }

    suspend fun getCustomPosts2(userId: Int, options: Map<String,String>): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPosts2(userId, options)
    }
}