def quick_sort(a):
    n = len(a)
    if n <= 1:
        return a
    pivot = a[n//2]
    less, equal, greater = [], [], []
    for i in range(0, n):
        if i < pivot:
            less.append(i)
        elif i > pivot:
            greater.append(i)
        else:
            equal.append(i)
    return quick_sort(less)+equal+quick_sort(greater)


d = [2, 4, 5, 1, 3]
quick_sort(d)
print(d)
