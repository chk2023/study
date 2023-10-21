### 컬렉션 프레임워크와 핵심 인터페이스

컬렉션은 여러 객체(데이터)를 모아 놓은 것.
프레임워크는 프로그래밍을 위해 제공되는 틀.
컬렉션 프레임워크는 컬렉션을 다루기 위한 표준화된 프로그래밍 방식.
컬렉션 프레임워크는 컬렉션을 쉽고 편리하게 다룰 수 있는 다양한 클래스를 제공한다.
컬렉션(객체)를 다룬다는 것은 객체를 저장, 삭제, 검색, 정렬 등의 기능을 한다는 것.
java.util 패키지에 포함되어 있으며 JDK 1.2부터 제공되고 있다. 그 전에도 있었지만 표준화가 되어 있지 않았다. 
그렇게 제공되는 클래스는 컬렉션 클래스라고 하며 다수의 데이터를 저장할 수 있다. (Vector, ArrayList, HashSet)

![[Pasted image 20231021090224.png]]
프로그래밍을 할 때 다루는 데이터를 보니 세 가지로 구분할 수 있었다. 그것을 인터페이스로 정해둔 것이 List, Set, Map.
List의 특징 중 순서는 저장순서를 의미한다. ArrayList, LinkedList, Stack, Vector.
Set은 집합이며 List와는 정반대의 특징을 가진다. HashSet, TreeSet.
Map은 쌍으로 이루어진 데이터의 집합이 순서가 중요하지 않다. HashMap, TreeMap, Hashtable, Properties. 인터페이스 이름이 들어가지 않은 것은 예전 표준화 되기 이전에 사용하던 인터페이스의 이름. 
키는 중복 허용을 하지 않고, 값은 중복을 허용한다.
List와 Set의 공통 부분을 뽑아서 Collection이라는 인터페이스를 만들었다.

### Collection, List, Set, Map
![[Pasted image 20231021093615.png]]

![[Pasted image 20231021093802.png]]
List를 구현한 클래스는 Vector, ArrayList, LinkedList가 있다.
ArrayList는 Vector를 개선한 것. ArrrayList, LinkedList가 핵심이다. 

![[Pasted image 20231021093914.png]]
여기에 Collection 인터페이스의 메서드는 제외했다.

![[Pasted image 20231021094045.png]]
Set 인터페이스의 핵심은 HashSet과 TreeSet이다.
여기에 나오는 Set 인터페이스의 메서드는 Collection 인터페이스와 동일.
집합과 관련된 메서드가 있으며 결과값 타입은 boolean이다. 

![[Pasted image 20231021095110.png]]
Map의 핵심은 HashMap과 TreeMap이다. 
Hashtable을 개선한 것이 HashMap이다.
Hashtable은 동기화가 되지만 HashMap은 동기화가 되지 않는다. 
Map은 원래 순서가 없지만 LinkedHashMap은 순서가 생긴다.

![[Pasted image 20231021095218.png]]
Set entrySet()은 키와 값으로 이루어진 객체를 Set으로 반환.
Collection values()는 Collection 타입으로 반환. 

### ArrayList

![[Pasted image 20231021110612.png]]
ArrayList는 데이터의 저장공간으로 배열을 사용한다. 
Vector를 보면 Object 배열이 있다. 이는 다형성이다.
조상 타입의 참조변수로 자손 타입의 객체를 대입하는 것.
이 객체 역시 모든 종류의 객체를 저장할 수 있다.
Vector뿐만 아니라 ArrayList도 마찬가지.

![[Pasted image 20231021113842.png]]
ArrayList의 메서드를 알아본다.

생성자
ArrayList()는 기본 생성자다. 
ArrayList(Collection c)  //매개변수로 Collection을 주면 Collection의 내용을 저장하는 컬렉션 생성
ArrayList(int initialCapacity)  //배열의 길이를 정해주는 것

추가
boolean add(Object o)  //ArrayList에 객체를 추가한다. 성공 시 ture, 실패 시 false 반환.
void add(int index, Object element)  //index(저장위치)를 지정할 수 있다. 위 add 메서드는 마지막에 추가한다면 이 add 메서드는 어디에 저장할 지 정할 수 있다.
boolean addAll(Collection c)  //컬렉션을 주면 그 값을 그대로 저장. 
boolean addAll(int index, Collection c)  //위와 같지만 위치를 정한다.

삭제(추가와 같지만 기능은 삭제)
boolean(remove Object o)
Object remove(int index)
boolean removeAll(Collection c)
void clear()

검색
int indexOf(Object o)  //객체의 위치(인덱스)를 찾고 못 찾으면 -1 반환. 좌에서 우로 검색.
int lastIndexOf(Object o)  //위와 같지만 우측에서 좌측으로 검색.
boolean contains(Object o)  //객체가 존재하는지. boolean.
Object get(int index)  //특정 위치에 있는 객체 변환. 객체 읽기.
Object set(int index, Object element)  //특정 위치에 있는 객체 변경.

List subList(int fromIndex, in toIndex)  //from~to 사이에 있는 객체를 뽑아서 새로운 List 생성
Object[] toArray()  //ArrayList의 객체 배열을 반환
boolean isEmpty()  //비어있는지 확인
void trimToSize()  //빈 공간 제거
int size()  //ArrayList에 저장된 객체의 개수

예제
ArrayList에는 객체만 저장 가능하다. 객체의 주소가 배열로 저장된다.
list1.add(5); 이런식으로 기본형이 매개변수로 올 수 있는 이유는 오토박싱에 의해 참조형으로 자동변환되기 때문이다. 

```
ArrayList list2 = new ArrayList(list1.subList(1,4));

//풀어쓰면 다음과 같다.
List sub = list1.subList(1,4);
ArrayList list2 = new ArrayList(sub);
```
위는 1~3까지의 인덱스를 뽑아 리스트를 만든다. 4는 포함이 되지 않는다. 
subList로 만들어진 list는 읽기 전용이다. 읽기 전용이 때문에 새로운 ArrayList 객체에 만들어 주는 것이다. ArrayList(Collection c) 생성자를 사용 한 것.

정렬할 때에는 Collections.sort();를 사용. Collection은 인터페이스, Collections는 유틸 클래스. 






### LinkedList

### Stack과 Queue

### StackQueue 활용

### Iterator, Enumeration, Map과 Iterator

### Arrays

### Comparator와 Comparable

### HashSet(1)

### HashSet(2)

### TreeSet(1)

### TreeSet(2)

### HashMap(1)

### HasMap(2)

### Collections 클래스, 컬렉션 클래스 요약
