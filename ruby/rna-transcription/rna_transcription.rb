class Complement
  RNA_COUNTERPART = {
    "C" => "G",
    "T" => "A",
    "A" => "U",
    "G" => "C"
  }

  DNA_COUNTERPART = {
    "G" => "C",
    "A" => "T",
    "U" => "A",
    "C" => "G"
  }

  def self.of_dna strand
    translate strand, RNA_COUNTERPART
  end

  def self.of_rna strand
    translate strand, DNA_COUNTERPART
  end

  def self.translate strand, dictionary
    strand.split("").map { |s| dictionary[s] or raise ArgumentError }.join
  end
end

