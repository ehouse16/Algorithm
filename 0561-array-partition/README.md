<h2><a href="https://leetcode.com/problems/array-partition">561. Array Partition</a></h2><h3>Easy</h3>
![image](https://github.com/user-attachments/assets/ac1dd2f3-da57-4fca-8445-c4974f6e4bba)

## 문제
1. 주어진 2n개의 int 배열을 가지고 n개의 짝을 만든다
2. 각각의 짝의 min value를 구해서 더한다
3. 모두 더한 값이 최댓값이라면 그 값을 반환한다 

## 풀이 방식
문제의 Example에 나와있는 걸 보니까 정렬하고 순서대로 자른다면 최댓값이 나온다는 걸 알게 되었다! 그래서 쉽게 풀 수 있던 문제였다

Ex) 
`1,4,3,2`가 주어진 배열이라면 정렬해서 `1,2,3,4` 로 만든다
그러면 `(1,2), (3,4)`로 잘리게 되고
각 `min` 값인 1+3을 더한다면 최댓값인 4가 나오게 된다

```java
Arrays.sort(nums);
```
1. 배열을 정렬한다

```java
for(int i = 0; i < length - 1; i+=2){
    sum += Math.min(nums[i], nums[i+1]);
}
```
2. 2개씩 짝을 지으니 2씩 더해주고, 각각의 min value 를 더한다
3. 그렇게 나온 sum을 return!

## 내 코드
```java
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        int sum = 0;

        for(int i = 0; i < length - 1; i+=2){
            sum += Math.min(nums[i], nums[i+1]);
        }
        
        return sum;
    }
}
```
