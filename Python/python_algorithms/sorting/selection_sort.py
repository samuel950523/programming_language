def selection_sort(a):
    n = len(a)
    for i in range(0, n-1):
        min_idx = i
        for j in range(i+1, n):
            if a[j] < a[min_idx]:
                min_idx = j
        a[i], a[min_idx] = a[min_idx], a[i]

def selection_sort_reverse(a):
    n = len(a)
    for i in range(0, n-1):
        min_idx = i
        for j in range(i+1, n):
            if a[j] > a[min_idx]:
                min_idx = j
        a[i], a[min_idx] = a[min_idx], a[i]

d = [2, 4, 5, 1, 3]
#selection_sort(d)
selection_sort_reverse(d)
print(d)
