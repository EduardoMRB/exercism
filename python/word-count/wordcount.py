from re import compile

def frequencies(count, item):
    if count.has_key(item):
        count[item] += 1
    else:
        count[item] = 1

    return count

def word_count(sentence):
    words = compile("[\n\s]").split(sentence)
    words = filter(lambda x: x != "", words)
    return reduce(frequencies, words, {})
