function areStrandsInvalid(s1, s2) {
  return s1.length !== s2.length;
}

module.exports = {
  compute: function (s1, s2) {
    if (areStrandsInvalid(s1, s2)) {
      throw new Error("DNA strands must be of equal length.");
    }

    var s1 = s1.split(""),
        s2 = s2.split("");

    return s1.filter(function (strand, idx) {
      return strand !== s2[idx];
    }).length;
  }
};
