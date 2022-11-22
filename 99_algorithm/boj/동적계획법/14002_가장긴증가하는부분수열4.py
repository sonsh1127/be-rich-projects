# https://www.acmicpc.net/problem/14002
import sys
input = sys.stdin.readline
N = int(input())
data = list(map(int,input().split()))
prev = [0] * N
length = [0 for _ in range(N)]
length[0] = 1
for i in range(N):
    length[i] = 1
    prev[i] = i
    for j in range(i):
        if data[i] > data[j] and length[i] < (length[j]+1):
            length[i] = length[j]+1
            prev[i] = j

max_idx = 0
for i in range(N):
    if length[max_idx] < length[i]:
        max_idx = i

result = []
while True:
    # print(data[max_idx],end=' ')
    result.append(data[max_idx])
    if prev[max_idx] == max_idx:
        break
    max_idx = prev[max_idx]
print(length[max_idx])
print(*result[::-1])
