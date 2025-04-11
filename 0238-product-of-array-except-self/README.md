<h2><a href="https://leetcode.com/problems/product-of-array-except-self">238. Product of Array Except Self</a></h2><h3>Medium</h3>

![image](https://github.com/user-attachments/assets/ec763c28-ea5c-46e2-af81-48a91d954237)

## 문제
모든 건 좋았다 마지막 줄을 읽기 전까지,,, 😥

1. 주어진 int 배열 nums을 가지고 answer 이름의 배열을 반환하기
2. answer[i]는 nums[i]을 뺀 나머지 nums의 모든 원소를 곱한 값이어야한다
3. O(n)의 시간복잡도를 가지고 있어야한다
4. 나누기를 사용하면 안된다 ❌

## 풀이 방식
```java
int num = 1;
for(int i = 0; i < length; i++){
    answer[i] = num;
    num *= nums[i];
}
```
1. 나를 제외하고 내 기준 왼쪽 값들을 모두 곱하고 저장하기
2. 이렇게 하면 [1,2,3,4] 의 배열이 주어졌을 때 answer = [1,1,2,6] 이렇게 된다

```java
int num2 = 1;
for(int j = length - 1; j >= 0; j--){
    answer[j] *= num2;
    num2 *= nums[j];
}
```
1. 나를 기준으로 오른쪽의 값들을 곱하는 과정이다
2. 이렇게하면 j가 3일때 answer[3]은 6이고 오른쪽에는 아무것도 없으니 처음에 num2에 저장했던 1을 곱하여 6이 된다
3. j가 2일때 answer[2]은 2이며, num2 = 1*4이니 둘이 곱해 8이 되고 이런식으로 쭉쭉 풀면 된다

나누기를 할 수 없어서 꽤나 어려웠던 문제였다 이런 문제 나오면 오른쪽 왼쪽 나눠서 푸는 걸 1번으로 생각하면 앞으로 좀 쉬울 거 같다 (이게 투 포인터인가?)

## 내 코드
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        int num = 1;
        for(int i = 0; i < length; i++){
            answer[i] = num;
            num *= nums[i];
        }

        int num2 = 1;
        for(int j = length - 1; j >= 0; j--){
            answer[j] *= num2;
            num2 *= nums[j];
        }
        return answer;
    }
}
```
