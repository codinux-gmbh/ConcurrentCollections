package net.codinux.kotlin.concurrent.atomic

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import kotlin.test.Test

class AtomicReferenceTest {

    @Test
    fun changeValueAsynchronously() = runTest {
        val underTest = AtomicReference("Old")

        withContext(Dispatchers.Default) {
            underTest.set("New")
        }

        assertThat(underTest.get()).isEqualTo("New")
    }

    @Test
    fun getAndSet() = runTest {
        val underTest = AtomicReference("Old")

        withContext(Dispatchers.Default) {
            assertThat(underTest.getAndSet("New")).isEqualTo("Old")
        }

        assertThat(underTest.get()).isEqualTo("New")
    }

}