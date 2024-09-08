# # Ques 1
# import pandas as pd
# import numpy as np
# import time
# arr=np.array([[0.81,0.47,0.18,0.02,0.17,0.35,0.19,0.6,0.46,0.25],[0.07,0.62,0.05,0.07,0.06,0.06,0.56,0.48,0.48,0.58],[0.08,0.69,0.75,0.68,0.59,0.77,0.78,0.51,0.14,0.26],[0.17,0.98,0.06,0.57,0.02,0.21,0.09,0.27,0.61,0.63],[0.11,0.03,0.92,0.43,0.57,0.0,0.09,0.5,0.99,0.13],[0.82,0.69,0.96,0.38,0.9,0.58,0.12,0.65,0.4,0.29],[0.92,0.33,0.83,0.66,0.27,0.83,0.92,0.92,0.64,0.66],[0.99,0.21,0.46,0.25,0.02,0.28,0.76,0.32,0.81,0.22],[0.45,0.91,0.9,0.24,0.84,0.47,0.33,0.05,0.69,0.78],[0.29,0.48,0.78,0.83,0.06,0.17,0.38,0.68,0.89,0.71]])

# # """import random as r
# # for i in range(100):
# #     print(r.randint(0,99)/100, end =",")"""

# s_time = time.time()
# for i in range(10):
#     for j in range(10):
#         arr[i][j] += 10
# e_time = time.time()


# arr=np.array([[0.81,0.47,0.18,0.02,0.17,0.35,0.19,0.6,0.46,0.25],[0.07,0.62,0.05,0.07,0.06,0.06,0.56,0.48,0.48,0.58],[0.08,0.69,0.75,0.68,0.59,0.77,0.78,0.51,0.14,0.26],[0.17,0.98,0.06,0.57,0.02,0.21,0.09,0.27,0.61,0.63],[0.11,0.03,0.92,0.43,0.57,0.0,0.09,0.5,0.99,0.13],[0.82,0.69,0.96,0.38,0.9,0.58,0.12,0.65,0.4,0.29],[0.92,0.33,0.83,0.66,0.27,0.83,0.92,0.92,0.64,0.66],[0.99,0.21,0.46,0.25,0.02,0.28,0.76,0.32,0.81,0.22],[0.45,0.91,0.9,0.24,0.84,0.47,0.33,0.05,0.69,0.78],[0.29,0.48,0.78,0.83,0.06,0.17,0.38,0.68,0.89,0.71]])
# start_time = time.time()
# arr = arr + 10
# end_time = time.time()
# print(arr)

# print("For loop approach took: ", e_time - s_time, " seconds")
# print("Vectorized operation approach took: ", end_time - start_time, " seconds")


# # Ques 2

# df = pd.DataFrame(columns=['roll no', 'name', 'subject', 'age', 'marks'])
# df.loc[0] = [1, 'Ana', 'Math', 20, 85]
# df.loc[1] = [2, 'pob', 'Science', 22, 90]
# df.loc[2] = [3, 'mary', 'English', 21, 80]
# df.loc[3] = [4, 'Diya', 'History', 20, 75]
# df.loc[4] = [5, 'rani', 'Geography', 22, 88]
# df.loc[5] = [6, 'binna', 'Computer Science', 21, 92]
# df.loc[6] = [7, 'winter', 'Biology', 20, 80]
# df.loc[7] = [8, 'rahul', 'Physics', 22, 75]
# df.loc[8] = [9, 'king', 'Chemistry', 21, 90]
# df.loc[9] = [10, 'ram', 'Economics', 20, 85]

# min_marks = df['marks'].min()
# print("Minimum marks: ", min_marks)
# max_marks = df['marks'].max()
# print("Maximum marks: ", max_marks)
# mean_marks = df['marks'].mean()
# print("Mean marks: ", mean_marks)
# median_marks = df['marks'].median()
# print("Median marks: ", median_marks)
# std_marks = df['marks'].std()
# print("Standard deviation of marks: ", std_marks)



# # Ques 3
# def sum_numbers(*args):
#     if len(args) == 1 and type(args[0]) == list:
#         args = args[0]
#     return sum(args)

# print(sum_numbers(5, 6, 7, 8, 9)) 
# print(sum_numbers([5, 6, 7, 8, 9]))


# #Ques 4
# s1 = input("Enter string 1: ")
# s2 = input("Enter string 2: ")
# s1 = sorted(s1.strip().lower())
# s2 = sorted(s2.strip().lower())
# if(s1==s2):
#     print("Anagram")
# else:
#     print("Not an anagram")


# #Ques 5
# import random
# L=[0,0,0,0,0,0,0,0,0]
# for i in range(9):
#     L[i]=random.randint(5,9)
# print("List: ",L)

# ld = {}
# for number in L:
#     if number in ld:
#         ld[number] += 1
#     else:
#         ld[number] = 1
# print("frequency :",ld)

# maxf_k=0
# for key in ld.keys():
#     if(ld[key] == max(ld.values())):
#         maxf_k=key
# for i in range(len(L)):
#     if (L[i] == maxf_k):
#         print(i)

    
    
            
# # Ques 6
# import random
# l1=random.sample(range(40,50),10)
# l2 = random.sample(range(41,49),10)
# print(l1)
# print(l1)
# l=[]
# for i in range(len(l1)):
#     if (i % 2 == 0):
#         l.append(l1[i])
#     else:
#         l.append(l2[i])
# print(l)


# # Ques 7
# def find_unique(a):
#     a=set(a.split(","))
#     return a
# a=input("Enter a list with square brackets: ")
# print(a)
# print(find_unique(a))

# # Ques 8
# import numpy as np
# array = np.random.rand(20, 5)
# first_ten_rows = array[:10, :]
# print(first_ten_rows)


# # Ques 9
#string=input("Enter string: ")
# string = "-100#^sdfkj8902w3ir021@swf-20"
# string +="a"
# aa = []
# k = ''
# for i in range(len(string)):
#     if (string[i]=="-"):
#         k='-'
#     elif (string[i].isdigit()):
#         k = k+string[i]
#     else:
#         aa.append(k)
#         k=''
# print(aa)

# positive=0
# negative=0
# for i in aa:
#     if (i!=""):
#         if(int(i) < 0):
#             negative += int(i)
#         positive += abs(int(i))
# print("Positive : ",positive)
# print("Negative : ",negative)


# # Ques10
# a = [5, 16, 62, 23, 7, 12, 18, 3, 1]
# b=a[4:]+a[:4]
# print(b)



# # Ques11
# import numpy

# my_array = numpy.array([[1, 2, 3], [4, 5, 6]])
# print("Transpose: \n", numpy.transpose(my_array),"\n")

# my_array = numpy.array([[1, 2, 3], [4, 5, 6]])
# print("flatten: ", my_array.flatten())

# # Ques12
# sum=0
# dict={'a': 100, 'b':200, 'c':300}
# for i in dict.values():
#     sum=sum+i
    
# print("sum of all items: ",sum)
