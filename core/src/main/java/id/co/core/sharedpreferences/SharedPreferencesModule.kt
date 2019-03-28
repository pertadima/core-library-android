package id.co.core.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by pertadima on 28,March,2019
 */

@Module
open class SharedPreferencesModule(
    private val context: Context,
    private val sharedPreferencesName: String
) {
    @Provides
    @Singleton
    fun providesSharedPreferences(): SharedPreferences = context.getSharedPreferences(sharedPreferencesName, 0)

    @Provides
    @Singleton
    fun probvidesSharedPreferencesHelper(sharedPreferences: SharedPreferences) =
        SharedPreferenceHelper(sharedPreferences)

}