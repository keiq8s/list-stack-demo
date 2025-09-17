from collections import deque

str_1 = "AaBbCcDd"

li_1 = []
li_2 = []

stack_1 = deque()
stack_2 = deque()

for letter in str_1:
    if (letter.isupper()):
        li_1.append(letter)
        stack_1.append(letter)
    else: 
        li_2.append(letter)
        stack_2.append(letter)


print(*li_1, end="\n\n")
print(*li_2, end="\n\n")

while len(stack_1) != 0:
    print(stack_1.pop(), end=" ")
print("\n")

while len(stack_2) != 0:
    print(stack_2.pop(), end=" ")
print("\n")


