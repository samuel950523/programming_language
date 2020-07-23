i = 0
hap = 0

for i in range(1, 101):
    hap += i

    if hap > 1000:
        break

print("1~100의 합에서 최초로 1000이 넘는 위치 : %d" % i)
