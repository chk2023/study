// 1. 특정 단어로 시작하는지 검사
// http:// 또는 https://로 시작하는지 검사
const url = 'https://www.google.com';
// const url = 'https://www.google.com';
// const url = 'www.google.com';

console.log(/^https?:\/\//.test(url));

// 2. 특정 단어로 끝나는지 검사
// 파일 확장자가 js인지 검사
const fileName = 'test.js';

console.log(/js$/.test(fileName));

// 3. 숫자로만 이러우진 문자열인지 검사
const target = '12345';

// 처음과 끝이 숫자이고 최소 한 번 이상 반복되는 문자열과 매칭
console.log(/^\d+$/.test(target)); //처음부터 끝까지 숫자가 한 개만 반복되는 패턴

// 4. 아이디로 사용 가능한지 검사
// 알파벳 대소문자 또는 숫자로 시작하고 끝나면 6~12 자리인지 검사
const id = 'hello123';

console.log(/^[A-Za-z\d]{6,12}$/.test(id));

// 5. 핸드폰 번호 형식에 맞는지 검사
const phone = '010-1234-5678';

console.log(/^\d{3}-\d{3,4}-\d{4}$/.test(phone));

// 6. 특수문자 포함 여부
const target2 = 'hello#world';

console.log(/[^A-Za-z\d가-힣ㄱ-ㅎㅏ-ㅣ]/.test(target2));


















