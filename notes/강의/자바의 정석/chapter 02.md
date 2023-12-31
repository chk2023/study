### 화면에 글자 출력하기, 덧셈 뺄셈 계산하기
println을 하면 출력 후 줄 바꿈.
print만 하면 이어서 출력.

### 변수의 선언과 저장
변수는 하나의 값을 저장할 수 있는 메모리 공간(램). 
메모리 공간에는 메모리 주소와 매핑된 값이 저장되어 있다.
메모리 주소를 다 아는 것은 복잡하기 때문에 변수라는 이름을 붙여 값을 사용한다.

변수 선언 방법
변수타입 변수이름;
int age;

변수에 값 저장
age = 25;
대입한다.

변수에 첨으로 값을 저장하는 것을 변수의 초기화라고 한다.
변수는 클래스 변수, 인스턴스 변수, 지역변수가 있다.
지역변수는 읽기 전에 꼭 초기화해야 한다. 

### 변수의 타입
기본형 타입
![[Pasted image 20231006104337.png]]

### 상수와 리터럴
상수는 한 번만 값을 저장 가능한 변수다.
선언 방법은 변수와 같지만 앞에 final을 붙여준다.
리터럴 = 값

### 리터럴의 타입과 접미사
![[Pasted image 20231006104858.png]]
d(double)는 생략 가능하다.

![[Pasted image 20231006105241.png]]
0b는 2진수를 의미.

20억이 넘는 값은 L을 붙여야 한다. L은 생략 불가하다.

변수와 리터럴의 타입 불일치
변수의 범위가 리터럴의 범위보다 크면 에러가 나지 않는다.
int i = 'A'; //int>char

byte와 short 타입의 리터럴은 없다. 따라서 byte와 short 변수에 int 리터럴을 저장할 수 있다. 단, 변수 타입의 범위 이내여야 한다.
byte b = 128; //에러

### 문자열
문자가 두 개 이상인 경우 문자열 변수에 넣어주어야 한다.

String은 자바에서 제공한 문자를 다루는 클래스다.
원래 클래스는 객체를 생성해야 사용할 수 있다.
String s2 = new String("AB"); //이런식으로
하지만 String은 자주 사용하기 때문에 변수에 값을 넣는 것과 같이 사용한다.
String s1 = "AB";

문자열은 문자 하나만 저장할 수 있고, 빈 문자열을 저장할 수도 있다. 하지만 문자 타입의 변수에 빈 문자를 저장하면 에러.

문자열 끼리 이어줄 때는 +를 사용.

숫자를 문자열로 바꾸려면
![[Pasted image 20231006110550.png]]

### 기본형과 참조형 변수
![[Pasted image 20231007095241.png]]
기본형 타입은 8개가 있다. 기본형 타입은 메모리 공간에 값을 저장한다.

기본형 타입을 제외한 타입이 참조형이다. String, System 등.
참조형 타입의 변수는 메모리 공간에 값이 아닌 주소를 저장한다(스택). 
이 주소는 다른 공간의 값을 참조하는 주소다(힙).

기본형 변수는 타입마다 크기가 다르지만 (byte(1byte), short(2byte), int(4byte), long(8byte)),
참조형 변수는 타입에 관계없이 크기가 항상 4 byte다. (또는 8byte)
4byte로 표현할 수 있는 최대값은 40억 byte이다. 40억 byte이면 4GB의 메모리를 다룰 수 있다는 얘기가 된다. 
OS와 JVM에서 사용하는 부분을 제외하면 실제 프로그램에서 사용할 수 있는 메모리는 절반인 2GB도 안 된다.

32bit JVM의 참조변수는 4byte, 64bit JVM의 참조변수는 8byte의 크기를 가진다. 64bit JVM에서 다룰 수 있는 최대 메모리는 40억 x 40억 byte, 즉, 160경 바이트인 1600만 TB이다. 이는 이론상의 크기이고 실제 사용할 수 있는 메모리는 TB 단위.

![[Pasted image 20231007101706.png]]
참조형 변수 today를 생성.
객체를 생성하고 today에 대입.
today에는 값이 아닌 객체의 주소가 저장된다.
참조변수는 객체의 주소를 저장한다. 

### 기본형의 종류와 범위
![[Pasted image 20231009105042.png]]
![[Pasted image 20231009105446.png]]
1 byte는 8 bit다. bit는 2진수 한 자리의 값을 가지며 0과 1을 가질 수 있다.
예를 들어 3이 byte타입의 b에 저장이 되면, 2진수로 표현하면 11인 3이 저장되며 앞에서부터 0으로 채워진다.
범위에 경우 위와 같은 규칙을 따른다. 예를 들어 8비트로 표현할 수 있는 부호 있는 정수의 범위는 (자바의 정수는 부호가 있다) -2^7 ~ 2^7 -1 즉, -128~127이다.

![[Pasted image 20231009110341.png]]
첫 번째 bit 공간은 양수 또는 음수의 부호가 저장된다. 0은 양수, 1은 음수. 

![[Pasted image 20231009110745.png]]
float 타입은 4 byte인데 어떻게 큰 수를 저장할까? float 타입은부호, 지수, 가수, 세 부분으로 나누어져 저장된다. 대신 float 타입은 원래 값가 저장된 값에 오차가 나타난다. 정밀도를 정하는 것은 가수다. 

### printf를 이용한 출력
```
public class PrintfEx1 {  
    public static void main(String[] args) {  
        System.out.println(10.0/3);  
        System.out.println(10/3);  
    }  
}
```
10/3을 하면 두 타입 모두 정수 이기 때문에 정수 타입인 3이 출력된다. 실수를 얻으려면 10.0/3을 해야한다. 결과는 3.3333333333333335. 

![[Pasted image 20231009112047.png]]
println()은 출력형식을 지정할 수 없다. 실수의 자리수를 조절할 수 없고, 10진수로만 출력된다. 따라서 출력형식을 지정하려면 printf()를 사용한다. 형식을 지정하는 파라미터를 지시자라고 한다.

![[Pasted image 20231009112254.png]]
printf()는 개행문자인 \\n을 붙여줘야 한다.

![[Pasted image 20231009113235.png]]

![[Pasted image 20231009115156.png]]
소수점도 칸 하나를 차지한다. 

### 화면으로부터 입력받기
![[Pasted image 20231009120308.png]]

```
public class ScanfEx1 {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
  
//        int num = scanner.nextInt();  
//        int num2 = scanner.nextInt();  
//        System.out.println(num);  
//        System.out.println(num2);  
  
        String input = scanner.nextLine();  
        int num = Integer.parseInt(input);  
        System.out.println(num);  
    }  
}
```

### 정수형의 오버플로우
![[Pasted image 20231009121750.png]]
![[Pasted image 20231009121815.png]]

### 타입간의 변환방법
charAt(0)
Integer.parseInt()
+'0'
-'0'
