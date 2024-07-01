def reverseString(s: String): String = {
  if (s.isEmpty) "" 
  else reverseString(s.tail) + s.head
}
