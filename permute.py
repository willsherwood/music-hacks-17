x = '''t4 3{3 3/3/3/}
44>3/>
4>4>3/>
443/>
4>43/>
4>4>3/
44>3/
4>43/
443/
t3 2{3/ 3/ 3/}
t5 4{3 3/3/3/3/}
'''.split('\n')

from random import shuffle
shuffle(x)
print(' '.join(x))

