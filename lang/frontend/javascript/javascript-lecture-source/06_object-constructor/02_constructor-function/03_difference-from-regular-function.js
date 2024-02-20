// 일반 함수와의 차이점
function Student(name, age) {
    console.log(this);
    this.name = name;
    this.age = age;
    this.getInfo = function () {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
}

// 일반 함수와 생성자 함수의 형식적인 차이는 없다. (첫 문자를 대문자로 기술하여 구별하려 노력한다.)
// 단, new 연산자와 함께 호출할 때 생성자 함수로 동작하며
// 만약 new 연산자와 함께 호출하지 않으면 일반 함수로 동작한다.
const student = Student('강감찬', 35);
// 일반 함수로 호출 된 Student는 반환문이 없으므로 undefined를 반환한다.
console.log(student);
// 일반 함수로 호출 된 Student 내의 this는 전역 객체를 가리킨다.
console.log(age);
console.log(name);
console.log(getInfo());

// 생성자 함수가 new 연산자 없이 호출 되는 것을 방지하기 위해 ES6에서는 new.target을 지원한다.
// new 연산자와 함께 생성자 함수로서 호출 되면 함수 내부의 new.target은 함수 자신을 가리킨다.
// new 연산자 없이 일반 함수로 호출 된 함수 내부의 new.target은 undefined이다.
function Dog(name, age) {

    if(!new.target) {
        // new 연산자와 함께 호출 되지 않은 경우 undefined를 반환하므로
        // new 연산자와 함께 생성자 함수를 재귀 호출 하여 생성 된 인스턴스를 반환한다.
        return new Dog(name, age);
    }

    this.name = name;
    this.age = age;

}
// new 연산자 없이 호출해도 if문에서 다시 new 연산자와 함께 호출해주었으므로 객체를 반환 받는다.
const dog = Dog('뽀삐', 3);
console.log(dog);













