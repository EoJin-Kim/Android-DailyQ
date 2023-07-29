package com.ej.dailyq.ui.base

import androidx.fragment.app.Fragment
import com.ej.dailyq.api.ApiService

abstract class BaseFragment : Fragment() {
    val api: ApiService by lazy { ApiService.getInstance() }
}
