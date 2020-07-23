a = 0
b = 0
extra = 0

money = int(input("금액을 입력하세요. : "))

a = money//500
b = (money-500*a)//100
extra = money % 100

print("500원짜리 동전 : %d개" % a)
print("100원짜리 동전 : %d개" % b)
print("남은 금액 : %d원" % extra)
