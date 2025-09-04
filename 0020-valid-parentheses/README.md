<h2><a href="https://leetcode.com/problems/valid-parentheses">20. Valid Parentheses</a></h2><h3>Easy</h3>

<img width="383" height="580" alt="image" src="https://github.com/user-attachments/assets/266e85ac-5af4-45b1-85a8-3ee49ab15d59" />

### 문제
'(', ')', '{', '}', '[', ']' 만 있는 string `s`를 가지고 서로 짝이 알맞는 지 체크하기
- 괄호는 반드시 같은 타입의 괄호로 닫혀야한다
- 괄호는 반드시 순서대로 닫혀야한다

ex) 
```
Input: s = "()[]{}"
Output: true
```

```
Input: s = "([)]"

Output: false
```

### 풀이
```java
Deque<Character> stack = new ArrayDeque<>();

```
- 큐 생성하기

for 문으로 돌면서 swtich문으로 open bracket이면 stack.push()하고 break;
open bracket이면 stack이 비어있나 확인 + 똑같은 타입의 괄호이며 닫히는 괄호인지 확인
틀리면 false 반환

for문 다 돌고, stack에 남아있는 게 있는지 
```java
return stack.isEmpty();
```
로 반환

### 내 코드
```java
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);

            switch (a){
                case '(':
                    stack.push(a);
                    break;
                case '[':
                    stack.push(a);
                    break;
                case '{':
                    stack.push(a);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(')
                        return false; 
                        break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[')
                        return false;
                        break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{')
                        return false;
                        break;
            }
        }
        return stack.isEmpty();
    }
}
```

### 느낀점
굳이 저렇게 switch case를 많이 안만들고 if문으로 한번에 여러 조건 걸어서 확인했어도 좋을 거 같다!
