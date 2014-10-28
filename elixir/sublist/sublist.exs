defmodule Sublist do
  @doc """
  Returns whether the first list is a sublist or a superlist of the second list
  and if not whether it is equal or unequal to the second list.
  """
  def compare([], []), do: :equal

  def compare([], _b), do: :sublist

  def compare(_a, []), do: :superlist

  def compare(a, b) when a == b, do: :equal

  def compare(a, b), do: :unequal
end
