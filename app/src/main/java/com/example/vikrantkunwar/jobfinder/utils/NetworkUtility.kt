package com.example.vikrantkunwar.jobfinder.utils

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Singleton

@Singleton
object NetworkUtility {

    fun isNetworkConnected(context: Context): Boolean {

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }


}// This class is not publicly instantiable
