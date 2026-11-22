
/*
Stream API

    오늘 배운 내용

이번에는 자바에서 컬렉션이나 배열에 저장된 데이터를
효율적으로 처리할 수 있도록 도와주는 Stream API에 대해 배웠다.

Stream API는 데이터를 하나씩 반복문으로 처리하는 대신
필터링, 변환, 정렬 등의 작업을 연결해서 작성할 수 있는 기능이다.

이전에 배운 람다식과 함께 사용하면 코드를 더 간결하게 작성할 수 있다.

대표적인 메서드로는 filter(), map(), sorted(), forEach(),
count(), collect() 등이 있다.


    정의

Stream API란 컬렉션이나 배열 등의 데이터를
일정한 처리 과정에 따라 가공하고 처리할 수 있도록
자바에서 제공하는 기능이다.

Stream은 데이터를 직접 저장하는 공간이 아니라
데이터를 처리하기 위한 흐름이다.

주요 특징

- 원본 컬렉션의 데이터를 직접 변경하지 않는다.
- 여러 처리 과정을 연결해서 작성할 수 있다.
- 람다식과 함께 사용하면 코드를 간결하게 만들 수 있다.
- 한 번 사용한 Stream은 다시 사용할 수 없다.


    사용 방법

1. Stream 생성하기

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

        numbers.stream()
               .forEach(num -> System.out.println(num));
    }
}

코드 설명

- stream()을 사용하여 컬렉션을 Stream으로 변환한다.
- forEach()로 데이터를 하나씩 처리한다.
- 저장된 숫자가 순서대로 출력된다.


2. filter() - 조건에 맞는 데이터 선택하기

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        numbers.stream()
               .filter(num -> num >= 20)
               .forEach(num -> System.out.println(num));
    }
}

코드 설명

- filter()는 조건에 맞는 데이터만 선택한다.
- num >= 20 조건을 만족하는 숫자만 남긴다.
- forEach()로 선택된 숫자를 출력한다.

실행 결과
20
25
30


3. map() - 데이터 변환하기

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        numbers.stream()
               .map(num -> num * 2)
               .forEach(num -> System.out.println(num));
    }
}

코드 설명

- map()은 각 데이터를 원하는 형태로 변환한다.
- num * 2를 통해 모든 숫자를 두 배로 만든다.
- 변환된 데이터를 출력한다.

실행 결과
2
4
6
8


4. sorted() - 데이터 정렬하기

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(30, 10, 40, 20);

        numbers.stream()
               .sorted()
               .forEach(num -> System.out.println(num));
    }
}

코드 설명

- sorted()는 데이터를 오름차순으로 정렬한다.
- 정렬된 데이터를 forEach()로 출력한다.

실행 결과
10
20
30
40


5. count() - 데이터 개수 확인하기

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        long count = numbers.stream()
                            .filter(num -> num >= 30)
                            .count();

        System.out.println(count);
    }
}

코드 설명

- filter()로 30 이상의 숫자만 선택한다.
- count()로 조건에 맞는 데이터의 개수를 계산한다.
- 결과는 3이 출력된다.


6. collect() - 처리한 데이터 모으기

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        List<Integer> result = numbers.stream()
                                      .filter(num -> num >= 20)
                                      .collect(Collectors.toList());

        System.out.println(result);
    }
}

코드 설명

- filter()로 20 이상의 숫자를 선택한다.
- collect()로 처리한 데이터를 새로운 List에 저장한다.
- Collectors.toList()는 결과를 List 형태로 모은다.

실행 결과
[20, 25, 30]


    코드 분석

Stream API는 여러 메서드를 연결하여 데이터를 처리할 수 있다.

filter()는 조건에 맞는 데이터를 선택하고,
map()은 데이터를 다른 값으로 변환한다.
sorted()는 데이터를 정렬하고,
forEach()는 각 데이터를 하나씩 처리한다.
count()는 데이터의 개수를 반환하며,
collect()는 처리한 결과를 컬렉션으로 모은다.

Stream의 메서드는 크게 두 종류로 나눌 수 있다.

1) 중간 연산
filter(), map(), sorted()처럼 데이터를 가공하는 작업이다.
여러 중간 연산을 연결할 수 있다.

2) 최종 연산
forEach(), count(), collect()처럼 실제 처리를 마무리하는 작업이다.
최종 연산이 실행되어야 Stream의 데이터 처리가 진행된다.


    복습하면서 알게 된 점

이번 학습을 통해 Stream API를 사용하면
반복문을 길게 작성하지 않아도 데이터를 처리할 수 있다는 것을 알게 되었다.

특히 filter()와 map()을 연결하면 조건에 맞는 데이터를 선택한 뒤
원하는 형태로 변환할 수 있다는 점이 편리했다.

또한 Stream은 데이터를 직접 저장하는 공간이 아니라
데이터를 처리하기 위한 기능이라는 점을 이해했다.


📌 AI 활용 복습 문제

1) Stream API란 무엇인가?

정답: 컬렉션이나 배열 등의 데이터를
필터링, 변환, 정렬 등의 방식으로 처리할 수 있도록
도와주는 자바의 기능이다.

2) filter()의 역할은 무엇인가?

정답: 지정한 조건에 맞는 데이터만 선택한다.

3) map()의 역할은 무엇인가?

정답: 기존 데이터를 원하는 형태의 데이터로 변환한다.

4) sorted()의 역할은 무엇인가?

정답: 데이터를 정렬하는 역할을 한다.

5) 중간 연산과 최종 연산의 차이점은 무엇인가?

정답: 중간 연산은 데이터를 가공하고,
최종 연산은 처리 결과를 출력하거나 수집하는 등
Stream 작업을 마무리한다.
*/
