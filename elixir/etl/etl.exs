defmodule ETL do
  @doc """
  Transform an index into an inverted index.

  ## Examples

  iex> ETL.transform(%{"a" => ["ABILITY", "AARDVARK"], "b" => ["BALLAST", "BEAUTY"]})
  %{"ability" => "a", "aardvark" => "a", "ballast" => "b", "beauty" =>"b"}
  """
  @spec transform(Dict.t) :: map()
  def transform(input) do
    input |> Enum.reduce(%{}, fn({score, words}, acc) ->
      Map.merge(acc, word_scores(score, words))
    end)
  end

  defp word_scores(score, words) do
    Enum.reduce(words, %{}, fn(word, scores) ->
      Map.put(scores, String.downcase(word), score)
    end)
  end
end
