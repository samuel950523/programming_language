n1, n2 = input("두 자리 정수 두개를 입력 : ").split()

if n1==n2:
    print("두 정수는 모두 %s로 같은 정수입니다."%n1)
elif n1[0]==n2[0] or n1[1]==n2[1]:
    print("%s , %s : 하나의 숫자만 일치합니다."%(n1,n2))
elif n1[0]==n2[1] and n1[1]==n2[0]:
    print("%s , %s : 자리 값만 다른 정수입니다."%(n1,n2))
else:
     print("%s, %s : 일치하지 않는 정수입니다."%(n1,n2))