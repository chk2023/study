// const
// let 키워드에서 알아본 특징은 모두 동일하며 상수(const) 선언에서 사용 된다는 점이 특징이다.

// const 키워드로 선언한 변수는 반드시 선언과 동시에 초기화 해야 한다.
// const x;
const x = 1;

// const 키워드로 선언한 변수는 재할당 금지
// x = 2;

// 일반적으로 상수의 이름은 대문자로 선언, 여러 단어로 이루어진 경우 _(언더스코어)로 구분
const DISCOUNT_RATE = 0.15;

const student = {
    name : '홍길동',
    age : 20
};

// const 키워드로 선언된 변수에 객체를 할당한 경우 프로퍼티 값을 변경할 수 있다.
student.name = '유관순';
console.log(student);

// 객체를 재할당하는 것은 불가능하다.
// student = {};














