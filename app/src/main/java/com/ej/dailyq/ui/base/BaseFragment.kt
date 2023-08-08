package com.ej.dailyq.ui.base

import androidx.fragment.app.Fragment
import com.ej.dailyq.api.ApiService
import com.ej.dailyq.db.AppDatabase

abstract class BaseFragment : Fragment() {
    val api: ApiService by lazy { ApiService.getInstance() }
    val db: AppDatabase by lazy { AppDatabase.getInstance() }
}
