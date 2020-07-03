A=[4,8,2,3,4,2]
B=[7,2,5,2,3,6,5]
C=[]

for i in range(6):
    for j in range(7):
        if A[i]==B[j]:
            C.append(A[i])
remove_dup=list(set(C))
remove_dup.sort()
print(remove_dup)
