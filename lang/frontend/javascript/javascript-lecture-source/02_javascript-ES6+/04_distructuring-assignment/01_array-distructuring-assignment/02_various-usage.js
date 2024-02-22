// 다양한 사용법

// 객체 프로퍼티에 사용
let user = {};
[user.firstName, user.lastName] = "Gwansoon Yu".split(" ");
console.log(user);

// 변수 교환 용도로 사용
let student = "학생";
let teacher = "선생님";
[student, teacher] = [teacher, student];
console.log(`student : ${student}, teacher : ${teacher}`);

// rest parameter ... 로 나머지 요소를 한 번에 가져올 수도 있다.
let [sign1, sign2, ...rest] = ['양자리', '황소자리', '쌍둥이자리', '게자리'];
console.log(sign1);
console.log(sign2);
console.log(rest);

// 기본 값을 설정하고 사용할 수 있다.
let [firstName4 = "아무개", lastName4 = "김"] = [];
console.log(firstName4);
console.log(lastName4);















