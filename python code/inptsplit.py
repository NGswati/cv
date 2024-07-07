c=list(input("Enter: "))
su=0
for i in range(int(len(c)/3)):
    a=max(c)
    
    c.pop(c.index(a))
    b=max(c)
    c.pop(c.index(b))
    c.pop(int(max(c)))
    su+=a+b
print(su)
