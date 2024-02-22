// 재귀 함수
// 함수가 자기 자신을 호출하는 것을 재귀 호출이라고 한다.
// 재귀 함수는 반복되는 처리를 위해 사용한다.

// n! = 1 * 2 * 3 ... * (n-1) * n
function factorial(n) {
    //n이 1이하일 때 1을 반환함
    if (n <= 1) return 1;
    // 재귀 호출
    return n * factorial(n - 1);
}

console.log(factorial(1));
console.log(factorial(2));
console.log(factorial(3));
console.log(factorial(4));
console.log(factorial(5));










