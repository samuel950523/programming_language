num_set = list(map(int, input("정수들을 입력 : ").split()))
plus = 0
minus = 0
sum = 0
if len(num_set) == 0:
    print("입력한 숫자가 없습니다.")

for i in range(len(num_set)):

    print(num_set[i], end=" ")

    sum += num_set[i]
    if num_set[i] > 0:
        plus += 1
    elif num_set[i] < 0:
        minus += 1
    else:
        continue

print("")
print("양수 : %d개, 음수 : %d개, 합계 : %d" % (plus, minus, sum))
