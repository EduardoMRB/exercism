def shout(sentence):
    return sentence.isupper()

def question(sentence):
    return sentence.endswith("?")

def blank(sentence):
    return sentence == ""

def hey(what):
    sentence = what.strip()
    if shout(sentence):
        return "Whoa, chill out!"
    elif question(sentence):
        return "Sure."
    elif blank(sentence):
        return "Fine. Be that way!"
    else:
        return "Whatever."
