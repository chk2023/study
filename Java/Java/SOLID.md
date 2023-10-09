https://limkydev.tistory.com/77

객체지향 설계 5대 원칙
1. SRP (Single Responsibility Principle) 단일 책임 원칙
	클래스에게 역할과 책임을 너무 많이 주면 안 된다.
	클래스에 모든 상태를 때려 넣기 보다는 사용 목적과 취지에 맞는 상태와 행동으로 구성해야 한다. 관련된 책임만 줘야 함.

2. OCP (Open Closed Principle) 개방 폐쇄 원칙
	자신의 확장에는 열려 있고, 주변의 변화에 대해서는 닫혀 있어야 한다.

3. LSP (Liskov Substitution Principle) 리스코프 치환 원칙
	하위 클래스의 인스턴스는 상위형 객체 참조 변수에 대입해 상위 클래스의 인스턴스 역할을 하는데 문제가 없어야 한다.

4. ISP (Interface Segregation Principle) 인터페이스 분리 원칙
	상황에 맞는 메서드만 제공하라.	

5. DIP (Dependency Inversion Principle) 의존 역전 원칙
	자신보다 변하기 쉬운 것에 의존하지 마라.
	구체적으로 추상클래스 또는 상위클래스는 구체적인 구현클래스 또는 하위클래스에게 의존적이면 안 된다.