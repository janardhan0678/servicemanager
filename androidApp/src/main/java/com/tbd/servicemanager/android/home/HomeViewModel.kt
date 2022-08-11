package com.tbd.servicemanager.android.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbd.servicemanager.service.ServiceResult
import kotlinx.coroutines.launch


class HomeViewModel(private val homeRepository: HomeRepository):ViewModel() {

    fun sendService(){

        viewModelScope.launch {
          val serviceResult = homeRepository.makeHomeServiceRequest()


            // Display result of the network request to the user
            when (serviceResult) {

                is ServiceResult.Success -> {}
                else ->{}

            }
        }
    }

//    fun makeHomeScreenService(){
//
//        // Create a new coroutine on the UI thread
//        viewModelScope.launch {
//            val jsonBody = "{ username: \"$username\", token: \"$token\"}"
//
//            // Make the network call and suspend execution until it finishes
//            val result = loginRepository.makeLoginRequest(jsonBody)
//
//            // Display result of the network request to the user
//            when (result) {
//                is Result.Success<LoginResponse> -> // Happy path
//                else -> // Show error in UI
//            }
//        }
//
//    }




}