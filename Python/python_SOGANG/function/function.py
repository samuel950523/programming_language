def password_check(password):
    count = 0
    if len(password)<8:
        print("error! 8 글자 이상이어야 함")
        return False
    if password.isnumeric()==True:
        print("error! 영문도 포함되어야 함")
        return False
    if password.isalpha()==True:
        print("error! 숫자도 포함되어야 함")
        return False
    for i in range(1,len(password)):
        if password[i].isnumeric() == True:
            count+=1
    if count <2:
        print("error! 최소한 2개의 숫자를 포함해야 함")
        return False
    if password.isalnum()==False:
        print("error! 영문자, 숫자로만 구성되어야 함")
        return False

for k in range(1,6):
    password = input("Enter password : ")
    if password_check(password) == False:
        print("Invalid password")
    else :
        print("Valid password")
        break
