<h2><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">121. Best Time to Buy and Sell Stock</a></h2><h3>Easy</h3>

![image](https://github.com/user-attachments/assets/aba39efe-725c-43d5-abb1-bdbd08e19e9e)

## 문제
1. 주어진 배열의 i번째의 수는 i번째 날짜에 팔 수 있는 가격이다
2. 한 날에 사고, 다른 날에 팔았을 때 최고의 이득을 낼 수 있는 값을 return하기
3. 만약에 이득이 없다면 0 return

## 풀이 방식
```java
for(int i = 1; i < length; i++){
    min = Math.min(min, prices[i]);
    max = Math.max(max, prices[i] - min);
}
```
배열을 돌면서 min value 를 찾는다 (처음에 prices[0]을 min으로 초기화)
그러면서 prices[i]에서 min value를 마이너스 했을 때의 가장 큰 값을 max로 둔다
그리고 max return!

## 내 코드
```java
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        int length = prices.length;

        for(int i = 1; i < length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
}
```
