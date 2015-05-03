from re import compile

def shout(sentence):
    letters_pattern = compile("[a-zA-Z]")
    letters = filter(lambda letter: letters_pattern.match(letter), sentence)
    return letters.isupper()

def question(sentence):
    return sentence.strip().endswith("?")

def blank(sentence):
    return sentence.strip() == ""

def hey(what):
    if shout(what):
        return "Whoa, chill out!"
    elif question(what):
        return "Sure."
    elif blank(what):
        return "Fine. Be that way!"
    else:
        return "Whatever."
