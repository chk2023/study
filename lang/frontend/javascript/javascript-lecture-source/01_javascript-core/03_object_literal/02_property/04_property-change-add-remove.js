// 프로퍼티 변경, 추가, 삭제
var dog = {
    name : '뽀삐'
};

// 이미 존재하는 프로퍼티에 값을 할당하면 프로퍼티 값이 갱신 된다.
dog.name = '두부';
console.log(dog.name);

// 프로퍼티 동적 추가
// 존재하지 않는 프로퍼티에 값을 할당하면 프로퍼티가 동적으로 생성 되어 추가 되고 값이 할당 된다.
dog.age = 3;
console.log(dog.age);

//프로퍼티 삭제
// delete 연산자는 객체의 프로퍼티를 삭제하며, 만약 존재하지 않는 프로퍼티를 삭제하면 에러 없이 무시 된다.
console.log(dog);
delete dog.age;
console.log(dog);

delete dog.something;





