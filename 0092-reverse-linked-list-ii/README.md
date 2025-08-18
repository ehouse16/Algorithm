<h2><a href="https://leetcode.com/problems/reverse-linked-list-ii">92. Reverse Linked List II</a></h2><h3>Medium</h3>

### 문제
주어진 left와 right 사이의 수만 reverse하기
<img width="405" height="177" alt="image" src="https://github.com/user-attachments/assets/098e7a9b-82e2-4c13-8cb9-740cfcd1c768" />
<img width="406" height="556" alt="image" src="https://github.com/user-attachments/assets/f6a80022-07bb-46e1-88b1-851903c93962" />

### 풀이 방식
```java
for (int i = 1; i < left; i++) {
    prev = prev.next;
}
```
- left 위치 직전 노드까지 이동하기

```java
ListNode curr = prev.next;
ListNode subTail = curr;  
ListNode rev = null;
```
- curr: 실제 뒤집기 시작할 노트
- subTail: 나중에 뒤쪽과 연결할 때 사용
- rev: 뒤집힌 리스트의 앞쪽을 가리킬 임시 변수

```java
for (int i = left; i <= right; i++) {
    ListNode next = curr.next;
    curr.next = rev;
    rev = curr;
    curr = next;
}
```
- 뒤집기!

```java
prev.next = rev;
```
- 앞쪽 연결

```java
subTail.next = curr;
```
- 뒤쪽 연결
  
### 내 코드
```java
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode subTail = curr;  
        ListNode rev = null;

        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = rev;
            rev = curr;
            curr = next;
        }

        prev.next = rev;
        subTail.next = curr;

        return dummy.next;
    }
}
```
