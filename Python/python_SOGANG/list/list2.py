print("***** 5월까지만 입력 *****")
print("***** if 조건문으로 작성 *****")
month_if = int(input("월을 입력하세요 : "))
if(month_if == 1):
    print("%d월은 January입니다." % month_if)
if(month_if == 2):
    print("%d월은 Febuary입니다." % month_if)
if(month_if == 3):
    print("%d월은 March입니다." % month_if)
if(month_if == 4):
    print("%d월은 April입니다." % month_if)
if(month_if == 5):
    print("%d월은 May입니다." % month_if)

print("***** 리스트로 작성 *****")
month_list = ['January', 'Febuary', 'March', 'April', 'May']
month_input = int(input("월을 입력하세요 : "))
print("%d월은 %s입니다." % (month_input, month_list[month_input-1]))
