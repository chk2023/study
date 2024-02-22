// 배열 생성
// 1. 배열 리터럴을 통한 생성
const arr = ['바나나', '복숭아', '키위'];
console.log(arr);

// 2. 배열 생성자 함수
const arr2 = new Array();
console.log(arr2);

// 전달된 인수가 1개이고 숫자인 경우 length 프로퍼티 값이 인수인 배열을 생성
const arr3 = new Array(10);
console.log(arr3);

// 전달된 인수가 2개 이상이거나 숫자가 아닌 경우 인수를 요소로 갖는 배열을 생성
const arr4 = new Array(1, 2, 3);
console.log(arr4);

// 3. Array.of 메서드
// 전달된 인수를 요소로 갖는 배열 생성
console.log(Array.of(10));
console.log(Array.of(1, 2, 3));
console.log(Array.of("hello", "js"));

// 배열의 요소는 자신의 위치를 나타내는 인덱스를 가지며 배열의 요소에 접근할 때 사용된다.
console.log(arr[0]);
console.log(arr[1]);
console.log(arr[2]);

// 배열은 요소의 개수, 즉 배열의 길이를 나타내는 length 프로퍼티를 갖는다.
console.log(arr.length);

// for문을 통한 요소 순회
for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
}

// 배열은 별도의 타입이 존재하지 않으며 객체 타입이다.
console.log(typeof arr);










