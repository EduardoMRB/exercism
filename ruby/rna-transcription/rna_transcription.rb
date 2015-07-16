class Complement
  DNA_COUNTERPART = {
    "G" => "C",
    "A" => "T",
    "U" => "A",
    "C" => "G"
  }

  def self.of_dna strand
    translate strand, DNA_COUNTERPART.invert
  end

  def self.of_rna strand
    translate strand, DNA_COUNTERPART
  end

  def self.translate strand, dictionary
    strand.chars.map { |s| dictionary.fetch(s) { fail ArgumentError } }.join
  end
end

