x = '''3 4/4/
t5 4 {3. 4/4/}
t7 4 {3. 3/3/}
t3 2 {3 3/3/}'''.split('\n')

from itertools import permutations as p
from random import choice as choice
t = list(p(x))
print(' '.join(choice(t)))

