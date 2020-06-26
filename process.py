x = ''
while True:
    try:
        x += input() + '\n'
    except:
        break

x = x.replace('4/', '4').replace('r4 [ 4 4 r4 ]', 'r4 4 [3] ').replace('t3 2{ 4- [ r4 r4 ]\n}', '3')
print(x)
