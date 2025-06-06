package net.codinux.kotlin.concurrent.atomic

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlinx.coroutines.test.runTest
import net.codinux.kotlin.concurrent.test.TestConstants.executeOnDifferentThread
import kotlin.test.Test

class AtomicLongTest {

    @Test
    fun changeValue() = runTest {
        val underTest = AtomicLong(7)

        executeOnDifferentThread {
            underTest.set(42)
        }

        assertThat(underTest.get()).isEqualTo(42)
    }

    @Test
    fun incrementAndGet() = runTest {
        val initialValue = 41L

        val underTest = AtomicLong(initialValue)

        executeOnDifferentThread {
            assertThat(underTest.incrementAndGet()).isEqualTo(initialValue + 1)
        }

        assertThat(underTest.get()).isEqualTo(initialValue + 1)
    }

    @Test
    fun decrementAndGet() = runTest {
        val initialValue = 43L

        val underTest = AtomicLong(initialValue)

        executeOnDifferentThread {
            assertThat(underTest.decrementAndGet()).isEqualTo(initialValue - 1)
        }

        assertThat(underTest.get()).isEqualTo(initialValue - 1)
    }

    @Test
    fun addAndGet() = runTest {
        val initialValue = 1L
        val delta = 41L

        val underTest = AtomicLong(initialValue)

        executeOnDifferentThread {
            assertThat(underTest.addAndGet(delta)).isEqualTo(initialValue + delta)
        }

        assertThat(underTest.get()).isEqualTo(initialValue + delta)
    }

    @Test
    fun getAndIncrement() = runTest {
        val initialValue = 41L

        val underTest = AtomicLong(initialValue)

        executeOnDifferentThread {
            assertThat(underTest.getAndIncrement()).isEqualTo(initialValue)
        }

        assertThat(underTest.get()).isEqualTo(initialValue + 1)
    }

    @Test
    fun getAndDecrement() = runTest {
        val initialValue = 43L

        val underTest = AtomicLong(initialValue)

        executeOnDifferentThread {
            assertThat(underTest.getAndDecrement()).isEqualTo(initialValue)
        }

        assertThat(underTest.get()).isEqualTo(initialValue - 1)
    }

    @Test
    fun getAndAdd() = runTest {
        val initialValue = 1L
        val delta = 41L

        val underTest = AtomicLong(initialValue)

        executeOnDifferentThread {
            assertThat(underTest.getAndAdd(delta)).isEqualTo(initialValue)
        }

        assertThat(underTest.get()).isEqualTo(initialValue + delta)
    }

}