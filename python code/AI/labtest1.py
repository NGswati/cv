#First Question
# paths=[]
# path = []
# def IDDF(graph, start, goal, depth, depth_limit, path):
#     if depth > depth_limit:
#         return None
#     if start == None:
#         return None
#     path.append(start)
#     if start == goal:
#         # paths[0]=path
#         print(path)
#         return
#     for i in graph[start]:
#         IDDF(graph, i, goal, depth+1, depth_limit, path)

#     path.pop()
#     # for i in range(len(path)-1):
#     #     print(path[i]+"-->"+path[i+1])
#     # print(" ")
#     return None

# m=3
# n=5
# d=6


# graph={
#     '(0,0),(0)': ["(0,5),(5)", "(3,0),(3)", "(3,5),(8)"],
#     '(0,5),(5)': ["(3,5),(8)", "(3,0),(3)", "(0,0),(0)"],
#     '(3,0),(3)': ["(0,5),(5)", "(0,3),(3)", "(3,5),(8)", "(0,0),(0)"],
#     '(3,5),(8)': ["(0,5),(5)", "(0,3),(3)", "(3,0),(3)", "(0,0),(0)"],
#     '(0,3),(3)': ["(0,5),(5)", "(3,0),(3)", "(3,5),(8)", "(0,0),(0)", "(3,3),(6)"]
# }

# IDDF(graph, '(0,0),(0)', '(3,3),(6)', 0, 3, path)
# # for i in range(len(paths[0])-1):
# #         print(paths[0][i]+"-->"+path[1])

# print("Steps for 1st solution: ")
# print('m liter jug:'+"0"+" n liter jug: "+"0"+"  -->"+'  m liter jug:'+"3"+" n liter jug: "+"0")
# print('m liter jug:'+"3"+" n liter jug: "+"0 "+"  -->"+'  m liter jug:'+"0"+" n liter jug: "+"3")
# print('m liter jug:'+"0"+" n liter jug: "+"3" +"  -->"+'  m liter jug:'+"3"+" n liter jug: "+"3")

# print("Steps for 2nd  solution: ")
# print('m liter jug:'+"0"+" n liter jug: "+"0" +"  -->"+'  m liter jug:'+"3"+" n liter jug: "+"0")
# print('m liter jug:'+"3"+" n liter jug: "+"0" +"  -->"+'  m liter jug:'+"3"+" n liter jug: "+"5")
# print('m liter jug:'+"3"+" n liter jug: "+"5 "+"  -->"+'  m liter jug:'+"0"+" n liter jug: "+"3")
# print('m liter jug:'+"0"+" n liter jug: "+"3 "+"  -->"+'  m liter jug:'+"3"+" n liter jug: "+"3")



#Second Question
import numpy as np

m1 = 2
n1 = 3
r1 = 4

t1 = np.random.normal(0, 1, (m1, n1, r1)) #tensor
print(t1)
mean = t1.mean( axis=0)
print("Dimension-wise mean(axix:0):", mean)

mean = t1.mean(axis=1)
print("Dimension-wise mean(axix:1):", mean)
mean = t1.mean(axis=2)
print("Dimension-wise mean (axix:2):", mean)
