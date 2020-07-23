def add(a, b):
    return a+b


def swap(a, b):
    a, b = b, a
    return a, b


a = int(input("정수 1 입력 : "))
b = int(input("정수 2 입력 : "))
sum = add(a, b)
average = sum/2
print("두 수의 합 : %d" % sum)
print("두 수의 평균 : %d" % average)
a, b = swap(a, b)
print("두 수의 교환 : %d, %d" % (a, b))
