// 생성자 오버라이딩

// Animal 클래스 선언
class Animal {
    constructor(name, weight) {
        this.name = name;
        this.weight = weight;
    }

    eat(foodWeight) {
        this.weight += foodWeight;
        console.log(`${this.name}(은)는 ${foodWeight}kg의 식사를 하고 ${this.weight}kg이 되었습니다.`);
    }

    move(lostWeight) {
        if (this.weight > lostWeight) {
            this.weight -= lostWeight;
            console.log(`${this.name}(은)는 움직임으로 인해 ${lostWeight}kg 감량 되어 ${this.weight}kg이 되었습니다.`);
        }
    }
}

/* 클래스가 다른 클래스를 상속 받고 constructor를 선언하지 않는 경우 비어 있는 생성자가 만들어진다.
* class Tiger extends Aniaml {
*   constructor(...args) {
*       super(...args);
*    }
* }
* */

class Deer extends Animal {
    constructor(name, weight, legLength) {
        // this.name = name;
        // this.weight = weight;
        // 상속 클래스의 생성자에는 반드시 부모 클래스 생성자를 호출하는 구문이 들어가야 한다.
        super(name, weight);
        this.legLength = legLength;
    }
    
    hide(place) {
        console.log(`${this.name}(은)는 ${place}에 숨습니다.`);
    }
}

let deer = new Deer("슬픈 눈망울의 사슴", 40, 1);
deer.hide('동굴 안');














