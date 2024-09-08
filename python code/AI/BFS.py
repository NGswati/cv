import networkx as nx
def bfs(graph,source):
    visited=[]
    queue=[]
    queue.append(source)
    visited.append(source)
    while len(queue)!=0:
        v=queue.pop(0)
        print(v)
        for i in graph[v]:
            if i not  in visited:
                queue.append(i)
                visited.append(i)

def bfs_path(graph,source,goal):
    def pred(vertex):
        for u,v in nx.bfs_edges(graph,source):
            if v==vertex:
                predecessor=u
                break
        return predecessor
    graph=nx.DiGraph(graph)
    path=[]
    current=goal
    while current!=source:
        path.append(current)
        current=pred(current)
    path.append(source)
    return path[::-1]

def BIDIR(graph, source, goal,pa):
    fvisited=[]
    fqueue=[]
    rvisited=[]
    rqueue=[]
    front=[]
    rear=[]
    fqueue.append(source)
    fvisited.append(source)
    rqueue.append(goal)
    rvisited.append(goal)
    while len(fqueue)!=0 and len(rqueue)!=0:
        v=fqueue.pop(0)
        if v in rvisited:
            print("1")
            print(bfs_path(graph,source,v)+bfs_path(graph,v,goal)[1:])
            break
            return
        front.append(v)
        for i in graph[v]:
            if i not  in fvisited:
                fqueue.append(i)
                fvisited.append(i)
        v=rqueue.pop(0)
        if v in fvisited:
            print(bfs_path(graph,source,v)+bfs_path(graph,v,goal)[1:])
            break
            return
        rear.append(v)
        for i in graph[v]:
            if i not  in rvisited:
                rqueue.append(i)
                rvisited.append(i)