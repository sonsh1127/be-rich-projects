# https://www.acmicpc.net/problem/1753
import sys
from heapq import heappush, heappop
input = sys.stdin.readline
# 그냥 input()은 시간 터짐
V, E = map(int,(input().split()))
K = int(input())
INF = 0xffffffff
g = [[] for _ in range(V+1)]
distance = [INF]*(V+1)
visited = [0] * (V+1)
for i in range(E):
    u, v, w = map(int,input().split())
    g[u].append((w, v))

distance[K] = 0
weight = []
# 그냥 다익스트라는 시간 터짐...
heappush(weight,(0,K))
while weight:
    w, v = heappop(weight)
    if distance[v] < w:
        continue
    # visited[v] = 1
    for adj in g[v]:
        tmp = w + adj[0]
        if tmp < distance[adj[1]]:
            distance[adj[1]] = tmp
            heappush(weight,(tmp,adj[1]))

for i in range(1,V+1):
    print(distance[i] if distance[i] < INF else 'INF' )
# 5 6
# 1
# 5 1 1
# 1 2 3
# 1 3 2
# 2 3 4
# 2 4 5
# 3 4 6