### 프로그램 오류, 예외 클래스의 계층구조
![[Pasted image 20231023094401.png]]
javac.exe가 자바 컴파일러다. 커맨드 창에서 컴파일 하려면 javac.exe가 있는 경로에서 javac OO.java라고 입력.
컴파일러가 기본적으로 하는 일은 번역, 구문체크, 최적화, 생략된 코드 추가. 
컴파일 에러는 클래스 파일이 만들어지지 않는다.

런타임 에러는 실행 중 발생하는 에러. 소스파일을 실행 시키려면 위와 같은 경로에서 java OO.java를 입력해주면 된다. 클래스 파일은 만들어지지만 실행 과정에서 프로그램이 죽는다.

논리적 에러는 프로그램이 종료되지 않는다. 예) 비행기 게임에서 내 의도와 다르게 미사일에 맞아도 죽지 않음.

![[Pasted image 20231023095645.png]]
런타임 에러는 에러와 예외로 구분된다. 
심각한 오류는 처리할 수 없다. 코드로 수습 가능한 것을 예외라고 한다.
에러의 예는 OOME(out of memory error).

![[Pasted image 20231023100017.png]]
예외가 발생하면 프로그램이 죽는다. 죽지 않게 하는 것이 예외처리다. 
수습될 수 있는 다소 미약한 오류인 예외가 발생했을 때 이를 대비하는 코드를 작성하는 것이 예외처리라고 할 수 있다.

![[Pasted image 20231023100523.png]]
예외 클래스 계층 구조를 보면 Exception(예외)과 Error(에러)로 구분된다.
Exception은 다시 두 가지로 구분된다. Exception의 자손들과 RuntimeException의 자손들.
물론 RuntimeException도 Exception의 자손이긴 하다. 

Exception클래스와 그 자손은 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외.
RuntimException클래스와 그 자손은 프로그래머의 실수로 발생하는 예외.


### 예외 처리하기, try-catch문의 흐름

![[Pasted image 20231023104846.png]]
예외를 처리할 때 사용하는 것이 try-catch문이다. 

![[Pasted image 20231023105720.png]]
case 1: 1 출력>> 2,3 출력>> 예외 발생 안 하면 catch 블럭을 빠져나와서 5 실행.
case 2: 1 출력>> try 블럭에서 예외 발생. 0으로 나눌 수 없다 >> catch 블럭으로 가서 예외를 처리 >>3 출력 >> 4 출력

만약 예외를 처리하지 못하면 프로그램은 비정상적으로 종료된다. 

![[Pasted image 20231023110729.png]]
0으로 나누는 예외가 발생. 그 후 캐치 블럭으로 가는데 두 개가 있다. 이 중 어떤 것이 발생한 예외랑 일치하는 지 확인. 0으로 나누는 것은 ArithmeticException에 해당하기 때문에 해당 블럭을 실행하고 블럭을 빠져나와 5 출력. 예외가 발생한 이후의 문장은 실행되지 않는다. 
만약 발생한 예외가 첫 번째 캐치 블럭과 다르다면 두 번째 캐치 블럭으로 간다. Exception은 모든 예외의 최고 조상이다. 모든 예외를 다 처리할 수 있다. 따라서 Exception이 선언된 catch 블럭은 마지막에 위치한다.


### printStackTrace(), 멀티 catch 블럭





### 예외 발생시키기






### 예외 선언하기, finally 블럭





### 사용자 정의 예외 만들기, 예외 되던지기








### 연결된 예외
