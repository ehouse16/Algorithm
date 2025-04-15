<h2><a href="https://leetcode.com/problems/palindrome-linked-list">234. Palindrome Linked List</a></h2><h3>Easy</h3>

![image](https://github.com/user-attachments/assets/521f74f2-d5fe-436f-b867-07dbe07bf3f0)

## 문제
1. 주어진 단일 연결 리스트의 head가 주어진다
2. 이 연결 리스트가 palindrome이면 true를, 아니면false를 반환한다
   
- 1 -> 2 -> 2 -> 1 → true
- 1 -> 2 -> 3 → false
  
## 풀이 방식
ListNode 문제 푸는 방식을 모르겠어서 힌트를 보면서 풀었다

```java
//중간까지의 값 구하기
while(second != null && second.next != null){
    first = first.next;
    second = second.next.next;
}
```
1. 중간 지점 찾기
2. first는 한칸씩 앞으로, second는 두칸씩 앞으로 간다
3. second가 끝에 도달하면 first는 딱 중간에 있다

```java
ListNode returnValue = null;

while (list != null) {
    ListNode temp = list.next;
    list.next = returnValue;
    returnValue = list;
    list = temp;
}
return returnValue;
```
1. 뒤집기!
#### 단계별 해석
1. `returnValue`는 현재까지 뒤집은 리스트의 헤드(시작점) 역할.
2. 매 반복마다
- `temp`에 `list.next`를 저장 -> 다음 노드를 기억하기
- `list.next = returnValue` -> 현재 노드를 뒤집은 리스트의 앞에 붙이기
- `returnValue = list` -> 뒤집은 리스트의 새 head를 현재 노드로 업데이트
- `list = temp` -> 다음 노드로 이

```java
while(reverseList != null){
    if(head.val != reverseList.val)
        return false;
    head = head.next;
    reverseList = reverseList.next;
}
return true;
```
1. 주어진 ListNode와 뒤집은 reverseList를 비교하기
   
## 내 코드
```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        //중간까지의 값 구하기
        while(second != null && second.next != null){
            first = first.next;
            second = second.next.next;
        }

        // 뒤집기
        ListNode reverseList = reverse(first);

        // 비교하기
        while(reverseList != null){
            if(head.val != reverseList.val)
                return false;
            head = head.next;
            reverseList = reverseList.next;
        }
        return true;
    }

    private ListNode reverse(ListNode list){
        ListNode returnValue = null;

         while (list != null) {
            ListNode temp = list.next;
            list.next = returnValue;
            returnValue = list;
            list = temp;
        }
        return returnValue;
    }
}
```

처음 사용해보는 ListNode라 사용법을 모르겠어서 힌트를 보고 푼게 아쉽다.
ListNode에 대해서 정리해야겠
