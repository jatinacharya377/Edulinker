package com.link.edulinker.data.repository

import com.link.edulinker.data.api.ApiBuilder
import com.link.edulinker.data.api.EduLinkerApi
import retrofit2.Response

abstract class RepositoryBase {

    private val api by lazy { ApiBuilder().getApi() }

    suspend fun <T> makeApiCall(call: suspend (api: EduLinkerApi) -> Response<T>) : Response<T> {
        return call.invoke(api)
    }

    companion object {
        private val instances = mutableListOf<RepositoryBase>()
        fun <T: RepositoryBase> getInstance(entityClass: Class<T>) : T {
            return instances.firstOrNull {
                entityClass.isInstance(it)
            }?.let {
                it as T
            } ?: run {
                val instance = entityClass.getDeclaredConstructor().newInstance()
                instances.add(instance)
                instance
            }
        }
    }
}