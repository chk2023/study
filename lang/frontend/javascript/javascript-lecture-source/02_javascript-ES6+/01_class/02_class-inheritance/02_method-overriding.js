// 메서드 오버라이딩

// Animal 클래스 선언
class Animal {
    constructor(name, weight) {
        this.name = name;
        this.weight = weight;
    }

    eat(foodWeight){
        this.weight += foodWeight;
        console.log(`${this.name}(은)는 ${foodWeight}kg의 식사를 하고 ${this.weight}kg이 되었습니다.`);
    }

    move(lostWeight){
        if (this.weight > lostWeight) {
            this.weight -= lostWeight;
            console.log(`${this.name}(은)는 움직임으로 인해 ${lostWeight}kg 감량 되어 ${this.weight}kg이 되었습니다.`);
        }
    }
}

// Animal을 상속 받는 Tiger 클래스 선언
class Tiger extends Animal {
    attack(target) {
        console.log(`${this.name}(은)는 ${target}을 공격합니다.`)
    }

    // Animal의 move 오버라이딩
    move(target) {
        this.attack(target);
        super.move(0.1);
    }

}

let tiger = new Tiger("백두산 호랭이", 90);
tiger.move("슬픈 눈망울의 사슴");


















