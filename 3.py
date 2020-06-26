import re
import itertools
import random

# x_save = '4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 55 55 55 55 55 55 55 55 55 55 55 55 r4 4z 4 4- 4- 4- 4> 4> 4> 4> 4 4 4/ 4/ 4 4 4/ r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4 r4'.split(' ')
x_save = ((('4> ') + '4 ' * 5 + 'r4 ' * 25) * 10).split(' ')
random.shuffle(x_save)


global x

def gen():
    global x
#    x = '4gg 4 4g 4> r4 r4 4> 4- r4 r4 r4t3 2{4/- 4/ 4/} 4/ 4/'.split(' ')
#    x = '4gg 55 4 4- r4 r4 4gg 4 55 4z 4 r4 r4 4/ 4> r4 4/ 4/ 4> r4 r4 4> 4- 4/ 4/ 4/ 4/ 4> 2 2'.split(' ')
#    x = '4 4 4 r4 r4 55 4 4 r4 r4 4 55 4 r4 r4 4 4 55 r4 r4 55 55 4 4 r4 4/ 4/ 4/ 4/ 4/ 4/ 4/ 4/'.split(' ')
#    if random.randint(0, 1) == 0:
#    x = 'r4 4 r4 r4 4 4 4 4- r4 4 4- r4 4 r4 4/ 4 r4 55 4 r4 4 r4 4> r4 r4 4> 4- 4 4 4/ 4/ 4- r4 4/ 4- r4 r4 4>'.split(' ')
    
    x = x_save

    for i, j in enumerate(x):
        if '{' in j:
            j = j[j.index('{') + 1:]
            x[i] = j
        if '}' in j:
            j = j[:j.index('}') + 1]
            x[i] = j
        if 't' in j:
            j = j[:j.index('t')]
            x[i] = j

    x = [i for i in x if i != '.']

def xlet(num):
    global x
    if num > 0:
        print('t' + str(num), ('2' if num == 3 else '4') + '{', end = ' ')

    count = 0
    for i in range(4 if num == 0 else 3 if num == 3 else num):
        if len(x) > 1 and x[0] == x[1] and x[1] == 'r4' and i < num - 1: 
            x = x[1:]
            count += 1
            continue
        elif x[0] == 'r4':
            if count == 0:
                print('r4', end = ' ')
            elif count == 1:
                print('r3', end = ' ')
            elif count == 2:
                print('r3#.#', end = ' ')
            elif count == 3:
                print('2', end = ' ')
            else:
                print('BAD ')
            count = 0
        else:
            print(x[0], end = ' ')
        x = x[1:]
        if i==0: print('[', end = ' ')
    print(']')
    if num > 0:
        print('}', end = ' ')

def piece(perm):
    gen()
    for i in perm:
        xlet(i)
    print(' t3 2{ 4[44>] } r4')
print('T71 61')
for p in itertools.permutations([3, 0, 5, 7]):
    piece(p)
