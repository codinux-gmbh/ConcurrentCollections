package net.codinux.kotlin.concurrent.collections

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import assertk.assertions.isTrue
import kotlinx.coroutines.test.runTest
import net.codinux.kotlin.concurrent.test.TestConstants.executeOnDifferentThread
import kotlin.test.Test

class ConcurrentMapTest {

    @Test
    fun get() = runTest {
        val underTest = ConcurrentMap<String, String>()

        executeOnDifferentThread {
            assertThat(underTest.put("Key", "Value")).isNull()
        }

       assertThat(underTest.get("Key")).isEqualTo("Value")
    }

    @Test
    fun getOrPut() = runTest {
        val underTest = ConcurrentMap<String, String>()

        executeOnDifferentThread {
            assertThat(underTest.getOrPut("Key") { "Value" }).isEqualTo("Value")
        }

        assertThat(underTest.get("Key")).isEqualTo("Value")
    }

    @Test
    fun getNotExistingKey() = runTest {
        val underTest = ConcurrentMap<String, String>()

        assertThat(underTest.get("Key")).isNull()
    }

    @Test
    fun overwriteValue() = runTest {
        val underTest = ConcurrentMap<String, String>()
        underTest.put("Key", "Value")

        executeOnDifferentThread {
            underTest.put("Key", "Value2")
        }

        assertThat(underTest.get("Key")).isEqualTo("Value2")
    }

    @Test
    fun remove() = runTest {
        val underTest = ConcurrentMap<String, String>()
        underTest.put("Key", "Value")

        executeOnDifferentThread {
            assertThat(underTest.remove("Key")).isEqualTo("Value")
        }

        assertIsEmpty(underTest)
    }

    @Test
    fun removeNotExistingKey() = runTest {
        val underTest = ConcurrentMap<String, String>()

        assertThat(underTest.remove("Key2")).isNull()
    }

    @Test
    fun clear() = runTest {
        val underTest = ConcurrentMap<String, String>()
        underTest.put("Key", "Value")

        executeOnDifferentThread {
            underTest.clear()
        }

        assertIsEmpty(underTest)
    }


    private fun assertIsEmpty(underTest: ConcurrentMap<String, String>) {
        assertThat(underTest.size).isEqualTo(0)

        assertThat(underTest.isEmpty()).isTrue()
    }

}