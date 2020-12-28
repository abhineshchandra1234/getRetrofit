package com.abhinesh.getretrofit.model

import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName

data class Post (
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
        )