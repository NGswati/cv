# import networkx as nx
# import BFS
# import DFS
# graph = {'(FCGW),()': ['(FC),(GW)', '(FG),(CW)', '(FW),(GC)', '(F),(CGW)'],
#          '(FC),(GW)': ['(FCGW),()'],
#          '(FW),(GC)': ['(FCGW),()'], '(F),(CGW)': ['(FCGW),()'],
#          '(FG),(CW)': ['(FCGW),()', '(G),(FCW)'],
#          '(G),(FCW)': ['(FG),(CW)', '(FGW),(C)', '(FCG),(W)'],
#          '(FGW),(C)': ['(G),(FCW)', '(W),(FGC)', '(GW),(FC)'],
#          '(GW),(FC)': ['(FGW),(C)'],
#          '(FCG),(W)': ['(C),(FGW)', '(G),(FCW)', '(CG),(FW)'],
#          '(CG),(FW)': ['(FCG),(W)'],
#          '(W),(FGC)': ['(FGW),(C)', '(FCW),(G)'],
#          '(FCW),(G)': ['(W),(FGC)', '(CW),(FG)', '(C),(FGW)'],
#          '(CW),(FG)': ['(FCW),(G)', '(),(FGCW)'],
#          '(),(FGCW)': ['(CW),(FG)'],
#          '(C),(FGW)': ['(FCG),(W)', '(FCW),(G)']}

# path = []
# r = BFS.BIDIR(graph, '(FCGW),()', '(),(FGCW)', path)
# print(r)


import networkx as nx
import BFS
import DFS
graph = {'(H1H2H3W1W2W3),()': ['(H2H3W2W3),(H1W1)', '(H1H2W2W3),(H3W1)'],
         '(H2H3W2W3),(H1W1)': ['(H1H2H3W1W2W3),()', '(H1H2H3W2W3),(W1)'],
         '(H1H2W2W3),(H3W1)': ['(H1H2H3W1W2W3),()'],
         '(H1H2H3W2W3),(W1)': ['(H1H2H3),(W1W2W3)'],
         '(H1H2H3),(W1W2W3)': ['(H1H2H3W2W3),(W1)', '(H1H2H3W1),(W2W3)'],
         '(H1H2H3W1),(W2W3)': ['(H1H2H3),(W1W2W3)', '(H1W1),(H2H3W2W3)'],
         '(H1W1),(H2H3W2W3)': ['(H1H2H3W1),(W2W3)', '(H1H2W1W2),(H3W3)'],
         '(H1H2W1W2),(H3W3)': ['(H1W1),(H2H3W2W3)', '(W1W2),(H1H2H3W3)'],
         '(W1W2),(H1H2H3W3)': ['(H1H2W1W2),(H3W3)', '(W1W2W3),(H1H2H3)'],
         '(W1W2W3),(H1H2H3)': ['(W1W2),(H1H2H3W3)', '(W3),(H1H2H3W1W2)'],
         '(W3),(H1H2H3W1W2)': ['(W1W2W3),(H1H2H3)', '(H3W3),(H1H2W1W2)'],
         '(H3W3),(H1H2W1W2)': ['(W3),(H1H2H3W1W2)', '(),(H1H2H3W1W2W3)'],
         '(),(H1H2H3W1W2W3)': ['(H3W3),(H1H2W1W2)']
         }

print('bfs path')
b = BFS.bfs_path(graph, '(H1H2H3W1W2W3),()', '(),(H1H2H3W1W2W3)')
print(b)
print()
print('Dfs')
DFS.dfs(graph, '(H1H2H3W1W2W3),()')
visited = []
path = []
pa = []
print()
print('dfs path')
DFS.dfs_path(graph, '(H1H2H3W1W2W3),()', '(),(H1H2H3W1W2W3)', visited, path)
print()
print('DLS')
DFS.DLS(graph, '(H1H2H3W1W2W3),()', '(),(H1H2H3W1W2W3)', 0, 12, pa)
print()
print('iterartive dfs')
for i in range(0, 12):
    DFS.DLS(graph, '(H1H2H3W1W2W3),()', '(),(H1H2H3W1W2W3)', 0, i, pa)
print()
print('bidirectional')
r = BFS.BIDIR(graph, '(H1H2H3W1W2W3),()', '(),(H1H2H3W1W2W3)', pa)
print(r)
