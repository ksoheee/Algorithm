# [Silver V] 좌표 정렬하기 - 11650 

[문제 링크](https://www.acmicpc.net/problem/11650) 

### 성능 요약

메모리: 186088 KB, 시간: 1780 ms

### 분류

정렬

### 제출 일자

2025년 7월 2일 08:52:29

### 문제 설명

<p>2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 x<sub>i</sub>와 y<sub>i</sub>가 주어진다. (-100,000 ≤ x<sub>i</sub>, y<sub>i</sub> ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.</p>

### 출력 

 <p>첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.</p>
 
### 풀이 1 Add commentMore actions
<p>배열의 정렬은 Arrays.sort()를 사용하여 정렬할 수 있다. </p>
<p>Arrays.sort()는 메소드 인자를 두개 받을 수 있는데, 첫 번째는 제너릭 타입의 객체 배열(T[]), 어떤 클래스든 자료형이든 오브젝트이든 타입 상관없이 넣을 수 있다. 만약 int[]라면 T는 int가 되고, boolean이라면 T는 boolean, Car라는 클래스 객체를 배열로 만들어 넣는 다면 T는 Car클래가 된다.</p>
<br />
<p>Comparator<? super T>는 <? super T>는 상속관계에 있는 타입만 자료형으로 받겠다는 이야기다. T는 자식클래스가 되고 T의 상속관계에 있는 타입만 허용하겠다는 의미이다. 이 문제에서는 상속관계에 대한 데이터를 정렬을 하지 않기 때문에 <T>라고 보면 된다. 이 문제에서는 T를 int[]로 받을 것이다. </T> </p>

<p>arr[n][2]인 배열이 있다면 arr[i][0]과 arr[i+1][0]을 비교하고 두 값이 같다면 arr[i][1],arr[i+1][1]을 정렬하면 된다.</p>

### 풀이 2 - 람다식 사용
<p>Comparator는 람다식을 사용할 수 있다 </p>
<p>람다식 예시</p>
<pre>
 public int sum(a,b){
    return a+b;
 }
 //람다식 사용
 (int a, int b) -> {return a+b;}
</pre>
<p>람다식은 메소드를 구현하지 않고 바로 함수를 바로 쓸 수 있다. compare를 람다식으로 변경 할 수 있다.
람다식 인자가 타입이 int[]인 이유는, 코드에서 호출한 멤서드 시그니처가 바로 그 타입을 요구하기 때문이다.
구체적으로 살펴보면</p>
<p>1. Arrays.sort의 메서드 시그니처는 <code>public static <T> void sort(T[] a, Comparator<? super T>c)</code></br> T[]a: 는 요소 타입이 T인 배열을 받겠다. Comparator<?super T>: T또는 T의 부모 타입을 비교할 수 있는 비교자를 받겠다. </p>
<p>2.arr의 타입  arr자체의 타입은 "int[]들의 배열" 즉 int[][]</br> 이 배열을 T[]a에 넘기려면 T[]이 int[][]여야 한다. -> 따라서 T가 곧 int[]로 추론된다.</p>
<p>3. Comparator<? super T>의 구체화 </br> T가 int[]이므로 <code>Comparator<? super int[]></code> 람다로는 compare<int[] a1, int[]a2>를 구현하게 된다. </p>
<P>4.람다식의 타입 맥락 </br> <code>Arrays.sort(arr, (a1, a2) -> { … });</code> 이때 컴파일러는 첫번째 인자로 int[][]를 받았으니 T=int[], 두번째 인자로는 Comparator<int[]>가 와야 한다. 따라서 람다 (a1,a2)의 매개변수 a1,a2는 자동으로 int타입이 되는 것이다. </P>
