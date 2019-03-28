package id.co.core.sharedpreferences

import android.content.SharedPreferences

/**
 * Created by pertadima on 28,March,2019
 */

open class SharedPreferenceHelper(private val sharedPreference: SharedPreferences) {
    open fun setBoolean(key: String, value: Boolean) {
        sharedPreference.edit().putBoolean(key, value).apply()
    }

    open fun setString(key: String, value: String) {
        sharedPreference.edit().putString(key, value).apply()
    }

    open fun setInt(key: String, value: Int) {
        sharedPreference.edit().putInt(key, value).apply()
    }

    open fun setLong(key: String, value: Long) {
        sharedPreference.edit().putLong(key, value).apply()
    }

    open fun getBoolean(key: String) = sharedPreference.getBoolean(key, false)

    open fun getString(key: String) = sharedPreference.getString(key, "")

    open fun getInt(key: String) = sharedPreference.getInt(key, 0)

    open fun getLong(key: String) = sharedPreference.getLong(key, 0)
}