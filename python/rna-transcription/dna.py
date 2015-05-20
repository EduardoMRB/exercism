DNA_TO_RNA = {"A":"U", "T":"A", "C":"G", "G":"C"}

def to_rna(dna):
    return "".join(map(lambda strand: DNA_TO_RNA[strand], dna))
