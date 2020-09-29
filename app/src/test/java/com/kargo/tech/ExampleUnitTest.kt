package com.kargo.tech

import com.kargo.tech.models.entities.JobUtils
import com.kargo.tech.models.entities.KargoJob
import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SortintTest {
    val sampleList = ArrayList<KargoJob>().apply {
        add(KargoJob(1, 100, "a", "b", 10))
        add(KargoJob(2, 110, "a", "b", 11))
        add(KargoJob(3, 50, "a", "b", 9))
        add(KargoJob(4, 100, "a", "b", 6))
        add(KargoJob(5, 99, "a", "b", 124))
        add(KargoJob(6, 200, "a", "b", 5))
    }

    @Test
    fun testSortByPrice() {
        JobUtils.sortByPrice(sampleList, 1)
        var compare = true
        for (i in 1 until sampleList.size) {
            if (sampleList[i].price < sampleList[i - 1].price) {
                compare = false
                break
            }
        }
        Assert.assertTrue("Sorted  price in ascending order", compare)
        compare = true
        JobUtils.sortByPrice(sampleList, -1)
        for (i in 1 until sampleList.size) {
            if (sampleList[i].price > sampleList[i - 1].price) {
                compare = false
                break
            }
        }
        Assert.assertTrue("Sorted  price in decreasing order", compare)
    }

    @Test
    fun testSortByTime() {
        JobUtils.sortByTime(sampleList, 1)
        var compare = true
        for (i in 1 until sampleList.size) {
            if (sampleList[i].date < sampleList[i - 1].date) {
                compare = false
                break
            }
        }
        Assert.assertTrue("Sorted date in ascending order", compare)
        compare = true
        JobUtils.sortByTime(sampleList, -1)
        for (i in 1 until sampleList.size) {
            if (sampleList[i].date > sampleList[i - 1].date) {
                compare = false
                break
            }
        }
        Assert.assertTrue("Sorted  date in decreasing order", compare)
    }


}