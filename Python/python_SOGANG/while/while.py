num_list = []
i = 0
sum = 0
while True:
    number = int(input("정수를 입력 (0을 입력하면 종료) : "))
    if number == 0:
        break
    sum += number
    num_list.append(number)
    i = i+1

print("입력한 정수 리스트 : ", num_list)
print("합계 : %d" % sum)
average = sum/i
print("평균 : %.2f" % average)
