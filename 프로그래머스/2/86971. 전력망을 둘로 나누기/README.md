# [level 2] 전력망을 둘로 나누기 - 86971 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/86971) 

### 성능 요약

메모리: 93.4 MB, 시간: 2.50 ms

### 구분

코딩테스트 연습 > 완전탐색

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 08월 31일 16:25:53

### 문제 설명

<p>n개의 송전탑이 전선을 통해 하나의 <a href="https://en.wikipedia.org/wiki/Tree_(data_structure)" target="_blank" rel="noopener">트리</a> 형태로 연결되어 있습니다. 당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다. 이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.</p>

<p>송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다. 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때, 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>n은 2 이상 100 이하인 자연수입니다.</li>
<li>wires는 길이가 <code>n-1</code>인 정수형 2차원 배열입니다.

<ul>
<li>wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며, 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.</li>
<li>1 ≤ v1 &lt; v2 ≤ n 입니다.</li>
<li>전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>wires</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>9</td>
<td><code>[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]</code></td>
<td>3</td>
</tr>
<tr>
<td>4</td>
<td><code>[[1,2],[2,3],[3,4]]</code></td>
<td>0</td>
</tr>
<tr>
<td>7</td>
<td><code>[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]</code></td>
<td>1</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1</p>

<ul>
<li>다음 그림은 주어진 입력을 해결하는 방법 중 하나를 나타낸 것입니다.</li>
<li><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/5b8a0dcd-cba0-47ca-b5e3-d3bafc81f9d6/ex1.png" title="" alt="ex1.png"></li>
<li>4번과 7번을 연결하는 전선을 끊으면 두 전력망은 각 6개와 3개의 송전탑을 가지며, 이보다 더 비슷한 개수로 전력망을 나눌 수 없습니다.</li>
<li>또 다른 방법으로는 3번과 4번을 연결하는 전선을 끊어도 최선의 정답을 도출할 수 있습니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li>다음 그림은 주어진 입력을 해결하는 방법을 나타낸 것입니다.</li>
<li><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/b28865e1-a18e-429d-ae7a-14e77e801539/ex2.png" title="" alt="ex2.png"></li>
<li>2번과 3번을 연결하는 전선을 끊으면 두 전력망이 모두 2개의 송전탑을 가지게 되며, 이 방법이 최선입니다.</li>
</ul>

<p>입출력 예 #3</p>

<ul>
<li>다음 그림은 주어진 입력을 해결하는 방법을 나타낸 것입니다.</li>
<li><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/0a7f21af-1e07-4015-8ad3-c06155c613b3/ex3.png" title="" alt="ex3.png"></li>
<li>3번과 7번을 연결하는 전선을 끊으면 두 전력망이 각각 4개와 3개의 송전탑을 가지게 되며, 이 방법이 최선입니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges

### 풀이
<pre>인접 리스트를 이용해서 그래프를 표현한다.
Wires 배열을 순회하면서 간선을 하나씩 끊고 dfs로 탐색한다.
이때 모든 간선을 하나씩 끊어서 확인해야 하므로 매번 새로운 방문 배열을 만들어 줘야한다.
dfs에서는 현재 인자로 넘어온 간선의 값에 들어있는 리스트들(방문할 수 있는 리스트들)을 방문하며 간선의 수를 센다. 이때 끊어진 간선의 확인은 dfs로 넘어온 인자값이 끊을 두 노드의 값이므로 비교하여 확인한다.


전선 하나를 끊으면 두개의 부분 트리로 나뉘고, 나뉜 그룹 중 한 쪽 그룹의 크기를 재고, 나머지 그룹은 n-한쪽 그룹 크기로 구하면 두 구룹의 크기 차이를 구할 수 있다. (n= 한쪽그룹 + 나머지 그룹이기 때문)

dfs로 탐색이 끝났다면 n - 한쪽 그룹을 계산하고, |나머지그룹 - 한쪽그룹|의 값이 작은 값을 저장한다. </pre>

<pre>인접 행렬을 이용해서 그래프를 표현한다.
선을 하나씩 끊어보면서 bfs를 이용하여 탐색한다.
방문을 체크할 배열을 만들어주고, bfs 인자 값으로 받아온 첫번째 값을 큐에 대입한다. 
큐가 비어있지 않을 때 까지 탐색하는데, 큐의 맨 앞 갚을 빼내고 방문표시를 한다. 그리고 빼낸 값과 연결되어 있는 노드 중에 방문한 적이 없는 노드를 큐에 전부 넣는다. 
나눠진 전력망 그룹은 cnt와 n-cnt이므로 두 전력망이 가지고 있는 송전탑의 개수는 |n-cnt-cnt|로 |n-*2cnt|이고 이 값을 return 한다.
return한 값과 그 전의 저장된 값중 작은 값을 최종 값으로 return한다.</pre>
