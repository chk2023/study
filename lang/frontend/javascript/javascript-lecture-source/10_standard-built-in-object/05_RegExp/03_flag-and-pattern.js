/* flag의 종류
* i(ignore case) : 대소문자 구별 않고 패턴 검색
* g(global) : 대상 문자열 내에서 패턴과 일치하는 모든 문자열을 전역 검색
* flag는 옵션이므로 선택적으로 사용하며, 순서와 상관 없이 하나 이상의 플래그를 동시 설정 가능
* */

 let target = 'Java JavaScript';

 console.log(target.match(/VA/));
 console.log(target.match(/VA/i));
 console.log(target.match(/VA/ig));

 console.log('------------------------------')

/* pattern
* 패턴은 특별한 의미를 가지는 메타문자 또는 기호로 표현할 수 있다.
* */
     
// . : 임의의 문자열
 target = 'abcdefg';
 console.log(target.match(/../g));  // 임의의 2자리 문자열 전역 검색

console.log('------------------------------')

// {m,n} : 최소 m번, 최대 n번 반복되는 문자열 (반복 검색)
target = 'a aa aaa b bb bbb ab aab abb';
console.log(target.match(/a{2,3}/g));   // a가 최소 2번 ~ 최대 3번 반복되는 패턴을 글로벌하게 찾는다.
console.log(target.match(/b{2}/g));     // b 두 번 반복
console.log(target.match(/b{3,}/g));     // b 세 번 이상 반복

















