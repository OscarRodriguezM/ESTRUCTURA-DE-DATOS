# Dado un arreglo (una lista) de números enteros, por ejemplo [2, 7, 11, 15]
# y un número objetivo (un target), por ejemplo 9. Tu tarea es devolver los índices
#  de los dos números en la lista que suman exactamente el target."
# Para nums = [2, 7, 11, 15] y target = 9.
# La respuesta sería [0, 1] porque nums[0] + nums[1] (o sea, 2 + 7) es igual a 9.


# ESTE SERIA EL METODO "FUERZA BRUTA"

nums=[2,7,11,15]
target = 9

for i in range(len(nums)):
    for j in range(i+1, len(nums)):
        if nums[i]+nums[j]==target:
            print([i,j])


# OTRO METODO "EL AJA"

vistos={}
num_actual=2

for i, num_actual in enumerate(nums):
    complemento=target-num_actual
    if complemento in vistos:
        print([vistos[complemento],i])
    vistos[num_actual]=i

