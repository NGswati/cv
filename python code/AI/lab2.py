# # Ques 1
# import numpy as np
# import time

# P = np.random.rand(10^6, 10^4)
# Q = np.random.rand(10 ^ 6, 10 ^ 4)

# start_time = time.time()
# result = np.zeros((10^6, 10^6))
# for i in range(10^6):
#     for j in range(10^6):
#         for k in range(10^4):
#             result[i][j] += P[i][k] * Q[j][k]
# end_time = time.time()
# t1 = end_time - start_time
# print(result)

# start_time = time.time()
# result = np.matmul(P, Q.T)
# end_time = time.time()
# t2 = end_time - start_time
# print(result)

# speedup = t1 / t2
# print("Speedup:", speedup)

#Ques 2
# import numpy as np
# import math
# vector1 = [1, 2, 3]
# vector2 = [4, 5, 6]
# result = sum([(x - y)**2 for x, y in zip(vector1, vector2)])
# distance=result**(1/2)
# print("distance: ",distance)

# import statistics as s
# xm=s.mean(vector1)
# ym=s.mean(vector2)
# u = sum([(x - xm)*(y-ym) for x, y in zip(vector1, vector2)])
# d1 = sum([(x - xm)**2 for x in vector1])
# d2= sum([(y-ym)**2 for  y in  vector2])
# result=u/((d1*d2)**(1/2))
# print("Pearson correlation coefficient : ", result)


# Ques 3
# import numpy as np
# import math
# u = np.array([2, 1, 2])
# v = np.array([1, 1, 1])
# u_unit = u / (np.dot(u, u))**(1/2)
# v_unit = v / (np.dot(v,v))**(1/2)
# cos_theta = np.dot(u_unit, v_unit)
# theta = math.acos(cos_theta)
# theta_degrees = math.degrees(theta)
# print("The angle between the vectors is: {:.2f} degrees".format(theta_degrees))


#Ques 4
# import numpy as np
# A = np.random.randint(low=-10, high=10, size=(3, 3))
# B = np.random.randint(low=-10, high=10, size=(3, 3))
# A_TB = np.dot(A.T, B)
# eigenvalues_AB = np.linalg.eigvals(np.dot(A, B))
# eigenvalues_BA = np.linalg.eigvals(np.dot(B, A))
# print("A: \n", A)
# print("B: \n", B)
# print("ATransposeB: \n", A_TB)
# print("Eigenvalues of AB: ", eigenvalues_AB)
# print("Eigenvalues of BA: ", eigenvalues_BA)


# Ques 5
# x=[1,2,3]
# y=[4,4,5]
# distance = sum([abs(x - y) for x, y in zip(x,y)])
# print("Manhattan Distance: ", distance)

# def spiral_matrix(matrix):
#     result = []
#     m, n = len(matrix), len(matrix[0])
#     top, bottom, left, right = 0, m-1, 0, n-1
#     while top <= bottom and left <= right:
#         for i in range(left, right+1):
#             result.append(matrix[top][i])
#         top += 1
#         for i in range(top, bottom+1):
#             result.append(matrix[i][right])
#         right -= 1
#         if top <= bottom:
#             for i in range(right, left-1, -1):
#                 result.append(matrix[bottom][i])
#             bottom -= 1
#         if left <= right:
#             for i in range(bottom, top-1, -1):
#                 result.append(matrix[i][left])
#             left += 1
#     return result

# matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
# print(spiral_matrix(matrix))

# Ques 6
# import matplotlib.pyplot as plt
# import numpy as np
# from scipy.stats import norm
# n = 10
# sample_space = np.linspace(-3, 3, n)
# mean = 0
# std = 1
# pdf = norm.pdf(sample_space, mean, std)
# plt.plot(sample_space, pdf)
# plt.xlabel('x')
# plt.ylabel('Probability Density')
# plt.title('Probability Density Function of x')
# plt.show()

# Ques 7
# import numpy as np
# M = np.random.rand(10)
# N = np.mean(M)
# stdD = np.sqrt(np.sum((M - N)**2) / len(M))
# print("Standard Deviation: ", stdD)

#Ques 8
# import numpy as np
# X = np.random.rand(3, 3)
# Y = np.random.rand(3, 1)
# X_inv = np.linalg.inv(X)
# X_invY = np.dot(X_inv, Y)
# print("X^-1Y: \n", X_invY)
# XTX = np.dot(X.T, X)
# print("XTX: \n", XTX)
# XTY = np.dot(X.T, Y)
# print("XTY: \n", XTY)

#Ques 9
# import numpy as np
# random_list = np.random.rand(15)
# mean = sum(random_list) / len(random_list)
# print("Mean: ", mean)
# random_list.sort()
# if len(random_list) % 2 == 0:
#     median = (random_list[int(len(random_list) / 2) - 1] +random_list[int(len(random_list) / 2)]) / 2
# else:
#     median = random_list[int(len(random_list) / 2)]
# print("Median: ", median)
# variance = sum((random_list - mean)**2) / len(random_list)
# print("Variance: ", variance)
# std_dev = variance**(1/2)
# print("Standard deviation: ", std_dev)
# print("Mean (Using Built-in Function): ", np.mean(random_list))
# print("Median (Using Built-in Function): ", np.median(random_list))
# print("Variance (Using Built-in Function): ", np.var(random_list))
# print("Standard deviation (Using Built-in Function): ", np.std(random_list))

#Ques 10
# from math import pow
# def minkowski_distance(X1, Y1, X2, Y2, X3, Y3, p):
#     distance = pow(abs(X1 - Y1)**p + abs(X2 - Y2)**p + abs(X3 - Y3)**p, 1/p)
#     return distance
# P1 = (1, 2)
# P2 = (2, 3)
# P3 = (4, 5)
# p = 1
# print("Minkowski distance for p = 1:", minkowski_distance(P1[0], P2[0], P3[0], P1[1], P2[1], P3[1], p))
# p = 2
# print("Minkowski distance for p = 2:", minkowski_distance(P1[0], P2[0], P3[0], P1[1], P2[1], P3[1], p))
# p = 3
# print("Minkowski distance for p = 3:", minkowski_distance(P1[0], P2[0], P3[0], P1[1], P2[1], P3[1], p))
# p = 4
# print("Minkowski distance for p = 4:", minkowski_distance(P1[0], P2[0], P3[0], P1[1], P2[1], P3[1], p))


#ques 11
# import numpy as np
# def normalizeRows(x):
#     norm = np.linalg.norm(x, axis=1, keepdims=True)
#     x = x / norm
#     return x
# x = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
# print("Original Matrix:\n", x)
# normalized_x = normalizeRows(x)
# print("Normalized Matrix:\n", normalized_x)

#Ques 12
import numpy as np

x1 = np.array([9, 2, 5, 0, 0, 7, 5, 0, 0, 0, 9, 2, 5, 0, 0])
x2 = np.array([9, 2, 2, 9, 0, 9, 2, 5, 0, 0, 9, 2, 5, 0, 0])
dot_product = np.dot(x1, x2)
print("Vectorized dot product:", dot_product)
outer_product = np.outer(x1, x2)
print("Vectorized outer product:\n", outer_product)
elementwise_multiplication = x1 * x2
print("Vectorized elementwise multiplication:\n", elementwise_multiplication)
general_dot_product = np.vdot(x1, x2)
print("Vectorized general dot product:", general_dot_product)
