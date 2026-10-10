public class DollarAccount extends BankAccount {


    // 오버로딩 => 동일한 이름의 메서드 여러 개 정의
    // 매개변수의 타입, 개수, 순서 중 하나 이상이 달라야 함
    void inquiry(double currencyRate) {}
    
    // 오버라이딩 => 부모 클래스에서 상속받은 메서드의 내용 변경
    // 자식 클래스의 상황에 맞게
    public void deposit() {

    }
}
