def frequencies(count, item):
    if count.has_key(item):
        count[item] += 1
    else:
        count[item] = 1

    return count

def word_count(sentence):
    words = sentence.split()
    return reduce(frequencies, words, {})
