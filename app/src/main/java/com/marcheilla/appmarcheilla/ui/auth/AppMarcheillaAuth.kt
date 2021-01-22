package com.marcheilla.appmarcheilla.ui.auth

import android.content.Context
import com.marcheilla.appmarcheilla.data.model.ActionState
import com.marcheilla.appmarcheilla.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object AppMarcheillaAuth {
    fun logout(context: Context, callback: ((ActionState<Boolean>) -> Unit)? = null) {
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main) {
                callback?.invoke(resp)
            }
        }
    }
}