package id.co.core.network

import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection

/**
 * Created by pertadima on 28,March,2019
 */

open class NetworkError(var error: Throwable) : Throwable() {
    companion object {
        private const val HTTP_UNPROCESS_ENTITY = 422
    }

    open val errorMessage: String?
        get() = error.message

    open val isNetworkError: Boolean
        get() = error is IOException

    open val isHttpError: Boolean
        get() = error is HttpException

    open val isAuthFailure: Boolean
        get() = isHttpError && (error as HttpException).code() == HttpURLConnection.HTTP_UNAUTHORIZED

    open val isAuthForbidden: Boolean
        get() = isHttpError && (error as HttpException).code() == HttpURLConnection.HTTP_FORBIDDEN

    open val httpErrorCode: String
        get() = if (isHttpError) (error as HttpException).code().toString() else ""

    open val isInternalServerError: Boolean
        get() = isHttpError && (error as HttpException).code() == HttpURLConnection.HTTP_INTERNAL_ERROR

    open val isUnprocessError: Boolean
        get() = isHttpError && (error as HttpException).code() == HTTP_UNPROCESS_ENTITY
}
