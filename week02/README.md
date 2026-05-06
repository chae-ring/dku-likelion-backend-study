📘 함수(Function) / 메서드(Method) 개념 정리
📌 개요

이번 학습에서는 Java에서 함수(메서드)의 개념과 사용 방법을 익혔다.
함수는 특정 기능을 수행하는 코드 묶음으로, 코드의 재사용성과 가독성을 높이는 데 중요한 역할을 한다.

📌 함수(메서드)란?
특정 작업을 수행하는 코드 블록
필요할 때 호출하여 사용
코드 중복을 줄이고 유지보수를 쉽게 함
📌 함수의 기본 구조
반환타입 함수이름(매개변수) {
// 실행 코드
return 값;
}
예시
static int mod(int a, int b) {
return a % b;
}
📌 주요 구성 요소

1. 반환 타입 (Return Type)
   함수가 실행 후 돌려주는 값의 타입
   void → 반환값 없음
   void print() { }
   int sum() { return 0; }
2. 함수 이름
   함수의 역할을 나타내는 이름
   보통 동사 형태로 작성

예: printList, getSum, calculate

3. 매개변수 (Parameter)
   함수로 전달되는 입력값
   int add(int a, int b)

👉 a, b가 매개변수

4. 반환값 (Return)
   함수 실행 결과를 호출한 곳으로 돌려줌
   return a + b;
   📌 함수 호출
   int result = mod(3, 2);

👉 실행 흐름

mod(3, 2) 호출
함수 내부 실행
결과 반환 → result에 저장
📌 static 함수 vs 일반 함수
✔ static 함수
객체 생성 없이 호출 가능
static void hello() { }
✔ 일반 함수
객체 생성 후 사용
void hello() { }

MethodsExample ex = new MethodsExample();
ex.hello();
📌 함수 사용 이유
코드 재사용 가능
가독성 향상
유지보수 용이
기능 단위로 분리 가능
📌 예제 흐름
ArrayList<Integer> list = new ArrayList<>();
list.add(10);
list.add(100);

printListElements(list);

👉 리스트를 함수에 전달하여 출력 수행
