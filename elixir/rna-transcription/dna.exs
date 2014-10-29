defmodule DNA do
  @doc """
  Transcribes a character list representing DNA nucleotides to RNA

  ## Examples

  iex> DNA.to_rna('ACTG')
  'UGAC'
  """
  @spec to_rna([char]) :: [char]
  def transcript(?G), do: 'C'
  def transcript(?C), do: 'G'
  def transcript(?T), do: 'A'
  def transcript(?A), do: 'U'

  def to_rna(char_list) do
    char_list |> Enum.map(&transcript/1) |> List.flatten
  end
end
