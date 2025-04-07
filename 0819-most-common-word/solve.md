![image](https://github.com/user-attachments/assets/090ea4a2-1055-4fbd-a144-ae8e26e10c12)

## 문제 
1. 주어진 문자열 `paragraph`와 금지된 단어 배열 `banned`를 사용하여, 금지된 단어가 아니면서 가장 많이 사용된 단어를 리턴하기
2. 금지되지 않은 단어가 적어도 하나는 있으며, 그 정답은 유일하다
3. `paragraph`에 있는 단어들은 대소문자를 구별하지 않으며, 정답은 소문자로 반환되어야 한다

## 해결방안
```
String words = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();
String[] normal = words.split("\\s+");
```

`paragraph`에 존재하는 알파벳이 아닌 글자는 모두 공백으로 바꾸고 (, !, . 등) 소문자로 변환한다. -> 알파벳이 아닌 것들 저 식은 구글링했습니다 ㅠ 
소문자로 변환한 문자열을 공백으로 `split` 하여 배열에 저장한다

```
HashMap<String, Integer> split = new HashMap();
```
나온 단어들과 횟수를 저장하기 위해 `HashMap`을 사용했다

```
for (String word: normal) {
            boolean isBanned = false;
            for (String ban : banned) {
                if (ban.equals(word)) {
                    isBanned = true;
                    break;
                }
            }

            if (!isBanned) {
                split.put(word, split.getOrDefault(word, 0) + 1);
            }
        }
```
배열에 들어가있는 단어를 하나씩 돌면서 `banned` 에 포함되어 있는지 확인한 후, 들어가있지 않으면 `HashMap`에 추가했다.
처음 들어가는 단어들은 `value`를 `0`으로 넣어주며, 또 발견될때마다 `value+1`을 해주었다

```
String mostCommon = "";
        int max = 0;

        for (HashMap.Entry<String, Integer> entry : split.entrySet()) {
            if (entry.getValue() > max) {
                mostCommon = entry.getKey();
                max = entry.getValue();
            }
        }
```

`HashMap`을 `for문`으로 돌면서 가장 높은 `value` 값이 있는 `entry`의 `key`값을 찾는다

## 내 코드
```import java.util.HashMap;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String words = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();

        String[] normal = words.split("\\s+");
        
        HashMap<String, Integer> split = new HashMap();

        for (String word: normal) {
            boolean isBanned = false;
            for (String ban : banned) {
                if (ban.equals(word)) {
                    isBanned = true;
                    break;
                }
            }

            if (!isBanned) {
                split.put(word, split.getOrDefault(word, 0) + 1);
            }
        }
    
        String mostCommon = "";
        int max = 0;

        for (HashMap.Entry<String, Integer> entry : split.entrySet()) {
            if (entry.getValue() > max) {
                mostCommon = entry.getKey();
                max = entry.getValue();
            }
        }

        return mostCommon;
    }
}
```

## 개선할 점
`이중 for문`을 꼭 사용해야할까? 어떻게 하면 `이중 for문` 없이 문제를 해결할 수 있을까
