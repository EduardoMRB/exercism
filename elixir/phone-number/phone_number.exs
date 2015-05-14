defmodule Phone do
  @doc """
  Remove formatting from a phone number.

  Returns "0000000000" if phone number is not valid
  (10 digits or "1" followed by 10 digits)

  ## Examples

  iex> Phone.number("123-456-7890")
  "1234567890"

  iex> Phone.number("+1 (303) 555-1212")
  "3035551212"

  iex> Phone.number("867.5309")
  "0000000000"
  """
  @spec number(String.t) :: String.t
  def number(raw) do
    coll = number_coll(raw)
    cond do
      Enum.count(coll) == 11 and hd(coll) == "1" -> Enum.drop(coll, 1)
      Enum.count(coll) == 10 -> coll
      true -> repeat("0", 10)
    end
      |> to_string
  end

  defp repeat(x, n), do: repeat(x, n, [])
  defp repeat(_, 0, acc), do: acc
  defp repeat(x, n, acc), do: repeat(x, n - 1, [x | acc])

  defp number_coll(raw) do
    raw
    |> split_sentence
    |> Enum.filter(fn(char) -> Regex.match?(~r/\d/, char) end)
  end

  defp split_sentence(sentence) do
    String.split sentence, ""
  end

  @doc """
  Extract the area code from a phone number

  Returns the first three digits from a phone number,
  ignoring long distance indicator

  ## Examples

  iex> Phone.area_code("123-456-7890")
  "123"

  iex> Phone.area_code("+1 (303) 555-1212")
  "303"

  iex> Phone.area_code("867.5309")
  "000"
  """
  @spec area_code(String.t) :: String.t
  def area_code(raw) do
    Enum.take(number_coll(raw), 3) |> to_string
  end

  @doc """
  Pretty print a phone number

  Wraps the area code in parentheses and separates
  exchange and subscriber number with a dash.

  ## Examples

  iex> Phone.pretty("123-456-7890")
  "(123) 456-7890"

  iex> Phone.pretty("+1 (303) 555-1212")
  "(303) 555-1212"

  iex> Phone.pretty("867.5309")
  "(000) 000-0000"
  """
  @spec pretty(String.t) :: String.t
  def pretty(raw) do
    code = area_code(raw)
    {first_part, second_part} = raw
      |> number_coll
      |> Enum.drop(3)
      |> Enum.split(-4)

    "(#{code}) #{first_part}-#{second_part}"
  end
end
