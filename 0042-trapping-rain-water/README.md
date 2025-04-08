<h2><a href="https://leetcode.com/problems/trapping-rain-water">42. Trapping Rain Water</a></h2><h3>Hard</h3><hr>

![image](https://github.com/user-attachments/assets/ba38a329-05e6-4418-8356-c345acd2008a)

## 문제
![image](https://github.com/user-attachments/assets/02fa923c-1a6a-4a4d-955d-5f469f570e53)

1. 모든 값이 양수인 int 배열이 주어진다
2. 각각의 값은 높이를 나타낸다
3. 각 높이는 너비 1의 막대이다
4. 비가 온 후 고인 물의 총량을 구해라

## 해결 방안
처음에는 아예 감이 안잡혀서 꽤나 헤매었다. 그냥 오른쪽으로 쭉 가다가 높은 거 만나면 값을 빼서 더하면 되는거 아닌가? 싶었는데 오른쪽, 왼쪽을 모두 계산하고 문제를 풀었어야했다 😥

```java
//왼쪽 최고 높이 구하기
leftMax[0] = height[0];
for(int i = 1; i < length; i++){
    leftMax[i] = Math.max(leftMax[i-1], height[i]);
}
```
왼쪽의 값을 구해야하기 때문에 1부터 시작했다.
주어진 배열의 길이만큼 돌면서, 원래의 값과 왼쪽의 값 중 큰 것을 저장했다

```java
//오른쪽 최고 높이 구하기
rightMax[length - 1] = height[length - 1]; 
for(int j = length-2; j >= 0; j--){
    rightMax[j] = Math.max(rightMax[j+1], height[j]);
}
```
오른쪽 값을 구해야하기 때문에 -2를 계산하고 배열을 시작했다. (첫번째 값은 length-1 이니까)
주어진 배열의 길이만큼 돌면서, 원래의 값과 오른쪽의 값 중 큰 것을 저장했다

```java
//각 위치의 고인 물 더하기
for(int a = 0; a < length; a++){  
    sum += Math.min(leftMax[a], rightMax[a]) - height[a]; 
}
```
다시 한번 주어진 배열만큼의 길이를 돌면서 가장 높은 왼쪽의 높이와 가장 높은 오른쪽의 값 중 작은 것을 선택해 원래의 값을 뺀만큼의 수를 더했다. 

## 내 코드
```java
class Solution {
    public int trap(int[] height) {
        int length = height.length;

        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        int sum = 0;

        //왼쪽 최고 높이 구하기
        leftMax[0] = height[0];
        for(int i = 1; i < length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        //오른쪽 최고 높이 구하기
        rightMax[length-1] = height[length-1]; 
        for(int j = length-2; j >= 0; j--){
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }

        //각 위치의 고인 물 더하기
        for(int a = 0; a < length; a++){  
            sum += Math.min(leftMax[a], rightMax[a]) - height[a]; 
        }

        return sum;
    }
}
```

## 내 생각
이렇게 배열을 만들어서 for문을 3번 도는 것은 불필요한 거 같은데 다른 방법이 생각나지 않아 일단은 이렇게 풀었다. 
