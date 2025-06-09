//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
//
//
//Example 1:
//
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//Example 2:
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
//
//
//Constraints:
//
//        1 <= prices.length <= 105
//        0 <= prices[i] <= 104

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {2,4,1};
        SolutionOfBestTimeToBuyAndSellStock solution = new SolutionOfBestTimeToBuyAndSellStock();
        System.out.println(solution.maxProfit(prices));

    }
}

class SolutionOfBestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int profit = 0;
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            else{
                profit = prices[i] - min;
                if (profit > maxProfit) maxProfit = profit;
            }
        }
        return maxProfit;
    }
}

//крч по итогу два варианта решение,выше мой первый вариант,снизу я подсмотрел более скоростной,вообще честно мне он менее нравится из-за
// отсутствия макса, но он тоже раюочий,суть в чём,перовый элоемент мин,макс профит априоре 0,если например массив из 1 элемента то выгода 0,всё кайф,не надо делатиь 2 ретурна
//ну и тут пользуются логикой, ччто если он не меньшге, то значит он больше,следовательно макс,а там уже решают,текущий профит больше чем макс или нет
// аналогичные действия есть у меня, только изначально я хотел проверять больше ли индекс макс чем мин или нет, но потом просто при каждом новом
//минимуме я назначал новый максимум и потом аналогично сравнивал профиты, сущесвтенное отличие моего кода и его,даже не в определении минимума,
// т.к. я так тоже пробовал делать, а в отсутсвии максимума,и можно сказать при каждом новом максимуме он считает профит,а у меня всегда,поэтому
// его решение и выгоднее

//================================================


//        int profit = 0;
//        int min = prices[0];
//        int minIndex = 0;
//        int max = 0;
//        int maxIndex=0;
//
//        boolean isHaveMax = false;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < min) {
//                min = prices[i];
//                minIndex = i;
//
//                max = min;
//                maxIndex = i;
//
//
//            }
//            if (prices[i]> max) {
//                max = prices[i];
//                maxIndex = i;
//            }
//            if(max-min>profit){
//                profit = max-min;
//            }
//        }
//        System.out.println(min + " " + max);
//        if(profit!=0){
//            return profit;
//        }
//        return 0;

