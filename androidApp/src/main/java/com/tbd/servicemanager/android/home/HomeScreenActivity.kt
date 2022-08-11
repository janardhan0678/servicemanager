package com.tbd.servicemanager.android.home

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import com.tbd.servicemanager.android.R
import com.tbd.servicemanager.service.ServiceResult
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch



class HomeScreenActivity : AppCompatActivity() {

    private val mainScope = MainScope()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // networkingManager.makeGetServiceCall(servicePlaceHolderRequest.getURL())
        val tv: TextView = findViewById(R.id.text_view)


        mainScope.launch {

            var homeRepository = HomeRepository()

            val serviceResult = homeRepository.makeHomeServiceRequest()

            // Display result of the network request to the user
            when (serviceResult) {

                is ServiceResult.Success -> {


                    println("success")
                    tv.setText(serviceResult.data.responseStr)
                }
                else ->{
                    println("Error")
                  //  tv.setText(serviceResult.data.responseStr)
                   // tv.setText(ServiceResult.Error.responseStr)
                }

            }
        }
    }
}
