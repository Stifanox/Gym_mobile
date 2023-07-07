package com.example.gym.domain.user_id

import android.content.Context
import com.example.gym.data.remote.model.StatusRemote
import com.example.gym.domain.repository.remote.UserRepository
import com.example.gym.domain.token.TokenManagerSharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class UserIdManager @Inject constructor(
    private val userRepository: UserRepository,
    @ApplicationContext private val context: Context
){

   suspend fun getUserId():Int?{
       return try {
           val response = userRepository.getId(TokenManagerSharedPreferences.getTokenFromSharedPreferences(context))
           response.data.toInt()
       } catch (e:IOException){
           null
       }
       catch (e:HttpException){
           null
       }

   }
}