from collections import deque

# Реализация списка на языке Python

li = list()

li.append(1)
li.append(2)
li.append(3)

print(li[1]) # должно вывести 2, то есть можно получить доступ не только к последнему элементу в отличие от стэка


# Реализация стека на языке Python

stack = deque()

stack.append(1)
stack.append(2)
stack.append(3)
    

print("Кол-во до удаления: " + len(stack))
print(stack.pop()) # должно вывести 3 а тажке кол-во елементов должно стать равным двум
print("Кол-во после удаления: " + len(stack))
