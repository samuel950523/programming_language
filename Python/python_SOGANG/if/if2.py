n1, n2, n3 = input("수식 입력(예 : 20 * 40) : ").split()
n1 = float(n1)
n3 = float(n3)
if n2 == '+':
    print("%f + %f = %f" % (n1, n3, n1+n3))
elif n2=='-':
    print("%f - %f = %f" % (n1, n3, n1-n3))
elif n2=='*':
    print("%f * %f = %f" % (n1, n3, n1*n3))
elif n2=='/':
    if n3==0:
        print("%f로 나누기를 수행할 수 없습니다."%n3)
    else:
        print("%f / %f = %f"%(n1,n3,n1/n3))
else:
    print("%c는 지원하지 않는 연산자입니다."%n2)