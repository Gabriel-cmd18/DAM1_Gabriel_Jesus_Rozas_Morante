package com.example.appgrupo1

import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun obtenerPosts(): PostResponse
}