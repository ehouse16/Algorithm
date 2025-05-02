<h2><a href="https://leetcode.com/problems/reverse-linked-list">206. Reverse Linked List</a></h2><h3>Easy</h3>

### 문제
- 주어진 단일 연결 리스트의 `head`를 가지고 list를 역순으로 바꿔 반환해라
![image](https://github.com/user-attachments/assets/d5e047c1-d9af-41f1-af7c-71f766558252)

### 풀이 방식
예전에 정리해둔 ListNode 글을 보고 변경 전 미리 다음 노드를 저장해두자! 라는 걸 기억하여 prev를 만들고 현재 head를 current에 저장했다
```
ListNode prev =  null;
ListNode current = head;
```

그리고 current가 null이 아닐때까지
다음 노드를 가져오고 서로 변경을 시켜주어 prev가 뒤로 가도록 해주었다

```
while(current != null){
    ListNode next = current.next;
    current.next = prev;
    prev = current;
    current = next;
}
```

그렇게 하면 prev가 제일 뒤로 가게 되는데 그 부분을 head로 주어 반환한다
그렇게 하면 제일 뒤에서부터 앞으로 가르키게 되기 때문에 역순이 된다

### 내 코드
```
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev =  null;
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

        return head;
    }
}
```

### 느낀 점
ListNode는 감이 잘 안잡힌다 포인터의 개념이 아직 부족하여 그런 거 같다. 예전 정리 글이 아니었다면 못 풀었을 듯ㅜ
