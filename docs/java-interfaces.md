# 📐 실전 필수 인터페이스 가이드 (비교 · 자원정리 · 함수형)

## ⚖️ 1. 객체 비교를 위한 인터페이스 (Comparable)
>내가 만든 커스텀 클래스(객체)들이 정렬 알고리즘(`Arrays.sort()`, `Collections.sort()`)을 만났을 때 **기본적으로 어떻게 정렬될지 객체 자체에 규칙을 선언**하는 인터페이스입니다.

- **핵심 메서드:** `public int compareTo(T o)`
- **정렬 원리:** `Integer.compare(내값, 상대값)`의 결과가 음수면 앞으로(오름차순), 양수면 뒤로 보냅니다.

```java
class Node implements Comparable<Node> {
    int id;
    int cost;

    public Node(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    // cost(비용)를 기준으로 오름차순 정렬 규칙 고정
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost); 
    }
}
```

## 2. Comparator & Lambda (즉석에서 다중 정렬 규칙 세우기)
>기본 정렬 기준 외에 정렬이 필요한 시점에 즉석에서 임시 규칙을 주거나, 2차원 배열 정렬 등 복잡한 다중 조건을 세울 때 사용합니다. 현대 자바에서는 람다식(Lambda)을 이용해 간결하게 규칙만 주입합니다.

```java
int[][] points = {{2, 3}, {1, 2}, {2, 1}};
// 1. X좌표 기준 오름차순 -> 2. X좌표가 같으면 Y좌표 오름차순 규칙 적용
Arrays.sort(points, (o1, o2) -> {
    if (o1[0] == o2[0]) {
        return Integer.compare(o1[1], o2[1]);
    }
    return Integer.compare(o1[0], o2[0]);
    });
```

## 3. java.lang.AutoCloseable (자원 자동 반납 규칙)
>파일 입출력(BufferedReader, FileReader) 등 시스템 자원을 소모하는 객체를 다 쓴 뒤, 수동으로 .close()를 호출하지 않아도 블록을 벗어날 때 안전하게 자원을 자동 폐기해 주는 규칙입니다.
```java
// BufferedReader는 내부적으로 AutoCloseable 인터페이스를 구현하고 있습니다.
try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
    String line = br.readLine();
    System.out.println(line);
} catch (IOException e) {
    e.printStackTrace();
} // 💡 블록을 나가는 순간 자바가 알아서 br.close()를 실행해 줌
```

## 4. 람다 활용을 위한 함수형 인터페이스 (Functional Interface)
>구현해야 하는 추상 메서드가 **단 하나뿐인 인터페이스**를 의미합니다. 거추장스러운 익명 클래스 선언을 생략하고, 즉석에서 화살표 문법을 쓰는 **람다식(Lambda Expression)**을 사용할 수 있게 해주는 현대 자바의 핵심 도구입니다.

| 인터페이스명 | 추상 메서드 | 매개변수 (Input) | 반환값 (Output) | 설명 | 한 줄 요약 |
| :--- | :--- | :---: | :---: | :--- | :--- |
| **`Runnable`** | `void run()` | 없음 | 없음 | 매개변수와 반환값 없이 특정 로직을 실행합니다. | **실행기** |
| **`Supplier<T>`** | `T get()` | 없음 | 있음 ($T$) | 매개변수 없이 데이터를 공급(생성)하여 반환합니다. | **공급자** |
| **`Consumer<T>`** | `void accept(T t)` | 있음 ($T$) | 없음 | 매개변수를 받아서 소비(출력, 저장 등)하고 끝냅니다. | **소비자** |
| **`Function<T, R>`** | `R apply(T t)` | 있음 ($T$) | 있음 ($R$) | 입력값($T$)을 받아서 다른 타입의 결과값($R$)으로 변환(매핑)합니다. | **변환기** |
| **`Predicate<T>`** | `boolean test(T t)` | 있음 ($T$) | `boolean` | 입력값을 받아 조건식을 평가한 후 참(`true`) 또는 거짓(`false`)을 반환합니다. | **조건 검사기** |

