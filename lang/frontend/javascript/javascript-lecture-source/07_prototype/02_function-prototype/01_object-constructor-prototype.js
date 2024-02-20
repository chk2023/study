// 생성자 함수 프로토타입
const user = {
    activate : true,
    login : function () {
        console.log('로그인 되었습니다.');
    }
};

function Student(name) {
    this.name = name;
}

// 여기서의 프로토타입은 앞에서 배운 프로토타입(__proto__)과 이름만 같을 뿐 실제로는 일반 프로퍼티이다.
Student.prototype = user;

// F.prototype은 new F를 호출할 때만 사용이 된다.
// new F를 호출할 때 만들어지는 새로운 객체의 [[Prototype]]을 할당한다.
let student = new Student('홍길동');   // student.__proto__ = user; 내부적으로 동작
let student2 = new Student('유관순');  // student2.__proto__ = user; 내부적으로 동작
let student3 = new Student('신사임당');// student3.__proto__ = user; 내부적으로 동작

console.log(student.name);      // 본인 프로퍼티
console.log(student.activate);  // 상속 프로퍼티
student.login();                // 상속 프로퍼티









