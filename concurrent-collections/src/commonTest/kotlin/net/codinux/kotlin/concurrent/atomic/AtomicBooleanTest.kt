package net.codinux.kotlin.concurrent.atomic

import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import kotlin.test.Test

class AtomicBooleanTest {

    @Test
    fun fromFalseToTrue() = runTest {
        val underTest = AtomicBoolean(false)

        withContext(Dispatchers.Default) {
            underTest.set(true)
        }

        assertThat(underTest.get()).isTrue()
    }

    @Test
    fun fromTrueToFalse() = runTest {
        val underTest = AtomicBoolean(true)

        withContext(Dispatchers.Default) {
            underTest.set(false)
        }

        assertThat(underTest.get()).isFalse()
    }

}