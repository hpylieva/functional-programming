object task1{

  def pascal(r: Int, c: Int):Int =
  {
    if(r==c || c==0) 1
    else pascal(find_arg(r), find_arg(c)) + pascal(find_arg(r), c)

  }

  def find_arg(x: Int): Int =
  {
    if (x==0) 0 else x-1
  }

  pascal(4,2)
}