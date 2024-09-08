def dfs(graph,source):
    def dfs_visit(graph,source):
        parent={}
        visited.append(source)
        print(source)
        for i in graph[source]:
            if i not in visited:
                parent[i]=source
                dfs_visit(graph,i)
    visited=[]
    for i in graph:
        if i not in visited:
            dfs_visit(graph,i)
visited=[]
path=[]
def dfs_path(graph,source,goal,visited,path):
    visited.append(source)
    path.append(source)
    if source==goal:
        print(path)
        return
    else:
        for g in graph[source]:
            if g not in visited:
                dfs_path(graph,g,goal,visited,path)
                path.pop()
                   
def p(graph,start,goal):
    path=[]
    if start==goal:
        path=[start]
    else:
        visited=[start]
        stack=[start]
        while len(stack)!=0:
            v=stack.pop()
            path.append(v)
            c=0
            for i in graph[v]:
                if i not in visited and len(graph[i])!=1:
                    visited.append(i)
                    stack.append(i)          
    path.append(goal)
    print(path)
def DLS(graph,start,goal,depth,depth_limit,path):
    if depth>depth_limit:
        return None
    if start ==None:
        return None
    path.append(start)
    if start==goal:
        print(path)
    for i in graph[start]:
        DLS(graph,i,goal,depth+1,depth_limit,path)
    path.pop()
    return None

