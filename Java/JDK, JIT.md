https://doozi0316.tistory.com/entry/1%EC%A3%BC%EC%B0%A8-JVM%EC%9D%80-%EB%AC%B4%EC%97%87%EC%9D%B4%EB%A9%B0-%EC%9E%90%EB%B0%94-%EC%BD%94%EB%93%9C%EB%8A%94-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%8B%A4%ED%96%89%ED%95%98%EB%8A%94-%EA%B2%83%EC%9D%B8%EA%B0%80

**JDK**
Java Development Kit. 자바 개발 키트.
자바를 사용하기 위해 필요한 모든 기능을 갖춘 SDK(Software Development Kit)이다. 컴파일러(javac), jdb, javadoc과 같은 도구.
JDK는 JRE를 포함한다.

![[Pasted image 20230927122817.png]]

**JRE**
Java Runtime Environment. 자바 런타임 환경.
JVM + 자바 클래스 라이브러리 등으로 구성되어 있다.

**JIT**
JIT 컴파일 또는 동적 번역이라고 한다. JIT 컴파일러는 프로그램을 실행하는 시점에 기계어로 번역하는 컴파일러다.

인터프리터 방식의 단점을 보완하기 위해 도입.
인터프리터 방식으로 실행하다가 적절한 시점에 바이트 코드 전체를 컴파일하여 기계어로 변경하고, 이후에는 인터프리팅 하지 않고 기계어로 직접 실행.

**가비지 콜렉터**
더 이상 사용되지 않는 인스턴스를 찾아 메모리에서 삭제.