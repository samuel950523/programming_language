import random

def coin_throw (total_trial):
    head=0
    for i in range(1,total_trial+1):
        result = random.randint(0,1)
        if result==0:
            head+=1
        if i<10:
            print("%d 번째까지 던지기에서 앞면이 나온 확룔 : %d%%"%(i, (head/i)*100))    
        if i>=10 and i%10==0:
            print("%d 번째까지 던지기에서 앞면이 나온 확룔 : %d%%"%(i, (head/i)*100))    
    return head

total_trial=int(input("동전 던지기 시도 횟수를 입력(1 - 100) : "))
head = coin_throw(total_trial)
print("************************************")
print("총 %d번 동전 던지기에서 앞면이 나올 확률 : %d%%"%(total_trial,(head/total_trial)*100))