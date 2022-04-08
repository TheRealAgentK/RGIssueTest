package com.rgissuetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.raygun.raygun4android.RaygunClient
import com.rgissuetest.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
        initRaygun()

        val tw = HashMap<String,String>()
        tw["secondkey"] = "secondvalue"
        // Manual exception creation & sending
        RaygunClient.send(Exception("Congratulations, you have sent errors with Raygun4Android"), null, tw)
    }

    private fun initRaygun() {
        RaygunHelper.initRaygunClient(this)
        // Set Raygun User Info
        // RaygunHelper.setRaygunUserInfo(spDataManager, customerDetailsProvider)
    }
}