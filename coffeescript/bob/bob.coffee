isShout = (phrase) ->
  letters = phrase.split("").filter (char) ->
    char.match /[a-zA-Z]/

  return false if letters.length == 0

  letters.every (char) ->
    char.match /[A-Z]/

isQuestion = (phrase) ->
  phrase.indexOf("?", phrase.length - 1) != -1

blankPhrase = (phrase) ->
  phrase == ""

class Bob
  hey: (phrase) ->
    phrase = phrase.replace /\s/g, ""
    if isShout phrase
      "Whoa, chill out!"
    else if isQuestion phrase
      "Sure."
    else if blankPhrase phrase
      "Fine. Be that way!"
    else
      "Whatever."


  module.exports = Bob
