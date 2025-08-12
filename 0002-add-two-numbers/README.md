<h2><a href="https://leetcode.com/problems/add-two-numbers/">2. Add Two Numbers</a></h2><h3>Medium</h3> 

### 문제

<img width="498" height="357" alt="image" src="https://github.com/user-attachments/assets/7ca14b71-fb3a-480e-85c6-2438a37ed9a1" />

- 주어진 2개의 단일 연결 리스트를 가지고 거꾸로 더한 값을 linkedlist로 반환하기

<img width="484" height="424" alt="image" src="https://github.com/user-attachments/assets/e98141b9-0837-41e1-aa15-00f68ff8ae2d" />

---

### 풀이 방식
```java
ListNode node = new ListNode(-1);
ListNode result = node;
int add = 0;
```
- node: 결과 리스트를 만들기 위한 더미(head) 노드 생성
- result: 최종적으로 반환할 리스트 시작 위치 저장
- add: 올림 수 저장 변수

```
while(list1 != null || list2 != null) {
    int sum = add; // 이전 자리에서 넘어온 carry 포함
    
    if(list1 != null) {
        sum += list1.val;
        list1 = list1.next; // 다음 노드로 이동
    }
    
    if(list2 != null) {
        sum += list2.val;
        list2 = list2.next;
    }
```
- list1과 list2 둘 다 끝날 때까지 반복
- 현재 자리수에 올림 수 더하고, 값 더하기
- 각 리스트 더하고 다음 노드로 이동!

---

### 동작 예시

입력:list1 = 2 → 4 → 3 (342)
list2 = 5 → 6 → 4 (465)
1.	첫 자리: 2 + 5 = 7 → carry = 0 → 결과: 7
2.	둘째 자리: 4 + 6 = 10 → carry = 1 → 결과: 0
3.	셋째 자리: 3 + 4 + 1(carry) = 8 → carry = 0 → 결과: 8

결과: 7 → 0 → 8 (807)

---

### 내 코드
```
class Solution {
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(-1);
        ListNode result = node;
        int add = 0;

        while(list1 != null || list2 != null){
            int sum = add;

            if(list1 != null){
                sum += list1.val;
                list1 = list1.next;
            }
            
            if(list2 != null){
                sum += list2.val;
                list2 = list2.next;
            }

            add = sum/10;
            sum %= 10;

            node.next = new ListNode(sum);
            node = node.next;
        }
        if(add > 0){
            node.next = new ListNode(add);
        }
        return result.next;
    }
}
```

### 느낀 점 
오랜만에 알고리즘 + 아직도 어려운 Node의 개념으로 한시간 반 걸렸다 🥲 
