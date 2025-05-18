package net.codinux.kotlin.concurrent.collections

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import net.codinux.kotlin.concurrent.test.TestConstants.executeOnDifferentThread
import kotlin.test.Test

class ConcurrentSetTest {

    @Test
    fun add() = runTest {
        val underTest = ConcurrentSet<String>()

        executeOnDifferentThread {
            assertThat(underTest.add("One")).isTrue()
        }

        assertItems(underTest, "One")
    }

    @Test
    fun addMany() = runTest {
        val underTest = ConcurrentSet<String>()
        val expectedItems = IntRange(1, 1000).map { "Item $it" }

        executeOnDifferentThread {
            expectedItems.forEach { item ->
                launch {
                    assertThat(underTest.add(item)).isTrue()
                }
            }
        }

        assertItems(underTest, *expectedItems.toTypedArray())
    }

    @Test
    fun contains() = runTest {
        val underTest = ConcurrentSet<String>()

        executeOnDifferentThread {
            assertThat(underTest.add("One")).isTrue()
        }

        assertThat(underTest.contains("One")).isTrue()
    }

    @Test
    fun containsAll() = runTest {
        val underTest = ConcurrentSet<String>()
        val expectedItems = IntRange(1, 1000).map { "Item $it" }

        executeOnDifferentThread {
            expectedItems.forEach { item ->
                launch {
                    assertThat(underTest.add(item)).isTrue()
                }
            }
        }

        assertThat(underTest.containsAll(expectedItems)).isTrue()
    }

    @Test
    fun remove() = runTest {
        val underTest = ConcurrentSet<String>()
        underTest.add("One")

        executeOnDifferentThread {
            assertThat(underTest.remove("One")).isTrue()
        }

        assertIsEmpty(underTest)
    }

    @Test
    fun clear() = runTest {
        val underTest = ConcurrentSet<String>()
        underTest.add("One")

        executeOnDifferentThread {
            underTest.clear()
        }

        assertIsEmpty(underTest)
    }


    private fun assertItems(underTest: ConcurrentSet<String>, vararg expectedItems: String) {
        assertThat(underTest).hasSize(expectedItems.size)

        expectedItems.forEach { expectedItem ->
            assertThat(underTest.contains(expectedItem)).isEqualTo(true)
        }
    }

    private fun assertIsEmpty(underTest: ConcurrentSet<String>) {
        assertThat(underTest).hasSize(0)
        assertThat(underTest.isEmpty()).isEqualTo(true)
    }

}