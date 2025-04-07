이중for문 사용시
![image](https://github.com/user-attachments/assets/fa99cfcf-345d-4fff-8a4f-4b35a0c398d8)

## 문제
주어진 배열 nums에서 두 개의 숫자를 찾아서, 그 합이 target과 같아지는 경우의 인덱스를 반환

## 조건
1. 정확히 하나의 해결 방법만 존재
2. 같은 원소를 두 번 사용 불가
3. 정답의 순서는 상관 없다

## 해결 방안
```
for(int i = 0; i<nums.length-1; i++){
  for(int j = i+1; j<nums.length; j++){
    if(nums[i]+nums[j]==target)
    {
      answer[0] = i;
      answer[1] = j;
    }
  }
}
```

어게인 이중 for문 돌면서 각 숫자의 합이 target이 되면 숫서를 배열에 저장 후 반환

## 내 코드
```
class Solution {
    public int[] twoSum(int[] nums, int target) {
      int[] answer = new int[2];

        for(int i = 0; i<nums.length-1; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target)
                {
                    answer[0] = i;
                    answer[1] = j;
                }

            }
        }
        return answer;  
    }
}
```

## 개선 방안
이 문제는 3달전에 푼 거라 일단 그대로 가져왔는데, 이중 for문 없이 다시 한번 풀어보고 업데이트하겠다 => 업데이트 완료!

---

## 2차 해결방안
Way 3-->Using HashMap -->O(n)
keep on storing the elements that we reach, also keep on check if target-element is already present in the hashmap or not, if it is, then we found a pair
이 글 보면서 풀었다!

```
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            Integer j = result.get(target - nums[i]);

            if(j == null)
                result.put(nums[i], i);
            else
                return new int[]{i,j};
        }
        return new int[]{-1,-1};
    }
}
```

일단 해시맵 만들고, target-element가 hashmap에 있나 없나 체크하면서, 없으면 값 추가 있으면 리턴하는 식으로 문제를 풀었다

![image](https://github.com/user-attachments/assets/f9adf9ad-39df-4971-8cb6-8cf5a18ef1e5)

솔직히 저 글 없었으면 생각도 못한 방법이었을듯 ㅠ 어렵다 어려워
