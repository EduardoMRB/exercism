DNA_TO_RNA = {"A":"U", "T":"A", "C":"G", "G":"C"}

def to_rna(dna):
    return reduce(lambda acc, strand: acc + DNA_TO_RNA[strand], dna, "")
