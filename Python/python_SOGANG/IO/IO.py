n1, n2, n3 = input("정수 숫자 3개를 입력 : ").split()
n1 = int(n1)
n2 = int(n2)
n3 = int(n3)
sum=n1+n2+n3
average=sum/3
print("입력 받은 값 : %d %d %d" % (n1, n2, n3))
print("총합 : %d"%sum)
print("평균 : %.1f"%average)
