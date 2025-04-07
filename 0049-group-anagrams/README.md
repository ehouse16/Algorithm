<h2><a href="https://leetcode.com/problems/group-anagrams">49. Group Anagrams</a></h2><h3>Medium</h3>

절대로 이렇게 높을 수 없다,,, 다시 풀자,, => 다시 풀기 완료 아래에 해설 추가
![image](https://github.com/user-attachments/assets/2ef334b2-b301-4a6e-a68c-e6e968e28fbc)

## 문제

주어진 문자열 배열에서 anagram인 문자열들을 그룹핑해야한다.

anagram 이란?
* 단어나 문장의 글자들을 각각 한 번씩만 사용하여, 순서를 바꿔서 만든 단어나 구이다!

## 1차 해결 방안
```
List<List<String>> result = new ArrayList<>();
List<String> sortedList = new ArrayList<>();
```

반환할 리스트 하나와, 각각의 단어를 정렬할 리스트 하나를 만든다

```
for (String str : strs) {
            //각 단어 str을 char 배열로 만든다
            char[] charArray = str.toCharArray();
            //정렬한다
            Arrays.sort(charArray);
            //정렬한 char 배열을 String 으로 바꾼다
            String sortedStr = new String(charArray);

            //비교를 위한 check 변수
            int check = -1;

            //for문을 돌며 sortedList에 있는 단어가 정렬한 sortedStr와 같은 지 확인한다
            for (int i = 0; i < sortedList.size(); i++) {
                if (sortedList.get(i).equals(sortedStr)) {
                    check = i;
                    break;
                }
            }

            //없으면 sortedList에 정렬된 값 넣기
            //그리고 새로운 List에 원래 단어 넣고, 반환할 List result에 넣기
            if (check == -1) {
                sortedList.add(sortedStr);
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                result.add(newGroup);
            }
            //존재한다면 들어있던 반환할 List result에 넣기
            else {
                result.get(check).add(str);
            }
        }
```

## 내 코드
```
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> sortedList = new ArrayList<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            int check = -1;
            for (int i = 0; i < sortedList.size(); i++) {
                if (sortedList.get(i).equals(sortedStr)) {
                    check = i;
                    break;
                }
            }

            if (check == -1) {
                sortedList.add(sortedStr);
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                result.add(newGroup);
            } else {
                result.get(check).add(str);
            }
        }

        return result;
    }
}
```

## 개선 방향
* List<List<String>>이 뭔가 별로이다,,, Map 사용이 안 될까?
* 이중 for문 맨날 사용하는 것 같은데 이걸 어칸담? 맘에 안들지만 다른 방법을 모르니 패스,,, 정답 찾아봐야겠다

---

## 2차 해결 방안
일단 List<List<String>>을 HashMap으로 바꾸고 진행했다
```
Map<String,List<String>> result = new HashMap<>();
```

그리고 똑같이 for문 돌면서 HashMap에 정렬한 문자열을 key로 넣고, 정렬했을 때 똑같은 문자열이 있다면 value의 List에 추가하는 식으로 해결했다
```
for (String str : strs) {
    char[] charArray = str.toCharArray();
    Arrays.sort(charArray);
    String sortedStr = new String(charArray);

    if(!result.containsKey(sortedStr)){
         result.put(sortedStr, new ArrayList<>());
    }
    result.get(sortedStr).add(str);
}
```

![image](https://github.com/user-attachments/assets/3cac9b84-a240-449d-ad2f-4eb23e124ea9)

## 배운 점
List<List<String>> 보다 Map을 사용하자 -> 효율 굿
