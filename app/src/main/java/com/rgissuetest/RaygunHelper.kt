package com.rgissuetest

import android.app.Activity
import android.util.Log
import com.raygun.raygun4android.CrashReportingOnBeforeSend
import com.raygun.raygun4android.RaygunClient
import com.raygun.raygun4android.messages.crashreporting.RaygunMessage


class RaygunHelper {
    companion object {
        fun initRaygunClient(mActivity: Activity) {
            try {
                RaygunClient.init(mActivity.application)
                // Enable Real User Monitoring with Network Logging
                // RaygunClient.enableRUM(mActivity, true)
                // Enable Crash Reporting
                RaygunClient.enableCrashReporting()
                // Set App Version
                RaygunClient.setVersion("1.0.0")
            } catch (e: Exception) {
                e.printStackTrace()
            }
            Log.d("RaygunHelper","### Init the Raygun client..")
        }

        class SampleOnBeforeSend : CrashReportingOnBeforeSend {
            override fun onBeforeSend(message: RaygunMessage): RaygunMessage {

                val details = message.details
                val error = details.error
                error.message = "My own Message"

                Log.d(
                    "Raygun4Android-Sample",
                    "In SampleOnBeforeSend - About to post to Raygun"
                )
                return message
            }
        }
    }
}
