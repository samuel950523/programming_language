number = int(input("구하려는 소수의 개수를 입력 : "))
pn_list = []  # prime number list

for i in range(2, 1001):
    check = True
    for j in range(2, i):
        if i % j == 0:
            check = False
            break
    if check == True:
        pn_list.append(i)
    if len(pn_list) == number:
        for k in range(len(pn_list)):
            print(pn_list[k])
        print("%d개의 소수를 찾았습니다"%number)
        break

