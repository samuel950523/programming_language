Names = []
while True:
    name = input("학생 이름을 입력하세요:")
    if name == "":
        break
    Names.append(name)

print("학생 이름:")
for name in Names:
    print(name, end=",")
    