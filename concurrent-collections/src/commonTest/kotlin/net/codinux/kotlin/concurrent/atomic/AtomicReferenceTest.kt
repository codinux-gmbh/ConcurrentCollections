package net.codinux.kotlin.concurrent.atomic

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlinx.coroutines.test.runTest
import net.codinux.kotlin.concurrent.test.TestConstants.executeOnDifferentThread
import kotlin.test.Test

class AtomicReferenceTest {

    @Test
    fun changeValueAsynchronously() = runTest {
        val underTest = AtomicReference("Old")

        executeOnDifferentThread {
            underTest.set("New")
        }

        assertThat(underTest.get()).isEqualTo("New")
    }

    @Test
    fun getAndSet() = runTest {
        val underTest = AtomicReference("Old")

        executeOnDifferentThread {
            assertThat(underTest.getAndSet("New")).isEqualTo("Old")
        }

        assertThat(underTest.get()).isEqualTo("New")
    }

}