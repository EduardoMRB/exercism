defmodule Anagram do
  @doc """
  Returns all candidates that are anagrams of, but not equal to, 'base'.
  """
  @spec match(String.t, [String.t]) :: [String.t]
  def match(base, candidates) do
    candidates |> Enum.filter &(match_word?(base, &1))
  end

  defp match_word?(word, candidate) do
    sorted_candidate = sort_word(candidate)
    sorted_word = sort_word(word)

    sorted_candidate == sorted_word and String.downcase(word) != String.downcase(candidate)
  end

  defp sort_word(word), do: word |> String.downcase |> split_word |> Enum.sort |> Enum.join

  defp split_word(word), do: String.split(word, "", trim: true)
end
