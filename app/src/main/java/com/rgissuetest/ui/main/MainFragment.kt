package com.rgissuetest.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.raygun.raygun4android.RaygunClient
import com.rgissuetest.R
import com.rgissuetest.RaygunHelper

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val myView = inflater.inflate(R.layout.main_fragment, container, false);
        val button =  myView.findViewById<Button>(R.id.button);

        button.setOnClickListener {
            val i = 3 / 0
            Log.d("Raygun4Android-Sample", "This is here purely so that our division by zero calculation in i gets used and not optimised away in a release build: $i")
        }

        return myView;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RaygunClient.setOnBeforeSend(RaygunHelper.Companion.SampleOnBeforeSend())
    }

}