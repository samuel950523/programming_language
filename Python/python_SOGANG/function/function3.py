def plus(a, b):
    print("%f + %f = %f" % (a, b, a+b))


def minus(a, b):
    print("%f - %f = %f" % (a, b, a-b))


def mul(a, b):
    print("%f * %f = %f" % (a, b, a*b))


def div(a, b):
    if b == 0:
        print("%f로 나누기를 수행 할 수 없습니다"%b)
    else:
        print("%f / %f = %f" % (a, b, a/b))


def other(a):
    print(a, "지원하지 않는 연산자입니다")


a, c, b = input("수식 입력(예 : 20 * 40) : ").split()
a = float(a)
b = float(b)
if c == '+':
    plus(a, b)
elif c == '-':
    minus(a, b)
elif c == '*':
    mul(a, b)
elif c == '/':
    div(a, b)
else:
    other(c)
