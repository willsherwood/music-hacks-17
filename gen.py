import re
import itertools

global x

def gen():
    global x
#    x = '4gg 4 4g 4> r4 r4 4> 4- r4 r4 r4t3 2{4/- 4/ 4/} 4/ 4/'.split(' ')
    x = '4gg 4 4g 4> r4 r4 4> 4- r4 r4 r4 4/z r4 4/ 4/ 2 2 2 2 2 2 2 2 2 2 2 2 2'.split(' ')

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
        print('t' + str(num), ('2' if num != 5 else '4') + '{', end = ' ')
    for i in range(4 if num == 0 else 6 if num == 3 else num):
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
    print(' 4 4g- r4')

for p in itertools.permutations([0, 3, 5]):
    piece(p)
