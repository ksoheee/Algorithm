# [level 2] 가장 큰 정사각형 찾기 - 12905 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12905) 

### 성능 요약

메모리: 90.7 MB, 시간: 16.12 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 59.6<br/>효율성: 40.4<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 08월 28일 19:35:03

### 문제 설명

<p>1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)</p>

<p>예를 들어</p>
<table class="table">
        <thead><tr>
<th style="text-align: center">1</th>
<th style="text-align: center">2</th>
<th style="text-align: center">3</th>
<th style="text-align: center">4</th>
</tr>
</thead>
        <tbody><tr>
<td style="text-align: center">0</td>
<td style="text-align: center">1</td>
<td style="text-align: center">1</td>
<td style="text-align: center">1</td>
</tr>
<tr>
<td style="text-align: center">1</td>
<td style="text-align: center">1</td>
<td style="text-align: center">1</td>
<td style="text-align: center">1</td>
</tr>
<tr>
<td style="text-align: center">1</td>
<td style="text-align: center">1</td>
<td style="text-align: center">1</td>
<td style="text-align: center">1</td>
</tr>
<tr>
<td style="text-align: center">0</td>
<td style="text-align: center">0</td>
<td style="text-align: center">1</td>
<td style="text-align: center">0</td>
</tr>
</tbody>
      </table>
<p>가 있다면 가장 큰 정사각형은</p>
<table class="table">
        <thead><tr>
<th style="text-align: center">1</th>
<th style="text-align: center">2</th>
<th style="text-align: center">3</th>
<th style="text-align: center">4</th>
</tr>
</thead>
        <tbody><tr>
<td style="text-align: center">0</td>
<td style="text-align: center"><code>1</code></td>
<td style="text-align: center"><code>1</code></td>
<td style="text-align: center"><code>1</code></td>
</tr>
<tr>
<td style="text-align: center">1</td>
<td style="text-align: center"><code>1</code></td>
<td style="text-align: center"><code>1</code></td>
<td style="text-align: center"><code>1</code></td>
</tr>
<tr>
<td style="text-align: center">1</td>
<td style="text-align: center"><code>1</code></td>
<td style="text-align: center"><code>1</code></td>
<td style="text-align: center"><code>1</code></td>
</tr>
<tr>
<td style="text-align: center">0</td>
<td style="text-align: center">0</td>
<td style="text-align: center">1</td>
<td style="text-align: center">0</td>
</tr>
</tbody>
      </table>
<p>가 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.</p>

<h5>제한사항</h5>

<ul>
<li>표(board)는 2차원 배열로 주어집니다.</li>
<li>표(board)의 행(row)의 크기 : 1,000 이하의 자연수</li>
<li>표(board)의 열(column)의 크기 : 1,000 이하의 자연수</li>
<li>표(board)의 값은 1또는 0으로만 이루어져 있습니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>board</th>
<th>answer</th>
</tr>
</thead>
        <tbody><tr>
<td>[[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]</td>
<td>9</td>
</tr>
<tr>
<td>[[0,0,1,1],[1,1,1,1]]</td>
<td>4</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>입출력 예 #1<br>
위의 예시와 같습니다.</p>

<p>입출력 예 #2</p>

<p>| 0 | 0 | <code>1</code> | <code>1</code> |<br>
| 1 | 1 | <code>1</code> | <code>1</code> | <br>
로 가장 큰 정사각형의 넓이는 4가 되므로 4를 return합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges


### 풀이 
<pre>
2*2크기의 정사각형을 기준으로 검사하는데, 
현재 값이 1인경우 좌,상단,좌측 상단을 체크한다. 

만약 사각형이 아래와 같다면 
0 1 1 1
1 1 1 1
1 1 1 1
(1,1)부터 시작해서 좌측(1), 상단(1), 좌측 상단(0)값을 구하고 
이 중의 최소 값 +1을 해서 현재 자신의 값으로 바꿔준다. => 0+1 = 1
그 이유는 최소값이 0 이기때문에 정사각형을 만들 수 없으므로 현재값을 1로 만들어 주고, 
만약 좌측, 상단, 좌측 상단의 값이 모두 1이라면 최소값 +1 = 2 로 정사각형을 만들 수 있다는 말이다. 
이렇게 체크하다보면 (1,3) 값은 3이 되게 되고, 정사각형의 크기를 구하는게 문제였으니 제곱을 하여 주면 된다. 
</pre>
