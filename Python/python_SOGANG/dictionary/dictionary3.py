fruit={'배':[2,1000],'자몽':[1,2000],'메론':[1,8000],'감':[6,800]}
fruit_want = input("먹고 싶은 과일은? : ")
exist = fruit.get(fruit_want,0)
if exist==0:
    print("%s 준비되어 있지 않습니다"%fruit_want)
else:
    print("%s 맛있게 드세요"%fruit_want)