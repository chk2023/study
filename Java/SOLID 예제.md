https://blog.siner.io/2020/06/18/solid-principles/

객체지향하는 이유 유지보수, 확장성을 용이하게게

1. SRP 단일 책임 원칙
![[Pasted image 20230927213539.png]]

```
export class BasicWorker {
public position;

public doMyJob(): boolean {
// 내 할일만 하면 된다
try {
return this.position;
} catch {
throw Error('I don\'t have any position');
}
}
}

class BackendDeveloper extends BasicWorker {
constructor() {
super();
this.position = 'backend-developer';
}
}

class FrontendDeveloper extends BasicWorker {
constructor() {
super();
this.position = 'frontend-developer';
}
}

const backendDeveloper: BackendDeveloper = new BackendDeveloper(); // 나는 백엔드 개발자다.
backendDeveloper.doMyJob();
​
const frontendDeveloper: FrontendDeveloper = new FrontendDeveloper(); // 나는 프론트엔드 개발자다.
frontendDeveloper.doMyJob();

```

2. OCP 개방 폐쇄 원칙
![[Pasted image 20230927213910.png]]
클래스 확장에는 개방적이어야 하고, 변경에는 폐쇄적이어야 한다.
```
class GoodDeveloper2019 {
public eat(): boolean {
console.log('eating'); // 먹기
return true;
}

public sleep(): boolean {
console.log('sleeping'); // 자기
return true;
}


const developer = new GoodDeveloper2019();
developer.eat();
developer.sleep();

/**
* 중간에 다른일을 추가해야한다면?
*/
​
class GoodDeveloper2020 {
public eat(): boolean {
console.log('eating'); // 먹기
return true;
}

public sleep(): boolean {
console.log('sleeping'); // 자기
return true;
}

public develop(): boolean {
console.log('developing'); // 개발하기
return true;
}

public rest(): boolean {
console.log('resting'); // 쉬기
return true;
}

const developer = new GoodDeveloper2020();
developer.sleep();
developer.rest();
developer.develop();
developer.eat();
```


3. LSP 리스코프 치환 원칙
![[Pasted image 20230927214457.png]]
만약 S가 T의 서브타입이라면, T는 어떠한 경고도 내지 않으면서, S로 대체가 가능하다. 
자식 클래스는 부모 클래스가 할 수 있는 모든 것을 할 수 있어야 한다.
```
class GoodClockParent {
public date: Date;
public dateString: string;

constructor() {
this.date = new Date();
this.dateString = this.date.toString();
}

public getDate(): string {
return this.dateString;
}
}

const clockParent: GoodClockParent = new GoodClockParent();
clockParent.getDate(); // Thu Jun 18 2020 01:11:27 GMT+0900 (대한민국 표준시)

/**
* 아래는 자식
*/

class GoodClockChild extends GoodClockParent {
public dateLocaleString: string;

constructor() {
super();
this.dateLocaleString = this.date.toLocaleString();
}

public getDateWithLocaleString(): string {
return this.dateLocaleString;
}
}

const clockChild: GoodClockChild = new GoodClockChild();
clockParent.getDate(); // Thu Jun 18 2020 01:11:27 GMT+0900 (대한민국 표준시)
clockChild.getDateWithLocaleString(); // 2020. 6. 18. 오전 1:11:33
```

4. ISP 인터페이스 분리 원칙
![[Pasted image 20230927214846.png]]
클라이언트는 사용하지 않는 메서드에 대해 의존적이지 않아야 한다.
클래스는 해당 역할에 대한 액션만 수행해야 하고, 이를 제외한 다른 액션은 삭제하거나
이동해야 한다.


5. DIP 의존 관계 역전 원칙
![[Pasted image 20230927214852.png]]
추상은 구체에 의존하지 않아야 하며, 구체는 추상에 의존해야 한다.

```
interface Robot {  work(): void;  }  ​  

class GuideRobot implements Robot {  work(): void {  // guiding logic  }  }  ​  

class CookingRobot implements Robot {  work(): void {  // cooking logic  }  }  ​  

const robot1: Robot = new GuideRobot();  robot1.work(); // guiding logic  ​  

const robot2: Robot = new CookingRobot();  robot2.work(); // cooking logic
```
