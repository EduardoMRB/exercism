def distance(strand1, strand2):
    equals = map(lambda n1, n2: n1 == n2, strand1, strand2)
    return len(filter(lambda x: x == False, equals))

