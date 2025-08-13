<h2><a href="https://leetcode.com/problems/swap-nodes-in-pairs">24. Swap Nodes in Pairs</a></h2><h3>Medium</h3>
<img width="567" height="560" alt="image" src="https://github.com/user-attachments/assets/1d8bbf54-ab7e-4c2a-9e06-7e5d380e0c8a" />

### 문제
연결 리스트를 직접 값(value)가 아닌 **노드의 연결(next)** 을 바꿔서 두 개씩 swap하기
<img width="467" height="388" alt="image" src="https://github.com/user-attachments/assets/8f090e86-53e9-4ec9-86d7-ddf0e4e0d932" />

### 풀이방식
```java
ListNode dummy = new ListNode(0);
dummy.next = head;  // dummy → 1 → 2 → 3 → 4
ListNode prev = dummy;
```
- dummy: swap 이후의 head 반환용
- prev: 매 번 swap 이후의 다음 쌍 앞의 노드를 가리킴

```java
prev.next = second;         // dummy → 2
first.next = second.next;   // 1 → 3
second.next = first;        // 2 → 1
```

```java
prev = first;       // prev → 1
head = first.next;  // head → 3
```

### 내 코드
```java
class Solution {
    public ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            head = first.next;
        }
        return dummy.next;
    }
}
```
