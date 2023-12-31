package com.ej.dailyq.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ej.dailyq.AuthManager
import com.ej.dailyq.R
import com.ej.dailyq.databinding.ActivityMainBinding
import com.ej.dailyq.ui.base.BaseActivity
import com.ej.dailyq.ui.profile.ProfileFragment
import com.ej.dailyq.ui.timeline.TimelineFragment
import com.ej.dailyq.ui.today.TodayFragment

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navView.setOnItemSelectedListener {
            val ft = supportFragmentManager.beginTransaction()

            when (it.itemId) {
                R.id.timeline -> {
                    ft.replace(R.id.host, TimelineFragment())
                    supportActionBar?.setTitle(R.string.title_timeline)
                }
                R.id.today -> {
                    ft.replace(R.id.host, TodayFragment())
                    supportActionBar?.setTitle(R.string.title_today)
                }
                R.id.profile -> {
                    ft.replace(R.id.host, ProfileFragment().apply {
                        arguments = Bundle().apply {
                            putString(ProfileFragment.ARG_UID, AuthManager.uid)
                        }
                    })
                    supportActionBar?.setTitle(R.string.title_profile)
                }
            }
            ft.commit()
            true
        }

        binding.navView.selectedItemId = R.id.today
    }
}