def il(num_list):
    num_list.sort()

    print(num_list)


t = input()
n = input()
n = int(n)
num = []
for i in range(n):
    num.append(input())
il(num)
