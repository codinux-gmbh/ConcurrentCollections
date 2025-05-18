package net.codinux.kotlin.concurrent.atomic

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import net.codinux.kotlin.concurrent.test.TestConstants
import kotlin.test.Test

class AtomicIntTest {

    @Test
    fun changeValue() = runTest {
        val underTest = AtomicInt(7)

        withContext(TestConstants.TestDispatcher) {
            underTest.set(42)
        }

        assertThat(underTest.get()).isEqualTo(42)
    }

    @Test
    fun incrementAndGet() = runTest {
        val initialValue = 41

        val underTest = AtomicInt(initialValue)

        withContext(TestConstants.TestDispatcher) {
            assertThat(underTest.incrementAndGet()).isEqualTo(initialValue + 1)
        }

        assertThat(underTest.get()).isEqualTo(initialValue + 1)
    }

    @Test
    fun decrementAndGet() = runTest {
        val initialValue = 43

        val underTest = AtomicInt(initialValue)

        withContext(TestConstants.TestDispatcher) {
            assertThat(underTest.decrementAndGet()).isEqualTo(initialValue - 1)
        }

        assertThat(underTest.get()).isEqualTo(initialValue - 1)
    }

    @Test
    fun addAndGet() = runTest {
        val initialValue = 1
        val delta = 41

        val underTest = AtomicInt(initialValue)

        withContext(TestConstants.TestDispatcher) {
            assertThat(underTest.addAndGet(delta)).isEqualTo(initialValue + delta)
        }

        assertThat(underTest.get()).isEqualTo(initialValue + delta)
    }

    @Test
    fun getAndIncrement() = runTest {
        val initialValue = 41

        val underTest = AtomicInt(initialValue)

        withContext(TestConstants.TestDispatcher) {
            assertThat(underTest.getAndIncrement()).isEqualTo(initialValue)
        }

        assertThat(underTest.get()).isEqualTo(initialValue + 1)
    }

    @Test
    fun getAndDecrement() = runTest {
        val initialValue = 43

        val underTest = AtomicInt(initialValue)

        withContext(TestConstants.TestDispatcher) {
            assertThat(underTest.getAndDecrement()).isEqualTo(initialValue)
        }

        assertThat(underTest.get()).isEqualTo(initialValue - 1)
    }

    @Test
    fun getAndAdd() = runTest {
        val initialValue = 1
        val delta = 41

        val underTest = AtomicInt(initialValue)

        withContext(TestConstants.TestDispatcher) {
            assertThat(underTest.getAndAdd(delta)).isEqualTo(initialValue)
        }

        assertThat(underTest.get()).isEqualTo(initialValue + delta)
    }

}