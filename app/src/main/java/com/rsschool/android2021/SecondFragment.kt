package com.rsschool.android2021

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment


class SecondFragment : Fragment() {
    private var backButton: Button? = null
    private var result: TextView? = null
    private lateinit var interFace :ChangeFragments

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        interFace = context as ChangeFragments
        return inflater.inflate(R.layout.fragment_second, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result = view.findViewById(R.id.result)
        backButton = view.findViewById(R.id.back)

        val min = arguments?.getInt(MIN_VALUE_KEY) ?: 0
        val max = arguments?.getInt(MAX_VALUE_KEY) ?: 0
        val res = generate(min,max)
        result?.text = res.toString()

        val callback: OnBackPressedCallback = object : OnBackPressedCallback(
            true // default to enabled
        ) {
            override fun handleOnBackPressed() {
                interFace.toFirst(res)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,  // LifecycleOwner
            callback
        )

        backButton?.setOnClickListener {
            // TODO: implement back
        interFace.toFirst(res)
        }
    }


    private fun generate(min: Int, max: Int): Int {
        // TODO: generate random number
        return (min..max).random()
    }

    companion object {
        @JvmStatic
        fun newInstance(min: Int, max: Int): SecondFragment {
            val fragment = SecondFragment()
            val args = Bundle()
            // TODO: implement adding arguments
            args.putInt(MIN_VALUE_KEY,min)
            args.putInt(MAX_VALUE_KEY,max)
            fragment.arguments = args
            return fragment
        }
        private const val MIN_VALUE_KEY = "MIN_VALUE"
        private const val MAX_VALUE_KEY = "MAX_VALUE"
    }
}