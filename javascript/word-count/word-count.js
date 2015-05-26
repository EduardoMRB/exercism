module.exports = function (phrase) {
  var words = phrase.split(/[\s\n]/);

  return words.reduce(function (count, word) {
    if (count[word]) {
      count[word]++;
    } else {
      count[word] = 1;
    }

    return count;
  }, {});
}
