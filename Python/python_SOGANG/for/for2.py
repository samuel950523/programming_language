L = []
for i in range(1, 100):
    if i % 2 == 0:
        L.append(i)
    if i % 8 == 0:
        print(i, end=" ")
