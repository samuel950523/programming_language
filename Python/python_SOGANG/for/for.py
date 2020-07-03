for i in range(10):
    number = int(input("Enter a number : "))
    if number == 0:
        print("입력 받은 수가 0입니다.\n프로그램을 종료합니다.")
        break
    if number > 0 and number % 2 == 0:
        print("%d : 양수, 짝수" % number)
    if number > 0 and number % 2 == 1:
        print("%d : 양수, 홀수" % number)
    if number < 0 and number % 2 == 0:
        print("%d : 음수, 짝수" % number)
    if number < 0 and number % 2 == 1:
        print("%d : 음수, 홀수" % number)
