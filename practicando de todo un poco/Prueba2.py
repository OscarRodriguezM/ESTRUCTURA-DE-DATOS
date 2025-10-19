# DADA UNA LISTA DE NUMEROS ENTEROS DETERMINA
# SI CONTIENE DUPLICADOS

nums1=[1,2,3,1]
nums2=[1,2,3,4]
nums3=[3,3,3,3]

n1 = len(nums1)
n2 = len(nums2)
n3 = len(nums3)

for i in range(n1-1):
    for j in range(n1-1-i):
        if nums1[j]>nums1[j+1]:
            nums1[j],nums1[j+1]=nums1[j+1],nums1[j]
print("Ordenado 1: ")
for i in range(n1):
    print(nums1[i], end=" ")

for i in range(n1-1):
    if nums1[i]==nums1[i+1]:
        print("EL NUMERO DUPLICADO ES: ",nums1[i])


for i in range(n2-1):
    for j in range(n2-1):
        if nums2[j]>nums2[j+1]:
            nums2[j],nums2[j+1]=nums2[j+1],nums2[j]

print("Ordenado 2: ")
for i in range(n2-1):
    print(nums2[i],end=" ")

for i in range(n2-1):
    if nums2[i]==nums2[i+1]:
        print("EL NUMERO DUPLICADO ES: ",nums2[i])

for i in range(n3-1):
    for j in range(n3-1):
        if nums3[j]>nums3[j+1]:
            nums3[j],nums3[j+1]=nums3[j+1],nums3[j]


print("Ordenado 3: ")
for i in range(n3-1):
    print(nums3[i],end=" ")

for i in range(n3-1):
    if nums3[i]==nums3[i+1]:
        print("EL NUMERO DUPLICADO ES: ",nums3[i])

    