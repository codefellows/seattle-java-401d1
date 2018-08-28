merge_sort(arr) {
  if (arr.length == 1) {
    return arr;
  }

  left = first_half(arr)
  right = second_half(arr)

  left = merge_sort(left)
  right = merge_sort(right)

  return zip(left, right)
}
