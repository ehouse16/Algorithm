<h2><a href="https://leetcode.com/problems/valid-palindrome">125. Valid Palindrome</a></h2>

## 문제
1. 기존 문자열을 소문자로 바꾸고 알파벳이 아닌 글자는 모두 지운다
2. 앞 뒤로 읽을 때 똑같아야한다

## 해결방안
```String s2 = s.toLowerCase().trim();``` 
으로 소문자와 공백제거

```
for(int i = 0; i < s2.length(); i++){
  if(Character.isLetterOrDigit(s2.charAt(i)))
    word+=s2.charAt(i);
}
```
으로 숫자와 문자시 String word에 합치기

```
for(int j = 0; j < word.length(); j++){
  if(word.charAt(j)!=word.charAt(word.length()-1-j))
    return false;
}
return true;
```
으로 맨 앞 글자와 맨 뒷글자가 다르면 false, for문을 끝까지 다 돌았다면 (다른 단어가 없다면) true 반환


## 내 코드
```
class Solution {
    public boolean isPalindrome(String s) {
        String s2 = s.toLowerCase().trim();

        String word = "";

        for(int i = 0; i < s2.length(); i++){
            if(Character.isLetterOrDigit(s2.charAt(i)))
                word+=s2.charAt(i);
        }

        //System.out.println(word);

        for(int j = 0; j < word.length(); j++){
            if(word.charAt(j)!=word.charAt(word.length()-1-j))
                return false;
        }
        return true;
    }
}
```

## 개선 방안
* for문을 두 번 사용하는 것이 맘에 들지 않는다 -> 한번으로 해결하고 싶다
* 굳이 새로운 String word를 만들어야할까? -> 만들지 않고 반복문 내에서 처리해보기

