package com.ej.dailyq.ui.base

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ej.dailyq.api.ApiService
import com.ej.dailyq.db.AppDatabase

abstract class BaseActivity : AppCompatActivity() {
    val api: ApiService by lazy { ApiService.getInstance() }
    val db: AppDatabase by lazy { AppDatabase.getInstance() }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
