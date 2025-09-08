<h2><a href="https://leetcode.com/problems/remove-duplicate-letters">316. Remove Duplicate Letters</a></h2><h3>Medium
<img width="439" height="569" alt="image" src="https://github.com/user-attachments/assets/4e5af79e-0b6f-48f6-93ce-da462785e5fe" />

### 문제 설명
주어진 string s에서 중복된 것을 모두 지우고 알파벳 순서대로 정렬하기

ex) bcabc -> abc
ebcabc -> eabc (e는 사전순서대로 제일 뒤에 와야하지만, 한번만 등장하여 순서 바꿀 수 없음)

### 문제 풀이
```java
Map<Character, Integer> counter = new HashMap<>();
Map<Character, Boolean> seen = new HashMap<>();
Deque<Character> stack = new ArrayDeque<>();
```
- counter: 각 문자가 남은 횟수 저장하는 Map(아직 처리되지 않은 문자 개수)
- seen: 이미 stack에 포함된 문자인지의 여부
- stack: 결과 문자열을 만들기 위한 스택

```java
for(char c:s.toCharArray()){
    counter.put(c, counter.get(c) == null ? 1 : counter.get(c) + 1);
}
```
- 문자열 s를 한 글자씩 돌면서 해당 문자가 몇 번 등장하는 지 갯수 기록

```java
for(char c:s.toCharArray()){
    counter.put(c, counter.get(c)-1); // 남은 횟수 줄이기

    if(seen.get(c) != null && seen.get(c) == true)
        continue; // 이미 스택에 있으면 넘어감

    while(!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0)
        seen.put(stack.pop(), false); // 사전순 최적화

    stack.push(c);
    seen.put(c, true);
}
```
1. 남은 횟수 줄이기
   -> 지금 문자를 처리했으니 앞으로 나올 개수를 줄여준다
2. 이미 스택에 있으면 패스
   -> 중복 제거 목적. 한번 들어간 문자는 다시 안넣음
3. 스택에서 꺼내는 조건
   -> `while(!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0)`
   -> 스택 맨 위의 숫자가 현재 문자보다 사전적으로 뒤에 있음 + 다시 등장할 예정이다 (counter > 0)
   -> 그러면 그 문자를 스택에서 제거(나중에 다시 추가될 것이니까)
4. 현재 문자 스택에 추가
   -> 스택에 쌓고 seen 을 true로 기록

```java
StringBuilder answer = new StringBuilder();
while(!stack.isEmpty())
    answer.append(stack.pollLast());
```
- stack에 들어간 문자를 pollLast()로 꺼내어 정답 만들기
- push로 넣었으니까 맨 아래에서부터 꺼내야함

### 내 코드
```java
class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        for(char c:s.toCharArray()){
            counter.put(c, counter.get(c) == null ? 1 : counter.get(c) + 1);
        }

        for(char c:s.toCharArray()){
            counter.put(c, counter.get(c)-1);

            if(seen.get(c) != null && seen.get(c) == true)
                continue;

            while(!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0)
                seen.put(stack.pop(), false);
            
            stack.push(c);
            seen.put(c, true);
        }

        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty())
            answer.append(stack.pollLast());
        
        return answer.toString();
    }
}
```
### 느낀 점
한번씩 돌면서 단어의 개수를 세고, 1 이상인 것들은 sort해서 꺼내면 되지 않을까 하고 간단하게 생각했는데, 이 sort하는 과정을 모르겠어서 정답지 보면서 같이 풀었다🥲 Map의 개념은 알겠는데 아직 활용하는 게 머리에 들어가지 않은 느낌,,
