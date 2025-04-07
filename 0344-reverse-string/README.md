<h2><a href="https://leetcode.com/problems/reverse-string">344. Reverse String</a></h2>

![image](https://github.com/user-attachments/assets/0d14b7f0-bfa8-474c-9d29-1ec7ce6d4eba)

## 문제
주어진 배열을 거꾸로 만들기

## 해결 방안
```
for(int i = 0; i < num/2; i++){
            char temp = s[i];
            s[i] = s[num-1-i];
            s[num-1-i] = temp;
        }
```
흔히 자바에서 하는 배열 속 a,b 바꾸기 방법을 그대로 적용

## 내 코드
```
class Solution {
    public void reverseString(char[] s) {
        int num = s.length;
        
        for(int i = 0; i < num/2; i++){
            char temp = s[i];
            s[i] = s[num-1-i];
            s[num-1-i] = temp;
        }
    }
}
```

## 개선 방안
왜 나는 0m로 해결할 수 없나?! for문이라 그런가? while문으로 다시 풀어보자

## 다시 풀기
![image](https://github.com/user-attachments/assets/0a7f3419-8c8e-494e-9848-d96159f45271)

while 문으로 푸니 0ms 성공!

```
class Solution {
    public void reverseString(char[] s) {
        int num = s.length;
        
        int i = 0;
        int j = num- 1;

        while(i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }
    }
}
```

