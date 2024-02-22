// 생성자 함수
const student1 = {
    name : '유관순',
    age : 16,
    getInfo() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
};
const student2 = {
    name : '홍길동',
    age : 20,
    getInfo() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
};
const student3 = {
    name : '신사임당',
    age : 30,
    getInfo() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
};
// 객체 리터럴을 이용한 객체 생성 방식은 직관적이고 간편하지만, 단 하나의 객체를 생성한다.
// 따라서 동일 프로퍼티를 갖는 객체를 여러 개 생성해야 하는 경우 비효율적이다.

// 생성자 함수에 의한 객체 생성
// 객체를 생성하기 위한 템플릿처럼 생성자 함수를 사용하여 프로퍼티 구조가 동일한 객체 여러 개를 생성한다.
function Student(name, age) {
    // 생성자 함수 내부의 this는 생성자 함수가 생성할 인스턴스를 가리킨다.
    this.name = name;
    this.age = age;
    this.getInfo = function () {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
}

// 인스턴스의 생성
const student4 = new Student('장보고', 35);
const student5 = new Student('선덕여왕', 40);

console.log(student4);
console.log(student4.getInfo());
console.log(student5);
console.log(student5.getInfo());











