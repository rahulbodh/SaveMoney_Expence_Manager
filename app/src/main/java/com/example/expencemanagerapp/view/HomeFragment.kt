package com.example.expencemanagerapp.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.expencemanagerapp.R
class HomeFragment : Fragment() {

    private lateinit var search: ImageView
    private lateinit var userInfo :ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        search = view.findViewById(R.id.searchIcon)
        userInfo= view.findViewById(R.id.userInfo)

        search.setOnClickListener {
            val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }

        userInfo.setOnClickListener {
            val intent = Intent(activity, UserProfileActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}