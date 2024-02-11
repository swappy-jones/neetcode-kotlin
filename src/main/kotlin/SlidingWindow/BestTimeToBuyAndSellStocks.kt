package SlidingWindow

import kotlin.math.max

object BestTimeToBuyAndSellStocks {
    fun maxProfit(prices: IntArray): Int {
        var l = 0
        var r = prices.size-1
        var profit = 0
        while(l<r) {
            profit = maxOf(profit, prices[r]-prices[l])
            if(prices[r]< prices[l]) {
                l++
            } else {
                r--
            }
        }
        return profit
    }
    fun main() {
        print(maxProfit(intArrayOf(7,1,5,3,6,4)))
    }
}