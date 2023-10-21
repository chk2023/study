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

ArrayList의 메서드를 알아본다.
ArrayList()는 기본 생성자다. 
ArrayList(Collection c) //매개변수로 Collection을 주면 Collection을 저장하는 
ArrayList(int initialCapacity)


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
