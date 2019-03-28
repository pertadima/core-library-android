package id.co.core.sharedpreferences

import android.app.Application
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
    private val sharedPreferencesName: String
) {
    @Provides
    @Singleton
    fun providesContext(): Application = Application()

    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application): SharedPreferences =
        application.getSharedPreferences(sharedPreferencesName, 0)

    @Provides
    @Singleton
    fun probvidesSharedPreferencesHelper(sharedPreferences: SharedPreferences) =
        SharedPreferenceHelper(sharedPreferences)

}