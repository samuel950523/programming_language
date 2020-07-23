n1,n2,n3=map(int,input("세 개의 정수를 입력하시오 : ").split())
if n2>n1:
    n1,n2=n2,n1
if n3>n1:
    n1,n3=n3,n1
if n3>n2:
    n2,n3=n3,n2
print("내림차순 정렬 : %d %d %d"%(n1,n2,n3))
