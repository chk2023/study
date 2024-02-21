// 배열 고차 함수
// * 고차 함수 : 함수를 인수로 전달 받거나 함수를 반환하는 함수

// Array.prototype.sort : 배열을 정렬 기준으로 정렬
let numbers = [];

for (let i = 0; i < 10; i++) {
    numbers[i] = Math.floor(Math.random() * 100) + 1;
}

console.log(`정렬 전 numbers : ${numbers}`);

// 문자열 오름차순 정렬이 기본이며 정렬 후 정렬 순서를 유지한다.
// 다른 정렬 기준을 사용하려면 compare 함수를 인수로 전달해야 한다.
numbers.sort();

console.log(`정렬 후 numbers : ${numbers}`);

// 숫자 오름차순 정렬에 사용 될 function
function compare(a, b) {
    if (a > b) return 1; // 양수 반환 -> 순서 변경
    if (a == b) return 0; // 0반환 -> 같은 값
    if (a < b) return -1; // 음수반환 -> 순서 변경하지 않음
}

numbers.sort(compare);
console.log(`매개변수로 compare 함수 전달하여 정렬 후 numbers : ${numbers}`);

// 함수 리터럴을 전달하여 숫자 내림차순 정렬
numbers.sort(function (a, b) { return b - a });
numbers.sort((a, b) => b - a);
console.log(`매개변수로 함수 리터럴 전달하여 정렬 후 numbers : ${numbers}`);

// Array.prototype.forEach : for를 대체할 수 있는 고차함수
/*
* 배열.forEach(function(item, index, array) {
*   // 배열 요소 각각에 실행할 기능 작성
* });
* */

numbers = [1, 2, 3, 4, 5];

numbers.forEach(function (item, index, array){
    console.log(`item : ${item}`);
    console.log(`index : ${index}`);
    console.log(`array : ${array}`);
});

// 각 요소별로 * 10 한 값을 콘솔에 출력
numbers.forEach(item => console.log(item * 10));

// Array.prototype.map : 배열 요소 전체를 대상으로 콜백 함수 호출 후 반환 값들로 구성 된 새로운 배열 반환
/*
* 배열.forEach(function(item, index, array) {
*   // 배열 요소 각각에 실행할 기능 작성
*   return 배열 요소 각각에 반환할 값
* });
* */

const types = [true, 1, 'text'].map(item => typeof item);
console.log(types);

const lengths = ['apple', 'banana', 'cat', 'dog', 'egg'].map(item => item.length);
console.log(lengths);

// Array.prototype.filter : 배열 요소 전체를 대상으로 콜백 함수 호출 후 반환 값이 true인 요소로만
// 구성 된 새로운 배열 반환
const odds = numbers.filter(item => item % 2);
console.log(odds);

// Array.prototype.reduce : 배열을 순회하며 각 요소에 대하여 이전의 콜백 함수 실행 반환 값을
// 전달하여 콜백 함수를 실행하고 그 결과를 반환
numbers.reduce(function (previousValue, currentValue, currentIndex, array){
   console.log(`previousValue : ${previousValue}`);  //이전 콜백의 반환 값 
   console.log(`currentValue : ${currentValue}`);   //배열 요소의 값
   console.log(`currentIndex : ${currentIndex}`);   //배열 인덱스
   console.log(`array : ${array}`);                 //메소드를 호출한 배열
    return currentValue;
});

// 합산
const sum = numbers.reduce((previousValue, currentValue) => previousValue + currentValue);
console.log(`sum : ${sum}`);

// 최대값 취득
const max = [5, 1, 10, 8, 4].reduce((pre, cur)=> pre > cur ? pre : cur);
console.log(`max : ${max}`);

// Array.prototype.some : 배열 내 일부 요소가 콜백 함수의 테스트를 통과하는지 확인하여
// 그 결과를 boolean으로 반환

// 배열 내 요소 중 10보다 큰 값이 1개 이상 존재하는지 확인
let result = [1, 5, 3, 2, 4].some(item => item > 10);
console.log(`result : ${result}`);

// 배열 내 요소 중 3보다 큰 값이 1개 이상 존재하는지 확인
result = [1, 5, 3, 2, 4].some(item => item > 3);
console.log(`result : ${result}`);

// Array.prototype.every : 배열 내 모든 요소가 콜백 함수의 테스트를 통과하는지 확인하여
// 그 결과를 boolean으로 반환

// 배열 내 요소 중 모든 요소가 3보다 큰지 확인
result = [1, 5, 3, 2, 4].every(item => item > 3);
console.log(`result : ${result}`);

// 배열 내 요소 중 모든 요소가 0보다 큰지 확인
result = [1, 5, 3, 2, 4].every(item => item > 0);
console.log(`result : ${result}`);

// Array.prototype.find : 배열을 순회하며 각 요소에 대하여 인자로 주어진 콜백 함수를 실행하여
// 그 결과가 참인 첫 번째 요소를 반환. 참인 요소가 존재하지 않는다면 undefined 반환.
// Array.prototype.findIndex : 배열을 순회하며 각 요소에 대하여 인자로 주어진 콜백 함수를 실행하여
// 그 결과가 참인 첫 번째 요소의 인덱스를 반환. 참인 요소가 존재하지 않는다면 -1 반환.
const students = [
    {name: '유관순', score : 90},
    {name: '홍길동', score : 80},
    {name: '장보고', score : 70},
];

// 학생 배열에서 이름이 홍길동인 학생을 찾는다면?
result = students.find(item => item.name === '홍길동');
console.log(result);
result = students.findIndex(item => item.name === '홍길동');
console.log(result);

// 만약 80점 이상인 학생들을 찾고 싶다면?
// find, findIndex는 일치하는 요소를 찾으면 더 이상 탐색하지 않고 하나의 요소, 인덱스만 반환한다.
// filter는 콜백 함수의 실행 결과가 true인 배열 요소의 값만을 추출한 새로운 배열을 반환한다.
result = students.filter(item => item.score >= 80);
console.log(result);













