import math as m

x1, y1, x2, y2 = input("두 점의 좌표값을 x1, y1, x2, y2 순서대로 입력 : ").split()
x1 = float(x1)
y1 = float(y1)
x2 = float(x2)
y2 = float(y2)
distance = m.sqrt((x1-x2)**2+(y1-y2)**2)
print("distance = %.2f" % distance)
print("두 점 사이의 거리는 5이하 입니까?", distance <= 5)
