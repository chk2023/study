// Symbol은 ES6에서 추가된 7번째 타입으로 다른 값과 중복 되지 않는 유일무이한 값
// 이름 충돌 위험이 없는 객체의 유일한 프로퍼티 키 값을 만들기 위해 사용
// 심벌 외의 원시 값은 리터럴을 통해 생성하며 심벌은 Symbol 함수를 통해 호출해서 생성

//심벌 생성
var key = Symbol('key');
console.log(typeof key);

// 객체 타입
// 자바스크립트의 데이터 타입은 크게 원시 타입, 객체 타입으로 분류한다.
// number, string, boolean, undefined, null, symbol 6가지 데이터 타입 외의 값은 모두 "객체" 타입이다.
// (객체, 함수, 배열, ... 등에 대해서는 추후 자세히 다룬다.)

//객체 생성
var obj = {};
obj[key] = 'value';
console.log(obj[key]);