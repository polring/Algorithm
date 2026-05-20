# 📊 1. 배열 및 문자열 마스터 가이드

> 고정 크기의 원시 배열(`[]`)과 문자열 데이터를 효율적으로 조작하고 처리하는 자바 핵심 도구입니다.

---
## Array Instance Property
- `length` : 배열의 크기 출력 


## 🛠️ java.util.Arrays (배열 제어 유틸리티)
일반 배열을 다룰 때 For문을 쓰지 않고 한 줄로 끝낼 수 있도록 돕는 static 메서드 집합입니다.

| 메서드 | 설명 | 예시 |
| :--- | :--- | :--- |
| `Arrays.sort(배열)` | 배열의 요소를 오름차순으로 정렬 | `Arrays.sort(arr);` |
| `Arrays.toString(배열)` | 1차원 배열의 내부 값을 대괄호`[]` 형태로 이쁘게 출력 | `System.out.println(Arrays.toString(arr));` |
| `Arrays.deepToString(배열)` | **2차원 배열**의 내부 값을 출력할 때 필수 사용 🔥 | `System.out.println(Arrays.deepToString(matrix));` |
| `Arrays.copyOfRange(배열, 시작, 끝)` | 배열의 특정 인덱스 범위를 복사하여 새 배열 생성 | `int[] sub = Arrays.copyOfRange(arr, 1, 4);` |
| `Arrays.fill(배열, 值)` | 배열의 모든 요소를 지정한 특정 값으로 한 번에 초기화 | `Arrays.fill(arr, -1);` |

---
## String
> 자바에서 String은 불변(Immutable) 객체이다.
### String 주요 메서드

#### String instance method
- `.length()` : 문자열 길이 반환
- `.charAt(int idx)` : 특정 인덱스의 문자 반환 (char)
- `.substring(int s, int e)` : s부터 e-1까지 문자열 추출
- `.indexOf(String str)` : 문자열이 시작되는 인덱스 반환 (없으면 -1)
- `.contains(CharSequence s)` : 포함 여부 (true/false)
- `.split(String regex)` : 정규식 기준으로 나누어 String[] 반환
- `.replace(target, replacement)` : 문자열 치환
- `.replaceAll(regex, replacement)` : 정규식을 이용한 치환 (특수문자, 숫자 제거 시 유용)
- `.toCharArray()` : `char[]` 배열로 변환 (반복문 돌릴 때 유용)
#### String static method
- `String.valueOf(값)` : 숫자 등을 문자열로 변환
- `String.join(Delimiter,Iterable)` : 리스트나 배열을 하나의 문자열로 결합
- `String.format(Stirng format,Object ... args)` : 문자열 형식 지정하기
- `String.copyValueOf()` : char 배열을 문자열로 변환

## 🔤 java.lang.StringBuilder (가변 문자열 조작)
자바의 일반 `String`은 불변 객체이므로 문자열을 수정할 때마다 새로운 메모리가 낭비됩니다. 반복문 안에서 문자열을 계속 이어 붙이거나 뒤집어야 할 때는 반드시 이 클래스를 사용해야 합니다.

*   **선언법:** `StringBuilder sb = new StringBuilder();`

### 📌 주요 메서드
- `.append(값)`: 문자열 맨 뒤에 값을 추가 (숫자, 문자, 객체 모두 가능)
- `.insert(인덱스, 값)`: 지정한 인덱스 위치에 값을 삽입
- `.delete(시작, 끝)`: 시작 인덱스부터 (끝-1) 인덱스까지 삭제
- `.reverse()`: 문자열의 순서를 완전히 뒤집음
- `.toString()`: 최종 완성된 가변 문자열을 일반 `String` 객체로 변환

```java
// 실전 활용 예시
StringBuilder sb = new StringBuilder("hello");
sb.append("world");          // "helloworld"
sb.insert(5, " ");           // "hello world"
sb.reverse();                // "dlrow olleh"
String result = sb.toString();
```

## StringTokenizer
> string을 구분자를 기준으로 토큰화 시키는 객체이다

```java
import java.util.StringTokenizer;

StringTokenizer st = new StringTokenizer(str,delim);
System.out.println( st.nextToken());
```
