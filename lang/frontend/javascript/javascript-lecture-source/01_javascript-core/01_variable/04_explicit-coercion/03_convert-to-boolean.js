// 논리 타입으로 명시적 변환

// 1. Boolean 생성자 함수를 new 연산자 없이 호출
console.log(Boolean('JavaScript'));
console.log(Boolean(''));
console.log(Boolean(1));
console.log(Boolean(0));
console.log(Boolean(NaN));
console.log(Boolean(Infinity));
console.log(Boolean(null));
console.log(Boolean(undefined));
console.log(Boolean({}));
console.log(Boolean([]));

// 2. ! 부정 논리 연산자를 두 번 사용하는 방법
console.log(!!'JavaScript');
console.log(!!'');
console.log(!!1);
console.log(!!0);
console.log(!!NaN);
console.log(!!Infinity);
console.log(!!null);
console.log(!!undefined);
console.log(!!{});
console.log(!![]);