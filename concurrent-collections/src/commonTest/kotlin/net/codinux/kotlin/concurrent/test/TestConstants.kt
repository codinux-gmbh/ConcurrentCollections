package net.codinux.kotlin.concurrent.test

import kotlinx.coroutines.*

object TestConstants {

    val TestDispatcher = Dispatchers.Default

    suspend fun executeOnDifferentThread(block: () -> Unit) {
        withContext(TestDispatcher) {
            block()
        }
    }

}