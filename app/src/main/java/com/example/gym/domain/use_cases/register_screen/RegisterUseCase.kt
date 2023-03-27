package com.example.gym.domain.use_cases.register_screen

import com.example.gym.data.remote.model.request.UserAddRemote
import com.example.gym.domain.repository.remote.UserRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(user:UserAddRemote){
        userRepository.registerUser(user)

    }
}