![image](https://github.com/user-attachments/assets/0bd6a656-307c-47a3-8928-c8ffd9b5b37c)

🤢🤮 코드는 잘 돌아가지만 효율이 쓰레기라 time limit exceeded 가 떠버렸다,,

substring 때문이라 생각하고 charAt으로 풀으라는 조언을 받아 다시 풀어보았다,,

## 문제
주어진 문자열 s에서 가장 긴 팰린드롬 찾기

## 풀이 방안
```
for (int i = 0; i < len; i++) {
  for (int j = i; j < len; j++) {
    if (isPalindrome(s, i, j) && (j - i + 1) > max) {
      max = j - i + 1;
      start = i;
    }
  }
}
```
for문 돌면서 각 길이만큼의 문자열이 펠린드롬인지 확인하며, 원래 있던 max 길이보다 길다면 새로 갱신한다

```
StringBuilder answer = new StringBuilder();
  for (int i = start; i < start + max; i++) {
    answer.append(s.charAt(i));
}
```
최종적으로 제일 긴 팰린드롬을 StringBuilder로 만든다
(반복적인 문자열 변경 시 메모리 낭비와 성능 저하)의 이유로

## 내 코드
```
class Solution {
    public String longestPalindrome(String s) {
        int max = 1;
        int start = 0;
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(s, i, j) && (j - i + 1) > max) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = start; i < start + max; i++) {
            answer.append(s.charAt(i));
        }
        
        return answer.toString();
    }

    public boolean isPalindrome(String s, int start, int end) {
        for (int j = start; j <= (start + end) / 2; j++) {
            if (s.charAt(j) != s.charAt(end - (j - start))) {
                return false;
            }
        }
        return true;
    }
}
```

## 개선방안
![image](https://github.com/user-attachments/assets/688f5eb0-5b3e-408c-9bd9-0d8d4908f8d1)

실행시간이 너무 길다,, 줄일 방법을 찾아보자!
