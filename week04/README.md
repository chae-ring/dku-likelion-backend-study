# Week05 - Java 객체지향 프로그래밍과 예외 처리

## 학습 목표

이번 주차에서는 Java의 객체지향 프로그래밍 구조와 예외 처리 방법을 학습하였다.  
은행 계좌 예제를 중심으로 클래스 설계, 객체 생성, 생성자, 캡슐화, 상속, 오버라이딩과 오버로딩을 실습하였고, 프로그램 실행 중 발생할 수 있는 오류를 `try-catch-finally` 문으로 처리하는 방법을 확인하였다.

## 주요 학습 내용

### 1. 객체지향 프로그래밍

객체지향 프로그래밍은 프로그램을 여러 객체의 역할과 책임으로 나누어 구성하는 방식이다.  
이번 실습에서는 `BankAccount` 클래스를 중심으로 계좌 정보를 저장하고, 입금·출금·조회와 같은 기능을 메서드로 분리하여 구현하였다.

```java
BankAccount bankAccount = new BankAccount();
```

`BankAccount` 객체는 계좌번호, 예금주, 잔액, 비밀번호, 휴면 여부 등의 정보를 멤버 변수로 가진다.

```java
private int bankCode;
private int accountNo;
private String owner;
private int balance;
private int password;
private boolean isDormant;
```

기능은 메서드로 분리하여 객체가 스스로 동작을 수행하도록 구성하였다.

```java
public void deposit() {}
public void withdraw() {}
public void inquiry() {}
```

### 2. 캡슐화

계좌 정보처럼 외부에서 직접 변경되면 안 되는 데이터는 `private` 접근 제어자를 사용하여 외부 접근을 제한하였다.  
대신 Getter / Setter 또는 별도의 메서드를 통해 필요한 경우에만 값을 조회하거나 변경할 수 있도록 구현하였다.

```java
private int password;

public void changePassword(int password) {
    this.password = password;
}
```

이를 통해 객체 내부 상태를 안전하게 관리하고, 잘못된 값이 직접 입력되는 상황을 방지할 수 있었다.

### 3. 생성자

생성자는 객체가 생성될 때 초기값을 설정하기 위해 사용한다.  
기본 생성자와 매개변수가 있는 생성자를 함께 구현하여 객체 생성 방식을 다양하게 구성하였다.

```java
BankAccount() {
}
```

```java
BankAccount(int bankCode, int accountNo, String owner, int balance, int password, boolean isDormant) {
    this.bankCode = bankCode;
    this.accountNo = accountNo;
    this.owner = owner;
    this.balance = balance;
    this.password = password;
    this.isDormant = isDormant;
}
```

생성자를 사용하면 객체 생성 직후 필요한 데이터가 설정된 상태로 사용할 수 있어 코드의 안정성과 가독성을 높일 수 있다.

### 4. 상속

상속은 부모 클래스의 필드와 메서드를 자식 클래스가 물려받아 사용하는 개념이다.  
공통 계좌 기능은 `BankAccount` 클래스에 정의하고, 계좌 종류별 특성은 자식 클래스에서 확장하였다.

```java
public class SavingsAccount extends BankAccount
```

이번 실습에서는 `SavingsAccount`, `DollarAccount`, `SubscriptionAccount` 클래스를 구현하였다.  
각 클래스는 `BankAccount`를 상속받아 공통 기능을 재사용하고, 필요한 기능만 추가하거나 변경하였다.

이를 통해 코드 중복을 줄이고, 계좌 종류가 늘어나더라도 구조적으로 확장할 수 있음을 확인하였다.

### 5. 오버라이딩과 오버로딩

오버라이딩은 부모 클래스의 메서드를 자식 클래스의 상황에 맞게 다시 구현하는 방식이다.  
예를 들어 `DollarAccount`에서는 일반 계좌와 다른 입금 방식이 필요했기 때문에 부모 클래스의 메서드를 재정의하였다.

```java
@Override
public void deposit() {
}
```

오버로딩은 같은 이름의 메서드를 유지하면서 매개변수를 다르게 정의하는 방식이다.  
동일한 기능 이름을 사용하되, 입력값에 따라 다른 처리를 할 수 있도록 구성하였다.

```java
void inquiry(double currencyRate) {
}
```

이를 통해 메서드 이름은 일관되게 유지하면서도 다양한 상황에 대응할 수 있었다.

### 6. 예외 처리

프로그램 실행 중 발생할 수 있는 오류를 처리하기 위해 `try-catch-finally` 문을 사용하였다.

```java
try {
    // 예외 발생 가능 코드
} catch (Exception e) {
    // 예외 처리 코드
} finally {
    // 항상 실행되는 코드
}
```

`try` 영역에는 예외가 발생할 수 있는 코드를 작성하고, `catch` 영역에서는 발생한 예외를 처리한다.  
`finally` 영역은 예외 발생 여부와 관계없이 항상 실행되어야 하는 마무리 작업에 사용된다.

예를 들어 0으로 나누는 연산을 통해 `ArithmeticException`이 발생하는 상황을 확인하였다.

```java
int a = 10;
int b = 0;
int c = a / b;
```

또한 예외의 종류에 따라 각각 다른 처리 로직을 작성할 수 있음을 실습하였다.

```java
catch (IndexOutOfBoundsException ioe) {
} catch (IllegalArgumentException iae) {
} catch (Exception e) {
}
```
