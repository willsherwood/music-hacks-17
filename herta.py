import random
base_3 = '4;4;3;3'
base_2 = '4;4;3'

def apply(x, suffix):
    x = x.split(';')
    return ';'.join([i+suffix[j] for j,i in enumerate(x)])


def ran_suffs(n):
    out = []
    for i in range(n):
        local = ''
        if random.randint(0,1):
            local += '/'
        if random.randint(0,1):
            local += '>'
        out += [local]
    return out

for k in range(4):
    t = apply(base_3, ran_suffs(4))
    print(' '.join(t.split(';')))

print('4>43/ 44>3/')




