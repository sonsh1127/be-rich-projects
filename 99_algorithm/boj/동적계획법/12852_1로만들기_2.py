#https://www.acmicpc.net/problem/12852

# 1로 만들기 위한 최소 연산 횟수
# 1. 3으로 나누어 떨어지면 3으로 나누기
# 2. 2로 나누어 떨어지면 2로 나누기
# 3. 1을 뺀다
import sys
input = sys.stdin.readline

X = int(input())
prevs =[0]*1000001
dp = [0] * 1000001
dp[1] = 0
dp[2] = 1
prevs[2] = 1
dp[3] = 1
prevs[3] = 1
# 4 => ? /2 /2 , -1, /3
# 5 => -1, /2 /2, -1 -1 /3
# 6 => /3 /2 , /2 /3
# 7 => -1 /2 /3  -1 /3 /2
# 8 => /2 /2 /2 , /2 -1 /3
# 9 => /3 /3
# 10 => /2 -1 /2 /2 , -1 /3 /3
...
# 현재 시점에서 할 수 있는 경우의 수에서 이전 수가 제일 작은거 고르믄 댑니다.

for i in range(4,1000001):
    min_case = dp[i-1] # 일단 -1 한 케이스를 제일 작은걸로 잡음
    prev = i - 1
    if not i % 2 and dp[i//2] < min_case:
        min_case = dp[i//2]
        prev = i//2
    if not i % 3 and dp[i//3] < min_case:
        min_case = dp[i//3]
        prev = i//3
    dp[i] = min_case + 1
    prevs[i] = prev

print(dp[X])
while X > 1:
    print(X, end=' ')
    X = prevs[X]
print(1)

