### 조건문 if문과 if-else문
if문 괄호 안에 조건문이 true 면 중괄호 안에 내용을 실행. false라면 해당 if문을 스킵하고 그 다음 문장 실행.

조건문은 조건을 만족할때만 {}를 수행. if, switch
반복문은 조건을 만족하는 동안 {}를 수행. for, while
조건문, 반복문을 제어문이라고 한다.

조건문 괄호의 조건은 boolean 식으로 나타내야 한다.

![[Pasted image 20231011164435.png]]
![[Pasted image 20231011164921.png]]

### if-else if문, 중첩 if문
if-else는 둘 중 하나를 처리한다. if-else if문은 여러 개의 경우의 수를 처리할 때 사용한다.
![[Pasted image 20231011165154.png]]

![[Pasted image 20231011170421.png]]

### switch 문
경우의 수가 많을 때는 if-else if문 보다 swtich가 사용하기 좋다.
![[Pasted image 20231011170910.png]]
switch는 조건식에 정수와 문자열을 넣을 수 있다. if-else if와 다르게 조건식을 매번 써주지 않아도 된다. 
 
![[Pasted image 20231011171518.png]]

### 임의의 정수 만들기
![[Pasted image 20231011172925.png]]
Math.random()은 0.0과 1.0사이의 임의의 double 값을 반환한다. 
범위를 더 넓혀서 임의의 숫자를 얻으려면? Math.random()의 숫자를 곱해준다.
정수를 얻으려면 형변환.

### for문
int i=0;을 for문 밖으로 빼주고 for( ; ; ) 이런식으로 쓸 수도 있다. 이렇게 조건식을 생략하면 true로 간주되어서 무한반복문이 된다. 

### 중첩 for 문
![[Pasted image 20231013201012.png]]
구구단

![[Pasted image 20231013202943.png]]

```
for (int i = 1; i <= 5; i++) {  
    for (int j = 1; j <= i; j++) {  
        System.out.print("*");  
    }  
    System.out.println();  
}
--
*
**
***
****
*****
```
j를 상수인 리터럴 값으로 두면 같은 수의 별이 찍힌다. 하지만 이를 변수인 i로 두면 줄 마다 찍히는 별의 숫자가 달라진다. 

### while문, do-while문
![[Pasted image 20231013204145.png]]
반복 횟수를 모르면 while을 사용. 조건식이 있다. for와 while은 호환가능.

![[Pasted image 20231013210659.png]]

### break문, continue문, 이름붙은 반복
![[Pasted image 20231013212057.png]]
while(ture){} 또는 for(;;){} 반복문은 무한반복문이다. 
break; 되면 반복문을 빠져나온다.

![[Pasted image 20231013212904.png]]
3의 배수일 경우 i를 출력하지 않고 건너뛴다. 

![[Pasted image 20231013213357.png]]
반복문에 이름을 붙여 하나 이상의 반복문을 벗어날 수 있다. 
