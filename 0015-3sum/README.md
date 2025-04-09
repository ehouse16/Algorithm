<h2><a href="https://leetcode.com/problems/3sum">15. 3Sum</a></h2><h3>Medium</h3><hr>
![image](https://github.com/user-attachments/assets/912d8e04-c572-4e63-babc-a475dca8d094)

## 문제
1. 주어진 int array를 가지고 세 개의 숫자의 합이 0인 triplet을 반환하기
2. 이때 3개의 숫자는 각각 달라야한다!
   
## 풀이 방식
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Set<List<Integer>> answer = new HashSet();

         for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        answer.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(answer); 
    }
}
```
처음에는 Two Sum 풀었던 방식처럼 for문 돌려서 값을 구했는데 배열이 점점 커지면서 `time exceeded`가 떠버렸다

그래서 힌트를 보니까 1. 정렬 2. 2개의 pointer(j = i + 1, k = n - 1)를 잡고 3. 중복이 있으면 건너뛰어라

이걸 보고 다시 풀어보았다

** 전체 흐름 **
1. 배열 정렬
2. 첫번째 수(nums[i])를 고정
3. left 와 right로 나머지 두 수를 찾아서 0이 되는 조합 찾기
4. 중복 조합은 없애기

## 내 코드
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 정렬

        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; 
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}

```
