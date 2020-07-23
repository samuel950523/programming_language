def myfunc(mystr):
    mystr2 = mystr.lower()
    mylist1 = []
    mylist2 = []
    for i in range(len(mystr2)):
        if mylist1.count(mystr2[i]) == 0:
            mylist1.append(mystr2[i])
            mylist2.append(mystr.count(mystr2[i]))
    return mylist1, mylist2


mystr = input("문자열 입력 : ")
mylist1 = []
mylist2 = []
mylist1, mylist2 = myfunc(mystr)

for i in range(len(mylist1)):
    if mylist1[i]!= " ":
        print("%c : %d" % (mylist1[i], mylist2[i]))
