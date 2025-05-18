package net.codinux.kotlin.concurrent.atomic

import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import kotlinx.coroutines.test.runTest
import net.codinux.kotlin.concurrent.test.TestConstants.executeOnDifferentThread
import kotlin.test.Test

class AtomicBooleanTest {

    @Test
    fun fromFalseToTrue() = runTest {
        val underTest = AtomicBoolean(false)

        executeOnDifferentThread {
            underTest.set(true)
        }

        assertThat(underTest.get()).isTrue()
    }

    @Test
    fun fromTrueToFalse() = runTest {
        val underTest = AtomicBoolean(true)

        executeOnDifferentThread {
            underTest.set(false)
        }

        assertThat(underTest.get()).isFalse()
    }

}