l = [1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]

elements_count = {}

for element in l:
    if element in elements_count:
        elements_count[element] += 1
    else:
        elements_count[element] = 1

print(elements_count)

