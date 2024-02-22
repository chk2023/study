// in 연산자 : 프로퍼티 존재 여부 확인
var student = {
    name : '유관순',
    age : 16,
    test : undefined
};

console.log(student.name === undefined);    //false -해당 프로퍼티가 객체 안에 존재
console.log(student.height === undefined);  //true -해당 프로퍼티가 객체 안에 존재하지 않음
console.log(student.test === undefined);  //true -프로퍼티는 존재하지만 값이 undefined인 상황

console.log("name" in student);
console.log("height" in student);
console.log("test" in student);












