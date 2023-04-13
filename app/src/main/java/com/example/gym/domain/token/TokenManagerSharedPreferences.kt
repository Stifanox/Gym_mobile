package com.example.gym.domain.token

import android.content.Context
import com.example.gym.R

class TokenManagerSharedPreferences {
    companion object {
        fun saveTokenToSharedPreferences(context: Context, token: String, tokenRefresh: String) {
            val shared = context.getSharedPreferences(
                context.getString(R.string.shared_preferences_token),
                Context.MODE_PRIVATE
            )
            shared.edit().also {
                it.putString(context.getString(R.string.token), token)
                it.putString(context.getString(R.string.token_refresh), tokenRefresh)
                it.apply()
            }
        }

        //TODO: może będzie trzeba jeszcze zrobić jedną funkcję która będzie zwracać refresh token
        fun getTokenFromSharedPreferences(context: Context):String {
            val shared =
                context.getSharedPreferences(
                    context.getString(R.string.shared_preferences_token),
                    Context.MODE_PRIVATE
                )
            val token = shared.getString(context.getString(R.string.token),"") as String
            return "JWT=$token"
        }
    }
}