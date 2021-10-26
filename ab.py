import random
print('22332')

for k in range(2):
    if random.randint(0,1):
        print('3 4/4/ 3')
    if random.randint(0,1):
        print('t4 3 { ' + ''.join(['3' if random.randint(0,1) else ('3/' if random.randint(0,1) else 'r3') for i in range(4)]) + '}')
    else:
        print('t5 4 { ' + ''.join(['3' if random.randint(0,1) else ('3/' if random.randint(0,1) else 'r3') for i in range(5)]) + '}')
