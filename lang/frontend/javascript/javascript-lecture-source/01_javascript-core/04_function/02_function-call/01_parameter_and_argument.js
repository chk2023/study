// 매개변수와 인수
function hello(name) {

    // 모든 인수는 암묵적으로 arguments 객체의 프로퍼티로 보관 된다.
    console.log(arguments);

    return `${name}님 안녕하세요`;
}

// 매개변수 함수 몸체 외부에서 참조할 수 없다.
// console.log(name); - ReferenceError: name is not defined

var result = hello('홍길동');
console.log(result);

// 함수는 매개변수의 개수와 인수의 개수가 일치하는지 체크하지 않는다.
// 인수가 부족해서 할당되지 않은 매개변수의 값은 undefined이다.
result = hello();
console.log(result);

// 매개변수보다 인수가 많은 경우 초과된 인수는 무시된다.
result = hello('유관순', '신사임당');
console.log(result);

// 인수를 전달하지 않거나 undefined를 전달하면 매개변수 기본 값이 동작하도록 설정할 수 있다. -ES6 추가 문법
function hi(name = '아무개') {
    return `${name} 안녕!`
}

result = hi('홍길동');
console.log(result);
result = hi();
console.log(result);


