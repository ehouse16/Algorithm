<h2><a href="https://leetcode.com/problems/merge-two-sorted-lists">21. Merge Two Sorted Lists</a></h2><h3>Easy</h3>

![image](https://github.com/user-attachments/assets/5041f349-201f-434e-93cf-d76bea4b3fcb)

## 문제
1. 2개의 정렬된 list1과 list2의 시작점이 주어진다
2. 2개의 list를 하나의 정렬된 리스트로 합쳐라
3. 정렬된 리스트의 시작점을 반환해라

## 풀이 방식
```java
ListNode dummy = new ListNode(-1);
ListNode returnValue = dummy;
```
- dummy 노드를 하나 생성해서, 결과 리스트의 시작 지점으로 사용

```java
while(list1 != null && list2 != null){
    if(list1.val < list2.val){
        returnValue.next = list1;
        list1 = list1.next;
    }
    else{
        returnValue.next = list2;
        list2 = list2.next;
    }
    returnValue = returnValue.next;
}
```
- returnValue 포인터는 결과 리스트를 따라가며 새로운 노드를 연결-
- list1과 list2가 모두 남아 있는 동안, 두 노드의 값을 비교해서 작은 값을 결과 리스트에 연결

```java
if(list1 != null){
    returnValue.next = list1;
} else {
     returnValue.next = list2;
}
```

- 하나의 리스트가 먼저 끝나면, 남은 리스트를 통째로 결과 리스트에 붙임

```java
return dummy.next;
```
- 마지막에 dummy.next를 반환해서 진짜 결과 리스트의 시작 노드를 넘김

## 내 코드
```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode returnValue = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                returnValue.next = list1;
                list1 = list1.next;
            }
            else{
                returnValue.next = list2;
                list2 = list2.next;
            }
            returnValue = returnValue.next;
        } 

        if(list1 != null){
            returnValue.next = list1;
        } else {
            returnValue.next = list2;
        }

        return dummy.next;
    }
}
```

https://velog.io/@ehouse16/ListNode%EC%99%80-%EC%97%B0%EA%B2%B0-%EB%A6%AC%EC%8A%A4%ED%8A%B8

ListNode 정리 글 작성 완료. 이 문제 풀다가 도저히 안되겠어서 정리를 하고 풀었다ㅠ 해도해도 어려운 것...😥
