<h2><a href="https://leetcode.com/problems/odd-even-linked-list">328. Odd Even Linked List</a></h2><h3>Medium</h3>

### 문제
- 단일 연결 리스트에서 홀수, 짝수 순서로 노드들을 배치
- 공간 복잡도 O(1), 시작 복잡도 O(n)

<img width="444" height="493" alt="image" src="https://github.com/user-attachments/assets/753c8866-902d-48ba-adf5-be180b6fca14" />


### 풀이 방식
```java
ListNode odd = head;
ListNode even = head.next;
ListNode evenHead = even;
```
- odd: 홀수 노드를 만들 때 사용
- even: 짝수 노드를 만들 때 사용
- evenHead: 홀수 리스트 뒤에 붙일 때 사용

```java
while (even != null && even.next != null) {
    odd.next = odd.next.next;   // 홀수 → 다음 홀수로 연결
    even.next = even.next.next; // 짝수 → 다음 짝수로 연결

    even = even.next;           // 짝수 포인터 이동
    odd = odd.next;             // 홀수 포인터 이동
}
```
- 홀수 -> 다음 홀수로 연결
- 짝수 -> 다름 짝수로 연결

```java
odd.next = evenHead;
```
- 홀수 리스트의 마지막 노드를 짝수 리스트 시작에 연결
  
### 느낀 점
어제 문제와 비슷하여 좀 빨리 풀었던 거 같다. 처음에 예외처리 안넣으니까 pass가 안되었었는데,, 예외처리도 습관적으로 사용해야겠다고 생각했다
