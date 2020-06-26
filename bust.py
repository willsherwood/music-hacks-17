for k in range(5, 100):
    mod = 2 ** k
    s = -mod
    for i in range(mod):
        scale = int(99 / (1 - i/mod)) / 100
        if scale >= 1:
            s += 1
    print(k, s / mod)

