defmodule ListOps do
  # Please don't use any external modules (especially List) in your
  # implementation. The point of this exercise is to create these basic functions
  # yourself.
  # 
  # Note that `++` is a function from an external module (Kernel, which is
  # automatically imported) and so shouldn't be used either.
 
  @spec count(list) :: non_neg_integer
  def count([]), do: 0

  def count([_head | tail]) do
    1 + count(tail)
  end

  @spec reverse(list) :: list
  def reverse(l) do
    do_reverse(l, [])
  end

  defp do_reverse([], acc), do: acc
  defp do_reverse([head | tail], acc), do: do_reverse(tail, [head | acc])

  @spec map(list, (any -> any)) :: list
  def map([], _f), do: []

  def map([head | tail], f), do: [f.(head) | map(tail, f)]

  @spec filter(list, (any -> as_boolean(term))) :: list
  def filter(l, f) do
    do_filter(l, f, [])
  end

  defp do_filter([], _f, acc), do: reverse(acc)
  defp do_filter([head | tail], f, acc) do
    cond do
      f.(head) -> do_filter(tail, f, [head | acc])
      true     -> do_filter(tail, f, acc)
    end
  end

  @type acc :: any
  @spec reduce(list, acc, ((any, acc) -> acc)) :: acc
  def reduce([], acc, _f), do: acc
  def reduce([head | tail], acc, f), do: reduce(tail, f.(head, acc), f)

  @spec append(list, list) :: list
  def append(a, b), do: a ++ b

  # defp do_append([], acc), do: acc
  # defp do_append([head | tail], acc), do: append(tail, [head | acc])

  @spec concat([[any]]) :: [any]
  def concat([]), do: []

  def concat([head | tail]) do
    append(concat(head), concat(tail))
  end

  def concat(head), do: [head]
end
