def insertion_sort(a):
    n=len(a)
    for i in range(1,n):
        j=i
        t=a[i]
        while a[j-1]>t and j>0:
            a[j]=a[j-1]
            j-=1
        a[j]=t

def insertion_sort_reverse(a):
    n=len(a)
    for i in range(1,n):
        j = i
        t=a[i]
        while a[j-1]<t and j>0:
            a[j]=a[j-1]
            j-=1
        a[j]=t    


d=[2,4,5,1,3]
#insertion_sort(d)
insertion_sort_reverse(d)
print(d)
