package net.codinux.kotlin.concurrent.atomic

import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import net.codinux.kotlin.concurrent.test.TestConstants
import kotlin.test.Test

class AtomicBooleanTest {

    @Test
    fun fromFalseToTrue() = runTest {
        val underTest = AtomicBoolean(false)

        withContext(TestConstants.TestDispatcher) {
            underTest.set(true)
        }

        assertThat(underTest.get()).isTrue()
    }

    @Test
    fun fromTrueToFalse() = runTest {
        val underTest = AtomicBoolean(true)

        withContext(TestConstants.TestDispatcher) {
            underTest.set(false)
        }

        assertThat(underTest.get()).isFalse()
    }

}