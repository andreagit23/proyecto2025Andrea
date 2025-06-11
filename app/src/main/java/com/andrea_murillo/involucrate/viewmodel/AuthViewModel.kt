package com.andrea_murillo.involucrate.viewmodel

import androidx.lifecycle.ViewModel
import com.andrea_murillo.involucrate.model.AuthRequest
import com.andrea_murillo.involucrate.model.AuthResponse
import com.andrea_murillo.involucrate.model.Usuario
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.AuthApi
import retrofit2.Response

class AuthViewModel : ViewModel() {

    private val api: AuthApi = ApiService.retrofit.create(AuthApi::class.java)

    suspend fun login(request: AuthRequest): Response<AuthResponse> {
        return api.login(request)
    }

    suspend fun register(usuario: Usuario): Response<Usuario> {
        return api.register(usuario)
    }
}
