defmodule Words do
  @doc """
  Count the number of words in the sentence.

  Words are compared case-insensitively.
  """
  @spec count(String.t) :: map() 
  def count(sentence) do
    sentence |> transform_sentence |> count_words(%{})
  end

  defp transform_sentence(sentence) do
    sentence
    |> String.downcase
    |> String.replace(~r{[!@#$%^&:,]}, "")
    |> String.replace("_", " ")
    |> String.split
  end

  defp count_words([], acc), do: acc

  defp count_words([head | tail], acc) do
    new_acc = Map.update(acc, head, 1, &(&1 + 1))
    count_words(tail, new_acc)
  end
end
