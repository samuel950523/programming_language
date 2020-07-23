# for i in range(100):
#    print(i+1, end=' ')

# for i in range(1, 51):
#    print("%d %d" % (2*i, 2*i-1), end=' ')

# input은 짝수
for i in range(1, int(input())//2+1):
    print("%d %d" % (2*i, 2*i-1), end=' ')
